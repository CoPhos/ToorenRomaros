import React from 'react'
import MovieCard from '../cards/movieCard/MovieCard'
import Carousel from 'react-elastic-carousel'

function RegularCarouselContainer({ data }) {
    console.log(data)
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
                {data.map((item) => {
                    return (
                        <MovieCard
                            key={item.id}
                            data={item}
                            id={item.id}
                            images={item.mainImageId}
                            addWathcList={true}
                        />
                    )
                })}
            </Carousel>
        </div>
    )
}

export default RegularCarouselContainer