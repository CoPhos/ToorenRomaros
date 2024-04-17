import React from 'react'
import { Link } from 'react-router-dom'

function MobileNavMenu({ fillColor, to }) {
    return (
        <div className="border-t border-white-300 flex flex-row items-center justify-around py-1 sticky bottom-[0px] z-10 lg:hidden bg-white-50">
            <Link
                to="/"
                className="flex flex-col items-center justify-center w-5 gap-1"
            >
                <svg
                    width="32"
                    height="31"
                    viewBox="0 0 32 31"
                    fill="none"
                    xmlns="http://www.w3.org/2000/svg"
                >
                    <path
                        d="M32 14.9131V15.0813C31.9144 15.745 31.3088 16.1438 30.6744 15.9425C30.5235 15.895 30.3354 15.7569 30.11 15.5281C29.9242 15.3398 29.7387 15.1511 29.5537 14.9619C29.5179 14.9248 29.5 14.9321 29.5 14.9838C29.4983 19.0313 29.4996 23.0492 29.5037 27.0375C29.5046 27.6138 29.4794 28.0215 29.4281 28.2606C29.1444 29.58 27.9306 30.5 26.5938 30.5C19.7346 30.5 12.8752 30.5 6.01562 30.5C5.39854 30.5 4.98312 30.4775 4.76937 30.4325C3.715 30.2119 2.87313 29.3925 2.59125 28.34C2.5275 28.1013 2.49604 27.714 2.49688 27.1781C2.50104 23.1561 2.50167 19.0902 2.49875 14.9806C2.49875 14.9323 2.48208 14.9254 2.44875 14.96C2.22375 15.1913 1.98875 15.4269 1.74375 15.6669C1.5025 15.9036 1.24937 16.0146 0.984375 16C0.420625 15.9688 0.0925 15.6606 0 15.0756V14.9044C0.03375 14.6569 0.11 14.4738 0.22875 14.355C4.27708 10.3067 8.32542 6.25856 12.3737 2.21064C12.7842 1.80023 13.0919 1.52023 13.2969 1.37064C14.8687 0.225017 17.0075 0.220017 18.6256 1.31689C18.8469 1.46689 19.1546 1.73877 19.5487 2.13252C23.6362 6.21793 27.7104 10.2919 31.7712 14.3544C31.8925 14.4752 31.9688 14.6615 32 14.9131ZM19.1513 17.7738C20.2863 18.3 20.9987 19.3894 20.9994 20.6438C21.0002 23.2558 21.0002 25.8523 20.9994 28.4331C20.9994 28.4512 21.0066 28.4685 21.0193 28.4813C21.0321 28.4941 21.0494 28.5013 21.0675 28.5013C22.7642 28.4975 24.5567 28.4986 26.445 28.5044C26.8862 28.5056 27.2237 28.3919 27.4219 27.9819C27.4756 27.8702 27.5023 27.6752 27.5019 27.3969C27.5006 22.8452 27.4998 18.035 27.4994 12.9663C27.4994 12.9288 27.4862 12.8969 27.46 12.8706C24.2704 9.68106 21.0819 6.49273 17.8944 3.30564C16.845 2.25627 15.1944 2.21877 14.1294 3.28377C10.8744 6.53835 7.67271 9.74002 4.52437 12.8888C4.50396 12.9088 4.49375 12.9331 4.49375 12.9619C4.50375 17.7181 4.50458 22.5646 4.49625 27.5013C4.495 27.9175 4.64 28.2475 5.03375 28.4281C5.14667 28.4798 5.36521 28.5052 5.68937 28.5044C7.43187 28.4986 9.18458 28.4975 10.9475 28.5013C10.9609 28.5013 10.9738 28.4959 10.9833 28.4864C10.9928 28.4769 10.9981 28.4641 10.9981 28.4506C11.0035 25.9877 11.0021 23.5804 10.9937 21.2288C10.9917 20.65 11.0158 20.2365 11.0662 19.9881C11.3581 18.5531 12.6594 17.5 14.11 17.5013C15.9104 17.5033 17.181 17.5065 17.9219 17.5106C18.3698 17.5136 18.7796 17.6013 19.1513 17.7738ZM13.0656 28.5006H18.9344C18.9528 28.5006 18.9704 28.4933 18.9834 28.4803C18.9964 28.4673 19.0037 28.4497 19.0037 28.4313V20.7206C19.0037 20.5594 18.9733 20.3998 18.914 20.2509C18.8548 20.102 18.768 19.9667 18.6585 19.8527C18.549 19.7387 18.4191 19.6483 18.2761 19.5866C18.1331 19.5249 17.9798 19.4931 17.825 19.4931H14.175C14.0202 19.4931 13.8669 19.5249 13.7239 19.5866C13.5809 19.6483 13.451 19.7387 13.3415 19.8527C13.232 19.9667 13.1452 20.102 13.086 20.2509C13.0267 20.3998 12.9963 20.5594 12.9963 20.7206V28.4313C12.9963 28.4497 13.0036 28.4673 13.0166 28.4803C13.0296 28.4933 13.0472 28.5006 13.0656 28.5006Z"
                        fill="#000000"
                        className={`${
                            fillColor == 'home'
                                ? 'fill-red-600'
                                : 'fill-white-950'
                        }`}
                    />
                </svg>

                <p
                    className={`text-tiny-d-400 ${
                        fillColor == 'home' ? 'text-red-600' : 'fill-white-950'
                    }`}
                >
                    Home
                </p>
            </Link>

            <Link
                to="/browse?at=theaters"
                className="flex flex-col items-center justify-center w-5 gap-1"
            >
                <svg
                    width="31"
                    height="27"
                    viewBox="0 0 31 27"
                    fill="none"
                    xmlns="http://www.w3.org/2000/svg"
                >
                    <path
                        d="M30.25 23.8781C30.25 24.5735 29.9738 25.2404 29.4821 25.7321C28.9904 26.2238 28.3235 26.5 27.6281 26.5H2.87188C2.17651 26.5 1.50963 26.2238 1.01793 25.7321C0.526232 25.2404 0.25 24.5735 0.25 23.8781V3.12187C0.25 2.42651 0.526232 1.75963 1.01793 1.26793C1.50963 0.776232 2.17651 0.5 2.87188 0.5H27.6281C28.3235 0.5 28.9904 0.776232 29.4821 1.26793C29.9738 1.75963 30.25 2.42651 30.25 3.12187V23.8781ZM3.53875 6.47375L4.85125 2.53438C4.85917 2.51146 4.85104 2.5 4.82688 2.5C4.21146 2.49958 3.58021 2.5 2.93313 2.50125C2.46187 2.50187 2.24687 2.78625 2.2475 3.22C2.24917 4.34458 2.25021 5.42333 2.25062 6.45625C2.25062 6.46785 2.2553 6.47898 2.26362 6.48719C2.27194 6.49539 2.28323 6.5 2.295 6.5H3.5025C3.51054 6.5 3.51837 6.49747 3.52488 6.49275C3.53139 6.48804 3.53625 6.48139 3.53875 6.47375ZM9.85437 2.52688C9.85537 2.52376 9.8556 2.52045 9.85506 2.51722C9.85452 2.51399 9.85322 2.51093 9.85127 2.50831C9.84931 2.50568 9.84676 2.50356 9.84382 2.50211C9.84089 2.50067 9.83765 2.49995 9.83438 2.5H6.985C6.98056 2.49993 6.97622 2.50128 6.97262 2.50387C6.96902 2.50646 6.96634 2.51015 6.965 2.51438L5.64563 6.47313C5.64463 6.47624 5.6444 6.47956 5.64494 6.48278C5.64548 6.48601 5.64678 6.48907 5.64873 6.49169C5.65069 6.49432 5.65324 6.49644 5.65618 6.49788C5.65911 6.49933 5.66235 6.50005 5.66563 6.5H8.515C8.51944 6.50007 8.52378 6.49871 8.52738 6.49613C8.53098 6.49354 8.53366 6.48985 8.535 6.48563L9.85437 2.52688ZM14.8544 2.52688C14.8554 2.52376 14.8556 2.52045 14.8551 2.51722C14.8545 2.51399 14.8532 2.51093 14.8513 2.50831C14.8493 2.50568 14.8468 2.50356 14.8438 2.50211C14.8409 2.50067 14.8376 2.49995 14.8344 2.5H11.985C11.9806 2.49993 11.9762 2.50128 11.9726 2.50387C11.969 2.50646 11.9663 2.51015 11.965 2.51438L10.6456 6.47313C10.6446 6.47624 10.6444 6.47956 10.6449 6.48278C10.6455 6.48601 10.6468 6.48907 10.6487 6.49169C10.6507 6.49432 10.6532 6.49644 10.6562 6.49788C10.6591 6.49933 10.6624 6.50005 10.6656 6.5H13.515C13.5194 6.50007 13.5238 6.49871 13.5274 6.49613C13.531 6.49354 13.5337 6.48985 13.535 6.48563L14.8544 2.52688ZM19.8544 2.52688C19.8554 2.52376 19.8556 2.52045 19.8551 2.51722C19.8545 2.51399 19.8532 2.51093 19.8513 2.50831C19.8493 2.50568 19.8468 2.50356 19.8438 2.50211C19.8409 2.50067 19.8376 2.49995 19.8344 2.5H16.985C16.9806 2.49993 16.9762 2.50128 16.9726 2.50387C16.969 2.50646 16.9663 2.51015 16.965 2.51438L15.6456 6.47313C15.6446 6.47624 15.6444 6.47956 15.6449 6.48278C15.6455 6.48601 15.6468 6.48907 15.6487 6.49169C15.6507 6.49432 15.6532 6.49644 15.6562 6.49788C15.6591 6.49933 15.6624 6.50005 15.6656 6.5H18.515C18.5194 6.50007 18.5238 6.49871 18.5274 6.49613C18.531 6.49354 18.5337 6.48985 18.535 6.48563L19.8544 2.52688ZM24.8544 2.52688C24.8554 2.52376 24.8556 2.52045 24.8551 2.51722C24.8545 2.51399 24.8532 2.51093 24.8513 2.50831C24.8493 2.50568 24.8468 2.50356 24.8438 2.50211C24.8409 2.50067 24.8376 2.49995 24.8344 2.5H21.985C21.9806 2.49993 21.9762 2.50128 21.9726 2.50387C21.969 2.50646 21.9663 2.51015 21.965 2.51438L20.6456 6.47313C20.6446 6.47624 20.6444 6.47956 20.6449 6.48278C20.6455 6.48601 20.6468 6.48907 20.6487 6.49169C20.6507 6.49432 20.6532 6.49644 20.6562 6.49788C20.6591 6.49933 20.6624 6.50005 20.6656 6.5H23.515C23.5194 6.50007 23.5238 6.49871 23.5274 6.49613C23.531 6.49354 23.5337 6.48985 23.535 6.48563L24.8544 2.52688ZM25.645 6.47437C25.644 6.47732 25.6437 6.48047 25.6442 6.48355C25.6447 6.48663 25.6459 6.48956 25.6477 6.49207C25.6495 6.49459 25.652 6.49662 25.6548 6.498C25.6575 6.49938 25.6606 6.50007 25.6637 6.5H28.2025C28.2154 6.5 28.2278 6.49486 28.237 6.48572C28.2461 6.47658 28.2512 6.46418 28.2512 6.45125C28.2483 5.43042 28.2496 4.36875 28.255 3.26625C28.2562 2.955 28.1844 2.6925 27.8931 2.56063C27.6481 2.45 27.2875 2.51125 27.01 2.4975C26.9842 2.49625 26.9673 2.50771 26.9594 2.53188L25.645 6.47437ZM27.6056 24.5C27.9688 24.5 28.25 24.2356 28.25 23.8675C28.25 18.6983 28.25 13.5979 28.25 8.56625C28.25 8.54868 28.243 8.53183 28.2306 8.5194C28.2182 8.50698 28.2013 8.5 28.1838 8.5H2.28187C2.27342 8.5 2.26531 8.50329 2.25934 8.50915C2.25336 8.51501 2.25 8.52296 2.25 8.53125C2.25 13.5571 2.25 18.6654 2.25 23.8563C2.25 24.2125 2.51125 24.5 2.875 24.5C11.1883 24.4996 19.4319 24.4996 27.6056 24.5Z"
                        fill="black"
                        className={`${
                            fillColor == 'browse'
                                ? 'fill-red-600'
                                : 'fill-white-950'
                        }`}
                    />
                    <path
                        d="M12.5319 11.6506L19.0212 15.6431C19.1676 15.7331 19.2884 15.859 19.3722 16.0089C19.4561 16.1588 19.5001 16.3277 19.5001 16.4994C19.5001 16.6711 19.4561 16.84 19.3722 16.9899C19.2884 17.1398 19.1676 17.2657 19.0212 17.3556L12.5319 21.3481C12.3796 21.4419 12.2051 21.4933 12.0263 21.4971C11.8476 21.5009 11.671 21.4569 11.5149 21.3697C11.3588 21.2825 11.2288 21.1553 11.1383 21.0011C11.0478 20.8469 11 20.6713 11 20.4925V12.5063C11 12.3275 11.0478 12.1519 11.1383 11.9977C11.2288 11.8435 11.3588 11.7162 11.5149 11.6291C11.671 11.5419 11.8476 11.4979 12.0263 11.5017C12.2051 11.5055 12.3796 11.5569 12.5319 11.6506ZM13.0281 14.3056C13.0253 14.304 13.0221 14.3032 13.0189 14.3031C13.0157 14.3031 13.0125 14.3039 13.0096 14.3055C13.0068 14.3071 13.0044 14.3093 13.0027 14.3121C13.001 14.3149 13.0001 14.318 13 14.3213V18.6788C13.0001 18.682 13.001 18.6852 13.0027 18.6879C13.0044 18.6907 13.0068 18.693 13.0096 18.6946C13.0125 18.6961 13.0157 18.6969 13.0189 18.6969C13.0221 18.6969 13.0253 18.696 13.0281 18.6944L16.5669 16.5163C16.5697 16.5146 16.5721 16.5123 16.5738 16.5094C16.5754 16.5066 16.5763 16.5033 16.5763 16.5C16.5763 16.4967 16.5754 16.4935 16.5738 16.4906C16.5721 16.4878 16.5697 16.4854 16.5669 16.4838L13.0281 14.3056Z"
                        fill="black"
                        className={`${
                            fillColor == 'browse'
                                ? 'fill-red-600'
                                : 'fill-white-950'
                        }`}
                    />
                </svg>

                <p
                    className={`text-tiny-d-400 ${
                        fillColor == 'browse'
                            ? 'text-red-600'
                            : 'fill-white-950'
                    }`}
                >
                    Films
                </p>
            </Link>

            {/* <Link
                to="/blog"
                className="flex flex-col items-center justify-center w-5 gap-1"
            >
                <svg
                    width="33"
                    height="29"
                    viewBox="0 0 33 29"
                    fill="none"
                    xmlns="http://www.w3.org/2000/svg"
                >
                    <path
                        d="M 32.5 5.3775 V 25.1475 C 32.4275 26.1617 32.0425 26.9923 31.345 27.6394 C 30.6531 28.2813 29.7862 28.6175 28.8394 28.6175 C 20.8719 28.6175 12.6675 28.6175 4.2263 28.6175 C 3.1662 28.6175 2.2821 28.2673 1.5737 27.5669 C 0.9146 26.9152 0.5567 26.1058 0.5 25.1388 V 1.7475 C 0.5354 1.3683 0.6787 1.0542 0.93 0.805 C 1.2129 0.525 1.566 0.3848 1.9894 0.3844 C 10.5206 0.381 18.9898 0.3808 27.3969 0.3838 C 28.2437 0.3838 28.8731 1.0219 28.8775 1.8831 C 28.8808 2.541 28.881 3.2342 28.8781 3.9625 C 28.8781 3.9729 28.8822 3.983 28.8895 3.9903 C 28.8967 3.9977 28.9066 4.0019 28.9169 4.0019 C 29.5465 4.0006 30.2408 4.0004 31 4.0013 C 31.7994 4.0019 32.4263 4.5569 32.5 5.3775 Z M 29.9544 25.0194 C 29.9406 25.4019 29.6438 25.7013 29.2563 25.7125 C 28.4531 25.735 27.7556 25.1906 27.5163 24.4394 C 27.4587 24.2585 27.4302 23.9325 27.4306 23.4613 C 27.434 16.255 27.4342 9.0569 27.4312 1.8669 C 27.4312 1.8419 27.4187 1.8294 27.3937 1.8294 H 1.9688 C 1.9554 1.8294 1.9487 1.836 1.9487 1.8494 C 1.9483 9.5615 1.9485 17.2604 1.9494 24.9463 C 1.9494 26.2013 2.9094 27.1681 4.1875 27.1681 C 12.3958 27.1702 20.6042 27.1702 28.8125 27.1681 C 29.8412 27.1681 30.6856 26.55 30.9719 25.5619 C 31.0277 25.3694 31.0554 25.0144 31.055 24.4969 C 31.0525 18.0881 31.0508 11.746 31.05 5.4706 C 31.05 5.4657 31.048 5.4609 31.0445 5.4574 C 31.041 5.4539 31.0362 5.4519 31.0312 5.4519 H 28.9031 C 28.8968 5.4519 28.8908 5.4543 28.8863 5.4586 C 28.8819 5.463 28.8794 5.4689 28.8794 5.475 C 28.8794 11.6183 28.8794 17.7621 28.8794 23.9063 C 28.8794 24.0192 28.9281 24.1152 29.0256 24.1944 C 29.1169 24.2681 29.26 24.2794 29.3738 24.2963 C 29.7263 24.3475 29.9662 24.6906 29.9544 25.0194 Z M 23.81 4.7275 H 5.5688 C 5.1732 4.7275 4.8525 5.0482 4.8525 5.4438 V 5.4563 C 4.8525 5.8519 5.1732 6.1725 5.5688 6.1725 H 23.81 C 24.2056 6.1725 24.5263 5.8519 24.5263 5.4563 V 5.4438 C 24.5263 5.0482 24.2056 4.7275 23.81 4.7275 Z M 13.605 16.3506 C 13.605 16.5512 13.5254 16.7435 13.3835 16.8854 C 13.2417 17.0272 13.0493 17.1069 12.8488 17.1069 H 5.5988 C 5.3982 17.1069 5.2058 17.0272 5.064 16.8854 C 4.9222 16.7435 4.8425 16.5512 4.8425 16.3506 V 9.1006 C 4.8425 9.0013 4.8621 8.903 4.9001 8.8112 C 4.9381 8.7195 4.9938 8.6361 5.064 8.5659 C 5.1342 8.4956 5.2176 8.4399 5.3094 8.4019 C 5.4011 8.3639 5.4995 8.3444 5.5988 8.3444 H 12.8488 C 12.9481 8.3444 13.0464 8.3639 13.1382 8.4019 C 13.2299 8.4399 13.3133 8.4956 13.3835 8.5659 C 13.4538 8.6361 13.5095 8.7195 13.5475 8.8112 C 13.5855 8.903 13.605 9.0013 13.605 9.1006 V 16.3506 Z M 12.1563 9.83 C 12.1563 9.821 12.1527 9.8125 12.1464 9.8061 C 12.1401 9.7998 12.1315 9.7962 12.1225 9.7962 H 6.3263 C 6.3173 9.7962 6.3087 9.7998 6.3024 9.8061 C 6.2961 9.8125 6.2925 9.821 6.2925 9.83 V 15.6237 C 6.2925 15.6327 6.2961 15.6413 6.3024 15.6476 C 6.3087 15.6539 6.3173 15.6575 6.3263 15.6575 H 12.1225 C 12.1315 15.6575 12.1401 15.6539 12.1464 15.6476 C 12.1527 15.6413 12.1563 15.6327 12.1563 15.6237 V 9.83 Z M 23.8112 8.3393 L 16.4987 8.352 C 16.1059 8.3527 15.788 8.6717 15.7887 9.0645 L 15.7888 9.0908 C 15.7894 9.4836 16.1084 9.8015 16.5013 9.8008 L 23.8137 9.788 C 24.2066 9.7873 24.5244 9.4683 24.5237 9.0755 L 24.5237 9.0493 C 24.523 8.6565 24.204 8.3386 23.8112 8.3393 Z M 23.8156 11.9688 H 16.4969 C 16.1051 11.9688 15.7875 12.2863 15.7875 12.6781 V 12.7044 C 15.7875 13.0962 16.1051 13.4137 16.4969 13.4137 H 23.8156 C 24.2074 13.4137 24.525 13.0962 24.525 12.7044 V 12.6781 C 24.525 12.2863 24.2074 11.9688 23.8156 11.9688 Z M 23.815 15.5863 H 16.4975 C 16.1057 15.5863 15.7881 15.9039 15.7881 16.2957 V 16.3219 C 15.7881 16.7137 16.1057 17.0313 16.4975 17.0313 H 23.815 C 24.2067 17.0313 24.5243 16.7137 24.5243 16.3219 V 16.2957 C 24.5243 15.9039 24.2067 15.5863 23.815 15.5863 Z M 12.8812 19.2063 H 5.565 C 5.1725 19.2063 4.8544 19.5245 4.8544 19.9169 V 19.9432 C 4.8544 20.3356 5.1725 20.6538 5.565 20.6538 H 12.8812 C 13.2737 20.6538 13.5919 20.3356 13.5919 19.9432 V 19.9169 C 13.5919 19.5245 13.2737 19.2063 12.8812 19.2063 Z M 23.8112 19.1999 L 16.4987 19.2126 C 16.1059 19.2133 15.788 19.5323 15.7887 19.9251 L 15.7888 19.9501 C 15.7894 20.3429 16.1084 20.6608 16.5013 20.6601 L 23.8137 20.6474 C 24.2066 20.6467 24.5244 20.3277 24.5237 19.9349 L 24.5237 19.9099 C 24.523 19.5171 24.204 19.1992 23.8112 19.1999 Z M 12.8812 22.8217 L 5.5625 22.8345 C 5.1711 22.8351 4.8543 23.153 4.855 23.5444 L 4.855 23.5707 C 4.8557 23.9621 5.1736 24.2789 5.565 24.2782 L 12.8838 24.2654 C 13.2752 24.2647 13.592 23.9469 13.5913 23.5554 L 13.5912 23.5292 C 13.5905 23.1378 13.2727 22.821 12.8812 22.8217 Z M 23.8169 22.8287 H 16.4956 C 16.1042 22.8287 15.7869 23.1461 15.7869 23.5375 V 23.5625 C 15.7869 23.9539 16.1042 24.2712 16.4956 24.2712 H 23.8169 C 24.2083 24.2712 24.5256 23.9539 24.5256 23.5625 V 23.5375 C 24.5256 23.1461 24.2083 22.8287 23.8169 22.8287 Z"
                        fill="black"
                        className={`${
                            fillColor == 'blog'
                                ? 'fill-red-600'
                                : 'fill-white-950'
                        }`}
                    />
                </svg>

                <p
                    className={`text-tiny-d-400 ${
                        fillColor == 'blog' ? 'text-red-600' : 'fill-white-950'
                    }`}
                >
                    Blog
                </p>
            </Link> */}

            {to && (
                <Link
                    to={to}
                    className="flex flex-col items-center justify-center w-5 gap-1"
                >
                    <svg
                        width="33"
                        height="33"
                        viewBox="0 0 33 33"
                        fill="none"
                        xmlns="http://www.w3.org/2000/svg"
                    >
                        <path
                            d="M16.44 0.5H17.0681C19.6781 0.562083 22.0763 1.18354 24.2625 2.36437C26.195 3.40812 27.8304 4.75625 29.1688 6.40875C31.4542 9.23042 32.6479 12.4913 32.75 16.1912V16.8181C32.6646 20.0102 31.7412 22.9042 29.98 25.5C28.6737 27.4256 26.9131 29.0756 24.9375 30.2537C22.5408 31.6829 19.915 32.4317 17.06 32.5H16.4319C13.8098 32.4375 11.4017 31.8106 9.2075 30.6194C7.2875 29.5773 5.66208 28.2346 4.33125 26.5912C2.04625 23.7696 0.8525 20.509 0.75 16.8094V16.1825C0.82 13.3129 1.57708 10.6756 3.02125 8.27063C4.195 6.31563 5.83313 4.57188 7.74125 3.27562C10.3417 1.50896 13.2412 0.58375 16.44 0.5ZM17.4794 5.79563C19.8694 6.04625 21.9888 7.615 22.9319 9.82625C23.421 10.9729 23.5817 12.159 23.4137 13.3844C23.1917 15.0048 22.4556 16.384 21.2056 17.5219C21.0035 17.7056 20.7865 17.8731 20.5544 18.0244C20.5497 18.0275 20.5459 18.0319 20.5435 18.037C20.5411 18.0421 20.5401 18.0478 20.5407 18.0533C20.5413 18.0589 20.5434 18.0641 20.5468 18.0685C20.5502 18.0729 20.5548 18.0762 20.56 18.0781C23.9794 19.3594 26.5019 22.1844 27.41 25.7181C27.4105 25.7201 27.4116 25.7219 27.413 25.7234C27.4145 25.7248 27.4162 25.7259 27.4182 25.7264C27.4201 25.7269 27.4221 25.7269 27.424 25.7263C27.4259 25.7257 27.4275 25.7246 27.4287 25.7231C28.7921 24.139 29.7633 22.34 30.3425 20.3263C30.3896 20.1629 30.4673 19.839 30.5756 19.3544C30.6594 18.9788 30.705 18.6006 30.7581 18.2231C30.796 17.9544 30.8212 17.6833 30.8337 17.41C30.8519 17.0012 30.88 16.5938 30.8706 16.1931C30.6869 8.51687 24.4119 2.36562 16.7163 2.37812C9.17562 2.39062 2.94375 8.3925 2.64 15.92C2.62292 16.3379 2.62583 16.7567 2.64875 17.1763C2.82458 20.3983 3.965 23.2479 6.07 25.725C6.07128 25.7264 6.07292 25.7275 6.07474 25.728C6.07657 25.7286 6.07851 25.7286 6.08036 25.7282C6.08221 25.7277 6.08391 25.7268 6.08528 25.7255C6.08665 25.7241 6.08763 25.7225 6.08813 25.7206C6.63896 23.5777 7.72146 21.7669 9.33562 20.2881C10.3965 19.3169 11.6027 18.5827 12.9544 18.0856C12.9586 18.0841 12.9624 18.0815 12.9652 18.078C12.968 18.0745 12.9699 18.0703 12.9704 18.0658C12.971 18.0613 12.9704 18.0568 12.9685 18.0527C12.9667 18.0486 12.9637 18.045 12.96 18.0425C11.7542 17.1938 10.9071 16.0981 10.4187 14.7556C9.84937 13.1906 9.90062 11.4388 10.525 9.9325C11.675 7.15938 14.475 5.48 17.4794 5.79563ZM21.605 12.4844C21.605 11.8468 21.4794 11.2155 21.2354 10.6264C20.9914 10.0374 20.6338 9.5022 20.183 9.05137C19.7322 8.60054 19.197 8.24293 18.6079 7.99894C18.0189 7.75495 17.3876 7.62937 16.75 7.62937C15.4624 7.62937 14.2275 8.14088 13.317 9.05137C12.4065 9.96186 11.895 11.1967 11.895 12.4844C11.895 13.772 12.4065 15.0069 13.317 15.9174C14.2275 16.8279 15.4624 17.3394 16.75 17.3394C17.3876 17.3394 18.0189 17.2138 18.6079 16.9698C19.197 16.7258 19.7322 16.3682 20.183 15.9174C20.6338 15.4665 20.9914 14.9313 21.2354 14.3423C21.4794 13.7533 21.605 13.1219 21.605 12.4844ZM9.57875 22.7894C8.555 24.0813 7.89937 25.66 7.705 27.2981C7.7025 27.3202 7.70958 27.3381 7.72625 27.3519C9.82958 29.0769 12.2077 30.1231 14.8606 30.4906C15.291 30.5502 15.7125 30.5877 16.125 30.6031C19.3146 30.7227 22.2277 29.8717 24.8644 28.05C25.0994 27.8879 25.4033 27.654 25.7763 27.3481C25.7933 27.3344 25.8004 27.3165 25.7975 27.2944C25.7271 26.7506 25.6296 26.2719 25.505 25.8581C24.92 23.9131 23.8354 22.3375 22.2512 21.1313C21.9208 20.8796 21.5887 20.659 21.255 20.4694C19.5975 19.5294 17.791 19.1494 15.8356 19.3294C15.2744 19.381 14.724 19.489 14.1844 19.6531C12.3215 20.2198 10.7862 21.2652 9.57875 22.7894Z"
                            fill="black"
                            className={`${
                                fillColor == 'profile'
                                    ? 'fill-red-600'
                                    : 'fill-white-950'
                            }`}
                        />
                    </svg>

                    <p
                        className={`text-tiny-d-400 ${
                            fillColor == 'profile'
                                ? 'text-red-600'
                                : 'fill-white-950'
                        }`}
                    >
                        Profile
                    </p>
                </Link>
            )}

            {/* MySQL and Spring Boot, on their own, cannot handle a complete notification system that can scale well. 
            I would need something like a message broker and a fast key/value storage engine. I could use Firebase, 
            but apparently FCM itself does not provide built-in functionality to store notifications for later retrieval. 
            Firestore exists, but I would rather implement a custom solution.
            Designing a notification system is another project itself so it is out of the scope of this application.
            <Link
                to="/notifications"
                className="flex flex-col items-center justify-center w-5 gap-1"
            >
                <svg
                    width="27"
                    height="33"
                    viewBox="0 0 27 33"
                    fill="none"
                    xmlns="http://www.w3.org/2000/svg"
                >
                    <path
                        d="M13.3506 0.5H13.6569C15.1681 0.644375 16.1806 1.79375 16.17 3.28312C16.1663 3.78021 16.1661 4.30354 16.1694 4.85313C16.1698 4.87604 16.1809 4.89083 16.2025 4.8975C19.8063 6.0275 22.3356 9.0675 22.7731 12.8038C22.8173 13.1825 22.8386 13.6023 22.8369 14.0631C22.8323 15.2277 22.83 16.4475 22.83 17.7225C22.8296 20.2554 23.6781 22.4362 25.3756 24.265C25.7469 24.665 26.265 25.0119 26.5506 25.4825C27.2288 26.6012 26.6344 28.0338 25.4069 28.4163C25.2219 28.4742 24.9615 28.5027 24.6256 28.5019C22.4269 28.4985 20.27 28.4983 18.155 28.5012C18.1346 28.5012 18.1227 28.511 18.1194 28.5306C17.7344 30.7463 15.9963 32.345 13.7488 32.5H13.2431C10.9969 32.335 9.24064 30.7275 8.88252 28.5244C8.88131 28.5169 8.87747 28.5101 8.87172 28.5053C8.86597 28.5004 8.8587 28.4979 8.85127 28.4981C6.94543 28.4998 4.74877 28.5015 2.26127 28.5031C1.99377 28.5031 1.76939 28.4738 1.58814 28.415C0.251269 27.9831 -0.256232 26.4294 0.566893 25.3044C0.766893 25.0312 1.05439 24.8281 1.29752 24.5906C3.0321 22.8948 3.98189 20.8438 4.14689 18.4375C4.16398 18.1883 4.17148 17.7719 4.16939 17.1881C4.16606 16.1498 4.16544 15.1027 4.16752 14.0469C4.16877 13.5377 4.1896 13.1125 4.23002 12.7712C4.46627 10.7875 5.25231 9.055 6.58814 7.57375C7.73064 6.30688 9.15877 5.4175 10.8031 4.89375C10.8269 4.88625 10.8386 4.87021 10.8381 4.84562C10.8219 3.91937 10.8269 3.26875 10.8531 2.89375C10.8931 2.3175 11.1725 1.75188 11.5688 1.33375C12.0363 0.840833 12.6302 0.562917 13.3506 0.5ZM12.2944 2.6025C12.2161 2.75917 12.1759 2.91958 12.1738 3.08375C12.1659 3.60875 12.1642 4.10042 12.1688 4.55875C12.1692 4.58375 12.1817 4.59458 12.2063 4.59125C13.0713 4.47125 13.9334 4.47146 14.7925 4.59188C14.82 4.59562 14.8336 4.58375 14.8331 4.55625C14.8298 4.145 14.8302 3.70479 14.8344 3.23563C14.8463 1.76813 12.9519 1.285 12.2944 2.6025ZM5.49689 17.9363C5.47939 20.8425 4.29189 23.5819 2.18189 25.5894C1.88502 25.8719 1.38314 26.1631 1.52377 26.66C1.62002 26.9992 1.86273 27.1688 2.25189 27.1688C9.75273 27.1692 17.2659 27.169 24.7913 27.1681C25.2744 27.1681 25.6188 26.7419 25.4575 26.2787C25.3619 26.0063 25.0238 25.7869 24.8075 25.5794C22.6988 23.5575 21.51 20.8181 21.5006 17.9056C21.4969 16.6927 21.4979 15.4681 21.5038 14.2319C21.5059 13.7402 21.4888 13.325 21.4525 12.9862C21.3159 11.7104 20.8988 10.5398 20.2013 9.47437C19.19 7.92854 17.7861 6.84646 15.9894 6.22813C15.7006 6.12875 15.3913 6.0625 15.0919 5.99813C14.409 5.85063 13.684 5.80333 12.9169 5.85625C12.5077 5.88458 12.0969 5.94771 11.6844 6.04563C9.81981 6.48813 8.2971 7.48104 7.11627 9.02437C6.24043 10.169 5.71835 11.4825 5.55002 12.965C5.51085 13.3067 5.49293 13.6979 5.49627 14.1388C5.50418 15.3871 5.50439 16.6529 5.49689 17.9363ZM12.0138 30.8106C12.9581 31.2938 14.1356 31.2838 15.0788 30.7638C15.9534 30.2812 16.514 29.5379 16.7606 28.5338C16.7661 28.5113 16.7573 28.5 16.7344 28.5H10.2688C10.2421 28.5 10.2321 28.5129 10.2388 28.5387C10.4996 29.5808 11.0913 30.3381 12.0138 30.8106Z"
                        fill="black"
                        className={`${
                            fillColor == 'notification'
                                ? 'fill-red-600'
                                : 'fill-white-950'
                        }`}
                    />
                </svg>

                <p
                    className={`text-tiny-d-400 ${
                        fillColor == 'notification'
                            ? 'text-red-600'
                            : 'fill-white-950'
                    }`}
                >
                    Notifications
                </p>
            </Link> */}
        </div>
    )
}

export default MobileNavMenu