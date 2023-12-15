import React, {useState} from 'react'
import Carousel from 'react-elastic-carousel'

function PostRatingContainer() {
     const [hoveredIndex, setHoveredIndex] = useState(null)

     const breakPoints = [
             { width: 1, itemsToShow: 4 },
             { width: 290, itemsToShow: 6 },
             { width: 410, itemsToShow: 8 },
             { width: 545, itemsToShow: 10 },
         ]
     const baseClassesRating =
         'flex items-center justify-center rounded-xl h-[64px] w-[64px]'

     const dynamicClasses =
         hoveredIndex + 1 <= 4
             ? 'bg-red-500'
             : hoveredIndex + 1 < 7 && hoveredIndex + 1 > 4
             ? 'bg-[#ffbd3f]'
             : 'bg-green-600'

     const baseClasses =
         'flex items-center justify-center rounded-[50%] w-[44px] h-[44px] hover:cursor-pointer'

     const children = new Array(10).fill(null).map((_, index) => {
        let dynamicClasses = 'child '
        if (hoveredIndex !== null && index <= hoveredIndex) {
            dynamicClasses = dynamicClasses + 'opacity-100 '
        } else {
            dynamicClasses = dynamicClasses + 'opacity-50 '
        }
        if (index + 1 <= 4) {
            dynamicClasses = dynamicClasses + 'bg-red-500 '
        } else if (index + 1 < 7 && index + 1 > 4) {
            dynamicClasses = dynamicClasses + 'bg-[#ffbd3f] '
        } else {
            dynamicClasses = dynamicClasses + 'bg-green-600 '
        }

        return (
            <div
                key={index}
                className={`${baseClasses} ${dynamicClasses}`}
                onMouseEnter={() => setHoveredIndex(index)}
                onMouseLeave={() => setHoveredIndex(null)}
            >
                <p className="w-fit h-fit text-body-b-700 text-white-50">
                    {index + 1 + '0'}
                </p>
            </div>
        )
     })

  return (
      <div className="w-full mb-2">
          <div className="flex flex-row items-center justify-between w-full mt-2">
              <div className="flex flex-col items-start justify-center">
                  <p className="text-body-m-300 lg:text-body-d-300">My Score</p>
                  <p className="text-small-m-700 lg:text-small-d-700">
                      Hover and click to give a rating
                  </p>
              </div>
              <div>
                  <div className={`${baseClassesRating} ${dynamicClasses}`}>
                      <p className="text-[36px] font-bold text-white-50">
                          {hoveredIndex ? hoveredIndex + 1 + '0' : 0}
                      </p>
                  </div>
              </div>
          </div>
          <div className="w-full mt-1 max-w-[1024px]" style={{}}>
              <Carousel
                  pagination={true}
                  showArrows={false}
                  breakPoints={breakPoints}
              >
                  {children}
              </Carousel>
          </div>
          <button className="mt-2 rounded-md border-[1px] border-white-200 w-full text-small-m-400 h-[36px] lg:text-small-d-400">
              Add My Review
          </button>
      </div>
  )
}

export default PostRatingContainer