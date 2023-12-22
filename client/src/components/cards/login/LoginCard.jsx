import React, { Fragment, useState, useEffect } from 'react'
import {Link} from 'react-router-dom'
import gemstone from '../../../assests/gemstone.png'

function LoginCard({ handleSubmit, handleChange, formData, closePopup }) {
    const [active, setactive] = useState(1)

    const baseClassesButton =
        'text-white-500 text-h3-m-700  lg:text-h3-d-700 border-[none] hover:cursor-pointer py-1 px-1'
    const focus = 'text-white-900 border-b-[1px] border-white-950'
    const notFocus = 'border-[none]'
    const show = 'flex flex-col items-center justify-start gap-2 w-full'
    const notShow = 'hidden'
    return (
        <div
            className="fixed w-[100vw] h-[100vh] flex items-center justify-center z-50 "
            style={{ top: 0, left: 0 }}
        >
            <div
                onClick={closePopup}
                className="block fixed bg-black opacity-50 z-40 w-[100vw] h-[100vh]"
                style={{ top: 0, left: 0 }}
            ></div>

            <div className="p-8 rounded-md w-[596px] bg-white-50 z-50">
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
                                <rect width="14" height="14" fill="white" />
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
                                active === 1 ? focus : notFocus
                            }`}
                        >
                            Register
                        </button>
                        <button
                            onClick={() => setactive(2)}
                            className={`${baseClassesButton} ${
                                active === 2 ? focus : notFocus
                            }`}
                        >
                            Sign in
                        </button>
                    </div>
                    <div className={`${active === 1 ? show : notShow}`}>
                        <p className="text-white-700 text-small-m-400 lg:text-small-d-400 text-center w-full">
                            Get started with a free Cinnabar account to rate,
                            review, and discover top movies, TV shows, posts,
                            and more!
                        </p>

                        <form
                            onSubmit={handleSubmit}
                            className="flex flex-col items-start justify-center gap-1 w-[344px] mt-8"
                        >
                            <div className="w-full">
                                <label
                                    htmlFor="email"
                                    className="block text-gray-700 text-sm text-small-m-700 lg:text-small-d-700"
                                >
                                    Email
                                </label>
                                <input
                                    type="email"
                                    id="email"
                                    name="email"
                                    value={formData.email}
                                    onChange={handleChange}
                                    className="h-[36px] p-1 border border-gray-300 w-full text-small-m-400 lg:text-small-d-400"
                                    required
                                />
                                <p className="text-tiny-m-400 lg:text-tiny-d-400">
                                    placeholder
                                </p>
                            </div>

                            <div className="w-full">
                                <label
                                    htmlFor="username"
                                    className="block text-gray-700 text-sm text-small-m-700 lg:text-small-d-700"
                                >
                                    Username
                                </label>
                                <input
                                    type="text"
                                    id="username"
                                    name="username"
                                    value={formData.username}
                                    onChange={handleChange}
                                    className="h-[36px] p-1 border border-gray-300 w-full text-small-m-400 lg:text-small-d-400"
                                    required
                                />
                                <p className="text-tiny-m-400 lg:text-tiny-d-400">
                                    placeholder
                                </p>
                            </div>

                            <div className="w-full">
                                <label
                                    htmlFor="password"
                                    className="block text-gray-700 text-sm text-small-m-700 lg:text-small-d-700"
                                >
                                    Password
                                </label>
                                <input
                                    type="password"
                                    id="password"
                                    name="password"
                                    value={formData.password}
                                    onChange={handleChange}
                                    className="h-[36px] p-1 border border-gray-300 w-full text-small-m-400 lg:text-small-d-400"
                                    required
                                />
                                <p className="text-tiny-m-400 lg:text-tiny-d-400">
                                    Must be at least 6 characters with 1 number
                                    and special character
                                </p>
                            </div>

                            <button
                                type="submit"
                                className="flex flex-row items-center justify-center mt-2 w-full text-white-50 text-small-m-400 lg:text-small-d-400 rounded bg-[#404040] py-1 h-full hover:cursor-pointer hover:opacity-50"
                            >
                                Register
                            </button>
                        </form>
                    </div>
                    <div className={`${active === 2 ? show : notShow}`}>
                        <p className="text-white-700 text-small-m-400 lg:text-small-d-400 text-center w-full">
                            Welcome back!
                        </p>
                        <form
                            onSubmit={handleSubmit}
                            className="flex flex-col items-start justify-center gap-1 w-[344px] mt-8"
                        >
                            <div className="w-full">
                                <label
                                    htmlFor="usernameSignin"
                                    className="block text-gray-700 text-sm text-small-m-700 lg:text-small-d-700"
                                >
                                    Username
                                </label>
                                <input
                                    type="text"
                                    id="usernameSignin"
                                    name="username"
                                    value={formData.username}
                                    onChange={handleChange}
                                    className="h-[36px] p-1 border border-gray-300 w-full text-small-m-400 lg:text-small-d-400"
                                    required
                                />
                                <p className="text-tiny-m-400 lg:text-tiny-d-400">
                                    placeholder
                                </p>
                            </div>

                            <div className="w-full">
                                <label
                                    htmlFor="passwordSignin"
                                    className="block text-gray-700 text-sm text-small-m-700 lg:text-small-d-700"
                                >
                                    Password
                                </label>
                                <input
                                    type="password"
                                    id="passwordSignin"
                                    name="password"
                                    value={formData.password}
                                    onChange={handleChange}
                                    className="h-[36px] p-1 border border-gray-300 w-full text-small-m-400 lg:text-small-d-400"
                                    required
                                />
                            </div>

                            <button
                                type="submit"
                                className="flex flex-row items-center justify-center mt-2 w-full text-white-50 text-small-m-400 lg:text-small-d-400 rounded bg-[#404040] py-1 h-full hover:cursor-pointer hover:opacity-50"
                            >
                                Sign Up
                            </button>
                            <Link
                                to="/forgotpassword"
                                className="text-tiny-m-700 lg:text-tiny-d-700 underline hover:cursor-pointer w-full text-center"
                            >
                                Forgot Password?
                            </Link>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    )
}

export default LoginCard
