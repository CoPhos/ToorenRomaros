import React from 'react'
import VideoManager from '../videoPlayer/VideoManager'
import MainRatingScore from '../cards/mainRatingScore/MainRatingScore';
import PostRatingManager from '../postRating/PostRatingManager';

function FilmMainInfoContainer({data}) {
    

  return (
      <div className="flex flex-col items-center justify-center grow p-1">
          <VideoManager></VideoManager>

          <div
              className="mt-2 pb-2 border-b-[1px] border-white-200 w-full"
          >
              <p className="text-[36px] font-bold ">Poor Things</p>
          </div>

          <MainRatingScore data={data}></MainRatingScore>
          <MainRatingScore data={data}></MainRatingScore>

         <PostRatingManager></PostRatingManager>
      </div>
  )
}

export default FilmMainInfoContainer