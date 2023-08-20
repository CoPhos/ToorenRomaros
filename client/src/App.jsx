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
import CirlceRating from './components/rating/CirlceRating'
import WhereWatch from './components/whereWatch/WhereWatch'
import RatingScore from './components/ratingScore/RatingScore'
import RatingScoreOverall from './components/ratingScore/RatingScoreOverall'
import Review from './components/review/Review'

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
            <CirlceRating cursor={1}></CirlceRating>
            <WhereWatch></WhereWatch>
            <RatingScore number={78} tittle={'User Score'} cursor={1}></RatingScore>
            <RatingScoreOverall></RatingScoreOverall>
            <Review></Review>

            <MobileNavMenu></MobileNavMenu>
            <Footer></Footer>
        </ThemeProvider>
    )
}
