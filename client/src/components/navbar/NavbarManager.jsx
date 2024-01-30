import React, { Fragment } from 'react'
import useAuth from '../hooks/useAuth'
import { useQuery } from 'react-query'
import axios from '../../utils/constants'
import NavbarContainer from './NavbarContainer.jsx'

function NavbarManager() {
    const { auth } = useAuth()
    const FILM_URL = '/films'

    const moviesExplore = {
        0: { tittle: 'Movies Home', to: '/browse?at=home&filmType=1' },
        1: {
            tittle: 'Coming Soon to Theaters',
            to: '/browse?at=upcoming&filmType=1',
        },
        2: {
            tittle: 'Best Movies of All Time',
            to: '/browse?at=home&filmType=1&sortBy=averageSuperRating-Desc',
        },
        3: {
            tittle: 'Best Movies on Netflix',
            to: '/browse?at=home&Streaming=[netflix]&filmType=1',
        },
        4: { tittle: 'Best Movies on Hulu', to: '/browse?at=home&Streaming=[hulu]&filmType=1' },
        5: { tittle: 'Best Movies on HBO Max', to: '/browse?at=home&Streaming=[hbo]&filmType=1' },
        6: { tittle: 'Best Movies on Amazon Prime Video', to: '/browse?at=home&Streaming=[amazon]&filmType=1' },
        7: { tittle: 'Best Movies on Apple TV+', to: '/browse?at=home&Streaming=[apple]&filmType=1' },
        8: { tittle: 'Best Movies on Disney+', to: '/browse?at=home&Streaming=[disney]&filmType=1' },
    }

    const tvExplore = {
        0: { tittle: 'TV Home', to: '/browse?at=home&filmType=2' },
        1: {
            tittle: 'Best TV Shows of All Time',
            to: '/browse?at=home&filmType=2&sortBy=averageSuperRating-Desc',
        },
        2: {
            tittle: 'Netflix: New & Upcoming',
            to: '/browse?at=home&Streaming=[netflix]filmType=2&sortBy=addedDate-Desc',
        },
        3: {
            tittle: 'Hulu: New & Upcoming',
            to: '/browse?at=home&Streaming=[hulu]filmType=2&sortBy=addedDate-Desc',
        },
        4: {
            tittle: 'Amazon Prime Video: New & Upcoming',
            to: '/browse?at=home&Streaming=[amazon]filmType=2&sortBy=addedDate-Desc',
        },
        5: {
            tittle: 'Disney+: New & Upcoming',
            to: '/browse?at=home&Streaming=[disney]filmType=2&sortBy=addedDate-Desc',
        },
        6: {
            tittle: 'Apple TV+: New & Upcoming',
            to: '/browse?at=home&Streaming=[apple]filmType=2&sortBy=addedDate-Desc',
        },
        7: {
            tittle: 'HBO Max: New & Upcoming',
            to: '/browse?at=home&Streaming=[hbo]filmType=2&sortBy=addedDate-Desc',
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
            console.log(data?.data)
        },
        onError: (error) => {
            console.log(error)
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
            console.log(data?.data)
        },
        onError: (error) => {
            console.log(error)
        },
    })

    return (
        <Fragment>
            <NavbarContainer
                user={auth?.user}
                moviesExplore={moviesExplore}
                tvExplore={tvExplore}
                moviesQuery={getNewMovies}
                tvQuery={getNewTv}
            ></NavbarContainer>
        </Fragment>
    )
}

export default NavbarManager
