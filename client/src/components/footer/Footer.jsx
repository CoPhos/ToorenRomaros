import React from 'react'
import logo from '../../assests/logo.webp'
import facebook from '../../assests/facebook.png'
import twitter from '../../assests/twitter.png'
import instagram from '../../assests/instagram.png'
import youtube from '../../assests/youtube.png'
import pinterest from '../../assests/pinterest.png'
import styled from 'styled-components'

function Footer() {
    return (
        <FooterContainer>
            <img id="hide" src={logo} width="50" height="50"></img>
            <p id="end">
                Copyright © 2012 - 2023 TermsFeed®. All rights reserved.
            </p>
            <FlexBox>
                <FlexBoxDesktopLeft id="panels">
                    <a>About Tooren Romaros</a>
                    <a>Critic Submission</a>
                    <a>Licensing</a>
                    <a>FAQ</a>
                </FlexBoxDesktopLeft>
                <FlexBoxDesktopCenter>
                    <p id="lines">
                        View freshest reviews, news, and more delivered right
                        now!
                    </p>
                    <ButtonVisitBlog>Visit our blog site</ButtonVisitBlog>
                </FlexBoxDesktopCenter>
                <FlexBoxDesktopRight id="panels">
                    <p>FOLLOW US</p>
                    <div>
                        <ButtonSocial>
                            <img src={facebook} width="16" height="16"></img>
                        </ButtonSocial>
                        <ButtonSocial>
                            <img src={youtube} width="16" height="16"></img>
                        </ButtonSocial>
                        <ButtonSocial>
                            <img src={twitter} width="16" height="16"></img>
                        </ButtonSocial>
                        <ButtonSocial>
                            <img src={instagram} width="16" height="16"></img>
                        </ButtonSocial>
                        <ButtonSocial>
                            <img src={pinterest} width="16" height="16"></img>
                        </ButtonSocial>
                    </div>
                </FlexBoxDesktopRight>
            </FlexBox>
            <FlexBox>
                <a>Privacy police</a>
                <Line id="lines"></Line>
                <a>Terms and conditions</a>
                <Line id="lines"></Line>
                <a>Help</a>
                <Line id="lines"></Line>
                <a>Aviso de cookies</a>
                <Line id="lines"></Line>
                <a>Blog site</a>
            </FlexBox>
        </FooterContainer>
    )
}

const FlexBox = styled.div`
    display: flex;
    flex-direction: row;
    align-items: center;
    flex-wrap: wrap;
    justify-content: center;
    width: 100%;
    gap: 16px;
`
const FlexBoxDesktopCenter = styled.div`
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: space-around;
    gap: 16px;
    flex-grow: 2;
`
const FlexBoxDesktopLeft = styled(FlexBoxDesktopCenter)`
    align-items: flex-start;
`
const FlexBoxDesktopRight = styled(FlexBoxDesktopCenter)`
    align-items: center;
    div {
        display: flex;
        flex-direction: row;
        align-items: center;
        gap: 16px;
    }
`
const FooterContainer = styled.footer`
    display: flex;
    align-items: center;
    background-color: ${(props) => props.theme.colors.secondary};
    flex-direction: column;
    justify-content: center;
    padding: 16px;
    gap: 16px;
    width: 100%;
    p,
    a {
        color: white;
        text-align: center;
        margin: 0;
    }
    a {
        font-size: ${(props) => props.theme.fontSizes.mCaption};
        cursor: pointer;
    }
    #lines {
        display: none;
    }
    #panels {
        display: none;
    }
    @media only screen and (min-width: 904px) {
        #hide {
            display: none;
        }
        #lines {
            display: block;
        }
        #panels {
            display: flex;
        }
        #end {
            order: 3;
        }
        a {
            font-size: ${(props) => props.theme.fontSizes.base};
        }
        padding: 16px 10%;
    }
    @media only screen and (max-width: 300px) {
        margin: 0;
        padding: 2px;
    }
`
const Line = styled.div`
    width: 2px;
    height: 21px;
    background-color: white;
`;

const ButtonVisitBlog = styled.button`
    border-width: 0;
    border-radius: 8px;
    background-color: ${(props) => props.theme.colors.main};
    margin: 0;
    cursor: pointer;
    color: white;
    height: 38px;
`
const ButtonSocial = styled.button`
    border-width: 0;
    background-color: ${(props) => props.theme.colors.secondary};
    margin: 0;
    cursor: pointer;
    height: 16px;
    width: 16px;
`
export default Footer
