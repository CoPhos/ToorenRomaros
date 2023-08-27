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
    mobile: { height: '280px', width: '100%' },
    tablet: { height: '340px', width: '50%' },
    desktop: { height: '408px', width: '50%' },
}

const moviesSizes = {
    mobile: { height: '186px', width: '125px' },
    tablet: { height: '186px', width: '130px' },
    desktop: { height: '258px', width: '180px' },
}

const theme = {
    colors: colors,
    fontSizes: fontSizes,
}

const breakPointsMovie = [
    { width: 1, itemsToShow: 2, itemsToScroll: 2 },
    { width: 420, itemsToShow: 3, itemsToScroll: 3 },
    { width: 600, itemsToShow: 4, itemsToScroll: 4 },
    { width: 1000, itemsToShow: 5, itemsToScroll: 5 },
]
const breakPointsMain = [
    { width: 1, itemsToShow: 1, itemsToScroll: 1 },
    { width: 470, itemsToShow: 2, itemsToScroll: 2 },
]


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
                breakPoints={breakPointsMain}
                pagination={true}
            ></MainCarouselContainer>
            <MainCarouselContainer
                slides={moviesSlides}
                dimension={moviesSizes}
                belowText={true}
                gradient={false}
                breakPoints={breakPointsMovie}
                pagination={false}
                border={'8px'}
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
