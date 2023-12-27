import React from 'react'
import { Link } from 'react-router-dom'

function MainCardBlog() {
    return (
        <div
            to="/vcvcv"
            className="flex flex-col items-start justify-start gap-1 mt-4 md:flex-row md:items-center md:justify-center border-b pb-6 border-[#F2F2F2]"
        >
            <div className="basis-1/2">
                <Link to="/ggg" className="group">
                    <p className="text-h2-m-700 min-[851px]:text-h2-d-700 line-clamp-3 break-words group-hover:text-red-600">
                        VS Code Got a Major Upgrade: What You Need to Know
                    </p>
                    <p className="overflow-hidden text-ellipsis line-clamp-4 break-words text-small-m-400 lg:text-small-d-400">
                        Visual Studio Code, the popular open-source code editor,
                        received a major update in November 2023 with version
                        1.85. This update brings a slew of new features and
                        improvements that make coding even more
                    </p>
                </Link>
                <div className="flex flex-row items-center justify-start gap-1">
                    <p className="text-tiny-m-400 lg:text-tiny-d-400">Dec 20</p>
                    <div className="h-[2px] w-[2px] rounded-[50%] bg-white-600 "></div>

                    <p className="text-tiny-m-400 lg:text-tiny-d-400">
                        12 min reading
                    </p>
                    <div className="h-[2px] w-[2px] rounded-[50%] bg-white-600"></div>

                    <div className="flex flex-row items-center justify-center py-[4px] px-1 bg-[#F2F2F2] rounded-lg ">
                        <Link
                            to="/asdc"
                            className="text-tiny-m-400 lg:text-tiny-d-400 tex hover:cursor-pointer hover:text-red-600"
                        >
                            Programming
                        </Link>
                    </div>
                </div>
            </div>
            <Link to="/xvcv" className="basis-1/2">
                <img
                    //srcset="https://small 480w, https://medium 800w, https://large 1100w"
                    src="https://www.geekmi.news/__export/1682884106095/sites/debate/img/2023/04/30/axadir_un_txtulo_x22x.jpg_759710130.jpg"
                    alt="Elva dressed as a fairy"
                    className="w-full h-auto  object-cover object-center"
                />
            </Link>
        </div>
    )
}

export default MainCardBlog
