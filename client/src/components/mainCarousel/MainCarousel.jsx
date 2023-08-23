import React, { Fragment, useRef, useState } from 'react'
import styled from 'styled-components'

function MainCarousel({ slides, type }) {
    const ref = useRef(null)
    const slide = useRef(0)
    const width = useRef(null)
    const rightDirection = useRef(null);
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

    function direction(e){
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
    function iterateData(value, key, type) {
        if (type == 'main') {
            return (
                <Fragment key={key}>
                    <ImageContainer
                        ref={width}
                        theme={{ img: value }}
                        type={{ value: type }}
                    >
                        {type == 'main' && (
                            <p>
                                the youngest Gemthe youngest Gemthe youngest
                                Gemthe youngest Gem the youngest Gem the
                                youngest Gem
                            </p>
                        )}
                    </ImageContainer>
                </Fragment>
            )
        } else {
            return (
                <Moviesdiv key={key}>
                    <ImageContainer
                        ref={width}
                        theme={{ img: value }}
                        type={{ value: type }}
                    >
                        {type == 'main' && (
                            <p>
                                the youngest Gemthe youngest Gemthe youngest
                                Gemthe youngest Gem the youngest Gem the
                                youngest Gem
                            </p>
                        )}
                    </ImageContainer>
                    {type == 'movies' && <p>45% Civil war45% Civil war</p>}
                </Moviesdiv>
            )
        }
    }

    return (
        <Wrapper>
            <Arrow className="left">
                <i onClick={() => moveSlides(false)}>{'<'}</i>
            </Arrow>
            <Div
                ref={ref}
                onPointerMove={(e) => direction(e)}
                onTouchStart={() => (isDragging = true)}
                onTouchEnd={(e) => dragging(e)}
            >
                {slides.map((value, key) => {
                    return iterateData(value, key, type)
                })}
            </Div>
            <Arrow className="right">
                <i onClick={() => moveSlides(true)}>{'>'}</i>
            </Arrow>
        </Wrapper>
    )
}

const Wrapper = styled.div`
    display: flex;
    align-items: center;
    justify-content: flex-start;
    margin-top: 16px;
    padding: 0 16px;
    @media only screen and (max-width: 650px) {
        width: 100vw;
    }
    .left {
        left: 8px;
    }
    .right {
        right: 8px;
    }
    i {
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
    margin-right: 16px;
    background-image: linear-gradient(
            to bottom,
            rgba(255, 255, 255, 0.3),
            rgba(0, 0, 0, 0.8)
        ),
        url(http://localhost:3000${(props) => props.theme.img});
    @media only screen and (max-width: 650px) {
        min-width: ${(props) => {
            if (props.type.value == 'main') return 'calc(100vw - 32px)'
            else {
                return 'calc(28vw - 32px)'
            }
        }};
        min-height: ${(props) => {
            if (props.type.value == 'main')
                return 'calc((100vw - 32px) * 0.665)'
            else {
                return 'calc((28vw - 32px) * 1.6)'
            }
        }};
        background-size: cover;
        background-repeat: no-repeat;
        background-position: center center;
    }
    @media only screen and (min-width: 651px) {
        min-width: ${(props) => {
            if (props.type.value == 'main') return 'calc(50vw - 16px)'
            else {
                return '132px'
            }
        }};
        min-height: ${(props) => {
            if (props.type.value == 'main') return 'calc((50vw - 16px) * 0.9)'
            else {
                return '211px'
            }
        }};
        background-size: cover;
        background-repeat: no-repeat;
        background-position: center center;
    }
    @media only screen and (min-width: 1100px) {
        min-width: ${(props) => {
            if (props.type.value == 'main') return '575px'
            else {
                return '137px'
            }
        }};
        min-height: ${(props) => {
            if (props.type.value == 'main') return '382px'
            else {
                return '220px'
            }
        }};
        background-size: cover;
        background-repeat: no-repeat;
        background-position: center center;
    }
    align-items: flex-end;
    p {
        color: white;
        margin: 0 8px;
        overflow: hidden;
        text-overflow: ellipsis;
        display: -webkit-box;
        -webkit-line-clamp: 4;
        -webkit-box-orient: vertical;
        -webkit-user-select: none;
        -ms-user-select: none;
        user-select: none;
    }
`

const Arrow = styled.div`
    display: flex;
    align-items: center;
    justify-content: center;
    border-radius: 50%;
    @media only screen and (max-width: 800px) {
        display: none;
    }
    width: 40px;
    height: 40px;
    position: absolute;
    z-index: 0;
    background-color: white;
    i {
        cursor: pointer;
        color: black;
        font-size: ${(props) => props.theme.fontSizes.mh1};
    }
`

export default MainCarousel
