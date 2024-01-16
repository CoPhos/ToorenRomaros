import React, { useContext } from 'react'
import RegularCarouselContainer from './RegularCarouselContainer'
import { useMutation, useQuery } from 'react-query'
import axios from '../../utils/constants'
import { useQueryClient } from 'react-query'
import useAuth from '../hooks/useAuth'
import { LoginPopUpContext } from '../context/LoginPopUpProvider'

function RegularCarouselManager({parameters ,queryName, promiseName}) { 
  const queryClient = useQueryClient()
  const { setisPopupOpen } = useContext(LoginPopUpContext)
  const { auth, isAuthenticated } = useAuth()
  
  const FILM_URL = '/films'
  const WATCH_LIST_URL = '/watchLists'
  
  const getFilms = useQuery({
      queryKey: [queryName],
      queryFn: async () => {
          return axios.get(FILM_URL + parameters)
      },
  })

  const getAllImages = useQuery(
      promiseName,
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

          queryClient.setQueryData([queryName], {
              data: { response: updatedFilms },
          })
      },
      { enabled: !!getFilms.data }
  )
  const postWatchListItem = useMutation({
      mutationKey: ['postWatchListItem'],
      mutationFn: async (formData) => {
        try {
            return axios.post(WATCH_LIST_URL, formData, {
                headers: {
                    'Content-Type': 'application/json',
                },
            })
        } catch (error) {
            throw error
        }
      },

      onSuccess: (data) => {
          console.log(data?.data?.created)
      },
      onError: (error) => {
          console.log(error)
      },
  })
  

  function handleAddWatchList(e, filmId){
    e.preventDefault()
    if (!isAuthenticated) {
        setisPopupOpen(true)
    } else {
        postWatchListItem.mutate(
            JSON.stringify({
                film: filmId,
                user: auth.id,
            })
        )
    }
   
  }
  
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
          handleAddWatchList={handleAddWatchList}
      />
  )

}

export default RegularCarouselManager