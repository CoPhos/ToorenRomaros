import React, { Fragment } from 'react'
import {Link} from 'react-router-dom'
import RatingBar from './RatingBar';

function ReviewRating({ tittle, totalScore, data, viewAll, to }) {
    const total = data.positive + data.negative + data.neutral
    const greenBar = Math.round((data.positive * 100) / total) + '%'
    const yellowBar = Math.round((data.neutral * 100) / total) + '%'
    const redBar = Math.round((data.negative * 100) / total) + '%'

    let dynamicClasses
    let totalScoreText
    const baseClassesRating =
        'flex items-center justify-center rounded-xl h-[64px] w-[64px] hover:cursor-pointer'
    if (totalScore < 40) {
        dynamicClasses = 'bg-red-600'
        totalScoreText = 'Generally Unfavorable'
    } else if (totalScore < 70 && totalScore >= 40) {
        dynamicClasses = 'bg-[#ffbd3f]'
        totalScoreText = 'Mixed or Average'
    } else {
        dynamicClasses = 'bg-green-600'
        totalScoreText = 'Generally Favorable'
    }
    return (
        <div className="flex flex-col items-start justify-center w-full gap-2">
            <div className="flex flex-row items-center justify-between border-b-[1px] border-white-400 w-full pb-1">
                <p className="text-h3-m-700 lg:text-h3-d-700">{tittle}</p>
                {viewAll ? (
                    <Link
                        to={to}
                        className="text-small-m-400 lg:text-small-d-400 text-blue-800 hover:text-blue-600"
                    >
                        VIEW ALL
                    </Link>
                ) : (
                    ''
                )}
            </div>

            <Fragment>
                <div className="w-full">
                    <div className="flex flex-row items-center justify-start gap-2 w-full">
                        <Link
                            to={to}
                            className={`${baseClassesRating} ${dynamicClasses}`}
                        >
                            <p className="text-[36px] font-bold text-white-50">
                                {totalScore}
                            </p>
                        </Link>

                        <div className="flex flex-col items-start justify-center">
                            <p className="text-tiny-m-400 text-white-700 tracking-[4px] mb-1 lg:tracking-[4px] lg:text-tiny-d-400">
                                {tittle}
                            </p>
                            <p className="text-small-m-700 lg:text-small-d-700">
                                {totalScoreText}
                            </p>
                            <Link
                                to={to}
                                className="text-small-m-400 lg:text-small-d-400 hover:text-red-600 hover:cursor-pointer"
                            >
                                Based on {total + ' ' + tittle}
                            </Link>
                        </div>
                    </div>
                </div>

                <div className="w-full border-b-[1px] border-white-400 pb-4">
                    {Object.entries(data).map(([key, value]) => {
                        return (
                            <RatingBar
                                key={key}
                                keyValue={key}
                                value={value}
                                barValues={{ greenBar, yellowBar, redBar }}
                                to={to}
                            ></RatingBar>
                        )
                    })}
                </div>
            </Fragment>
        </div>
    )
}

export default ReviewRating