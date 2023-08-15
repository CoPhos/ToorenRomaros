import React, { Fragment } from 'react'
import styled from 'styled-components'
import smiling from '../../assests/smiling.png'
import neutral from '../../assests/neutral.png'
import sad from '../../assests/sad.png'

function MenuPanel(props) {
    return (
        <FlexBoxPanel>
            {Object.values(props.data).map((value, index) => {
                console.log(value.tittle)
                if (value.tittle == 'CERTIFIED FRESH PICKS') {
                    console.log('in')
                    return (
                        <div>
                            <p>{value.tittle}</p>
                            <Flex>
                                {Object.values(value.subItems).map(
                                    (value, index) => {
                                        return (
                                            <div>
                                                {value.image && (
                                                    <img
                                                        key={index}
                                                        src={value.image}
                                                        width="130"
                                                        height="200"
                                                    ></img>
                                                )}
                                                {value.text && (
                                                    <p key={index}>
                                                        {value.text}
                                                    </p>
                                                )}
                                                {value.rating && (
                                                    <p key={index}>
                                                        {value.rating}
                                                    </p>
                                                )}
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
                                                                    src={
                                                                        neutral
                                                                    }
                                                                    width="16"
                                                                    height="16"
                                                                ></img>
                                                            )
                                                        case 3:
                                                            return (
                                                                <img
                                                                    key={index}
                                                                    src={
                                                                        smiling
                                                                    }
                                                                    width="16"
                                                                    height="16"
                                                                ></img>
                                                            )
                                                        default:
                                                            return ''
                                                    }
                                                })()}
                                            </div>
                                        )
                                    }
                                )}
                            </Flex>
                        </div>
                    )
                } else {
                    return (
                        <div key={index}>
                            <p>{value.tittle}</p>
                            {Object.values(value.subItems).map(
                                (value, index) => {
                                    return (
                                        <Fragment>
                                            {value.image && (
                                                <img
                                                    key={index}
                                                    src={value.image}
                                                    width="130"
                                                    height="200"
                                                ></img>
                                            )}
                                            {value.text && (
                                                <p key={index}>{value.text}</p>
                                            )}
                                            {value.rating && (
                                                <p key={index}>
                                                    {value.rating}
                                                </p>
                                            )}
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
                                        </Fragment>
                                    )
                                }
                            )}
                        </div>
                    )
                }
            })}
        </FlexBoxPanel>
    )
}
const FlexBoxPanel = styled.div`
    display: flex;
    align-items: flex-start;
    width: 100%;
    position: absolute;
    top: 56px;
    left: 0;
    margin: 0px;
    padding: 8px;
    background-color: white;
    box-shadow: 3px 3px ${(props) => props.theme.colors.background};
`
const Flex = styled.div`
    display: flex;
    flex-direction: row;
`
export default MenuPanel
