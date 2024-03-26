import React, { useState, useEffect, useContext } from 'react'
import { useSearchParams } from 'react-router-dom'
import { useInfiniteQuery, useMutation } from 'react-query'
import axios from '../../utils/constants'
import BrowseContainer from './BrowseContainer'
import { LoginPopUpContext } from '../context/LoginPopUpProvider'
import useAuth from '../hooks/useAuth'
import useAxiosPrivate from '../hooks/useAxiosPrivate'

function BrowseManager({}) {
    const { auth, isAuthenticated } = useAuth()
    const { setisPopupOpen } = useContext(LoginPopUpContext)
    const axiosPrivate = useAxiosPrivate()
    function appendQueryParam(query, key, value) {
        if (value) {
            query += `&${key}=${value}`
        }
        return query
    }
    function appendArrayQueryParam(query, key, array) {
        if (array && array.length > 0) {
            query += `&${key}=`
            query += array.join(',')
        }
        return query
    }

    const pageSize = 12
    const defaultParams = {
        at: 'theaters',
        filmType: 'all',
        sortBy: '',
        genre: [],
        rating: [],
        streaming: [],
    }
    const FILM_URL = '/films'
    const WATCH_LIST_URL = '/watchLists'
    const [searchParams, setSearchParams] = useSearchParams()

    const at = searchParams.get('at') || 'theaters'
    const filmType = searchParams.get('filmType') || 'all'
    const sortBy = searchParams.get('sortBy') || ''
    const genre = searchParams.get('genre') || ''
    const rating = searchParams.get('rating') || ''
    const streaming = searchParams.get('streaming') || ''

    const [checkedCheckboxes, setCheckedCheckboxes] = useState({
        genre: genre ? genre.split(',') : [],
        rating: rating ? rating.split(',') : [],
        streaming: streaming ? streaming.split(',') : [],
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
    const getContentBySearchParams = useInfiniteQuery({
        queryKey: [
            'getContentBySearchParams',
            at,
            filmType,
            sortBy,
            genre,
            rating,
            streaming,
        ],
        queryFn: async ({ pageParam = 0 }) => {
            try {
                let query = FILM_URL + '?'
                query = appendQueryParam(
                    query,
                    'atTheaters',
                    searchParams.get('at') === 'theaters' ? 1 : null
                )
                query = appendQueryParam(
                    query,
                    'atStreaming',
                    searchParams.get('at') === 'home' ? 1 : null
                )
                query = appendQueryParam(
                    query,
                    'commingSoonStreaming',
                    searchParams.get('at') === 'upcoming' ? 1 : null
                )
                query = appendQueryParam(
                    query,
                    'commingSoonTheaters',
                    searchParams.get('at') === 'upcoming' ? 1 : null
                )
                query = appendQueryParam(
                    query,
                    'filmType',
                    searchParams.get('filmType') === '1' ? 1 : null
                )
                query = appendQueryParam(
                    query,
                    'filmType',
                    searchParams.get('filmType') === '2' ? 2 : null
                )
                query = appendArrayQueryParam(query, 'genres', genre.split(','))
                query = appendArrayQueryParam(
                    query,
                    'suitableFor',
                    rating.split(',')
                )
                query = appendArrayQueryParam(
                    query,
                    'streamId',
                    streaming.split(',')
                )
                query = appendQueryParam(
                    query,
                    'orderBy',
                    searchParams.get('sortBy')
                )
                query = appendQueryParam(query, 'size', pageSize)
                query = appendQueryParam(query, 'page', pageParam)
                return axios.get(query)
            } catch (error) {
                return error
            }
        },
        getNextPageParam: (lastPage, pages) => {
            const hasNextPage =
                parseInt(lastPage.data.currentPage, 12) + 1 <
                parseInt(lastPage.data.totalPages, 12)

            return hasNextPage
                ? parseInt(lastPage.data.currentPage, 12) + 1
                : null
        },
        onSuccess: (data) => {
        },
        onError: (error) => {
        },
    })
    const postWatchListItem = useMutation({
        mutationKey: ['postWatchListItem'],
        mutationFn: async (formData) => {
            try {
                return axiosPrivate.post(WATCH_LIST_URL, formData, {
                    headers: {
                        'Content-Type': 'application/json',
                    },
                })
            } catch (error) {
                return error
            }
        },

        onSuccess: (data) => {
    
        },
        onError: (error) => {
         
        },
    })

    function handleAddWatchList(e, filmId) {
        e.preventDefault()
        if (!isAuthenticated) {
            setisPopupOpen(true)
        } else {
            postWatchListItem.mutate(
                JSON.stringify({
                    film: filmId,
                    user: auth.id,
                })
            )
        }
    }

    useEffect(() => {
        setCheckedCheckboxes({
            genre: genre ? genre.split(',') : [],
            rating: rating ? rating.split(',') : [],
            streaming: streaming ? streaming.split(',') : [],
        })
        getContentBySearchParams.refetch()
    }, [searchParams])

    const isLoading = getContentBySearchParams.isLoading

    const hasError = getContentBySearchParams.error

    if (isLoading) {
        return <p>Loading...</p>
    }

    if (hasError) {
        return (
            <div>
                <p>
                    Oops! Something went wrong while fetching the data.
                    <br />
                </p>
            </div>
        )
    }

    const filmData = getContentBySearchParams.data?.pages
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
            filmData={filmData}
            fetchNextPage={getContentBySearchParams.fetchNextPage}
            isFetchingNextPage={getContentBySearchParams.isFetchingNextPage}
            hasNextPage={getContentBySearchParams.hasNextPage}
            handleAddWatchList={handleAddWatchList}
        ></BrowseContainer>
    )
}

export default BrowseManager
