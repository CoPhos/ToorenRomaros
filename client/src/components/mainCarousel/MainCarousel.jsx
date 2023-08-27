import React, { Fragment, useRef, useCallback, useState } from 'react'
import arrow from '../../assests/arrow.png'
import styled from 'styled-components'
import Carousel from 'react-elastic-carousel'

function MainCarousel({
    breakPoints,
    pagination,
    slides,
    dimension,
    gradient,
    belowText,
    insideText,
    border,
}) {
    function iterateData(value, key) {
        const component = (
            <ImageContainer
                theme={{
                    img: value,
                    dimensionValue: dimension,
                    gradientValue: gradient,
                    borderValue: border,
                }}
            >
                {insideText && (
                    <ImageTextWrapper>
                        <RedBar></RedBar>
                        <TextContainer>
                            <p id="tittle">Text Tittle</p>
                            <p>
                                the youngest Gemthe youngest Gemthe youngest
                                Gemthe youngest Gem the youngest Gem the
                                youngest Gem the youngest Gemthe youngest Gemthe
                                youngest Gemthe youngest Gem the youngest Gem
                                the youngest Gem the youngest Gemthe youngest
                                Gemthe youngest Gemthe youngest Gem the youngest
                                Gem the youngest Gem the youngest Gemthe
                                youngest Gemthe youngest Gemthe youngest Gem the
                                youngest Gem the youngest Gem the youngest
                                Gemthe youngest Gemthe youngest Gemthe youngest
                                Gem the youngest Gem the youngest Gem the
                                youngest Gemthe youngest Gemthe youngest Gemthe
                                youngest Gem the youngest Gem the youngest Gem
                            </p>
                        </TextContainer>
                    </ImageTextWrapper>
                )}
            </ImageContainer>
        )
        if (!belowText) {
            return <Fragment key={key}>{component}</Fragment>
        } else {
            return (
                <Moviesdiv key={key}>
                    {component}
                    {belowText && <p>45% Civil war45% Civil war</p>}
                </Moviesdiv>
            )
        }
    }

    return (
        <Carousel
            disableArrowsOnEnd={false}
            itemPadding={[0, 8, 0, 8]}
            breakPoints={breakPoints}
            pagination={pagination}
        >
            {slides.map((value, key) => {
                return iterateData(value, key)
            })}
        </Carousel>
    )
}

const Moviesdiv = styled.div`
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: flex-start;
`

const ImageContainer = styled.div`
    display: flex;
    background-image: ${(props) => {
            if (props.theme.gradientValue) {
                return `linear-gradient(
            to bottom,
            rgba(255, 255, 255, 0.3),
            rgba(0, 0, 0, 0.8)
        ),`
            }
        }}
        url(http://localhost:3000${(props) => props.theme.img});
    @media only screen and (max-width: 800px) {
        min-width: ${(props) => props.theme.dimensionValue.mobile.width};
        min-height: ${(props) => props.theme.dimensionValue.mobile.height};
    }
    @media only screen and (min-width: 801px) {
        min-width: ${(props) => props.theme.dimensionValue.tablet.width};
        min-height: ${(props) => props.theme.dimensionValue.tablet.height};
    }
    @media only screen and (min-width: 1200px) {
        min-width: ${(props) => props.theme.dimensionValue.desktop.width};
        min-height: ${(props) => props.theme.dimensionValue.desktop.height};
    }
    border-radius: ${(props) => {
        if (!props.theme.borderValue) return ''
        else {
            return props.theme.borderValue
        }
    }};
    background-size: cover;
    background-repeat: no-repeat;
    background-position: center center;
    align-items: flex-end;
`
const ImageTextWrapper = styled.div`
    display: flex;
    flex-direction: row;
    align-items: flex-start;
    justify-content: flex-start;
    padding: 8px 8px;
`

const RedBar = styled.div`
    min-height: 122px;
    min-width: 4px;
    background-color: ${(props) => props.theme.colors.main};
`

const TextContainer = styled.div`
    min-height: 122px;
    padding-left: 8px;
    #tittle {
        font-size: ${(props) => props.theme.fontSizes.mh3};
        @media only screen and (min-width: 904px) {
            font-size: ${(props) => props.theme.fontSizes.h3};
        }
    }
    p {
        color: white;
        margin: 0;
        overflow: hidden;
        text-overflow: ellipsis;
        display: -webkit-box;
        -webkit-line-clamp: 2;
        -webkit-box-orient: vertical;
        -webkit-user-select: none;
        -ms-user-select: none;
        user-select: none;
        @media only screen and (min-width: 355px) {
            -webkit-line-clamp: 3;
        }
    }
`



export default MainCarousel
