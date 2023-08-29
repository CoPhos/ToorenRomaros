import React, { Fragment } from 'react'
import styled from 'styled-components'

import smiling from '../../assests/smiling.png'
import neutral from '../../assests/neutral.png'
import sad from '../../assests/sad.png'
import Tittle from '../../utils/Tittle'

function SimpleTop({ tittle, data }) {
    return (
        <Wrapper>
            <FlexRow>
                <Tittle tittle={tittle}></Tittle>
                <a>VIEW ALL</a>
            </FlexRow>
            <DataContainer>
                {Object.values(Object.values(data)).map((value, index) => {
                    return (
                        <Fragment key={index.toString()}>
                            <li>
                                {value.text && (
                                    <p className={value.textType}>
                                        {value.text}
                                    </p>
                                )}
                                <RatingDiv>
                                    {(() => {
                                        switch (value.ratingImg) {
                                            case 1:
                                                return (
                                                    <img
                                                        src={sad}
                                                        width="16"
                                                        height="16"
                                                    ></img>
                                                )
                                            case 2:
                                                return (
                                                    <img
                                                        src={neutral}
                                                        width="16"
                                                        height="16"
                                                    ></img>
                                                )
                                            case 3:
                                                return (
                                                    <img
                                                        src={smiling}
                                                        width="16"
                                                        height="16"
                                                    ></img>
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
                                    {value.rating && <p>{value.rating}</p>}
                                </RatingDiv>
                            </li>
                        </Fragment>
                    )
                })}
            </DataContainer>
        </Wrapper>
    )
}

const Wrapper = styled.div`
    display: flex;
    flex-direction: column;
    align-items: flex-start;
    justify-content: center;
    max-width: 364px;
    padding-left: 16px;
`

const FlexRow = styled.div`
    display: flex;
    flex-direction: row;
    align-items: center;
    justify-content: space-between;
    width: 100%;
    a {
        margin: 0;
    }
    a:hover,
    a:focus {
        cursor: pointer;
        color: ${(props) => props.theme.colors.hyperlinks};
    }
`
const RatingDiv = styled.div`
    display: flex;
    flex-direction: row;
    align-items: center;
    gap: 4px;
    justify-self: end;
`

const DataContainer = styled.ul`
    padding: 0;
    width: 100%;
    li {
        display: flex;
        flex-direction: row;
        align-items: center;
        justify-content: space-between;
        list-style-type: none;
        padding: 0;
        margin: 0;
        width: 100%;
        border-bottom: 1px solid ${(props) => props.theme.colors.line};
        .movieRtng {
            max-width: 282px;
            overflow: hidden;
            text-overflow: ellipsis;
            display: -webkit-box;
            -webkit-line-clamp: 1;
            -webkit-box-orient: vertical;
            overflow: hidden;
        }
    }
    li:hover,
    li:focus {
        cursor: pointer;
        p {
            color: ${(props) => props.theme.colors.hyperlinks};
        }
    }
`

export default SimpleTop
