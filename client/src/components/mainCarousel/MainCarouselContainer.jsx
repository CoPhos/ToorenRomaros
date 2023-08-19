import React from 'react'
//assests
//components
import MainCarousel from './MainCarousel'

function MainCarouselContainer() {
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
  return <MainCarousel slides={slides}></MainCarousel>
}

export default MainCarouselContainer