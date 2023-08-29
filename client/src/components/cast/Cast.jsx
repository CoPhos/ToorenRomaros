import React from 'react'
import styled from 'styled-components'
import cast from '../../assests/cast.PNG'

function Cast() {
  return (
      <Wrapper>
          <img src={cast} height="120" width="100"></img>
          <TextContainer>
              <p id='first'>Amber Midthunder</p>
              <p id='last'>Naru</p>
          </TextContainer>
      </Wrapper>
  )
}

const Wrapper = styled.div`
    display: flex;
    flex-direction: row;
    align-items: center;
    justify-content: flex-start;
    gap: 16px;
    max-width: 260px;
`

const TextContainer = styled.div`
    display: flex;
    flex-direction: column;
    p{
        margin: 0;
    }
    p:hover {
        cursor: pointer;
    }
    #first {
        font-size: ${(props) => props.theme.fontSizes.mh6};
        color: ${(props) => props.theme.colors.hyperlinks};
    }
    #last {
        font-size: ${(props) => props.theme.fontSizes.base};
    }
`

export default Cast