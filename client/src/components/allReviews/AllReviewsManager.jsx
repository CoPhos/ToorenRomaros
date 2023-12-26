import React from 'react'
import AllReviewsContainer from './AllReviewsContainer';

function AllReviewsManager() {
  const rating = {
      values: {
          positive: 40,
          neutral: 20,
          negative: 8,
      },
      total: 68,
  }
  return <AllReviewsContainer rating={rating}></AllReviewsContainer>
}

export default AllReviewsManager