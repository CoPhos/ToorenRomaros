import React from 'react'
import { profilePanel } from '../../utils/data.js'
import styled from 'styled-components'
function UserPanel() {
  return <FlexBoxPanel>
    {profilePanel.map((value, key) =>{
        return(<p key={key}>{value}</p>)}
    )}
    </FlexBoxPanel>
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
        font-weight: normal;
        &:hover {
            color: ${(props) => props.theme.colors.hyperlinks};
        }
    }
`

export default UserPanel

