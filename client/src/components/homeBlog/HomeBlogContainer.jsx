import React, { Fragment } from 'react'

import MainCardBlog from '../cards/HomeBlog/MainCardBlog';
import TrendingBlog from '../cards/HomeBlog/TrendingBlog';
import ContentBlog from '../cards/HomeBlog/ContentBlog';

function HomeBlogContainer() {
   
  return (
      <div className="max-[1125px]:px-1">
          <Fragment>
              <MainCardBlog></MainCardBlog>
              <TrendingBlog></TrendingBlog>
              <ContentBlog></ContentBlog>
          </Fragment>
      </div>
  )
}

export default HomeBlogContainer