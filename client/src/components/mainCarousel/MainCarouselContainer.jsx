import React from 'react'
//assests
import mainCarouselDesktop from '../../assests/mainCarouselDesktop.webp'
import mainCarouselTablet from '../../assests/mainCarouselTablet.webp'
import mainCarouselMobile from '../../assests/mainCarouselMobile.webp'
//components
import MainCarousel from './MainCarousel'

function MainCarouselContainer() {
  const slides = [
      mainCarouselMobile,
      mainCarouselMobile, 
      mainCarouselMobile,
      mainCarouselMobile,
      mainCarouselMobile,
  ]
  return <MainCarousel slides={slides}></MainCarousel>
}

export default MainCarouselContainer