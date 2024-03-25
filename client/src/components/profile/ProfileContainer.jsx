import React, { Fragment, useEffect, useState, useRef } from 'react'
import { Link } from 'react-router-dom'
import useAuth from '../hooks/useAuth'
import { BASE_URL } from '../../utils/constants'
import TittleCard from '../cards/tittle/TittleCard'
import MovieCard from '../cards/movieCard/MovieCard'
import EditCommentCard from '../cards/editCommentCard/EditCommentCard'
import useInfiniteScrollX from '../hooks/useInfiniteScrollX'

function ProfileContainer({
    getWatchListByUser,
    getLatestMoviesCommentsByUserId,
    getLatestSeriesCommentsByUserId,
    handleLogout,
    watchlistdata,
    handleRemoveFromWatchList,
    seriesCommentsData,
    moviesCommentsData,
    handleSubmit,
    formData,
    setFormData,
    handleChange,
    fomrError,
    handleCheckboxChange,
    closePopup,
    hoveredIndex,
    isPopupOpen,
    openPopup,
    setHoveredIndex,
    setcommentId,
    setcurrentIndex,
    currentIndex,
    handleOnClick,
}) {
    const container1Ref = useRef(null)
    const container2Ref = useRef(null)
    const container3Ref = useRef(null)
    const { auth } = useAuth()
    const [filmData, setfilmData] = useState({
        filmdata: { tittle: '', mainImageId: '' },
    })

    const breakPoints = [
        { width: 1, itemsToShow: 4 },
        { width: 290, itemsToShow: 6 },
        { width: 410, itemsToShow: 8 },
        { width: 545, itemsToShow: 10 },
    ]
    const baseClassesRating =
        'flex items-center justify-center rounded-xl h-[64px] w-[64px]'
    const baseClasses =
        'flex items-center justify-center rounded-[50%] w-[44px] h-[44px] hover:cursor-pointer'

    let dynamicClasses
    let totalScoreText
    if (hoveredIndex + 1 <= 4) {
        dynamicClasses = 'bg-red-600'
        totalScoreText = 'Generally Unfavorable'
    } else if (hoveredIndex + 1 < 7 && hoveredIndex + 1 > 4) {
        dynamicClasses = 'bg-[#ffbd3f]'
        totalScoreText = 'Mixed or Average'
    } else {
        dynamicClasses = 'bg-green-600'
        totalScoreText = 'Generally Favorable'
    }

    const children = new Array(10).fill(null).map((_, index) => {
        let dynamicClasses = 'child '
        if (hoveredIndex !== null && index <= hoveredIndex) {
            dynamicClasses = dynamicClasses + 'opacity-100 '
        } else {
            dynamicClasses = dynamicClasses + 'opacity-50 '
        }
        if (index + 1 <= 4) {
            dynamicClasses = dynamicClasses + 'bg-red-600 '
        } else if (index + 1 < 7 && index + 1 > 4) {
            dynamicClasses = dynamicClasses + 'bg-[#ffbd3f] '
        } else {
            dynamicClasses = dynamicClasses + 'bg-green-600 '
        }

        return (
            <div
                key={index}
                className={`${baseClasses} ${dynamicClasses}`}
                onMouseEnter={() => setHoveredIndex(index)}
                onMouseLeave={() => handleOnMouseLeave()}
                onClick={(e) => handleOnClick(e, index)}
            >
                <p className="w-fit h-fit text-body-b-700 text-white-50">
                    {(index + 1) * 10}
                </p>
            </div>
        )
    })

    function handleOnMouseLeave() {
        if (!(hoveredIndex != null)) {
            setHoveredIndex(null)
        } else {
            setHoveredIndex(currentIndex)
        }
    }
    const renderWathcList =
        watchlistdata &&
        watchlistdata.every((page) => page.data.response.content.length > 0)
    const renderMoviesComments =
        moviesCommentsData &&
        moviesCommentsData.every(
            (page) => page.data.response.content.length > 0
        )
    const renderSeriesComments =
        seriesCommentsData &&
        seriesCommentsData.every(
            (page) => page.data.response.content.length > 0
        )

    useEffect(() => {
        if (isPopupOpen) {
            document.body.style.overflow = 'hidden'
        } else {
            document.body.style.overflow = 'auto'
        }
    }, [isPopupOpen])
    useInfiniteScrollX(
        container1Ref,
        getWatchListByUser.hasNextPage,
        getWatchListByUser.isFetchingNextPage,
        getWatchListByUser.fetchNextPage
    )
    useInfiniteScrollX(
        container2Ref,
        getLatestMoviesCommentsByUserId.hasNextPage,
        getLatestMoviesCommentsByUserId.isFetchingNextPage,
        getLatestMoviesCommentsByUserId.fetchNextPage
    )
    useInfiniteScrollX(
        container3Ref,
        getLatestSeriesCommentsByUserId.hasNextPage,
        getLatestSeriesCommentsByUserId.isFetchingNextPage,
        getLatestSeriesCommentsByUserId.fetchNextPage
    )
    return (
        <Fragment>
            <div className="grid py-2 mt-4 items-start grid-cols-1 min-[880px]:grid-cols-4 min-[880px]:gap-4 lg:px-[0px]">
                <div className="flex flex-col max-[880px]:w-full mt-4 min-[880px]:border min-[880px]:rounded-md min-[880px]:border-white-200 min-[880px]:p-2 min-[880px]:col-span-1">
                    <TittleCard
                        tittle={'Profile'}
                        to={null}
                        linkText={''}
                        mt={'mt-[0px]'}
                    ></TittleCard>
                    <div className="flex flex-col items-start justify-start gap-2 mt-2 w-full min-[880px]:mt-[0px]">
                        <div className="flex flex-row items-center justify-start gap-2 pb-4 border-b border-white-200 w-full min-[880px]:flex-col min-[880px]:items-start min-[880px]:mt-2">
                            {auth.imageurl ? (
                                <img
                                    //srcset="https://small 480w, https://medium 800w, https://large 1100w"
                                    src={`${BASE_URL}/images/${auth.imageurl}`}
                                    alt="Elva dressed as a fairy"
                                    loading="lazy"
                                    className="w-[70px] h-[70px] rounded-[50%] object-cover object-center"
                                />
                            ) : (
                               
                                    <svg
                                        width="70"
                                        height="70"
                                        viewBox="0 0 70 70"
                                        fill="none"
                                        xmlns="http://www.w3.org/2000/svg"
                                    >
                                        <g clipPath="url(#clip0_577_2)">
                                            <path
                                                d="M35 0C25.7174 0 16.815 3.68749 10.2513 10.2513C3.68749 16.815 0 25.7174 0 35C0.00123845 36.1952 0.0661452 37.3895 0.194444 38.5778C1.10441 47.1744 5.16363 55.1302 11.59 60.9123C18.0164 66.6944 26.3553 69.8936 35 69.8936C43.6447 69.8936 51.9836 66.6944 58.41 60.9123C64.8364 55.1302 68.8956 47.1744 69.8056 38.5778C69.9339 37.3895 69.9988 36.1952 70 35C70 25.7174 66.3125 16.815 59.7487 10.2513C53.185 3.68749 44.2826 0 35 0ZM56.0778 52.1889C56.0389 52.1889 55.8444 52.5 55.8056 52.5C53.2597 55.5435 50.0771 57.9913 46.4823 59.671C42.8874 61.3506 38.9679 62.2211 35 62.2211C31.0321 62.2211 27.1126 61.3506 23.5177 59.671C19.9229 57.9913 16.7403 55.5435 14.1944 52.5C14.1556 52.5 13.9611 52.1889 13.9222 52.1889C13.7087 51.879 13.5873 51.5149 13.5722 51.1389C13.5795 50.7309 13.7095 50.3346 13.9454 50.0016C14.1812 49.6686 14.512 49.4144 14.8944 49.2722C17.7722 48.3 20.5333 47.3667 21.3111 47.1722C21.293 47.0845 21.2941 46.9939 21.3142 46.9067C21.3344 46.8194 21.3731 46.7376 21.4278 46.6667C21.5297 46.2902 21.7448 45.9541 22.0438 45.7038C22.3428 45.4534 22.7115 45.3009 23.1 45.2667L28.0389 44.8778C27.9973 43.815 27.7462 42.771 27.3 41.8056V41.7667C26.8833 40.6682 26.2924 39.6439 25.55 38.7333C23.5163 36.0803 22.4342 32.8203 22.4778 29.4778C22.2627 26.0405 23.4053 22.656 25.6598 20.0525C27.9143 17.4489 31.1006 15.8341 34.5333 15.5556H35.4667C38.8994 15.8341 42.0857 17.4489 44.3402 20.0525C46.5947 22.656 47.7373 26.0405 47.5222 29.4778C47.5658 32.8203 46.4837 36.0803 44.45 38.7333C43.7076 39.6439 43.1167 40.6682 42.7 41.7667V41.8056C42.2538 42.771 42.0027 43.815 41.9611 44.8778L46.9 45.2667C47.2885 45.3009 47.6572 45.4534 47.9562 45.7038C48.2552 45.9541 48.4703 46.2902 48.5722 46.6667C48.6269 46.7376 48.6656 46.8194 48.6858 46.9067C48.7059 46.9939 48.707 47.0845 48.6889 47.1722C49.4667 47.3667 52.2278 48.3 55.1056 49.2722C55.3907 49.3637 55.6502 49.5211 55.8632 49.7317C56.0761 49.9422 56.2364 50.2 56.3311 50.4841C56.4258 50.7682 56.4522 51.0706 56.4082 51.3668C56.3642 51.663 56.251 51.9446 56.0778 52.1889Z"
                                                fill="#494C4E"
                                            />
                                        </g>
                                        <defs>
                                            <clipPath id="clip0_577_2">
                                                <rect
                                                    width="70"
                                                    height="70"
                                                    fill="white"
                                                />
                                            </clipPath>
                                        </defs>
                                    </svg>
                                
                            )}
                            <div className="flex flex-col items-start justify-start">
                                <p className="text-small-m-700 lg:text-small-d-700">
                                    {auth.user}
                                </p>
                                <p className="text-small-m-400 lg:text-small-d-400">
                                    {auth.email}
                                </p>
                            </div>
                        </div>
                        <div className="flex flex-col items-start justify-start gap-1 pb-2 border-b border-white-200 w-full">
                            <Link
                                to="/settings"
                                className="text-small-m-400 lg:text-small-d-400 text-blue-800  hover:text-blue-600 hover:cursor-pointer"
                            >
                                Manage Account
                            </Link>
                            <button
                                onClick={(e) => handleLogout(e)}
                                className="text-small-m-400 lg:text-small-d-400 text-blue-800  hover:text-blue-600 hover:cursor-pointer border-none"
                            >
                                Logout
                            </button>
                        </div>
                    </div>
                </div>
                <div className="flex flex-col gap-6 mt-4 max-[880px]:w-full min-[880px]:rounded-md min-[880px]:border min-[880px]:border-white-200 min-[880px]:p-2 min-[880px]:pb-6 min-[880px]:col-start-2 min-[880px]:col-end-5">
                    <div className="flex flex-col gap-2">
                        <TittleCard
                            tittle={'My Watchlist'}
                            to={null}
                            linkText={''}
                            mt={'mt-[0px]'}
                        ></TittleCard>

                        {renderWathcList ? (
                            <div
                                ref={container1Ref}
                                className="flex flex-row items-center justify-start gap-3 overflow-x-scroll h-[440px] w-full"
                            >
                                {watchlistdata.map((page, pageIndex) => (
                                    <Fragment key={pageIndex}>
                                        {page.data.response.content.map(
                                            (item) => (
                                                <MovieCard
                                                    key={item.id}
                                                    data={item}
                                                    id={item.film}
                                                    images={item.mainImageId}
                                                    handleAddWatchList={null}
                                                    handleRemoveFromWatchList={
                                                        handleRemoveFromWatchList
                                                    }
                                                />
                                            )
                                        )}
                                    </Fragment>
                                ))}
                            </div>
                        ) : (
                            <div className="flex flex-col items-center justify-center bg-[#F3F3F3] p-1 rounded-[4px] py-5">
                                <div className="flex flex-row items-center justify-center bg-[#DCDCE6] rounded-[50%] h-[60px] w-[60px]">
                                    <svg
                                        width="30"
                                        height="30"
                                        viewBox="0 0 30 30"
                                        fill="none"
                                        xmlns="http://www.w3.org/2000/svg"
                                    >
                                        <path
                                            d="M27.2631 15.0006C27.2631 16.6112 26.9458 18.2061 26.3295 19.6941C25.7131 21.1822 24.8097 22.5342 23.6708 23.6731C22.5319 24.812 21.1798 25.7154 19.6918 26.3318C18.2038 26.9482 16.6089 27.2654 14.9982 27.2654C11.7454 27.2654 8.62579 25.9732 6.32569 23.6731C4.02558 21.373 2.7334 18.2534 2.7334 15.0006C2.7334 11.7477 4.02558 8.62811 6.32569 6.32801C8.62579 4.0279 11.7454 2.73572 14.9982 2.73572C16.6089 2.73572 18.2038 3.05296 19.6918 3.66932C21.1798 4.28569 22.5319 5.18911 23.6708 6.32801C24.8097 7.4669 25.7131 8.81897 26.3295 10.307C26.9458 11.795 27.2631 13.3899 27.2631 15.0006ZM25.3916 14.9953C25.3916 13.6306 25.1228 12.2794 24.6006 11.0186C24.0784 9.75783 23.3129 8.61227 22.348 7.64732C21.383 6.68237 20.2375 5.91693 18.9767 5.3947C17.7159 4.87247 16.3646 4.60369 15 4.60369C12.244 4.60369 9.60083 5.69851 7.65203 7.64732C5.70323 9.59612 4.6084 12.2393 4.6084 14.9953C4.6084 17.7513 5.70323 20.3945 7.65203 22.3433C9.60083 24.2921 12.244 25.3869 15 25.3869C16.3646 25.3869 17.7159 25.1181 18.9767 24.5959C20.2375 24.0736 21.383 23.3082 22.348 22.3433C23.3129 21.3783 24.0784 20.2327 24.6006 18.972C25.1228 17.7112 25.3916 16.3599 25.3916 14.9953Z"
                                            fill="black"
                                        />
                                        <path
                                            d="M15.9374 15.9844C15.9366 17.3703 15.937 18.7174 15.9386 20.0256C15.939 20.2487 15.8808 20.442 15.764 20.6057C15.3286 21.2156 14.411 21.0985 14.1315 20.417C14.0843 20.3026 14.0608 20.1629 14.0612 19.9981C14.0624 18.6813 14.0628 17.35 14.0624 16.0043C14.0624 15.9606 14.0405 15.9385 13.9968 15.9381C12.6104 15.9365 11.2726 15.9369 9.98311 15.9393C9.83467 15.9397 9.70283 15.9158 9.5876 15.8678C8.82412 15.5508 8.78603 14.4674 9.5624 14.1381C9.69092 14.0838 9.87393 14.0571 10.1114 14.0578C11.4392 14.0641 12.7411 14.0647 14.0173 14.0596C14.0285 14.0596 14.0392 14.0551 14.0471 14.0472C14.055 14.0393 14.0595 14.0286 14.0595 14.0174C14.0669 12.8217 14.0661 11.5555 14.0571 10.2188C14.0552 9.90783 14.0827 9.6885 14.1397 9.56076C14.37 9.04338 14.9876 8.83537 15.4774 9.1301C15.8062 9.32815 15.9409 9.64397 15.9397 10.0155C15.9358 11.4065 15.9353 12.7342 15.938 13.9987C15.938 14.0153 15.9446 14.0312 15.9564 14.043C15.9681 14.0547 15.9841 14.0613 16.0007 14.0613C17.2456 14.0664 18.5104 14.0656 19.7952 14.059C20.0948 14.0574 20.3054 14.0824 20.4269 14.134C21.1897 14.4604 21.1944 15.528 20.4327 15.8614C20.3104 15.9153 20.1343 15.9418 19.9042 15.941C18.4886 15.936 17.1813 15.9352 15.9825 15.9387C15.9524 15.9387 15.9374 15.9539 15.9374 15.9844Z"
                                            fill="black"
                                        />
                                    </svg>
                                </div>

                                <p className="text-center text-body-m-700 lg:text-body-d-700">
                                    Your Watchlist is Empty
                                </p>
                                <p className="text-center text-small-m-400 lg:text-small-d-400 mt-1">
                                    Add movies and shows to your Watchlist to
                                    keep track of what you want to watch.
                                </p>
                                <div className="flex flex-row items-center justify-center ">
                                    <Link
                                        to="/browse?at=theaters"
                                        className="w-[200px] px-2 mt-2 rounded bg-red-600 py-1 h-full hover:cursor-pointer hover:opacity-50 text-white-50 text-small-m-400 lg:text-small-d-400"
                                    >
                                        Browse Popular Movies
                                    </Link>
                                </div>
                                <div className="flex flex-row items-center justify-center">
                                    <Link
                                        to="/browse?at=home"
                                        className="w-[200px] px-2 mt-2 rounded bg-red-600 py-1 h-full hover:cursor-pointer hover:opacity-50 text-white-50 text-small-m-400 lg:text-small-d-400"
                                    >
                                        Browse Popular Tv Shows
                                    </Link>
                                </div>
                            </div>
                        )}
                    </div>
                    <div className="flex flex-col gap-2 w-full">
                        <TittleCard
                            tittle={'My Movie Ratings'}
                            to={null}
                            linkText={''}
                            mt={'mt-[0px]'}
                        ></TittleCard>

                        {renderMoviesComments ? (
                            <div
                                ref={container2Ref}
                                className="flex flex-row items-center justify-start gap-3 overflow-x-scroll h-[245px] w-full"
                            >
                                {moviesCommentsData.map((page, pageIndex) => (
                                    <Fragment key={pageIndex}>
                                        {page.data.response.content.map(
                                            (item) => (
                                                <div
                                                    key={item.id}
                                                    className="flex flex-row items-center bg-white border border-gray-200 rounded-lg dark:border-gray-100 dark:bg-white-50 min-w-[450px] h-[180px] shadow-md"
                                                >
                                                    <img
                                                        className="object-cover object-center rounded-tl-lg rounded-bl-lg w-[120px] h-full"
                                                        src={`${BASE_URL}/images/${item.mainImageId}`}
                                                        alt=""
                                                        loading="lazy"
                                                    />
                                                    <div className="flex flex-col items-start justify-between h-full max-h-[178px] grow-[2]">
                                                        <div className="flex flex-col items-start justify-start h-full px-1 py-2 w-full">
                                                            <p className="text-small-d-700 overflow-hidden text-ellipsis line-clamp-2 break-words max-w-[100%]">
                                                                {item.filmName}
                                                            </p>
                                                            <p className="text-tag overflow-hidden text-ellipsis line-clamp-5 break-words max-w-[100%]">
                                                                {item.body}
                                                            </p>
                                                        </div>
                                                        <button
                                                            onClick={() => {
                                                                setcommentId(
                                                                    item.id
                                                                )
                                                                setcurrentIndex(
                                                                    item.rating /
                                                                        10
                                                                )
                                                                setHoveredIndex(
                                                                    item.rating /
                                                                        10
                                                                )
                                                                setFormData({
                                                                    text: item.body,
                                                                })
                                                                setfilmData({
                                                                    filmdata: {
                                                                        tittle: item.filmName,
                                                                        mainImageId:
                                                                            item.mainImageId,
                                                                    },
                                                                })
                                                                openPopup()
                                                            }}
                                                            className="flex flex-row items-center gap-1 self-end pr-1 pb-1"
                                                        >
                                                            <svg
                                                                width="16"
                                                                height="16"
                                                                viewBox="0 0 16 16"
                                                                fill="none"
                                                                xmlns="http://www.w3.org/2000/svg"
                                                            >
                                                                <g clipPath="url(#clip0_540_2)">
                                                                    <path
                                                                        fillRule="evenodd"
                                                                        clipRule="evenodd"
                                                                        d="M14.4 14.1034H1.6V1.97778H8V0.462071H0V15.6191H16V8.04057H14.4V14.1034ZM4.8 7.96176L12.6712 0.380981L16 3.51621L7.8736 11.072H4.8V7.96176Z"
                                                                        fill="black"
                                                                    />
                                                                </g>
                                                                <defs>
                                                                    <clipPath id="clip0_540_2">
                                                                        <rect
                                                                            width="16"
                                                                            height="16"
                                                                            fill="white"
                                                                        />
                                                                    </clipPath>
                                                                </defs>
                                                            </svg>
                                                            <p className="text-tiny-d-300">
                                                                Edit
                                                            </p>
                                                        </button>
                                                    </div>
                                                </div>
                                            )
                                        )}
                                    </Fragment>
                                ))}
                            </div>
                        ) : (
                            <div className="flex flex-col items-center justify-center bg-[#F3F3F3] p-1 rounded-[4px] py-5">
                                <div className="flex flex-row items-center justify-center bg-[#DCDCE6] rounded-[50%] h-[60px] w-[60px]">
                                    <svg
                                        width="30"
                                        height="30"
                                        viewBox="0 0 30 30"
                                        fill="none"
                                        xmlns="http://www.w3.org/2000/svg"
                                    >
                                        <path
                                            d="M10.5661 10.0858C11.7763 7.63421 12.971 5.21312 14.1503 2.82249C14.3683 2.38069 14.881 2.23948 15.3304 2.37894C15.6222 2.46976 15.7716 2.65667 15.9052 2.92737C17.0833 5.32503 18.2626 7.71663 19.4431 10.1022C19.447 10.11 19.4531 10.1145 19.4613 10.1157C22.0124 10.4926 24.5869 10.8662 27.1845 11.2366C27.5181 11.2842 27.7521 11.3465 27.8865 11.4235C28.1353 11.5664 28.279 11.8141 28.3177 12.1664C28.357 12.5221 28.1577 12.7846 27.907 13.0278C26.0007 14.8782 24.1042 16.726 22.2175 18.5713C22.213 18.5757 22.2096 18.581 22.2077 18.5868C22.2057 18.5926 22.2053 18.5988 22.2064 18.6047C22.6384 21.1434 23.0792 23.7045 23.5288 26.2881C23.587 26.6233 23.5974 26.8709 23.5599 27.0311C23.4579 27.4647 22.9681 27.7934 22.5046 27.7037C22.3929 27.6823 22.2501 27.6258 22.0763 27.5344C19.7279 26.2992 17.3802 25.0651 15.0333 23.8319C15.024 23.8268 15.0134 23.8242 15.0027 23.8242C14.992 23.8242 14.9814 23.8268 14.9718 23.8319C12.6066 25.0748 10.2382 26.32 7.86673 27.5672C7.38002 27.8235 6.96302 27.7559 6.61576 27.3645C6.389 27.1096 6.38841 26.7926 6.44466 26.4662C6.89193 23.8744 7.34173 21.2543 7.79408 18.6059C7.79516 18.5995 7.79471 18.593 7.79277 18.5869C7.79083 18.5808 7.78746 18.5752 7.78295 18.5707C5.93099 16.7567 4.06791 14.9416 2.19369 13.1256C1.95033 12.8901 1.80521 12.7168 1.75834 12.6059C1.50111 12 1.87435 11.3795 2.5183 11.2864C5.2472 10.8918 7.91166 10.5047 10.5117 10.125C10.5232 10.1234 10.5343 10.119 10.5438 10.1121C10.5532 10.1053 10.5609 10.0962 10.5661 10.0858Z"
                                            fill="black"
                                        />
                                    </svg>
                                </div>

                                <p className="text-center text-body-m-700 lg:text-body-d-700">
                                    No Movie Ratings Yet
                                </p>
                                <p className="text-center text-small-m-400 lg:text-small-d-400 mt-1">
                                    Rate each Movie you watched by using a 5
                                    star scale to share your thoughts and
                                    reaction.
                                </p>
                            </div>
                        )}
                    </div>

                    <div className="flex flex-col gap-2">
                        <TittleCard
                            tittle={'My Movie Ratings'}
                            to={null}
                            linkText={''}
                            mt={'mt-[0px]'}
                        ></TittleCard>

                        {renderSeriesComments ? (
                            <div
                                ref={container3Ref}
                                className="flex flex-row items-center justify-start gap-3 overflow-x-scroll h-[245px] w-full"
                            >
                                {seriesCommentsData.map((page, pageIndex) => (
                                    <Fragment key={pageIndex}>
                                        {page.data.response.content.map(
                                            (item) => (
                                                <div
                                                    key={item.id}
                                                    className="flex flex-row items-start bg-white border border-gray-200 rounded-lg dark:border-gray-100 dark:bg-white-50 min-w-[450px] h-[180px] shadow-md"
                                                >
                                                    <img
                                                        className="object-cover object-center rounded-tl-lg rounded-bl-lg w-[120px] h-full"
                                                        src={`${BASE_URL}/images/${item.mainImageId}`}
                                                        alt=""
                                                        loading="lazy"
                                                    />
                                                    <div className="flex flex-col items-start justify-between h-full max-h-[178px] grow-[2]">
                                                        <div className="flex flex-col items-start justify-start h-full px-1 py-2 w-full">
                                                            <p className="text-small-d-700 overflow-hidden text-ellipsis line-clamp-2 break-words ">
                                                                {item.filmName}
                                                            </p>
                                                            <p className="text-tag overflow-hidden text-ellipsis line-clamp-5 break-words ">
                                                                {item.body}
                                                            </p>
                                                        </div>
                                                        <button
                                                            onClick={() => {
                                                                setcommentId(
                                                                    item.id
                                                                )
                                                                setcurrentIndex(
                                                                    item.rating /
                                                                        10
                                                                )
                                                                setHoveredIndex(
                                                                    item.rating /
                                                                        10
                                                                )
                                                                setFormData({
                                                                    text: item.body,
                                                                })
                                                                setfilmData({
                                                                    filmdata: {
                                                                        tittle: item.filmName,
                                                                        mainImageId:
                                                                            item.mainImageId,
                                                                    },
                                                                })
                                                                openPopup()
                                                            }}
                                                            className="flex flex-row items-center gap-1 self-end pr-1 pb-1"
                                                        >
                                                            <svg
                                                                width="16"
                                                                height="16"
                                                                viewBox="0 0 16 16"
                                                                fill="none"
                                                                xmlns="http://www.w3.org/2000/svg"
                                                            >
                                                                <g clipPath="url(#clip0_540_2)">
                                                                    <path
                                                                        fillRule="evenodd"
                                                                        clipRule="evenodd"
                                                                        d="M14.4 14.1034H1.6V1.97778H8V0.462071H0V15.6191H16V8.04057H14.4V14.1034ZM4.8 7.96176L12.6712 0.380981L16 3.51621L7.8736 11.072H4.8V7.96176Z"
                                                                        fill="black"
                                                                    />
                                                                </g>
                                                                <defs>
                                                                    <clipPath id="clip0_540_2">
                                                                        <rect
                                                                            width="16"
                                                                            height="16"
                                                                            fill="white"
                                                                        />
                                                                    </clipPath>
                                                                </defs>
                                                            </svg>
                                                            <p className="text-tiny-d-300">
                                                                Edit
                                                            </p>
                                                        </button>
                                                    </div>
                                                </div>
                                            )
                                        )}
                                    </Fragment>
                                ))}
                            </div>
                        ) : (
                            <div className="flex flex-col items-center justify-center bg-[#F3F3F3] p-1 rounded-[4px] py-5">
                                <div className="flex flex-row items-center justify-center bg-[#DCDCE6] rounded-[50%] h-[60px] w-[60px]">
                                    <svg
                                        width="30"
                                        height="30"
                                        viewBox="0 0 30 30"
                                        fill="none"
                                        xmlns="http://www.w3.org/2000/svg"
                                    >
                                        <path
                                            d="M10.5661 10.0858C11.7763 7.63421 12.971 5.21312 14.1503 2.82249C14.3683 2.38069 14.881 2.23948 15.3304 2.37894C15.6222 2.46976 15.7716 2.65667 15.9052 2.92737C17.0833 5.32503 18.2626 7.71663 19.4431 10.1022C19.447 10.11 19.4531 10.1145 19.4613 10.1157C22.0124 10.4926 24.5869 10.8662 27.1845 11.2366C27.5181 11.2842 27.7521 11.3465 27.8865 11.4235C28.1353 11.5664 28.279 11.8141 28.3177 12.1664C28.357 12.5221 28.1577 12.7846 27.907 13.0278C26.0007 14.8782 24.1042 16.726 22.2175 18.5713C22.213 18.5757 22.2096 18.581 22.2077 18.5868C22.2057 18.5926 22.2053 18.5988 22.2064 18.6047C22.6384 21.1434 23.0792 23.7045 23.5288 26.2881C23.587 26.6233 23.5974 26.8709 23.5599 27.0311C23.4579 27.4647 22.9681 27.7934 22.5046 27.7037C22.3929 27.6823 22.2501 27.6258 22.0763 27.5344C19.7279 26.2992 17.3802 25.0651 15.0333 23.8319C15.024 23.8268 15.0134 23.8242 15.0027 23.8242C14.992 23.8242 14.9814 23.8268 14.9718 23.8319C12.6066 25.0748 10.2382 26.32 7.86673 27.5672C7.38002 27.8235 6.96302 27.7559 6.61576 27.3645C6.389 27.1096 6.38841 26.7926 6.44466 26.4662C6.89193 23.8744 7.34173 21.2543 7.79408 18.6059C7.79516 18.5995 7.79471 18.593 7.79277 18.5869C7.79083 18.5808 7.78746 18.5752 7.78295 18.5707C5.93099 16.7567 4.06791 14.9416 2.19369 13.1256C1.95033 12.8901 1.80521 12.7168 1.75834 12.6059C1.50111 12 1.87435 11.3795 2.5183 11.2864C5.2472 10.8918 7.91166 10.5047 10.5117 10.125C10.5232 10.1234 10.5343 10.119 10.5438 10.1121C10.5532 10.1053 10.5609 10.0962 10.5661 10.0858Z"
                                            fill="black"
                                        />
                                    </svg>
                                </div>

                                <p className="text-center text-body-m-700 lg:text-body-d-700">
                                    No Movie Ratings Yet
                                </p>
                                <p className="text-center text-small-m-400 lg:text-small-d-400 mt-1">
                                    Rate each Movie you watched by using a 5
                                    star scale to share your thoughts and
                                    reaction.
                                </p>
                            </div>
                        )}
                    </div>
                </div>
            </div>
            {isPopupOpen && (
                <EditCommentCard
                    filmdata={filmData}
                    baseClassesRating={baseClassesRating}
                    dynamicClasses={dynamicClasses}
                    totalScoreText={totalScoreText}
                    hoveredIndex={hoveredIndex}
                    children={children}
                    breakPoints={breakPoints}
                    handleSubmit={handleSubmit}
                    formData={formData}
                    handleChange={handleChange}
                    fomrError={fomrError}
                    handleCheckboxChange={handleCheckboxChange}
                    closePopup={closePopup}
                ></EditCommentCard>
            )}
        </Fragment>
    )
}

export default ProfileContainer
