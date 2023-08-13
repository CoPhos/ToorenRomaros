import React from 'react'
import styled from 'styled-components'

function MenuPanel(props) {
  return (
      <FlexBoxPanel>
          <p>{props.number}</p>
          <p>the younges Gem</p>
          <p>the younges Gem</p>
          <p>the younges Gem</p>
          <p>the younges Gem</p>
          <p>the younges Gem</p>
      </FlexBoxPanel>
  )
}
const FlexBoxPanel = styled.div`
    display: flex;
    align-items: flex-start;
    width: 100%;
    position: absolute;
    top: 56px;
    left: 0;
    margin: 0;
    background-color: red;
`

export default MenuPanel