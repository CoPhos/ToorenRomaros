import React, {useState, useEffect, useRef} from 'react'
import { useMutation } from 'react-query'
import useAuth from '../hooks/useAuth'
import { jwtDecode } from 'jwt-decode'
import { useNavigate, useLocation } from 'react-router-dom'
import useApiErrorHandler from '../hooks/useApiErrorHandler'

import SignUpContainer from './SignUpContainer';
import axios from '../../utils/constants'

function SignUpManager({ active, closePopup }) {
      const recaptchaRef = useRef()
      const [captchaToken, setcaptchaToken] = useState(null)
      const [submiteEnable, setsubmiteEnable] = useState(false)

      function onChange(value) {
          setcaptchaToken(value)
      }
    const USER_REGEX = /^[A-z][A-z0-9-_]{3,23}$/
    const PASSWORD_REGEX =
        /^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%]).{8,24}$/
    const EMAIL_REGEX = /^[^\s@]+@[^\s@]+\.[^\s@]+$/

    const REGISTER_URL = '/users'
    const { login } = useAuth()
    const navigate = useNavigate()
    const location = useLocation()
    const from = location.state?.from?.pathname || '/'

    const [user, setuser] = useState('')
    const [validUsername, setvalidUsername] = useState(false)
    const [userFocus, setuserFocus] = useState(false)

    const [email, setemail] = useState('')
    const [validEmail, setvalidEmail] = useState(false)
    const [emailFocus, setemailFocus] = useState(false)

    const [password, setpassword] = useState('')
    const [validPassword, setvalidPassword] = useState(false)
    const [passwordFocus, setpasswordFocus] = useState(false)

    const [matchPassword, setmatchPassword] = useState('')
    const [validmatchPassword, setvalidMatchPassword] = useState(false)
    const [matchPasswordFocus, setmatchPasswordFocus] = useState(false)
    
    const userRef = useRef()
    const errorRef = useRef()
    
    const { errorMessage, seterrorMessage, handleApiError } =
        useApiErrorHandler()

    const mutation = useMutation(
        async () => {
           try {
               return axios.post(
                   REGISTER_URL,
                   JSON.stringify({
                       username: user,
                       password: password,
                       email: email,
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
                const id = data?.data?.userId
                const accessToken = data?.data?.accessToken
                const refreshToken = data?.data?.refreshToken
                const roles = jwtDecode(accessToken).roles || []
                const email = data?.data?.email
                login(
                    id,
                    user,
                    roles,
                    accessToken,
                    refreshToken,
                    email
                )
                navigate(from, { replace: true })
                setuser('')
                setvalidUsername(false)
                setuserFocus(false)
                setemail('')
                setvalidEmail(false)
                setemailFocus(false)
                setpassword('')
                setvalidPassword(false)
                setpasswordFocus(false)
                setmatchPassword('')
                setvalidMatchPassword(false)
                setmatchPasswordFocus(false)
                seterrorMessage('')
                closePopup()
            },
            onError: (error) => {
                recaptchaRef.current.reset()
                handleApiError(error)
                errorRef.current.focus()
            },
        }
    )

    useEffect(() => {
        userRef.current.focus()
    }, [])

    useEffect(() => {
        setvalidUsername(USER_REGEX.test(user))
    }, [user])

    useEffect(() => {
        setvalidEmail(EMAIL_REGEX.test(email))
    }, [email])

    useEffect(() => {
        setvalidPassword(PASSWORD_REGEX.test(password))
        setvalidMatchPassword(password === matchPassword)
    }, [password, matchPassword])

    useEffect(() => {
        seterrorMessage('')
    }, [user, email, password, matchPassword])

    const handleSubmit = async (e) => {
        e.preventDefault()
        if (!USER_REGEX.test(user) || !PASSWORD_REGEX.test(password)) {
            seterrorMessage('Invalid Entry')
            return
        }
        mutation.mutate()
    }

    return (
        <SignUpContainer
            active={active}
            userRef={userRef}
            errorRef={errorRef}
            errorMessage={errorMessage}
            user={user}
            setuser={setuser}
            setemail={setemail}
            validUsername={validUsername}
            setuserFocus={setuserFocus}
            email={email}
            validEmail={validEmail}
            setemailFocus={setemailFocus}
            emailFocus={emailFocus}
            userFocus={userFocus}
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
            captchaToken={captchaToken}
            submiteEnable={submiteEnable}
            setsubmiteEnable={setsubmiteEnable}
            onChange={onChange}
            recaptchaRef={recaptchaRef}
        ></SignUpContainer>
    )
}

export default SignUpManager