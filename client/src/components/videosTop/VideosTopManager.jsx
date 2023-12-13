import React from 'react'
import VideosTopContainer from './VideosTopContainer';

function VideosTopManager() {
    const data = {
        0: {
            videoType: 'Interview',
            tittle: 'Napoleon',
            text: 'Ridley Scott and Vanessa Kirby on Working with Joaquin Phoenix ',
        },
        1: {
            videoType: 'Scene breakdown',
            tittle: 'Monarch',
            text: 'Ridley Scott and Vanessa Kirby on Working with Joaquin Phoenix ',
        },
        2: {
            videoType: 'Trailer',
            tittle: 'Fast and furious X-2',
            text: 'Ridley Scott and Vanessa Kirby on Working with Joaquin Phoenix ',
        },
        3: {
            videoType: 'Interview',
            tittle: 'Awards tour',
            text: 'Ridley Scott and Vanessa Kirby on Working with Joaquin Phoenix ',
        },
    }
  return (
    <VideosTopContainer data={data}></VideosTopContainer>
  )
}

export default VideosTopManager