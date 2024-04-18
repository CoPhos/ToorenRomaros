import React, { useState, useEffect } from 'react'
import { Link } from 'react-router-dom'
import ReCAPTCHA from 'react-google-recaptcha'

function LoginContainer({
    active,
    handleSubmit,
    userRef,
    errorRef,
    user,
    setuser,
    password,
    setpassword,
    errorMessage,
    captchaToken,
    submiteEnable,
    setsubmiteEnable,
    onChange,
    recaptchaRef,
    closePopup,
    isLoading,
}) {
    const show = 'flex flex-col items-center justify-start gap-2 w-full'
    const notShow = 'hidden'

    useEffect(() => {
        if (captchaToken) {
            setsubmiteEnable(true)
        }
    }, [captchaToken])

    return (
        <div className={`${active === 2 ? show : notShow}`}>
            <p className="text-white-700 text-small-m-400 lg:text-small-d-400 text-center w-full">
                Welcome back! <br></br> <b>for testing use </b>
                <br></br>
                <b> user:</b>
                john.doe <b>password:</b>tiger <br></br> <b> criticUser:</b>
                sara.wilson
                <b> password:</b>
                tiger
            </p>

            <section className="w-[300px] min-[380px]:w-[344px]">
                <div
                    ref={errorRef}
                    className={
                        errorMessage
                            ? 'flex flex-row items-center justify-center bg-[#e95b5b] max-w-[344px] min-h-6 p-[4px] mb-1'
                            : 'hidden'
                    }
                    aria-live="assertive"
                >
                    <p className="text-white-50 text-center overflow-hidden text-ellipsis line-clamp-3 break-words text-small-m-700 lg:text-small-d-700">
                        {errorMessage}
                    </p>
                </div>

                <form
                    onSubmit={handleSubmit}
                    className="flex flex-col items-start justify-center gap-1 w-full mt-8"
                >
                    <div className="w-full">
                        <label
                            htmlFor="username_login"
                            className="block text-gray-700 text-sm text-small-m-700 lg:text-small-d-700"
                        >
                            Username:
                        </label>
                        <input
                            type="text"
                            id="username_login"
                            name="username_login"
                            ref={userRef}
                            onChange={(e) => setuser(e.target.value)}
                            value={user}
                            className="h-[36px] p-1 border border-gray-300 w-full text-small-m-400 lg:text-small-d-400"
                            required
                        />
                    </div>
                    <div className="w-full">
                        <label
                            htmlFor="password_login"
                            className="block text-gray-700 text-sm text-small-m-700 lg:text-small-d-700"
                        >
                            Password
                        </label>
                        <input
                            type="password"
                            id="password_login"
                            name="password_login"
                            onChange={(e) => setpassword(e.target.value)}
                            value={password}
                            className="h-[36px] p-1 border border-gray-300 w-full text-small-m-400 lg:text-small-d-400"
                            required
                        />
                    </div>
                    <button
                        type="submit"
                        disabled={!submiteEnable || isLoading}
                        className="flex flex-row items-center justify-center mt-2 w-full text-white-50 text-small-m-400 lg:text-small-d-400 rounded bg-[#404040] py-1 h-full hover:cursor-pointer hover:opacity-50"
                    >
                        Sign Up
                    </button>

                    <div className="flex flex-row items-center justify-center w-full">
                        <ReCAPTCHA
                            ref={recaptchaRef}
                            sitekey={process.env.RECAPTCHA_SITE_KEY}
                            onChange={onChange}
                        />
                    </div>
                    <Link
                        to="/forgot-password"
                        className="text-tiny-m-700 lg:text-tiny-d-700 underline hover:cursor-pointer w-full text-center"
                        onClick={() => closePopup()}
                    >
                        Forgot Password?
                    </Link>
                    <div className="flex flex-row items-center justify-start w-full mt-1">
                        <div className="border border-white-600 w-11/12  h-[0.5px]"></div>
                        <p className="mx-1">or</p>
                        <div className="border border-white-600  w-11/12 h-[0.5px]"></div>
                    </div>
                    <a
                        className="flex flex-row items-center gap-2 justify-center border border-white-400 rounded w-full text-center h-[40px]"
                        href="http://localhost:9090/oauth2/authorization/google"
                    >
                        <svg
                            width="24"
                            height="24"
                            viewBox="0 0 24 24"
                            fill="none"
                            xmlns="http://www.w3.org/2000/svg"
                        >
                            <g clipPath="url(#clip0_573_2)">
                                <path
                                    fillRule="evenodd"
                                    clipRule="evenodd"
                                    d="M5.16375 12C5.16375 11.2379 5.29033 10.5072 5.51625 9.82186L1.56184 6.80212C0.791149 8.36692 0.356934 10.1301 0.356934 12C0.356934 13.8683 0.790615 15.6304 1.56024 17.1941L5.51251 14.1685C5.28873 13.4864 5.16375 12.7584 5.16375 12Z"
                                    fill="#FBBC05"
                                />
                                <path
                                    fillRule="evenodd"
                                    clipRule="evenodd"
                                    d="M12.1069 5.0666C13.7625 5.0666 15.258 5.65327 16.433 6.61327L19.8512 3.19993C17.7682 1.3866 15.0978 0.266602 12.1069 0.266602C7.46347 0.266602 3.47274 2.92207 1.56177 6.80207L5.51618 9.8218C6.42734 7.05594 9.02462 5.0666 12.1069 5.0666Z"
                                    fill="#EB4335"
                                />
                                <path
                                    fillRule="evenodd"
                                    clipRule="evenodd"
                                    d="M12.1069 18.9333C9.02462 18.9333 6.42734 16.944 5.51618 14.1781L1.56177 17.1973C3.47274 21.0778 7.46347 23.7333 12.1069 23.7333C14.9728 23.7333 17.7089 22.7157 19.7625 20.809L16.0089 17.9072C14.9498 18.5744 13.6162 18.9333 12.1069 18.9333Z"
                                    fill="#34A853"
                                />
                                <path
                                    fillRule="evenodd"
                                    clipRule="evenodd"
                                    d="M23.3228 11.9999C23.3228 11.3066 23.216 10.5599 23.0558 9.86658H12.1069V14.3999H18.4092C18.0941 15.9455 17.2363 17.1338 16.009 17.9071L19.7626 20.809C21.9198 18.8068 23.3228 15.8244 23.3228 11.9999Z"
                                    fill="#4285F4"
                                />
                            </g>
                            <defs>
                                <clipPath id="clip0_573_2">
                                    <rect width="24" height="24" fill="white" />
                                </clipPath>
                            </defs>
                        </svg>

                        <p className="text-small-d-700">CONTINUE WITH GOOGLE</p>
                    </a>
                </form>
            </section>
        </div>
    )
}

export default LoginContainer
