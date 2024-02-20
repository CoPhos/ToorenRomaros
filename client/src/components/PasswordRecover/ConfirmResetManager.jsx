import React, { useState, useEffect, useRef } from 'react'
import { useSearchParams } from 'react-router-dom'
import ConfirmResetContainer from './ConfirmResetContainer'
import { useMutation } from 'react-query'
import axios from '../../utils/constants'

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

    const sendNewPassword = useMutation({
        mutationKey: [sendNewPassword],
        mutationFn: async () => {
            try {
                
                return axios.patch(
                    '/auth/reset-password',
                    JSON.stringify({
                        email: 'adsasd',
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
            console.log(token)
            console.log(data)
        },
        onError: (error) => {
            console.log(token)
            console.log(
                JSON.stringify({
                    email: 'adsasd',
                    newPassword: password,
                    token: token,
                })
            )
            errorRef.current.focus()
            seterrorMessage(error.code)
        },
        enabled: false,
    })

    function handleSubmit(e) {
        e.preventDefault()
        if (!PASSWORD_REGEX.test(password)) {
            seterrorMessage('Invalid Entry')
            return
        }
        sendNewPassword.mutate()
    }

    useEffect(() => {
        setvalidPassword(PASSWORD_REGEX.test(password))
        setvalidMatchPassword(password === matchPassword)
    }, [password, matchPassword])

    return (
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
        ></ConfirmResetContainer>
    )
}

export default ConfirmResetManager
