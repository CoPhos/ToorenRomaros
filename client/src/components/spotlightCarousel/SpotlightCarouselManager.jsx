import React from 'react'
import axios from '../../utils/constants'
import SpotlightCarouselContainer from './SpotlightCarouselContainer'
import { useQuery } from 'react-query';

function SpotlightCarouselManager() {
  const POST_URL = '/posts'

  const getLatestPost = useQuery({
    queryKey: ["latestPosts"],
    queryFn: async () => { 
      return axios.get(POST_URL + "?page=0&size=4&latest=true")
    }
  })

  const getAllImages = useQuery({
    queryKey: ["allImages"],
    queryFn: async () => {
      if(!getLatestPost.data){
        return []
      }
      const secondResponses = await Promise.all(
          getLatestPost.data.data.response.map(async (item) => {
              const response = await axios.get(
                  `${item.id}/media/images?imageType=POST_MAIN`
              )
              return response.data
          })
      )
    return secondResponses;
    },
    enabled: !!getLatestPost.data,
  })

    
  return (
      <SpotlightCarouselContainer
          data={getLatestPost.data?.data?.response || []}
          images={getAllImages.data || []}
          isLoading={getLatestPost.isLoading || getAllImages.isLoading}
      />
  )
}

export default SpotlightCarouselManager