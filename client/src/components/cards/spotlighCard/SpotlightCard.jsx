import React from 'react'
import { Link } from 'react-router-dom'
import { BASE_URL } from '../../../utils/constants'

function SpotlightCard({ insideText, images }) {
    const IMAGE_URL = "/images/"
    let oneDpiId, twoDpiId, threeDpiId

    images.forEach((obj) => {
        if (obj.imageSize === 'ONE_DPI') {
            oneDpiId = BASE_URL + IMAGE_URL + obj.id
        } else if (obj.imageSize === 'TWO_DPI') {
            twoDpiId = BASE_URL + IMAGE_URL + obj.id
        } else if (obj.imageSize === 'THREE_DPI') {
            threeDpiId = BASE_URL + IMAGE_URL + obj.id
        }
    })
  
    return (
        <Link
            to={`/post/${insideText.id}`}
            className="w-full h-auto lg:w-full lg:h-auto min-h-[260px] relative max-h[552px] max-w-[390]"
        >
            <img
                srcSet={`${oneDpiId} 380w, ${twoDpiId} 500w`}
                sizes="(max-width: 650px) 480px, 600px"
                src={threeDpiId}
                loading="lazy"
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
        </Link>
    )
}

export default SpotlightCard