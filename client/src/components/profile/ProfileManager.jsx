import React from 'react'
import ProfileContainer from './ProfileContainer';
import useAuth from '../hooks/useAuth'
import { useNavigate } from 'react-router-dom'


function ProfileManager() {
   const { logout } = useAuth()
   const navigate = useNavigate()

   function handleLogout(e){
    e.preventDefault()
    logout()
    navigate("/", { replace: true })
   }
  return <ProfileContainer handleLogout={handleLogout}></ProfileContainer>
}

export default ProfileManager