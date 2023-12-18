import React from 'react'
import styled from 'styled-components'


function RatingScore(props) {
    let text = '';
    if(!props.date){
        if (props.number > 80) {
            text = 'Generally Favorable Reviews'
        } else if (props.number < 80 && props.number > 50) {
            text = 'Generally Neutral Reviews'
        } else {
            text = 'Generally Bad Reviews'
        }
    }else{
        text=props.date
    }

  return (
      <Wrapper>
          {/* <CirlceRating number={props.number} cursor={props.cursor}></CirlceRating> */}
          <TextContainer size={{ value: props.date }}>
              <p>{props.tittle}</p>
              <p>{text}</p>
          </TextContainer>
      </Wrapper>
  )
}

const Wrapper = styled.div`
    display: flex;
    flex-direction: row;
    align-items: center;
    justify-content: center;
    gap: 8px;
    width: fit-content;
    height: fit-content;
    
`

const TextContainer = styled(Wrapper)`
    flex-direction: column;
    align-items: flex-start;
    gap: 0;
    p {
        margin: 0;
        font-size: ${(props) =>
            props.size.value
                ? props.theme.fontSizes.base
                : props.theme.fontSizes.mh5};
        font-weight: bold;
    }
    :last-child {
        font-size: ${(props) =>
            props.size.value
                ? props.theme.fontSizes.mCaption
                : props.theme.fontSizes.mh5};
        font-weight: ${(props) => (props.size.value ? 'normal' : 'bold')};
    }
    :first-child {
        &:hover {
            cursor: ${(props) => (props.size.value ? 'pointer' : 'default')};
            color: ${(props) =>
                props.size.value ? props.theme.colors.hyperlinks : 'black'};
        }
    }
`



export default RatingScore