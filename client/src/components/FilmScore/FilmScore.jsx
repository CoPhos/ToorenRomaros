import React from 'react'
import audiendce from '../../assests/audience.png'
import director from '../../assests/director.png'
import styled from 'styled-components'

function FilmScore() {
  return (
      <Wrapper>
          <p className="bold h2">PREY</p>
          <InfoContainer>
              <p id="rounded">PG-18</p>
              <p>2022, Action/Adventure, 1h 39m</p>
          </InfoContainer>
          <ScoreWrapper>
              <ScoreContainer>
                  <Score>
                      <img src={director} width="40px" height="40px"></img>
                      <p className="bold h4">91%</p>
                  </Score>
                  <p>CRITC SCORE</p>
                  <p className="blue">78 Reviews</p>
              </ScoreContainer>
              <ScoreContainer>
                  <Score>
                      <img src={audiendce} width="40px" height="40px"></img>
                      <p className="bold h4">96%</p>
                  </Score>
                  <p>AUDIENCE SCORE</p>
                  <p className="blue">278 Reviews</p>
              </ScoreContainer>
          </ScoreWrapper>
      </Wrapper>
  )
}

const Wrapper = styled.div`
    display: flex;
    flex-direction: column;
    gap: 8px;
    align-items: center;
    justify-content: center;
    border-radius: 8px;
    background-color: ${(props) => props.theme.colors.background};
    max-width: 904px;
    p {
        margin: 0;
    }
    .blue {
        cursor: pointer;
        color: ${(props) => props.theme.colors.hyperlinks};
    }
    .bold {
        font-weight: bold;
    }
    .h2 {
        font-size: ${(props) => props.theme.fontSizes.mh2};
    }
    .h4 {
        font-size: ${(props) => props.theme.fontSizes.mh4};
    }
`
const InfoContainer = styled.div`
    display: flex;
    flex-direction: row;
    gap: 4px;
    align-items: center,
    justify-content: flex-start;
    #rounded {
        border-radius: 6px;
        border: 1px solid black;
        padding: 0px 4px;
    }
`
const ScoreWrapper = styled.div`
    display: flex;
    flex-direction: row;
    align-items: center;
    justify-content: center;
    gap: 64px;
    width: 100%;
`
const ScoreContainer = styled.div`
     display: flex;
    flex-direction: column;
    align-items: flex-end,
    justify-content: center;
`
const Score = styled.div`
    display: flex;
    flex-direction: row;
    align-items: flex-start,
    justify-content: space-between;
`



export default FilmScore