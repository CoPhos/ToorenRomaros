import React, { Fragment } from 'react'
import { useParams } from 'react-router-dom'
import axios from '../../utils/constants'

import FilmDetailsContainer from './FilmDetailsContainer'
import FilmMainInfoContainer from './FilmMainInfoContainer'
import { useQuery } from 'react-query'

function FilmManager() {
    const params = useParams()
    console.log(params.uuid)
    const FILM_URL = '/films'
    //movie critic consensus
    //total super and user ratings
    //ratings score

    const getFilm = useQuery({
        queryKey: ['getFilmById'],
        queryFn: async () => {
            try {
                return axios.get(FILM_URL + `/${params.uuid}`)
            } catch (error) {
                return error
            }
        },
        onSuccess: (data) => {
           // console.log(data?.data)
        },
        onError: (error) => {
            console.log(error)
        },
    })
    const getAllStaffFromFilm = useQuery({
        queryKey: ['getAllStaffFromFilm'],
        queryFn: async () => {
            try {
                return axios.get(FILM_URL + `/${params.uuid}/staffs`)
            } catch (error) {
                return error
            }
        },
        onSuccess: (data) => {
           // console.log(data?.data)
        },
        onError: (error) => {
            console.log(error)
        },
    })
    const getProfileImageFromStaffByFilmId = useQuery(
        {
            queryKey: ['getProfileImageFromStaffByFilmId'],
            queryFn: async () => {
                try {
                    return axios.get(
                        FILM_URL +
                            `/${params.uuid}/staffs/media/images?imageType=STAFF_PROFILE`
                    )
                } catch (error) {
                    return error
                }
            },
            onSuccess: (data) => {
              //  console.log(data?.data)
            },
            onError: (error) => {
                console.log(error)
            },
        },
    )

    const getAllGenresFromFilm = useQuery({
        queryKey: ['getAllGenresFromFilm'],
        queryFn: async () => {
            try {
                return axios.get(FILM_URL + `/${params.uuid}/genres`)
            } catch (error) {
                return error
            }
        },
        onSuccess: (data) => {
            //console.log(data?.data)
        },
        onError: (error) => {
            console.log(error)
        },
    })

    const getRatingFromFilm = useQuery({
        queryKey: ['getRatingByFilmIdAndRatingType'],
        queryFn: async () => {
            try {
                return axios.get(FILM_URL + `/${params.uuid}` + '/ratings')
            } catch (error) {
                return error
            }
        },
        onSuccess: (data) => {
           //console.log(data?.data)
        },
        onError: (error) => {
            console.log(error)
        },
    })

    if (
        getFilm.isLoading ||
        getRatingFromFilm.isLoading ||
        getProfileImageFromStaffByFilmId.isLoading ||
        getAllGenresFromFilm.isLoading ||
        getRatingFromFilm.isLoading
    ) {
        return <p></p>
    }

    return getFilm.error ||
        getRatingFromFilm.error ||
        getProfileImageFromStaffByFilmId.error ||
        getAllGenresFromFilm.error ||
        getRatingFromFilm.error ? (
        <div>
            <p>
                Oops! Something went wrong while fetching the data.
                <br></br>
            </p>
        </div>
    ) : (
        <Fragment>
            <FilmMainInfoContainer
                data={getFilm.data.data.response}
                ratings={getRatingFromFilm.data.data.response}
            ></FilmMainInfoContainer>
            <FilmDetailsContainer
                data={getFilm.data.data.response}
                staff={getAllStaffFromFilm.data.data.response}
                genre={getAllGenresFromFilm.data.data.response}
                staffImages={
                    getProfileImageFromStaffByFilmId.data.data
                }
            ></FilmDetailsContainer>
        </Fragment>
    )
}

export default FilmManager
