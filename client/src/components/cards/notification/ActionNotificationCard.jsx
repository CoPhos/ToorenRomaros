import React, { Fragment, useEffect } from 'react'

function ActionNotificationCard({
    text,
    isNotificationPopupOpen,
    setnotificationText,
    setisNotificationPopupOpen,
    type,
    settype,
}) {
    useEffect(() => {
        const timeoutId = setTimeout(() => {
            setisNotificationPopupOpen(false)
            setnotificationText('')
            settype('')
        }, 3000)

        return () => clearTimeout(timeoutId)
    }, [isNotificationPopupOpen])
    return (
        <Fragment>
            {isNotificationPopupOpen && (
                <div className="flex flex-row items-center justify-end sticky bottom-1 w-full z-50">
                    {
                        <Card
                            text={text}
                            type={type}
                            setisNotificationPopupOpen={
                                setisNotificationPopupOpen
                            }
                            setnotificationText={setnotificationText}
                            settype={settype}
                        ></Card>
                    }
                </div>
            )}
        </Fragment>
    )
}

function Card({
    text,
    type,
    setisNotificationPopupOpen,
    setnotificationText,
    settype,
}) {
    let color
    let icon

    switch (type) {
        case 'success':
            color = 'bg-[#edf7ed] text-[#1e4620]'
            icon = (
                <svg
                    width="24"
                    height="24"
                    viewBox="0 0 24 24"
                    fill="none"
                    xmlns="http://www.w3.org/2000/svg"
                >
                    <path
                        fill-rule="evenodd"
                        clip-rule="evenodd"
                        d="M22 12C22 17.5228 17.5228 22 12 22C6.47715 22 2 17.5228 2 12C2 6.47715 6.47715 2 12 2C17.5228 2 22 6.47715 22 12ZM16.0303 8.96967C16.3232 9.26256 16.3232 9.73744 16.0303 10.0303L11.0303 15.0303C10.7374 15.3232 10.2626 15.3232 9.96967 15.0303L7.96967 13.0303C7.67678 12.7374 7.67678 12.2626 7.96967 11.9697C8.26256 11.6768 8.73744 11.6768 9.03033 11.9697L10.5 13.4393L12.7348 11.2045L14.9697 8.96967C15.2626 8.67678 15.7374 8.67678 16.0303 8.96967Z"
                        fill="#2E7D32"
                    />
                </svg>
            )

            break
        case 'error':
            color = 'bg-[#fdeded] text-[#5f2120]'
            icon = (
                <svg
                    width="24"
                    height="24"
                    viewBox="0 0 24 24"
                    fill="none"
                    xmlns="http://www.w3.org/2000/svg"
                >
                    <path
                        fill-rule="evenodd"
                        clip-rule="evenodd"
                        d="M12 2C17.522 2 22 6.478 22 12C22 17.522 17.522 22 12 22C6.478 22 2 17.522 2 12C2 6.478 6.478 2 12 2ZM14.293 8.293L12 10.586L9.707 8.293L8.293 9.707L10.586 12L8.293 14.293L9.707 15.707L12 13.414L14.293 15.707L15.707 14.293L13.414 12L15.707 9.707L14.293 8.293Z"
                        fill="#D32F2F"
                    />
                </svg>
            )

            break
        default:
            color = 'bg-[#e5f6fd] text-[#014361]'
            icon = (
                <svg
                    width="24"
                    height="24"
                    viewBox="0 0 24 24"
                    fill="none"
                    xmlns="http://www.w3.org/2000/svg"
                >
                    <g clip-path="url(#clip0_563_10)">
                        <path
                            d="M11.9996 0.000488281C5.37309 0.000488281 0 5.37321 0 12.0001C0 18.627 5.37309 23.9997 11.9996 23.9997C18.6277 23.9997 24 18.6271 24 12.0001C24 5.37316 18.6277 0.000488281 11.9996 0.000488281ZM14.1067 17.5092C13.6213 18.0479 13.3431 18.3681 12.8191 18.8689C12.0261 19.6272 11.1256 19.8291 10.4256 19.0806C9.4193 18.0044 10.4747 14.7304 10.5004 14.6065C10.6894 13.7363 11.0667 11.9971 11.0667 11.9971C11.0667 11.9971 10.2517 12.496 9.76781 12.673C9.41095 12.8034 9.00727 12.6321 8.90747 12.287C8.81447 11.9672 8.88853 11.7638 9.08438 11.5453C9.56972 11.007 9.84792 10.6869 10.3719 10.186C11.1657 9.42733 12.0654 9.22586 12.7655 9.97394C13.7717 11.0501 13.0293 12.8208 12.7685 14.0754C12.7428 14.1997 12.1243 17.0579 12.1243 17.0579C12.1243 17.0579 12.9393 16.5589 13.4232 16.3816C13.7807 16.2516 14.1845 16.4232 14.2843 16.768C14.3773 17.0878 14.3025 17.2911 14.1067 17.5092ZM12.8048 8.25588C11.6851 8.35413 10.6985 7.52632 10.6002 6.40586C10.5027 5.28658 11.3305 4.29958 12.4502 4.20208C13.5691 4.10378 14.5565 4.9324 14.6541 6.05168C14.7523 7.171 13.9237 8.15838 12.8048 8.25588Z"
                            fill="#0288D1"
                        />
                    </g>
                    <defs>
                        <clipPath id="clip0_563_10">
                            <rect width="24" height="24" fill="white" />
                        </clipPath>
                    </defs>
                </svg>
            )

            break
    }
    return (
        <div
            className={`max-w-[385px] w-fit py-[12px] shadow-md hover:shodow-lg rounded-2xl px-[24px] mr-2 ${color}`}
        >
            <div class="flex flex-col p-8 items-start justify-center ">
                <div class="flex flex-row items-center justify-between gap-2">
                    {icon}
                    <p className="text-small-d-400 text-gray-600 max-w-[290px]">
                        {text}
                    </p>
                    <button
                        className="text-gray-600 hover:text-gray-800"
                        onClick={() => {
                            setnotificationText('')
                            setisNotificationPopupOpen(false)
                            settype('')
                        }}
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
                </div>
            </div>
        </div>
    )
}

export default ActionNotificationCard
