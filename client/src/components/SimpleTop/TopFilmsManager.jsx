import React from 'react'
import TopFilmsContainer from './TopFilmsContainer';

function TopFilmsManager({ tittle, to, linkText }) {
    const data = {
        0: {
            text: 'Painkiller: Season 0',
            rating: '38',        
        },
        1: {
            text: 'Only murders in the Building: Sea the mother of god',
            rating: '',        
        },
        2: {
            text: 'Dark Winds: Season 1',
            rating: '100',        
        },
        3: {
            text: 'The Crowded Room: Season 0',
            rating: '22',        
        },
        4: {
            text: 'Painkiller: Season 0',
            rating: '38',
       
        },
        5: {
            text: 'Only murders in the Building: Sea the mother of god',
            rating: '',
       
        },
        6: {
            text: 'Dark Winds: Season 1',
            rating: '100',        
        },
        7: {
            text: 'The Crowded Room: Season 0',
            rating: '22',        
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