import React, { createContext, useState } from 'react'
import ActionNotificationCard from '../cards/notification/ActionNotificationCard'
const ActionNotificationContext = createContext()

const ActionNotificationProvider = ({ children }) => {
    const [isNotificationPopupOpen, setisNotificationPopupOpen] =useState(false)
    const [notificationText, setnotificationText] = useState('')
    const [type, settype] = useState('')
    return (
        <ActionNotificationContext.Provider
            value={{
                isNotificationPopupOpen,
                setisNotificationPopupOpen,
                notificationText,
                setnotificationText,
                type,
                settype,
            }}
        >
            {children}
            <ActionNotificationCard
                text={notificationText}
                setnotificationText={setnotificationText}
                isNotificationPopupOpen={isNotificationPopupOpen}
                setisNotificationPopupOpen={setisNotificationPopupOpen}
                type={type}
                settype={settype}
            ></ActionNotificationCard>
        </ActionNotificationContext.Provider>
    )
}


export { ActionNotificationContext, ActionNotificationProvider }
