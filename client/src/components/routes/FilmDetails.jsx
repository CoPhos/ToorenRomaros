import React, { Fragment } from 'react'

import FilmsPanelContainer from '../FilmsPanel/FilmsPanelContainer'
import EssentialLinks from '../cards/essentialListCard/EssentialLinks'
import FilmMainInfoManager from '../filmMainInfo/FilmMainInfoManager';
import FilmDetailsManager from '../FilmDetails/FilmDetailsManager';
import ReviewManager from '../review/ReviewManager';


function FilmDetails() {
  return (
      <Fragment>
          <FilmMainInfoManager></FilmMainInfoManager>
          <FilmDetailsManager></FilmDetailsManager>
          <ReviewManager></ReviewManager>
          {/* <FilmScoreContainer></FilmScoreContainer> */}
          <FilmsPanelContainer></FilmsPanelContainer>
          {/*<EssentialLinks></EssentialLinks> */}
      </Fragment>
  )
}

export default FilmDetails