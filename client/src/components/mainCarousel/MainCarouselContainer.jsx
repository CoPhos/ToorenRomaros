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
            border={props.border}
            gradient={props.gradient}
        ></MainCarousel>
    )
}

export default MainCarouselContainer
