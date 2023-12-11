import React from 'react'
import TopFilmsContainer from './TopFilmsContainer';

function TopFilmsManager({ tittle, to, linkText }) {
    const data = {
        0: {
            image: '',
            text: 'Painkiller: Season 0',
            rating: '38%',
            ratingImg: 1,
            textType: 'movieRtng',
        },
        1: {
            image: '',
            text: 'Only murders in the Building: Sea the mother of god',
            rating: '88%',
            ratingImg: 2,
            textType: 'movieRtng',
        },
        2: {
            image: '',
            text: 'Dark Winds: Season 1',
            rating: '100%',
            ratingImg: 2,
            textType: 'movieRtng',
        },
        3: {
            image: '',
            text: 'The Crowded Room: Season 0',
            rating: '22%',
            ratingImg: 1,
            textType: 'movieRtng',
        },
        4: {
            image: '',
            text: 'Painkiller: Season 0',
            rating: '38%',
            ratingImg: 1,
            textType: 'movieRtng',
        },
        5: {
            image: '',
            text: 'Only murders in the Building: Sea the mother of god',
            rating: '88%',
            ratingImg: 2,
            textType: 'movieRtng',
        },
        6: {
            image: '',
            text: 'Dark Winds: Season 1',
            rating: '100%',
            ratingImg: 2,
            textType: 'movieRtng',
        },
        7: {
            image: '',
            text: 'The Crowded Room: Season 0',
            rating: '22%',
            ratingImg: 1,
            textType: 'movieRtng',
        },
    }
     
    return (
        <TopFilmsContainer
            tittle={tittle}
            to={to}
            linkText={linkText}
            data={data}
        ></TopFilmsContainer>
    )
}

export default TopFilmsManager