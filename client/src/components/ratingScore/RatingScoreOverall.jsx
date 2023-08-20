import React, { Fragment } from 'react'
import styled from 'styled-components'

function RatingScoreOverall() {
    const data = {
        1: { number: '61 Positive rating', percentage: 92 },
        2: { number: '24 Neutral rating', percentage: 7 },
        3: { number: '2 Negative rating', percentage: 1 },
    }
    return (
        <Wrapper>
            {Object.values(data).map((value, index) => {
                return (
                    <Fragment key={index.toString()}>
                        <ItemsContainer>
                            <p>{value.number}</p>
                            <p>{value.percentage}%</p>
                        </ItemsContainer>
                        <BarsContainer
                            color={{ rate: index }}
                            size={{ rate: value.percentage }}
                        >
                            <div></div>
                            <div></div>
                        </BarsContainer>
                    </Fragment>
                )
            })}
        </Wrapper>
    )
}

const Wrapper = styled.div`
    display: flex;
    flex-direction: column;
    align-items: flex-start;
    justify-content: center;
    gap: 8px;
`

const ItemsContainer = styled(Wrapper)`
    display: flex;
    flex-direction: row;
    align-items: center;
    justify-content: space-between;
    width: 100%;
    p {
        font-size: ${(props) => props.theme.fontSizes.mCaption};
        margin: 0px;
    }
    &:hover {
        p {
            color: ${(props) => props.theme.colors.hyperlinks};
            cursor: pointer;
        }
    }
`

const BarsContainer = styled.div`
    display: flex;
    flex-direction: row;
    align-items: center;
    justify-content: flex-start;
    width: 100%;
    div {
        height: 3px;
        background-color: ${(props) => {
            if (props.color.rate == 0) {
                return props.theme.colors.green
            } else if (props.color.rate == 1) {
                return props.theme.colors.yellow
            } else {
                return props.theme.colors.red
            }
        }};
    }
    :first-child {
        width: ${(props) => props.size.rate}%;
    }
    :last-child {
        width: calc(100% - ${(props) => props.size.rate}%);
        opacity: 35%;
    }
`

export default RatingScoreOverall
