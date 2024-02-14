import React, {Fragment} from 'react'
import axios from '../../utils/constants'
import { useQuery } from 'react-query';

import VideosTopContainer from './VideosTopContainer'

function VideosTopManager({ query, queryName }) {
    const getLatestPost = useQuery({
        queryKey: [queryName],
        queryFn: async () => {
            try {
                return axios.get(`/posts${query}`)
            } catch (error) {
                return error
            }
        },
        onSuccess: (data) => {
            console.log(data)
        },
        onError: (error) => {
            console.log(error)
        },
    })

    const isLoading = getLatestPost.isLoading

    const hasError = getLatestPost.error

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

    const data = getLatestPost.data?.data?.response

    return (
        <Fragment>
            {data && <VideosTopContainer data={data}></VideosTopContainer>}
        </Fragment>
    )
    
}

export default VideosTopManager