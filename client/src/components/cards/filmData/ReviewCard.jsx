import React, { useState, createRef, useEffect, Fragment } from 'react'
import {Link} from 'react-router-dom'

function ReviewCard({expand}) {
    const [height, setHeight] = useState(0)
    const [show, setshow] = useState(false)
    
    const toggle = () => {
        setshow(!show)
    }
    const elementRef = createRef(null)

    useEffect(() => {
        setHeight(elementRef.current.offsetHeight)
    }, [])

    const text = `styled-components utilises tagged template literals to style your
              components. It removes the mapping between components and styles.
              This means that when you're defining your styles, you're actually
              creating a normal React component, that has your styles attached
              to it. This example creates two simple components, a wrapper and a
              title, with some styles attached to it:`

    const data = 99
    const baseClassesRating =
        'flex items-center justify-center rounded-xl h-[56px] w-[56px]'
    const dynamicClasses =
        data.value <= 40
            ? 'bg-red-500'
            : data.value < 70 && data.value > 40
            ? 'bg-[#ffbd3f]'
            : 'bg-green-600'

    const baseClassesText = 'text-small-m-400 lg:text-small-d-400 break-words'
    const dynamicClassesText = 
    show
        ? 'line-clamp-[unset]'
        : ' overflow-hidden text-ellipsis line-clamp-4'

    let textComponent 
     if (!expand) {
         textComponent = (
             <div>
                 <p
                     ref={elementRef}
                     className={`${
                         baseClassesText +
                         ' overflow-hidden text-ellipsis line-clamp-4'
                     }`}
                 >
                     {text}
                 </p>
                 &nbsp;
                 <Link
                     to="/blog"
                     className="hover:cursor-pointer text-blue-800 hover:text-blue-600"
                 >
                     See full review
                 </Link>
             </div>
         )
     } else if (height > 85) {
         textComponent = (
             <Fragment>
                 <p
                     ref={elementRef}
                     className={`${baseClassesText} ${dynamicClassesText}`}
                 >
                     {text}
                 </p>
                 <button
                     onClick={toggle}
                     className="self-end bg-white-50 max-w-[80px] border-none hover:cursor-pointer text-small-m-700 lg:text-small-d-700"
                 >
                     {show ? 'Collapse' : 'Expand'}
                 </button>
             </Fragment>
         )
     } else {
        textComponent = (
            <p
                ref={elementRef}
                className={'text-small-m-400 lg:text-small-d-400 break-words'}
            >
                {text}
            </p>
        )
     }
        
    return (
        <div className="flex flex-col items-start justify-center">
            <Link
                to="/user123"
                className="flex flex-row items-center justify-start gap-1 group hover:cursor-pointer"
            >
                <div className={`${baseClassesRating} ${dynamicClasses}`}>
                    <p className="text-[36px] font-bold text-white-50">
                        {data}
                    </p>
                </div>
                <div className="flex flex-col items-start justify-center">
                    <p className="text-small-m-400 lg:text-small-d-400 group-hover:text-blue-800">
                        Username123uwu
                    </p>
                    <p className="text-tiny-m-400 lg:text-tiny-d-400  group-hover:text-blue-800">
                        Augs 8, 2023
                    </p>
                </div>
            </Link>
            <div className="flex flex-col items-start justify-center">
                {textComponent}
                
            </div>
            {expand && (
                <div>
                    <div className="flex flex-row items-start justify-start hover:cursor-pointer group">
                        <svg
                            width="24"
                            height="24"
                            viewBox="0 0 24 24"
                            fill="none"
                            xmlns="http://www.w3.org/2000/svg"
                        >
                            <path
                                d="M7.72363 19.5028C7.72301 14.3081 7.72301 8.91732 7.72363 3.33045C7.72363 2.98357 7.85238 2.70764 8.10988 2.50264C8.66019 2.06482 9.45707 2.30529 9.69707 2.94467C9.74832 3.08154 9.77113 3.25076 9.76551 3.45232C9.75926 3.67701 9.75894 3.91107 9.76457 4.15451C9.76472 4.15741 9.76569 4.1602 9.76735 4.16253C9.76902 4.16486 9.77131 4.16663 9.77394 4.16764C12.7277 5.30889 15.6925 6.4506 18.6685 7.59279C18.7988 7.64279 18.8847 7.69138 18.9263 7.73857C19.0278 7.85545 19.0368 7.98076 18.953 8.11451C18.886 8.22232 18.7711 8.25373 18.6539 8.29873C15.6943 9.43873 12.7363 10.5779 9.78004 11.7164C9.76879 11.7204 9.76316 11.7286 9.76316 11.7408V19.514C9.76316 19.5195 9.76538 19.5248 9.76934 19.5286C9.7733 19.5325 9.77866 19.5347 9.78426 19.5347C10.128 19.5344 10.4153 19.5344 10.6463 19.5347C11.4905 19.5361 12.1936 20.1178 12.4205 20.9053C12.4486 21.0037 12.4736 21.1294 12.4955 21.2822C12.5124 21.4025 12.5021 21.4944 12.4646 21.5578C12.3996 21.6672 12.3038 21.7219 12.1772 21.7219C9.92347 21.7219 7.63988 21.7217 5.32644 21.7214C5.08504 21.7214 4.97488 21.5339 4.99316 21.3103C5.07613 20.3114 5.83879 19.5492 6.8466 19.5365C7.12535 19.5331 7.40613 19.5333 7.68894 19.537C7.71207 19.5373 7.72363 19.5259 7.72363 19.5028ZM8.38082 19.5365H9.10551C9.11259 19.5365 9.11939 19.5337 9.1244 19.5287C9.12941 19.5237 9.13222 19.5169 9.13222 19.5098V3.33889C9.13222 3.22662 9.09484 3.11896 9.02829 3.03958C8.96175 2.9602 8.87149 2.9156 8.77738 2.9156H8.70894C8.61483 2.9156 8.52458 2.9602 8.45803 3.03958C8.39148 3.11896 8.3541 3.22662 8.3541 3.33889V19.5098C8.3541 19.5169 8.35691 19.5237 8.36192 19.5287C8.36694 19.5337 8.37373 19.5365 8.38082 19.5365ZM9.78144 4.84732C9.77933 4.84658 9.77707 4.84634 9.77486 4.84665C9.77264 4.84695 9.77052 4.84778 9.76869 4.84906C9.76686 4.85034 9.76536 4.85205 9.76431 4.85403C9.76327 4.85601 9.76271 4.85821 9.76269 4.86045V11.0264C9.76271 11.0286 9.76327 11.0308 9.76431 11.0328C9.76536 11.0348 9.76686 11.0365 9.76869 11.0378C9.77052 11.0391 9.77264 11.0399 9.77486 11.0402C9.77707 11.0405 9.77933 11.0403 9.78144 11.0395L17.7839 7.95654C17.7866 7.95552 17.7889 7.95372 17.7905 7.95138C17.7921 7.94903 17.793 7.94626 17.793 7.94342C17.793 7.94057 17.7921 7.9378 17.7905 7.93546C17.7889 7.93311 17.7866 7.93131 17.7839 7.93029L9.78144 4.84732ZM11.8158 21.0633C11.6424 20.527 11.1788 20.16 10.6111 20.1633C9.64863 20.1686 8.53582 20.1681 7.27269 20.1619C6.86707 20.1597 6.60332 20.1804 6.48144 20.2242C6.07301 20.3701 5.80347 20.6483 5.67285 21.0586C5.6666 21.0779 5.67379 21.0876 5.69441 21.0876H11.798C11.8152 21.0876 11.8211 21.0795 11.8158 21.0633Z"
                                fill="#3C3C3C"
                                className="group-hover:fill-blue-800"
                            />
                        </svg>

                        <button className="bg-white-50 max-w-[80px] border-none text-small-m-400 lg:text-small-d-400 group-hover:text-blue-800">
                            Report
                        </button>
                    </div>
                </div>
            )}
        </div>
    )
}

export default ReviewCard
