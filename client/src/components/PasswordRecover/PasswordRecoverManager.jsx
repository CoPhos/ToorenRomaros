import React, { useState, useEffect, useContext } from 'react'
import PasswordRecoverContainer from './PasswordRecoverContainer'
import { useMutation } from 'react-query'
import axios from '../../utils/constants'
import ErrorBoundary from '../../utils/ErrorBoundary'
import { ActionNotificationContext } from '../context/ActionNotificationProvider'

function PasswordRecoverManager() {
    const [email, setemail] = useState('')
    const [validEmail, setvalidEmail] = useState(false)
    const [emailsended, setemailsended] = useState(false)
    const [isLoading, setIsLoading] = useState(false)
    const EMAIL_REGEX = /^[^\s@]+@[^\s@]+\.[^\s@]+$/
    const { setnotificationText, settype, setisNotificationPopupOpen } =
        useContext(ActionNotificationContext)

    function handleOnChange(event) {
        setemail(event.target.value)
    }

    function handleOnSumbit(e) {
        e.preventDefault()
        if (validEmail) {
            setIsLoading(true)
            sendEmail.mutate()
        }
    }

    useEffect(() => {
        setvalidEmail(EMAIL_REGEX.test(email))
    }, [email])

    const sendEmail = useMutation({
        mutationKey: [sendEmail],
        mutationFn: async () => {
            try {
                return axios.post(
                    '/auth/forgot-password',
                    JSON.stringify({ email: email }),
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
            setemailsended(true)
        },
        onError: (error) => {
            if (error?.response?.data?.errorCode === 'API-0102') {
                setnotificationText('User does not exists.')
            } else {
                setnotificationText('Server error, Try again.')
            }
            settype('error')
            setisNotificationPopupOpen(true)
        },
        onSettled: () => {
            setIsLoading(false)
        },
        enabled: false,
    })

    return (
        <ErrorBoundary>
            <PasswordRecoverContainer
                email={email}
                handleOnChange={handleOnChange}
                handleOnSumbit={handleOnSumbit}
                validEmail={validEmail}
                emailsended={emailsended}
                isLoading={isLoading}
            ></PasswordRecoverContainer>
        </ErrorBoundary>
    )
}

export default PasswordRecoverManager
