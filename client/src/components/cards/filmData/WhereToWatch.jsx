import React from 'react'
import { BASE_URL } from '../../../utils/constants'

function WhereToWatch({ data }) {
    return (
        <a
            href={`${data.url}`}
            target="_blank"
            className="flex flex-col items-center justify-start gap-1 hover:cursor-pointer group h-[150px] mx-auto"
        >
            <img
                className="rounded-[50%] object-cover object-center w-[70px] h-[70px]"
                src={`${BASE_URL}/images/${data.images.id}`}
            ></img>

            <div className="flex flex-col items-center justify-start">
                <p className="text-tiny-m-400 lg:text-tiny-d-400 group-hover:text-red-600  overflow-hidden text-ellipsis line-clamp-2 break-words max-w-[85px] text-center">
                    {data.streamSiteName}
                </p>
                <p className="text-tiny-m-400 lg:text-tiny-d-400 group-hover:text-red-600 overflow-hidden text-ellipsis line-clamp-2 break-words max-w-[85px] text-center">
                    {data.rent ? 'Rent' : ''}
                </p>
                <p className="text-tiny-m-400 lg:text-tiny-d-400 group-hover:text-red-600 overflow-hidden text-ellipsis line-clamp-2 break-words max-w-[85px] text-center">
                    {data.buy ? 'Buy' : ''}
                </p>
            </div>
        </a>
    )
}

export default WhereToWatch