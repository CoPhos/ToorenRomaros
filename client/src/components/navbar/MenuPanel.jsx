import React, { Fragment } from 'react'
import styled from 'styled-components'
import smiling from '../../assests/smiling.png'
import neutral from '../../assests/neutral.png'
import sad from '../../assests/sad.png'

function MenuPanel(props) {
    return (
        <FlexBoxPanel>
            {Object.values(props.data).map((value, index) => {
                if (value.tittle == 'CERTIFIED FRESH PICKS') {
                    return (
                        <SubPanel>
                            <p id="notMaxW">{value.tittle}</p>
                            <Flex>
                                {Object.values(value.subItems).map(
                                    (value, index) => {
                                        return iterateData(value, index, 1)
                                    }
                                )}
                            </Flex>
                        </SubPanel>
                    )
                } else {
                    return (
                        <SubPanel>
                            <p id="notMaxW">{value.tittle}</p>
                            {Object.values(value.subItems).map(
                                (value, index) => {
                                    return iterateData(value, index, 0)
                                }
                            )}
                        </SubPanel>
                    )
                }
            })}
        </FlexBoxPanel>
    )
}

function iterateData(value, index, flag) {
    if(flag){
        return (
            <FlexCertified>
                {value.image && (
                    <img
                        key={index}
                        src={value.image}
                        width="130"
                        height="200"
                    ></img>
                )}
                <FlexRating>
                    {(() => {
                        switch (value.ratingImg) {
                            case 1:
                                return (
                                    <img
                                        key={index}
                                        src={sad}
                                        width="16"
                                        height="16"
                                    ></img>
                                )
                            case 2:
                                return (
                                    <img
                                        key={index}
                                        src={neutral}
                                        width="16"
                                        height="16"
                                    ></img>
                                )
                            case 3:
                                return (
                                    <img
                                        key={index}
                                        src={smiling}
                                        width="16"
                                        height="16"
                                    ></img>
                                )
                            default:
                                return ''
                        }
                    })()}
                    {value.rating && (
                        <p id="100" key={index}>
                            {value.rating}
                        </p>
                    )}
                </FlexRating>
                {value.text && (
                    <p id="100" key={index}>
                        {value.text}
                    </p>
                )}
            </FlexCertified>
        )
    }
    return (
        <Fragment>
            {value.image && (
                <img
                    key={index}
                    src={value.image}
                    width="210"
                    height="118"
                ></img>
            )}
            <FlexRatingRow>
                {(() => {
                    switch (value.ratingImg) {
                        case 1:
                            return (
                                <img
                                    key={index}
                                    src={sad}
                                    width="16"
                                    height="16"
                                ></img>
                            )
                        case 2:
                            return (
                                <img
                                    key={index}
                                    src={neutral}
                                    width="16"
                                    height="16"
                                ></img>
                            )
                        case 3:
                            return (
                                <img
                                    key={index}
                                    src={smiling}
                                    width="16"
                                    height="16"
                                ></img>
                            )
                        default:
                            return ''
                    }
                })()}
                {value.rating && <p id="100" key={index}>{value.rating}</p>}
                {value.text && <p key={index}>{value.text}</p>}
            </FlexRatingRow>
        </Fragment>
    )
}

// function iterateData(value, index) {
//     let html = '<Fragment>'
//     if (value.image) {
//         console.log("in function")
//         html += `<img
//                     key=${index}
//                     src=${value.image}
//                     width="130"
//                     height="200"
//                 ></img>`
//     }
//     if (value.text) {
//         html += `<p key=${index}>${value.text}</p>`
//     }
//     if (value.rating) {
//         html += `p key=${index}>${value.rating}</p>`
//     }
//     switch (value.ratingImg) {
//         case 1:
//             html += `<img
//                         key=${index}
//                         src=${sad}
//                         width="16"
//                         height="16"
//                     </img>`
//         case 2:
//             html += `<img
//                         key=${index}
//                         src=${neutral}
//                         width="16"
//                         height="16"
//                     ></img>`
//         case 3:
//             html += `<img
//                         key=${index}
//                         src=${smiling}
//                         width="16"
//                         height="16"
//                     ></img>`
//         default:
//             html += ''
//     }
//     html += '</Fragment>'
//     return html
// }

const FlexBoxPanel = styled.div`
    display: flex;
    align-items: flex-start;
    justify-content: space-around;
    width: 100%;
    position: absolute;
    top: 56px;
    left: 0;
    margin: 0px;
    padding: 0 42px;
    background-color: white;
    cursor: default;
    box-shadow: 3px 3px ${(props) => props.theme.colors.background};
    p:not(#notMaxW) {
        margin: 0;
        font-weight: normal;
        cursor: pointer;
        color: ${(props) => props.theme.colors.hyperlinks};
    }
    p:not(#100) {
        width: 100%;
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
`

const FlexRatingRow = styled.div`
    display: flex;
    flex-direction: row;
    align-items: center;
    gap:4px;
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
`

export default MenuPanel
