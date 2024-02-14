import React, { Fragment } from 'react'
import { useParams } from 'react-router-dom'
import { useQuery } from 'react-query';
import axios from '../../utils/constants'

import SinglePostContainer from './SinglePostContainer';

function HomeBlogManager() {
const params = useParams()

const getPostById = useQuery({
    queryKey: ['getPostById', params.uuid],
    queryFn: async () => {
        try {
            return axios.get(`/posts/${params.uuid}`)
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
      <Fragment>
          {/* home blog page is pending for know ill just implement individual post page {login ? <HomeBlogLoginContainer></HomeBlogLoginContainer> : <HomeBlogContainer></HomeBlogContainer>} */}
          {postData && (
                  <SinglePostContainer
                      postData={postData}
                      uuid={params.uuid}
                  ></SinglePostContainer>
              )}
      </Fragment>
  )
}

export default HomeBlogManager