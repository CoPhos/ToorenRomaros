import React, { Fragment, useState, useEffect } from 'react'
import {
    useParams,
    useLocation,
    useSearchParams,
    useNavigate,
} from 'react-router-dom'
import AllReviewsContainer from './AllReviewsContainer'
import { useQuery } from 'react-query'
import axios from '../../utils/constants'

function AllReviewsManager() {
    const defaultParams = {
        super: 'true',
        rating: 'all',
        order: 'rating',
    }
    const FILM_URL = '/films'
    const location = useLocation()
    const navigate = useNavigate()
    const params = useParams()
    const [fetchedData, setFetchedData] = useState([])
    const [searchParams, setSearchParams] = useSearchParams()

    const [selectedSuper, setselectedSuper] = useState(
        searchParams.get('super') || 'true'
    )
    const [selectedRating, setselectedRating] = useState(
        searchParams.get('rating') || 'all'
    )
    const [selectedOrder, setselectedOrder] = useState(
        searchParams.get('order') || 'rating'
    )

    const handleSelectedSuperChange = (selected) => {
        setselectedSuper(selected)
        navigate(
            `?super=${selected}&rating=${selectedRating}&?order=${selectedOrder}`
        )
    }

    const handleSelectedRatingChange = (event) => {
        const newSelectedOption = event.target.value

        setselectedRating(newSelectedOption)

        setSearchParams({ selectedOption: newSelectedOption })
        navigate(
            `?super=${selectedSuper}&rating=${newSelectedOption}&?order=${selectedOrder}`
        )
    }

    const handleSelectedOrder = (event) => {
        const newSelectedOption = event.target.value

        setselectedOrder(newSelectedOption)

        setSearchParams({ selectedOption: newSelectedOption })
        navigate(
            `?super=${selectedSuper}&rating=${selectedRating}&?order=${newSelectedOption}`
        )
    }

    const getContent = useQuery({
        queryKey: [
            'getContent',
            searchParams.get('rating') || defaultParams.rating,
            searchParams.get('order') || defaultParams.order,
            params.uuid,
        ],
        queryFn: async () => {
            try {
                let query
                if (searchParams.get('super') == 'true') {
                    query = `${FILM_URL}/${params.uuid}/posts/reviews?rating=${
                        searchParams.get('rating') || defaultParams.rating
                    }&?order=${
                        searchParams.get('order') || defaultParams.order
                    }`
                } else {
                    query = `${FILM_URL}/${params.uuid}/comments?rating=${
                        searchParams.get('rating') || defaultParams.rating
                    }&?order=${
                        searchParams.get('order') || defaultParams.order
                    }`
                }
                return await axios.get(query)
            } catch (error) {
                return error
            }
        },
        enabled: false,
        onSuccess: (data) => {
            console.log(data)
            setFetchedData(data.data.response.content)
        },
        onError: (error) => {
            console.log(error)  
        },
    })

    const getCommonRatingFromFilm = useQuery({
        queryKey: ['getCommonRatingFromFilm', params.uuid],
        queryFn: async () => {
            try {
                return axios.get(
                    FILM_URL + `/${params.uuid}` + '/comments/ratings'
                )
            } catch (error) {
                return error
            }
        },
        onSuccess: (data) => {
            //console.log(data?.data)
        },
        onError: (error) => {
            console.log(error)
        },
    })
    const getSuperRatingFromFilm = useQuery({
        queryKey: ['getSuperRatingFromFilm', params.uuid],
        queryFn: async () => {
            try {
                return axios.get(
                    FILM_URL + `/${params.uuid}` + '/posts/ratings'
                )
            } catch (error) {
                return error
            }
        },
        onSuccess: (data) => {
            //console.log(data?.data)
        },
        onError: (error) => {
            console.log(error)
        },
    })
    const getFilm = useQuery({
        queryKey: ['getFilmById', params.uuid],
        queryFn: async () => {
            try {
                return axios.get(FILM_URL + `/${params.uuid}`)
            } catch (error) {
                return error
            }
        },
        onSuccess: (data) => {
            // console.log(data?.data)
        },
        onError: (error) => {
            console.log(error)
        },
    })

    useEffect(() => {
        const missingParams = Object.keys(defaultParams).filter(
            (param) => !searchParams.get(param)
        )

        if (missingParams.length > 0) {
            const updatedParams = new URLSearchParams(searchParams)

            missingParams.forEach((param) => {
                updatedParams.set(param, defaultParams[param])
            })
             setSearchParams(updatedParams)
        }
       
        if (missingParams.length === 0) {
            getContent.refetch()
        }
    }, [
        selectedOrder,
        selectedRating,
        selectedSuper,
        searchParams,
        navigate,
        setSearchParams,
    ])

    const isLoading =
        getFilm.isLoading ||
        getContent.isLoading ||
        getCommonRatingFromFilm.isLoading ||
        getSuperRatingFromFilm.isLoading

    const hasError =
        getFilm.error ||
        getContent.error ||
        getCommonRatingFromFilm.error ||
        getSuperRatingFromFilm.error

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

    const filmData = getFilm.data?.data?.response
    const commonRatingData = getCommonRatingFromFilm.data?.data?.response
    const superRatingData = getSuperRatingFromFilm.data?.data?.response
    const data = getContent.data?.data?.response?.content

    return (
        <Fragment>
            {commonRatingData && superRatingData && (
                <AllReviewsContainer
                    handleSelectedOrder={handleSelectedOrder}
                    handleSelectedRatingChange={handleSelectedRatingChange}
                    handleSelectedSuperChange={handleSelectedSuperChange}
                    selectedOrder={selectedOrder}
                    selectedRating={selectedRating}
                    commonRatings={commonRatingData}
                    superRatings={superRatingData}
                    data={fetchedData}
                    filmData={filmData}
                ></AllReviewsContainer>
            )}
        </Fragment>
    )
}

export default AllReviewsManager
