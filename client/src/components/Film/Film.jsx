import React from 'react'
import styled from 'styled-components'
import prey from '../../assests/prey.webp'

function Film() {
  return <Wrapper>
    <img src={prey} width='115px' height='170px'></img>
    <p id='second'>Prey</p>
    <p id='last'>Release date: July 21, 2023</p>
  </Wrapper>
}

const Wrapper = styled.div`
    display: flex;
    flex-direction: column;
    gap: 8px;
    align-items: center;
    justify-content: center;
    p {
        margin: 0;
    }
    #second {
        font-size: ${(props) => props.theme.fontSizes.mh1};
        font-weight: bold;
    }
    #last {
        font-size: ${(props) => props.theme.fontSizes.base};
    }
`

export default Film