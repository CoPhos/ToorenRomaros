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
                to={'/browse?at=theaters&filmType=all&sortBy=added_date-Desc'}
                linkText={'View all'}
            ></TittleCard>
            <RegularCarouselManager
                parameters={
                    '?atTheaters=1&genres=&suitableFor=&streamId=&orderBy=added_date-Desc&size=15'
                }
                queryName={'NewMovies'}
                promiseName={'NewMoviesImages'}
            ></RegularCarouselManager>

            <TittleCard
                tittle={'NEW & UPCOMING TV SERIES'}
                to={'/browse?at=home&filmType=2&sortBy=added_date-Desc'}
                linkText={'View all'}
            ></TittleCard>
            <RegularCarouselManager
                parameters={
                    '?atStreaming=1&filmType=2&genres=&suitableFor=&streamId=&orderBy=added_date-Desc&size=15'
                }
                queryName={'NewTvSeries'}
                promiseName={'NewTvSeriesImages'}
            ></RegularCarouselManager>

            <div className="grid grid-cols-1 sm:grid-cols-2 gap-y-4 gap-x-2 lg:gap-y-4 lg:gap-x-[128px] mb-3">
                <TopFilmsManager
                    tittle={'MOST POPULAR TV ON RT'}
                    to={'/browse?at=home&filmType=all&sortBy=view_count-Desc'}
                    linkText={'View all'}
                    parameters={
                        '?atStreaming=1&genres=&suitableFor=&streamId=&orderBy=view_count-Desc&size=10'
                    }
                    queryName={'popularOnRt'}
                ></TopFilmsManager>

                <TopFilmsManager
                    tittle={'ADULTS ONLY POPULAR TV SHOWS'}
                    to={
                        '/browse?at=home&filmType=2&sortBy=view_count-Desc&rating=PG-18'
                    }
                    linkText={'View all'}
                    parameters={
                        '?&atStreaming=1&filmType=2&genres=&suitableFor=PG-18&streamId=&orderBy=view_count-Desc&size=10'
                    }
                    queryName={'popularStreaming'}
                ></TopFilmsManager>

                <TopFilmsManager
                    tittle={'NEW TV THIS WEEK'}
                    to={'/browse?at=tv&filmType=all&sortBy=added_date-Desc'}
                    linkText={'View all'}
                    parameters={
                        '?genres=&suitableFor=&streamId=&orderBy=added_date-Desc&size=10'
                    }
                    queryName={'newThisWeek'}
                ></TopFilmsManager>

                <TopFilmsManager
                    tittle={'POPULAR MOVIES FOR ALL AGES'}
                    to={
                        '/browse?at=home&filmType=1&sortBy=view_count-Desc&rating=G'
                    }
                    linkText={'View all'}
                    parameters={
                        '?&atStreaming=1&filmType=1&genres=&suitableFor=G&streamId=&orderBy=view_count-Desc&size=10'
                    }
                    queryName={'newAndUpcomingAtTheaters'}
                ></TopFilmsManager>
            </div>

            <TittleCard
                tittle={'POPULAR MOVIES AT THEATERS'}
                to={'/browse?at=theaters&filmType=all&sortBy=view_count-Desc'}
                linkText={'View all'}
            ></TittleCard>
            <RegularCarouselManager
                parameters={
                    '?atTheaters=1&genres=&suitableFor=&streamId=&orderBy=view_count-Desc&size=15'
                }
                queryName={'popularMoviesAtTheaters'}
                promiseName={'popularMoviesAtTheatersImages'}
            ></RegularCarouselManager>

            <TittleCard
                tittle={'LATEST CERTIFIED FRESH MOVIES'}
                to={
                    '/browse?at=home&filmType=1&sortBy=average_super_rating-Desc'
                }
                linkText={'View all'}
            ></TittleCard>
            <RegularCarouselManager
                parameters={
                    '?&atStreaming=1&filmType=1&genres=&suitableFor=&streamId=&orderBy=average_super_rating-Desc&size=15'
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