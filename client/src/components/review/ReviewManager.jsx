import React from 'react'
import ReviewContainer from './ReviewContainer';

function ReviewManager() {
    const rating = {
        values: {
            positive: 40,
            neutral: 8,
            negative: 8,
        },
        total: 56
    }
  return (
    <ReviewContainer rating={rating}></ReviewContainer>
  )
}

export default ReviewManager