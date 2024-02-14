import React from 'react'
import {Link} from 'react-router-dom'
import { BASE_URL } from '../../../utils/constants'

function VideoCard({ videoType, tittle, text, to, image }) {
    return (
        <Link
            to={to}
            className="w-[320px] md:w-[265px] group hover:cursor-pointer h-[290px]"
        >
            <div className="w-[320px] md:w-[265px] h-[151px] relative">
                <img
                    src={`${BASE_URL}/images/${image}`}
                    alt="Elva dressed as a fairy"
                    className="w-full h-[151px] object-cover object-center"
                />
                <div className="min-h-[22px] absolute left-[1px] right-0 bottom-[0px] overflow-hidden bg-red-700 rounded-[4px]">
                    <p className="text-white-50 overflow-hidden text-ellipsis line-clamp-1 text-small-m-300 lg:text-small-d-300 px-0.5">
                        {videoType}
                    </p>
                </div>
            </div>
            <div>
                <p className="text-body-m-700 lg:text-body-d-700 group-hover:text-red-600 overflow-hidden text-ellipsis line-clamp-3">
                    {tittle}
                </p>
                <p className="text-small-m-400 lg:text-small-d-400 group-hover:text-red-600 overflow-hidden text-ellipsis line-clamp-2">
                    {text}
                </p>
            </div>
        </Link>
    )
}

export default VideoCard