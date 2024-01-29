import React from 'react'
import { Link, useLocation } from 'react-router-dom'
import VideoManager from '../videoPlayer/VideoManager'
import MainRatingScore from '../cards/mainRatingScore/MainRatingScore'
import PostRatingManager from '../postRating/PostRatingManager'
import TittleCard from '../cards/tittle/TittleCard'

function FilmMainInfoContainer({ data, commonRatings, superRatings }) {
    const location = useLocation()
    const pathname = location.pathname
    const component = (
        <>
            <TittleCard
                tittle={'Critics Consensus'}
                to={null}
                linkText={''}
            ></TittleCard>
            <p className="mt-1 text-small-m-400 lg:text-small-d-400">
                {data.criticsConsensus}&nbsp;
                <Link
                    to={`${pathname}/reviews?super=false&rating=all&order=rating`}
                    className="hover:cursor-pointer text-blue-800 hover:text-blue-600"
                >
                    Read critic reviews
                </Link>
            </p>
        </>
    )

    return (
        <div className="flex flex-col items-center justify-center grow p-1 lg:grid lg:grid-cols-[1fr,412px] lg:grid-rows-1 lg:gap-4 lg:items-start">
            <div className="w-full">
                <VideoManager></VideoManager>
                <div className="w-full hidden lg:block mt-2">{component}</div>
            </div>

            <div className="w-full">
                <div className="mt-2 pb-2 border-b-[1px] border-white-200 w-full">
                    <p className="text-[36px] font-bold ">{data.tittle}</p>
                </div>

                <MainRatingScore
                    data={superRatings}
                    totalScore={data.averageSuperRating}
                    to={'reviews?super=true&rating=all&order=rating'}
                ></MainRatingScore>
                <MainRatingScore
                    data={commonRatings}
                    totalScore={data.averageUserRating}
                    to={'reviews?super=false&rating=all&order=rating'}
                ></MainRatingScore>

                <PostRatingManager></PostRatingManager>
            </div>

            <div className="w-full lg:hidden">{component}</div>
        </div>
    )
}

export default FilmMainInfoContainer
