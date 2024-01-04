import React from 'react'

function SpotlightCard({ insideText }) {
    return (
        <div className="w-full h-auto lg:w-full lg:h-auto min-h-[260px] relative">
            <img
                //srcset="https://small 480w, https://medium 800w, https://large 1100w"
                src="https://www.geekmi.news/__export/1682884106095/sites/debate/img/2023/04/30/axadir_un_txtulo_x22x.jpg_759710130.jpg"
                alt="Elva dressed as a fairy"
                className="w-full h-full lg:w-full lg:h-auto min-h-[300px] md:min-h-[340px] lg:min-h-[408px] object-cover object-center"
            />
            <div
                className=" min-h-[80px] absolute left-0 right-0 bottom-[16px] my-auto ml-2 p-[10px] overflow-hidden border-solid border-l-4
                 border-red-600 w-11/12"
                style={{ backgroundColor: 'rgba(0, 0, 0, 0.5)' }}
            >
                <p className="text-white-50 text-h3-m-700 lg:text-h3-d-700 uppercase">
                    {insideText.tittle}
                </p>
                <p className="text-white-50 overflow-hidden text-ellipsis line-clamp-3 break-words text-small-m-400 lg:text-small-d-400">
                    {insideText.text}
                </p>
            </div>
        </div>
    )
}

export default SpotlightCard