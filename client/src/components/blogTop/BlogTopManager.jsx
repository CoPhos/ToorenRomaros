import React from 'react'
import BlogTopContainer from './BlogTopContainer';

function BlogTopManager() {
    const data = {
        0: {
            text: 'Spring/SpringBoot Interview Questions and Answers Series 2',
        },
        1: {
            text: 'Spring/SpringBoot Interview Questions and Answers Series 2',
        },
        2: {
            text: 'Spring/SpringBoot Interview Questions and Answers Series 2',
        },
        3: {
            text: 'Spring/SpringBoot Interview Questions and Answers Series 2',
        },
    } 
  return (
    <BlogTopContainer data={data}></BlogTopContainer>
  )
}

export default BlogTopManager