import React, { useState } from 'react'
import Cast from './Cast'

function CastContainer({ cast }) {
    const [show, setshow] = useState(false)
    const baseClasses =
        'flex flex-row items-center justify-start gap-2 flex-wrap overflow-hidden'

    const dynamicClass = show ? 'max-h-max' : 'max-h-[250px]'

    const toggle = () => {
        setshow(!show)
    }


    return (
        <div className="flex flex-col items-start justify-start">
            <div className={`${baseClasses} ${dynamicClass}`}>
                {Object.entries(cast).map(([key, value]) => {
                    return <Cast key={key.toString()} data={value}></Cast>
                })}
            </div>
            <button
                onClick={toggle}
                className="self-end bg-white-50 hover:cursor-pointer border-none text-small-m-400 lg:text-small-d-400 text-blue-800 hover:text-blue-600"
            >
                {show ? 'Hide Cast & Crew' : 'Show All Cast & Crew'}
            </button>
        </div>
    )
}

export default CastContainer