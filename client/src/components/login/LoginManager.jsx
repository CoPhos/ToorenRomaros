import React, { useState, useEffect, useRef } from 'react'
import useAuth from '../hooks/useAuth'
import { Link, useNavigate, useLocation } from 'react-router-dom'
import { useMutation } from 'react-query'
import {jwtDecode} from 'jwt-decode'

import LoginContainer from './LoginContainer'
import axios from '../../utils/constants'


function LoginManager({ active, closePopup }) {
    const LOGIN_URL = '/auth/token'
    const { login } = useAuth()

    const navigate = useNavigate()
    const location = useLocation()
    const from = location.state?.from?.pathname || '/'

    const userRef = useRef()
    const errorRef = useRef()

    const [user, setuser] = useState('')
    const [password, setpassword] = useState('')
    const [errorMessage, seterrorMessage] = useState('')

    const handleApiError = (error) => {
        if (!error.response) {
            seterrorMessage('No Server Response')
        } else {
            handleHttpError(error)
        }
    }

    const handleHttpError = (error) => {
        switch (error.response.status) {
            case 401:
                seterrorMessage('Unauthorize')
                break
            default:
                console.log(error.response.data.message)
                seterrorMessage(error.response.data.message)
        }
    }

    const mutation = useMutation(
        async () => {
           try {
            return axios.post(
                 LOGIN_URL,
                 JSON.tringify({
                     ussername: user,
                     password: password,
                 }),
                 {
                     headers: {
                         'Content-Type': 'application/json',
                         withCredentials: true,
                     },
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
                login(id, user, password, roles, accessToken, refreshToken) 
                setuser('')
                setpassword('')
                seterrorMessage('')
                closePopup()
                navigate(from, { replace: true })
            },
            onError: (error) => {
                handleApiError(error)
                errorRef.current.focus()
            },
        }
    )

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
        ></LoginContainer>
    )
}

export default LoginManager
