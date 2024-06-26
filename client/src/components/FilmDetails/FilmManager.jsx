import React, { Fragment } from 'react'
import { useParams } from 'react-router-dom'
import axios from '../../utils/constants'
import { useQueryClient, useQuery } from 'react-query'
import ErrorBoundary from '../../utils/ErrorBoundary'
import useAuth from '../hooks/useAuth'
import FilmDetailsContainer from './FilmDetailsContainer'
import FilmMainInfoContainer from './FilmMainInfoContainer'
import ReviewContainer from '../review/ReviewContainer'

function FilmManager() {
    const { auth } = useAuth()
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
           
        },
        onError: (error) => {
           
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
            
        },
        onError: (error) => {
           
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
                return staffWithImages
            } catch (error) {
                return error
            }
        },
        {
            enabled: !!getAllStaffFromFilm.data,
            onError: (error) => {
               
            },
            onSuccess: (data) => {
            },
        },
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
           
        },
        onError: (error) => {
           
        },
    })
    const getCommonRatingFromFilm = useQuery({
        queryKey: ['getCommonRatingFromFilm', params.uuid],
        queryFn: async () => {
            try {
                return axios.get(
                    FILM_URL + `/${params.uuid}` + '/comments/ratings'
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
    const getSuperRatingFromFilm = useQuery({
        queryKey: ['getSuperRatingFromFilm', params.uuid],
        queryFn: async () => {
            try {
                return axios.get(
                    FILM_URL + `/${params.uuid}` + '/posts/ratings'
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
           
        },
        onError: (error) => {
         
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
               
            },
        }
    )
    const getSuperReviews = useQuery({
        queryKey: ['getSuperReviews', params.uuid],
        queryFn: async () => {
            try {
                return axios.get(FILM_URL + `/${params.uuid}/posts/reviews?size=8`)
            } catch (error) {
                return error
            }
        },
        onSuccess: (data) => {
          
        },
        onError: (error) => {
          
        },
    })
    const getCommonReviews = useQuery({
        queryKey: ['getCommonReviews', params.uuid],
        queryFn: async () => {
            try {
                const query = auth.id
                    ? FILM_URL +
                      `/${params.uuid}/comments?size=8&userId=${auth.id}`
                    : FILM_URL + `/${params.uuid}/comments?size=8`
                return axios.get(query)
            } catch (error) {
                return error
            }
        },
        onSuccess: (data) => {
        },
        onError: (error) => {
           
        },
    })

    const isLoading =
        getFilm.isLoading ||
        getCommonRatingFromFilm.isLoading ||
        getSuperReviews.isLoading ||
        getCommonReviews.isLoading ||
        getProfileImageFromStaffByFilmId.isLoading ||
        getSuperRatingFromFilm.isLoading ||
        getAllGenresFromFilm.isLoading ||
        getStreamSitesFromFilm.isLoading ||
        getImageFromStreamsiteByFilmId.isLoading
        

    const hasError =
        getFilm.error ||
        getCommonRatingFromFilm.error ||
        getProfileImageFromStaffByFilmId.error ||
        getSuperReviews.error ||
        getCommonReviews.error ||
        getSuperRatingFromFilm.error ||
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
   const commonRatingData = getCommonRatingFromFilm.data?.data?.response
   const superRatingData = getSuperRatingFromFilm.data?.data?.response
   const staffData = getProfileImageFromStaffByFilmId.data
   const genreData = getAllGenresFromFilm.data?.data?.response
   const streamSitesData = getImageFromStreamsiteByFilmId.data
   const reviewsData = getSuperReviews.data?.data?.response?.content
   const commentsData = getCommonReviews.data?.data?.response?.content

   return (
       <ErrorBoundary>
           <div className="min-h-[500px]">
               {filmData && commonRatingData && superRatingData && (
                   <FilmMainInfoContainer
                       data={filmData}
                       commonRatings={commonRatingData}
                       superRatings={superRatingData}
                   ></FilmMainInfoContainer>
               )}
           </div>

           <div className="min-h-[700px]">
               {filmData && staffData && genreData && streamSitesData && (
                   <FilmDetailsContainer
                       data={filmData}
                       staff={staffData}
                       genre={genreData}
                       streamSites={streamSitesData}
                   ></FilmDetailsContainer>
               )}
           </div>
           <div className="min-h-[1000px]">
               {reviewsData &&
                   commentsData &&
                   commonRatingData &&
                   superRatingData &&
                   filmData && (
                       <ReviewContainer
                           commonRatings={commonRatingData}
                           superRatings={superRatingData}
                           filmData={filmData}
                           reviews={reviewsData}
                           uuid={params.uuid}
                           comments={commentsData}
                       ></ReviewContainer>
                   )}
           </div>
       </ErrorBoundary>
   )
}

export default FilmManager
