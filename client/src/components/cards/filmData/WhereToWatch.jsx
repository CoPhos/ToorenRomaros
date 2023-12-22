import React from 'react'
import {Link} from 'react-router-dom'

function WhereToWatch({blank}) {
  return blank ? (
      <a
          href="https://www.netflix.com/mx/title/70205012"
          target="_blank"
          className="flex flex-col items-center justify-center gap-1 hover:cursor-pointer group"
      >
          <img
              className="rounded-[50%] object-cover object-center w-[70px] h-[70px]"
              src="https://yt3.googleusercontent.com/ytc/AIf8zZQKCG8w7wVznj9sHhrHge3cKYVuUblDUuOaUp_psQ=s900-c-k-c0x00ffffff-no-rj"
          ></img>
          <p className="text-small-m-400 lg:text-small-d-400 group-hover:text-blue-800">
              Netflix
          </p>
      </a>
  ) : (
      <div>
          <Link
              to="/aasda"
              className="flex flex-col items-center justify-center gap-1 hover:cursor-pointer group"
          >
              <img
                  className="rounded-[50%] object-cover object-center min-w-[70px] min-h-[70px]"
                  src="https://yt3.googleusercontent.com/ytc/AIf8zZQKCG8w7wVznj9sHhrHge3cKYVuUblDUuOaUp_psQ=s900-c-k-c0x00ffffff-no-rj"
              ></img>
              <p className="text-small-m-400 lg:text-small-d-400 group-hover:text-blue-800">
                  Netflix
              </p>
          </Link>
      </div>
  )
}

export default WhereToWatch