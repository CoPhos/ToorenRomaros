import React, { Fragment, useState, useEffect, useContext } from 'react'
import useAxiosPrivate from '../hooks/useAxiosPrivate'
import { useParams } from 'react-router-dom'
import PostRatingContainer from './PostRatingContainer'
import useAuth from '../hooks/useAuth'
import { useMutation, useQuery } from 'react-query'
import { LoginPopUpContext } from '../context/LoginPopUpProvider'
import CriticRating from './CriticRating'

function PostRatingManager(filmdata) {
    const axiosPrivate = useAxiosPrivate()
    const params = useParams()
    const { auth, isAuthenticated } = useAuth()
    const { setisPopupOpen } = useContext(LoginPopUpContext)
    const [currentIndex, setcurrentIndex] = useState(null)
    const [hoveredIndex, setHoveredIndex] = useState(null)
    const [formData, setFormData] = useState({
        text: '',
    })
    const [criticRating, setcriticRating] = useState(null)
    const [isChecked, setIsChecked] = useState(false)
    const [fomrError, setfomrError] = useState(false)
    const [isPopupOpen, setPopupOpen] = useState(false)
    const isValidUUID = (str) => {
        const uuidRegex =
            /^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$/
        return uuidRegex.test(str)
    }

    const closePopup = () => {
        setPopupOpen(false)
    }
    const handleCheckboxChange = () => {
        setIsChecked((prevChecked) => !prevChecked)
    }
    function handleOnClick(e, index) {
        if (isAuthenticated) {
            setcurrentIndex(index)

            if (userCommentData?.id && isValidUUID(userCommentData.id)) {
                const data = JSON.stringify({
                    publicationDateTime: new Date(),
                    rating: (index + 1) * 10,
                })
            
                updateComment.mutate(data)
            } else {
                const data = JSON.stringify({
                    userId: auth.id,
                    filmId: params.uuid,
                    publicationDateTime: new Date(),
                    rating: (index + 1) * 10,
                })
               
                postComment.mutate(data)
            }
        } else {
            setisPopupOpen(true)
        }
    }
    const openPopup = () => {
        if (isAuthenticated) {
            setPopupOpen(true)
        } else {
            setisPopupOpen(true)
        }
    }
    const handleChange = (e) => {
        const { name, value } = e.target
        setFormData((prevData) => ({
            ...prevData,
            [name]: value,
        }))
    }
    const handleSubmit = (e) => {
        e.preventDefault()
        if (formData.text.length <= 5000) {
            setfomrError(false)
           
            if (userCommentData?.id && isValidUUID(userCommentData.id)) {
                 const data = JSON.stringify({
                     body: formData.text,
                     publicationDateTime: new Date(),
                     spoiler: isChecked,
                     rating: hoveredIndex * 10,
                 })
                updateComment.mutate(data)
            } else {
                 const data = JSON.stringify({
                     userId: auth.id,
                     filmId: params.uuid,
                     body: formData.text,
                     publicationDateTime: new Date(),
                     spoiler: isChecked,
                     rating: hoveredIndex * 10,
                 })
                postComment.mutate(data)
            }
            setPopupOpen(false)
        } else {
            setfomrError(true)
        }
    }
    const getCommentByFilmIdAndUserId = useQuery({
        queryKey: ['getCommentByFilmIdAndUserId', params.uuid, auth.id],
        queryFn: async () => {
            try {
                return axiosPrivate.get(
                    `/users/${auth.id}/comments/films/${params.uuid}`
                )
            } catch (error) {
                return error
            }
        },
        onSuccess: (data) => {
           
            setHoveredIndex(data.data.response.rating / 10 - 1)
            setcurrentIndex(data.data.response.rating / 10 - 1)
        },
        onError: (error) => {
            
        },
        enabled: false,
    })
    const getLatestPostCriticReview = useQuery({
        queryKey: ['getLatestPostCriticReview', params.uuid, auth.id],
        queryFn: async () => {
            try {
                return axiosPrivate.get(
                    `/users/${auth.id}/films/${params.uuid}/posts/reviews`
                )
            } catch (error) {
                return error
            }
        },
        onSuccess: (data) => {
           
        },
        onError: (error) => {
        
        },
        enabled: false,
    })
    const updateComment = useMutation({
        mutationKey: ['updateComment', params.uuid, auth.id],
        mutationFn: async (form) => {
            try {
                return axiosPrivate.patch(
                    `/comments/${userCommentData.id}`,
                    form,
                    {
                        headers: {
                            'Content-Type': 'application/json',
                        },
                    }
                )
            } catch (error) {
                return error
            }
        },
        onSuccess: (data) => {
            setnotificationText('Updated Successfully.')
            settype('success')
            setisNotificationPopupOpen(true)
            userCommentData.refetch()
        },
        onError: (error) => {
           settype('error')
           setnotificationText(
               error?.response?.data?.message || 'No server response'
           )
           setisNotificationPopupOpen(true)
        },
        enabled: false,
    })

    const postComment = useMutation({
        mutationKey: ['postComment', params.uuid, auth.id],
        mutationFn: async (form) => {
            try {
                return axiosPrivate.post(`/comments`, form, {
                    headers: {
                        'Content-Type': 'application/json',
                    },
                })
            } catch (error) {
                return error
            }
        },
        onSuccess: (data) => {
           setnotificationText('Updated Successfully.')
           settype('success')
           setisNotificationPopupOpen(true)
        },
        onError: (error) => {
           settype('error')
           setnotificationText(
               error?.response?.data?.message || 'No server response'
           )
           setisNotificationPopupOpen(true)
        },
        enabled: false,
    })

    useEffect(() => {
        if (auth) {
            if (auth.id && auth?.roles?.includes('USUER')) {
                getCommentByFilmIdAndUserId.refetch()
            } else if (auth.id && auth.roles.includes('CRITIC')) {
                getLatestPostCriticReview.refetch()
            }
        }
    }, [])

    const isLoading =
        getCommentByFilmIdAndUserId.isLoading ||
        getLatestPostCriticReview.isLoading
    const hasError =
        getCommentByFilmIdAndUserId.error || getLatestPostCriticReview.isError

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

    const userCommentData = getCommentByFilmIdAndUserId.data?.data?.response
    const criticPostData = getLatestPostCriticReview.data?.data?.response

    return (
        <Fragment>
            {auth && auth?.roles?.find((item) => item == 'CRITIC') ? (
                <CriticRating
                    hoveredIndex={criticPostData?.rating || 0}
                    filmId={params.uuid}
                ></CriticRating>
            ) : (
                <PostRatingContainer
                    filmdata={filmdata}
                    currentIndex={currentIndex}
                    hoveredIndex={hoveredIndex}
                    setHoveredIndex={setHoveredIndex}
                    formData={formData}
                    handleOnClick={handleOnClick}
                    handleChange={handleChange}
                    handleSubmit={handleSubmit}
                    handleCheckboxChange={handleCheckboxChange}
                    closePopup={closePopup}
                    openPopup={openPopup}
                    isPopupOpen={isPopupOpen}
                    userCommentData={userCommentData ? userCommentData : []}
                    fomrError={fomrError}
                ></PostRatingContainer>
            )}
        </Fragment>
    )
}

export default PostRatingManager
