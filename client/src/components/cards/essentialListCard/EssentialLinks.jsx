import React from 'react'
import styled from 'styled-components'

function EssentialLinks() {
    return (
        <Wrapper>
            <TextDiv>
                <p>Essential Links</p>
            </TextDiv>
            <LinksDiv>
                <a>New Releases in Theaters</a>
                <a>Coming Soon to Theaters</a>
                <a>New on Amazon Prime Video</a>
                <a>New on Netflix</a>
                <a>Coming Soon to DVD/Blu-ray</a>
                <a>All-Time High Scores</a>
                <a>2023 High Scores</a>
            </LinksDiv>
        </Wrapper>
    )
}

const Wrapper = styled.div`
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: start;
    min-width: 320px;
    max-width: 320px;
    border: 1px solid black;
    border-top: none;
`

const TextDiv = styled.div`
    display:flex;
    justify-content: flex-start;
    align-items: center;
    padding: 12px;
    width: 100%;
    background-color: ${(props) => props.theme.colors.main};
    height: 32px;
    p{
        color: white;
        font-size: ${(props) => props.theme.fontSizes.h5};
        text-transform: uppercase;
    }
`

const LinksDiv = styled.div`
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: start;
    padding: 12px;
    width: 320px;
    gap: 12px;
    a:hover {
        cursor: pointer;
        color: ${(props) => props.theme.colors.hyperlinks};
    }
`

export default EssentialLinks