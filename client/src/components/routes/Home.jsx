import React, {Fragment} from 'react'

//components
import ButtonCreatePostManager from '../button/ButtonCreatePostManager'

//utils
import TittleCard from '../cards/tittle/TittleCard'
import SpotlightCarouselManager from '../spotlightCarousel/SpotlightCarouselManager';
import RegularCarouselManager from '../regularCarousel/RegularCarouselManager';
import TopFilmsManager from '../SimpleTop/TopFilmsManager';
import VideosTopManager from '../videosTop/VideosTopManager';
import BlogTopManager from '../blogTop/BlogTopManager';

function Home() {
    return (
        <Fragment>
            <SpotlightCarouselManager></SpotlightCarouselManager>

            <TittleCard
                tittle={'NEW & UPCOMING MOVIES IN THEATERS'}
                to={'/adasd'}
                linkText={'View all'}
            ></TittleCard>
            <RegularCarouselManager
                parameters={'?atStreaming=0&page=0&size=10'}
            ></RegularCarouselManager>

            <TittleCard
                tittle={'NEW & UPCOMING MOVIES IN THEATERS'}
                to={'/adasd'}
                linkText={'View all'}
            ></TittleCard>
            <RegularCarouselManager
                parameters={'?atStreaming=0&page=0&size=10'}
            ></RegularCarouselManager>

            <div className="grid grid-cols-1 sm:grid-cols-2 gap-y-4 gap-x-2 lg:gap-y-4 lg:gap-x-[128px] mb-3">
                <TopFilmsManager
                    tittle={'MOST POPULAR TV ON RT'}
                    to={'/adasd'}
                    linkText={'View all'}
                ></TopFilmsManager>
                <TopFilmsManager
                    tittle={'POPULAR STREAMING MOVIES'}
                    to={'/adasd'}
                    linkText={'View all'}
                ></TopFilmsManager>
                <TopFilmsManager
                    tittle={'NEW TV THIS WEEK'}
                    to={'/adasd'}
                    linkText={'View all'}
                ></TopFilmsManager>
                <TopFilmsManager
                    tittle={'NEW & UPCOMING MOVIES IN THEATERS'}
                    to={'/adasd'}
                    linkText={'View all'}
                ></TopFilmsManager>
            </div>

            <TittleCard
                tittle={'NEW & UPCOMING MOVIES IN THEATERS'}
                to={'/adasd'}
                linkText={'View all'}
            ></TittleCard>
            <RegularCarouselManager
                parameters={'?atStreaming=0&page=0&size=10'}
            ></RegularCarouselManager>

            <TittleCard
                tittle={'NEW & UPCOMING MOVIES IN THEATERS'}
                to={'/adasd'}
                linkText={'View all'}
            ></TittleCard>
            <RegularCarouselManager
                parameters={'?atStreaming=0&page=0&size=10'}
            ></RegularCarouselManager>

            <TittleCard
                tittle={'NEW & UPCOMING MOVIES IN THEATERS'}
                to={'/adasd'}
                linkText={'View all'}
            ></TittleCard>
            <RegularCarouselManager
                parameters={'?atStreaming=0&page=0&size=10'}
            ></RegularCarouselManager>

            <TittleCard
                tittle={'TRAILERS & VIDEOS'}
                to={'/adasd'}
                linkText={'View all'}
            ></TittleCard>
            <VideosTopManager></VideosTopManager>

            <TittleCard
                tittle={'FROM OUR BLOG'}
                to={'/adasd'}
                linkText={'View all'}
            ></TittleCard>
            <BlogTopManager></BlogTopManager>

            <ButtonCreatePostManager></ButtonCreatePostManager>
        </Fragment>
    )
}

export default Home