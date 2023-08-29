import React, { useState, createRef, useEffect } from 'react'
import styled from 'styled-components'
import RatingScore from '../ratingScore/RatingScore'

function Review() {
     const [height, setHeight] = useState(0)
     const elementRef = createRef(null)

     useEffect(() => {
         setHeight(elementRef.current.offsetHeight)
     }, [])
    let seeMore;
    const text = `styled-components utilises tagged template literals to style your
              components. It removes the mapping between components and styles.
              This means that when you're defining your styles, you're actually
              creating a normal React component, that has your styles attached
              to it. This example creates two simple components, a wrapper and a
              title, with some styles attached to it:`;
    if (height > 87) {
        seeMore = <p>See full review</p>
    }
    else{
        seeMore = <p></p>
    }
  return (
      <Wrapper>
          <RatingScore
              cursor={0}
              tittle={'username123'}
              date={'Agus 8, 2023'}
              number={94}
          ></RatingScore>
          <p ref={elementRef}>{text}</p>
          {seeMore}
      </Wrapper>
  )
}

const Wrapper = styled.div`
    display: flex;
    flex-direction: column;
    align-items: flex-start;
    justify-content: center;
    width: 100%;
    p {
        overflow: hidden;
        text-overflow: ellipsis;
        display: -webkit-box;
        -webkit-line-clamp: 4;
        -webkit-box-orient: vertical;
        margin:0;
    }
`

export default Review