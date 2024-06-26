import React from 'react'
import SpotlightCard from '../cards/spotlighCard/SpotlightCard'
import Carousel from 'react-elastic-carousel'

function SpotlightCarouselContainer({ data }) {
    const breakPointsMain = [
        { width: 1, itemsToShow: 1, itemsToScroll: 1 },
        { width: 650, itemsToShow: 2, itemsToScroll: 2 },
    ]

    return (
        <div className="relative mt-4">
            <Carousel
                disableArrowsOnEnd={true}
                enableMouseSwipe={false}
                itemPadding={[0, 0, 0, 0]}
                pagination={true}
                breakPoints={breakPointsMain}
            >
                {data.map((item, index) => {
                    const lazyLoading = index > 1 ? 'lazy' : 'eager'
                    return (
                        <SpotlightCard
                            key={item.id}
                            insideText={item}
                            images={item.images}
                            lazyLoading={lazyLoading}
                        ></SpotlightCard>
                    )
                })}
            </Carousel>
        </div>
    )
}

export default SpotlightCarouselContainer
