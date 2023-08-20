import React from 'react'
import styled from 'styled-components'

function CirlceRating(props) {
    const numbers = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
    const listItems = numbers.map((number) => (
        <CircleDiv
            cursor={{ value: props.cursor }}
            color={{ value: number }}
            key={number.toString()}
        >
            <p>{number}</p>
        </CircleDiv>
    ))

    if (props.number) {
        return (
            <CircleDiv cursor={{value: props.cursor}} color={{ value: props.number/10 }}>
                <p>{props.number}</p>
            </CircleDiv>
        )
    } else {
        return <Wrapper>{listItems}</Wrapper>
    }
}

const CircleDiv = styled.div`
    display: flex;
    align-items: center;
    justify-content: center;
    border-radius: 50%;
    width: 44px;
    height: 44px;
    background-color: ${(props) => {
        if (props.color.value < 4) {
            return props.theme.colors.red
        } else if (props.color.value < 8 && props.color.value > 3) {
            return props.theme.colors.yellow
        } else {
            return props.theme.colors.green
        }
    }};
    cursor: ${(props) => (props.cursor.value == 1 ? 'pointer' : 'default')};
    p {
        width: fit-content;
        height: fit-content;
        color: white;
        font-size: ${(props) => props.theme.fontSizes.mh5};
        font-weight: bold;
    }
`

const Wrapper = styled.div`
    display: flex;
    flex-direction: row;
    align-items: center;
    justify-content: space-around;
`

export default CirlceRating
