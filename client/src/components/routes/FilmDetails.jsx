import React, { Fragment } from 'react'

import FilmsPanelContainer from '../FilmsPanel/FilmsPanelContainer'
import EssentialLinks from '../cards/essentialListCard/EssentialLinks'
import FilmMainInfoManager from '../filmMainInfo/FilmMainInfoManager';
import FilmDetailsManager from '../FilmDetails/FilmDetailsManager';
import ReviewManager from '../review/ReviewManager';
import TittleCard from '../cards/tittle/TittleCard';
import VideosTopManager from '../videosTop/VideosTopManager';
import BlogTopManager from '../blogTop/BlogTopManager';
import RegularCarouselManager from '../regularCarousel/RegularCarouselManager';
import PhotostopManager from '../photosTop/PhotosTopManager'

function FilmDetails() {
  return (
      <Fragment>
          <FilmMainInfoManager></FilmMainInfoManager>

          <FilmDetailsManager></FilmDetailsManager>
          
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

          {/* <FilmScoreContainer></FilmScoreContainer> */}
          {/* <FilmsPanelContainer></FilmsPanelContainer> */}
          {/*<EssentialLinks></EssentialLinks> */}
      </Fragment>
  )
}

export default FilmDetails