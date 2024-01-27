import React, { useState, useEffect, Fragment} from 'react'
import useAxiosPrivate from '../hooks/useAxiosPrivate'
import axios from '../../utils/constants'
import useAuth from '../hooks/useAuth'
import { useNavigate } from 'react-router-dom'
import { useParams } from 'react-router-dom'
import { useMutation, useQuery, useQueryClient } from 'react-query'

import ProfileContainer from './ProfileContainer'

function ProfileManager() {
    const queryClient = useQueryClient()
    const LOGOUT_URL = '/auth/token'
    const axiosPrivate = useAxiosPrivate()
    const { logout, auth } = useAuth()
    const navigate = useNavigate()
    const params = useParams()
    

    const mutation = useMutation(
        async () => {
            return axios.delete(
                `${LOGOUT_URL}?refreshToken=${encodeURIComponent(
                    auth.refreshToken
                )}`,
                {
                    headers: {
                        'Content-Type': 'application/json',
                    },
                    withCredentials: true,
                }
            )
        },
        {
            onSuccess: (data) => {
                navigate('/', { replace: true })
                logout()
            },
            onError: (error) => {
                console.log(error)
            },
        }
    )

    function handleLogout(e) {
        e.preventDefault()
        mutation.mutate()
    }

    const getWatchListByUser = useQuery({
        queryKey: ['getWatchListByUser', params.uuid],
        queryFn: async () => {
            try {
                return axiosPrivate.get(`users/${params.uuid}/watchLists`)
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

    const getFilmsFromWatchlist = useQuery(
        ['getFilmsFromWatchlist'],
        
        async () => {
            if (
                !getWatchListByUser.data ||
                !getWatchListByUser.data.data.content.length > 0
            ) {
                return []
            }

            try {
                const filmresponse = await Promise.all(
                    getWatchListByUser.data.data.content.map(async (item) => {
                        const response = await axios.get(`/films/${item.film}`)
                        return { id: item.id, films: response.data }
                    })
                )

                const updatedFilms = getWatchListByUser.data.data.content.map(
                    (item) => {
                        const correspondingFilm = filmresponse.find(
                            (film) => film.films.response.id === item.film
                        )
                        return correspondingFilm
                            ? {
                                  ...item,
                                  filmDetails: correspondingFilm.films.response,
                              }
                            : item
                    }
                )
                return updatedFilms
            } catch (error) {
                return error
            }
        },
        {
            enabled: !!getWatchListByUser.data,
            onSuccess: (data) => {
                console.log("refecthed")
                queryClient.setQueryData(['getWatchListByUser', params.uuid], {
                    data: { content: data },
                })
            },
            onError: (error) => {
                console.log(error)
            },
        },
    )

    const getAllImagesFromWatchlist = useQuery(
        ['getAllImagesFromWatchlist', params.uuid],
        async () => {
            if (
                !getWatchListByUser.data ||
                !getWatchListByUser.data.data.content.length > 0
            ) {
                return []
            }

            try {
                const imageResponses = await Promise.all(
                    getWatchListByUser.data.data.content.map(async (item) => {
                        const response = await axios.get(
                            `${item.film}/media/images?imageType=FILM_MAIN`
                        )
                        return { id: item.id, images: response.data }
                    })
                )

                const updatedcontent = getWatchListByUser.data.data.content.map(
                    (item) => {
                        const correspondingImage = imageResponses.find(
                            (image) => image.images[0].owner === item.film
                        )
                        return correspondingImage
                            ? { ...item, images: correspondingImage.images }
                            : item
                    }
                )
                return updatedcontent
            } catch (error) {
                return error
            }
        },
        {
            enabled: !!getFilmsFromWatchlist.data,
            onSuccess: (data) => {
                console.log('refecthed')
                queryClient.setQueryData(['getWatchListByUser', params.uuid], {
                    data: { content: data },
                })
            },
            onError: (error) => {
                console.log(error)
            },
        }
    )

    const isLoading =
        getWatchListByUser.isLoading ||
        getFilmsFromWatchlist.isLoading ||
        getAllImagesFromWatchlist.isLoading 

    const hasError =
        getWatchListByUser.error ||
        getFilmsFromWatchlist.error ||
        getAllImagesFromWatchlist.error
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

    const watchlistdata = getWatchListByUser.data?.data?.content

    return (
        <Fragment>
            {watchlistdata && (
                <ProfileContainer
                    handleLogout={handleLogout}
                    watchlistdata={watchlistdata}
                ></ProfileContainer>
            )}
        </Fragment>
    )
}

export default ProfileManager

    //   const getReviewsByUser = useQuery({
    //       queryKey: ['getReviewsByUser',params.uuid],
    //       queryFn: async () => {
    //           try {
    //               return axios.get(`users/${params.uuid}/watchLists`)
    //           } catch (error) {
    //               return error
    //           }
    //       },
    //       onSuccess: (data) => {
    //           console.log(data?.data)
    //       },
    //       onError: (error) => {
    //           console.log(error)
    //       },
    //   })
