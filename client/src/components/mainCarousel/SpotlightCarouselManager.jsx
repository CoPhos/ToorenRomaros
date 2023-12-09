import React from 'react'
import SpotlightCard from '../cards/spotlighCard/SpotlightCard';
import Carousel from 'react-elastic-carousel'

function SpotlightCarouselManager() {
    const breakPointsMain = [
            { width: 1, itemsToShow: 1, itemsToScroll: 1 },
            { width: 550, itemsToShow: 2, itemsToScroll: 2 },
        ]
    const insideText = {
        tittle: 'TITTLE',
        text: `the youngest Gemthe youngest Gemthe youngest Gemthe
                            youngest Gem the youngest Gem the youngest Gem the
                            youngest Gemthe youngest Gemthe youngest Gemthe
                            youngest Gem the youngest Gem the youngest Gem the
                            youngest Gemthe youngest Gemthe youngest Gemthe
                            youngest Gem the youngest Gem the youngest Gem the
                            youngest Gemthe youngest Gemthe youngest Gemthe
                            youngest Gem the youngest Gem the youngest Gem the
                            youngest Gemthe youngest Gemthe youngest Gemthe
                            youngest Gem the youngest Gem the youngest Gem the
                            youngest Gemthe youngest Gemthe youngest Gemthe
                            youngest Gem the youngest Gem the youngest Gem`,
    }
  return (
      <div className="relative">
          <Carousel
              disableArrowsOnEnd={true}
              enableMouseSwipe={false}
              itemPadding={[0, 0, 0, 0]}
              pagination={true}
              breakPoints={breakPointsMain}
          >
              <SpotlightCard insideText={insideText}></SpotlightCard>
              <SpotlightCard insideText={insideText}></SpotlightCard>
              <SpotlightCard insideText={insideText}></SpotlightCard>
              <SpotlightCard insideText={insideText}></SpotlightCard>
          </Carousel>
      </div>
  )
}

export default SpotlightCarouselManager