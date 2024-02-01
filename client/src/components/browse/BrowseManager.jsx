import React, { useState, useEffect } from 'react'
import { useSearchParams, useNavigate, useLocation } from 'react-router-dom'
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
    const genre = searchParams.getAll('genre') || []
    const rating = searchParams.getAll('rating') || []
    const streaming = searchParams.getAll('streaming') || []

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
        console.log(checkedCheckboxes)
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
