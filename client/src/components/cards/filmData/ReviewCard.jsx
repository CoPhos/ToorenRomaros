import React, { useState, createRef, useEffect, useContext } from 'react'
import { useMutation, useQueryClient } from 'react-query'
import useAxiosPrivate from '../../hooks/useAxiosPrivate'
import useAuth from '../../hooks/useAuth'
import { LoginPopUpContext } from '../../context/LoginPopUpProvider'
import { Link, useParams } from 'react-router-dom'

function ReviewCard({ expand, data, critic }) {
    const queryClient = useQueryClient()
    const params = useParams()
    const axiosPrivate = useAxiosPrivate()
    const { setisPopupOpen } = useContext(LoginPopUpContext)
    const { auth, isAuthenticated } = useAuth()
    const [height, setHeight] = useState(0)
    const [show, setshow] = useState(false)
    const [clapped, setclapped] = useState(data.liked ? true : false)
    const [showSpoiler, setshowSpoiler] = useState(false)

    const addClapp = useMutation(
        ['addClapp', data.id],
        async (formData) => {
            try {
                setclapped(true)
                return axiosPrivate.post('/comments/likes/', formData, {
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
                    'getCommonReviews',
                    params.uuid,
                ])
                queryClient.setQueryData(
                    ['getCommonReviews', params.uuid],
                    (oldData) => {
                        if (!oldData) return []

                        return {
                            ...oldData,
                            data: {
                                ...oldData.data,
                                response: {
                                    ...oldData.data.response,
                                    content: oldData.data.response.content.map(
                                        (item) =>
                                            item.id == data.id
                                                ? {
                                                      ...item,
                                                      likeCount:
                                                          (item.likeCount ||
                                                              0) + 1,
                                                  }
                                                : item
                                    ),
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
                        ['getCommonReviews', params.uuid],
                        rollback
                    )
                }
            },
            onSuccess: () => {
                queryClient.invalidateQueries(['getCommonReviews', params.uuid])
            },
        }
    )

    const removeClapp = useMutation(
        ['removeClapp', data.id],
        async () => {
            try {
                setclapped(false)
                return axiosPrivate.delete(`/comments/likes?owner=${data.id}&user=${auth.id}`)
            } catch (error) {
                return error
            }
        },
        {
            onMutate: async () => {
                const previousData = queryClient.getQueryData([
                    'getCommonReviews',
                    params.uuid,
                ])
                queryClient.setQueryData(
                    ['getCommonReviews', params.uuid],
                    (oldData) => {
                        if (!oldData) return []

                        return {
                            ...oldData,
                            data: {
                                ...oldData.data,
                                response: {
                                    ...oldData.data.response,
                                    content: oldData.data.response.content.map(
                                        (item) =>
                                            item.id == data.id
                                                ? {
                                                      ...item,
                                                      likeCount:
                                                          (item.likeCount ||
                                                              0) - 1,
                                                  }
                                                : item
                                    ),
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
                        ['getCommonReviews', params.uuid],
                        rollback
                    )
                }
            },
            onSuccess: () => {
                queryClient.invalidateQueries(['getCommonReviews', params.uuid])
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
                    ownerId: data.id,
                    userId: auth.id,
                })
            )
        } else {
            removeClapp.mutate()
        }
    }

    const toggle = () => {
        setshow(!show)
    }
    const elementRef = createRef(null)

    useEffect(() => {
        setHeight(elementRef.current.offsetHeight)
    }, [])

    const baseClassesRating =
        'flex items-center justify-center rounded-xl h-[56px] w-[56px]'
    const dynamicClasses =
        data.rating < 40
            ? 'bg-red-500'
            : data.rating < 70 && data.rating >= 40
            ? 'bg-[#ffbd3f]'
            : 'bg-green-600'

    const baseClassesText = 'text-small-m-400 lg:text-small-d-400 break-words'
    const dynamicClassesText = show
        ? 'line-clamp-[unset]'
        : ' overflow-hidden text-ellipsis line-clamp-4'

    const blurClasses =
        showSpoiler || !Boolean(data.spoiler)
            ? 'blur-none'
            : 'blur pointer-events-none '

    const dateObject = new Date(data.publicationDateTime)
    let textComponent
    if (height > 98 && expand) {
        textComponent = (
            <div className="flex flex-col items-start justify-center">
                <p
                    ref={elementRef}
                    className={`${baseClassesText} ${dynamicClassesText}`}
                >
                    {critic ? data.synthesis : data.body}
                </p>
                <button
                    onClick={toggle}
                    className="self-start bg-transparent max-w-[80px] border-none hover:cursor-pointer text-small-m-700 lg:text-small-d-700"
                >
                    {show ? 'Collapse' : 'Expand'}
                </button>
            </div>
        )
    } else {
        textComponent = (
            <p
                ref={elementRef}
                className={
                    'text-small-m-400 lg:text-small-d-400 break-words overflow-hidden text-ellipsis line-clamp-6'
                }
            >
                {critic ? data.synthesis : data.body}
            </p>
        )
    }

    const fullReviewDiv = (
        <Link
            to={`/post/${data.id}`}
            className="flex flex-row items-center justify-start gap-1 hover:cursor-pointer group w-fit pt-2 pr-2"
        >
            <p className="text-small-m-400 lg:text-small-d-400 text-blue-800 group-hover:text-blue-600">
                See full review
            </p>
            <svg
                width="16"
                height="16"
                viewBox="0 0 16 16"
                fill="none"
                xmlns="http://www.w3.org/2000/svg"
            >
                <path
                    d="M4.02562 3.62502C3.77593 3.62471 3.62343 3.79471 3.62343 4.03502C3.62385 6.62419 3.62437 9.28138 3.62499 12.0066C3.62499 12.2303 3.8178 12.3756 4.02562 12.3756C6.79124 12.3748 9.43426 12.3747 11.9547 12.3753C12.2212 12.3753 12.3772 12.2181 12.3766 11.9522C12.373 10.5399 12.373 9.22554 12.3766 8.00909C12.3781 7.49971 13.1272 7.49971 13.1262 8.02471C13.1237 9.33075 13.1241 10.6131 13.1272 11.8719C13.1276 12.0569 13.1128 12.201 13.0828 12.3041C12.9428 12.785 12.5097 13.1244 12.0025 13.1244C9.7677 13.1246 7.1203 13.125 4.0603 13.1256C3.60239 13.1256 3.25999 12.9423 3.03312 12.5756C2.91124 12.3791 2.87249 12.1553 2.8728 11.9131C2.87635 9.35002 2.87687 6.7169 2.87437 4.01377C2.87374 3.50002 3.20093 3.06409 3.69155 2.91815C3.79635 2.8869 3.95333 2.87159 4.16249 2.87221C5.44958 2.87638 6.72291 2.877 7.98249 2.87409C8.13583 2.87388 8.24957 2.93711 8.32374 3.06377C8.4703 3.31409 8.28249 3.62471 7.99687 3.62471C6.62916 3.62534 5.30541 3.62544 4.02562 3.62502Z"
                    fill="black"
                />
                <path
                    d="M12.3731 4.17183C12.3731 4.1707 12.3728 4.16958 12.3722 4.16862C12.3716 4.16766 12.3707 4.16691 12.3696 4.16647C12.3686 4.16603 12.3674 4.16592 12.3663 4.16615C12.3652 4.16639 12.3642 4.16695 12.3634 4.16777C11.0305 5.49798 9.69913 6.82986 8.36934 8.1634C8.26142 8.27173 8.17829 8.33371 8.11996 8.34933C7.8084 8.43277 7.53996 8.13777 7.66746 7.83965C7.68746 7.79256 7.73923 7.72746 7.82277 7.64433C9.12882 6.34392 10.4656 5.00798 11.8331 3.63652C11.834 3.6356 11.8347 3.63443 11.8349 3.63314C11.8352 3.63186 11.8351 3.63052 11.8346 3.62931C11.834 3.6281 11.8332 3.62707 11.8321 3.62635C11.831 3.62563 11.8297 3.62525 11.8284 3.62527C11.319 3.62465 10.8289 3.62475 10.3581 3.62558C10.1943 3.626 10.0757 3.56715 10.0021 3.44902C9.93694 3.34486 9.92559 3.23486 9.96809 3.11902C10.0334 2.94152 10.1871 2.87308 10.3725 2.87371C11.1462 2.87538 11.9139 2.87475 12.6756 2.87184C12.7835 2.87142 12.8638 2.88569 12.9165 2.91465C13.0762 3.00246 13.1281 3.14996 13.1271 3.32902C13.124 4.05027 13.1235 4.8184 13.1256 5.6334C13.126 5.83173 13.0477 5.96371 12.8906 6.02934C12.6868 6.11434 12.4284 5.98965 12.3884 5.76746C12.3767 5.70267 12.3714 5.61767 12.3725 5.51246C12.3766 5.05183 12.3768 4.60496 12.3731 4.17183Z"
                    fill="black"
                />
            </svg>
        </Link>
    )

    const reportDiv = (
        <div
            className="flex flex-row items-start justify-start hover:cursor-pointer group w-fit pt-2 pr-2 gap-[4px] "
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
                            clapped ? 'fill-white-950' : 'fill-white-50'
                        } group-hover:fill-white-950`}
                    />
                    <path
                        d="M7.58092 7.97866L7.59973 8.63425L13.3263 2.96687C13.7178 2.57533 13.7781 1.94541 13.4344 1.51123C13.2177 1.23741 12.9016 1.10054 12.5854 1.10046C12.3084 1.10046 12.0315 1.2056 11.8213 1.41562L6.82544 6.41174C7.28215 6.78262 7.57607 7.34681 7.58092 7.97866Z"
                        className={`${
                            clapped ? 'fill-white-950' : 'fill-white-50'
                        } group-hover:fill-white-950`}
                    />
                    <path
                        d="M2.23911 15.3802L2.52439 15.0485L3.50508 7.91786C3.54206 6.92289 4.29576 6.1083 5.26377 5.97539L5.23591 5.00351C5.23591 4.41518 4.75449 3.93384 4.16616 3.93384C3.57783 3.93384 3.09649 4.41518 3.09649 5.00351L2.06938 12.4713C2.0693 12.4721 2.0689 12.4729 2.06841 12.4734L1.07674 13.6263C0.92187 13.8062 0.932125 14.0753 1.10024 14.2432L2.23911 15.3802Z"
                        className={`${
                            clapped ? 'fill-white-950' : 'fill-white-50'
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
                            clapped ? 'fill-white-950' : 'fill-white-50'
                        } group-hover:fill-white-950`}
                    />
                    <path
                        d="M20.5262 11.8824C20.278 11.686 19.9843 11.5523 19.6737 11.4894C19.6942 11.4523 19.7134 11.4145 19.7315 11.3762L19.9259 11.1817C20.6748 10.4328 20.7534 9.25393 20.1087 8.43943C19.8044 8.05499 19.3819 7.7995 18.9127 7.70414C18.9462 7.64245 18.9759 7.57938 19.0029 7.51535C19.5129 6.77659 19.5046 5.78371 18.9397 5.07006C18.6353 4.68537 18.2127 4.42908 17.7432 4.33388C18.1308 3.6212 18.0813 2.73297 17.5635 2.07899C17.1721 1.58441 16.5858 1.30066 15.9548 1.30066C15.4496 1.30066 14.9729 1.48121 14.5989 1.8118C14.5423 1.4905 14.4081 1.18019 14.1942 0.909922C13.8026 0.41534 13.2163 0.131673 12.5853 0.131592C12.0371 0.131592 11.5224 0.344363 11.1362 0.73058L6.22345 5.64329L6.20472 4.98761C6.19608 3.87087 5.28484 2.96496 4.16607 2.96496C3.06758 2.96496 2.16925 3.83825 2.12888 4.92697L1.14812 12.0575L0.342008 12.9945C-0.141107 13.5563 -0.108727 14.4061 0.415893 14.9294L1.61395 16.1254C1.24461 16.6811 1.30929 17.4389 1.79208 17.9205L7.41755 23.537C7.68636 23.8052 8.04319 23.9527 8.42254 23.9527C8.73399 23.9527 9.04172 23.8482 9.28889 23.6584L10.4633 22.7566C11.593 22.4897 12.8386 21.8836 14.1675 20.9535C15.3279 20.1413 16.5869 19.0592 17.9091 17.7368L20.7055 14.9405C21.1179 14.5281 21.335 13.9563 21.301 13.3718C21.2671 12.7882 20.9847 12.2454 20.5262 11.8824ZM9.96273 21.9191L8.69862 22.8898C8.61674 22.9527 8.51944 22.9837 8.42254 22.9837C8.30602 22.9837 8.18999 22.9389 8.10213 22.8512L2.47634 17.2343C2.30814 17.0666 2.29789 16.7976 2.45284 16.6174L3.44443 15.4647C3.44499 15.464 3.44532 15.4633 3.44548 15.4626L4.47251 7.99475C4.47251 7.40642 4.95393 6.925 5.54226 6.925C6.13059 6.925 6.61193 7.40642 6.61193 7.99475L6.66248 9.75699C6.67087 10.0498 6.91175 10.2404 7.16239 10.2404C7.28464 10.2404 7.40932 10.1951 7.51033 10.094L13.1975 4.40687C13.4077 4.19669 13.6845 4.09172 13.9615 4.09172C14.2777 4.09172 14.5939 4.22858 14.8106 4.5024C15.1543 4.93658 15.0939 5.56666 14.7024 5.95813L10.7847 9.87586C10.5813 10.0793 10.5813 10.409 10.7847 10.6124C10.8876 10.7153 11.0225 10.7668 11.1575 10.7668C11.2924 10.7668 11.4274 10.7153 11.5303 10.6124L16.5669 5.57586C16.777 5.36568 17.0539 5.2607 17.3309 5.2607C17.647 5.26079 17.9632 5.39765 18.18 5.67147C18.5236 6.10557 18.4633 6.73565 18.0718 7.12711L13.0588 12.14C12.8527 12.3463 12.8527 12.6804 13.0588 12.8866C13.1604 12.9882 13.2935 13.039 13.4267 13.039C13.5598 13.039 13.693 12.9882 13.7945 12.8866L17.7359 8.94532C17.9461 8.73513 18.223 8.63016 18.5 8.63016C18.8161 8.63016 19.1323 8.76702 19.349 9.04092C19.6927 9.47502 19.6324 10.1051 19.2408 10.4966L15.3367 14.4007C15.1258 14.6116 15.1258 14.9536 15.3367 15.1644L15.343 15.1708C15.4405 15.2683 15.5683 15.317 15.6959 15.317C15.8237 15.317 15.9514 15.2683 16.0488 15.1708L18.4691 12.7505C18.6872 12.5324 18.9792 12.4171 19.2702 12.4171C19.5017 12.4171 19.7326 12.4901 19.9249 12.6423C20.4385 13.0488 20.4704 13.8054 20.0204 14.2554L17.2241 17.0518C14.8358 19.4401 12.3393 21.3571 10.1463 21.835C10.0796 21.8495 10.0169 21.8776 9.96273 21.9191ZM1.07665 13.6264L2.06832 12.4735C2.0688 12.473 2.06921 12.4721 2.06929 12.4714L3.0964 5.0036C3.0964 4.41527 3.57774 3.93393 4.16607 3.93393C4.7544 3.93393 5.23582 4.41527 5.23582 5.0036L5.26368 5.9754C4.29567 6.10832 3.54197 6.92282 3.50499 7.91796L2.5243 15.0486L2.23902 15.3803L1.10023 14.2434C0.932034 14.0755 0.921779 13.8064 1.07665 13.6264ZM12.5853 1.10049C12.9016 1.10057 13.2177 1.23744 13.4344 1.51125C13.7781 1.94543 13.7178 2.57543 13.3263 2.9669L7.59972 8.63427L7.5809 7.97868C7.57598 7.34683 7.28214 6.78264 6.82543 6.41177L11.8214 1.41573C12.0314 1.20562 12.3084 1.10049 12.5853 1.10049ZM15.9547 2.26956C16.2708 2.26956 16.5871 2.40642 16.8038 2.68024C17.1474 3.11442 17.0872 3.7445 16.6957 4.13597L16.1969 4.63466C16.12 4.68594 16.0452 4.74077 15.9751 4.80286C15.9185 4.48149 15.7842 4.17117 15.5703 3.90099C15.3073 3.56879 14.9563 3.33228 14.5629 3.21245L15.1906 2.58472C15.4009 2.37461 15.6778 2.26956 15.9547 2.26956Z"
                        className={`${
                            clapped ? 'fill-white-50' : 'fill-white-950'
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
                {data.likeCount}
            </p>
        </div>
    )

    return (
        <div
            className="flex flex-col items-start justify-between min-h-[300px] py-2 rounded-md bg-[#f2f2f2] w-full relative"
            onClick={() => {
                setshowSpoiler(true)
            }}
        >
            <div
                className={`flex flex-col items-start justify-start gap-2 px-2 ${blurClasses} h-full`}
            >
                <Link
                    to="/user123"
                    className="flex flex-row items-center justify-start gap-1 group hover:cursor-pointer"
                >
                    <div className={`${baseClassesRating} ${dynamicClasses}`}>
                        <p className="text-[36px] font-bold text-white-50">
                            {parseInt(data.rating, 10)}
                        </p>
                    </div>
                    <div className="flex flex-col items-start justify-center">
                        <p className="text-small-m-400 lg:text-small-d-400 group-hover:text-red-600">
                            {critic ? data.user : data.username}
                        </p>
                        <p className="text-tiny-m-400 lg:text-tiny-d-400  group-hover:text-red-600">
                            {dateObject.getDate() +
                                '-' +
                                (dateObject.getMonth() + 1) +
                                '-' +
                                dateObject.getFullYear()}
                        </p>
                    </div>
                </Link>
                {textComponent}
            </div>
            {!showSpoiler && Boolean(data.spoiler) && (
                <div className="absolute rounded-lg  top-[0px] left-[0px] w-full h-full flex flex-row items-center justify-center text-small-m-300 lg:text-small-d-300 p-2 hover:cursor-pointer">
                    Show Spoiler
                </div>
            )}
            <div className="flex flex-row items-start justify-end border-t border-[#d8d8d8] w-full">
                {expand ? reportDiv : fullReviewDiv}
            </div>
        </div>
    )
}

export default ReviewCard
