import React from 'react'
import styled from 'styled-components'

function MainCarousel({slides}) {
    return (
        <Wrapper>
            <Arrow className="left">
                <i>{'<'}</i>
            </Arrow>
            {slides.map((value, key) => {
                return (
                    <ImageContainer key={key} theme={{img: value}}>
                    </ImageContainer>
                )
            })}
            <Arrow className="right">
                <i>{'>'}</i>
            </Arrow>
        </Wrapper>
    )}

const Wrapper = styled.div`
    display: flex;
    align-items: center;
    justify-content: flex-start;
    gap: 16px;
    height: 256px;
    width: 100vw;
    overflow: hidden;
    .left{
      left: 8px;
    }
    .right{
      right: 8px;
    }
`
const ImageContainer = styled.div`
    display: inline-block;
    background: linear-gradient(
        to bottom,
        rgba(0, 0, 0, 0) 0%,
        rgba(0, 0, 0, 0.65) 100%
    );
    background-image: url(${(props) => props.theme.img});
`


const Arrow = styled.div`
    display: flex;
    align-items: center;
    justify-content: center;
    border-radius: 50%;
    background-color: white;
    width: 40px;
    height: 40px;
    position: absolute;
    z-index: 1;
    i {
        font-size: ${(props) => props.theme.fontSizes.mh1};
    }
`

export default MainCarousel
