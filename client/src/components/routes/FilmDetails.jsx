import React, { Fragment } from 'react'

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
          {/*
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
          <VideosTopManager></VideosTopManager>*/}

          <TittleCard
              tittle={'RELATED'}
              to={'/adasd'}
              linkText={null}
          ></TittleCard>
          <RegularCarouselManager
              parameters={
                  '?filmType=1&orderBy=average_super_rating-desc,view_count-desc&page=0&size=15'
              }
              queryName={'latestCertified'}
              promiseName={'latestCertifiedImages'}
          ></RegularCarouselManager>

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