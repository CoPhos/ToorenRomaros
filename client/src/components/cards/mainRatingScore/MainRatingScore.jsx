import React from 'react'
import {Link} from 'react-router-dom'


function MainRatingScore({data}) {
    
    const greenBar =
        Math.round((data.rating.positive * 100) / data.rating.total) + '%'
    const yellowBar =
        Math.round((data.rating.neutral * 100) / data.rating.total) + '%'
    const redBar = Math.round((data.rating.negative * 100) / data.rating.total) + '%'

    const baseClassesRating =
        'flex items-center justify-center rounded-xl h-[64px] w-[64px]'
    
    const dynamicClasses =
        data.value <= 40
            ? 'bg-red-500'
            : data.value < 70 && data.value > 40
            ? 'bg-[#ffbd3f]'
            : 'bg-green-600'

    return (
        <div className="flex flex-col items-start justify-center w-full">
            <div className="flex flex-row items-center justify-between w-full mt-2">
                <div className="flex flex-col items-start justify-center">
                    <p className="text-body-m-300 lg:text-body-d-300">
                        METASCORE
                    </p>
                    <p className="text-small-m-700 lg:text-small-d-700">
                        Universal Acclaim
                    </p>
                    <Link
                        to="/asdas"
                        className="text-small-d-400 lg:text-small-d-400 underline hover:cursor-pointer hover:text-blue-800"
                    >
                        Based on 54 Critic Reviews
                    </Link>
                </div>
                <div>
                    <div className={`${baseClassesRating} ${dynamicClasses}`}>
                        <p className="text-[36px] font-bold text-white-50">
                            {data.value}
                        </p>
                    </div>
                </div>
            </div>
            <div className="flex flex-row items-center justify-start w-full mt-1">
                <div
                    className="bg-green-600 h-1"
                    style={{ width: greenBar }}
                ></div>
                <div
                    className="bg-[#ffbd3f] h-1"
                    style={{ width: yellowBar }}
                ></div>
                <div className="bg-red-500 h-1" style={{ width: redBar }}></div>
            </div>
        </div>
    )
}

export default MainRatingScore