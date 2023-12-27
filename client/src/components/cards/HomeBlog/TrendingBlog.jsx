import React from 'react'
import {Link} from 'react-router-dom'

function TrendingBlog() {
  return (
      <div className="flex flex-col items-start justify-start gap-1 mt-6 border-b pb-6 border-[#F2F2F2]">
          <div className="flex flex-row items-center justify-center gap-1">
              <svg
                  width="20"
                  height="20"
                  viewBox="0 0 20 20"
                  fill="none"
                  xmlns="http://www.w3.org/2000/svg"
              >
                  <g clipPath="url(#clip0_526_17442)">
                      <path
                          d="M9.70937 0H10.2941C13.1949 0.0976562 15.9043 1.42656 17.7215 3.64531C19.1514 5.39062 19.9109 7.4125 20 9.71094V10.2949C19.9051 13.0383 18.7113 15.6258 16.6902 17.4316C14.8835 19.0465 12.7479 19.9026 10.2836 20H9.71289C6.80273 19.9004 4.09102 18.5723 2.27031 16.3434C0.847396 14.602 0.090625 12.5878 0 10.3008V9.69258C0.104167 7.22409 0.967708 5.08776 2.59062 3.28359C3.40234 2.38125 4.37214 1.64219 5.5 1.06641C6.79115 0.407031 8.19427 0.0515625 9.70937 0ZM6.63086 18.0707C8.4293 18.8246 10.2854 18.9687 12.1992 18.5031C12.4562 18.4406 12.7115 18.3638 12.9648 18.2727C15.657 17.3035 17.6648 15.1309 18.4531 12.3895C18.8016 11.1762 18.875 9.87109 18.6754 8.63906C18.3579 6.67943 17.4798 5.00729 16.041 3.62266C14.6262 2.26094 12.7672 1.44453 10.827 1.25117C9.53203 1.12187 8.20273 1.29922 7.00547 1.73672C2.45391 3.39922 0.128906 8.48906 1.81172 13.0266C2.65781 15.3082 4.39922 17.1352 6.63086 18.0707Z"
                          fill="black"
                      />
                      <path
                          d="M14.1083 9.25667C14.1083 9.25525 14.1079 9.25385 14.1072 9.25265C14.1064 9.25145 14.1053 9.25052 14.104 9.24997C14.1027 9.24942 14.1012 9.24928 14.0998 9.24957C14.0984 9.24986 14.0972 9.25056 14.0962 9.25159C13.1391 10.2151 12.157 11.1992 11.1497 12.2039C10.8079 12.545 10.4118 12.5782 10.0591 12.2278C9.52782 11.7004 8.90972 11.0832 8.20477 10.3762C8.20218 10.3736 8.19864 10.3721 8.19492 10.3721C8.1912 10.3721 8.18758 10.3736 8.18485 10.3762C7.40828 11.1541 6.59617 11.9694 5.74852 12.8223C5.6618 12.9098 5.57925 12.9722 5.50086 13.0094C5.05633 13.2215 4.47547 12.8821 4.53641 12.3653C4.55907 12.1742 4.65008 11.986 4.78328 11.8524C5.72313 10.9081 6.70164 9.92802 7.71883 8.91214C8.01805 8.61292 8.44735 8.67815 8.73407 8.96448C9.3325 9.5624 9.93615 10.1663 10.545 10.7762C10.5531 10.7843 10.5613 10.7841 10.5696 10.7758L13.0321 8.31331C13.0467 8.29847 13.0436 8.29105 13.0227 8.29105C12.623 8.28766 12.2173 8.28493 11.8055 8.28284C10.8845 8.27776 10.8856 6.9348 11.8005 6.93011C12.7906 6.9249 13.8016 6.92555 14.8337 6.93206C15.086 6.93362 15.3106 7.08675 15.4106 7.318C15.4442 7.39638 15.4613 7.50276 15.4618 7.63714C15.4662 8.75641 15.4654 9.75459 15.4595 10.6317C15.4548 11.3543 14.4345 11.5207 14.1673 10.8864C14.1259 10.7879 14.1062 10.6447 14.1083 10.4567C14.1127 10.0515 14.1127 9.65146 14.1083 9.25667Z"
                          fill="black"
                      />
                  </g>
                  <defs>
                      <clipPath id="clip0_526_17442">
                          <rect width="20" height="20" fill="white" />
                      </clipPath>
                  </defs>
              </svg>

              <p className="text-small-m-700 lg:text-small-d-700">
                  Trending on Cinnabar
              </p>
          </div>
          <div className="grid grid-cols-1 min-[595px]:grid-cols-2 min-[810px]:grid-cols-3">
              {new Array(6).fill(null).map((_, index) => {
                  return <Card index={index + 1} key={index}></Card>
              })}
          </div>
      </div>
  )
}

function Card({index}) {
    return (
        <div className="mb-2 col-span-1">
            <div className="flex flex-row items-start justify-start">
                <div className="flex items-start justify-center mr-1">
                    <p className="text-number text-white-300">{'0' + index}</p>
                </div>
                <div className="flex flex-col items-start justify-start gap-1 pt-[4px]">
                    <Link
                        to="/cxcv"
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
                    </Link>
                    <div className="flex flex-row items-center justify-start gap-1">
                        <p className="text-tiny-m-400 lg:text-tiny-d-400">
                            Dec 20
                        </p>
                        <div className="h-[2px] w-[2px] rounded-[50%] bg-white-600 "></div>

                        <p className="text-tiny-m-400 lg:text-tiny-d-400">
                            12 min reading
                        </p>
                        <div className="h-[2px] w-[2px] rounded-[50%] bg-white-600"></div>

                        <div className="flex flex-row items-center justify-center py-[4px] px-1 bg-[#F2F2F2] rounded-lg ">
                            <Link
                                to="/asdc"
                                className="capitalize text-tiny-m-400 lg:text-tiny-d-400 tex hover:cursor-pointer hover:text-red-600"
                            >
                                Programming
                            </Link>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    )
}

export default TrendingBlog