import React, { useState, createRef, useEffect, Fragment } from 'react'
import styled from 'styled-components'
import RatingScore from '../ratingScore/RatingScore'

function Review({ expand }) {
    const [height, setHeight] = useState(0)
    const [show, setshow] = useState(false)
    const toggle = () => {
        setshow(!show)
    }
    const elementRef = createRef(null)

    useEffect(() => {
        setHeight(elementRef.current.offsetHeight)
    }, [])

    const text = `styled-components utilises tagged template literals to style your
              components. It removes the mapping between components and styles.
              This means that when you're defining your styles, you're actually
              creating a normal React component, that has your styles attached
              to it. This example creates two simple components, a wrapper and a
              title, with some styles attached to it:`
    let content
    if (height > 85 && !expand) {
        content = (
            <Fragment>
                <p className="Collapse" ref={elementRef}>
                    {text}
                </p>
                <p className="blue">See full review</p>
            </Fragment>
        )
    } else if (height > 85) {
        content = (
            <Fragment>
                <p className={show ? 'Expand' : 'Collapse'} ref={elementRef}>
                    {text}
                </p>
                <Button onClick={toggle}>{show ? 'Collapse' : 'Expand'}</Button>
            </Fragment>
        )
    } else {
        content = <p ref={elementRef}>{text}</p>
    }
    return (
        <Wrapper>
            <RatingScore
                cursor={0}
                tittle={'username123'}
                date={'Agus 8, 2023'}
                number={94}
            ></RatingScore>
            <Container>{content}</Container>
        </Wrapper>
    )
}

const Wrapper = styled.div`
    display: flex;
    flex-direction: column;
    align-items: flex-start;
    justify-content: center;
    width: 100%;
    p{
        margin: 0;
    }
    .blue {
        cursor: pointer;
        color: ${(props) => props.theme.colors.hyperlinks};
    }
    border-bottom: 1px solid ${(props) => props.theme.colors.line};
    .Expand {
        overflow: visible;
        text-overflow: clip;
        display: -webkit-box;
        -webkit-line-clamp: unset;
        -webkit-box-orient: vertical;
    }
    .Collapse {
        overflow: hidden;
        text-overflow: ellipsis;
        display: -webkit-box;
        -webkit-line-clamp: 4;
        -webkit-box-orient: vertical;
    }
`

const Container = styled.div`
    display: flex;
    flex-direction: column;
    align-items: flex-end;
`

const Button = styled.button`
    backgroud-color: white;
    max-width: 80px;
    border: none;
    cursor: pointer;
    font-weight: bold;
`

export default Review
