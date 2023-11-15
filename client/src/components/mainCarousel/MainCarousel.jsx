import React, { Fragment } from 'react'
import styled from 'styled-components'
import smiling from '../../assests/smiling.png'
import Carousel from 'react-elastic-carousel'
import Tittle from '../../utils/Tittle'
import { fontSizes } from '../../utils/globalStyles'
import { Link } from 'react-router-dom/cjs/react-router-dom.min';

function MainCarousel({
    breakPoints,
    pagination,
    slides,
    dimension,
    gradient,
    belowText,
    insideText,
    border,
    rating,
}) {
    const sizes = {
        tittleM: fontSizes.mh3,
        tittleD: fontSizes.h3,
        base: fontSizes.base,
    }
    return (
        <Carousel
            disableArrowsOnEnd={true}
            enableMouseSwipe={false}
            itemPadding={[0, 8, 0, 8]}
            breakPoints={breakPoints}
            pagination={pagination}
        >
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
        </Carousel>
    )
}

export function generateCard(
    value,
    key,
    dimension,
    gradient,
    border,
    belowText,
    rating,
    insideText,
    sizes
) {
    const component = (
        <StyledLink to="/film" draggable={false}>
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
                        <TextContainer>
                            <Tittle
                                tittle={insideText.tittle}
                                text={insideText.text}
                                sizes={sizes}
                            ></Tittle>
                        </TextContainer>
                    </ImageTextWrapper>
                )}
            </ImageContainer>
        </StyledLink>
    )

    if (!belowText) {
        return <Fragment key={key}>{component}</Fragment>
    } else {
        return (
            <Moviesdiv
                theme={{
                    dimensionValue: dimension,
                }}
                key={key}
            >
                {component}
                {belowText && (
                    <RatingContainer>
                        {rating && (
                            <RatingDiv>
                                <img src={smiling} width="16" height="16"></img>
                                <p className="left">85%</p>
                            </RatingDiv>
                        )}
                        <p>Captitan America: Winter Soldier</p>
                    </RatingContainer>
                )}
            </Moviesdiv>
        )
    }
}

const Moviesdiv = styled.div`
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: flex-start;
    @media only screen and (max-width: 800px) {
        min-width: ${(props) => props.theme.dimensionValue.mobile.width};
        min-height: ${(props) => props.theme.dimensionValue.mobile.height};
        max-width: ${(props) => props.theme.dimensionValue.mobile.maxWidth};
    }
    @media only screen and (min-width: 801px) {
        min-width: ${(props) => props.theme.dimensionValue.tablet.width};
        min-height: ${(props) => props.theme.dimensionValue.tablet.height};
        max-width: ${(props) => props.theme.dimensionValue.tablet.maxWidth};
    }
    @media only screen and (min-width: 1200px) {
        min-width: ${(props) => props.theme.dimensionValue.desktop.width};
        min-height: ${(props) => props.theme.dimensionValue.desktop.height};
        max-width: ${(props) => props.theme.dimensionValue.desktop.maxWidth};
    }
    &:hover {
        cursor:pointer;
        p:not(.notBlue) {
            color: #51a9ee;
        }
    }
`
const RatingContainer = styled.div`
    display: flex;
    flex-direction: column;
    width: 80%;
    p {
        margin: 0;
    }
    :hover,
    :focus {
        p {
            cursor: pointer;
            color: ${(props) => props.theme.colors.hyperlinks};
        }
    }
`
const RatingDiv = styled.div`
    display: flex;
    flex-direction: row;
    align-items: center;
    justify-content: flex-start;
    .left {
        margin-left: 4px;
        font-weight: bold;
    }
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
        max-width: ${(props) => props.theme.dimensionValue.mobile.maxWidth};
    }
    @media only screen and (min-width: 801px) {
        min-width: ${(props) => props.theme.dimensionValue.tablet.width};
        min-height: ${(props) => props.theme.dimensionValue.tablet.height};
        max-width: ${(props) => props.theme.dimensionValue.tablet.maxWidth};
    }
    @media only screen and (min-width: 1200px) {
        min-width: ${(props) => props.theme.dimensionValue.desktop.width};
        min-height: ${(props) => props.theme.dimensionValue.desktop.height};
        max-width: ${(props) => props.theme.dimensionValue.desktop.maxWidth};
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
    &:hover{
        cursor:pointer;}
`
const ImageTextWrapper = styled.div`
    display: flex;
    flex-direction: row;
    align-items: flex-start;
    justify-content: flex-start;
    padding: 8px 8px;
`
const TextContainer = styled.div`
    padding-left: 8px;
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

const StyledLink = styled(Link)`
    text-decoration: none;
    user-drag: none;
    user-select: none;
    -moz-user-select: none;
    -webkit-user-drag: none;
    -webkit-user-select: none;
    -ms-user-select: none;
`

export default MainCarousel
