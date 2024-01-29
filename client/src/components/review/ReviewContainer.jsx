import React from 'react'
import ReviewCard from '../cards/filmData/ReviewCard'
import ReviewRating from '../cards/filmData/ReviewRating'
import ReviewPanel from './ReviewPanel';

function ReviewContainer({
    filmData,
    commonRatings,
    superRatings,
    reviews,
    comments,
    uuid
}) {
    return (
        <div className="grid py-2 mt-4 px-1 items-start grid-cols-1 md:grid-cols-2 md:gap-4 lg:px-[0px]">
            <div className="flex flex-col items-start justify-center gap-2 grow">
                <div className="flex flex-col items-start justify-center w-full">
                    <ReviewRating
                        tittle={'Super Reviews'}
                        totalScore={filmData.averageSuperRating}
                        data={superRatings}
                        viewAll={true}
                        to={'reviews?super=true&rating=all&order=rating'}
                    ></ReviewRating>

                    <ReviewPanel
                        expand={false}
                        to={'reviews?super=true&rating=all&order=rating'}
                        data={reviews}
                        critic={true}
                    ></ReviewPanel>
                </div>
            </div>
            <div className="flex flex-col items-start justify-center gap-2 grow">
                <div className="flex flex-col items-start justify-center w-full">
                    <ReviewRating
                        tittle={'User Reviews'}
                        totalScore={filmData.averageUserRating}
                        data={commonRatings}
                        viewAll={true}
                        to={'reviews?super=false&rating=all&order=rating'}
                    ></ReviewRating>

                    <ReviewPanel
                        expand={true}
                        to={'reviews?super=false&rating=all&order=rating'}
                        data={comments}
                        critic={false}
                    ></ReviewPanel>
                </div>
            </div>
        </div>
    )
}

export default ReviewContainer
