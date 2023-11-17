import React from 'react'
import ButtonContainer from './ButtonContainer'


function ButtonCreatePostManager() {

    function createNewPost(){
        console.log("hi!")
    }

  return (
      <ButtonContainer
          text={'Create new post'}
          onClick={createNewPost}
      ></ButtonContainer>
  )
}

export default ButtonCreatePostManager