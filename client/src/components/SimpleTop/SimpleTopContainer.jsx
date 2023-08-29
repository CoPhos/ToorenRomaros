import React, { Fragment } from 'react'
import SimpleTop from './SimpleTop'
import styled from 'styled-components'

function SimpleTopContainer() {
    const data = {
        0: {
            tittle: 'MOST POPULAR TV ON RT',
            subItems: {
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
            },
        },
        1: {
            tittle: 'POPULAR STREAMING MOVIES',
            subItems: {
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
            },
        },
        2: {
            tittle: 'NEW TV THIS WEEK',
            subItems: {
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
            },
        },
        3: {
            tittle: 'NEW & UPCOMING MOVIES IN THEATERS',
            subItems: {
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
            },
        },
    }

    return (
        <FlexWrap>
            {Object.values(Object.values(data)).map((value, index) => {
                return (
                    <SimpleTop
                        key={index.toString()}
                        tittle={value.tittle}
                        data={value.subItems}
                    ></SimpleTop>
                )
            })}
        </FlexWrap>
    )
}

const FlexWrap = styled.div`
    display: flex;
    flex-direction: row;
    align-items: flex-start;
    justify-content: space-between;
    flex-wrap: wrap;
    padding: 0 16px 0 0;
    margin-top: 48px;
    @media only screen and (max-width: 710px) {
        justify-content: center;
    }
`

export default SimpleTopContainer
