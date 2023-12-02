import React from 'react'
import { Link } from 'react-router-dom'
import logo from '../../assests/logo.webp'
import loup from '../../assests/loupe.png'
import user from '../../assests/user.jpg'
import MenuPanel from './MenuPanel'
import UserPanel from './UserPanel'
import styled from 'styled-components'

function NavbarHolder(props) {
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
                <MoviesDiv>
                    <BaseAnchor to="/browse" id="anchorMovies">
                        MOVIES
                    </BaseAnchor>
                    <div id="aaa">
                        <MenuPanel
                            data={props.menuPanelData.movies}
                        ></MenuPanel>
                    </div>
                </MoviesDiv>

                <TvDiv>
                    <BaseAnchor to="/browse" id="anchorTv">
                        TV SHOW
                    </BaseAnchor>
                    <div id="aac">
                        <MenuPanel data={props.menuPanelData.tv}></MenuPanel>
                    </div>
                </TvDiv>

                <NewsDiv>
                    <BaseAnchor to="/browse" id="anchorNews">
                        NEWS
                    </BaseAnchor>
                    <div id="aab">
                        <MenuPanel data={props.menuPanelData.news}></MenuPanel>
                    </div>
                </NewsDiv>

                {isLoggedIn ? (
                    <ButtonLogin>
                        <FlexImg>
                            <FlexBox>
                                <User src={user} width="40" height="40"></User>
                                <p id="mar">XavierXavier</p>
                            </FlexBox>
                            <div
                                style={{ width: 'calc(100% + 16px)' }}
                                id="aae"
                            >
                                <UserPanel></UserPanel>
                            </div>
                        </FlexImg>
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
    #mar {
        margin-bottom: 14px;
    }
`
const FlexImg = styled(FlexBox)`
    max-height: 48px;
    flex-direction: column;
    p {
        font-weight: normal;
    }
    width: 100%;
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
    z-index: 2;
    #aaa,
    #aab,
    #aac,
    #aae {
        visibility: hidden;
    }
`
const SearchContainer = styled(FlexBox)`
    padding: 16px 8px;
    border-radius: 25px;
    margin-right: 8px;
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
const BaseAnchor = styled(Link)`
    height: 48px;
    padding: 0 8px;
    padding-top: 8px;
    text-align: center;
    align-self: flex-end;
    border-top-left-radius: 8px;
    border-top-right-radius: 8px;
    text-decoration: none;
`
const BaseDiv = styled.div`
    height: 48px;
    padding: 0 8px;
    padding-top: 8px;
    text-align: center;
    align-self: flex-end;
    border-top-left-radius: 8px;
    border-top-right-radius: 8px;
`

const MoviesDiv = styled(BaseDiv)`
    &:hover {
        background-color: white;
        #aaa {
            color: black;
            visibility: visible;
        }
        #anchorMovies {
            color: black;
        }
    }
`
const TvDiv = styled(BaseDiv)`
    &:hover {
        background-color: white;
        #aac {
            color: black;
            visibility: visible;
        }
        #anchorTv {
            color: black;
        }
    }
`

const NewsDiv = styled(BaseDiv)`
    &:hover {
        background-color: white;
        #aab {
            color: black;
            visibility: visible;
        }
        #anchorNews {
            color: black;
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
const User = styled.img`
    border-radius: 50%;
    margin-right: 8px;
`

const ButtonLogin = styled.button`
    padding: 0 8px;
    text-align: center;
    align-self: flex-end;
    border-top-left-radius: 8px;
    border-top-right-radius: 8px;
    font-weight: bold;
    background-color: ${(props) => props.theme.colors.main};
    border-width: 0;
    height: 48px;
    color: white;
    cursor: pointer;
    &:hover {
        color: black;
        background-color: white;
        #aae {
            color: black;
            visibility: visible;
        }
    }
`

export default NavbarHolder
