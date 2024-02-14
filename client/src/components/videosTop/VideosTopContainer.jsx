import React from 'react'
import VideoCard from '../cards/videoCard/VideoCard';

function VideosTopContainer({data}) {
  return (
      <div className="flex flex-row items-center my-3 overflow-scroll gap-2 ml-1 min-[1080px]:overflow-hidden min-[1080px]:gap-[0px] min-[1080px]:justify-between min-[1080px]:flex-wrap">
          {Object.values(Object.values(data)).map((value, index) => {
              return (
                  <VideoCard
                      key={index}
                      to={`/post/${value.id}`}
                      videoType={value.tag}
                      tittle={value.tittle}
                      text={value.headline}
                      image={value.mainImageOneDpi}
                  ></VideoCard>
              )
          })}
      </div>
  )
}

export default VideosTopContainer