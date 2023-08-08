import React from 'react'
import logo from '../../assests/logo.webp'
import styled from 'styled-components';

function Navbar() {
  return (
    <nav>
        <NavBox> <img src={logo}></img>
        <div>asdasdasdas</div></NavBox>
       
    </nav>
  )
}

const NavBox = styled.div`
    display: flex;
    background-color: ${props => props.theme.colors.mainColor};

`;

export default Navbar