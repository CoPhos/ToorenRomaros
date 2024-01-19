import React, { Fragment } from 'react'

import ReviewManager from '../review/ReviewManager';
import TittleCard from '../cards/tittle/TittleCard';
import VideosTopManager from '../videosTop/VideosTopManager';
import BlogTopManager from '../blogTop/BlogTopManager';
import RegularCarouselManager from '../regularCarousel/RegularCarouselManager';
import PhotostopManager from '../photosTop/PhotosTopManager'
import FilmManager from '../FilmDetails/FilmManager';

function FilmDetails() {
  return (
      <Fragment> 
         <FilmManager></FilmManager>
          
          <ReviewManager></ReviewManager>

          <TittleCard
              tittle={'PHOTOS'}
              to={'/adasd'}
              linkText={'View all'}
          ></TittleCard>
          <PhotostopManager></PhotostopManager>

          <TittleCard
              tittle={'VIDEOS'}
              to={'/adasd'}
              linkText={'View all'}
          ></TittleCard>
          <VideosTopManager></VideosTopManager>

          <TittleCard
              tittle={'RELATED'}
              to={'/adasd'}
              linkText={null}
          ></TittleCard>
          <RegularCarouselManager></RegularCarouselManager>

          <TittleCard
              tittle={'FROM OUR BLOG'}
              to={'/adasd'}
              linkText={null}
          ></TittleCard>
          <BlogTopManager></BlogTopManager>
      </Fragment>
  )
}

export default FilmDetails