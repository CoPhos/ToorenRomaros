import React,{useEffect} from 'react'
import RegularCarouselContainer from './RegularCarouselContainer'
import { useQuery } from 'react-query'
import axios from '../../utils/constants'
import { useQueryClient } from 'react-query'

function RegularCarouselManager({parameters}) { 
  const queryClient = useQueryClient()
  
  const FILM_URL = '/films'
  
  const getFilms = useQuery({
    queryKey: ["customFilmsQuery"],
    queryFn: async () => { 
      return axios.get(FILM_URL + parameters)
    }
  })

  const getAllImages = useQuery(
      'allImagesfromCustomFilmsQuery',
      async () => {
          if (!getFilms.data) {
              return []
          }

          const imageResponses = await Promise.all(
              getFilms.data.data.response.map(async (item) => {
                  const response = await axios.get(
                      `${item.id}/media/images?imageType=FILM_MAIN`
                  )
                  return { id: item.id, images: response.data }
              })
          )

          const updatedFilms = getFilms.data.data.response.map((item) => {
              const correspondingImage = imageResponses.find(
                  (image) => image.id === item.id
              )
              return correspondingImage
                  ? { ...item, images: correspondingImage.images }
                  : item
          })

          queryClient.setQueryData(['customFilmsQuery'], {
              data: { response: updatedFilms },
          })
      },
      { enabled: !!getFilms.data }
  )
  
  if (getFilms.isLoading || getAllImages.isLoading) {
      return <p></p>
  }

  return getFilms.error || getAllImages.error ? (
      <div>
          <p>
              Oops! Something went wrong while fetching the data.
              <br></br>
              {getFilms.error?.message}
              <br></br>
              {getAllImages.error?.message}
          </p>
      </div>
  ) : (
      <RegularCarouselContainer
          data={getFilms.data.data.response}
      />
  )

}

export default RegularCarouselManager