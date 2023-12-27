import React from 'react'
import {Link} from 'react-router-dom'

function Cast({data}) {
  return (
    
      <Link
          to="/asdhasd"
          className="flex flex-col items-start justify-center max-w-[120px] mt-2 group"
      >
          <img
              //srcset="https://small 480w, https://medium 800w, https://large 1100w"
              src="https://m.media-amazon.com/images/M/MV5BM2U5NTc1YWYtMTBlYi00Yjg0LTgwMjUtNDM5MjdkZDgwODMwXkEyXkFqcGdeQXVyMTUzMTg2ODkz._V1_FMjpg_UX1000_.jpg"
              alt="Elva dressed as a fairy"
              className="w-[120px] h-[140px] object-cover object-center rounded-md"
          />
          <p className="text-small-m-400 lg:text-small-d-400 group-hover:text-red-600 w-[full] overflow-hidden text-ellipsis line-clamp-3 break-words">
              {data.name}
          </p>
          <p className="text-tiny-m-400 lg:text-tiny-d-400 group-hover:text-red-600 w-[full] overflow-hidden text-ellipsis line-clamp-3 break-words">
              {data.as}
          </p>
          <p className="text-tiny-m-400 lg:text-tiny-d-400 group-hover:text-red-600 w-[full] overflow-hidden text-ellipsis line-clamp-3 break-words">
              {data.role}
          </p>
      </Link>
  )
}

export default Cast