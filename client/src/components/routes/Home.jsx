import React, {Fragment} from 'react'

//components
import MainCarouselManager from '../mainCarousel/MainCarouselManager'
import SimpleTopContainer from '../SimpleTop/SimpleTopContainer'
import NewsSectionContainer from '../News&Blog/NewsSectionContainer'
import ButtonCreatePostManager from '../button/ButtonCreatePostManager'
import MovieCard from '../cards/movieCard/MovieCard'

//utils
import { fontSizes } from '../../utils/globalStyles'
import Tittle from '../../utils/Tittle'

function Home() {
    //slides
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
    const guidesSlides = [
        '/news1.JPG',
        '/news2.JPG',
        '/news1.JPG',
        '/news2.JPG',
        '/news1.JPG',
        '/news2.JPG',
    ]
    const newsSlides = [
        '/img1.JPG',
        '/img2.JPG',
        '/img3.JPG',
        '/img1.JPG',
        '/img2.JPG',
        '/img3.JPG',
        '/img2.JPG',
        '/img1.JPG',
    ]
    //sizes
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
    const guidesSizes = {
        mobile: { height: '380px', width: '100%' },
        tablet: { height: '145px', width: '257px' },
        desktop: { height: '145px', width: '257px' },
    }
    const newsSizes = {
        mobile: { height: '154px', width: '284px', maxWidth: '284px' },
        tablet: { height: '154px', width: '284px', maxWidth: '284px' },
        desktop: { height: '154px', width: '284px', maxWidth: '284px' },
    }
    //breakpoints
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
    const breakPointsNews = [
        { width: 1, itemsToShow: 1, itemsToScroll: 1 },
        { width: 781, itemsToShow: 3, itemsToScroll: 3 },
        { width: 1100, itemsToShow: 4, itemsToScroll: 4 },
    ]
   
    const insideText = {
        tittle: 'TITTLE',
        text: `the youngest Gemthe youngest Gemthe youngest Gemthe
                            youngest Gem the youngest Gem the youngest Gem the
                            youngest Gemthe youngest Gemthe youngest Gemthe
                            youngest Gem the youngest Gem the youngest Gem the
                            youngest Gemthe youngest Gemthe youngest Gemthe
                            youngest Gem the youngest Gem the youngest Gem the
                            youngest Gemthe youngest Gemthe youngest Gemthe
                            youngest Gem the youngest Gem the youngest Gem the
                            youngest Gemthe youngest Gemthe youngest Gemthe
                            youngest Gem the youngest Gem the youngest Gem the
                            youngest Gemthe youngest Gemthe youngest Gemthe
                            youngest Gem the youngest Gem the youngest Gem`,
    }
    return (
        <Fragment>
            <ButtonCreatePostManager></ButtonCreatePostManager>
            <MovieCard></MovieCard>
            {/* <MainCarouselManager
                slides={mainSlides}
                dimension={mainSizes}
                insideText={insideText}
                belowText={false}
                gradient={true}
                breakPoints={breakPointsMain}
                pagination={true}
                rating={true}
            ></MainCarouselManager>
            <Tittle
                tittle={'NEW & UPCOMING MOVIES IN THEATERS'}
                margin={'48px 0 16px 16px'}
            ></Tittle>
            <MainCarouselManager
                slides={moviesSlides}
                dimension={moviesSizes}
                belowText={true}
                gradient={false}
                breakPoints={breakPointsMovie}
                pagination={false}
                border={'8px'}
                rating={true}
            ></MainCarouselManager>
            <Tittle
                tittle={'NEW & UPCOMING ON STREAMING'}
                margin={'48px 0 16px 16px'}
            ></Tittle>
            <MainCarouselManager
                slides={moviesSlides}
                dimension={moviesSizes}
                belowText={true}
                gradient={false}
                breakPoints={breakPointsMovie}
                pagination={false}
                border={'8px'}
                rating={true}
            ></MainCarouselManager>
            <Tittle
                tittle={'HULU HAS MOVIES'}
                margin={'48px 0 16px 16px'}
            ></Tittle>
            <MainCarouselManager
                slides={moviesSlides}
                dimension={moviesSizes}
                belowText={true}
                gradient={false}
                breakPoints={breakPointsMovie}
                pagination={false}
                border={'8px'}
                rating={true}
            ></MainCarouselManager>
            <SimpleTopContainer></SimpleTopContainer>
            <Tittle
                tittle={'POPULAR IN THEATERS'}
                margin={'48px 0 16px 16px'}
            ></Tittle>
            <MainCarouselManager
                slides={moviesSlides}
                dimension={moviesSizes}
                belowText={true}
                gradient={false}
                breakPoints={breakPointsMovie}
                pagination={false}
                border={'8px'}
                rating={true}
            ></MainCarouselManager>
            <Tittle
                tittle={'ESSENTIAL ROAD TRIP MOVIES'}
                margin={'48px 0 16px 16px'}
            ></Tittle>
            <MainCarouselManager
                slides={moviesSlides}
                dimension={moviesSizes}
                belowText={true}
                gradient={false}
                breakPoints={breakPointsMovie}
                pagination={false}
                border={'8px'}
                rating={true}
            ></MainCarouselManager>
            <Tittle
                tittle={'ESSENTIAL HIGH SCHOOL MOVIES'}
                margin={'48px 0 16px 16px'}
            ></Tittle>
            <MainCarouselManager
                slides={moviesSlides}
                dimension={moviesSizes}
                belowText={true}
                gradient={false}
                breakPoints={breakPointsMovie}
                pagination={false}
                border={'8px'}
                rating={true}
            ></MainCarouselManager>
            <Tittle
                tittle={'TRAILERS & BLOG'}
                margin={'48px 0 16px 16px'}
            ></Tittle>
            <NewsSectionContainer
                slides={newsSlides}
                dimension={newsSizes}
                belowText={true}
                gradient={false}
                insideText={{ tittle: 'Interview' }}
                border={'8px'}
                rating={false}
                sizes={{
                    tittleM: fontSizes.mh6,
                    tittleD: fontSizes.h6,
                    base: fontSizes.base,
                }}
            ></NewsSectionContainer>
            <Tittle
                tittle={'MOVIE & TV GUIDES'}
                margin={'48px 0 16px 16px'}
            ></Tittle>
            <MainCarouselManager
                slides={guidesSlides}
                dimension={guidesSizes}
                belowText={true}
                gradient={false}
                breakPoints={breakPointsNews}
                pagination={false}
                border={'8px'}
                rating={false}
            ></MainCarouselManager> */}
        </Fragment>
    )
}

export default Home