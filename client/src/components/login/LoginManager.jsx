import React, { useState, useEffect, useRef } from 'react'
import useAuth from '../hooks/useAuth'
import { Link, useNavigate, useLocation } from 'react-router-dom'
import { useMutation, useQuery } from 'react-query'
import { jwtDecode } from 'jwt-decode'
import useApiErrorHandler from '../hooks/useApiErrorHandler'

import LoginContainer from './LoginContainer'
import axios from '../../utils/constants'

function LoginManager({ active, closePopup }) {
    const LOGIN_URL = '/auth/token'
    const { login, auth, setImage } = useAuth()

    const recaptchaRef = useRef()
    const [captchaToken, setcaptchaToken] = useState(null)
    const [submiteEnable, setsubmiteEnable] = useState(false)

    function onChange(value) {
        setcaptchaToken(value)
    }

    const navigate = useNavigate()
    const location = useLocation()
    const from = location.state?.from?.pathname || '/'

    const userRef = useRef()
    const errorRef = useRef()

    const [user, setuser] = useState('')
    const [password, setpassword] = useState('')
    const { errorMessage, seterrorMessage, handleApiError } =
        useApiErrorHandler()

    const mutation = useMutation(
        async () => {
            try {
                return axios.post(
                    LOGIN_URL,
                    JSON.stringify({
                        username: user,
                        password: password,
                    }),
                    {
                        headers: {
                            'Content-Type': 'application/json',
                            recaptcha: captchaToken,
                        },
                        withCredentials: true,
                    }
                )
            } catch (error) {
                return error
            }
        },
        {
            onSuccess: (data) => {
                const id = data?.data?.Ok?.userId
                const accessToken = data?.data?.Ok?.accessToken
                const refreshToken = data?.data?.Ok?.refreshToken
                const roles = jwtDecode(accessToken).roles || []
                const email = data?.data?.Ok?.email
                login(id, user, roles, accessToken, refreshToken, email)
                setuser('')
                setpassword('')
                seterrorMessage('')
            },
            onError: (error) => {
                recaptchaRef.current.reset()
                handleApiError(error)
                errorRef.current.focus()
            },
        }
    )

    const getProfileImage = useQuery({
        queryKey: ['getProfileImage'],
        queryFn: async () => {
            try {
                return axios.get(
                    `${auth.id}/media/images?imageType=USER_PROFILE`
                )
            } catch (error) {
                return error
            }
        },
        onSuccess: (data) => {
            const image = data?.data?.[0]?.id
            setImage(image)
            closePopup()
            navigate(from, { replace: true })
        },
        onError: (error) => {
           
        },
        enabled: !!auth?.id,
    })

    useEffect(() => {
        userRef.current.focus()
    }, [])

    useEffect(() => {
        seterrorMessage('')
    }, [user, password])

    const handleSubmit = async (e) => {
        e.preventDefault()
        mutation.mutate()
    }

    return (
        <LoginContainer
            handleSubmit={handleSubmit}
            active={active}
            userRef={userRef}
            errorRef={errorRef}
            user={user}
            setuser={setuser}
            password={password}
            setpassword={setpassword}
            errorMessage={errorMessage}
            captchaToken={captchaToken}
            submiteEnable={submiteEnable}
            setsubmiteEnable={setsubmiteEnable}
            onChange={onChange}
            recaptchaRef={recaptchaRef}
            closePopup={closePopup}
        ></LoginContainer>
    )
}

export default LoginManager
