import React from 'react'
import {Link} from 'react-router-dom'
import Carousel from 'react-elastic-carousel'
import TittleCard from '../cards/tittle/TittleCard'
import MovieCard from '../cards/movieCard/MovieCard'

function ProfileContainer({ handleLogout, watchlistdata,  }) {
     const breakPointsMovie = [
         { width: 1, itemsToShow: 2, itemsToScroll: 2 },
         { width: 408, itemsToShow: 3, itemsToScroll: 3 },
         { width: 550, itemsToShow: 4, itemsToScroll: 3 },
         { width: 672, itemsToShow: 5, itemsToScroll: 3 },
         { width: 768, itemsToShow: 4, itemsToScroll: 4 },
         { width: 880, itemsToShow: 5, itemsToScroll: 3 },
         { width: 1070, itemsToShow: 6, itemsToScroll: 5 },
     ]
    console.log(watchlistdata)
    return (
        <div className="flex flex-col items-start justify-start w-full min-[880px]:flex-row min-[880px]:items-start min-[880px]:justify-start min-[880px]:gap-3 px-1">
            {/* <div className="w-full min-[880px]:w-[320px] mt-4 min-[880px]:border min-[880px]:rounded-md min-[880px]:border-white-200 min-[880px]:p-2">
                <TittleCard
                    tittle={'Profile'}
                    to={null}
                    linkText={''}
                    mt={'mt-[0px]'}
                ></TittleCard>
                <div className="flex flex-col items-start justify-start gap-2 mt-2 w-full min-[880px]:mt-[0px]">
                    <div className="flex flex-row items-center justify-start gap-2 pb-2 border-b border-white-200 w-full">
                        <img
                            //srcset="https://small 480w, https://medium 800w, https://large 1100w"
                            src="https://image.tmdb.org/t/p/w235_and_h235_face/3dxEx32JnxUO34Wx0Y8tulUwlyh.jpg"
                            alt="Elva dressed as a fairy"
                            className="w-[70px] h-[70px] rounded-[50%] object-cover object-center"
                        />
                        <div className="flex flex-col items-start justify-start">
                            <p className="text-body-m-700 lg:text-body-d-700">
                                Ruka_Inaba1932
                            </p>
                            <p className="text-body-m-400 lg:text-body-d-400">
                                testEmail@gmail.com
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
            <div className="flex flex-col gap-3 mt-4 w-full min-[880px]:w-auto min-[880px]:rounded-md min-[880px]:border min-[880px]:border-white-200 min-[880px]:p-2 min-[880px]:pb-6 min-[880px]:grow">
                <div className="flex flex-col gap-2">
                    <TittleCard
                        tittle={'My Watchlist'}
                        to={null}
                        linkText={''}
                        mt={'mt-[0px]'}
                    ></TittleCard>
                    {watchlistdata.length > 0 ? (
                        <div className="relative mt-2 mb-4">
                            <Carousel
                                disableArrowsOnEnd={true}
                                enableMouseSwipe={false}
                                itemPadding={[0, 0, 0, 0]}
                                pagination={false}
                                breakPoints={breakPointsMovie}
                            >
                                {watchlistdata.map((item) => {
                                    return (
                                        <MovieCard
                                            key={item.id}
                                            data={item.filmDetails}
                                            images={item.images}
                                            handleAddWatchList={null}
                                        />
                                    )
                                })}
                            </Carousel>
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
                                Add movies and shows to your Watchlist to keep
                                track of what you want to watch.
                            </p>
                            <div className="flex flex-row items-center justify-center ">
                                <Link
                                    to="/browse/theaters"
                                    className="w-[200px] px-2 mt-2 rounded bg-red-600 py-1 h-full hover:cursor-pointer hover:opacity-50 text-white-50 text-small-m-400 lg:text-small-d-400"
                                >
                                    Browse Popular Movies
                                </Link>
                            </div>
                            <div className="flex flex-row items-center justify-center">
                                <Link
                                    to="/browse/tv"
                                    className="w-[200px] px-2 mt-2 rounded bg-red-600 py-1 h-full hover:cursor-pointer hover:opacity-50 text-white-50 text-small-m-400 lg:text-small-d-400"
                                >
                                    Browse Popular Tv Shows
                                </Link>
                            </div>
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
                            Rate each Movie you watched by using a 5 star scale
                            to share your thoughts and reaction.
                        </p>
                    </div>
                </div>

                <div className="flex flex-col gap-2">
                    <TittleCard
                        tittle={'My Movie Ratings'}
                        to={null}
                        linkText={''}
                        mt={'mt-[0px]'}
                    ></TittleCard>
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
                            Rate each Movie you watched by using a 5 star scale
                            to share your thoughts and reaction.
                        </p>
                    </div>
                </div>
            </div> */}
        </div>
    )
}

export default ProfileContainer