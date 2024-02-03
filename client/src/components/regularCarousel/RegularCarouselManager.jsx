import React, { useContext } from 'react'
import RegularCarouselContainer from './RegularCarouselContainer'
import { useMutation, useQuery } from 'react-query'
import axios from '../../utils/constants'
import useAxiosPrivate from '../hooks/useAxiosPrivate'
import { useQueryClient } from 'react-query'
import useAuth from '../hooks/useAuth'
import { LoginPopUpContext } from '../context/LoginPopUpProvider'

function RegularCarouselManager({parameters ,queryName, promiseName}) { 
  const queryClient = useQueryClient()
  const axiosPrivate = useAxiosPrivate()
  const { setisPopupOpen } = useContext(LoginPopUpContext)
  const { auth, isAuthenticated } = useAuth()
  
  const FILM_URL = '/films'
  const WATCH_LIST_URL = '/watchLists'
  
  const getFilms = useQuery({
      queryKey: [queryName],
      queryFn: async () => {
          return axios.get(FILM_URL + parameters)
      },
      onSuccess: (data) => {
          //console.log(data)
      },
  })

  const postWatchListItem = useMutation({
      mutationKey: ['postWatchListItem'],
      mutationFn: async (formData) => {
        try {
            return axiosPrivate.post(WATCH_LIST_URL, formData, {
                headers: {
                    'Content-Type': 'application/json',
                },
            })
        } catch (error) {
            return error
        }
      },

      onSuccess: (data) => {
          //console.log(data?.data?.created)
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
  
  if (getFilms.isLoading) {
      return <p></p>
  }

  return getFilms.error ? (
      <div>
          <p>
              Oops! Something went wrong while fetching the data.
              <br></br>
              {getFilms.error?.message}
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