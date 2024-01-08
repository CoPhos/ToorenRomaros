import React, { useState, useEffect, useRef } from 'react'
import LoginContainer from './LoginContainer'

function LoginManager({ active }) {
    return <LoginContainer active={active}></LoginContainer>
}

export default LoginManager
