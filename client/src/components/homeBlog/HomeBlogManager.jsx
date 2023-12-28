import React, { Fragment } from 'react'
import HomeBlogContainer from './HomeBlogContainer';
import HomeBlogLoginContainer from './HomeBlogLoginContainer';

function HomeBlogManager() {
   const login = true
  return (
      <Fragment>
          {login ? <HomeBlogLoginContainer></HomeBlogLoginContainer> : <HomeBlogContainer></HomeBlogContainer>}
      </Fragment>
  )
}

export default HomeBlogManager