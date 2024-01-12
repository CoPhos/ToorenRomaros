import React from 'react'
import SpotlightCard from '../cards/spotlighCard/SpotlightCard'
import Carousel from 'react-elastic-carousel'

function SpotlightCarouselContainer({ data, images, isLoading }) {
    const breakPointsMain = [
        { width: 1, itemsToShow: 1, itemsToScroll: 1 },
        { width: 650, itemsToShow: 2, itemsToScroll: 2 },
    ]
     if (isLoading) {
         return <p></p>
     }

    return (
        <div className="relative mt-4">
            <Carousel
                disableArrowsOnEnd={true}
                enableMouseSwipe={false}
                itemPadding={[0, 8, 0, 0]}
                pagination={true}
                breakPoints={breakPointsMain}
            >
                {data.map((item, index) => {
                    return (
                        <SpotlightCard
                            key={item.id}
                            insideText={item}
                            images={Array.of(images)[0][index]}
                        ></SpotlightCard>
                    )
                })}
            </Carousel>
        </div>
    )
}

export default SpotlightCarouselContainer
