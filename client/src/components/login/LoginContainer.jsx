import React from 'react'
import { Link } from 'react-router-dom'

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
}) {
    const show = 'flex flex-col items-center justify-start gap-2 w-full'
    const notShow = 'hidden'

    return (
        <div className={`${active === 2 ? show : notShow}`}>
            <p className="text-white-700 text-small-m-400 lg:text-small-d-400 text-center w-full">
                Welcome back!
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
                        className="flex flex-row items-center justify-center mt-2 w-full text-white-50 text-small-m-400 lg:text-small-d-400 rounded bg-[#404040] py-1 h-full hover:cursor-pointer hover:opacity-50"
                    >
                        Sign Up
                    </button>
                    <Link
                        to="/forgotpassword"
                        //   Close panel onClick
                        className="text-tiny-m-700 lg:text-tiny-d-700 underline hover:cursor-pointer w-full text-center"
                    >
                        Forgot Password?
                    </Link>
                </form>
            </section>
        </div>
    )
}

export default LoginContainer