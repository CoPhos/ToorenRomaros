import React, { Fragment, useState, useEffect, useContext } from 'react'
import useAxiosPrivate from '../hooks/useAxiosPrivate'
import { useParams } from 'react-router-dom'
import PostRatingContainer from './PostRatingContainer'
import useAuth from '../hooks/useAuth'
import { useMutation, useQuery } from 'react-query'
import { LoginPopUpContext } from '../context/LoginPopUpProvider'

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
    const [isChecked, setIsChecked] = useState(false)
    const [fomrError, setfomrError] = useState(false)
    const [isPopupOpen, setPopupOpen] = useState(false)

    const closePopup = () => {
        setPopupOpen(false)
    }
    const handleCheckboxChange = () => {
        setIsChecked((prevChecked) => !prevChecked)
    }
    function handleOnClick(e, index) {
        if (isAuthenticated) {
            setcurrentIndex(index)
            const data = JSON.stringify({
                publicationDateTime: new Date(),
                rating: (index + 1) * 10,
            })
             updateComment.mutate(data)
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
            const data = JSON.stringify({
                body: formData.text,
                publicationDateTime: new Date(),
                spoiler: isChecked,
                rating: hoveredIndex * 10,
            })
            updateComment.mutate(data)
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
            //console.log(data?.data)
            setHoveredIndex(data.data.response.rating / 10 - 1)
            setcurrentIndex(data.data.response.rating / 10 - 1)
        },
        onError: (error) => {
            console.log(error)
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
            console.log(data)
        },
        onError: (error) => {
            console.log(error)
        },
        enabled: false,
    })

    useEffect(() => {
        if (auth.id) {
            getCommentByFilmIdAndUserId.refetch()
        }
    }, [])

    const isLoading = getCommentByFilmIdAndUserId.isLoading
    const hasError = getCommentByFilmIdAndUserId.error

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

    return (
        <Fragment>
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
        </Fragment>
    )
}

export default PostRatingManager
