import React from 'react'
import BlogCard from '../cards/blogCard/BlogCard';

function BlogTopContainer({data}) {
  return (
      <div
          className="flex flex-col items-center justify-center my-3
            ml-1 sm:grid sm:grid-cols-2 sm:justify-items-center min-[1080px]:flex min-[1080px]:flex-row min-[1080px]:justify-between"
      >
          {Object.values(Object.values(data)).map((value, index) => {
              return <BlogCard key={index} text={value.text}></BlogCard>
          })}
      </div> 
  )
}

export default BlogTopContainer