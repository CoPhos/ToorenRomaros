import React from 'react'
import logo from '../../assests/logo.webp'
import loup from '../../assests/loupe.png'
import user from '../../assests/user.png'
import MenuPanel from './MenuPanel'
import styled from 'styled-components'

function Navbar(props) {
    const isLoggedIn = props.isLoggedIn
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
                <AnchorMovies>
                    MOVIES
                    <div id="aaa">
                        <MenuPanel number={1}></MenuPanel>
                    </div>
                </AnchorMovies>
                <AnchorNews>
                    NEWS
                    <div id="aab">
                        <MenuPanel number={2}></MenuPanel>
                    </div>
                </AnchorNews>
                <AnchorTv>
                    TV SHOW
                    <div id="aac">
                        <MenuPanel number={3}></MenuPanel>
                    </div>
                </AnchorTv>
                {isLoggedIn ? (
                    <ButtonLogin>
                        <FlexBox>
                            <img src={user} width="40" height="40"></img>
                            <p>the younges Gem</p>
                        </FlexBox>
                    </ButtonLogin>
                ) : (
                    <ButtonGetStarted>Get started</ButtonGetStarted>
                )}
            </NavItems>
        </Nav>
    )
}

const FlexBox = styled.div`
    display: flex;
    align-items: center;
`
const Nav = styled.nav`
    position: sticky;
    top: 0;
    display: flex;
    align-items: center;
    width: 100%;
    background-color: ${(props) => props.theme.colors.main};
    height: 56px;
    padding: 0 8px;
    gap: 8px;
    #aaa, #aab, #aac {
        visibility: hidden;
    }
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
    height: 100%;
    a {
        color: white;
        font-size: ${(props) => props.theme.fontSizes.h6};
        cursor: pointer;
    }
    @media only screen and (max-width: 904px) {
        display: none;
    }
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
    cursor: pointer;
`
const AnchorMovies = styled.a`
    &:hover {
        color: red;
        #aaa {
            color: black;
            visibility: visible;
        }
    }
`
const AnchorNews = styled.a`
    &:hover {
        color: red;
        #aab {
            color: black;
            visibility: visible;
        }
    }
`
const AnchorTv = styled.a`
    &:hover {
        color: red;
        #aac {
            color: black;
            visibility: visible;
        }
    }
`
const ButtonGetStarted = styled.button`
    background-color: ${(props) => props.theme.colors.secondary};
    border-width: 0;
    border-radius: 25px;
    letter-spacing: 2px;
    height: 35px;
    color: white;
    padding: 8px;
    cursor: pointer;
`
const ButtonLogin = styled.button`
    background-color: ${(props) => props.theme.colors.main};
    border-width: 0;
    height: 48px;
    color: white;
    padding: 8px, 0;
    cursor: pointer;
`
export default Navbar
