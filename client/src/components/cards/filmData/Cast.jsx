import React from 'react'
import {Link} from 'react-router-dom'
import { BASE_URL } from '../../../utils/constants'

function Cast({data}) {
  return (
      <Link
          to="/asdhasd"
          className="flex flex-col items-start h-[205px] justify-start max-w-[120px] mt-2 group"
      >
          <img
              //srcset="https://small 480w, https://medium 800w, https://large 1100w"
              src={`${BASE_URL}/images/${data.images.id}`}
              alt="Elva dressed as a fairy"
              className="w-[120px] h-[140px] object-cover object-center rounded-md"
          />
          <p className="text-small-m-400 lg:text-small-d-400 group-hover:text-red-600 w-[full] overflow-hidden text-ellipsis line-clamp-3 break-words">
              {data.staffName}
          </p>
          <p className="text-tiny-m-400 lg:text-tiny-d-400 group-hover:text-red-600 w-[full] overflow-hidden text-ellipsis line-clamp-3 break-words">
              {data.appearAs == null ? data.appearAs : ''}
          </p>
          <p className="text-tiny-m-400 lg:text-tiny-d-400 group-hover:text-red-600 w-[full] overflow-hidden text-ellipsis line-clamp-3 break-words">
              {data.role}
          </p>
      </Link>
  )
}

export default Cast