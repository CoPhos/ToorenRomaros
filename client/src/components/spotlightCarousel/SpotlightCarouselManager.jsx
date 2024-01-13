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

  const getAllImages = useQuery('allImages', async () => {
      if (!getLatestPost.data) {
          return []
      }

      const imageResponses = await Promise.all(
          getLatestPost.data.data.response.map(async (item) => {
              const response = await axios.get(
                  `${item.id}/media/images?imageType=POST_MAIN`
              )
              return { id: item.id, images: response.data }
          })
      )

      getLatestPost.data.data.response.forEach((item) => {
          const correspondingImage = imageResponses.find(
              (image) => image.id === item.id
          )
          if (correspondingImage) {
              item.images = correspondingImage.images
          }
      })
      console.dir(getLatestPost.data.data.response, { depth: null })
      return getLatestPost.data.data.response
  }, {enabled: !!getLatestPost.data},)

  return (getLatestPost.error || getAllImages.error) ? (
      <div>
          <p>
              Oops! Something went wrong while fetching the data.
              <br></br>
              {getLatestPost.error?.message} 
              <br></br>
              {getAllImages.error?.message}
          </p>
      </div>
  ) : (
      <SpotlightCarouselContainer
          data={getLatestPost.data?.data?.response || []}
          isLoading={getLatestPost.isLoading || getAllImages.isLoading}
      />
  )
}

export default SpotlightCarouselManager