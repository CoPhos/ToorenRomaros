import React from 'react'
import {Link} from 'react-router-dom'

function RatingBar({ keyValue, value, barValues }) {
    const bgColor =
        keyValue == 'positive'
            ? 'bg-green-600'
            : keyValue == 'neutral'
            ? 'bg-[#ffbd3f]'
            : 'bg-red-500'
    const baseClassesMainBar = 'h-[3px]'
    const baseClassesSecondBar = baseClassesMainBar + ' opacity-30'

    const width =
        keyValue == 'positive'
            ? barValues.greenBar
            : keyValue == 'neutral'
            ? barValues.yellowBar
            : barValues.redBar

    return (
        <Link
            to="/allratings"
            className="flex flex-col items-start justify-center w-full hover:cursor-pointer group"
        >
            <div className="flex flex-row items-center justify-between w-full">
                <p className="text-tiny-m-400 lg:text-tiny-d-400 group-hover:text-blue-800">
                    {value + ' ' + keyValue + ' ratings'}
                </p>
                <p className="text-tiny-m-400 lg:text-tiny-d-400 group-hover:text-blue-800">
                    {width}
                </p>
            </div>
            <div className="flex flex-row items-center justify-start w-full ">
                <div
                    className={`${baseClassesMainBar} ${bgColor}`}
                    style={{ width: width }}
                ></div>
                <div
                    className={`${baseClassesSecondBar} ${bgColor}`}
                    style={{ width: `calc(100% - ${width})` }}
                ></div>
            </div>
        </Link>
    )
}

export default RatingBar