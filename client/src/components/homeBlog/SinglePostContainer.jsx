import React, { useState, useEffect, useContext } from 'react'
import { useMutation, useQueryClient } from 'react-query'
import useAxiosPrivate from '../hooks/useAxiosPrivate'
import useAuth from '../hooks/useAuth'
import { LoginPopUpContext } from '../context/LoginPopUpProvider'
import { Link, useParams } from 'react-router-dom'
import { Editor } from 'react-draft-wysiwyg'
import { EditorState, convertFromRaw } from 'draft-js'

import VideosTopManager from '../videosTop/VideosTopManager'
import TittleCard from '../cards/tittle/TittleCard'

function SinglePostContainer({ postData }) {
    const date = new Date(postData.publicationDateTime)
    const axiosPrivate = useAxiosPrivate()
    const { setisPopupOpen } = useContext(LoginPopUpContext)
    const { auth, isAuthenticated } = useAuth()
    const queryClient = useQueryClient()
    const params = useParams()
    const [editorState, setEditorState] = useState(
        EditorState.createWithContent(
            convertFromRaw(JSON.parse(postData.content))
        )
    )
    const [showShare, setshowShare] = useState(false)
    const [showMore, setshowMore] = useState(false)
    const [clapped, setclapped] = useState(postData.liked ? true : false)

    const addClapp = useMutation(
        ['addClapp', postData.id],
        async (formData) => {
            try {
                setclapped(true)
                return axiosPrivate.post('/posts/likes/', formData, {
                    headers: {
                        'Content-Type': 'application/json',
                    },
                })
            } catch (error) {
                return error
            }
        },
        {
            onMutate: async () => {
                const previousData = queryClient.getQueryData([
                    'getPostById',
                    params.uuid,
                ])
                queryClient.setQueryData(
                    ['getPostById', params.uuid],
                    (oldData) => {
                        if (!oldData) return []

                        return {
                            ...oldData,
                            data: {
                                ...oldData.data,
                                response: {
                                    ...oldData.data.response,
                                    likeCount:
                                        (oldData.data.response
                                            .likeCount || 0) + 1,
                                },
                            },
                        }
                    }
                )
                return previousData
            },
            onError: (err, _, rollback) => {
                if (rollback) {
                    setclapped(false)
                    queryClient.setQueryData(
                        ['getPostById', params.uuid],
                        rollback
                    )
                }
            },
            onSuccess: (data) => {
                queryClient.invalidateQueries(['getPostById', params.uuid])
            },
        }
    )

    const removeClapp = useMutation(
        ['removeClapp', postData.id],
        async () => {
            try {
                setclapped(false)
                return axiosPrivate.delete(
                    `/comments/likes?owner=${postData.id}&user=${auth.id}`
                )
            } catch (error) {
                return error
            }
        },
        {
            onMutate: async () => {
                const previousData = queryClient.getQueryData([
                    'getPostById',
                    params.uuid,
                ])
                queryClient.setQueryData(
                    ['getPostById', params.uuid],
                    (oldData) => {
                        if (!oldData) return []

                        return {
                            ...oldData,
                            data: {
                                ...oldData.data,
                                response: {
                                    ...oldData.data.response,
                                    likeCount:
                                        (oldData.data.response
                                            .likeCount || 0) - 1,
                                },
                            },
                        }
                    }
                )
                return previousData
            },
            onError: (err, _, rollback) => {
                 if (rollback) {
                     setclapped(true)
                     queryClient.setQueryData(
                         ['getPostById', params.uuid],
                         rollback
                     )
                 }
            },
            onSuccess: (data) => {
                queryClient.invalidateQueries(['getPostById', params.uuid])
            },
        }
    )

    function handleClapClick(e) {
        e.preventDefault()
        if (!isAuthenticated) {
            setisPopupOpen(true)
        } else if (!clapped) {
            addClapp.mutate(
                JSON.stringify({
                    ownerId: postData.id,
                    userId: auth.id,
                })
            )
        } else {
            removeClapp.mutate()
        }
    }

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
            .then(() => {})
            .catch((error) => {})
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
        <div className="w-full mb-[120px]">
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

                {/* clap / share / more */}
                <div className="flex flex-row items-center justify-start gap-2 mt-3 ">
                    <div
                        className="flex flex-row items-start justify-start hover:cursor-pointer group w-fit gap-[4px] ml-1"
                        onClick={(e) => handleClapClick(e)}
                    >
                        <svg
                            width="24"
                            height="24"
                            viewBox="0 0 24 24"
                            fill="none"
                            xmlns="http://www.w3.org/2000/svg"
                        >
                            <g clipPath="url(#clip0_584_8)">
                                <path
                                    d="M15.5702 3.90096C15.7841 4.17115 15.9183 4.48146 15.975 4.80284C16.0451 4.74074 16.12 4.68592 16.1968 4.63464L16.6956 4.13594C17.0872 3.74439 17.1474 3.1144 16.8037 2.68022C16.587 2.4064 16.2708 2.26953 15.9547 2.26953C15.6777 2.26953 15.4008 2.37458 15.1906 2.58469L14.563 3.21243C14.9562 3.33226 15.3072 3.56877 15.5702 3.90096Z"
                                    className={`${
                                        clapped
                                            ? 'fill-white-950'
                                            : 'fill-white-50'
                                    } group-hover:fill-white-950`}
                                />
                                <path
                                    d="M7.58092 7.97866L7.59973 8.63425L13.3263 2.96687C13.7178 2.57533 13.7781 1.94541 13.4344 1.51123C13.2177 1.23741 12.9016 1.10054 12.5854 1.10046C12.3084 1.10046 12.0315 1.2056 11.8213 1.41562L6.82544 6.41174C7.28215 6.78262 7.57607 7.34681 7.58092 7.97866Z"
                                    className={`${
                                        clapped
                                            ? 'fill-white-950'
                                            : 'fill-white-50'
                                    } group-hover:fill-white-950`}
                                />
                                <path
                                    d="M2.23911 15.3802L2.52439 15.0485L3.50508 7.91786C3.54206 6.92289 4.29576 6.1083 5.26377 5.97539L5.23591 5.00351C5.23591 4.41518 4.75449 3.93384 4.16616 3.93384C3.57783 3.93384 3.09649 4.41518 3.09649 5.00351L2.06938 12.4713C2.0693 12.4721 2.0689 12.4729 2.06841 12.4734L1.07674 13.6263C0.92187 13.8062 0.932125 14.0753 1.10024 14.2432L2.23911 15.3802Z"
                                    className={`${
                                        clapped
                                            ? 'fill-white-950'
                                            : 'fill-white-50'
                                    } group-hover:fill-white-950`}
                                />
                                <path
                                    d="M22.9132 2.65136C23.1316 2.49689 23.1834 2.19449 23.0289 1.97607C22.8743 1.75764 22.5721 1.7058 22.3536 1.86044L21.1436 2.71653C20.9252 2.871 20.8735 3.1734 21.028 3.39182C21.1224 3.52522 21.272 3.59652 21.4238 3.59652C21.5206 3.59652 21.6183 3.56761 21.7033 3.50737L22.9132 2.65136Z"
                                    className="fill-white-950 "
                                />
                                <path
                                    d="M19.7077 2.373C19.7639 2.39416 19.8215 2.40417 19.8781 2.40417C20.0742 2.40417 20.2587 2.28434 20.3317 2.08998L20.8533 0.702566C20.9475 0.452167 20.8208 0.172778 20.5703 0.0786263C20.3199 -0.0156066 20.0404 0.111248 19.9463 0.361648L19.4246 1.74906C19.3306 1.99946 19.4573 2.27885 19.7077 2.373Z"
                                    className="fill-white-950 "
                                />
                                <path
                                    d="M23.5158 4.49048C23.5125 4.49048 23.5092 4.49048 23.5058 4.49048L22.024 4.50291C21.7565 4.50832 21.544 4.71326 21.5494 4.98078C21.5547 5.24499 21.7706 5.45945 22.0337 5.45945C22.037 5.45945 22.0403 5.45945 22.0437 5.45945L23.5255 5.43426C23.7929 5.42885 24.0054 5.21366 24 4.94614C23.9947 4.68193 23.7789 4.49048 23.5158 4.49048Z"
                                    className="fill-white-950 "
                                />
                                <path
                                    d="M20.0203 14.2552C20.4703 13.8053 20.4385 13.0488 19.9248 12.6421C19.7324 12.4899 19.5017 12.4169 19.2702 12.4169C18.9792 12.4169 18.6872 12.5322 18.4691 12.7503L16.0487 15.1707C15.9513 15.2681 15.8236 15.3168 15.6959 15.3168C15.5682 15.3168 15.4405 15.2681 15.343 15.1707L15.3367 15.1643C15.1258 14.9535 15.1258 14.6114 15.3367 14.4006L19.2408 10.4964C19.6323 10.1049 19.6926 9.47486 19.349 9.04076C19.1323 8.76686 18.816 8.62999 18.4999 8.62999C18.2229 8.62999 17.9461 8.73505 17.7359 8.94515L13.7945 12.8865C13.6929 12.988 13.5598 13.0388 13.4267 13.0388C13.2935 13.0388 13.1604 12.988 13.0588 12.8865C12.8526 12.6802 12.8526 12.3461 13.0588 12.1399L18.0717 7.12695C18.4633 6.7354 18.5236 6.10541 18.1799 5.67131C17.9632 5.39749 17.647 5.26062 17.3308 5.26054C17.0538 5.26054 16.7769 5.3656 16.5668 5.5757L11.5302 10.6122C11.4273 10.7152 11.2923 10.7667 11.1574 10.7667C11.0225 10.7667 10.8876 10.7152 10.7846 10.6122C10.5812 10.4088 10.5812 10.0791 10.7846 9.87569L14.7023 5.95796C15.0939 5.56641 15.1542 4.93642 14.8105 4.50224C14.5938 4.22842 14.2776 4.09155 13.9615 4.09155C13.6844 4.09155 13.4076 4.19661 13.1974 4.40671L7.51027 10.0939C7.40926 10.1949 7.28458 10.2403 7.16233 10.2403C6.91169 10.2403 6.67073 10.0496 6.66242 9.75683L6.61187 7.99459C6.61187 7.40626 6.13053 6.92484 5.5422 6.92484C4.95387 6.92484 4.47245 7.40626 4.47245 7.99459L3.44542 15.4624C3.44526 15.4632 3.44493 15.4639 3.44437 15.4645L2.45278 16.6173C2.29783 16.7973 2.30808 17.0664 2.47628 17.2342L8.10207 22.851C8.18993 22.9388 8.30588 22.9835 8.42248 22.9835C8.51938 22.9835 8.61668 22.9526 8.69856 22.8897L9.96267 21.9189C10.0169 21.8773 10.0794 21.8493 10.146 21.8347C12.3391 21.3568 14.8356 19.4397 17.2239 17.0514L20.0203 14.2552Z"
                                    className={`${
                                        clapped
                                            ? 'fill-white-950'
                                            : 'fill-white-50'
                                    } group-hover:fill-white-950`}
                                />
                                <path
                                    d="M20.5262 11.8824C20.278 11.686 19.9843 11.5523 19.6737 11.4894C19.6942 11.4523 19.7134 11.4145 19.7315 11.3762L19.9259 11.1817C20.6748 10.4328 20.7534 9.25393 20.1087 8.43943C19.8044 8.05499 19.3819 7.7995 18.9127 7.70414C18.9462 7.64245 18.9759 7.57938 19.0029 7.51535C19.5129 6.77659 19.5046 5.78371 18.9397 5.07006C18.6353 4.68537 18.2127 4.42908 17.7432 4.33388C18.1308 3.6212 18.0813 2.73297 17.5635 2.07899C17.1721 1.58441 16.5858 1.30066 15.9548 1.30066C15.4496 1.30066 14.9729 1.48121 14.5989 1.8118C14.5423 1.4905 14.4081 1.18019 14.1942 0.909922C13.8026 0.41534 13.2163 0.131673 12.5853 0.131592C12.0371 0.131592 11.5224 0.344363 11.1362 0.73058L6.22345 5.64329L6.20472 4.98761C6.19608 3.87087 5.28484 2.96496 4.16607 2.96496C3.06758 2.96496 2.16925 3.83825 2.12888 4.92697L1.14812 12.0575L0.342008 12.9945C-0.141107 13.5563 -0.108727 14.4061 0.415893 14.9294L1.61395 16.1254C1.24461 16.6811 1.30929 17.4389 1.79208 17.9205L7.41755 23.537C7.68636 23.8052 8.04319 23.9527 8.42254 23.9527C8.73399 23.9527 9.04172 23.8482 9.28889 23.6584L10.4633 22.7566C11.593 22.4897 12.8386 21.8836 14.1675 20.9535C15.3279 20.1413 16.5869 19.0592 17.9091 17.7368L20.7055 14.9405C21.1179 14.5281 21.335 13.9563 21.301 13.3718C21.2671 12.7882 20.9847 12.2454 20.5262 11.8824ZM9.96273 21.9191L8.69862 22.8898C8.61674 22.9527 8.51944 22.9837 8.42254 22.9837C8.30602 22.9837 8.18999 22.9389 8.10213 22.8512L2.47634 17.2343C2.30814 17.0666 2.29789 16.7976 2.45284 16.6174L3.44443 15.4647C3.44499 15.464 3.44532 15.4633 3.44548 15.4626L4.47251 7.99475C4.47251 7.40642 4.95393 6.925 5.54226 6.925C6.13059 6.925 6.61193 7.40642 6.61193 7.99475L6.66248 9.75699C6.67087 10.0498 6.91175 10.2404 7.16239 10.2404C7.28464 10.2404 7.40932 10.1951 7.51033 10.094L13.1975 4.40687C13.4077 4.19669 13.6845 4.09172 13.9615 4.09172C14.2777 4.09172 14.5939 4.22858 14.8106 4.5024C15.1543 4.93658 15.0939 5.56666 14.7024 5.95813L10.7847 9.87586C10.5813 10.0793 10.5813 10.409 10.7847 10.6124C10.8876 10.7153 11.0225 10.7668 11.1575 10.7668C11.2924 10.7668 11.4274 10.7153 11.5303 10.6124L16.5669 5.57586C16.777 5.36568 17.0539 5.2607 17.3309 5.2607C17.647 5.26079 17.9632 5.39765 18.18 5.67147C18.5236 6.10557 18.4633 6.73565 18.0718 7.12711L13.0588 12.14C12.8527 12.3463 12.8527 12.6804 13.0588 12.8866C13.1604 12.9882 13.2935 13.039 13.4267 13.039C13.5598 13.039 13.693 12.9882 13.7945 12.8866L17.7359 8.94532C17.9461 8.73513 18.223 8.63016 18.5 8.63016C18.8161 8.63016 19.1323 8.76702 19.349 9.04092C19.6927 9.47502 19.6324 10.1051 19.2408 10.4966L15.3367 14.4007C15.1258 14.6116 15.1258 14.9536 15.3367 15.1644L15.343 15.1708C15.4405 15.2683 15.5683 15.317 15.6959 15.317C15.8237 15.317 15.9514 15.2683 16.0488 15.1708L18.4691 12.7505C18.6872 12.5324 18.9792 12.4171 19.2702 12.4171C19.5017 12.4171 19.7326 12.4901 19.9249 12.6423C20.4385 13.0488 20.4704 13.8054 20.0204 14.2554L17.2241 17.0518C14.8358 19.4401 12.3393 21.3571 10.1463 21.835C10.0796 21.8495 10.0169 21.8776 9.96273 21.9191ZM1.07665 13.6264L2.06832 12.4735C2.0688 12.473 2.06921 12.4721 2.06929 12.4714L3.0964 5.0036C3.0964 4.41527 3.57774 3.93393 4.16607 3.93393C4.7544 3.93393 5.23582 4.41527 5.23582 5.0036L5.26368 5.9754C4.29567 6.10832 3.54197 6.92282 3.50499 7.91796L2.5243 15.0486L2.23902 15.3803L1.10023 14.2434C0.932034 14.0755 0.921779 13.8064 1.07665 13.6264ZM12.5853 1.10049C12.9016 1.10057 13.2177 1.23744 13.4344 1.51125C13.7781 1.94543 13.7178 2.57543 13.3263 2.9669L7.59972 8.63427L7.5809 7.97868C7.57598 7.34683 7.28214 6.78264 6.82543 6.41177L11.8214 1.41573C12.0314 1.20562 12.3084 1.10049 12.5853 1.10049ZM15.9547 2.26956C16.2708 2.26956 16.5871 2.40642 16.8038 2.68024C17.1474 3.11442 17.0872 3.7445 16.6957 4.13597L16.1969 4.63466C16.12 4.68594 16.0452 4.74077 15.9751 4.80286C15.9185 4.48149 15.7842 4.17117 15.5703 3.90099C15.3073 3.56879 14.9563 3.33228 14.5629 3.21245L15.1906 2.58472C15.4009 2.37461 15.6778 2.26956 15.9547 2.26956Z"
                                    className={`${
                                        clapped
                                            ? 'fill-white-50'
                                            : 'fill-white-950'
                                    } group-hover:fill-white-50`}
                                />
                            </g>
                            <defs>
                                <clipPath id="clip0_584_8">
                                    <rect width="24" height="24" fill="white" />
                                </clipPath>
                            </defs>
                        </svg>

                        <p className="bg-transparent max-w-[80px] border-none text-small-m-400 lg:text-small-d-400 group-hover:text-red-600">
                            {postData.likeCount}
                        </p>
                    </div>
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
                <div className="mt-3 mb-[136px]">
                    <Editor
                        editorState={editorState}
                        readOnly={true}
                        toolbarHidden={true}
                    />
                </div>

                <TittleCard tittle={'FROM OUR BLOG'}></TittleCard>
                <VideosTopManager
                    query={`?latest=true&popular=true&size=4&exclude=${postData.id}`}
                    queryName={'latesPostWithtag'}
                ></VideosTopManager>
            </div>
        </div>
    )
}

export default SinglePostContainer
