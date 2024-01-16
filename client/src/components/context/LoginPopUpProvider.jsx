import React, { createContext, useState } from 'react'

const LoginPopUpContext = createContext()

const LoginPopUpProvider = ({ children }) => {
    const [isPopupOpen, setisPopupOpen] = useState(false)
    return (
        <LoginPopUpContext.Provider value={{ isPopupOpen, setisPopupOpen }}>
            {children}
        </LoginPopUpContext.Provider>
    )
}

export { LoginPopUpContext, LoginPopUpProvider }
