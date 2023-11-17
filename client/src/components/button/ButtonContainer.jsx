import React from 'react'
import { Link } from 'react-router-dom/cjs/react-router-dom';
import styled from 'styled-components'

function ButtonContainer(props) {
  return (
      <StyledLink to="/editor">
          <Wrapper onClick={props.onClick}>{props.text}</Wrapper>
      </StyledLink>
  )
}

const Wrapper = styled.button`
    padding: 8px;
    color: black;
    width: 120px;
    &:hover {
        cursor: pointer;
    }
`

const StyledLink = styled(Link)`
    color: black;
    text-decoration: none;
    width: 120px;
`

export default ButtonContainer