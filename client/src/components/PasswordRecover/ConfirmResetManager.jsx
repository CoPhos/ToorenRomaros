import React, { useState, useEffect, useRef } from 'react'
import { useSearchParams } from 'react-router-dom'
import ConfirmResetContainer from './ConfirmResetContainer'
import { useMutation } from 'react-query'
import axios from '../../utils/constants'
import ErrorBoundary from '../../utils/ErrorBoundary'

function ConfirmResetManager() {
    const PASSWORD_REGEX =
        /^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%]).{8,24}$/
    const errorRef = useRef()
    const [searchParams, setSearchParams] = useSearchParams()
    const [password, setpassword] = useState('')
    const [validPassword, setvalidPassword] = useState(false)
    const [passwordFocus, setpasswordFocus] = useState(false)
    const [matchPassword, setmatchPassword] = useState('')
    const [validmatchPassword, setvalidMatchPassword] = useState(false)
    const [matchPasswordFocus, setmatchPasswordFocus] = useState(false)
    const [errorMessage, seterrorMessage] = useState('')
    const token = searchParams.get('token') || ''
    const [isLoading, setIsLoading] = useState(false)
    const [redirect, setredirect] = useState(false)

    const sendNewPassword = useMutation({
        mutationKey: [sendNewPassword],
        mutationFn: async () => {
            try {
                return axios.patch(
                    '/auth/reset-password',
                    JSON.stringify({
                        newPassword: password,
                        token: token,
                    }),
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
            setredirect(true)
        },
        onError: (error) => {
            errorRef.current.focus()
            seterrorMessage(error.code)
        },
        onSettled: () => {
            setIsLoading(false)
        },
        enabled: false,
    })

    function handleSubmit(e) {
        e.preventDefault()
        if (!PASSWORD_REGEX.test(password)) {
            seterrorMessage('Invalid Entry')
            return
        }
        setIsLoading(true)
        sendNewPassword.mutate()
    }

    useEffect(() => {
        setvalidPassword(PASSWORD_REGEX.test(password))
        setvalidMatchPassword(password === matchPassword)
    }, [password, matchPassword])

    return (
        <ErrorBoundary>
            <ConfirmResetContainer
                errorRef={errorRef}
                errorMessage={errorMessage}
                password={password}
                setpassword={setpassword}
                setpasswordFocus={setpasswordFocus}
                passwordFocus={passwordFocus}
                validPassword={validPassword}
                matchPassword={matchPassword}
                setmatchPassword={setmatchPassword}
                setmatchPasswordFocus={setmatchPasswordFocus}
                validmatchPassword={validmatchPassword}
                matchPasswordFocus={matchPasswordFocus}
                handleSubmit={handleSubmit}
                isLoading={isLoading}
                redirect={redirect}
            ></ConfirmResetContainer>
        </ErrorBoundary>
    )
}

export default ConfirmResetManager
