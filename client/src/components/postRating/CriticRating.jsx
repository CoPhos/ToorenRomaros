import React from 'react'
import { Link } from 'react-router-dom'
function CriticRating({ hoveredIndex, filmId }) {
    let dynamicClasses

    if (hoveredIndex <= 40) {
        dynamicClasses = 'bg-red-600'
    } else if (hoveredIndex < 70 && hoveredIndex > 40) {
        dynamicClasses = 'bg-[#ffbd3f]'
    } else {
        dynamicClasses = 'bg-green-600'
    }

    const baseClassesRating =
        'flex items-center justify-center rounded-xl h-[64px] w-[64px]'
    return (
        <div className="flex flex-col">
            <div className="flex flex-row items-center justify-between w-full mt-2">
                <div className="flex flex-col items-start justify-center">
                    <p className="text-body-m-300 lg:text-body-d-300">
                        My Score
                    </p>
                </div>
                <div>
                    <div className={`${baseClassesRating} ${dynamicClasses}`}>
                        <p className="text-[36px] font-bold text-white-50">
                            {hoveredIndex}
                        </p>
                    </div>
                </div>
            </div>
            <div className="mt-2 text-center rounded-md border-[1px] border-white-200 w-full  hover:border-white-600 h-[36px]">
                <Link
                    to={`/editor/${filmId}`}
                    className="text-small-m-400  lg:text-small-d-400 hover:text-white-500"
                >
                    Create a New Post Review
                </Link>
            </div>
        </div>
    )
}

export default CriticRating