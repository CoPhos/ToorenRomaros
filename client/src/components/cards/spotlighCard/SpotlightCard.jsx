import React from 'react'
import { BASE_URL } from '../../../utils/constants'

function SpotlightCard({ insideText, images }) {
    const IMAGE_URL = "/images/"
    const small = BASE_URL + IMAGE_URL + (images?.[0]?.id || '')
    const medium = BASE_URL + IMAGE_URL + (images?.[1]?.id || '')
    const large = BASE_URL + IMAGE_URL + (images?.[2]?.id || '')
    
  
    return (
        <div className="w-full h-auto lg:w-full lg:h-auto min-h-[260px] relative">
            <img
                srcSet={`${small} 480w, ${medium} 800w`}
                sizes="(max-width: 650px) 480px, 800px"
                src={large}
                alt="Elva dressed as a fairy"
                className="w-full h-full min-h-[300px] lg:min-h-[390px] lg:w-full lg:h-auto object-cover object-center"
            />
            <div
                className=" min-h-[80px] absolute left-[28px] right-0 bottom-[16px] my-auto ml-2 p-[10px] overflow-hidden border-solid border-l-4
                 border-red-600 w-10/12"
                style={{ backgroundColor: 'rgba(0, 0, 0, 0.5)' }}
            >
                <p className="text-white-50 text-h3-m-700 lg:text-h3-d-700 uppercase overflow-hidden text-ellipsis line-clamp-3 break-words">
                    {insideText.tittle}
                </p>
                <p className="text-white-50 overflow-hidden text-ellipsis line-clamp-3 break-words text-small-m-400 lg:text-small-d-400">
                    {insideText.headline}
                </p>
            </div>
        </div>
    )
}

export default SpotlightCard