import React from 'react'
import { Link } from 'react-router-dom'

import gemstone from '../../assests/gemstone.png'

function Footer() {
    return (
        <footer className="flex flex-col items-center justify-center p-2 border-t border-white-300 ">
            <div className="flex flex-col items-center justify-center max-w-[1120px] mx-auto my-0 w-full gap-3">
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
                <div className="flex flex-col items-center justify-center gap-3 lg:flex-row lg:justify-between lg:items-center w-full">
                    <div className="flex-1 flex-col items-start justify-center hidden lg:flex">
                        <p className="text-body-m-700 lg:text-body-d-700">OVERVIEW</p>
                        <Link to="/asdxx" className="hover:cursor-pointer hover:text-red-600 text-small-m-300 lg:text-small-d-300">
                            About Cinnabar
                        </Link>
                        <Link to="/asdxx" className="hover:cursor-pointer hover:text-red-600 text-small-m-300 lg:text-small-d-300">
                            Critic submission
                        </Link>
                        <Link to="/asdxx" className="hover:cursor-pointer hover:text-red-600 text-small-m-300 lg:text-small-d-300">
                            Licensing
                        </Link>
                        <Link to="/asdxx" className="hover:cursor-pointer hover:text-red-600 text-small-m-300 lg:text-small-d-300">
                            FAQ
                        </Link>
                    </div>

                    <div className="flex-1 flex flex-col items-center justify-center gap-1">
                        <p className="text-body-m-700 hidden lg:block lg:text-body-d-400">
                            EXPLORE
                        </p>
                        <p className="text-small-m-300 hidden lg:block w-[240px] text-center lg:text-small-d-300">
                            View freshest reviews, news, and more delivered
                            right now!
                        </p>
                        <div className="flex flex-row items-center justify-center w-[136px] h-[40px] bg-red-600 rounded hover:bg-red-400">
                            <Link
                                to="/blog"
                                className="text-white-50 text-small-m-400 lg:text-small-d-400"
                            >
                                Visit our blog site
                            </Link>
                        </div>
                    </div>

                    <div className="flex-1 flex flex-col items-center justify-center gap-1">
                        <p className="text-body-m-700 lg:text-body-d-700">FOLLOW US</p>
                        <div className="flex flex-row items-center gap-2">
                            <a
                                href="https://www.facebook.com/"
                                target="_blank"
                                className="flex flex-row items-center justify-center group hover:cursor-pointer w-3 h-3"
                            >
                                <svg
                                    width="14"
                                    height="24"
                                    viewBox="0 0 14 24"
                                    fill="none"
                                    xmlns="http://www.w3.org/2000/svg"
                                >
                                    <path
                                        d="M9.79336 0H10.294C10.3971 0.0078125 10.5493 0.0117188 10.7505 0.0117188C11.3824 0.0120312 12.2009 0.0642187 13.2059 0.168281C13.224 0.170156 13.233 0.180156 13.233 0.198281L13.2326 3.94969C13.2326 3.95889 13.2289 3.96771 13.2224 3.97422C13.2159 3.98072 13.2071 3.98438 13.1979 3.98438C12.5266 3.98438 11.8495 3.98422 11.1663 3.98391C11.036 3.98391 10.9027 3.98813 10.7665 3.99656C10.4543 4.01578 10.1824 4.03734 9.87774 4.14375C9.5093 4.27266 9.15258 4.56328 9.03305 4.93875C8.9918 5.06766 8.94492 5.18438 8.92148 5.32078C8.88023 5.56266 8.85961 5.80469 8.85961 6.04688C8.85961 6.95563 8.85977 7.86328 8.86008 8.76984C8.86008 8.78141 8.86586 8.78719 8.87742 8.78719H13.0695C13.071 8.78716 13.0725 8.78749 13.0739 8.78813C13.0753 8.78878 13.0766 8.78973 13.0776 8.79093C13.0786 8.79213 13.0794 8.79355 13.0799 8.79509C13.0803 8.79662 13.0804 8.79825 13.0802 8.79984L12.5327 13.043C12.5324 13.046 12.5309 13.0487 12.5286 13.0507C12.5262 13.0527 12.5232 13.0538 12.5201 13.0538H8.88727C8.87008 13.0538 8.86148 13.0623 8.86148 13.0795L8.86008 24H4.45336L4.45383 13.073C4.45383 13.0679 4.4518 13.063 4.4482 13.0594C4.4446 13.0558 4.43971 13.0538 4.43461 13.0538H0.789609C0.783766 13.0538 0.778162 13.0514 0.774031 13.0473C0.769899 13.0432 0.767578 13.0376 0.767578 13.0317V8.81063C0.767578 8.795 0.775391 8.78719 0.791016 8.78719L4.43086 8.78672C4.44711 8.78672 4.45523 8.77875 4.45523 8.76281C4.45148 7.67438 4.45211 6.61281 4.45711 5.57812C4.4618 4.62891 4.62352 3.64687 5.03133 2.80312C5.6057 1.61281 6.5118 0.796562 7.74961 0.354375C8.36773 0.13375 9.04898 0.015625 9.79336 0Z"
                                        fill="#010001"
                                        className="group-hover:fill-red-600"
                                    />
                                </svg>
                            </a>

                            <a
                                href="https://twitter.com/"
                                target="_blank"
                                className="flex flex-row items-center justify-center group hover:cursor-pointer w-3 h-3"
                            >
                                <svg
                                    width="24"
                                    height="20"
                                    viewBox="0 0 24 20"
                                    fill="none"
                                    xmlns="http://www.w3.org/2000/svg"
                                >
                                    <path
                                        d="M21.2152 3.3241C22.1677 3.20035 23.0819 2.94973 23.9578 2.57223C23.9807 2.56223 23.9852 2.56754 23.9714 2.58817C23.3196 3.56223 22.5168 4.39488 21.563 5.08613C21.5418 5.10176 21.5318 5.1227 21.533 5.14895C21.5558 5.55426 21.5563 5.96395 21.5344 6.37801C21.3464 9.96863 19.7597 13.5316 17.146 16.0183C15.1494 17.9174 12.7721 19.0949 10.0139 19.5508C9.163 19.6914 8.29394 19.7558 7.40675 19.7439C4.73144 19.708 2.27394 18.9799 0.0342522 17.5596C0.0327945 17.5586 0.0317062 17.5571 0.0311576 17.5555C0.030609 17.5538 0.0306311 17.552 0.0312205 17.5503C0.0318099 17.5487 0.0329332 17.5472 0.0344148 17.5463C0.0358963 17.5453 0.0376525 17.5449 0.0394085 17.545C1.55753 17.7075 3.02503 17.5433 4.44191 17.0524C5.45035 16.7027 6.3855 16.1944 7.24738 15.5275C7.26394 15.5147 7.26175 15.508 7.24082 15.5074C5.13847 15.4338 3.383 14.0964 2.69066 12.1127C2.68964 12.1098 2.68939 12.1066 2.68993 12.1036C2.69046 12.1005 2.69177 12.0977 2.69371 12.0953C2.69565 12.0929 2.69816 12.0911 2.701 12.0901C2.70384 12.089 2.7069 12.0887 2.70988 12.0893C3.42488 12.2102 4.13456 12.185 4.83894 12.0138C4.87675 12.0047 4.87675 11.9961 4.83894 11.988C3.89535 11.7818 3.03706 11.3022 2.36347 10.608C1.45003 9.66645 0.981284 8.51363 0.957221 7.14957C0.957161 7.14558 0.958143 7.14164 0.96007 7.13814C0.961997 7.13465 0.964803 7.13171 0.96821 7.12963C0.971617 7.12755 0.975509 7.12639 0.9795 7.12627C0.983492 7.12615 0.987445 7.12707 0.990971 7.12895C1.66128 7.48801 2.39769 7.69098 3.1505 7.71817C3.15223 7.71814 3.15392 7.71757 3.15532 7.71656C3.15672 7.71554 3.15777 7.71411 3.15834 7.71247C3.1589 7.71083 3.15894 7.70906 3.15847 7.7074C3.15799 7.70573 3.15701 7.70426 3.15566 7.70317C2.08972 6.9491 1.41206 5.95004 1.12269 4.70598C1.053 4.40567 1.01394 4.09723 1.0055 3.78067C0.98144 2.86348 1.20097 1.99363 1.6641 1.17113C1.67222 1.15676 1.6816 1.15598 1.69222 1.16879C2.77191 2.48192 4.02863 3.55832 5.46238 4.39801C7.40675 5.53707 9.51644 6.16801 11.7914 6.29082C11.7942 6.29096 11.7969 6.29046 11.7994 6.28937C11.8019 6.28828 11.8041 6.28663 11.8059 6.28455C11.8077 6.28247 11.8089 6.28 11.8096 6.27735C11.8103 6.2747 11.8103 6.27193 11.8097 6.26926C11.5666 5.01707 11.7333 3.86129 12.3099 2.80192C13.1653 1.2302 14.8538 0.234572 16.6416 0.255197C17.8172 0.268635 18.8638 0.652697 19.7813 1.40738C19.9224 1.52363 20.0508 1.65723 20.1821 1.78238C20.1961 1.79582 20.2128 1.80067 20.2322 1.79692C21.3228 1.57723 22.3446 1.18817 23.2974 0.629728C23.3199 0.616603 23.3269 0.622385 23.3185 0.647072C22.9847 1.64332 22.3963 2.45285 21.5532 3.07567C21.4421 3.1577 21.3235 3.23035 21.2086 3.30629C21.1846 3.32192 21.1868 3.32785 21.2152 3.3241Z"
                                        fill="black"
                                        className="group-hover:fill-red-600"
                                    />
                                </svg>
                            </a>

                            <a
                                href="https://www.instagram.com/"
                                target="_blank"
                                className="flex flex-row items-center justify-center group hover:cursor-pointer w-3 h-3"
                            >
                                <svg
                                    width="24"
                                    height="24"
                                    viewBox="0 0 24 24"
                                    fill="none"
                                    xmlns="http://www.w3.org/2000/svg"
                                >
                                    <path
                                        d="M9.85637 0H14.227C15.2632 0.005625 16.2981 0.0378125 17.3315 0.0965625C17.9887 0.134062 18.6314 0.240312 19.2595 0.415312C20.5698 0.780625 21.644 1.48047 22.4822 2.51484C23.5265 3.80391 23.9189 5.44875 23.9751 7.07812C23.9804 7.22469 23.9887 7.37094 24 7.51688V16.2811C23.9781 16.6477 23.9651 16.8845 23.9611 16.9917C23.9323 17.8083 23.8156 18.5652 23.6109 19.2623C22.9036 21.6736 21.0693 23.2505 18.637 23.7389C17.8054 23.9062 17.0039 23.9377 16.125 23.962C15.4881 23.9795 14.8509 23.9922 14.2134 24H9.87371C8.93715 23.9931 8.00137 23.9691 7.06637 23.9278C5.62684 23.8641 4.12731 23.5491 2.93246 22.717C1.69715 21.8567 0.871838 20.6927 0.456525 19.2248C0.279338 18.5995 0.171057 17.9442 0.131682 17.2589C0.0816817 16.3936 0.0543379 15.5236 0.0496504 14.6489C0.0405879 12.8889 0.0407442 11.1402 0.0501192 9.40266C0.0551192 8.47516 0.0852754 7.56781 0.140588 6.68062C0.196838 5.77031 0.377775 4.84078 0.729338 4.00219C1.19653 2.88875 1.92965 1.98375 2.92871 1.28719C4.01199 0.531562 5.3634 0.192187 6.66793 0.0946875C7.41356 0.03875 8.47637 0.0071875 9.85637 0ZM2.74778 4.81594C2.49903 5.42844 2.35324 6.09719 2.31043 6.82219C2.26668 7.56219 2.24153 8.19828 2.23496 8.73047C2.21028 10.7458 2.20903 12.8122 2.23121 14.9297C2.23746 15.5559 2.25574 16.1927 2.28606 16.8398C2.32028 17.5659 2.41028 18.2709 2.64934 18.9497C2.97981 19.8891 3.62059 20.663 4.48356 21.1355C5.39621 21.6352 6.45043 21.7448 7.47699 21.7856C8.13012 21.8113 8.62621 21.8258 8.96527 21.8292C10.6578 21.8458 12.4662 21.8486 14.3906 21.8377C15.1722 21.8333 15.9531 21.8139 16.7334 21.7795C17.7722 21.7336 18.8184 21.6084 19.7292 21.0642C20.504 20.6016 21.097 19.8905 21.4167 19.0444C21.6886 18.3253 21.7875 17.5598 21.8189 16.792C21.8589 15.8158 21.8803 14.8842 21.8831 13.9973C21.8881 12.2961 21.885 10.6925 21.8737 9.18656C21.8687 8.55937 21.85 7.91141 21.8175 7.24266C21.7837 6.53906 21.7111 5.87437 21.4978 5.20266C21.134 4.0575 20.3123 3.12562 19.1765 2.68078C18.5681 2.44266 17.9146 2.31562 17.2968 2.27484C16.7062 2.23609 16.0187 2.20922 15.2343 2.19422C14.3456 2.17734 12.6426 2.17391 10.1254 2.18391C8.69512 2.18953 7.58934 2.22031 6.80809 2.27625C5.85043 2.34469 4.8084 2.58609 4.02934 3.18422C3.46356 3.61875 3.01496 4.15875 2.74778 4.81594Z"
                                        fill="black"
                                        className="group-hover:fill-red-600"
                                    />
                                    <path
                                        d="M18.4532 7.03173C19.2478 7.03173 19.8918 6.38765 19.8918 5.59313C19.8918 4.79862 19.2478 4.15454 18.4532 4.15454C17.6587 4.15454 17.0146 4.79862 17.0146 5.59313C17.0146 6.38765 17.6587 7.03173 18.4532 7.03173Z"
                                        fill="black"
                                        className="group-hover:fill-red-600"
                                    />
                                    <path
                                        d="M18.2089 12.0019C18.2089 12.8115 18.0495 13.6131 17.7397 14.361C17.4299 15.1089 16.9758 15.7885 16.4034 16.3609C15.831 16.9333 15.1514 17.3874 14.4035 17.6972C13.6556 18.007 12.854 18.1665 12.0444 18.1665C10.4095 18.1665 8.84151 17.517 7.68543 16.3609C6.52936 15.2048 5.87988 13.6369 5.87988 12.0019C5.87988 10.367 6.52936 8.79903 7.68543 7.64295C8.84151 6.48688 10.4095 5.8374 12.0444 5.8374C12.854 5.8374 13.6556 5.99685 14.4035 6.30665C15.1514 6.61645 15.831 7.07052 16.4034 7.64295C16.9758 8.21538 17.4299 8.89495 17.7397 9.64287C18.0495 10.3908 18.2089 11.1924 18.2089 12.0019ZM16.0433 12.0019C16.0433 11.4768 15.9399 10.9568 15.7389 10.4716C15.538 9.98645 15.2434 9.54561 14.8721 9.17428C14.5007 8.80295 14.0599 8.50839 13.5747 8.30743C13.0896 8.10646 12.5696 8.00303 12.0444 8.00303C10.9838 8.00303 9.9667 8.42434 9.21676 9.17428C8.46682 9.92422 8.04551 10.9414 8.04551 12.0019C8.04551 13.0625 8.46682 14.0796 9.21676 14.8296C9.9667 15.5795 10.9838 16.0008 12.0444 16.0008C12.5696 16.0008 13.0896 15.8974 13.5747 15.6964C14.0599 15.4955 14.5007 15.2009 14.8721 14.8296C15.2434 14.4583 15.538 14.0174 15.7389 13.5322C15.9399 13.0471 16.0433 12.5271 16.0433 12.0019Z"
                                        fill="black"
                                        className="group-hover:fill-red-600"
                                    />
                                </svg>
                            </a>

                            <a
                                href="https://www.pinterest.com"
                                target="_blank"
                                className="flex flex-row items-center justify-center group hover:cursor-pointer w-3 h-3"
                            >
                                <svg
                                    width="24"
                                    height="24"
                                    viewBox="0 0 24 24"
                                    fill="none"
                                    xmlns="http://www.w3.org/2000/svg"
                                >
                                    <path
                                        d="M23.6274 12.2569C23.6274 13.7829 23.3268 15.2939 22.7429 16.7036C22.1589 18.1134 21.303 19.3944 20.224 20.4734C19.145 21.5524 17.864 22.4083 16.4543 22.9923C15.0445 23.5762 13.5335 23.8768 12.0075 23.8768C8.92577 23.8768 5.97021 22.6525 3.79107 20.4734C1.61193 18.2943 0.387695 15.3387 0.387695 12.2569C0.387695 9.17516 1.61193 6.2196 3.79107 4.04046C5.97021 1.86132 8.92577 0.637085 12.0075 0.637085C13.5335 0.637085 15.0445 0.937641 16.4543 1.52159C17.864 2.10554 19.145 2.96146 20.224 4.04046C21.303 5.11946 22.1589 6.40042 22.7429 7.81021C23.3268 9.21999 23.6274 10.731 23.6274 12.2569ZM11.0522 14.4952C11.0528 14.4927 11.054 14.4903 11.0556 14.4884C11.0573 14.4864 11.0594 14.4848 11.0618 14.4839C11.0642 14.4829 11.0668 14.4825 11.0694 14.4828C11.072 14.4831 11.0744 14.4839 11.0766 14.4854C11.3497 14.6691 11.6225 14.8515 11.895 15.0324C12.2079 15.2405 12.5443 15.3583 12.9043 15.3858C14.9635 15.5419 16.4316 14.1516 17.0654 12.3207C17.42 11.2954 17.5183 10.2215 17.3602 9.09896C16.9397 6.11724 13.8179 4.91865 11.1624 5.33724C9.89957 5.53646 8.67426 6.17584 7.81598 7.1499C6.86598 8.2274 6.46113 9.49708 6.60145 10.959C6.68535 11.8299 7.02004 12.6211 7.80004 13.0519C8.01691 13.1716 8.27004 13.2647 8.55941 13.3313C8.57723 13.3354 8.59035 13.3293 8.59879 13.313C8.83926 12.8569 8.90676 12.4036 8.62785 11.9344C8.44035 11.618 8.22379 11.2965 8.17457 10.928C8.06207 10.0877 8.2166 9.31162 8.63816 8.59974C9.4327 7.25912 11.0119 6.42662 12.5705 6.54615C13.2786 6.60052 13.9158 6.85552 14.4821 7.31115C14.8355 7.59568 15.0844 7.95427 15.2433 8.38083C15.645 9.46224 15.5682 10.7761 15.2086 11.8688C14.8032 13.0997 13.8296 14.378 12.3338 13.9088C11.3616 13.6036 11.5861 12.5213 11.8041 11.8004C11.9385 11.3551 12.0714 10.9122 12.203 10.4719C12.3877 9.85318 12.5977 8.86318 11.8599 8.49568C11.4221 8.27771 10.9477 8.26927 10.545 8.56459C9.64785 9.22365 9.42707 10.861 9.94738 11.7722C9.95738 11.7901 9.96051 11.809 9.95676 11.829C9.86457 12.2896 9.75019 12.7772 9.61363 13.2919C9.26394 14.611 8.95082 15.8326 8.86129 17.1324C8.81441 17.8155 8.83691 18.4996 8.92879 19.1846C8.92904 19.1865 8.92979 19.1882 8.93096 19.1897C8.93212 19.1912 8.93366 19.1924 8.93542 19.1931C8.93718 19.1938 8.9391 19.1941 8.94098 19.1938C8.94286 19.1935 8.94464 19.1928 8.94613 19.1916C10.3632 18.1121 10.7494 16.148 11.0522 14.4952Z"
                                        fill="black"
                                        className="group-hover:fill-red-600"
                                    />
                                </svg>
                            </a>

                            <a
                                href="https://www.youtube.com/"
                                target="_blank"
                                className="flex flex-row items-center justify-center group hover:cursor-pointer w-3 h-3"
                            >
                                <svg
                                    width="24"
                                    height="18"
                                    viewBox="0 0 24 18"
                                    fill="none"
                                    xmlns="http://www.w3.org/2000/svg"
                                >
                                    <path
                                        d="M24 8.60301V9.40316C23.9797 11.0844 23.8783 12.76 23.6958 14.43C23.6723 14.646 23.6427 14.8327 23.6067 14.9902C23.5658 15.1693 23.4894 15.3571 23.3775 15.5536C23.0984 16.0439 22.7184 16.4158 22.2375 16.6693C21.9847 16.8024 21.735 16.883 21.4884 16.9111C20.8397 16.9849 20.2153 17.0541 19.6153 17.1188C18.8222 17.2041 18.0164 17.2585 17.2209 17.3194C16.328 17.3874 15.4092 17.4216 14.5284 17.4525C13.0847 17.5032 11.5661 17.5089 9.97266 17.4699C9.23391 17.4521 8.47359 17.4113 7.72172 17.3766C7.40859 17.3622 7.09781 17.3432 6.78937 17.3194C6.00187 17.2589 5.22234 17.2088 4.45172 17.1244C3.90516 17.0644 3.37203 17.0079 2.85234 16.9547C2.53734 16.9225 2.28719 16.8758 2.10188 16.8146C1.30734 16.5521 0.593437 15.7979 0.392344 14.985C0.360469 14.856 0.341719 14.7672 0.336094 14.7188C0.133281 12.951 0.02125 11.1772 0 9.39754V8.58801C0.0103125 8.2802 0.0195312 7.97238 0.0276562 7.66457C0.0676562 6.13863 0.171562 4.66988 0.339375 3.25832C0.344375 3.21426 0.362812 3.12895 0.394688 3.00238C0.594375 2.2102 1.29328 1.46723 2.06531 1.19723C2.26 1.1291 2.53344 1.07723 2.88563 1.0416C3.71578 0.956759 4.5525 0.853165 5.38359 0.789415C6.16266 0.729415 6.94125 0.661915 7.72219 0.620665C10.8056 0.458009 13.8863 0.465509 16.8516 0.656759C17.1769 0.677696 17.7906 0.723946 18.6928 0.795509C19.5872 0.86629 20.4802 0.977384 21.3722 1.07207C21.5578 1.09176 21.7917 1.13535 21.9656 1.20566C22.5963 1.46098 23.0772 1.89316 23.4084 2.50223C23.5837 2.8252 23.6498 3.13598 23.6939 3.54285C23.8423 4.89879 23.9348 6.26098 23.9714 7.62941C23.9802 7.9541 23.9897 8.27863 24 8.60301ZM10.0214 5.0152C10.0193 5.01386 10.0169 5.01312 10.0144 5.01304C10.0119 5.01295 10.0094 5.01354 10.0072 5.01474C10.005 5.01593 10.0032 5.01769 10.0019 5.01983C10.0006 5.02197 9.99988 5.02442 9.99984 5.02692V12.975C9.99988 12.9775 10.0006 12.98 10.0019 12.9821C10.0032 12.9843 10.005 12.986 10.0072 12.9872C10.0094 12.9884 10.0119 12.989 10.0144 12.9889C10.0169 12.9888 10.0193 12.9881 10.0214 12.9868L15.983 9.0127C15.9849 9.01141 15.9865 9.00967 15.9876 9.00763C15.9887 9.00558 15.9893 9.0033 15.9893 9.00098C15.9893 8.99866 15.9887 8.99637 15.9876 8.99433C15.9865 8.99228 15.9849 8.99054 15.983 8.98926L10.0214 5.0152Z"
                                        fill="black"
                                        className="group-hover:fill-red-600"
                                    />
                                </svg>
                            </a>
                        </div>
                    </div>
                </div>

                <ul className="flex flex-row flex-wrap items-center gap-2 justify-around w-full">
                    <li>
                        <Link
                            to="/privacy"
                            className="hover:cursor-pointer hover:text-red-600 text-small-m-300 lg:text-small-d-300"
                        >
                            Privacy police
                        </Link>
                    </li>
                    <li>
                        <Link
                            to="/terms"
                            className="hover:cursor-pointer hover:text-red-600 text-small-m-300 lg:text-small-d-300"
                        >
                            Terms and conditions
                        </Link>
                    </li>
                    <li>
                        <Link
                            to="/blog"
                            className="hover:cursor-pointer hover:text-red-600 text-small-m-300 lg:text-small-d-300"
                        >
                            Blog site
                        </Link>
                    </li>
                    <li>
                        <Link
                            to="/cookies"
                            className="hover:cursor-pointer hover:text-red-600 text-small-m-300 lg:text-small-d-300"
                        >
                            Cookies settings
                        </Link>
                    </li>
                    <li>
                        <Link
                            to="/help"
                            className="hover:cursor-pointer hover:text-red-600 text-small-m-300 lg:text-small-d-300"
                        >
                            Help
                        </Link>
                    </li>
                </ul>
            </div>
        </footer>
    )
}

export default Footer
