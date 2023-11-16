import React from 'react'
//assests
//components
import MainCarouselContainer from './MainCarouselContainer'

function MainCarouselManager(props) {
    return (
        <MainCarouselContainer
            slides={props.slides}
            dimension={props.dimension}
            insideText={props.insideText}
            belowText={props.belowText}
            gradient={props.gradient}
            cardPerSlide={props.cardPerSlide}
            pagination={props.pagination}
            breakPoints={props.breakPoints}
            border={props.border}
            rating={props.rating}
        ></MainCarouselContainer>
    )
}

export default MainCarouselManager
