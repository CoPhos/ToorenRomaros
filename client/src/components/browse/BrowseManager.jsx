import React, { useState, useEffect } from 'react'
import { useHistory, useLocation } from 'react-router-dom'
import BrowseContainer from './BrowseContainer'

function BrowseManager({}) {
    const history = useHistory()
    const location = useLocation()
    const [selectedRadio, setSelectedRadio] = useState('')

    const [checkedCheckboxes, setCheckedCheckboxes] = useState({Genre: {}, Rating: {}})

    useEffect(() => {
        const pathParts = location.pathname.split('/')
        const radioValue = pathParts[pathParts.length - 1]
        setSelectedRadio(radioValue)
    }, [location.pathname])

    const handleRadioChange = (value) => {
        setSelectedRadio(value)
        history.push(`${location.pathname}?sort=${value}`)
    }

    const handleCheckboxChange = (event, group) => {
        const checkboxName = event.target.name

        setCheckedCheckboxes((prevCheckboxState) => ({
            ...prevCheckboxState,
            [group]: {
                ...prevCheckboxState[group],
                [checkboxName]: !prevCheckboxState[group][checkboxName],
            },
        }))
        console.log(checkedCheckboxes)
    }

    const handleSubmit = (event) => {
        event.preventDefault()
        //document.getElementById('myForm').submit()
        console.log('Selected Radio:', selectedRadio)
        console.log('Checked Checkboxes:', checkedCheckboxes)
    }

    const handleResetClick = (event, group) => {
        event.preventDefault()
        setCheckedCheckboxes((prevCheckboxState) => ({
            ...prevCheckboxState,
            [group]: {},
        }))
    }

    return (
        <BrowseContainer
            handleSubmit={handleSubmit}
            handleCheckboxChange={handleCheckboxChange}
            handleRadioChange={handleRadioChange}
            selectedRadio={selectedRadio}
            checkedCheckboxes={checkedCheckboxes}
            handleResetClick={handleResetClick}
        ></BrowseContainer>
    )
}

export default BrowseManager
