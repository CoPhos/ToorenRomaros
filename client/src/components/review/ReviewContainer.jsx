import React from 'react'
import ReviewCard from '../cards/filmData/ReviewCard'
import ReviewRating from '../cards/filmData/ReviewRating'
import ReviewPanel from './ReviewPanel';

function ReviewContainer({ rating }) {

    return (
        <div className="flex flex-col items-start justify-start gap-4 py-2 md:flex-row">
            <div className="flex flex-col items-start justify-center gap-2 grow">
                <div className="flex flex-col items-start justify-center">
                    <ReviewRating
                        tittle={'User Reviews'}
                        totalScore={65}
                        numberOfReviews={80}
                        rating={rating}
                    ></ReviewRating>

                    <ReviewPanel expand={false}></ReviewPanel>
                </div>
            </div>
            <div className="flex flex-col items-start justify-center gap-2 grow">
                <div className="flex flex-col items-start justify-center">
                    <ReviewRating
                        tittle={'User Reviews'}
                        totalScore={65}
                        numberOfReviews={80}
                        rating={rating}
                    ></ReviewRating>

                    <ReviewPanel expand={true}></ReviewPanel>
                </div>
            </div>
        </div>
    )
}

export default ReviewContainer
