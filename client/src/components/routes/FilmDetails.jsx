import React, { Fragment } from 'react'


import CirlceRating from '../rating/CirlceRating'
import WhereWatch from '../whereWatch/WhereWatch'
import CastContainer from '../cards/castCard/CastContainer'
import FilmContainer from '../Film/FilmContainer'
import FilmScoreContainer from '../FilmScore/FilmScoreContainer'
import FilmsPanelContainer from '../FilmsPanel/FilmsPanelContainer'
import ReviewsContainer from '../review/ReviewsContainer'
import EssentialLinks from '../cards/essentialListCard/EssentialLinks'
import FilmMainInfoManager from '../filmMainInfo/FilmMainInfoManager';


function FilmDetails() {
  return (
      <Fragment>
        <FilmMainInfoManager></FilmMainInfoManager>
        
          {/* <FilmContainer></FilmContainer> */}
          {/* <FilmScoreContainer></FilmScoreContainer> */}
          {/* <CirlceRating cursor={1}></CirlceRating> */}
          <FilmsPanelContainer></FilmsPanelContainer>
          <WhereWatch></WhereWatch>
          <ReviewsContainer></ReviewsContainer>
          <CastContainer></CastContainer>
          <EssentialLinks></EssentialLinks>
      </Fragment>
  )
}

export default FilmDetails