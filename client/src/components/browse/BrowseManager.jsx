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

    const handleCheckboxChange = (event, key) => {
        const checkboxValue = event.target.value
        const currentValues = searchParams.getAll('genre')
        console.log(currentValues)
        if (event.target.checked) {
            currentValues.push(checkboxValue)
        } else {
            const index = currentValues.indexOf(checkboxValue)
            if (index !== -1) {
                currentValues.splice(index, 1)
            }
        }
        //dont update searchparams every time a checkbox is clicked maybe just create a new url a use it in generateUrl
        setSearchParams({ 'genre': currentValues })
    }

    function generateUrl(index, value) {
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
                updatedParams
                break
        }

        const url = Object.entries(updatedParams)
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
            generateUrl={generateUrl}
            at={at}
            filmType={filmType}
            sortBy={sortBy}
            genre={genre}
        ></BrowseContainer>
    )
}

export default BrowseManager
