import React, { useState } from 'react'
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

    const data1 = {
        explore: [
            'Movies Home',
            'Coming Soon to Theaters',
            'Best Movies This Year',
            'Best Movies of All Time',
            'Best Movies on',
            'Best Movies on Netflix',
            'Best Movies on Hulu',
            'Best Movies on Prime Vide',
            'Best Movies on Paramount+',
            'Best Movies on Disney+',
        ],
        movies: {
            1: 'Aquaman and the Lost Kingdom',
            2: 'Anyone But You',
            3: 'American Fiction',
            4: 'The Iron Claw',
            5: 'Wonka',
            6: 'The Color Purple',
            7: 'The Zone of Interest',
            8: 'Poor Things',
            9: 'The Boy and the Heron',
        },
    }

    const data2 = {
        explore: [
            'TV Home',
            'Best TV Shows This Year',
            'Best TV Shows of All Time',
            'Netflix: New & Upcoming',
            'Hulu: New & Upcoming',
            'Prime Vide: New & Upcoming',
            'Paramount+: New & Upcoming',
            'Disney+: New & Upcoming',
            'Apple TV+: New & Upcoming',
        ],
        movies: {
            1: 'Aquaman and the Lost Kingdom',
            2: 'Anyone But You',
            3: 'American Fiction',
            4: 'The Iron Claw',
            5: 'Wonka',
            6: 'The Color Purple',
            7: 'The Zone of Interest',
            8: 'Poor Things',
            9: 'The Boy and the Heron',
        },
    }

    return (
        <NavbarContainer
            isLoggedIn={login}
            formData={formData}
            handleChange={handleChange}
            handleSubmit={handleSubmit}
            data1={data1}
            data2={data2}
        ></NavbarContainer>
    )
}

export default NavbarManager