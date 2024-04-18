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

     const copyToClipboard = (text) => {
         navigator.clipboard.writeText(text)
     }

    useEffect(() => {
        if (captchaToken) {
            setsubmiteEnable(true)
        }
    }, [captchaToken])

    return (
        <div className={`${active === 1 ? show : notShow}`}>
            <div className="flex flex-col items-center justify-center text-white-700 text-small-m-400 lg:text-small-d-400 text-center w-full">
                <p>
                    Welcome back! <br />
                    <b>For testing use:</b>
                    <br />
                </p>
                <p>Common user</p>
                <div className="flex flex-row items-center justify-start gap-1">
                    <b>User:</b> john.doe
                    <div
                        onClick={() => copyToClipboard('john.doe')}
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

                        {/* <p className="text-tag text-white-500 group-hover:text-white-900">
                            Copy
                        </p> */}
                    </div>
                </div>
                <div className="flex flex-row items-center justify-start gap-1">
                    <b>Password:</b> tiger
                    <div
                        onClick={() => copyToClipboard('tiger')}
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

                        {/* <p className="text-tag text-white-500 group-hover:text-white-900">
                            Copy
                        </p> */}
                    </div>
                </div>
                <p>Critic user</p>
                <div className="flex flex-row items-center justify-start gap-1">
                    <b>Critic User:</b> sara.wilson
                    <div
                        onClick={() => copyToClipboard('sara.wilson')}
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

                        {/* <p className="text-tag text-white-500 group-hover:text-white-900">
                            Copy
                        </p> */}
                    </div>
                </div>
                <div className="flex flex-row items-center justify-start gap-1">
                    <b>Password:</b> tiger
                    <div
                        onClick={() => copyToClipboard('tiger')}
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

                        {/* <p className="text-tag text-white-500 group-hover:text-white-900">
                            Copy
                        </p> */}
                    </div>
                </div>
            </div>

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
