import React, {Fragment} from 'react'

//components

//utils
import TittleCard from '../cards/tittle/TittleCard'
import SpotlightCarouselManager from '../spotlightCarousel/SpotlightCarouselManager';
import RegularCarouselManager from '../regularCarousel/RegularCarouselManager';
import TopFilmsManager from '../SimpleTop/TopFilmsManager';
import VideosTopManager from '../videosTop/VideosTopManager';


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
                parameters={
                    '?atTheaters=1&orderBy=added_date-asc&page=0&size=15'
                }
                queryName={'NewMovies'}
                promiseName={'NewMoviesImages'}
            ></RegularCarouselManager>

            <TittleCard
                tittle={'NEW & UPCOMING TV SERIES'}
                to={'/adasd'}
                linkText={'View all'}
            ></TittleCard>
            <RegularCarouselManager
                parameters={
                    '?filmType=2&atStreaming=1&orderBy=added_date-asc&page=0&size=15'
                }
                queryName={'NewTvSeries'}
                promiseName={'NewTvSeriesImages'}
            ></RegularCarouselManager>

            <div className="grid grid-cols-1 sm:grid-cols-2 gap-y-4 gap-x-2 lg:gap-y-4 lg:gap-x-[128px] mb-3">
                <TopFilmsManager
                    tittle={'MOST POPULAR TV ON RT'}
                    to={'/browse?filmType=all&sortBy=view_count-Desc'}
                    linkText={'View all'}
                    parameters={
                        '?filmType=all&sortBy=view_count-Desc&page=0&size=10'
                    }
                    queryName={'popularOnRt'}
                ></TopFilmsManager>

                <TopFilmsManager
                    tittle={'POPULAR STREAMING MOVIES'}
                    to={'/browse?at=home&filmType=1&sortBy=view_count-Desc'}
                    linkText={'View all'}
                    parameters={
                        '?at=home&filmType=1&sortBy=view_count-Desc&page=0&size=10'
                    }
                    queryName={'popularStreaming'}
                ></TopFilmsManager>

                <TopFilmsManager
                    tittle={'NEW TV THIS WEEK'}
                    to={
                        '/browse?at=upcoming&filmType=all&sortBy=added_date-Desc'
                    }
                    linkText={'View all'}
                    parameters={
                        '?at=upcoming&filmType=all&sortBy=added_date-Desc&page=0&size=10'
                    }
                    queryName={'newThisWeek'}
                ></TopFilmsManager>

                <TopFilmsManager
                    tittle={'NEW & UPCOMING MOVIES IN THEATERS'}
                    to={'/browse?at=upcoming&filmType=1'}
                    linkText={'View all'}
                    parameters={'?at=upcoming&filmType=1&page=0&size=10'}
                    queryName={'newAndUpcomingAtTheaters'}
                ></TopFilmsManager>
            </div>

            <TittleCard
                tittle={'POPULAR MOVIES AT THEATERS'}
                to={'/adasd'}
                linkText={'View all'}
            ></TittleCard>
            <RegularCarouselManager
                parameters={
                    '?filmType=1&atTheaters=1&orderBy=view_count-asc&page=0&size=15'
                }
                queryName={'popularMoviesAtTheaters'}
                promiseName={'popularMoviesAtTheatersImages'}
            ></RegularCarouselManager>

            <TittleCard
                tittle={'LATEST CERTIFIED FRESH MOVIES'}
                to={'/adasd'}
                linkText={'View all'}
            ></TittleCard>
            <RegularCarouselManager
                parameters={
                    '?filmType=1&orderBy=average_super_rating-desc,view_count-desc&page=0&size=15'
                }
                queryName={'latestCertified'}
                promiseName={'latestCertifiedImages'}
            ></RegularCarouselManager>

            <TittleCard tittle={'FROM OUR BLOG'}></TittleCard>
            <VideosTopManager
                query={`?latest=true&size=4`}
                queryName={'latesPost'}
            ></VideosTopManager>
        </Fragment>
    )
}

export default Home