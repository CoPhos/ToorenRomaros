import React, { useState } from 'react'
import { menuPanel } from '../../utils/data.js'
import Navbar from './Navbar'

function NavbarContainer() {
    const [login, setLogin] = useState(1)

    return <Navbar isLoggedIn={login} menuPanelData={menuPanel}></Navbar>
}

export default NavbarContainer
