import React, { useState, Fragment } from 'react'
import { Link } from 'react-router-dom'

import ReviewCard from '../cards/filmData/ReviewCard'

function ReviewPanel({ expand, to, data, critic}) {
    const [active, setactive] = useState(1)
    const baseClassesButton =
        'text-white-300 text-small-m-400 lg:text-small-d-400 border-[none] hover:cursor-pointer py-2 px-1'
    const focus = 'text-white-900 border-t-[1px] border-white-950'
    const notFocus = 'border-[none]'
    const show = 'flex flex-col items-center justify-start gap-2 w-full'
    const notShow = 'hidden'
    const dynamicClassButton = ''
    const filteredData = (requirement) => {
        if (requirement == 'positive') {
            return data.filter((item) => item.rating >= 70)
        } else if (requirement == 'neutral') {
            return data.filter((item) => item.rating >= 40 && item.rating < 70)
        } else if (requirement == 'negative') {
            return data.filter((item) => item.rating < 40)
        } else return data
    }
    return (
        <Fragment>
            <div className="grow mb-2 w-full">
                <div className="flex flex-row items-center justify-around w-full">
                    <button
                        onClick={() => setactive(1)}
                        className={`${baseClassesButton} ${
                            active === 1 ? focus : notFocus
                        }`}
                    >
                        All Reviews
                    </button>
                    <button
                        onClick={() => setactive(2)}
                        className={`${baseClassesButton} ${
                            active === 2 ? focus : notFocus
                        }`}
                    >
                        Postive Reviews
                    </button>
                    <button
                        onClick={() => setactive(3)}
                        className={`${baseClassesButton} ${
                            active === 3 ? focus : notFocus
                        }`}
                    >
                        Mixed Reviews
                    </button>
                    <button
                        onClick={() => setactive(4)}
                        className={`${baseClassesButton} ${
                            active === 4 ? focus : notFocus
                        }`}
                    >
                        Negative Reviews
                    </button>
                </div>
            </div>
            <div className={`${active === 1 ? show : notShow}`}>
                {filteredData('all').map((item) => (
                    <ReviewCard
                        key={item.id}
                        expand={expand}
                        data={item}
                        critic={critic}
                    ></ReviewCard>
                ))}
            </div>

            <div className={`${active === 2 ? show : notShow}`}>
                {filteredData('positive').map((item) => (
                    <ReviewCard
                        key={item.id}
                        expand={expand}
                        data={item}
                        critic={critic}
                    ></ReviewCard>
                ))}
            </div>

            <div className={`${active === 3 ? show : notShow}`}>
                {filteredData('neutral').map((item) => (
                    <ReviewCard
                        key={item.id}
                        expand={expand}
                        data={item}
                        critic={critic}
                    ></ReviewCard>
                ))}
            </div>

            <div className={`${active === 4 ? show : notShow}`}>
                {filteredData('negative').map((item) => (
                    <ReviewCard
                        key={item.id}
                        expand={expand}
                        data={item}
                        critic={critic}
                    ></ReviewCard>
                ))}
            </div>

            <Link
                to={to}
                className="flex flex-row items-center justify-center mt-2 w-full rounded bg-[#404040] py-1 h-full hover:cursor-pointer hover:opacity-50"
            >
                <p className="text-white-50 text-small-m-400 lg:text-small-d-400">
                    See All Reviews
                </p>
            </Link>
        </Fragment>
    )
}

export default ReviewPanel
