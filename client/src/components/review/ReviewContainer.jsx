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
}) {
    return (
        <div className="flex flex-col items-start justify-start gap-4 py-2 md:flex-row mt-4 px-1 lg:px-[0px]">
            <div className="flex flex-col items-start justify-center gap-2 grow">
                <div className="flex flex-col items-start justify-center">
                    <ReviewRating
                        tittle={'Super Reviews'}
                        totalScore={filmData.averageSuperRating}
                        data={superRatings}
                        viewAll={true}
                    ></ReviewRating>

                    <ReviewPanel
                        expand={false}
                        to={'/reviews/critic'}
                        data={reviews}
                        critic={true}
                    ></ReviewPanel>
                </div>
            </div>
            <div className="flex flex-col items-start justify-center gap-2 grow">
                <div className="flex flex-col items-start justify-center">
                    <ReviewRating
                        tittle={'User Reviews'}
                        totalScore={filmData.averageUserRating}
                        data={commonRatings}
                        viewAll={true}
                    ></ReviewRating>

                    <ReviewPanel
                        expand={true}
                        to={'/reviews/user'}
                        data={comments}
                        critic={false}
                    ></ReviewPanel>
                </div>
            </div>
        </div>
    )
}

export default ReviewContainer
