import React, { Fragment } from 'react'
import styled from 'styled-components'
import smiling from '../../assests/smiling.png'
import neutral from '../../assests/neutral.png'
import sad from '../../assests/sad.png'
import greyNeutral from '../../assests/greyNeutral.png'

function MenuPanel(props) {
    return (
        <FlexBoxPanel>
            {Object.values(props.data).map((value, index) => {
                if (value.tittle == 'CERTIFIED FRESH PICKS') {
                    return (
                        <Fragment key={index}>
                            <SubPanel>
                                <p id="tittle">{value.tittle}</p>
                                <Flex>
                                    {Object.values(value.subItems).map(
                                        (value, index) => {
                                            return iterateData(value, index, 1)
                                        }
                                    )}
                                </Flex>
                            </SubPanel>
                        </Fragment>
                    )
                } else {
                    return (
                        <Fragment key={(index + 1) * 100}>
                            <SubPanel>
                                <p id="tittle">{value.tittle}</p>
                                {Object.values(value.subItems).map(
                                    (value, index) => {
                                        return iterateData(value, index, 0)
                                    }
                                )}
                            </SubPanel>
                        </Fragment>
                    )
                }
            })}
        </FlexBoxPanel>
    )
}

function iterateData(value, index, flag) {
    if (flag) {
        return (
            <Fragment key={(index + 2) * 10}>
                <FlexCertified>
                    {value.image && (
                        <img src={value.image} width="130" height="200"></img>
                    )}
                    <FlexRating>
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
                        {value.rating && (
                            <p className='blue'>{value.rating}</p>
                        )}
                    </FlexRating>
                    {value.text && (
                        <p className={value.textType + ' blue'}>{value.text}</p>
                    )}
                </FlexCertified>
            </Fragment>
        )
    }
    return (
        <DivNews key={(index + 3) * 1000}>
            {value.image && (
                <img src={value.image} width="210" height="118"></img>
            )}
            <FlexRatingRow>
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

                {value.text && (
                    <p className={value.textType + ' blue'}>
                        {value.rating + ' ' + value.text}
                    </p>
                )}
            </FlexRatingRow>
        </DivNews>
    )
}

const FlexBoxPanel = styled.div`
    display: flex;
    align-items: flex-start;
    justify-content: space-around;
    width: 100%;
    position: absolute;
    top: 56px;
    left: 0;
    margin: 0px;
    padding: 0 1vw;
    padding-bottom: 16px;
    background-color: white;
    cursor: default;
    box-shadow: 3px 3px ${(props) => props.theme.colors.background};
    p:not(#tittle) {
        margin: 0;
        font-weight: normal;
        cursor: pointer;
        :hover {
            color: ${(props) => props.theme.colors.hyperlinks};
        }
    }
    #tittle {
        font-weight: bold;
    }
    p {
        text-align: start;
    }
`
const Flex = styled.div`
    display: flex;
    flex-direction: row;
    align-items: flex-start;
    gap: 8px;
`
const SubPanel = styled.div`
    flex-grow: 1;
    flex-shrink: 1;
    padding: 0 16px;
    display: flex;
    flex-direction: column;
    align-items: flex-start;
    .movieRtng {
        overflow: hidden;
        text-overflow: ellipsis;
        display: -webkit-box;
        -webkit-line-clamp: 1;
        -webkit-box-orient: vertical;
    }
`

const FlexRatingRow = styled.div`
    display: flex;
    flex-direction: row;
    align-items: center;
    justify-content: center;
    gap: 4px;
    .news {
        max-width: 210px;
        overflow: hidden;
        text-overflow: ellipsis;
        display: -webkit-box;
        -webkit-line-clamp: 2;
        -webkit-box-orient: vertical;
        overflow: hidden;
    }
    :hover {
        cursor: pointer;
    }
`

const FlexRating = styled.div`
    display: flex;
    flex-direction: row;
    align-items: center;
    justify-content: center;
    gap: 4px;
`

const FlexCertified = styled.div`
    display: flex;
    flex-direction: column;
    justify-content: flex-start;
    align-items: center;
    .movieImg {
        max-width: 130px;
        overflow: hidden;
        text-overflow: ellipsis;
        display: -webkit-box;
        -webkit-line-clamp: 2;
        -webkit-box-orient: vertical;
        overflow: hidden;
    }
    :hover,
    :focus {
        cursor: pointer;
        .blue {
            color: ${(props) => props.theme.colors.hyperlinks};
        }
    }
`
const DivNews = styled.div`
    :hover,
    :focus {
        cursor: pointer;
        .blue {
            color: ${(props) => props.theme.colors.hyperlinks};
        }
    }
`


export default MenuPanel
