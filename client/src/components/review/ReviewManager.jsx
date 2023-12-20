import React from 'react'
import ReviewContainer from './ReviewContainer';

function ReviewManager() {
    const rating = {
        values: {
            positive: 40,
            neutral: 20,
            negative: 8,
        },
        total: 68
    }
  return (
    <ReviewContainer rating={rating}></ReviewContainer>
  )
}

export default ReviewManager