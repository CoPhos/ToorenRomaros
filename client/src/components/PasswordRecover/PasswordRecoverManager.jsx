import React,{useState, useEffect} from 'react'
import PasswordRecoverContainer from './PasswordRecoverContainer';
import { useMutation } from 'react-query'
import axios from '../../utils/constants'

function PasswordRecoverManager() {
    const [email, setemail] = useState("")
    const [validEmail, setvalidEmail] = useState(false)
    const [emailsended, setemailsended] = useState(false)
    const EMAIL_REGEX = /^[^\s@]+@[^\s@]+\.[^\s@]+$/
    const [errorMessage, seterrorMessage] = useState('')

    function handleOnChange(event){
        setemail(event.target.value)
    }

    function handleOnSumbit(e){
        e.preventDefault()
        if(validEmail){
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
        onError: (error) => {},
        enabled: false,
    })

  return (
      <PasswordRecoverContainer
          email={email}
          handleOnChange={handleOnChange}
          handleOnSumbit={handleOnSumbit}
          validEmail={validEmail}
          emailsended={emailsended}
      ></PasswordRecoverContainer>
  )
}

export default PasswordRecoverManager