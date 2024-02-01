import React, { useState, useEffect } from 'react'
import { useSearchParams, useNavigate, useLocation } from 'react-router-dom'
import { useInfiniteQuery } from 'react-query'
import BrowseContainer from './BrowseContainer'
import constants from '../../utils/constants'

function BrowseManager({}) {
    const pageSize = 10
    const defaultParams = {
        at: 'theaters',
        filmType: 'all',
        sortBy: '',
        genre: [],
        rating: [],
        streaming: [],
    }
    const FILM_URL = '/films'
    const [searchParams, setSearchParams] = useSearchParams()

    const at = searchParams.get('at') || 'theaters'
    const filmType = searchParams.get('filmType') || 'all'
    const sortBy = searchParams.get('sortBy') || ''
    const genre = searchParams.get('genre') || []
    const rating = searchParams.get('rating') || []
    const streaming = searchParams.get('streaming') || []

    const [checkedCheckboxes, setCheckedCheckboxes] = useState({
        genre: [],
        rating: [],
        streaming: [],
    })
    const handleCheckboxChange = (event, group) => {
        const checkboxValue = event.target.value

        setCheckedCheckboxes((prevCheckboxState) => {
            const currentGroupState = prevCheckboxState[group] || []

            if (currentGroupState.includes(checkboxValue)) {
                return {
                    ...prevCheckboxState,
                    [group]: currentGroupState.filter(
                        (item) => item !== checkboxValue
                    ),
                }
            } else {
                return {
                    ...prevCheckboxState,
                    [group]: [...currentGroupState, checkboxValue],
                }
            }
        })
    }
    const resetCheckboxGroup = (event, group) => {
        setCheckedCheckboxes((prevCheckboxState) => ({
            ...prevCheckboxState,
            [group]: [],
        }))
    }
    function generateUrl(index, value, filmType) {
        const existingParams = Object.fromEntries(
            new URLSearchParams(window.location.search).entries()
        )
        const updatedParams = { ...defaultParams, ...existingParams }
        switch (index) {
            case 'at':
                updatedParams.at = value
                break
            case 'sortBy':
                updatedParams.sortBy = value
                break
            case 'filmType':
                updatedParams.filmType = value
                break
            case 'genre':
                updatedParams.genre = value
                break
            case 'rating':
                updatedParams.rating = value
                break
            case 'streaming':
                updatedParams.streaming = value
                break
            default:
                updatedParams.at = value
                updatedParams.sortBy = ''
                updatedParams.filmType = filmType
                updatedParams.genre = []
                updatedParams.rating = []
                updatedParams.streaming = []
                break
        }

        const url = Object.entries(updatedParams)
            .filter(
                ([key, val]) =>
                    val !== undefined &&
                    val !== null &&
                    val !== '' &&
                    val.length > 0
            )
            .map(([key, val]) =>
                Array.isArray(val)
                    ? `&${key}=${val.join(',')}`
                    : `&${key}=${val}`
            )
            .join('')

        return url.replace(/^\s*&/, '')
    }

    const a = `?streamId=Netflix,Amazon Prime Video
    &genres=Romance
    &suitableFor=PG-13,G
    &filmType=1
    &atTheaters=1
    &atStreaming=1
    &commingSoonStreaming=1
    &commingSoonTheaters=1
    &orderBy=average_super_rating-desc
    &page=0
    &size=10`
    // const getContentBySearchParams = useInfiniteQuery({
    //     queryKey: [
    //         'getContentBySearchParams',
    //         searchParams.get('at') || 'theaters',
    //         searchParams.get('filmType') || 'all',
    //         searchParams.get('sortBy') || '',
    //         searchParams.get('genre') || [],
    //         searchParams.get('rating') || [],
    //         searchParams.get('streaming') || [],
    //     ],
    //     queryFn: async ({ pageParam = 0 }) => {
    //         try {
    //             let query = FILM_URL + '?'
    //             if (searchParams.get('at')) {
    //                 if (searchParams.get('at') == 'theaters') {
    //                     query.concat(`atTheaters=1`)
    //                 } else if (searchParams.get('at') == 'home') {
    //                     query.concat(`atStreaming=1`)
    //                 } else if (searchParams.get('at') == 'upcoming') {
    //                     query.concat(
    //                         `commingSoonStreaming=1&commingSoonTheaters=1`
    //                     )
    //                 } else if (searchParams.get('at') == 'tv') {
    //                     query.concat(`atStreaming=1&filmType=2`)
    //                 }
    //             }
    //             if (searchParams.get('filmType')) {
    //                 if (searchParams.get('filmType') == '1') {
    //                     query.concat(`&filmType=1`)
    //                 } else if (searchParams.get('filmType') == '2') {
    //                     query.concat(`&filmType=2`)
    //                 }
    //             }
    //             if (
    //                 searchParams.get('genre') &&
    //                 searchParams.get('genre').length > 0
    //             ) {
    //                 query.concat(`&genres=`)
    //                 searchParams.get('genre').map((item, index) => {
    //                     if (index == searchParams.get('genre').length) {
    //                         query.concat(`${item}`)
    //                     } else {
    //                         query.concat(`${item},`)
    //                     }
    //                 })
    //             }
    //             if (
    //                 searchParams.get('rating') &&
    //                 searchParams.get('rating').length > 0
    //             ) {
    //                 query.concat(`&suitableFor=`)
    //                 searchParams.get('rating').map((item, index) => {
    //                     if (index == searchParams.get('rating').length) {
    //                         query.concat(`${item}`)
    //                     } else {
    //                         query.concat(`${item},`)
    //                     }
    //                 })
    //             }
    //             if (
    //                 searchParams.get('streaming') &&
    //                 searchParams.get('streaming').length > 0
    //             ) {
    //                 query.concat(`&streamId=`)
    //                 searchParams.get('streaming').map((item, index) => {
    //                     if (index == searchParams.get('streaming').length) {
    //                         query.concat(`${item}`)
    //                     } else {
    //                         query.concat(`${item},`)
    //                     }
    //                 })
    //             }
    //             if (searchParams.get('sortBy')) {
    //                 query.concat(`&orderBy=${searchParams.get('sortBy')}`)
    //             }
    //             console.log(query)
    //             return axios.get(query)
    //         } catch (error) {
    //             return error
    //         }
    //     },

    //     getNextPageParam: (lastPage, pages) => {
    //         const hasNextPage =
    //             parseInt(lastPage.data.response.number, 10) + 1 <
    //             parseInt(lastPage.data.response.totalPages, 10)

    //         return hasNextPage
    //             ? parseInt(lastPage.data.response.number, 10) + 1
    //             : null
    //     },
    //     onSuccess: (data) => {
    //         //console.log(data)
    //     },
    //     onError: (error) => {
    //         console.log(error)
    //     },
    // })

    useEffect(() => {
        let query = FILM_URL + '?'
        if (searchParams.get('at')) {
            if (searchParams.get('at') == 'theaters') {
                query = query + `atTheaters=1`
            } else if (searchParams.get('at') == 'home') {
                query = query +`atStreaming=1`
            } else if (searchParams.get('at') == 'upcoming') {
                query = query + `commingSoonStreaming=1&commingSoonTheaters=1`
            } else if (searchParams.get('at') == 'tv') {
                query = query +`atStreaming=1&filmType=2`
            }
        }
        if (searchParams.get('filmType')) {
            if (searchParams.get('filmType') == '1') {
                query = query +`&filmType=1`
            } else if (searchParams.get('filmType') == '2') {
                query = query +`&filmType=2`
            }
        }
        if (searchParams.get('genre') && searchParams.get('genre').length > 0) {
            query = query +`&genres=`
            checkedCheckboxes['genre'].map((item, index) => {
                if (index == checkedCheckboxes['genre'].length - 1) {
                    query = query +`${item}`
                } else {
                    query = query +`${item},`
                }
            })
        }
        if (
            searchParams.get('rating') &&
            searchParams.get('rating').length > 0
        ) {
            query = query +`&suitableFor=`
            checkedCheckboxes['rating'].map((item, index) => {
                if (index == checkedCheckboxes['rating'].length - 1) {
                    query = query +`${item}`
                } else {
                    query = query +`${item},`
                }
            })
        }
        if (
            searchParams.get('streaming') &&
            searchParams.get('streaming').length > 0
        ) {
            query = query + `&streamId=`
            checkedCheckboxes['streaming'].map((item, index) => {
                if (index == checkedCheckboxes['streaming'].length - 1) {
                    query = query + `${item}`
                } else {
                    query = query + `${item},`
                }
            })
        }
        if (searchParams.get('sortBy')) {
            query = query +`&orderBy=${searchParams.get('sortBy')}`
        }
        //when clicking a checkbox the compoenent re prints the query which i think it should be like that
        // it has to be after apply button click and not checkbox click. gotta change checkboxes dependecy for something else or idk 
        console.log(query)
    }, [at, filmType, sortBy, genre, rating, streaming])

    return (
        <BrowseContainer
            handleCheckboxChange={handleCheckboxChange}
            checkedCheckboxes={checkedCheckboxes}
            resetCheckboxGroup={resetCheckboxGroup}
            generateUrl={generateUrl}
            at={at}
            filmType={filmType}
            sortBy={sortBy}
            genre={genre}
            rating={rating}
            streaming={streaming}
        ></BrowseContainer>
    )
}

export default BrowseManager
