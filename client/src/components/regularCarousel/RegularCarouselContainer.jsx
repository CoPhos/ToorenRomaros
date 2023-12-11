import React from 'react'
import MovieCard from '../cards/movieCard/MovieCard'
import Carousel from 'react-elastic-carousel'

function RegularCarouselContainer() {
        const breakPointsMovie = [
            { width: 1, itemsToShow: 2, itemsToScroll: 2 },
            { width: 408, itemsToShow: 3, itemsToScroll: 3 },
            { width: 550, itemsToShow: 4, itemsToScroll: 3 },
            { width: 672, itemsToShow: 5, itemsToScroll: 3 },
            { width: 768, itemsToShow: 4, itemsToScroll: 4 },
            { width: 880, itemsToShow: 5, itemsToScroll: 3 },
            { width: 1070, itemsToShow: 6, itemsToScroll: 5 },
        ]
  return (
      <div className="relative mt-2 mb-4">
          <Carousel
              disableArrowsOnEnd={true}
              enableMouseSwipe={false}
              itemPadding={[0, 0, 0, 0]}
              pagination={false}
              breakPoints={breakPointsMovie}
          >
              <MovieCard
                  tittle={'Avengers: End Game'}
                  opened={'Dec 07, 2023'}
                  criticPercentage={'100'}
                  userPercentage={null}
              ></MovieCard>
              <MovieCard
                  tittle={'Avengers: End Game'}
                  opened={'Dec 07, 2023'}
                  criticPercentage={'100'}
                  userPercentage={null}
              ></MovieCard>
              <MovieCard
                  tittle={'Avengers: End Game'}
                  opened={'Dec 07, 2023'}
                  criticPercentage={'100'}
                  userPercentage={null}
              ></MovieCard>
              <MovieCard
                  tittle={'Avengers: End Game'}
                  opened={'Dec 07, 2023'}
                  criticPercentage={'100'}
                  userPercentage={null}
              ></MovieCard>
              <MovieCard
                  tittle={'Avengers: End Game'}
                  opened={'Dec 07, 2023'}
                  criticPercentage={'100'}
                  userPercentage={null}
              ></MovieCard>
              <MovieCard
                  tittle={'Avengers: End Game'}
                  opened={'Dec 07, 2023'}
                  criticPercentage={'100'}
                  userPercentage={null}
              ></MovieCard>
              <MovieCard
                  tittle={'Avengers: End Game'}
                  opened={'Dec 07, 2023'}
                  criticPercentage={'100'}
                  userPercentage={null}
              ></MovieCard>
              <MovieCard
                  tittle={'Avengers: End Game'}
                  opened={'Dec 07, 2023'}
                  criticPercentage={'100'}
                  userPercentage={null}
              ></MovieCard>
              <MovieCard
                  tittle={'Avengers: End Game'}
                  opened={'Dec 07, 2023'}
                  criticPercentage={'100'}
                  userPercentage={null}
              ></MovieCard>
          </Carousel>
      </div>
  )
}

export default RegularCarouselContainer