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

const mainSlides = [
    '/mainCarouselDesktop.webp',
    '/mainCarouselDesktop.webp',
    '/mainCarouselDesktop.webp',
    '/mainCarouselDesktop.webp',
    '/mainCarouselDesktop.webp',
    '/mainCarouselDesktop.webp',
    '/mainCarouselDesktop.webp',
    '/mainCarouselDesktop.webp',
]

const moviesSlides = [
    '/placeholder2.jpg',
    '/placeholder2.jpg',
    '/placeholder2.jpg',
    '/placeholder2.jpg',
    '/placeholder2.jpg',
    '/placeholder2.jpg',
    '/placeholder2.jpg',
    '/placeholder2.jpg',
    '/placeholder2.jpg',
    '/placeholder2.jpg',
    '/placeholder2.jpg',
    '/placeholder2.jpg',
    '/placeholder2.jpg',
    '/placeholder2.jpg',
]

const mainSizes = {
    mobile: { height: 'calc(100vw * 0.665)', width: '100vw' },
    tablet: { height: 'calc((50vw - 8px) * 0.665)', width: 'calc(50vw - 8px)' },
    desktop: { height: '408px', width: '592px' },
}

const moviesSizes = {
    mobile: { height: '186px', width: '130px' },
    tablet: { height: '186px', width: '130px' },
    desktop: { height: '258px', width: '180px' },
}

const theme = {
    colors: colors,
    fontSizes: fontSizes,
}

export default function App() {
    return (
        <ThemeProvider theme={theme}>
            <GlobalStyle />
            <NavbarContainer></NavbarContainer>
            <MainCarouselContainer
                slides={mainSlides}
                dimension={mainSizes}
                insideText={true}
                belowText={false}
                gradient={true}
            ></MainCarouselContainer>
            <MainCarouselContainer
                slides={moviesSlides}
                dimension={moviesSizes}
                belowText={true}
                border={'8px'}
                gradient={false}
            ></MainCarouselContainer>
            {/* <CirlceRating cursor={1}></CirlceRating>
            <WhereWatch></WhereWatch>
            <RatingScore
                number={78}
                tittle={'User Score'}
                cursor={1}
            ></RatingScore>
            <RatingScoreOverall></RatingScoreOverall>
            <Review></Review> */}
            <MobileNavMenu></MobileNavMenu>
            <Footer></Footer>
        </ThemeProvider>
    )
}
