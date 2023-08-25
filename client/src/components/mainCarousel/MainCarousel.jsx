import React, { Fragment, useRef } from 'react'
import arrow from '../../assests/arrow.png'
import styled from 'styled-components'

function MainCarousel({ slides, border, dimension, belowText, insideText, gradient }) {
    const ref = useRef(null)
    const slide = useRef(0)
    const width = useRef(null)
    const rightDirection = useRef(null)
    let isDragging = false

    window.addEventListener('touchend', function (e) {
        isDragging = false
    })

    function dragging(e) {
        if (!isDragging) {
            return
        }
        moveSlides(rightDirection.current)
    }

    function direction(e) {
        if (e.movementX == -4) {
            rightDirection.current = true
        } else if (e.movementX == 4) {
            rightDirection.current = false
        }
    }

    function moveSlides(right) {
        if (right) {
            const cardPerSlide = Math.ceil(
                ref.current.clientWidth / (width.current.clientWidth + 16)
            )
            console.log(cardPerSlide)
            const maxWidth =
                (width.current.clientWidth + 16) * slides.length -
                (width.current.clientWidth + 16) * cardPerSlide

            if (ref.current.scrollLeft >= maxWidth) {
                slide.current = 0
                ref.current.scrollTo({
                    top: 0,
                    left: 0,
                    behavior: 'smooth',
                })
            } else {
                slide.current++
                ref.current.scrollTo({
                    top: 0,
                    left: (ref.current.clientWidth + 16) * slide.current,
                    behavior: 'smooth',
                })
            }
        } else if (!right) {
            if (slide.current == 0) {
                return
            } else {
                ref.current.scrollTo({
                    top: 0,
                    left:
                        (ref.current.clientWidth + 16) * slide.current -
                        (ref.current.clientWidth + 16),
                    behavior: 'smooth',
                })
                slide.current--
            }
        }
    }
    function iterateData(value, key) {
        const component = (
            <ImageContainer
                ref={width}
                theme={{
                    img: value,
                    borderValue: border,
                    dimensionValue: dimension,
                    gradientValue: gradient,
                }}
            >
                {insideText && (
                    <ImageTextWrapper>
                        <RedBar>
                        </RedBar>
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
        <Wrapper>
            <Arrow className="left">
                <img src={arrow} onClick={() => moveSlides(false)}></img>
            </Arrow>
            <Div
                ref={ref}
                onPointerMove={(e) => direction(e)}
                onTouchStart={() => (isDragging = true)}
                onTouchEnd={(e) => dragging(e)}
            >
                {slides.map((value, key) => {
                    return iterateData(
                        value,
                        key,
                    )
                })}
            </Div>
            <Arrow className="right">
                <img src={arrow} onClick={() => moveSlides(true)}></img>
            </Arrow>
        </Wrapper>
    )
}

const Wrapper = styled.div`
    display: flex;
    align-items: center;
    justify-content: flex-start;
    margin-top: 16px;
    .left {
        left: 8px;
    }
    .right {
        right: 8px;
        transform: rotate(180deg);
    }
    img {
        -webkit-user-select: none;
        -ms-user-select: none;
        user-select: none;
    }
`
const Moviesdiv = styled.div`
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: flex-start;
`

const Div = styled.div`
    display: flex;
    align-items: center;
    justify-content: flex-start;
    overflow-x: hidden;
    scroll-behavior: smooth;
    gap: 16px;
    touch-action: none;
    p {
        margin: 0;
        overflow: hidden;
        text-overflow: ellipsis;
        display: -webkit-box;
        -webkit-line-clamp: 2;
        -webkit-box-orient: vertical;
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


const Arrow = styled.div`
    display: flex;
    align-items: center;
    justify-content: center;
    border-radius: 50%;
    @media only screen and (max-width: 904px) {
        display: none;
    }
    width: 40px;
    height: 40px;
    position: absolute;
    z-index: 0;
    background-color: white;
    img {
        cursor: pointer;
    }
`

export default MainCarousel
