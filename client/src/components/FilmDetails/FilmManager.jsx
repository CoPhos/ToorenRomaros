import React, { Fragment } from 'react'
import { useParams } from 'react-router-dom'
import axios from '../../utils/constants'
import { useQueryClient } from 'react-query'

import FilmDetailsContainer from './FilmDetailsContainer'
import FilmMainInfoContainer from './FilmMainInfoContainer'
import ReviewContainer from '../review/ReviewContainer'
import { useQuery } from 'react-query'

function FilmManager() {
    const params = useParams()
    const queryClient = useQueryClient()
    const FILM_URL = '/films' 

    const getFilm = useQuery({
        queryKey: ['getFilmById', params.uuid],
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
        queryKey: ['getAllStaffFromFilm', params.uuid],
        queryFn: async () => {
            try {
                return axios.get(FILM_URL + `/${params.uuid}/staffs`)
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
    const getProfileImageFromStaffByFilmId = useQuery(
        ['getProfileImageFromStaffByFilmId', params.uuid],
        async () => {
            if (!getAllStaffFromFilm.data) {
                return []
            }
            try {
                const imageResponses = await axios.get(
                    FILM_URL +
                        `/${params.uuid}/staffs/media/images?imageType=STAFF_PROFILE`
                )
                const staffWithImages =
                    getAllStaffFromFilm.data.data.response.map((item) => {
                        const correspondingImageKey = Object.keys(
                            imageResponses.data
                        ).find(
                            (key) =>
                                imageResponses.data[key].owner === item.staffId
                        )

                        return correspondingImageKey
                            ? {
                                  ...item,
                                  images: imageResponses.data[
                                      correspondingImageKey
                                  ],
                              }
                            : item
                    })
                queryClient.setQueryData(['getAllStaffFromFilm'], {
                    data: { response: staffWithImages },
                })
                console.log(staffWithImages)
                return staffWithImages
            } catch (error) {
                return error
            }
        },
        { enabled: !!getAllStaffFromFilm.data },
        {
            onError: (error) => {
                console.log(error)
            },
        }
    )
    const getAllGenresFromFilm = useQuery({
        queryKey: ['getAllGenresFromFilm', params.uuid],
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
        queryKey: ['getRatingFromFilm', params.uuid],
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
    const getStreamSitesFromFilm = useQuery({
        queryKey: ['getStreamSitesFromFilm', params.uuid],
        queryFn: async () => {
            try {
                return axios.get(
                    FILM_URL + `/${params.uuid}` + '/streamingsites'
                )
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
    const getImageFromStreamsiteByFilmId = useQuery(
        ['getImageFromStreamsiteByFilmId', params.uuid],
        async () => {
            if (
                !getStreamSitesFromFilm.data ||
                !getStreamSitesFromFilm.data.data.response.length > 0
            ) {
                return []
            }
            try {
                const imageResponses = await axios.get(
                    FILM_URL +
                        `/${params.uuid}/streamsites/media/images?imageType=STREAMSITE_MAIN`
                )
                const streamsiteWithImages =
                    getStreamSitesFromFilm.data.data.response.map((item) => {
                        const correspondingImageKey = Object.keys(
                            imageResponses.data
                        ).find(
                            (key) =>
                                imageResponses.data[key].owner ===
                                item.streamsiteId
                        )

                        return correspondingImageKey
                            ? {
                                  ...item,
                                  images: imageResponses.data[
                                      correspondingImageKey
                                  ],
                              }
                            : item
                    })
                queryClient.setQueryData(['getStreamSitesFromFilm'], {
                    data: { response: streamsiteWithImages },
                })
                return streamsiteWithImages
            } catch (error) {
                return error
            }
        },
        { enabled: !!getStreamSitesFromFilm.data },
        {
            onError: (error) => {
                console.log(error)
            },
        }
    )

    const isLoading =
        getFilm.isLoading ||
        getRatingFromFilm.isLoading ||
        getProfileImageFromStaffByFilmId.isLoading ||
        getAllGenresFromFilm.isLoading ||
        getStreamSitesFromFilm.isLoading ||
        getImageFromStreamsiteByFilmId.isLoading
        

    const hasError =
        getFilm.error ||
        getRatingFromFilm.error ||
        getProfileImageFromStaffByFilmId.error ||
        getAllGenresFromFilm.error ||
        getStreamSitesFromFilm.error ||
        getImageFromStreamsiteByFilmId.error
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

   const filmData = getFilm.data?.data?.response
   const ratingData = getRatingFromFilm.data?.data?.response
   const staffData = getProfileImageFromStaffByFilmId.data
   const genreData = getAllGenresFromFilm.data?.data?.response
   const streamSitesData = getImageFromStreamsiteByFilmId.data
   
   return (
       <Fragment>
           {filmData && ratingData && (
               <FilmMainInfoContainer
                   data={filmData}
                   ratings={ratingData}
               ></FilmMainInfoContainer>
           )}
           {filmData && staffData && genreData && streamSitesData && (
               <FilmDetailsContainer
                   data={filmData}
                   staff={staffData}
                   genre={genreData}
                   streamSites={streamSitesData}
               ></FilmDetailsContainer>
           )}
           {ratingData && filmData && (
               <ReviewContainer
                   rating={ratingData}
                   filmData={filmData}
               ></ReviewContainer>
           )}
       </Fragment>
   )
}

export default FilmManager
