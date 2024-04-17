import React, { useContext } from 'react'
import { useQuery } from 'react-query'
import axios from '../../utils/constants'
import TopFilmsContainer from './TopFilmsContainer'
import ErrorBoundary from '../../utils/ErrorBoundary'

function TopFilmsManager({ tittle, to, linkText, parameters, queryName }) {

    const FILM_URL = '/films'

    const getFilms = useQuery({
        queryKey: [queryName],
        queryFn: async () => {
            return axios.get(FILM_URL + parameters)
        },
        onSuccess: (data) => {
           
        },
    })

    const isLoading = getFilms.isLoading

    const hasError = getFilms.error

    if (isLoading) {
        return <div className="h-[600px]"></div>
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

    const data = getFilms.data?.data?.response

    return (
        <div className='min-h-[540px]'>
            {data && (
                <ErrorBoundary>
                    <TopFilmsContainer
                        tittle={tittle}
                        to={to}
                        linkText={linkText}
                        data={data}
                    ></TopFilmsContainer>
                </ErrorBoundary>
            )}
        </div>
    )
}

export default TopFilmsManager
