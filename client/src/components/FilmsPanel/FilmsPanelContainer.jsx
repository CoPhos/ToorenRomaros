import React from 'react'
import FilmsPanel from './FilmsPanel'

function FilmsPanelContainer() {
    const data = {
        0: {
            tittle: 'NEW IN THEATHERS',
            subItems: {
                0: { text: 'billions: Season 6', rating: '50%', ratingImg: 1 },
                1: {
                    text: 'The Chosen One: season 0',
                    rating: '--',
                    ratingImg: 4,
                },
                2: {
                    text: 'The Upshaws: Season 3',
                    rating: '55%',
                    ratingImg: 2,
                },
                3: {
                    text: 'Arcane season 2',
                    rating: '99%',
                    ratingImg: 3,
                },
                4: {
                    image: '',
                    text: 'My Dad the Bounty Hunter: Season 4',
                    rating: '38%',
                    ratingImg: 1,
                },
                5: {
                    image: '',
                    text: 'Captitan America: Winter soldier',
                    rating: '62%',
                    ratingImg: 2,
                },
                6: {
                    image: '',
                    text: 'The pirates of the caribbean',
                    rating: '97%',
                    ratingImg: 3,
                },
                7: {
                    image: '',
                    text: 'Project X',
                    rating: '82%',
                    ratingImg: 3,
                },
            },
        },
        1: {
            tittle: 'MOST POPULAR THEATHERS',
            subItems: {
                0: { text: 'billions: Season 6', rating: '50%', ratingImg: 1 },
                1: {
                    text: 'The Chosen One: season 0',
                    rating: '--',
                    ratingImg: 4,
                },
                2: {
                    text: 'The Upshaws: Season 3',
                    rating: '55%',
                    ratingImg: 2,
                },
                3: {
                    text: 'Arcane season 2',
                    rating: '99%',
                    ratingImg: 3,
                },
                4: {
                    image: '',
                    text: 'My Dad the Bounty Hunter: Season 4',
                    rating: '38%',
                    ratingImg: 1,
                },
                5: {
                    image: '',
                    text: 'Captitan America: Winter soldier',
                    rating: '62%',
                    ratingImg: 2,
                },
                6: {
                    image: '',
                    text: 'The pirates of the caribbean',
                    rating: '97%',
                    ratingImg: 3,
                },
                7: {
                    image: '',
                    text: 'Project X',
                    rating: '82%',
                    ratingImg: 3,
                },
            },
        },
        2: {
            tittle: 'CERTIFIED MOVIES',
            subItems: {
                0: { text: 'billions: Season 6', rating: '50%', ratingImg: 1 },
                1: {
                    text: 'The Chosen One: season 0',
                    rating: '--',
                    ratingImg: 4,
                },
                2: {
                    text: 'The Upshaws: Season 3',
                    rating: '55%',
                    ratingImg: 2,
                },
                3: {
                    text: 'Arcane season 2',
                    rating: '99%',
                    ratingImg: 3,
                },
                4: {
                    image: '',
                    text: 'My Dad the Bounty Hunter: Season 4',
                    rating: '38%',
                    ratingImg: 1,
                },
                5: {
                    image: '',
                    text: 'Captitan America: Winter soldier',
                    rating: '62%',
                    ratingImg: 2,
                },
                6: {
                    image: '',
                    text: 'The pirates of the caribbean',
                    rating: '97%',
                    ratingImg: 3,
                },
                7: {
                    image: '',
                    text: 'Project X',
                    rating: '82%',
                    ratingImg: 3,
                },
            },
        },
        3: {
            tittle: 'COOMING SOON',
            subItems: {
                0: { text: 'billions: Season 6', rating: '50%', ratingImg: 1 },
                1: {
                    text: 'The Chosen One: season 0',
                    rating: '--',
                    ratingImg: 4,
                },
                2: {
                    text: 'The Upshaws: Season 3',
                    rating: '55%',
                    ratingImg: 2,
                },
                3: {
                    text: 'Arcane season 2',
                    rating: '99%',
                    ratingImg: 3,
                },
                4: {
                    image: '',
                    text: 'My Dad the Bounty Hunter: Season 4',
                    rating: '38%',
                    ratingImg: 1,
                },
                5: {
                    image: '',
                    text: 'Captitan America: Winter soldier',
                    rating: '62%',
                    ratingImg: 2,
                },
                6: {
                    image: '',
                    text: 'The pirates of the caribbean',
                    rating: '97%',
                    ratingImg: 3,
                },
                7: {
                    image: '',
                    text: 'Project X',
                    rating: '82%',
                    ratingImg: 3,
                },
            },
        },
    }
    return <FilmsPanel data={data}></FilmsPanel>
}

export default FilmsPanelContainer
