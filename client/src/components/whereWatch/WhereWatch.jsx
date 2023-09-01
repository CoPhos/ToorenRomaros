import React from 'react'
import styled from 'styled-components'

import netflix from '../../assests/netflix.png'

function WhereWatch() {
    const sites = {
        1: { logo: netflix, name: 'Netlfix' },
        2: { logo: netflix, name: 'Netlfix' },
        3: { logo: netflix, name: 'Netlfix' },
        4: { logo: netflix, name: 'Netlfix' },
    }
    return (
        <Wrapper>
            {Object.values(sites).map((value, index) => {
                return <Card key={index.toString()}><Image src={value.logo}></Image><p>{value.name}</p></Card>
            })}
        </Wrapper>
    )
}

const Wrapper = styled.div`
    display: flex;
    flex-direction: row;
    align-items: center;
    gap: 16px;
    @media only screen and (max-width: 350px) {
        flex-wrap: wrap;
    }
`

const Card = styled.div`
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    cursor: pointer;
    p {
        margin: 0;
        font-size: ${(props) => props.theme.fontSizes.mCaption};
    }
`
const Image = styled.img`
    border-radius: 50%;
    width: 70px;
    height: 70px;
    
`

export default WhereWatch
