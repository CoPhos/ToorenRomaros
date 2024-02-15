import React, { useContext } from 'react'
import { useQuery } from 'react-query'
import axios from '../../utils/constants'
import TopFilmsContainer from './TopFilmsContainer'

function TopFilmsManager({ tittle, to, linkText, parameters, queryName }) {

    const FILM_URL = '/films'

    const getFilms = useQuery({
        queryKey: [queryName],
        queryFn: async () => {
            return axios.get(FILM_URL + parameters)
        },
        onSuccess: (data) => {
            console.log(data)
        },
    })

    const isLoading = getFilms.isLoading

    const hasError = getFilms.error

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

    const data = getFilms.data?.data?.response

    return (
        <TopFilmsContainer
            tittle={tittle}
            to={to}
            linkText={linkText}
            data={data}
        ></TopFilmsContainer>
    )
}

export default TopFilmsManager
