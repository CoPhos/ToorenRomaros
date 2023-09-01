import React from 'react'

import RatingScoreOverall from '../ratingScore/RatingScoreOverall'
import Review from '../review/Review'
import RatingScore from '../ratingScore/RatingScore'

import styled from 'styled-components'
function ReviewsContainer() {
    return (
        <Wrapper>
            <Container>
                <RatingScore
                    number={78}
                    tittle={'User Score'}
                    cursor={1}
                ></RatingScore>
                <RatingScoreOverall></RatingScoreOverall>
                <Review></Review>
                <Review></Review>
                <Review></Review>
                <Review></Review>
                <Review></Review>
                <Review></Review>
                <Review></Review>
                <Review></Review>
            </Container>
            <Container>
                <RatingScore
                    number={98}
                    tittle={'User Score'}
                    cursor={1}
                ></RatingScore>
                <RatingScoreOverall></RatingScoreOverall>
                <Review expand={true}></Review>
                <Review expand={true}></Review> 
                <Review expand={true}></Review>
                <Review expand={true}></Review> 
                <Review expand={true}></Review>
                <Review expand={true}></Review> 
                <Review expand={true}></Review>
                <Review expand={true}></Review> 
                <Review expand={true}></Review>
                <Review expand={true}></Review> 
                <Review expand={true}></Review>
            </Container>
        </Wrapper>
    )
}

const Wrapper = styled.div`
    display: flex;
    flex-direction: row;
    align-items: flex-start;
    justify-content: flex-start;
    gap: 32px;
    max-width: 1200px;
    padding: 0 16px;
    @media only screen and (max-width: 700px) {
        flex-direction: column;
    }
`

const Container = styled.div`
    display: flex;
    flex-direction: column;
    gap: 16px;
    align-items: flex-start;
    justify-content: center;
    @media only screen and (min-width: 1100px) {
        width: 300px;
    }
`

export default ReviewsContainer
