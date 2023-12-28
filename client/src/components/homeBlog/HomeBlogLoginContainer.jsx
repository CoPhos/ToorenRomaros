import React, { Fragment, useState } from 'react'
import { Link } from 'react-router-dom'
import Carousel from 'react-elastic-carousel'

function HomeBlogLoginContainer() {
    const [active, setactive] = useState("1")
    
    const show = 'flex flex-col items-center justify-start gap-2'
    const notShow = 'hidden'
    const dynamicClassButton = ''

    const tags = {
        1: "Programming",
        2: "Following",
        3: "Data Science",
        4: "Movies",
        5: "TV shows",
        6: "News",
        7: "On Theaters",
        8: "Upcoming",
        9: "Interviews",
        10: "Behind Scenes"
    }
    const recommended = [
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
    const breakPointsMovie = [
        { width: 1, itemsToShow: 1, itemsToScroll: 1 },
        { width: 200, itemsToShow: 2, itemsToScroll: 2 },
        { width: 270, itemsToShow: 3, itemsToScroll: 3 },
        { width: 380, itemsToShow: 4, itemsToScroll: 4 },
        { width: 460, itemsToShow: 5, itemsToScroll: 5 },
        { width: 672, itemsToShow: 6, itemsToScroll: 6 },
        { width: 768, itemsToShow: 8, itemsToScroll: 8 },
    ]

  return (
      <Fragment>
          <div className="mt-6 flex flex-row items-start gap-3 justify-start">
              <div className="flex flex-col items-start justify-start pr-[24px] grow min-[904px]:basis-9/12">
                  <div className="px-[20px] border-b border-[#F2F2F2] relative overflow-auto w-full">
                      <Carousel
                          pagination={false}
                          enableMouseSwipe={true}
                          itemPadding={[0, 0, 0, 0]}
                          className="carousel"
                          breakPoints={breakPointsMovie}
                      >
                          {Object.entries(tags).map(([key, value]) => {
                              return (
                                  <Button
                                      key={key.toString()}
                                      index={key}
                                      active={active}
                                      text={value}
                                      setactive={setactive}
                                  ></Button>
                              )
                          })}
                      </Carousel>
                  </div>
                  <div className="flex flex-col items-start justify-center mt-4 px-[20px]">
                      <PostCard></PostCard>
                      <PostCard></PostCard>
                      <PostCard></PostCard>
                      <PostCard></PostCard>
                      <PostCard></PostCard>
                      <PostCard></PostCard>
                  </div>
              </div>
              <div className="basis-3/12 hidden min-[904px]:block py-2">
                  <div className="pb-4 border-b border-[#F2F2F2]">
                      <p className="text-small-m-700 lg:text-small-d-700 ">
                          Staff Picks
                      </p>
                      <div className="flex flex-col items-start justify-start gap-2 mt-2">
                          <Recommended></Recommended>
                          <Recommended></Recommended>
                          <Recommended></Recommended>
                      </div>
                  </div>
                  <div className="mt-4 pb-4 border-b border-[#F2F2F2]">
                      <p className="text-small-m-700 lg:text-small-d-700">
                          Recommended topics
                      </p>
                      <div className="flex flex-row items-center justify-start gap-1 flex-wrap mt-2 mb-2">
                          {recommended.map((value, index) => {
                              return <TagCard tag={value} key={index}></TagCard>
                          })}
                      </div>
                      <Link
                          to="/asdasd"
                          className=" text-blue-800 hover:text-blue-600 hover:cursor-pointer text-tiny-m-400 lg:text-tiny-d-400"
                      >
                          See more topics
                      </Link>
                  </div>
                  <div className="mt-3 pb-4 border-b border-[#F2F2F2]">
                      <p className="text-small-m-700 lg:text-small-d-700">
                          Who to follow
                      </p>
                      <div className="flex flex-col items-start justify-start gap-2 mt-2">
                          <FollowCard></FollowCard>
                          <FollowCard></FollowCard>
                          <FollowCard></FollowCard>
                      </div>
                  </div>
              </div>
          </div>
      </Fragment>
  )
}

function Button({ index, active, text, setactive }) {
    const baseClassesButton =
        'whitespace-nowrap text-white-300 text-small-m-400 lg:text-small-d-400 border-[none] hover:cursor-pointer py-1 px-1 '
    const focus = ' text-white-900 border-b-[1px] border-white-950'
    const notFocus = ' border-[none]'
    return (
        <button
            onClick={() => setactive(index)}
            className={`${baseClassesButton} ${
                active === index ? focus : notFocus
            }`}
        >
            {text}
        </button>
    )
}

function TagCard({ tag }) {
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

function Recommended({}){
    return (
        <Link to="/asda">
            <div className="flex flex-row items-center justify-start gap-1 ">
                <img
                    //srcset="https://small 480w, https://medium 800w, https://large 1100w"
                    src="https://image.tmdb.org/t/p/w235_and_h235_face/3dxEx32JnxUO34Wx0Y8tulUwlyh.jpg"
                    alt="Elva dressed as a fairy"
                    className="w-[20px] h-[20px] rounded-[50%] object-cover object-center"
                />
                <p className="capitalize text-tag lg:text-tag ">
                    Cassie Kozyrov
                </p>
            </div>
            <p className="text-small-d-700">
                Birds, bugs, and beauty: The winners of Wiki Loves Earth 2023
            </p>
        </Link>
    )
}

function FollowCard({}) {
    return (
        <div className="flex flex-row items-center justify-start gap-3 w-full">
            <Link
                to="/asda"
                className="flex flex-row items-center justify-start gap-1 group"
            >
                <img
                    //srcset="https://small 480w, https://medium 800w, https://large 1100w"
                    src="https://image.tmdb.org/t/p/w235_and_h235_face/3dxEx32JnxUO34Wx0Y8tulUwlyh.jpg"
                    alt="Elva dressed as a fairy"
                    className="w-[32px] h-[32px] rounded-[50%] object-cover object-center"
                />
                <p className="capitalize text-small-m-700 lg:text-small-d-700 group-hover:text-red-600">
                    Cassie Kozyrov
                </p>
            </Link>
            <button className="py-[5px] px-[12px] rounded-[120px] border border-white-700 text-tag">
                Follow
            </button>
        </div>
    )
}

function PostCard() {
    return (
        <div className="mb-2 col-span-1">
            <div className="flex flex-col items-start justify-start">
                <div>
                    <Link
                        to="/asda"
                        className="flex flex-row items-center justify-start gap-1 group "
                    >
                        <img
                            //srcset="https://small 480w, https://medium 800w, https://large 1100w"
                            src="https://image.tmdb.org/t/p/w235_and_h235_face/3dxEx32JnxUO34Wx0Y8tulUwlyh.jpg"
                            alt="Elva dressed as a fairy"
                            className="w-[24px] h-[24px] rounded-[50%] object-cover object-center"
                        />
                        <p className="capitalize text-tag group-hover:text-red-600 overflow-hidden text-ellipsis line-clamp-1">
                            Cassie Kozyrov
                        </p>
                        <div className="h-[2px] w-[2px] rounded-[50%] bg-white-600 "></div>
                        <p className="text-tiny-m-400 lg:text-tiny-d-400 overflow-hidden text-ellipsis line-clamp-1">
                            Mar 7, 2023
                        </p>
                    </Link>
                </div>
                <div className="flex flex-row items-start justify-start gap-2 pb-3 border-b border-[#F2F2F2]">
                    <div className="flex flex-col items-start justify-start gap-1 basis-4/6 min-[560px]:basis-5/6 ">
                        <Link to="/asdasd">
                            <p className="capitalize overflow-hidden text-ellipsis line-clamp-2 break-words text-body-m-700 lg:text-body-d-700">
                                Willpower Is Not The Solution Willpower Is Not
                                The Solution
                            </p>
                            <p className="hidden min-[643px]:block overflow-hidden text-ellipsis line-clamp-3 break-words text-small-m-400">
                                Visual Studio Code, the popular open-source code
                                editor, received a major update in November 2023
                                with version 1.85. This update brings a slew of
                                new features and improvements that make coding
                                even more
                            </p>
                        </Link>
                        <div className="flex flex-row items-center justify-start gap-1 mt-3">
                            <div className="hidden min-[425px]:flex flex-row items-center justify-center py-[2px] px-1 bg-[#F2F2F2] rounded-lg ">
                                <Link
                                    to="/asdc"
                                    className="capitalize text-tiny-m-400 lg:text-tiny-d-400 tex hover:cursor-pointer hover:text-red-600"
                                >
                                    Programming
                                </Link>
                            </div>
                            <p className="text-white-600 text-tiny-m-400 lg:text-tiny-d-400">
                                12 min reading
                            </p>
                        </div>
                    </div>
                    <Link
                        to="/asdas"
                        className="flex flex-row items-center justify-end basis-2/6 min-[560px]:basis-1/6"
                    >
                        <img
                            //srcset="https://small 480w, https://medium 800w, https://large 1100w"
                            src="https://image.tmdb.org/t/p/w235_and_h235_face/3dxEx32JnxUO34Wx0Y8tulUwlyh.jpg"
                            alt="Elva dressed as a fairy"
                            className="w-[80px] h-[56px] min-[725px]:w-[112px] min-[725px]:h-[112px] object-cover object-center"
                        />
                    </Link>
                </div>
            </div>
        </div>
    )
}
export default HomeBlogLoginContainer