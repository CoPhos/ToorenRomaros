import React, { Fragment, useState } from 'react'
import styled from 'styled-components'
import smiling from '../../assests/smiling.png'
import neutral from '../../assests/neutral.png'
import sad from '../../assests/sad.png'
import greyNeutral from '../../assests/greyNeutral.png'

function FilmsPanel(props) {
    const [active, setactive] = useState(1)

    function generateText(value, index) {
        return (
            <TextContainer key={index.toString()}>
                {(() => {
                    switch (value.ratingImg) {
                        case 1:
                            return <img src={sad} width="16" height="16"></img>
                        case 2:
                            return (
                                <img src={neutral} width="16" height="16"></img>
                            )
                        case 3:
                            return (
                                <img src={smiling} width="16" height="16"></img>
                            )
                        case 4:
                            return (
                                <img
                                    src={greyNeutral}
                                    width="16"
                                    height="16"
                                ></img>
                            )
                        default:
                            return ''
                    }
                })()}
                <p>{value.rating}</p>
                <p>{value.text}</p>
            </TextContainer>
        )
    }

    return (
        <Wrapper>
            <CategoryConatiner>
                <Button
                    onClick={() => setactive(1)}
                    className={
                        active === 1 ? 'focus not-left' : 'not-focus not-left'
                    }
                >
                    IN THEATHERS
                </Button>
                <Button
                    onClick={() => setactive(2)}
                    className={
                        active === 2 ? 'focus not-left' : 'not-focus not-left'
                    }
                >
                    STREAMING MOVIES
                </Button>
                <Button
                    onClick={() => setactive(3)}
                    className={
                        active === 3 ? 'focus not-left' : 'not-focus not-left'
                    }
                >
                    TV SHOWS
                </Button>
            </CategoryConatiner>
            <Panel className={active === 1 ? 'show' : 'not-show'}>
                {Object.values(props.data).map((value, key) => {
                    return (
                        <Fragment key={key.toString()}>
                            <p className="tittle">{value.tittle}</p>
                            {Object.values(value.subItems).map((value, key) => {
                                return generateText(value, key)
                            })}
                        </Fragment>
                    )
                })}
            </Panel>
            <Panel className={active === 2 ? 'show' : 'not-show'}>
                {Object.values(props.data).map((value, key) => {
                    return (
                        <Fragment key={key.toString()}>
                            <p className="tittle">{value.tittle + ' 2'}</p>
                            {Object.values(value.subItems).map((value, key) => {
                                return generateText(value, key)
                            })}
                        </Fragment>
                    )
                })}
            </Panel>
            <Panel className={active === 3 ? 'show' : 'not-show'}>
                {Object.values(props.data).map((value, key) => {
                    return (
                        <Fragment key={key.toString()}>
                            <p className="tittle">{value.tittle + ' 3'}</p>
                            {Object.values(value.subItems).map((value, key) => {
                                return generateText(value, key)
                            })}
                        </Fragment>
                    )
                })}
            </Panel>
        </Wrapper>
    )
}

const Wrapper = styled.div`
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    width: 391px;
    .not-left {
        border-left: none;
    }
    p {
        margin: 0;
    }
    .tittle {
        font-weight: bold;
    }
    .show {
        display: flex;
    }
    .not-show {
        display: none;
    }
    .focus {
        border-bottom: none;
        background-color: white;
    }
    .not-focus {
        background-color: ${(props) => props.theme.colors.background};
        border: 1px solid ${(props) => props.theme.colors.line};
    }
`
const Button = styled.button`
    border: none;
    background-color: ${(props) => props.theme.colors.background};
    font-weight: bold;
    cursor: pointer;
    width: 105px;
    height: 60px;
    border: 1px solid ${(props) => props.theme.colors.line};
    flex-grow: 1;
`

const CategoryConatiner = styled.div`
    display: flex;
    width: 100%;
`
const Panel = styled.div`
    display: flex;
    width: 100%;
    flex-direction: column;
    gap: 4px;
    justify-content: center;
    alig-items: flex-start;
    
    border: 1px solid ${(props) => props.theme.colors.line};
    border-top: none;
    p {
        overflow: hidden;
        text-overflow: ellipsis;
        display: -webkit-box;
        -webkit-line-clamp: 1;
        -webkit-box-orient: vertical;
    }
`
const TextContainer = styled.div`
    display: flex;
    flex-direction: row;
    gap: 4px;
    align-items: center;
    justify-content: flex-start;
`

export default FilmsPanel
