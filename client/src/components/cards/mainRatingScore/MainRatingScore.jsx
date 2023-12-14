import React from 'react'
import {Link} from 'react-router-dom'


function MainRatingScore({data}) {
    
    const greenBar =
        Math.round((data.rating.positive * 100) / data.rating.total) + '%'
    const yellowBar =
        Math.round((data.rating.neutral * 100) / data.rating.total) + '%'
    const redBar = Math.round((data.rating.negative * 100) / data.rating.total) + '%'

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
                    <div className="flex items-center justify-center bg-green-600 rounded-xl h-[64px] w-[64px]">
                        <p className="text-[36px] font-bold text-white-50">87</p>
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