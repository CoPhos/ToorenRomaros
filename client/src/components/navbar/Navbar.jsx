import React from 'react'
import logo from '../../assests/logo.webp'
import loup from '../../assests/loupe.png'
import { menuItems } from '../data'
import styled from 'styled-components'

function Navbar() {
    return (
        <Nav>
            <img src={logo} width="40" height="40"></img>
            <SearchContainer>
                <ButtonSearch>
                    <img src={loup} width="20" height="20"></img>
                </ButtonSearch>
                <SearchBar
                    placeholder="Search Movies, Tv, Actors..."
                    type="text"
                    id="fname"
                    name="fname"
                />
            </SearchContainer>
            <NavItems>
                {Object.keys(menuItems).map((key, index) => {
                    return (
                        <NavAnchor key={index}>{menuItems[key].name}</NavAnchor>
                    )
                })}
                <ButtonLogin>Get started</ButtonLogin>
            </NavItems>
        </Nav>
    )
}

const FlexBox = styled.div`
    display: flex;
    align-items: center;
`
const Nav = styled.nav`
    display: flex;
    align-items: center;
    width: 100%;
    background-color: ${(props) => props.theme.colors.main};
    height: 56px;
    padding: 0 8px;
    gap:8px;
`
const SearchContainer = styled(FlexBox)`
    padding: 16px 8px;
    border-radius: 25px;
    border: solid 1px white;
    height: 32px;
    flex-grow: 3;
`
const NavItems = styled(FlexBox)`
    justify-content: space-around;
    flex-grow: 1;
`
const SearchBar = styled.input`
    height: 28px;
    border-width: 0;
    background-color: ${(props) => props.theme.colors.main};
    color: white;
    width: 100%;
    outline: none;
    font-size: ${(props) => props.theme.fontSizes.mh6};
    &::placeholder {
        color: white;
    }
`
const ButtonSearch = styled.button`
    border-width: 0;
    background-color: ${(props) => props.theme.colors.main};
    margin: 0;
`

const NavAnchor = styled.a`
    color: white;
    font-size: ${(props) => props.theme.fontSizes.h6};
`

const ButtonLogin = styled.button`
    background-color: ${(props) => props.theme.colors.secondary};
    border-width: 0;
    border-radius: 25px;
    letter-spacing: 2px;
    height: 35px;
    color: white;
    padding: 8px;
`

export default Navbar
