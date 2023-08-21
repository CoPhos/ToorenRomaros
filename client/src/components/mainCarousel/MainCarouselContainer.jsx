import React from 'react'
//assests
//components
import MainCarousel from './MainCarousel'

function MainCarouselContainer(props) {

  const slides = [
      '/mainCarouselMobile.webp',
      '/mainCarouselMobile.webp',
      '/mainCarouselMobile.webp',
      '/mainCarouselMobile.webp',
      '/mainCarouselMobile.webp',
      '/mainCarouselMobile.webp',
      '/mainCarouselMobile.webp',
      '/mainCarouselMobile.webp',
  ]
  return <MainCarousel slides={slides} size={props.size}></MainCarousel>
}

export default MainCarouselContainer