import React from 'react'

function SpotlightCard({ insideText }) {
    return (
        <div class="w-full h-auto lg:w-full lg:h-auto min-h-[260px]">
            <img
                //srcset="https://small 480w, https://medium 800w, https://large 1100w"
                src="https://www.geekmi.news/__export/1682884106095/sites/debate/img/2023/04/30/axadir_un_txtulo_x22x.jpg_759710130.jpg"
                alt="Elva dressed as a fairy"
                className="w-full h-auto lg:w-full lg:h-auto min-h-[260px]"
            />
            <div
                className=" min-h-[80px] relative left-0 right-0 bottom-0 my-auto mx-2 p-[10px] overflow-hidden border-solid border-l-4
                 border-red-700 w-full h-auto lg:w-full lg:h-auto max-w-full"
                style={{ backgroundColor: 'rgba(0, 0, 0, 0.5)' }}
            >
                <p className="text-white-50">TITTLE</p>
                <p
                    className="text-white-50 overflow-hidden text-ellipsis line-clamp-3"
                    style={{ textWrap: 'wrap' }}
                >
                    asdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasdasd
                </p>
            </div>
        </div>
    )
}

export default SpotlightCard