import React from 'react'
import ReviewCard from '../cards/filmData/ReviewCard'
import ReviewRating from '../cards/filmData/ReviewRating'
import ReviewPanel from './ReviewPanel';

function ReviewContainer({ rating }) {

    return (
        <div className="flex flex-col items-start justify-start gap-4 py-2 md:flex-row mt-4 px-1 lg:px-[0px]">
            <div className="flex flex-col items-start justify-center gap-2 grow">
                <div className="flex flex-col items-start justify-center">
                    <ReviewRating
                        tittle={'User Reviews'}
                        totalScore={65}
                        numberOfReviews={80}
                        rating={rating}
                        viewAll={true}
                    ></ReviewRating>

                    <ReviewPanel
                        expand={false}
                        to={'/reviews/critic'}
                    ></ReviewPanel>
                </div>
            </div>
            <div className="flex flex-col items-start justify-center gap-2 grow">
                <div className="flex flex-col items-start justify-center">
                    <ReviewRating
                        tittle={'User Reviews'}
                        totalScore={65}
                        numberOfReviews={80}
                        rating={rating}
                        viewAll={true}
                    ></ReviewRating>

                    <ReviewPanel
                        expand={true}
                        to={'/reviews/user'}
                    ></ReviewPanel>
                </div>
            </div>
        </div>
    )
}

export default ReviewContainer
