import React from 'react'
import { ThemeProvider } from 'styled-components'
import { colors } from './utils/globalStyles'
import { fontSizes } from './utils/globalStyles'
import { GlobalStyle } from './utils/globalStyles'

//components
import NavbarContainer from './components/navbar/NavbarContainer'
import Footer from './components/footer/Footer'
import MobileNavMenu from './components/navbar/MobileNavMenu'
import MainCarouselContainer from './components/mainCarousel/MainCarouselContainer'

const theme = {
    colors: colors,
    fontSizes: fontSizes,
}

export default function App() {
    return (
        <ThemeProvider theme={theme}>
            <GlobalStyle />
            <NavbarContainer></NavbarContainer>
            <MainCarouselContainer></MainCarouselContainer>
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
