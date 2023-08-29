import React from 'react'
import styled from 'styled-components'
import { generateCard } from '../mainCarousel/MainCarousel'
import { fontSizes } from '../../utils/globalStyles';

function NewsSection({
    slides,
    dimension,
    belowText,
    gradient,
    insideText,
    border,
    rating,
    sizes,
}) {
    return (
        <Wrapper>
            {slides.map((value, key) => {
                return generateCard(
                    value,
                    key,
                    dimension,
                    gradient,
                    border,
                    belowText,
                    rating,
                    insideText,
                    sizes
                )
            })}
        </Wrapper>
    )
}

const Wrapper = styled.div`
    display: flex;
    flex-direction: row;
    align-items: center;
    justify-content: center;
    flex-wrap: wrap;
    gap: 16px;
    margin: 0 16px;
`

export default NewsSection
