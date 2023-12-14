import React, {useState} from 'react'
import Carousel from 'react-elastic-carousel'
import CircleRating from '../cards/circleRating/CircleRating'

function PostRatingContainer() {
    const [highlight, sethighlight] = useState('10')

    const handleMouseEnter = () => {
        sethighlight('2')
        console.log("asdasd")
    }

    // const handleMouseLeave = () => {
    //     setIsHovered(false)
    // }

    const breakPoints = [
        { width: 1, itemsToShow: 4 },
        { width: 290, itemsToShow: 6 },
        { width: 410, itemsToShow: 8 },
        { width: 545, itemsToShow: 10 },
    ]
    const numbers = [10, 20, 30, 40, 50, 60, 70, 80, 90, 100]

    const listItems = numbers.map((number) => {
        let bgColor
        if (number <= 40) {
            bgColor = 'bg-red-500'
        } else if (number < 70 && number > 40) {
            bgColor = 'bg-[#ffbd3f]'
        } else {
            bgColor = 'bg-green-600'
        }
        return (
            <CircleRating
                key={number.toString()}
                number={number}
                bgColor={bgColor}
                handleMouseEnter={handleMouseEnter}
            ></CircleRating>
        )
    })

  return (
      <div className="w-full mt-1 max-w-[904px]">
          <Carousel
              pagination={false}
              showArrows={false}
              breakPoints={breakPoints}
          >
              {listItems}
          </Carousel>
      </div>
  )
}

export default PostRatingContainer