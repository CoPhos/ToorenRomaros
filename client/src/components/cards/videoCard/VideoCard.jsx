import React from 'react'
import {Link} from 'react-router-dom'

function VideoCard({ videoType, tittle, text, to }) {
    return (
        <Link to="/asdas" className="w-[320px] md:w-[265px] group hover:cursor-pointer">
            <div class="w-[320px] h-[178px] md:w-[265px] md:h-[151px] relative">
                <img
                    //srcset="https://small 480w, https://medium 800w, https://large 1100w"
                    src="https://blog-admin.siriusxm.com/wp-content/uploads/2023/07/barbie-interview.jpg"
                    alt="Elva dressed as a fairy"
                    className="w-full h-[178px] lg:h-[151px] object-cover object-center"
                />
                <div className="min-h-[22px] absolute left-[1px] right-0 bottom-[0px] overflow-hidden bg-blue-800 rounded-[4px]">
                    <p className="text-white-50 overflow-hidden text-ellipsis line-clamp-1 text-small-m-300 lg:text-small-d-300 px-0.5">
                        {videoType}
                    </p>
                </div>
            </div>
            <div>
                <p className="text-body-m-700 lg:text-body-d-700 group-hover:text-blue-700">
                    {tittle}
                </p>
                <p className="text-small-m-400 lg:text-small-d-400 group-hover:text-blue-700">
                    {text}
                </p>
            </div>
        </Link>
    )
}

export default VideoCard