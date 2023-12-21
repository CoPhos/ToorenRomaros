import React from 'react'
import { Link } from 'react-router-dom'

function BlogCard({text}) {
  return (
      <Link
          to="/asdas"
          className="w-[95vw] group hover:cursor-pointer sm:grow sm:w-10/12 min-[1080px]:w-[265px] min-[1080px]:grow-0"
      >
          <div className="w-full">
              <img
                  //srcset="https://small 480w, https://medium 800w, https://large 1100w"
                  src="https://i.ytimg.com/vi/OVnzpfDgvME/maxresdefault.jpg"
                  alt="Elva dressed as a fairy"
                  className="w-full h-auto min-[1080px]:w-[265px] min-[1080px]:h-[151px] object-cover object-center"
              />
              <p className="text-small-m-400 min-[1080px]:text-small-d-400 group-hover:text-blue-700">
                  {text}
              </p>
          </div>
      </Link>
  )
}

export default BlogCard