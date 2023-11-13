import React from 'react'
import Cast from './Cast'
import styled from 'styled-components'

function CastContainer() {
  return (
      <Wrapper>
          <Cast></Cast>
          <Cast></Cast>
          <Cast></Cast>
          <Cast></Cast>
          <Cast></Cast>
          <Cast></Cast>
      </Wrapper>
  )
}

const Wrapper = styled.div`
    display: flex;
    flex-direction: row;
    align-items: flex-start;
    justify-content: flex-start;
    flex-wrap: wrap;
    padding: 0 16px 0 0;
    margin-top: 48px;
    gap: 16px;
    @media only screen and (max-width: 710px) {
        justify-content: center;
    }
`

export default CastContainer