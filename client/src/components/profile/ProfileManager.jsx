import React from 'react'
import axios from '../../utils/constants'
import useAuth from '../hooks/useAuth'
import { useNavigate } from 'react-router-dom'
import { useMutation } from 'react-query'

import ProfileContainer from './ProfileContainer'


function ProfileManager() {
  const LOGOUT_URL = '/auth/token'
   const { logout, auth } = useAuth()
   const navigate = useNavigate()

   const mutation = useMutation(
       async () => {
           return axios.delete(
               `${LOGOUT_URL}?refreshToken=${encodeURIComponent(
                   auth.refreshToken
               )}`,
               {
                   headers: {
                       'Content-Type': 'application/json',
                   },
                   withCredentials: true,
               }
           )
       },
       {
           onSuccess: (data) => {
            navigate('/', { replace: true })
            logout()  
           },
           onError: (error) => {
               console.log(error)
           },
       }
   )

   function handleLogout(e){
    e.preventDefault()
    mutation.mutate()
   }

  return <ProfileContainer handleLogout={handleLogout}></ProfileContainer>
}

export default ProfileManager