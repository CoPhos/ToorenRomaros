import React, {useState, useEffect, useRef} from 'react'
import { useMutation } from 'react-query'

import SignUpContainer from './SignUpContainer';
import axios from '../../utils/constants'

function SignUpManager({active}) {
    const USER_REGEX = /^[A-z][A-z0-9-_]{3,23}$/
    const PASSWORD_REGEX =
        /^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%]).{8,24}$/
    const EMAIL_REGEX = /^[^\s@]+@[^\s@]+\.[^\s@]+$/

    const REGISTER_URL = '/users'

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

    const [errorMessage, seterrorMessage] = useState("")

    const userRef = useRef()
    const errorRef = useRef()

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
                        withCredentials: true,
                    },
                }
            )
        },
        {
            onSuccess: (data) => {
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
      ></SignUpContainer>
  )
}

export default SignUpManager