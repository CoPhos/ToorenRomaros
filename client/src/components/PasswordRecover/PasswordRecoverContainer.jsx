import React, { Fragment } from 'react'

function PasswordRecoverContainer({
    email,
    handleOnChange,
    handleOnSumbit,
    validEmail,
    emailsended,
}) {
    return (
        <div className="flex flex-col items-start justify-start gap-2 p-8 rounded-md min-[596px]:w-[596px] w-full bg-white-50 mx-auto mt-6">
            {emailsended ? (
                <Fragment>
                    <p className="text-h3-m-700 lg:text-h3-d-700">
                        An email has been sent to the provided address with
                        instructions on how to reset your password. Please check
                        your inbox, and if you don't see the email, be sure to
                        check your spam or junk folder. If you encounter any
                        issues, feel free to contact our support team for
                        assistance.
                    </p>
                </Fragment>
            ) : (
                <Fragment>
                    <p className="text-h2-m-700 lg:text-h2-d-700">
                        Forgot Your Password?
                    </p>
                    <p>
                        We will send you an email with instructions on how to
                        reset your password.
                    </p>
                    <form
                        onSubmit={handleOnSumbit}
                        className="flex flex-col items-start justify-start gap-1 w-full"
                    >
                        <div className="w-full">
                            <label
                                htmlFor="email"
                                className="block text-gray-700 text-sm text-small-m-700 lg:text-small-d-700"
                            >
                                Password
                            </label>
                            <input
                                type="email"
                                id="email"
                                name="email"
                                onChange={(event) => handleOnChange(event)}
                                value={email}
                                className="h-[36px] p-1 border border-gray-300 w-full text-small-m-400 lg:text-small-d-400"
                                required
                            />
                            <p
                                className={
                                    !validEmail
                                        ? 'flex items-center justify-start gap-1 text-tiny-m-400 lg:text-tiny-d-400 mt-[4px]'
                                        : 'hidden'
                                }
                            >
                                <svg
                                    width="16"
                                    height="16"
                                    viewBox="0 0 16 16"
                                    fill="none"
                                    xmlns="http://www.w3.org/2000/svg"
                                >
                                    <g clipPath="url(#clip0_528_2)">
                                        <path
                                            d="M7.85313 0H8.15125C9.46542 0.0308333 10.6797 0.349583 11.7941 0.95625C12.7291 1.46542 13.5222 2.1175 14.1734 2.9125C15.3389 4.335 15.9477 5.98198 16 7.85344V8.15125C15.9727 9.34417 15.706 10.4569 15.2 11.4894C14.7346 12.4385 14.124 13.2523 13.3681 13.9306C11.8983 15.2496 10.1581 15.9394 8.1475 16H7.84844C6.65448 15.9727 5.54177 15.706 4.51031 15.2C3.56115 14.7346 2.7475 14.1241 2.06938 13.3684C0.750625 11.8986 0.0608333 10.1586 0 8.14844V7.84781C0.0610417 5.84719 0.745729 4.11396 2.05406 2.64812C2.7351 1.885 3.55375 1.26896 4.51 0.8C5.54313 0.293333 6.6575 0.0266667 7.85313 0ZM9.93188 4.22156C9.93188 4.07165 9.90025 3.92321 9.83879 3.78471C9.77734 3.6462 9.68727 3.52036 9.57372 3.41436C9.46017 3.30835 9.32537 3.22427 9.17701 3.1669C9.02865 3.10953 8.86964 3.08 8.70906 3.08C8.38475 3.08 8.07373 3.20027 7.8444 3.41436C7.61508 3.62844 7.48625 3.9188 7.48625 4.22156C7.48625 4.52432 7.61508 4.81468 7.8444 5.02877C8.07373 5.24285 8.38475 5.36312 8.70906 5.36312C8.86964 5.36312 9.02865 5.3336 9.17701 5.27623C9.32537 5.21886 9.46017 5.13477 9.57372 5.02877C9.68727 4.92277 9.77734 4.79692 9.83879 4.65842C9.90025 4.51992 9.93188 4.37147 9.93188 4.22156ZM7.05344 12.7638C7.19385 12.819 7.33937 12.8554 7.49 12.8731C7.80833 12.9106 8.10687 12.9016 8.38562 12.8459C8.54583 12.8139 8.74198 12.752 8.97406 12.6603C9.1901 12.5751 9.41458 12.4906 9.6475 12.4069C9.65269 12.4051 9.65735 12.402 9.66106 12.3979C9.66477 12.3938 9.66741 12.3888 9.66875 12.3834L9.7975 11.8597C9.80146 11.8436 9.79573 11.8384 9.78031 11.8441C9.67156 11.8836 9.56323 11.9195 9.45531 11.9516C9.19615 12.0286 8.93792 12.0382 8.68062 11.9803C8.50521 11.9407 8.39531 11.8409 8.35094 11.6809C8.28625 11.4481 8.31969 11.1797 8.37031 10.9453C8.51844 10.2594 8.72625 9.57906 8.91875 8.91562C8.98271 8.69458 9.0301 8.49594 9.06094 8.31969C9.10052 8.09302 9.11833 7.87583 9.11438 7.66813C9.10625 7.22583 8.9249 6.88708 8.57031 6.65188C8.26875 6.45188 7.87437 6.39594 7.51062 6.4025C7.24542 6.40729 6.95385 6.4624 6.63594 6.56781C6.30865 6.67615 6.01052 6.78552 5.74156 6.89594C5.73302 6.89948 5.72771 6.90573 5.72563 6.91469L5.59937 7.43844C5.59542 7.4551 5.60146 7.46052 5.6175 7.45469C5.71896 7.41823 5.82 7.38438 5.92063 7.35313C6.18979 7.26958 6.45562 7.25885 6.71812 7.32094C6.87333 7.3576 6.97229 7.45062 7.015 7.6C7.08312 7.83656 7.05469 8.11125 7.00313 8.35219C6.95917 8.5576 6.91469 8.74115 6.86969 8.90281C6.71844 9.44698 6.56479 9.99188 6.40875 10.5375C6.36719 10.6831 6.34156 10.8338 6.31156 10.9838C6.26938 11.1975 6.24844 11.4406 6.25406 11.6544C6.26365 11.9983 6.39583 12.2854 6.65063 12.5156C6.76813 12.6217 6.9024 12.7044 7.05344 12.7638Z"
                                            fill="#030104"
                                        />
                                    </g>
                                    <defs>
                                        <clipPath id="clip0_528_2">
                                            <rect
                                                width="16"
                                                height="16"
                                                fill="white"
                                            />
                                        </clipPath>
                                    </defs>
                                </svg>
                                Invalid E-mail
                            </p>
                        </div>
                        <button
                            type="submit"
                            className="flex flex-row items-center justify-center mt-2 w-full text-white-50 text-small-m-400 lg:text-small-d-400 rounded bg-[#404040] py-1 h-full hover:cursor-pointer hover:opacity-50"
                        >
                            Send Email
                        </button>
                    </form>
                </Fragment>
            )}
        </div>
    )
}

export default PasswordRecoverContainer