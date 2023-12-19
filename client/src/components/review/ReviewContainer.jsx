import React from 'react'
import ReviewCard from '../cards/filmData/ReviewCard';
import ReviewRating from '../cards/filmData/ReviewRating';

function ReviewContainer({rating}) {
  return (
      <div className="flex flex-col items-start justify-start gap-4 py-2 md:flex-row">
          <div className="flex flex-col items-start justify-center gap-2 grow">
              <ReviewRating
                  tittle={'Critic Reviews'}
                  totalScore={88}
                  numberOfReviews={24}
                  rating={rating}
              ></ReviewRating>
              <ReviewCard></ReviewCard>
              <ReviewCard></ReviewCard>
              <ReviewCard></ReviewCard>
              <ReviewCard></ReviewCard>
              <ReviewCard></ReviewCard>
          </div>
          <div className="flex flex-col items-start justify-center gap-2 grow">
              <ReviewRating
                  tittle={'User Reviews'}
                  totalScore={65}
                  numberOfReviews={80}
                  rating={rating}
              ></ReviewRating>
              <ReviewCard expand={true}></ReviewCard>
              <ReviewCard expand={true}></ReviewCard>
              <ReviewCard expand={true}></ReviewCard>
              <ReviewCard expand={true}></ReviewCard>
              <ReviewCard expand={true}></ReviewCard>
          </div>
      </div>
  )
}

export default ReviewContainer