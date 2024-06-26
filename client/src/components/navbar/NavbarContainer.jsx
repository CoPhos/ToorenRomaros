import React, {
    useContext,
    useState,
    useEffect,
    lazy,
    Suspense,
    Fragment,
} from 'react'
import { Link } from 'react-router-dom'
import { useLocation, useNavigate } from 'react-router-dom'
import { LoginPopUpContext } from '../context/LoginPopUpProvider'
import { BASE_URL } from '../../utils/constants'

import gemstone from '../../assests/gemstone.png'
import LinksPanel from './LinksPanel'
const LoginManager = lazy(() => import('../login/LoginManager'))
const SignUpManager = lazy(() => import('../signup/SignUpManager'))
const SearchPanel = lazy(() => import('./SearchPanel'))

function Navbar({
    user,
    roles,
    image,
    moviesExplore,
    tvExplore,
    moviesQuery,
    tvQuery,
    searchQuery,
    handleOnChange,
    getFilmsBySearchQuery,
    getPostBySearchQuery,
    isDivVisible,
    setDivVisibility,
    inputRef,
    divRef,
    setSearchQuery,
    onlyLogo,
}) {
    const { pathname } = useLocation()

    const { isPopupOpen, setisPopupOpen } = useContext(LoginPopUpContext)
    const [active, setactive] = useState(1)

    const openPopup = () => {
        setisPopupOpen(true)
    }

    const closePopup = () => {
        setisPopupOpen(false)
    }

    useEffect(() => {
        if (isPopupOpen) {
            document.body.style.overflow = 'hidden'
        } else {
            document.body.style.overflow = 'auto'
        }
    }, [isPopupOpen])

    useEffect(() => {
        setDivVisibility(
            searchQuery.trim() !== '' &&
                document.activeElement === inputRef.current
        )
    }, [searchQuery])

    const handleClickOutside = (event) => {
        if (event.target.classList.contains('not-hide')) {
            return
        }
        if (divRef.current && !divRef.current.contains(event.target)) {
            setSearchQuery('')
            setDivVisibility(false)
        }
    }

    useEffect(() => {
        setSearchQuery('')
        setDivVisibility(false)
    }, [pathname])

    useEffect(() => {
        document.addEventListener('click', handleClickOutside)

        return () => {
            document.removeEventListener('click', handleClickOutside)
        }
    }, [])

    let toProfile
    if (roles?.includes('USER')) {
        toProfile = '/profile'
    } else if (roles?.includes('CRITIC')) {
        toProfile = '/critic'
    }

    const baseClassesButton =
        'text-white-500 text-h3-m-700  lg:text-h3-d-700 border-[none] hover:cursor-pointer py-1 px-1'
    const focus = 'text-white-900 border-b-[1px] border-white-950'
    const notFocus = 'border-[none]'

    return (
        <nav className="border-b border-white-300 px-2 min-h-[72px] flex flex-row items-center sticky top-[0px] bg-white-50 z-20">
            <div className="flex flex-row items-center justify-between max-w-[1120px] mx-auto my-0 w-full">
                <Link to="/">
                    <div className="flex flex-row items-center justify-center h-full">
                        <img
                            src={gemstone}
                            width={42}
                            height={42}
                            title="logo"
                        ></img>
                        <p className="font-SonsieOne text-h3-m-400 lg:text-h3-d-400">
                            Cinnabar
                        </p>
                    </div>
                </Link>
                {!onlyLogo && (
                    <Fragment>
                        <div className="flex flex-row items-center justify-between gap-2 min-[880px]:hidden">
                            {/* <Link to="/search">
                        <svg
                            width="24"
                            height="24"
                            viewBox="0 0 24 24"
                            fill="none"
                            xmlns="http://www.w3.org/2000/svg"
                        >
                            <path
                                d="M9.54 0H9.90516C11.5355 0.05375 13.0258 0.464844 14.3761 1.23328C15.5323 1.89109 16.4981 2.72375 17.2734 3.73125C18.7522 5.6525 19.4228 7.85313 19.2853 10.3331C19.2697 10.615 19.2322 10.928 19.1728 11.272C18.8991 12.8545 18.2717 14.2838 17.2908 15.5597C17.2871 15.5644 17.2854 15.5704 17.2858 15.5764C17.2862 15.5824 17.2888 15.5882 17.2931 15.5925C19.4109 17.7106 21.5277 19.8273 23.6433 21.9427C23.8442 22.1436 23.9631 22.3937 24 22.6931V22.9036C23.8934 23.5452 23.518 23.9106 22.8736 24H22.7184C22.3847 23.9648 22.1391 23.8355 21.8958 23.5922C19.7892 21.4822 17.6902 19.383 15.5986 17.2945C15.5937 17.2895 15.5871 17.2864 15.5801 17.2859C15.5731 17.2854 15.5662 17.2874 15.5606 17.2917C14.4947 18.1127 13.317 18.6863 12.0277 19.0125C8.955 19.7906 5.65359 19.0027 3.28969 16.9083C1.47563 15.3011 0.402656 13.2784 0.0707812 10.8403C0.0548437 10.7222 0.03125 10.432 0 9.96984V9.36094C0.095625 7.07812 0.871562 5.08141 2.32781 3.37078C4.11797 1.26703 6.75188 0.0510937 9.54 0ZM16.912 9.65719C16.912 7.73271 16.1475 5.88705 14.7867 4.52624C13.4259 3.16543 11.5803 2.40094 9.65578 2.40094C7.7313 2.40094 5.88565 3.16543 4.52484 4.52624C3.16403 5.88705 2.39953 7.73271 2.39953 9.65719C2.39953 11.5817 3.16403 13.4273 4.52484 14.7881C5.88565 16.1489 7.7313 16.9134 9.65578 16.9134C11.5803 16.9134 13.4259 16.1489 14.7867 14.7881C16.1475 13.4273 16.912 11.5817 16.912 9.65719Z"
                                fill="#656565"
                            />
                        </svg>
                    </Link> */}
                            {user ? (
                                <Link
                                    to={`${toProfile}`}
                                    className="flex flex-row items-center justify-start gap-1 hover:cursor-pointer group"
                                >
                                    {image ? (
                                        <img
                                            //srcset="https://small 480w, https://medium 800w, https://large 1100w"
                                            src={`${BASE_URL}/images/${image}`}
                                            alt="Elva dressed as a fairy"
                                            loading="lazy"
                                            className="w-[34px] h-[34px] rounded-[50%] object-cover object-center"
                                        />
                                    ) : (
                                        <div className="h-[34px] w-[34px] rounded-[50%] border border-white-400">
                                            <svg
                                                width="34"
                                                height="34"
                                                viewBox="0 0 34 34"
                                                fill="none"
                                                xmlns="http://www.w3.org/2000/svg"
                                            >
                                                <g clipPath="url(#clip0_577_4)">
                                                    <path
                                                        d="M17 0C12.4913 0 8.1673 1.79107 4.97918 4.97918C1.79107 8.1673 0 12.4913 0 17C0.000601532 17.5805 0.0321277 18.1606 0.0944444 18.7378C0.536427 22.9133 2.50805 26.7775 5.62944 29.586C8.75084 32.3944 12.8011 33.9483 17 33.9483C21.1989 33.9483 25.2492 32.3944 28.3706 29.586C31.4919 26.7775 33.4636 22.9133 33.9056 18.7378C33.9679 18.1606 33.9994 17.5805 34 17C34 12.4913 32.2089 8.1673 29.0208 4.97918C25.8327 1.79107 21.5087 0 17 0ZM27.2378 25.3489C27.2189 25.3489 27.1244 25.5 27.1056 25.5C25.869 26.9783 24.3232 28.1672 22.5771 28.983C20.831 29.7989 18.9273 30.2217 17 30.2217C15.0727 30.2217 13.169 29.7989 11.4229 28.983C9.67682 28.1672 8.13101 26.9783 6.89444 25.5C6.87556 25.5 6.78111 25.3489 6.76222 25.3489C6.6585 25.1984 6.59955 25.0215 6.59222 24.8389C6.59574 24.6407 6.6589 24.4482 6.77347 24.2865C6.88803 24.1247 7.04867 24.0013 7.23444 23.9322C8.63222 23.46 9.97333 23.0067 10.3511 22.9122C10.3423 22.8696 10.3428 22.8256 10.3526 22.7833C10.3624 22.7409 10.3812 22.7011 10.4078 22.6667C10.4573 22.4838 10.5617 22.3206 10.707 22.199C10.8522 22.0774 11.0313 22.0033 11.22 21.9867L13.6189 21.7978C13.5987 21.2816 13.4767 20.7745 13.26 20.3056V20.2867C13.0576 19.7531 12.7706 19.2556 12.41 18.8133C11.4222 17.5247 10.8966 15.9413 10.9178 14.3178C10.8133 12.6482 11.3683 11.0044 12.4633 9.73977C13.5584 8.47517 15.106 7.69087 16.7733 7.55556H17.2267C18.894 7.69087 20.4416 8.47517 21.5367 9.73977C22.6317 11.0044 23.1867 12.6482 23.0822 14.3178C23.1034 15.9413 22.5778 17.5247 21.59 18.8133C21.2294 19.2556 20.9424 19.7531 20.74 20.2867V20.3056C20.5233 20.7745 20.4013 21.2816 20.3811 21.7978L22.78 21.9867C22.9687 22.0033 23.1478 22.0774 23.293 22.199C23.4383 22.3206 23.5427 22.4838 23.5922 22.6667C23.6188 22.7011 23.6376 22.7409 23.6474 22.7833C23.6572 22.8256 23.6577 22.8696 23.6489 22.9122C24.0267 23.0067 25.3678 23.46 26.7656 23.9322C26.904 23.9767 27.0301 24.0531 27.1335 24.1554C27.237 24.2576 27.3148 24.3828 27.3608 24.5208C27.4068 24.6588 27.4197 24.8057 27.3983 24.9496C27.3769 25.0934 27.3219 25.2302 27.2378 25.3489Z"
                                                        fill="#494C4E"
                                                    />
                                                </g>
                                                <defs>
                                                    <clipPath id="clip0_577_4">
                                                        <rect
                                                            width="34"
                                                            height="34"
                                                            fill="white"
                                                        />
                                                    </clipPath>
                                                </defs>
                                            </svg>
                                        </div>
                                    )}
                                    <p className="hidden sm:block text-small-d-400 group-hover:text-red-600">
                                        {user}
                                    </p>
                                </Link>
                            ) : (
                                <button
                                    onClick={openPopup}
                                    className="flex flex-row items-center justify-center w-[98px] h-[32px] bg-red-600 rounded hover:bg-red-400 text-white-50 text-small-d-400"
                                >
                                    Sign in
                                </button>
                            )}
                        </div>

                        <div className="flex-row items-center justify-center gap-3 hidden min-[880px]:flex">
                            <div className="relative">
                                <ul className="flex flex-row items-center justify-between gap-4">
                                    <li className="group px-2 hover:bg-white-100 rounded-t-md h-6">
                                        <div className="h-full flex flex-row items-center justify-center">
                                            <Link
                                                to="/browse?at=theaters"
                                                className="group-hover:cursor-pointer group-hover:text-red-600 text-body-d-700 "
                                            >
                                                Movies
                                            </Link>
                                        </div>
                                        <div className="w-fit h-[550px] absolute bg-white-50 hidden group-hover:flex top-6 left-[0px] rounded-b-md shadow-[0_2.8px_2.2px_rgba(0,_0,_0,_0.034),_0_6.7px_5.3px_rgba(0,_0,_0,_0.048),_0_12.5px_10px_rgba(0,_0,_0,_0.06),_0_22.3px_17.9px_rgba(0,_0,_0,_0.072),_0_41.8px_33.4px_rgba(0,_0,_0,_0.086),_0_100px_80px_rgba(0,_0,_0,_0.12)]">
                                            <LinksPanel
                                                data={moviesExplore}
                                                filmData={
                                                    moviesQuery.isLoading
                                                        ? []
                                                        : moviesQuery.data?.data
                                                              ?.response || []
                                                }
                                                tittle1={'Explore Movies'}
                                                tittle2={
                                                    'New Movies in Theaters'
                                                }
                                            ></LinksPanel>
                                        </div>
                                    </li>
                                    <li className="group px-2 hover:bg-white-100 rounded-t-md h-6">
                                        <div className="h-full flex flex-row items-center justify-center">
                                            <Link
                                                to="/browse?at=home"
                                                className="group-hover:cursor-pointer group-hover:text-red-600 text-body-d-700 "
                                            >
                                                Tv Shows
                                            </Link>
                                        </div>
                                        <div className="w-fit h-[550px] absolute bg-white-50 hidden group-hover:flex top-6 left-[0px] rounded-b-md shadow-[0_2.8px_2.2px_rgba(0,_0,_0,_0.034),_0_6.7px_5.3px_rgba(0,_0,_0,_0.048),_0_12.5px_10px_rgba(0,_0,_0,_0.06),_0_22.3px_17.9px_rgba(0,_0,_0,_0.072),_0_41.8px_33.4px_rgba(0,_0,_0,_0.086),_0_100px_80px_rgba(0,_0,_0,_0.12)]">
                                            <LinksPanel
                                                data={tvExplore}
                                                filmData={
                                                    tvQuery.isLoading
                                                        ? []
                                                        : tvQuery.data?.data
                                                              ?.response || []
                                                }
                                                tittle1={'Explore TV'}
                                                tittle2={'New TV Shows'}
                                            ></LinksPanel>
                                        </div>
                                    </li>
                                    {/* <li className="group px-2 hover:bg-white-100 rounded-md h-6">
                                <div className="h-full flex flex-row items-center justify-center">
                                    <Link
                                        to="/blog"
                                        className="group-hover:cursor-pointer group-hover:text-red-600 text-body-d-700 "
                                    >
                                        Blog
                                    </Link>
                                </div>
                            </li> */}
                                </ul>
                            </div>
                            <div className="flex flex-row items-center justify-start gap-2 not-hide">
                                <div className="flex flex-row items-center justify-start gap-1 w-[265px] h-5 bg-white-100 rounded-3xl px-2 relative not-hide">
                                    <svg
                                        width="24"
                                        height="24"
                                        viewBox="0 0 24 24"
                                        fill="none"
                                        xmlns="http://www.w3.org/2000/svg"
                                        className="not-hide"
                                    >
                                        <path
                                            d="M9.54 0H9.90516C11.5355 0.05375 13.0258 0.464844 14.3761 1.23328C15.5323 1.89109 16.4981 2.72375 17.2734 3.73125C18.7522 5.6525 19.4228 7.85313 19.2853 10.3331C19.2697 10.615 19.2322 10.928 19.1728 11.272C18.8991 12.8545 18.2717 14.2838 17.2908 15.5597C17.2871 15.5644 17.2854 15.5704 17.2858 15.5764C17.2862 15.5824 17.2888 15.5882 17.2931 15.5925C19.4109 17.7106 21.5277 19.8273 23.6433 21.9427C23.8442 22.1436 23.9631 22.3937 24 22.6931V22.9036C23.8934 23.5452 23.518 23.9106 22.8736 24H22.7184C22.3847 23.9648 22.1391 23.8355 21.8958 23.5922C19.7892 21.4822 17.6902 19.383 15.5986 17.2945C15.5937 17.2895 15.5871 17.2864 15.5801 17.2859C15.5731 17.2854 15.5662 17.2874 15.5606 17.2917C14.4947 18.1127 13.317 18.6863 12.0277 19.0125C8.955 19.7906 5.65359 19.0027 3.28969 16.9083C1.47563 15.3011 0.402656 13.2784 0.0707812 10.8403C0.0548437 10.7222 0.03125 10.432 0 9.96984V9.36094C0.095625 7.07812 0.871562 5.08141 2.32781 3.37078C4.11797 1.26703 6.75188 0.0510937 9.54 0ZM16.912 9.65719C16.912 7.73271 16.1475 5.88705 14.7867 4.52624C13.4259 3.16543 11.5803 2.40094 9.65578 2.40094C7.7313 2.40094 5.88565 3.16543 4.52484 4.52624C3.16403 5.88705 2.39953 7.73271 2.39953 9.65719C2.39953 11.5817 3.16403 13.4273 4.52484 14.7881C5.88565 16.1489 7.7313 16.9134 9.65578 16.9134C11.5803 16.9134 13.4259 16.1489 14.7867 14.7881C16.1475 13.4273 16.912 11.5817 16.912 9.65719Z"
                                            fill="#656565"
                                        />
                                    </svg>
                                    <input
                                        ref={inputRef}
                                        placeholder="Search Movies, Tv, Actors..."
                                        type="text"
                                        id="fname"
                                        name="fname"
                                        value={searchQuery}
                                        onChange={(event) =>
                                            handleOnChange(event)
                                        }
                                        className="outline-none bg-transparent text-small-d-400 w-full not-hide"
                                    />
                                    {isDivVisible && (
                                        <Suspense fallback={<h1></h1>}>
                                            <SearchPanel
                                                divRef={divRef}
                                                filmQuery={
                                                    getFilmsBySearchQuery
                                                }
                                                postQuery={getPostBySearchQuery}
                                            ></SearchPanel>
                                        </Suspense>
                                    )}
                                </div>
                                {user ? (
                                    <Link
                                        to={`${toProfile}`}
                                        className="flex flex-row items-center justify-start gap-1 hover:cursor-pointer group"
                                    >
                                        {image ? (
                                            <img
                                                //srcset="https://small 480w, https://medium 800w, https://large 1100w"
                                                src={`${BASE_URL}/images/${image}`}
                                                alt="Elva dressed as a fairy"
                                                loading="lazy"
                                                className="w-[34px] h-[34px] rounded-[50%] object-cover object-center"
                                            />
                                        ) : (
                                            <svg
                                                width="34"
                                                height="34"
                                                viewBox="0 0 34 34"
                                                fill="none"
                                                xmlns="http://www.w3.org/2000/svg"
                                            >
                                                <g clipPath="url(#clip0_577_4)">
                                                    <path
                                                        d="M17 0C12.4913 0 8.1673 1.79107 4.97918 4.97918C1.79107 8.1673 0 12.4913 0 17C0.000601532 17.5805 0.0321277 18.1606 0.0944444 18.7378C0.536427 22.9133 2.50805 26.7775 5.62944 29.586C8.75084 32.3944 12.8011 33.9483 17 33.9483C21.1989 33.9483 25.2492 32.3944 28.3706 29.586C31.4919 26.7775 33.4636 22.9133 33.9056 18.7378C33.9679 18.1606 33.9994 17.5805 34 17C34 12.4913 32.2089 8.1673 29.0208 4.97918C25.8327 1.79107 21.5087 0 17 0ZM27.2378 25.3489C27.2189 25.3489 27.1244 25.5 27.1056 25.5C25.869 26.9783 24.3232 28.1672 22.5771 28.983C20.831 29.7989 18.9273 30.2217 17 30.2217C15.0727 30.2217 13.169 29.7989 11.4229 28.983C9.67682 28.1672 8.13101 26.9783 6.89444 25.5C6.87556 25.5 6.78111 25.3489 6.76222 25.3489C6.6585 25.1984 6.59955 25.0215 6.59222 24.8389C6.59574 24.6407 6.6589 24.4482 6.77347 24.2865C6.88803 24.1247 7.04867 24.0013 7.23444 23.9322C8.63222 23.46 9.97333 23.0067 10.3511 22.9122C10.3423 22.8696 10.3428 22.8256 10.3526 22.7833C10.3624 22.7409 10.3812 22.7011 10.4078 22.6667C10.4573 22.4838 10.5617 22.3206 10.707 22.199C10.8522 22.0774 11.0313 22.0033 11.22 21.9867L13.6189 21.7978C13.5987 21.2816 13.4767 20.7745 13.26 20.3056V20.2867C13.0576 19.7531 12.7706 19.2556 12.41 18.8133C11.4222 17.5247 10.8966 15.9413 10.9178 14.3178C10.8133 12.6482 11.3683 11.0044 12.4633 9.73977C13.5584 8.47517 15.106 7.69087 16.7733 7.55556H17.2267C18.894 7.69087 20.4416 8.47517 21.5367 9.73977C22.6317 11.0044 23.1867 12.6482 23.0822 14.3178C23.1034 15.9413 22.5778 17.5247 21.59 18.8133C21.2294 19.2556 20.9424 19.7531 20.74 20.2867V20.3056C20.5233 20.7745 20.4013 21.2816 20.3811 21.7978L22.78 21.9867C22.9687 22.0033 23.1478 22.0774 23.293 22.199C23.4383 22.3206 23.5427 22.4838 23.5922 22.6667C23.6188 22.7011 23.6376 22.7409 23.6474 22.7833C23.6572 22.8256 23.6577 22.8696 23.6489 22.9122C24.0267 23.0067 25.3678 23.46 26.7656 23.9322C26.904 23.9767 27.0301 24.0531 27.1335 24.1554C27.237 24.2576 27.3148 24.3828 27.3608 24.5208C27.4068 24.6588 27.4197 24.8057 27.3983 24.9496C27.3769 25.0934 27.3219 25.2302 27.2378 25.3489Z"
                                                        fill="#494C4E"
                                                    />
                                                </g>
                                                <defs>
                                                    <clipPath id="clip0_577_4">
                                                        <rect
                                                            width="34"
                                                            height="34"
                                                            fill="white"
                                                        />
                                                    </clipPath>
                                                </defs>
                                            </svg>
                                        )}

                                        <p className="hidden sm:block text-small-d-400 group-hover:text-red-600">
                                            {user}
                                        </p>
                                    </Link>
                                ) : (
                                    <button
                                        onClick={openPopup}
                                        className="flex flex-row items-center justify-center w-[98px] h-[32px] bg-red-600 rounded hover:bg-red-400 text-white-50 text-small-d-400"
                                    >
                                        Sign in
                                    </button>
                                )}
                            </div>
                        </div>
                        {isPopupOpen && (
                            <div
                                className="fixed w-[100vw] h-[100vh] flex items-center justify-center z-50 "
                                style={{ top: 0, left: 0 }}
                            >
                                <div
                                    onClick={closePopup}
                                    className="block fixed bg-black opacity-50 z-40 w-[100vw] h-[100vh]"
                                    style={{ top: 0, left: 0 }}
                                ></div>

                                <div className="p-8 rounded-md min-[596px]:w-[596px] w-full bg-white-50 z-50">
                                    <button
                                        onClick={closePopup}
                                        className="text-gray-600 hover:text-gray-800 relative left-[95%] top-1"
                                    >
                                        <svg
                                            width="14"
                                            height="14"
                                            viewBox="0 0 14 14"
                                            fill="none"
                                            xmlns="http://www.w3.org/2000/svg"
                                        >
                                            <g clipPath="url(#clip0_499_2)">
                                                <path
                                                    d="M14 12.5522V12.7105C13.9393 13.2278 13.6877 13.6205 13.2057 13.8226C13.0493 13.8882 12.8607 13.9201 12.6399 13.9183C12.234 13.9152 11.8954 13.7781 11.6244 13.507C10.7293 12.6125 9.18504 11.0685 6.99152 8.87498C6.99034 8.8738 6.98894 8.87286 6.9874 8.87222C6.98586 8.87158 6.98421 8.87125 6.98255 8.87125C6.9809 8.87125 6.97927 8.87158 6.97776 8.87222C6.97624 8.87286 6.97488 8.8738 6.97375 8.87498C5.45234 10.3971 3.91234 11.9377 2.35375 13.4966C2.25477 13.5954 2.1648 13.6693 2.08387 13.7184C1.89319 13.834 1.68729 13.8978 1.46617 13.9101C1.13613 13.9278 0.869531 13.8956 0.573398 13.7279C0.22668 13.5322 0.0295313 13.1264 0 12.7315V12.5828C0.0273438 12.2405 0.157865 11.9524 0.391562 11.7187C1.96273 10.1477 3.53327 8.57721 5.10316 7.00713C5.10445 7.00586 5.10546 7.00435 5.10616 7.00268C5.10685 7.00101 5.10721 6.99923 5.10721 6.99742C5.10721 6.99562 5.10685 6.99383 5.10616 6.99216C5.10546 6.9905 5.10445 6.98899 5.10316 6.98772C3.53145 5.41472 1.97531 3.85822 0.434766 2.31822C0.297135 2.18059 0.196693 2.01197 0.133438 1.81236C-0.233516 0.652989 1.01145 -0.352988 2.07266 0.267989C2.1587 0.318302 2.25395 0.395502 2.3584 0.499591C3.96329 2.09628 5.50694 3.63109 6.98934 5.104C6.99159 5.10624 6.99464 5.1075 6.99781 5.1075C7.00099 5.1075 7.00404 5.10624 7.00629 5.104C8.50126 3.60903 10.0427 2.06757 11.6307 0.47963C11.7007 0.409812 11.7757 0.35157 11.8557 0.304903C12.2491 0.0755802 12.653 0.0455932 13.0676 0.214942C13.5051 0.393497 13.8146 0.812677 13.8671 1.29338C13.8983 1.57757 13.8398 1.84946 13.6916 2.10904C13.6462 2.1887 13.5671 2.28477 13.4545 2.39725C11.9187 3.93032 10.3938 5.45455 8.87988 6.96994C8.87569 6.97432 8.87578 6.97869 8.88016 6.98307C10.3545 8.45325 11.8618 9.95141 13.402 11.4776C13.5764 11.6506 13.6859 11.7666 13.7304 11.8256C13.8875 12.0342 13.9774 12.2764 14 12.5522Z"
                                                    fill="black"
                                                />
                                            </g>
                                            <defs>
                                                <clipPath id="clip0_499_2">
                                                    <rect
                                                        width="14"
                                                        height="14"
                                                        fill="white"
                                                    />
                                                </clipPath>
                                            </defs>
                                        </svg>
                                    </button>
                                    <div className="flex flex-col items-start justify-center gap-4 p-4">
                                        <div className="flex flex-row items-center justify-center w-full">
                                            <img
                                                src={gemstone}
                                                width={42}
                                                height={42}
                                                title="logo"
                                            ></img>
                                            <p className="font-SonsieOne text-h3-m-400 lg:text-h3-d-400">
                                                Cinnabar
                                            </p>
                                        </div>

                                        <div className="flex flex-row items-center justify-around w-full border-b-[1px] border-white-400">
                                            <button
                                                onClick={() => setactive(1)}
                                                className={`${baseClassesButton} ${
                                                    active === 1
                                                        ? focus
                                                        : notFocus
                                                }`}
                                            >
                                                Sign in
                                            </button>
                                            <button
                                                onClick={() => setactive(2)}
                                                className={`${baseClassesButton} ${
                                                    active === 2
                                                        ? focus
                                                        : notFocus
                                                }`}
                                            >
                                                Register
                                            </button>
                                        </div>
                                        <Suspense fallback={<h1></h1>}>
                                            <LoginManager
                                                active={active}
                                                closePopup={closePopup}
                                            ></LoginManager>
                                            <SignUpManager
                                                active={active}
                                                closePopup={closePopup}
                                            ></SignUpManager>
                                        </Suspense>
                                    </div>
                                </div>
                            </div>
                        )}
                    </Fragment>
                )}
            </div>
        </nav>
    )
}

export default Navbar
