import React, { useRef} from 'react'
import styled from 'styled-components'

function MainCarousel({ slides, size }) {
    const ref = useRef(null)
    let isDragging = false
    window.addEventListener('mouseup', function (e) {
        isDragging = false
        ref.current.classList.remove('dragging')
    })
    window.addEventListener('touchend', function (e) {
        isDragging = false
        ref.current.classList.remove('dragging')
    })

    function dragging(e) {
        
        if (!isDragging) {
            return
        }
        ref.current.classList.add('dragging')
        ref.current.scrollLeft -= e.movementX
    }

    return (
        <Wrapper>
            <Arrow className="left">
                <i
                    onClick={() =>
                        (ref.current.scrollLeft += -ref.current.clientWidth -16)
                    }
                >
                    {'<'}
                </i>
            </Arrow>
            <Div
                ref={ref}
                onPointerMove={(e) => dragging(e)}
                onMouseDown={() => (isDragging = true)}
                onTouchStart={() => (isDragging = true)}
            >
                {slides.map((value, key) => {
                    return (
                        <ImageContainer
                            key={key}
                            theme={{ img: value }}
                            size={{ value: size }}
                        >
                            <p>
                                the youngest Gemthe youngest Gemthe youngest
                                Gemthe youngest Gem the youngest Gem the
                                youngest Gem
                            </p>
                        </ImageContainer>
                    )
                })}
            </Div>
            <Arrow className="right">
                <i
                    onClick={() =>
                        (ref.current.scrollLeft += ref.current.clientWidth + 16)
                    }
                >
                    {'>'}
                </i>
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
    .dragging {
        scroll-behavior: auto;
        cursor: grab;
    }
`
const Div = styled.div`
    display: flex;
    align-items: center;
    justify-content: flex-start;
    gap: 16px;
    overflow-x: hidden;
    scroll-behavior: smooth;
    cursor: grab;
    touch-action: none;
`
const ImageContainer = styled.div`
    display: flex;
    background-image: linear-gradient(
            to bottom,
            rgba(255, 255, 255, 0.3),
            rgba(0, 0, 0, 0.8)
        ),
        url(http://localhost:3000${(props) => props.theme.img});
    @media only screen and (max-width: 600px) {
        min-width: calc(100vw - 32px);
        background-size: cover;
        background-repeat: no-repeat;
        background-position: center center;
        min-height: 400px;
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
    width: 40px;
    height: 40px;
    position: absolute;
    z-index: 0;
    background-color: grey;
    &:hover {
        background-color: white;
        i {
            color: black;
        }
    }
    i {
        cursor: pointer;
        color: white;
        font-size: ${(props) => props.theme.fontSizes.mh1};
    }
`

export default MainCarousel
