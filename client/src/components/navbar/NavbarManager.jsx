import React, { Fragment, useState, useRef, useEffect } from 'react'
import useAuth from '../hooks/useAuth'
import { useQuery } from 'react-query'
import axios from '../../utils/constants'
import { useDebounce } from 'use-debounce'
import { jwtDecode } from 'jwt-decode'

import NavbarContainer from './NavbarContainer.jsx'

function NavbarManager({ onlyLogo }) {
    const { auth, login } = useAuth()
    const FILM_URL = '/films'
    const [searchQuery, setSearchQuery] = useState('')
    const [isDivVisible, setDivVisibility] = useState(false)
    const inputRef = useRef(null)
    const divRef = useRef(null)

    const [debouncedSearchQuery] = useDebounce(searchQuery, 800)

    function handleOnChange(event) {
        setSearchQuery(event.target.value)
    }
    function getDecodedCookie(cookieName) {
        const cookies = document.cookie
            .split(';')
            .map((cookie) => cookie.trim())

        for (const cookie of cookies) {
            const [name, value] = cookie.split('=')

            if (name === cookieName) {
                const decodedValue = decodeURIComponent(
                    value.replace(/\+/g, ' ')
                )
                return decodedValue
            }
        }

        return undefined
    }

    useEffect(() => {
        const id = getDecodedCookie('id')
        const user = getDecodedCookie('name')
        const accessToken = getDecodedCookie('accessToken')
        const refreshToken = getDecodedCookie('refreshToken')
        const email = getDecodedCookie('email')
        if (id && user && accessToken && accessToken && refreshToken && email) {
            const roles = jwtDecode(accessToken).roles || []
            login(id, user, roles, accessToken, refreshToken, email)
        }
    }, [])

    const moviesExplore = {
        0: { tittle: 'Movies Home', to: '/browse?at=home&filmType=1' },
        1: {
            tittle: 'Coming Soon to Theaters',
            to: '/browse?at=upcoming&filmType=1',
        },
        2: {
            tittle: 'Best Movies of All Time',
            to: '/browse?at=home&filmType=1&sortBy=average_super_rating-Desc',
        },
        3: {
            tittle: 'Best Movies on Netflix',
            to: '/browse?at=home&streaming=Netflix&filmType=1',
        },
        4: {
            tittle: 'Best Movies on Hulu',
            to: '/browse?at=home&streaming=Hulu&filmType=1',
        },
        5: {
            tittle: 'Best Movies on HBO Max',
            to: '/browse?at=home&streaming=HBO Max&filmType=1',
        },
        6: {
            tittle: 'Best Movies on Amazon Prime Video',
            to: '/browse?at=home&streaming=Amazon Prime Video&filmType=1',
        },
        7: {
            tittle: 'Best Movies on Apple TV+',
            to: '/browse?at=home&streaming=Apple TV Plus&filmType=1',
        },
        8: {
            tittle: 'Best Movies on Disney+',
            to: '/browse?at=home&streaming=Disney Plus&filmType=1',
        },
    }

    const tvExplore = {
        0: { tittle: 'TV Home', to: '/browse?at=home&filmType=2' },
        1: {
            tittle: 'Best TV Shows of All Time',
            to: '/browse?at=home&filmType=2&sortBy=average_super_rating-Desc',
        },
        2: {
            tittle: 'Netflix: New & Upcoming',
            to: '/browse?at=home&streaming=Netflix&filmType=2&sortBy=added_date-Desc',
        },
        3: {
            tittle: 'Hulu: New & Upcoming',
            to: '/browse?at=home&streaming=Hulu&filmType=2&sortBy=added_date-Desc',
        },
        4: {
            tittle: 'Amazon Prime Video: New & Upcoming',
            to: '/browse?at=home&streaming=Amazon Prime Video&filmType=2&sortBy=added_date-Desc',
        },
        5: {
            tittle: 'Disney+: New & Upcoming',
            to: '/browse?at=home&streaming=Disney%2B&filmType=2&sortBy=added_date-Desc',
        },
        6: {
            tittle: 'Apple TV+: New & Upcoming',
            to: '/browse?at=home&streaming=Apple TV%2B&filmType=2&sortBy=added_date-Desc',
        },
        7: {
            tittle: 'HBO Max: New & Upcoming',
            to: '/browse?at=home&streaming=HBO Max&filmType=2&sortBy=added_date-Desc',
        },
    }

    const getNewMovies = useQuery({
        queryKey: ['getNewMovies'],
        queryFn: async () => {
            try {
                return axios.get(
                    FILM_URL +
                        '?atTheaters=1&orderBy=added_date-asc&page=0&size=9'
                )
            } catch (error) {
                return error
            }
        },
        onSuccess: (data) => {
          
        },
        onError: (error) => {
        
        },
    })

    const getNewTv = useQuery({
        queryKey: ['getNewTv'],
        queryFn: async () => {
            try {
                return axios.get(
                    FILM_URL +
                        '?filmType=2&atStreaming=1&orderBy=added_date-asc&page=0&size=9'
                )
            } catch (error) {
                return error
            }
        },
        onSuccess: (data) => {
           
        },
        onError: (error) => {
        
        },
    })

    const getFilmsBySearchQuery = useQuery({
        queryKey: ['getFilmsBySearchQuery', debouncedSearchQuery],
        queryFn: async () => {
            if (debouncedSearchQuery.trim() === '') {
                return []
            }
            try {
                return axios.get(FILM_URL + '?search=' + debouncedSearchQuery)
            } catch (error) {
                return error
            }
        },
        onSuccess: (data) => {
           
        },
        onError: (error) => {
         
        },
    })

    const getPostBySearchQuery = useQuery({
        queryKey: ['getPostBySearchQuery', debouncedSearchQuery],
        queryFn: async () => {
            if (debouncedSearchQuery.trim() === '') {
                return []
            }
            try {
                return axios.get('/posts' + '?search=' + debouncedSearchQuery)
            } catch (error) {
                return error
            }
        },
        onSuccess: (data) => {
          
        },
        onError: (error) => {
          
        },
    })

    return (
        <Fragment>
            <NavbarContainer
                user={auth?.user}
                roles={auth?.roles}
                image={auth?.imageurl}
                moviesExplore={moviesExplore}
                tvExplore={tvExplore}
                moviesQuery={getNewMovies}
                tvQuery={getNewTv}
                searchQuery={searchQuery}
                handleOnChange={handleOnChange}
                getFilmsBySearchQuery={getFilmsBySearchQuery}
                getPostBySearchQuery={getPostBySearchQuery}
                isDivVisible={isDivVisible}
                setDivVisibility={setDivVisibility}
                inputRef={inputRef}
                divRef={divRef}
                setSearchQuery={setSearchQuery}
                onlyLogo={onlyLogo}
            ></NavbarContainer>
        </Fragment>
    )
}

export default NavbarManager
