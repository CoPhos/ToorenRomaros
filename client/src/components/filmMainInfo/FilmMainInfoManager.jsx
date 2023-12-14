import React from 'react'
import FilmMainInfoContainer from '../filmMainInfo/FilmMainInfoContainer'

function FilmMainInfoManager() {
  const data = {
    rating: {
      positive: 40,
      neutral: 8,
      negative: 8,
      total: 56
    }
  }
  return (
    <FilmMainInfoContainer data={data}></FilmMainInfoContainer>
  )
}

export default FilmMainInfoManager