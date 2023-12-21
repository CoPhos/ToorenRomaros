import React, { useState } from 'react'
import { menuPanel } from '../../utils/data.js'
import NavbarContainer from './NavbarContainer.jsx'

function NavbarManager() {
    const [login, setLogin] = useState(1)
    const [formData, setFormData] = useState({
        email: '',
        username: '',
        password: '',
    })

    const handleChange = (e) => {
        const { name, value } = e.target
        setFormData((prevData) => ({
            ...prevData,
            [name]: value,
        }))
    }

    const handleSubmit = (e) => {
        e.preventDefault()
        console.log('Form submitted:', formData)
    }

    return (
        <NavbarContainer
            isLoggedIn={login}
            menuPanelData={menuPanel}
            formData={formData}
            handleChange={handleChange}
            handleSubmit={handleSubmit}
        ></NavbarContainer>
    )
}

export default NavbarManager
