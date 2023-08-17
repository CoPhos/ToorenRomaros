import React from 'react'
import styled from 'styled-components'
function UserPanel() {
  return (
    //todo: use props
      <FlexBoxPanel>
          <p>User</p>
          <p>Config</p>
          <p>Favorite</p>
          <p>Profile</p>
          <p>Followers</p>
          <p>Log out</p>
      </FlexBoxPanel>
  )
}

const FlexBoxPanel = styled.div`
    display: flex;
    align-items: flex-start;
    flex-direction: column;
    justify-content: space-around;
    width: calc(100% + 16px);
    position: relative;
    top: 0;
    right: 8px;
    margin: 0px;
    padding: 0 16px;
    background-color: white;
    cursor: default;
    border: 2px solid ${(props) => props.theme.colors.background};
    border-top: none;
    p {
        cursor: pointer;
        &:hover {
            color: ${(props) => props.theme.colors.hyperlinks};
        }
    }
`

export default UserPanel

