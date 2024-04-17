import React, { useEffect } from 'react'
import { useParams } from 'react-router-dom'
import { useQuery } from 'react-query'
import axios from '../../utils/constants'
import useAuth from '../hooks/useAuth'
import ErrorBoundary from '../../utils/ErrorBoundary'

import SinglePostContainer from './SinglePostContainer'

function HomeBlogManager() {
    const { auth } = useAuth()
    const params = useParams()

    const getPostById = useQuery({
        queryKey: ['getPostById', params.uuid],
        queryFn: async () => {
            try {
                const query = auth.id
                    ? `/posts/${params.uuid}?userId=${auth.id}`
                    : `/posts/${params.uuid}`
                return axios.get(query)
            } catch (error) {
                return error
            }
        },
        onSuccess: (data) => {},
        onError: (error) => {},
    })

     function loadFacebookSDK() {
         if (!window.FB) {
             const script = document.createElement('script')
             script.async = true
             script.defer = true
             script.crossOrigin = 'anonymous'
             script.src =
                 'https://connect.facebook.net/es_ES/sdk.js#xfbml=1&version=v19.0'
             script.nonce = '9Z9pNreS'
             document.body.appendChild(script)
         }
     }

     useEffect(() => {
         loadFacebookSDK()
     }, [])


    const isLoading = getPostById.isLoading

    const hasError = getPostById.error

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

    const postData = getPostById.data?.data?.response

    return (
        <ErrorBoundary>
            {/* home blog page is pending for now ill just implement individual post page {login ? <HomeBlogLoginContainer></HomeBlogLoginContainer> : <HomeBlogContainer></HomeBlogContainer>} */}
            <div className='min-h-[100vh]'>
                {postData && (
                    <SinglePostContainer
                        postData={postData}
                        uuid={params.uuid}
                    ></SinglePostContainer>
                )}
            </div>
        </ErrorBoundary>
    )
}

export default HomeBlogManager
