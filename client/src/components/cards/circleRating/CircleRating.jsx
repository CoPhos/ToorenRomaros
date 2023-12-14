import React from 'react'

function CircleRating({ bgColor, number, handleMouseEnter }) {
    const baseClasses =
        'flex items-center justify-center rounded-[50%] w-[44px] h-[44px] hover:cursor-pointer'
    const dynamicClasses = bgColor
    return (
        <div
            className={`${baseClasses} ${dynamicClasses}`}
            onMouseEnter={handleMouseEnter}
        >
            <p className="w-fit h-fit text-body-b-700 text-white-50">
                {number}
            </p>
        </div>
    )
}

export default CircleRating