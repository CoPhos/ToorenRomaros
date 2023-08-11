import React from 'react'
import logo from '../../assests/logo.webp'
import styled from 'styled-components';

function Navbar() {
  return (
      <nav>
          <ColorBox color={'main'}>
              <img src={logo}></img>
              <div>
                  <FlexBox>
                      <img src={logo}></img>
                      <SearchBar type="text" id="fname" name="fname"/>
                  </FlexBox>
              </div>
          </ColorBox>
      </nav>
  )
}

const FlexBox = styled.div`
    display: flex;
`;
const ColorBox = styled(FlexBox)`
    background-color: ${(props) =>
        props.color ? props.theme.colors.main : 'trasnparent'};
`
const SearchBar = styled.input`
      height: 85%;
`;

export default Navbar