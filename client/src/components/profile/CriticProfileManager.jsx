import React, { useState, useEffect, Fragment, useContext } from 'react'
import useAxiosPrivate from '../hooks/useAxiosPrivate'
import axios from '../../utils/constants'
import useAuth from '../hooks/useAuth'
import { useNavigate } from 'react-router-dom'
import { useMutation, useQueryClient, useInfiniteQuery } from 'react-query'
import ErrorBoundary from '../../utils/ErrorBoundary'
import { ActionNotificationContext } from '../context/ActionNotificationProvider'

import CriticProfileContainer from '../profile/CriticProfileContainer'

function CriticProfileManager() {
    const queryClient = useQueryClient()
    const LOGOUT_URL = '/auth/token'
    const axiosPrivate = useAxiosPrivate()
    const { logout, auth } = useAuth()
    const navigate = useNavigate()
    const pageSize = 10
    const { setnotificationText, settype, setisNotificationPopupOpen } =
        useContext(ActionNotificationContext)

    function handleLogout(e) {
        e.preventDefault()
        mutation.mutate()
    }

    function handleRemoveFromWatchList(e, id) {
        e.preventDefault()
        removeFromWatchList.mutate(id)
    }

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
               
            },
        }
    )

    const removeFromWatchList = useMutation(
        async (id) => {
            const previousData = queryClient.getQueryData([
                'getWatchListByUser',
                auth.id,
            ])
            queryClient.setQueryData(['getWatchListByUser', auth.id], (old) => {
                const updatedData = old.pages.map((page) => ({
                    ...page,
                    data: {
                        response: {
                            content: page.data.response.content.filter(
                                (item) => item.film !== id
                            ),
                        },
                    },
                }))
                return {
                    ...old,
                    pages: updatedData,
                }
            })
            try {
                return axiosPrivate.delete(
                    `/watchLists/users/${auth.id}?filmId=${id}`,
                    {}
                )
            } catch (error) {
                queryClient.setQueryData(
                    ['getWatchListByUser', auth.id],
                    previousData
                )
                return error
            }
        },
        {
            onSuccess: (data) => {
                  setnotificationText('Removed From Watchlist Successfully.')
                  settype('success')
                  setisNotificationPopupOpen(true)
            },
            onError: (error) => {
               settype('error')
               setnotificationText(
                   error?.response?.data?.message || 'No server response'
               )
               setisNotificationPopupOpen(true)
            },
        }
    )
    const getWatchListByUser = useInfiniteQuery({
        queryKey: ['getWatchListByUser', auth.id],
        queryFn: async ({ pageParam = 0 }) => {
            try {
                return axiosPrivate.get(
                    `users/${auth.id}/watchLists?pageSize=${pageSize}&page=${pageParam}`
                )
            } catch (error) {
                return error
            }
        },
        getNextPageParam: (lastPage, pages) => {
            const hasNextPage =
                parseInt(lastPage?.data?.response?.number, 10) + 1 <
                parseInt(lastPage?.data?.response?.totalPages, 10)

            return hasNextPage
                ? parseInt(lastPage?.data?.response?.number, 10) + 1
                : null
        },
        onSuccess: (data) => {
         
        },
        onError: (error) => {
           
        },
    })

    const getLatestMoviesReviews = useInfiniteQuery({
        queryKey: ['getLatestMoviesReviews', auth.id],
        queryFn: async ({ pageParam = 0 }) => {
            try {
                return axiosPrivate.get(
                    `users/${auth.id}/posts?filmType=1&pageSize=${pageSize}&page=${pageParam}`
                )
            } catch (error) {
                return error
            }
        },
        getNextPageParam: (lastPage, pages) => {
            const hasNextPage =
                parseInt(lastPage?.data?.response?.number, 10) + 1 <
                parseInt(lastPage?.data?.response?.totalPages, 10)

            return hasNextPage
                ? parseInt(lastPage?.data?.response?.number, 10) + 1
                : null
        },
        onSuccess: (data) => {
        
        },
        onError: (error) => {
          
        },
    })

    const getLatestSeriesReviews = useInfiniteQuery({
        queryKey: ['getLatestSeriesReviews', auth.id],
        queryFn: async ({ pageParam = 0 }) => {
            try {
                return axiosPrivate.get(
                    `users/${auth.id}/posts?filmType=2&pageSize=${pageSize}&page=${pageParam}`
                )
            } catch (error) {
                return error
            }
        },
        getNextPageParam: (lastPage, pages) => {
            const hasNextPage =
                parseInt(lastPage?.data?.response?.number, 10) + 1 <
                parseInt(lastPage?.data?.response?.totalPages, 10)

            return hasNextPage
                ? parseInt(lastPage?.data?.response?.number, 10) + 1
                : null
        },
        onSuccess: (data) => {
          
        },
        onError: (error) => {
         
        },
    })

     const getLatestDrafts = useInfiniteQuery({
         queryKey: ['getLatestDrafts', auth.id],
         queryFn: async ({ pageParam = 0 }) => {
             try {
                 return axiosPrivate.get(
                     `users/${auth.id}/posts/drafts?pageSize=${pageSize}&page=${pageParam}`
                 )
             } catch (error) {
                 return error
             }
         },
         getNextPageParam: (lastPage, pages) => {
             const hasNextPage =
                 parseInt(lastPage?.data?.response?.number, 10) + 1 <
                 parseInt(lastPage?.data?.response?.totalPages, 10)

             return hasNextPage
                 ? parseInt(lastPage?.data?.response?.number, 10) + 1
                 : null
         },
         onSuccess: (data) => {
           
         },
         onError: (error) => {
            
         },
     })

    const isLoading = getWatchListByUser.isLoading ||
    getLatestMoviesReviews.isLoading ||
    getLatestSeriesReviews.isLoading ||
     getLatestDrafts.isLoading

    const hasError =
        getWatchListByUser.error ||
        getLatestMoviesReviews.error ||
        getLatestSeriesReviews.error ||
        getLatestDrafts.error

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

    const watchlistdata = getWatchListByUser.data?.pages
    const moviesReviewsData = getLatestMoviesReviews.data?.pages
    const seriesReviewsData = getLatestSeriesReviews.data?.pages
    const draftsData = getLatestDrafts.data?.pages

    return (
        <ErrorBoundary>
            {watchlistdata && moviesReviewsData && seriesReviewsData && (
                <CriticProfileContainer
                    handleLogout={handleLogout}
                    watchlistdata={watchlistdata}
                    moviesReviewsData={moviesReviewsData}
                    seriesReviewsData={seriesReviewsData}
                    draftsData={draftsData}
                    getWatchListByUser={getWatchListByUser}
                    getLatestMoviesReviews={getLatestMoviesReviews}
                    getLatestSeriesReviews={getLatestSeriesReviews}
                    getLatestDrafts={getLatestDrafts}
                    handleRemoveFromWatchList={handleRemoveFromWatchList}
                ></CriticProfileContainer>
            )}
        </ErrorBoundary>
    )
}

export default CriticProfileManager
