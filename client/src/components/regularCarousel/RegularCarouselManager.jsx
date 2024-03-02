import React, { useContext } from 'react'
import RegularCarouselContainer from './RegularCarouselContainer'
import { useMutation, useQuery } from 'react-query'
import axios from '../../utils/constants'


function RegularCarouselManager({parameters ,queryName, promiseName}) { 
  const FILM_URL = '/films'
  
  const getFilms = useQuery({
      queryKey: [queryName],
      queryFn: async () => {
          return axios.get(FILM_URL + parameters)
      },
      onSuccess: (data) => {
        
      },
  })


  
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
      />
  )

}

export default RegularCarouselManager