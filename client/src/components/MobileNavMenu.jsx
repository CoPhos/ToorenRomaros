import React from 'react'
import styled from 'styled-components'
import home from '../assests/home.png'
import news from '../assests/news.png'
import tv from '../assests/tv.png'
import user from '../assests/user.png'

function MobileNavMenu() {
    return (
        <Container>
            <Wrapper id="hide">
                <ButtonMenu>
                    <img src={home} width="42" height="42"></img>
                </ButtonMenu>
                <ButtonMenu>
                    <img src={tv} width="42" height="42"></img>
                </ButtonMenu>
                <ButtonMenu>
                    <img src={news} width="42" height="42"></img>
                </ButtonMenu>
                <ButtonMenu>
                    <img src={user} width="42" height="42"></img>
                </ButtonMenu>
            </Wrapper>
        </Container>
    )
}

const Container = styled.div`
    height: 64px;
    position: sticky;
    bottom: 0;
    @media only screen and (min-width: 904px) {
        #hide {
            display: none;
        }
    }
`
const Wrapper = styled.div`
    display: flex;
    justify-content: space-around;
    align-items: center;
    height: 64px;
    background-color: ${(props) => props.theme.colors.secondary};
`

const ButtonMenu = styled.button`
    border-width: 0;
    background-color: ${(props) => props.theme.colors.secondary};
    margin: 0;
    cursor: pointer;
    @media only screen and (min-width: 904px) {
        #hide {
            background-color: ${(props) => props.theme.colors.main};
            display: none;
        }
    }
`

export default MobileNavMenu
