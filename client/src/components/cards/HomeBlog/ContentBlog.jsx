import React from 'react'
import {Link} from 'react-router-dom'

function ContentBlog() {
    const tags = [
        'Movie Previews',
        'Behind the Scenes',
        'Movie Reviews',
        'Netflix',
        'Drama Series',
        'Animation',
        'Fantasy Series',
        'HBO Max',
        'Mystery',
    ]
  return (
      <div className="mt-6 grid grid-rows-[160px,1fr] grid-cols-1 min-[900px]:grid-rows-1 min-[900px]:grid-cols-12">
          <div className="row-start-2 row-end-3 min-[900px]:row-span-1 min-[900px]:col-start-1 min-[900px]:col-end-8 max-[899px]:mt-[62px]">
              {new Array(12).fill(null).map((_, index) => {
                  return <PostCard key={index}></PostCard>
              })}
          </div>
          <div className="h-fit row-start-1 row-end-2 border-b pb-5 border-[#F2F2F2] min-[900px]:row-span-1 min-[900px]:col-start-9 min-[900px]:col-end-13">
              <div className="pb-2">
                  <p className="text-small-m-700 lg:text-small-d-700">
                      Discover more of what matters to you
                  </p>
                  <div className="flex flex-row items-center justify-start gap-1 flex-wrap mt-2">
                      {tags.map((value, index) => {
                          return <TagCard tag={value} key={index}></TagCard>
                      })}
                  </div>
              </div>
          </div>
      </div>
  )
}

function PostCard(){
    return (
        <div className="mb-2 col-span-1">
            <div className="flex flex-row items-start justify-start gap-2">
                <div className="flex flex-col items-start justify-start gap-1 basis-4/6">
                    <Link
                        to="/asda"
                        className="flex flex-row items-center justify-start gap-1 group"
                    >
                        <img
                            //srcset="https://small 480w, https://medium 800w, https://large 1100w"
                            src="https://image.tmdb.org/t/p/w235_and_h235_face/3dxEx32JnxUO34Wx0Y8tulUwlyh.jpg"
                            alt="Elva dressed as a fairy"
                            className="w-[20px] h-[20px] rounded-[50%] object-cover object-center"
                        />
                        <p className="capitalize text-tiny-m-400 lg:text-tiny-d-400 group-hover:text-red-600">
                            Cassie Kozyrov
                        </p>
                    </Link>
                    <Link to="/asdasd">
                        <p className="capitalize overflow-hidden text-ellipsis line-clamp-2 break-words text-small-m-700 lg:text-small-d-700">
                            Willpower Is Not The Solution Willpower Is Not The
                            Solution
                        </p>
                        <p className="hidden min-[643px]:block overflow-hidden text-ellipsis line-clamp-3 break-words text-tag text-white-300">
                            Visual Studio Code, the popular open-source code
                            editor, received a major update in November 2023
                            with version 1.85. This update brings a slew of new
                            features and improvements that make coding even more
                        </p>
                    </Link>
                    <div className="flex flex-row items-center justify-start gap-1">
                        <p className="text-tiny-m-400 lg:text-tiny-d-400">
                            Dec 20
                        </p>
                        <div className="h-[2px] w-[2px] rounded-[50%] bg-white-600 "></div>

                        <p className="text-tiny-m-400 lg:text-tiny-d-400">
                            12 min reading
                        </p>
                        <div className="hidden min-[425px]:flex h-[2px] w-[2px] rounded-[50%] bg-white-600"></div>

                        <div className="hidden min-[425px]:flex flex-row items-center justify-center py-[4px] px-1 bg-[#F2F2F2] rounded-lg ">
                            <Link
                                to="/asdc"
                                className="capitalize text-tiny-m-400 lg:text-tiny-d-400 tex hover:cursor-pointer hover:text-red-600"
                            >
                                Programming
                            </Link>
                        </div>
                    </div>
                </div>
                <Link to="/asdas" className="flex items-start justify-center basis-2/6">
                    <img
                        //srcset="https://small 480w, https://medium 800w, https://large 1100w"
                        src="https://image.tmdb.org/t/p/w235_and_h235_face/3dxEx32JnxUO34Wx0Y8tulUwlyh.jpg"
                        alt="Elva dressed as a fairy"
                        className="w-[150px] h-[100px] min-[643px]:w-[200px] min-[643px]:h-[134px] object-cover object-center"
                    />
                </Link>
            </div>
        </div>
    )
}

function TagCard({tag}){
    return (
        <div className="flex flex-row items-center justify-center py-1 px-2 bg-[#F2F2F2] rounded-[100px]">
            <Link
                to="/asdc"
                className="capitalize text-tag hover:cursor-pointer hover:text-red-600"
            >
                {tag}
            </Link>
        </div>
    )
}

export default ContentBlog