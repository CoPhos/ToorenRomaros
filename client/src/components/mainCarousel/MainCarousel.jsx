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
                    <ImageContainer key={key} theme={{ img: value }}>
                        <p>
                            the youngest Gemthe youngest Gemthe youngest Gemthe
                            youngest Gem the youngest Gem the youngest Gem
                        </p>
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
    overflow: hidden;
    margin-top: 16px;
    .left {
        left: 8px;
    }
    .right {
        right: 8px;
    }
`
const ImageContainer = styled.div`
    display: flex;
    background-image: linear-gradient(
            to bottom,
            rgba(255, 255, 255, 0.3),
            rgba(0, 0, 0, 0.8)
        ),
        url(http://localhost:3000${(props) => props.theme.img});
    min-width: 384px;
    min-height: 256px;
    align-items: flex-end;
    p {
        color: white;
        margin: 0 8px;
        overflow: hidden;
        text-overflow: ellipsis;
        display: -webkit-box;
        -webkit-line-clamp: 4;
        -webkit-box-orient: vertical;
    }
`


const Arrow = styled.div`
    display: flex;
    align-items: center;
    justify-content: center;
    border-radius: 50%;
    width: 40px;
    height: 40px;
    position: absolute;
    z-index: 0;
    background-color: grey;
    &:hover {
        background-color: white;
        i {
            color:black;
        }
    }
    i {
        cursor:pointer;
        color: white;
        font-size: ${(props) => props.theme.fontSizes.mh1};
    }
`

export default MainCarousel
