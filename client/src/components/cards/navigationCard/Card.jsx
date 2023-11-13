import React from 'react'
import styled from 'styled-components'

function Card(props) {
  return (
    <CardContaier>
        <img></img>
        <a>{props.text}</a>
    </CardContaier>
  )
}

const CardContaier = styled.div`
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;

    img {
        
    }
    p{

    }
`;

export default Card