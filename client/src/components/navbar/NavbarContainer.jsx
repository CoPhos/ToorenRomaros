import React, { useState } from 'react'
import Navbar from './Navbar'

function NavbarContainer() {
    const [login, setLogin] = useState(1)

    return <Navbar isLoggedIn={login}></Navbar>
}

export default NavbarContainer
