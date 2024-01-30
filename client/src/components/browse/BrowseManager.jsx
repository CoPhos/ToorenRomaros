import React, { useState, useEffect } from 'react'
import { useSearchParams, useNavigate, useLocation } from 'react-router-dom'
import BrowseContainer from './BrowseContainer'

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
    const location = useLocation()
    const navigate = useNavigate()
    const [searchParams, setSearchParams] = useSearchParams()

    const [selectedAt, setselectedAt] = useState(
        searchParams.get('at') || 'theaters'
    )
    const [selectedFilmType, setselectedFilmType] = useState(
        searchParams.get('filmType') || 'all'
    )
    const [selectedSortBy, setselectedSortBy] = useState(
        searchParams.get('sortBy') || ''
    )
    const [selectedGenre, setselectedGenre] = useState(
        searchParams.get('genre') || []
    )
    const [selectedRating, setselectedRating] = useState(
        searchParams.get('rating') || []
    )
    const [selectedStreaming, setselectedStreaming] = useState(
        searchParams.get('streaming') || []
    )

    const handleButtonChangeAt = (e, value) => {
        e.preventDefault()
        setselectedAt(value)
        setSearchParams({ at: value })
        const url = `
            ?at=${value}
            ${selectedSortBy ? `&sortBy=${selectedSortBy}` : ''}
            ${selectedFilmType ? `&filmType=${selectedFilmType}` : ''}
            ${selectedGenre > 0 ? `&genre=${selectedGenre.join(',')}` : ''}
            ${selectedRating > 0 ? `&rating=${selectedRating.join(',')}` : ''}
            ${
                selectedStreaming > 0
                    ? `&streaming=${selectedStreaming.join(',')}`
                    : ''
            }`
        console.log(url.replaceAll(/\s/g, ''))
        navigate(url.replaceAll(/\s/g,''))
    }
    const handleRadioChangeFilmType = (value) => {
        setselectedFilmType(value)
        handleSearchChange('filmType', value)
    }
    const handleRadioChangeSortBy = (value) => {
        setselectedSortBy(value)
        handleSearchChange('sortBy', value)
    }

    const handleGenreChange = (value) => {
        setselectedGenre((prevState) => {
            if (prevState.includes(value)) {
                return prevState.filter((i) => i !== value)
            } else {
                return [...prevState, value]
            }
        })
        handleSearchChange('genre', selectedGenre.join(','))
    }

    const handleRatingChange = (value) => {
        setselectedRating((prevState) => {
            if (prevState.includes(value)) {
                return prevState.filter((i) => i !== value)
            } else {
                return [...prevState, value]
            }
        })
        handleSearchChange('rating', selectedRating.join(','))
    }

    const handleStreamingChange = (value) => {
        setselectedStreaming((prevState) => {
            if (prevState.includes(value)) {
                return prevState.filter((i) => i !== value)
            } else {
                return [...prevState, value]
            }
        })
        handleSearchChange('streaming', selectedStreaming.join(','))
    }

    const handleSubmit = (event) => {
        event.preventDefault()
        //document.getElementById('myForm').submit()
    }

    const handleResetClick = (event, group) => {
        event.preventDefault()
        setCheckedCheckboxes((prevCheckboxState) => ({
            ...prevCheckboxState,
            [group]: {},
        }))
    }

    const handleSearchChange = (param, value) => {
        setSearchParams((prevSearchParams) => {
            const updatedSearchParams = new URLSearchParams(prevSearchParams)
            updatedSearchParams.set(param, value)
            return updatedSearchParams
        })
    }

    useEffect(() => {}, [
        selectedAt,
        selectedFilmType,
        selectedSortBy,
        selectedGenre,
        selectedRating,
        selectedStreaming,
        navigate,
        setSearchParams,
    ])

    return (
        <BrowseContainer
            handleSubmit={handleSubmit}
            handleResetClick={handleResetClick}
            selectedAt={selectedAt}
            handleButtonChangeAt={handleButtonChangeAt}
            handleRadioChangeFilmType={handleRadioChangeFilmType}
            selectedFilmType={selectedFilmType}
            handleRadioChangeSortBy={handleRadioChangeSortBy}
            selectedSortBy={selectedSortBy}
            handleGenreChange={handleGenreChange}
            selectedGenre={selectedGenre}
            handleRatingChange={handleRatingChange}
            selectedRating={selectedRating}
            handleStreamingChange={handleStreamingChange}
            selectedStreaming={selectedStreaming}
        ></BrowseContainer>
    )
}

export default BrowseManager
