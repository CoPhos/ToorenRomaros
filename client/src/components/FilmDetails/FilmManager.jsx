import React, { Fragment } from 'react'
import { useParams } from 'react-router-dom'
import axios from '../../utils/constants'
import { useQueryClient } from 'react-query'

import FilmDetailsContainer from './FilmDetailsContainer'
import FilmMainInfoContainer from './FilmMainInfoContainer'
import { useQuery } from 'react-query'

function FilmManager() {
    const params = useParams()
      const queryClient = useQueryClient()
    const FILM_URL = '/films'

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
            //console.log(data?.data)
        },
        onError: (error) => {
            console.log(error)
        },
    })
    const getProfileImageFromStaffByFilmId = useQuery(
        ['getProfileImageFromStaffByFilmId'],
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

    const getStreamSitesFromFilm = useQuery({
        queryKey: ['getStreamSitesFromFilm'],
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
         ['getImageFromStreamsiteByFilmId'],
         async () => {
             if (!getStreamSitesFromFilm.data) {
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

    if (
        getFilm.isLoading ||
        getRatingFromFilm.isLoading ||
        getProfileImageFromStaffByFilmId.isLoading ||
        getAllGenresFromFilm.isLoading ||
        getStreamSitesFromFilm.isLoading ||
        getRatingFromFilm.isLoading
    ) {
        return <p></p>
    }

    return getFilm.error ||
        getRatingFromFilm.error ||
        getProfileImageFromStaffByFilmId.error ||
        getAllGenresFromFilm.error ||
        getStreamSitesFromFilm.error ||
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
                staff={getProfileImageFromStaffByFilmId.data}
                genre={getAllGenresFromFilm.data.data.response}
                streamSites={getImageFromStreamsiteByFilmId.data}
            ></FilmDetailsContainer>
        </Fragment>
    )
}

export default FilmManager
