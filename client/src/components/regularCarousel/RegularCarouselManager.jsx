import React, { useContext } from 'react'
import RegularCarouselContainer from './RegularCarouselContainer'
import { useMutation, useQuery } from 'react-query'
import axios from '../../utils/constants'
import ErrorBoundary from '../../utils/ErrorBoundary'

function RegularCarouselManager({ parameters, queryName, promiseName }) {
    const FILM_URL = '/films'

    const getFilms = useQuery({
        queryKey: [queryName],
        queryFn: async () => {
            return axios.get(FILM_URL + parameters)
        },
        onSuccess: (data) => {},
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
        <ErrorBoundary>
            <RegularCarouselContainer data={getFilms.data.data.response} />
        </ErrorBoundary>
    )
}

export default RegularCarouselManager
