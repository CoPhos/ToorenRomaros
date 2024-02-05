import React, { useState, useEffect, Fragment } from 'react'
import useAxiosPrivate from '../hooks/useAxiosPrivate'
import axios from '../../utils/constants'
import useAuth from '../hooks/useAuth'
import { useNavigate } from 'react-router-dom'
import { useMutation, useQuery,  } from 'react-query'

import ProfileContainer from './ProfileContainer'

function ProfileManager() {
    const LOGOUT_URL = '/auth/token'
    const axiosPrivate = useAxiosPrivate()
    const { logout, auth } = useAuth()
    const navigate = useNavigate()

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
            return axiosPrivate.delete(`/watchLists/users/${auth.id}?filmId=${id}`, {
            })
        },
        {
            onSuccess: (data) => {
                 for (let i = 0; i < watchlistdata.length; i++) {
                     if (watchlistdata[i].film === data.data) {
                         watchlistdata.splice(i, 1)
                         break
                     }
                 }
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

    function handleRemoveFromWatchList(e, id) {
        e.preventDefault()
        removeFromWatchList.mutate(id)
    }

    const getWatchListByUser = useQuery({
        queryKey: ['getWatchListByUser', auth.id],
        queryFn: async () => {
            try {
                return axiosPrivate.get(`users/${auth.id}/watchLists`)
            } catch (error) {
                return error
            }
        },
        onSuccess: (data) => {
            console.log(data?.data)
        },
        onError: (error) => {
            console.log(error)
        }
    })

    const isLoading =
        getWatchListByUser.isLoading 

    const hasError =
        getWatchListByUser.error 
        
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
                    handleRemoveFromWatchList={handleRemoveFromWatchList}
                ></ProfileContainer>
            )}
        </Fragment>
    )
}

export default ProfileManager

