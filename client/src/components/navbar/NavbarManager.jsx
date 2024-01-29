import React, { useState } from 'react'
import useAuth from '../hooks/useAuth'
import NavbarContainer from './NavbarContainer.jsx'

function NavbarManager() {
    const { auth } = useAuth()

    const data1 = {
        explore: [
            'Movies Home',
            'Coming Soon to Theaters',
            'Best Movies This Year',
            'Best Movies of All Time',
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
            user={auth?.user}
            data1={data1}
            data2={data2}
        ></NavbarContainer>
    )
}

export default NavbarManager
