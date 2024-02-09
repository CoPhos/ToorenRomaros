import React, { useState, useEffect, Fragment } from 'react'
import useAxiosPrivate from '../hooks/useAxiosPrivate'
import axios from '../../utils/constants'
import useAuth from '../hooks/useAuth'
import { useNavigate } from 'react-router-dom'
import { useMutation, useQueryClient, useInfiniteQuery } from 'react-query'

import CriticProfileContainer from '../profile/CriticProfileContainer'

function CriticProfileManager() {
    const queryClient = useQueryClient()
    const LOGOUT_URL = '/auth/token'
    const axiosPrivate = useAxiosPrivate()
    const { logout, auth } = useAuth()
    const navigate = useNavigate()
    const pageSize = 10

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
                console.log(error)
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
            onSuccess: (data) => {},
            onError: (error) => {
                console.log(error)
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
            console.log(data)
        },
        onError: (error) => {
            console.log(error)
        },
    })

    const isLoading = getWatchListByUser.isLoading

    const hasError = getWatchListByUser.error

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

    return (
        <Fragment>
            {watchlistdata && (
                <CriticProfileContainer
                    handleLogout={handleLogout}
                    watchlistdata={watchlistdata}
                    getWatchListByUser={getWatchListByUser}
                    handleRemoveFromWatchList={handleRemoveFromWatchList}
                ></CriticProfileContainer>
            )}
        </Fragment>
    )
}

export default CriticProfileManager
