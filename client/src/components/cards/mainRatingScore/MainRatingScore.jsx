import React from 'react'
import { Link, useLocation } from 'react-router-dom'


function MainRatingScore({ data, totalScore,to }) {
    const location = useLocation()
    const pathname = location.pathname
    const total = data.positive + data.negative + data.neutral
    const greenBar = Math.round((data.positive * 100) / total) + '%'
    const yellowBar = Math.round((data.neutral * 100) / total) + '%'
    const redBar = Math.round((data.negative * 100) / total) + '%'

    const baseClassesRating =
        'flex items-center justify-center rounded-xl h-[64px] w-[64px]'

    let dynamicClasses
    let totalScoreText

    if (totalScore <= 40) {
        dynamicClasses = 'bg-red-500'
        totalScoreText = 'Generally Unfavorable'
    } else if (totalScore < 70 && totalScore > 40) {
        dynamicClasses = 'bg-[#ffbd3f]'
        totalScoreText = 'Mixed or Average'
    } else {
        dynamicClasses = 'bg-green-600'
        totalScoreText = 'Generally Favorable'
    }

    return (
        <div className="flex flex-col items-start justify-center w-full">
            <div className="flex flex-row items-center justify-between w-full mt-2">
                <div className="flex flex-col items-start justify-center">
                    <p className="text-body-m-300 lg:text-body-d-300">
                        METASCORE
                    </p>
                    <p className="text-small-m-700 lg:text-small-d-700">
                        {totalScoreText}
                    </p>
                    <Link
                        to={to}
                        className="text-small-d-400 lg:text-small-d-400 underline hover:cursor-pointer hover:text-blue-800"
                    >
                        Based on {total} Critic Reviews
                    </Link>
                </div>
                <div>
                    <div className={`${baseClassesRating} ${dynamicClasses}`}>
                        <p className="text-[36px] font-bold text-white-50">
                            {totalScore}
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