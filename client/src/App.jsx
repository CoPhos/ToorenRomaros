import React from 'react'
import { ThemeProvider } from 'styled-components'
import { colors } from './utils/globalStyles'
import { fontSizes } from './utils/globalStyles'
import { GlobalStyle } from './utils/globalStyles'
import NavbarContainer from './components/navbar/NavbarContainer'
import Footer from './components/footer/Footer'
import MobileNavMenu from './components/navbar/MobileNavMenu'

const theme = {
    colors: colors,
    fontSizes: fontSizes,
}

export default function App() {
    return (
        <ThemeProvider theme={theme}>
            <GlobalStyle />
            <NavbarContainer></NavbarContainer>
            <p>the younges Gem</p>
            <p>the younges Gem</p>
            <p>the younges Gem</p>
            <p>the younges Gem</p>
            <p>the younges Gem</p> <p>the younges Gem</p>
            <p>the younges Gem</p>
            <p>the younges Gem</p>
            <p>the younges Gem</p>
            <p>the younges Gem</p> <p>the younges Gem</p>
            <p>the younges Gem</p>
            <p>the younges Gem</p>
            <p>the younges Gem</p>
            <p>the younges Gem</p> <p>the younges Gem</p>
            <p>the younges Gem</p>
            <p>the younges Gem</p>
            <p>the younges Gem</p>
            <p>the younges Gem</p> <p>the younges Gem</p>
            <p>the younges Gem</p>
            <p>the younges Gem</p>
            <p>the younges Gem</p>
            <p>the younges Gem</p> <p>the younges Gem</p>
            <p>the younges Gem</p>
            <p>the younges Gem</p>
            <p>the younges Gem</p>
            <p>the younges Gem</p> <p>the younges Gem</p>
            <p>the younges Gem</p>
            <p>the younges Gem</p>
            <p>the younges Gem</p>
            <p>the younges Gem</p> <p>the younges Gem</p>
            <p>the younges Gem</p>
            <p>the younges Gem</p>
            <p>the younges Gem</p>
            <p>the younges Gem</p> <p>the younges Gem</p>
            <p>the younges Gem</p>
            <p>the younges Gem</p>
            <p>the younges Gem</p>
            <p>the younges Gem</p> <p>the younges Gem</p>
            <p>the younges Gem</p>
            <p>the younges Gem</p>
            <p>the younges Gem</p>
            <p>the younges Gem</p> <p>the younges Gem</p>
            <p>the younges Gem</p>
            <p>the younges Gem</p>
            <p>the younges Gem</p>
            <p>the younges Gem</p> <p>the younges Gem</p>
            <p>the younges Gem</p>
            <p>the younges Gem</p>
            <p>the younges Gem</p>
            <p>the younges Gem</p>
            <MobileNavMenu></MobileNavMenu>
            <Footer></Footer>
        </ThemeProvider>
    )
}
