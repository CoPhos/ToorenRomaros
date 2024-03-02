import React, { Fragment, useState, useEffect } from 'react'
import {
    useParams,
    useSearchParams,
    useNavigate,
} from 'react-router-dom'
import AllReviewsContainer from './AllReviewsContainer'
import { useInfiniteQuery, useQuery } from 'react-query'
import axios from '../../utils/constants'
import ErrorBoundary from '../../utils/ErrorBoundary';

function AllReviewsManager() {
    const pageSize = 10
    const defaultParams = {
        super: 'true',
        rating: 'all',
        order: 'rating',
    }
    const FILM_URL = '/films'
    const navigate = useNavigate()
    const params = useParams()
    const [searchParams, setSearchParams] = useSearchParams()
    //TODO: stop using useState, is better to get the values from url
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
        setSearchParams({ super: selected })
        navigate(
            `?super=${selected}&rating=${selectedRating}&order=${selectedOrder}`
        )
    }
    const handleSelectedRatingChange = (event) => {
        const newSelectedOption = event.target.value

        setselectedRating(newSelectedOption)

        setSearchParams({ rating: newSelectedOption })
        navigate(
            `?super=${selectedSuper}&rating=${newSelectedOption}&order=${selectedOrder}`
        )
    }
    const handleSelectedOrder = (event) => {
        const newSelectedOption = event.target.value

        setselectedOrder(newSelectedOption)

        setSearchParams({ order: newSelectedOption })
        navigate(
            `?super=${selectedSuper}&rating=${selectedRating}&order=${newSelectedOption}`
        )
    }
    const getContent = useInfiniteQuery({
        queryKey: [
            'getContent',
            searchParams.get('rating') || defaultParams.rating,
            searchParams.get('order') || defaultParams.order,
            params.uuid,
        ],
        queryFn: async ({pageParam = 0}) => {
            try {
                let query
                if (searchParams.get('super') == 'true') {
                    query = `${FILM_URL}/${params.uuid}/posts/reviews?rating=${
                        searchParams.get('rating') || defaultParams.rating
                    }&order=${
                        searchParams.get('order') || defaultParams.order
                    }&size=${pageSize}&page=${pageParam}`
                } else {
                    query = `${FILM_URL}/${params.uuid}/comments?rating=${
                        searchParams.get('rating') || defaultParams.rating
                    }&order=${
                        searchParams.get('order') || defaultParams.order
                    }&size=${pageSize}&page=${pageParam}`
                }
                return axios.get(query)
            } catch (error) {
                return error
            }
        },
       
        getNextPageParam: (lastPage, pages) => {
            const hasNextPage =
                parseInt(lastPage.data.response.number, 10) + 1 <
                parseInt(lastPage.data.response.totalPages, 10)
                
            return hasNextPage
                ? parseInt(lastPage.data.response.number, 10) + 1
                : null
        },
        onSuccess: (data) => {
        },
        onError: (error) => {
            
        },
    })
    const getCommonRatingFromFilm = useQuery({
        queryKey: ['getCommonRatingFromFilm', params.uuid],
        queryFn: async () => {
            try {
                return axios.get(
                    FILM_URL +
                        `/${params.uuid}` +
                        '/comments/ratings' 
                )
                
            } catch (error) {
                return error
            }
        },
        onSuccess: (data) => {
          
        },
        onError: (error) => {
          
        },
    })
    const getMainFilmImage = useQuery({
        queryKey: ['getMainFilmImage', params.uuid],
        queryFn: async () => {
            try {
                return axios.get(
                    `/${params.uuid}/media/images?imageType=FILM_MAIN`
                )
            } catch (error) {
                return error
            }
        },
        onSuccess: (data) => {
           
        },
        onError: (error) => {
           
        },
    })
    const getSuperRatingFromFilm = useQuery({
        queryKey: ['getSuperRatingFromFilm', params.uuid],
        queryFn: async () => {
            try {
                return axios.get(
                    FILM_URL +
                        `/${params.uuid}` +
                        '/posts/ratings' 
                )
            } catch (error) {
                return error
            }
        },
        onSuccess: (data) => {
        },
        onError: (error) => {
           
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
        },
        onError: (error) => {
        },
    })

    useEffect(() => {
     
            getContent.refetch()
       
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
        getMainFilmImage.isLoading ||
        getSuperRatingFromFilm.isLoading

    const hasError =
        getFilm.error ||
        getContent.error ||
        getCommonRatingFromFilm.error ||
        getMainFilmImage.error ||
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
    const data = getContent.data?.pages
    const filmImageData = getMainFilmImage.data?.data
    return (
        <ErrorBoundary>
            {commonRatingData && superRatingData && data && (
                <AllReviewsContainer
                    handleSelectedOrder={handleSelectedOrder}
                    handleSelectedRatingChange={handleSelectedRatingChange}
                    handleSelectedSuperChange={handleSelectedSuperChange}
                    selectedOrder={selectedOrder}
                    selectedRating={selectedRating}
                    commonRatings={commonRatingData}
                    superRatings={superRatingData}
                    data={data}
                    filmData={filmData}
                    fetchNextPage={getContent.fetchNextPage}
                    isFetchingNextPage={getContent.isFetchingNextPage}
                    hasNextPage={getContent.hasNextPage}
                    filmImageData={filmImageData}
                ></AllReviewsContainer>
            )}
        </ErrorBoundary>
    )
}

export default AllReviewsManager
