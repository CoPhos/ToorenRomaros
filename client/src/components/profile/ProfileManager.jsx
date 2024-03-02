import React, { useState, useEffect, Fragment, useContext } from 'react'
import useAxiosPrivate from '../hooks/useAxiosPrivate'
import axios from '../../utils/constants'
import useAuth from '../hooks/useAuth'
import { useNavigate } from 'react-router-dom'
import { useMutation, useQueryClient, useInfiniteQuery } from 'react-query'
import { ActionNotificationContext } from '../context/ActionNotificationProvider'
import ErrorBoundary from '../../utils/ErrorBoundary'
import ProfileContainer from './ProfileContainer'

function ProfileManager() {
    const queryClient = useQueryClient()
    const LOGOUT_URL = '/auth/token'
    const axiosPrivate = useAxiosPrivate()
    const { logout, auth } = useAuth()
    const navigate = useNavigate()
    const pageSize = 10

    const {
        setnotificationText,
        settype,
        setisNotificationPopupOpen,
    } = useContext(ActionNotificationContext)


    const [commentId, setcommentId] = useState(null)
    const [hoveredIndex, setHoveredIndex] = useState(null)
    const [formData, setFormData] = useState({})
    const [isChecked, setIsChecked] = useState(false)
    const [fomrError, setfomrError] = useState(false)
    const [isPopupOpen, setPopupOpen] = useState(false)
    const [currentIndex, setcurrentIndex] = useState(null)

    const updateOptimisticComment = (
        previousData,
        commentId,
        updatedCommentData
    ) => {
        const updatedData = previousData.pages.map((page) => ({
            ...page,
            data: {
                response: {
                    content: page.data.response.content.map((comment) =>
                        comment.id === commentId
                            ? { ...comment, ...updatedCommentData }
                            : comment
                    ),
                },
            },
        }))

        return {
            ...previousData,
            pages: updatedData,
        }
    }
    const closePopup = () => {
        setPopupOpen(false)
    }
    const handleCheckboxChange = () => {
        setIsChecked((prevChecked) => !prevChecked)
    }
    function handleOnClick(e, index) {
        e.preventDefault()
        setcurrentIndex(index)
        const data = JSON.stringify({
            publicationDateTime: new Date(),
            rating: (index + 1) * 10,
        })
        updateComment.mutate(data)
    }
    const openPopup = () => {
        setPopupOpen(true)
    }
    const handleChange = (e) => {
        const { name, value } = e.target
        setFormData((prevData) => ({
            ...prevData,
            [name]: value,
        }))
    }
    const handleSubmit = (e) => {
        e.preventDefault()
        if (formData.text.length <= 5000) {
            setfomrError(false)
            const data = JSON.stringify({
                body: formData.text,
                publicationDateTime: new Date(),
                spoiler: isChecked,
                rating: hoveredIndex * 10,
            })
            updateComment.mutate(data)
            setPopupOpen(false)
        } else {
            setfomrError(true)
        }
    }
    const updateComment = useMutation({
        mutationKey: ['updateComment', auth.id],
        mutationFn: async (form) => {
            try {
                return axiosPrivate.patch(`/comments/${commentId}`, form, {
                    headers: {
                        'Content-Type': 'application/json',
                    },
                })
            } catch (error) {
                return error
            }
        },
        onMutate: async (form) => {
            const previousMoviesData = queryClient.getQueryData([
                'getLatestMoviesCommentsByUserId',
                auth.id,
            ])
            const previousSeriesData = queryClient.getQueryData([
                'getLatestSeriesCommentsByUserId',
                auth.id,
            ])

            const updatedMoviesData = updateOptimisticComment(
                previousMoviesData,
                commentId,
                form
            )
            const updatedSeriesData = updateOptimisticComment(
                previousSeriesData,
                commentId,
                form
            )

            queryClient.setQueryData(
                ['getLatestMoviesCommentsByUserId', auth.id],
                updatedMoviesData
            )
            queryClient.setQueryData(
                ['getLatestSeriesCommentsByUserId', auth.id],
                updatedSeriesData
            )

            return { previousMoviesData, previousSeriesData }
        },
        onSuccess: (data, variables, context) => {
           setnotificationText('Updated Successfully.')
           settype('success')
           setisNotificationPopupOpen(true)
        },
        onError: (error, variables, context) => {
            queryClient.setQueryData(
                ['getLatestMoviesCommentsByUserId', auth.id],
                context.previousMoviesData
            )
            queryClient.setQueryData(
                ['getLatestSeriesCommentsByUserId', auth.id],
                context.previousSeriesData
            )
             settype('error')
             setnotificationText(
                 error?.response?.data?.message || 'No server response'
             )
             setisNotificationPopupOpen(true)
        },
        onSettled: () => {
            queryClient.invalidateQueries([
                'getLatestMoviesCommentsByUserId',
                auth.id,
            ])
            queryClient.invalidateQueries([
                'getLatestSeriesCommentsByUserId',
                auth.id,
            ])
        },
        enabled: false,
    })
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
                setnotificationText(error?.response?.data?.message || "No server response")
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
    const getLatestMoviesCommentsByUserId = useInfiniteQuery({
        queryKey: ['getLatestMoviesCommentsByUserId', auth.id],
        queryFn: async ({ pageParam = 0 }) => {
            try {
                return axiosPrivate.get(
                    `users/${auth.id}/comments?filmType=1&pageSize=${pageSize}&page=${pageParam}`
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
    const getLatestSeriesCommentsByUserId = useInfiniteQuery({
        queryKey: ['getLatestSeriesCommentsByUserId', auth.id],
        queryFn: async ({ pageParam = 0 }) => {
            try {
                return axiosPrivate.get(
                    `users/${auth.id}/comments?filmType=2&pageSize=${pageSize}&page=${pageParam}`
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


    function handleLogout(e) {
        e.preventDefault()
        mutation.mutate()
    }
    function handleRemoveFromWatchList(e, id) {
        e.preventDefault()
        removeFromWatchList.mutate(id)
    }

    const isLoading =
        getWatchListByUser.isLoading ||
        getLatestMoviesCommentsByUserId.isLoading ||
        getLatestSeriesCommentsByUserId.isLoading

    const hasError =
        getWatchListByUser.error ||
        getLatestMoviesCommentsByUserId.error ||
        getLatestSeriesCommentsByUserId.error

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
    const moviesCommentsData = getLatestMoviesCommentsByUserId.data?.pages
    const seriesCommentsData = getLatestSeriesCommentsByUserId.data?.pages
    return (
        <ErrorBoundary>
            {watchlistdata && moviesCommentsData && seriesCommentsData && (
                <ProfileContainer
                    getLatestMoviesCommentsByUserId={
                        getLatestMoviesCommentsByUserId
                    }
                    getWatchListByUser={getWatchListByUser}
                    getLatestSeriesCommentsByUserId={
                        getLatestSeriesCommentsByUserId
                    }
                    handleLogout={handleLogout}
                    watchlistdata={watchlistdata}
                    moviesCommentsData={moviesCommentsData}
                    seriesCommentsData={seriesCommentsData}
                    handleRemoveFromWatchList={handleRemoveFromWatchList}
                    hoveredIndex={hoveredIndex}
                    setHoveredIndex={setHoveredIndex}
                    handleChange={handleChange}
                    handleSubmit={handleSubmit}
                    handleCheckboxChange={handleCheckboxChange}
                    closePopup={closePopup}
                    openPopup={openPopup}
                    isPopupOpen={isPopupOpen}
                    fomrError={fomrError}
                    formData={formData}
                    setcommentId={setcommentId}
                    setFormData={setFormData}
                    setcurrentIndex={setcurrentIndex}
                    currentIndex={currentIndex}
                    handleOnClick={handleOnClick}
                ></ProfileContainer>
            )}
        </ErrorBoundary>
    )
}

export default ProfileManager
