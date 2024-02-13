import React, {useState} from 'react'
import { Link } from 'react-router-dom'
import { Editor } from 'react-draft-wysiwyg'
import { EditorState, convertFromRaw } from 'draft-js'

function SinglePostContainer({ postData }) {
    const [editorState, setEditorState] = useState(
        EditorState.createWithContent(convertFromRaw(JSON.parse(postData.content)))
    )
    return (
        <div className="w-full">
            <div className="max-w-[685px] px-1 lg:px-3 py-4 mx-auto">
                {/* tittle  */}
                <div className="w-full flex flex-col items-start justify-start">
                    <p className="text-h1-m-700 lg:text-h2-d-700">
                        You don’t know Java Streams in-practice , Do You?
                    </p>
                    <p className="text-h3-m-700 lg:text-body-d-700 text-white-600">
                        Why You Should Learn Java Streams Today
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
                                    Tag name
                                </Link>
                            </div>
                            <div className="hidden md:block bg-white-900 rounded-full w-[3px] h-[3px]"></div>
                            <div className="flex flex-row items-center justify-start gap-1">
                                <p className="text-tag text-white-600">
                                    5 min read
                                </p>
                                <div className="bg-white-900 rounded-full w-[3px] h-[3px]"></div>
                                <button className="text-tag text-white-600">
                                    Jan 8, 2024
                                </button>
                            </div>
                        </div>
                    </div>
                </div>

                {/* share / more */}
                <div className="flex flex-row items-center justify-start gap-1 mt-3">
                    <div className="flex flex-row items-center justify-center gap-1 rounded-3xl border border-white-200 hover:border-white-400 py-[5px] px-[2px] w-[90px] hover:cursor-pointer group">
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
                                    <rect width="16" height="16" fill="white" />
                                </clipPath>
                            </defs>
                        </svg>
                        <div className="flex items-center h-[24px]">
                            <p className="text-tag text-white-500 group-hover:text-white-900">
                                Share
                            </p>
                        </div>
                    </div>
                    <div className="flex flex-row items-center justify-center gap-1 rounded-3xl border border-white-200 hover:border-white-400 py-[5px] px-[2px] w-[90px] hover:cursor-pointer group">
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
                </div>
                {/* content */}
                <div className="mt-3">
                    <Editor
                        editorState={editorState}
                        readOnly={true}
                        toolbarHidden={true}
                    />
                </div>
                {/* tag clap comments more share  */}
                <div className="flex flex-col items-start justify-start mt-5 gap-3 w-full">
                    <div className="flex flex-row items-center justify-center py-1 px-2 bg-[#F2F2F2] rounded-[100px] w-fit">
                        <Link className="capitalize text-tag hover:cursor-pointer hover:text-red-600">
                            {postData.tag}
                        </Link>
                    </div>
                    <div className="flex flex-row items-center justify-between w-full">
                        <div className="flex flex-row items-center justify-start gap-1">
                            <div className="flex flex-row items-center justify-center gap-1 py-[5px] px-[2px] w-[60px] hover:cursor-pointer group">
                                <svg
                                    width="20"
                                    height="20"
                                    viewBox="0 0 20 20"
                                    className="fill-white-600 group-hover:fill-white-900"
                                    xmlns="http://www.w3.org/2000/svg"
                                >
                                    <path
                                        fillRule="evenodd"
                                        clipRule="evenodd"
                                        d="M12.4001 0.8C12.4001 0.358172 12.0419 0 11.6001 0C11.1582 0 10.8001 0.358172 10.8001 0.8V2.4C10.8001 2.84182 11.1582 3.2 11.6001 3.2C12.0419 3.2 12.4001 2.84182 12.4001 2.4V0.8ZM8.96576 1.03431C8.65336 0.721895 8.14679 0.721895 7.83438 1.03431C7.52195 1.34674 7.52195 1.85326 7.83438 2.16569L8.6344 2.96569C8.9468 3.2781 9.45336 3.2781 9.76576 2.96569C10.0782 2.65326 10.0782 2.14674 9.76576 1.83431L8.96576 1.03431ZM15.3658 2.16569C15.6782 1.85326 15.6782 1.34674 15.3658 1.03431C15.0534 0.721895 14.5468 0.721895 14.2344 1.03431L13.4344 1.83431C13.1219 2.14674 13.1219 2.65326 13.4344 2.96569C13.7468 3.2781 14.2534 3.2781 14.5658 2.96569L15.3658 2.16569ZM8.24691 4.31689C7.88015 3.95014 7.39107 3.64101 6.84817 3.53242C6.27732 3.41826 5.63791 3.53178 5.13564 4.03405C4.9812 4.18849 4.86351 4.3559 4.7779 4.53029C4.62563 4.46484 4.46656 4.41375 4.30258 4.38095C3.73174 4.26678 3.09233 4.3803 2.59006 4.88258C2.08778 5.38486 1.97426 6.02426 2.08843 6.5951C2.12123 6.75908 2.17232 6.91815 2.23777 7.07042C2.06338 7.15603 1.89597 7.27372 1.74153 7.42816C1.23925 7.93044 1.12574 8.56984 1.2399 9.14072C1.34849 9.6836 1.65762 10.1726 2.02437 10.5394L2.05375 10.5688C1.94538 10.639 1.84078 10.723 1.74153 10.8222C1.23925 11.3246 1.12574 11.9639 1.2399 12.5348C1.34849 13.0777 1.65762 13.5668 2.02437 13.9335L5.98417 17.8934C7.59854 19.5077 10.1256 19.5873 12.287 18.4541C13.955 18.8299 15.8061 18.4157 17.3646 16.857C18.7458 15.476 19.6001 13.299 19.6001 11.4914C19.6001 9.60808 18.7163 8.00944 17.2108 6.50023L16.7422 6.02055L16.7357 6.01394C16.3689 5.64719 15.8798 5.33806 15.3369 5.22948C14.7661 5.11531 14.1266 5.22883 13.6244 5.7311C13.5246 5.83086 13.44 5.93602 13.3694 6.04501L13.3381 6.01394L13.337 6.01288C12.9704 5.64659 12.4817 5.33796 11.9394 5.22948C11.3685 5.11531 10.7291 5.22883 10.2268 5.7311C10.1275 5.83035 10.0435 5.93496 9.97336 6.04334L8.24691 4.31689ZM9.37824 8.8424L6.54986 6.01394C6.35092 5.81502 6.23578 5.59699 6.20294 5.43279C6.1757 5.29654 6.2036 5.22883 6.26701 5.16542C6.33042 5.10201 6.39812 5.0741 6.53438 5.10135C6.69858 5.13419 6.91661 5.24934 7.11554 5.44826L10.509 8.84168L10.5097 8.8424L12.2067 10.5394C12.5191 10.8518 13.0257 10.8518 13.3381 10.5394C13.6505 10.227 13.6505 9.72048 13.3381 9.40808L11.641 7.711C11.4425 7.51222 11.327 7.2939 11.2941 7.12985C11.2669 6.99359 11.2948 6.92589 11.3582 6.86247C11.4216 6.79906 11.4893 6.77116 11.6255 6.79841C11.7898 6.83125 12.0078 6.94639 12.2067 7.14532L12.2086 7.14718L13.8973 8.82488L14.464 9.40256L14.4694 9.40808C15.0538 9.9924 15.2838 11.015 15.0285 12.2918C14.7772 13.5483 14.077 14.8918 13.0552 15.9134C12.6494 16.3193 12.2166 16.6506 11.7741 16.9095C9.97888 17.9602 8.14174 17.7882 7.11554 16.762L3.15574 12.8022C2.95681 12.6033 2.84167 12.3852 2.80883 12.221C2.78158 12.0847 2.80949 12.017 2.8729 11.9537C2.9363 11.8902 3.00401 11.8623 3.14027 11.8896C3.30447 11.9224 3.5225 12.0375 3.72142 12.2365L5.41848 13.9335C5.7309 14.246 6.23743 14.246 6.54986 13.9335C6.86227 13.6211 6.86227 13.1146 6.54986 12.8022L4.8528 11.1051L3.15574 9.40808C2.95681 9.20912 2.84167 8.99112 2.80883 8.82688C2.78158 8.69064 2.80949 8.62296 2.8729 8.55952C2.9363 8.49616 3.00401 8.46824 3.14027 8.49544C3.30447 8.52832 3.5225 8.64344 3.72142 8.8424L6.54986 11.6708C6.86227 11.9832 7.36881 11.9832 7.68122 11.6708C7.99364 11.3584 7.99364 10.8518 7.68122 10.5394L4.8528 7.711L4.00427 6.86247C3.80534 6.66354 3.6902 6.44552 3.65736 6.28132C3.63011 6.14506 3.65802 6.07736 3.72142 6.01394C3.78483 5.95054 3.85254 5.92263 3.9888 5.94988C4.153 5.98272 4.37102 6.09786 4.56995 6.29679L5.41848 7.14532L8.24691 9.97376C8.55936 10.2862 9.06584 10.2862 9.37824 9.97376C9.69072 9.66136 9.69072 9.1548 9.37824 8.8424ZM16.2333 15.7257C15.6318 16.3271 14.9969 16.6875 14.3661 16.8598C15.5101 15.6446 16.2984 14.1004 16.5974 12.6055C16.9075 11.0551 16.7138 9.39224 15.6037 8.27952L15.0359 7.70074L15.0305 7.69527C14.8303 7.49512 14.719 7.28178 14.6882 7.12466C14.6632 6.99754 14.6878 6.93038 14.7558 6.86247C14.8191 6.79906 14.8869 6.77116 15.0231 6.79841C15.1865 6.83109 15.4032 6.94525 15.6013 7.14238L16.0694 7.62139L16.0754 7.62748C17.4045 8.95904 18.0001 10.1759 18.0001 11.4914C18.0001 12.8837 17.308 14.651 16.2333 15.7257Z"
                                        className="fill-inherit"
                                    />
                                </svg>
                                <div className="flex items-center h-[24px]">
                                    <p className="text-tag text-white-500 group-hover:text-white-900">
                                        {postData.likeCount}
                                    </p>
                                </div>
                            </div>
                            
                        </div>

                        <div className="flex flex-row items-center justify-start gap-1">
                            <div className="flex flex-row items-center justify-center gap-1 rounded-3xl py-[5px] px-[2px] w-[45px] hover:cursor-pointer group">
                                <svg
                                    width="18"
                                    height="22"
                                    viewBox="0 0 18 22"
                                    fill="none"
                                    xmlns="http://www.w3.org/2000/svg"
                                >
                                    <path
                                        d="M5.8 8.85714H12.2M9 6V11.7143M3 1H15C16.1046 1 17 1.83947 17 2.875V21L9 16L1 21V2.875C1 1.83947 1.89542 1 3 1Z"
                                        className="stroke-white-600 group-hover:stroke-white-900"
                                        strokeWidth="2"
                                        strokeLinecap="round"
                                        strokeLinejoin="round"
                                    />
                                </svg>
                            </div>
                            <div className="flex flex-row items-center justify-center gap-1 rounded-3xl  py-[5px] px-[2px] w-[45px] hover:cursor-pointer group">
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
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    )
}

export default SinglePostContainer