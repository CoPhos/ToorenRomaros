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
        return <div className="h-[390px] "></div>
    }

    return (
        <div className="min-h-[285px]">
            {getFilms.error ? (
                <div>
                    <p>
                        Oops! Something went wrong while fetching the data.
                        <br></br>
                        {getFilms.error?.message}
                    </p>
                </div>
            ) : (
                getFilms.data.data.response && (
                    <ErrorBoundary>
                        <RegularCarouselContainer
                            data={getFilms.data.data.response}
                        />
                    </ErrorBoundary>
                )
            )}
        </div>
    )
}

export default RegularCarouselManager
