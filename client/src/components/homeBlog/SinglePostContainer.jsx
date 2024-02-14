import React, { useState, useEffect } from 'react'
import { Link } from 'react-router-dom'
import { Editor } from 'react-draft-wysiwyg'
import { EditorState, convertFromRaw } from 'draft-js'

import VideosTopManager from '../videosTop/VideosTopManager'
import TittleCard from '../cards/tittle/TittleCard'

function SinglePostContainer({ postData }) {
    const date = new Date(postData.publicationDateTime)
    const [editorState, setEditorState] = useState(
        EditorState.createWithContent(
            convertFromRaw(JSON.parse(postData.content))
        )
    )
    const [showShare, setshowShare] = useState(false)
    const [showMore, setshowMore] = useState(false)

    function handleOnClickShare() {
        setshowShare(!showShare)
    }

    function handleOnClickMore() {
        setshowMore(!showMore)
    }

    function openSmallTab(url) {
        const windowFeatures =
            'width=500,height=600,menubar=no,location=no,status=no,toolbar=no'

        window.open(url, '_blank', windowFeatures)
    }

    function copyToClipboard() {
        const currentURL = window.location.href
        navigator.clipboard
            .writeText(currentURL)
            .then(() => {
                console.log(currentURL)
            })
            .catch((error) => {
                console.log(error)
            })
    }

    useEffect(() => {
        const handleClickOutside = (event) => {
            if (showShare) {
                setshowShare(false)
            }
            if (showMore) {
                setshowMore(false)
            }
        }
        document.addEventListener('click', handleClickOutside)

        return () => {
            document.removeEventListener('click', handleClickOutside)
        }
    }, [showShare, showMore])

    return (
        <div className="w-full">
            <div className="max-w-[685px] px-1 lg:px-3 py-4 mx-auto">
                {/* tittle  */}
                <div className="w-full flex flex-col items-start justify-start">
                    <p className="text-h1-m-700 lg:text-h2-d-700">
                        {postData.tittle}
                    </p>
                    <p className="text-h3-m-700 lg:text-body-d-700 text-white-600">
                        {postData.headline}
                    </p>
                </div>
                {/* profile card */}
                <div className="flex flex-row gap-2 items-start justify-start mt-2">
                    <div>
                        <img
                            //srcset="https://small 480w, https://medium 800w, https://large 1100w"
                            src="https://image.tmdb.org/t/p/w235_and_h235_face/3dxEx32JnxUO34Wx0Y8tulUwlyh.jpg"
                            alt="Elva dressed as a fairy"
                            className="w-[44px] h-[44px] rounded-[50%] object-cover object-center"
                        />
                    </div>
                    <div className="flex flex-col items-start justify-start gap-[4px]">
                        <div className="flex flex-row items-center justify-start gap-1">
                            <p className="text-small-m-400 lg:text-small-d-400">
                                Varsha Das
                            </p>
                            <div className="bg-white-900 rounded-full w-[3px] h-[3px]"></div>
                            <p className="text-small-m-400 lg:text-small-d-40 text-blue-800 hover:text-blue-600">
                                Follow
                            </p>
                        </div>
                        <div className="flex flex-col items-start justify-start gap-1 md:flex-row md:items-center md:justify-start md:gap-1">
                            <div className="flex flex-row items-center justify-start gap-1">
                                <p className="text-tag text-white-600">
                                    Published in
                                </p>
                                <Link className="text-tag hover:underline">
                                    {postData.tag}
                                </Link>
                            </div>
                            <div className="hidden md:block bg-white-900 rounded-full w-[3px] h-[3px]"></div>
                            <div className="flex flex-row items-center justify-start gap-1">
                                <p className="text-tag text-white-600">
                                    8 min read
                                </p>
                                <div className="bg-white-900 rounded-full w-[3px] h-[3px]"></div>
                                <p className="text-tag text-white-600">
                                    {date.toLocaleDateString()}
                                </p>
                            </div>
                        </div>
                    </div>
                </div>

                {/* share / more */}
                <div className="flex flex-row items-center justify-start gap-1 mt-3 ">
                    <div>
                        <button
                            onClick={handleOnClickShare}
                            className="flex flex-row items-center justify-center gap-1 rounded-3xl border border-white-200 hover:border-white-400 py-[5px] px-[2px] w-[90px] hover:cursor-pointer group"
                        >
                            <svg
                                width="16"
                                height="16"
                                viewBox="0 0 16 16"
                                className="fill-white-600 group-hover:fill-white-900"
                                xmlns="http://www.w3.org/2000/svg"
                            >
                                <g clipPath="url(#clip0_551_12)">
                                    <path
                                        fillRule="evenodd"
                                        clipRule="evenodd"
                                        d="M13.0996 0.533043C12.3222 -0.48654 10.6728 0.0542839 10.6728 1.32875V2.60848C8.15799 2.57871 6.43769 3.44315 5.29179 4.65036C4.06681 5.94087 3.56297 7.55427 3.35184 8.65747C3.24628 9.209 3.60807 9.6092 3.9883 9.7474C4.35154 9.8794 4.83691 9.82287 5.16083 9.4526C6.08016 8.4018 7.86625 6.9352 10.6728 7.03093V8.67127C10.6728 9.94573 12.3222 10.4865 13.0996 9.46693L15.5955 6.19356C16.1347 5.48627 16.1347 4.51373 15.5955 3.80644L13.0996 0.533043ZM4.98793 7.73967C6.19139 6.6894 7.91892 5.70379 10.6728 5.70379H11.3471C11.7194 5.70379 12.0212 6.00069 12.0212 6.36691L12.0211 8.67127L14.5169 5.39785C14.6967 5.16209 14.6967 4.83791 14.5169 4.60215L12.0211 1.32875V3.27159C12.0211 3.6378 11.7193 3.93467 11.3469 3.93467H10.6728C7.63945 3.93467 6.27723 5.55543 6.27723 5.55543C5.65008 6.21612 5.24648 7.00133 4.98793 7.73967Z"
                                        className="fill-inherit"
                                    />
                                    <path
                                        d="M4.66675 0.66925H2.66675C1.56218 0.66925 0.666748 1.56468 0.666748 2.66925V13.3359C0.666748 14.4405 1.56218 15.3359 2.66675 15.3359H13.3334C14.438 15.3359 15.3334 14.4405 15.3334 13.3359V11.3359C15.3334 10.9677 15.0349 10.6692 14.6667 10.6692C14.2985 10.6692 14.0001 10.9677 14.0001 11.3359V13.3359C14.0001 13.7041 13.7016 14.0026 13.3334 14.0026H2.66675C2.29856 14.0026 2.00008 13.7041 2.00008 13.3359V2.66925C2.00008 2.30106 2.29856 2.00258 2.66675 2.00258H4.66675C5.03493 2.00258 5.33341 1.7041 5.33341 1.33592C5.33341 0.967724 5.03493 0.66925 4.66675 0.66925Z"
                                        className="fill-inherit"
                                    />
                                </g>
                                <defs>
                                    <clipPath id="clip0_551_12">
                                        <rect
                                            width="16"
                                            height="16"
                                            fill="white"
                                        />
                                    </clipPath>
                                </defs>
                            </svg>
                            <div className="flex items-center h-[24px]">
                                <p className="text-tag text-white-500 group-hover:text-white-900">
                                    Share
                                </p>
                            </div>
                        </button>
                        {showShare && (
                            <div className="flex flex-col items-start justify-start gap-2 absolute w-[240px] h-[95px] p-2 z-10 bg-white-50 border border-white-300 mt-[4px]">
                                <div
                                    onClick={() => copyToClipboard()}
                                    className="flex flex-row items-center justify-start gap-1 hover:cursor-pointer group"
                                >
                                    <svg
                                        width="20"
                                        height="20"
                                        viewBox="0 0 20 20"
                                        fill="none"
                                        xmlns="http://www.w3.org/2000/svg"
                                    >
                                        <path
                                            d="M15 16.25C15 16.913 14.7366 17.5489 14.2678 18.0178C13.7989 18.4866 13.163 18.75 12.5 18.75H3.75C3.08696 18.75 2.45107 18.4866 1.98223 18.0178C1.51339 17.5489 1.25 16.913 1.25 16.25V7.5C1.25 6.83696 1.51339 6.20107 1.98223 5.73223C2.45107 5.26339 3.08696 5 3.75 5V6.25C3.41848 6.25 3.10054 6.3817 2.86612 6.61612C2.6317 6.85054 2.5 7.16848 2.5 7.5V16.25C2.5 16.5815 2.6317 16.8995 2.86612 17.1339C3.10054 17.3683 3.41848 17.5 3.75 17.5H12.5C12.8315 17.5 13.1495 17.3683 13.3839 17.1339C13.6183 16.8995 13.75 16.5815 13.75 16.25H15Z"
                                            fill="black"
                                        />
                                        <path
                                            d="M7.5 2.5C7.16848 2.5 6.85054 2.6317 6.61612 2.86612C6.3817 3.10054 6.25 3.41848 6.25 3.75V12.5C6.25 12.8315 6.3817 13.1495 6.61612 13.3839C6.85054 13.6183 7.16848 13.75 7.5 13.75H16.25C16.5815 13.75 16.8995 13.6183 17.1339 13.3839C17.3683 13.1495 17.5 12.8315 17.5 12.5V3.75C17.5 3.41848 17.3683 3.10054 17.1339 2.86612C16.8995 2.6317 16.5815 2.5 16.25 2.5H7.5ZM7.5 1.25H16.25C16.913 1.25 17.5489 1.51339 18.0178 1.98223C18.4866 2.45107 18.75 3.08696 18.75 3.75V12.5C18.75 13.163 18.4866 13.7989 18.0178 14.2678C17.5489 14.7366 16.913 15 16.25 15H7.5C6.83696 15 6.20107 14.7366 5.73223 14.2678C5.26339 13.7989 5 13.163 5 12.5V3.75C5 3.08696 5.26339 2.45107 5.73223 1.98223C6.20107 1.51339 6.83696 1.25 7.5 1.25Z"
                                            fill="black"
                                        />
                                    </svg>

                                    <p className="text-tag text-white-500 group-hover:text-white-900">
                                        Copy Link
                                    </p>
                                </div>
                                <div
                                    onClick={() =>
                                        openSmallTab(
                                            'https://www.facebook.com/sharer/sharer.php?u=https%3A%2F%2Fdevelopers.facebook.com%2Fdocs%2Fplugins%2Fshare-button%2F&amp;src=sdkpreparse'
                                        )
                                    }
                                    className="flex flex-row items-center justify-start gap-1 hover:cursor-pointer group"
                                >
                                    <svg
                                        width="24"
                                        height="24"
                                        viewBox="0 0 24 24"
                                        fill="none"
                                        xmlns="http://www.w3.org/2000/svg"
                                    >
                                        <path
                                            d="M19.9999 12.05C19.9812 10.5255 19.5272 9.03809 18.6914 7.76295C17.8556 6.48781 16.6729 5.47804 15.2825 4.85257C13.892 4.2271 12.3518 4.01198 10.8432 4.23253C9.33461 4.45309 7.92045 5.10013 6.76728 6.09748C5.6141 7.09482 4.76993 8.40092 4.33418 9.86195C3.89844 11.323 3.88926 12.8781 4.30774 14.3442C4.72622 15.8103 5.55492 17.1262 6.69625 18.1371C7.83757 19.148 9.244 19.8117 10.7499 20.05V14.38H8.74989V12.05H10.7499V10.28C10.7036 9.86846 10.7482 9.45175 10.8806 9.05931C11.013 8.66687 11.2299 8.30827 11.516 8.00882C11.8021 7.70936 12.1504 7.47635 12.5364 7.32624C12.9224 7.17612 13.3367 7.11255 13.7499 7.14003C14.3497 7.14824 14.9481 7.20173 15.5399 7.30003V9.30003H14.5399C14.3675 9.27828 14.1923 9.29556 14.0275 9.35059C13.8626 9.40562 13.7122 9.49699 13.5874 9.61795C13.4626 9.73891 13.3666 9.88637 13.3065 10.0494C13.2463 10.2125 13.2236 10.387 13.2399 10.56V12.07H15.4599L15.0999 14.4H13.2499V20C15.1398 19.7011 16.86 18.7347 18.0984 17.2761C19.3368 15.8175 20.0114 13.9634 19.9999 12.05Z"
                                            fill="black"
                                        />
                                    </svg>
                                    <p className="text-tag text-white-500 group-hover:text-white-900">
                                        Share on facebook
                                    </p>
                                </div>
                            </div>
                        )}
                    </div>
                    <div>
                        <div
                            onClick={handleOnClickMore}
                            className="flex flex-row items-center justify-center gap-1 rounded-3xl border border-white-200 hover:border-white-400 py-[5px] px-[2px] w-[90px] hover:cursor-pointer group"
                        >
                            <svg
                                width="24"
                                height="24"
                                viewBox="0 0 24 24"
                                fill="none"
                                xmlns="http://www.w3.org/2000/svg"
                            >
                                <path
                                    d="M18 12H18.01M12 12H12.01M6 12H6.01M13 12C13 12.5523 12.5523 13 12 13C11.4477 13 11 12.5523 11 12C11 11.4477 11.4477 11 12 11C12.5523 11 13 11.4477 13 12ZM19 12C19 12.5523 18.5523 13 18 13C17.4477 13 17 12.5523 17 12C17 11.4477 17.4477 11 18 11C18.5523 11 19 11.4477 19 12ZM7 12C7 12.5523 6.55228 13 6 13C5.44772 13 5 12.5523 5 12C5 11.4477 5.44772 11 6 11C6.55228 11 7 11.4477 7 12Z"
                                    className="stroke-white-600 group-hover:stroke-white-900"
                                    strokeWidth="2"
                                    strokeLinecap="round"
                                    strokeLinejoin="round"
                                />
                            </svg>
                            <div className="flex items-center h-[24px]">
                                <p className="text-tag text-white-500 group-hover:text-white-900">
                                    More
                                </p>
                            </div>
                        </div>
                        {showMore && (
                            <div className="group flex flex-col items-start justify-start gap-2 absolute w-[240px] p-2 z-10 bg-white-50 border border-white-300 mt-[4px]">
                                <div
                                    onClick={() => copyToClipboard()}
                                    className="flex flex-row items-center justify-start gap-1 hover:cursor-pointer group"
                                >
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
                                    <p className="bg-transparent max-w-[80px] border-none text-tag text-white-500 group-hover:text-white-900 ">
                                        Report
                                    </p>
                                </div>
                            </div>
                        )}
                    </div>
                </div>

                {/* content */}
                <div className="mt-3">
                    <Editor
                        editorState={editorState}
                        readOnly={true}
                        toolbarHidden={true}
                    />
                </div>

                <TittleCard tittle={'FROM OUR BLOG'}></TittleCard>
                <VideosTopManager
                    query={`?latest=true&tags=${postData.tagId}&size=4`}
                    queryName={'latesPostWithtag'}
                ></VideosTopManager>
            </div>
        </div>
    )
}

export default SinglePostContainer
