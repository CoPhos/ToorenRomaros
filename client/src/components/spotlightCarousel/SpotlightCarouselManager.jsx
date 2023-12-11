import React, { Fragment } from 'react'
import SpotlightCarouselContainer from './SpotlightCarouselContainer'

function SpotlightCarouselManager() {

    const data = {
        insideText: {
            tittle: 'Wonkas reviews are in',
            text: `Lorem ipsum dolor sit amet, consectetur adipiscing elit.
                        Nulla tortor urna, rhoncus at auctor in, ornare eget mauris.
                        `,
        },
    }
    
  return <SpotlightCarouselContainer data={data}></SpotlightCarouselContainer>
}

export default SpotlightCarouselManager