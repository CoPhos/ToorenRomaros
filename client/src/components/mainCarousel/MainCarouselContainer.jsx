import React from 'react'
//assests
//components
import MainCarousel from './MainCarousel'

function MainCarouselContainer(props) {
      
  return <MainCarousel slides={props.slides} type={props.type}></MainCarousel>
}

export default MainCarouselContainer