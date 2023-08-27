import React from 'react'
//assests
//components
import MainCarousel from './MainCarousel'

function MainCarouselContainer(props) {
    return (
        <MainCarousel
            slides={props.slides}
            dimension={props.dimension}
            insideText={props.insideText}
            belowText={props.belowText}
            gradient={props.gradient}
            cardPerSlide={props.cardPerSlide}
            pagination={props.pagination}
            breakPoints={props.breakPoints}
            border={props.border}
        ></MainCarousel>
    )
}

export default MainCarouselContainer
