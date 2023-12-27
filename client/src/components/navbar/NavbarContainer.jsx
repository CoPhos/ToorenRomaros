import React, { Fragment, useState, useEffect } from 'react'
import { Link } from 'react-router-dom'

import gemstone from '../../assests/gemstone.png'
import LinksPanel from './LinksPanel';
import LoginCard from '../cards/login/LoginCard';

function Navbar({ handleSubmit, handleChange, formData, data1 ,data2 }) {
    const [isPopupOpen, setPopupOpen] = useState(false)
    

    const openPopup = () => {
        setPopupOpen(true)
    }

    const closePopup = () => {
        setPopupOpen(false)
    }

    useEffect(() => {
        if (isPopupOpen) {
            document.body.style.overflow = 'hidden'
        } else {
            document.body.style.overflow = 'auto'
        }
    }, [isPopupOpen])

    //
    // TODO: Implement showing errors after form submission
    //
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
                <div className="flex flex-row items-center justify-between gap-2 lg:hidden">
                    <Link to="/browse">
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
                    </Link>
                    {/* <Link to="profile">
                        <svg
                            width="24"
                            height="24"
                            viewBox="0 0 24 24"
                            fill="none"
                            xmlns="http://www.w3.org/2000/svg"
                        >
                            <path
                                d="M11.7675 0H12.2386C14.1961 0.0465625 15.9947 0.512656 17.6344 1.39828C19.0837 2.18109 20.3103 3.19219 21.3141 4.43156C23.0281 6.54781 23.9234 8.99344 24 11.7684V12.2386C23.9359 14.6327 23.2434 16.8031 21.9225 18.75C20.9428 20.1942 19.6223 21.4317 18.1406 22.3153C16.3431 23.3872 14.3737 23.9487 12.2325 24H11.7614C9.79484 23.9531 7.98875 23.483 6.34313 22.5895C4.90313 21.808 3.68406 20.8009 2.68594 19.5684C0.972187 17.4522 0.076875 15.0067 0 12.232V11.7619C0.0525 9.60969 0.620313 7.63172 1.70344 5.82797C2.58375 4.36172 3.81234 3.05391 5.24344 2.08172C7.19375 0.756719 9.36844 0.0628125 11.7675 0ZM12.547 3.97172C14.3395 4.15969 15.9291 5.33625 16.6364 6.99469C17.0033 7.85469 17.1238 8.74422 16.9978 9.66328C16.8312 10.8786 16.2792 11.913 15.3417 12.7664C15.1902 12.9042 15.0273 13.0298 14.8533 13.1433C14.8498 13.1456 14.8469 13.1489 14.8451 13.1527C14.8433 13.1566 14.8426 13.1608 14.843 13.165C14.8435 13.1692 14.8451 13.1731 14.8476 13.1764C14.8502 13.1797 14.8536 13.1822 14.8575 13.1836C17.422 14.1445 19.3139 16.2633 19.995 18.9136C19.9954 18.9151 19.9962 18.9164 19.9973 18.9175C19.9983 18.9186 19.9997 18.9194 20.0011 18.9198C20.0026 18.9202 20.0041 18.9202 20.0055 18.9197C20.0069 18.9193 20.0081 18.9185 20.0091 18.9173C21.0316 17.7292 21.76 16.38 22.1944 14.8697C22.2297 14.7472 22.288 14.5042 22.3692 14.1408C22.432 13.8591 22.4662 13.5755 22.5061 13.2923C22.5345 13.0908 22.5534 12.8875 22.5628 12.6825C22.5764 12.3759 22.5975 12.0703 22.5905 11.7698C22.4527 6.01266 17.7464 1.39922 11.9747 1.40859C6.31922 1.41797 1.64531 5.91937 1.4175 11.565C1.40469 11.8784 1.40688 12.1925 1.42406 12.5072C1.55594 14.9237 2.41125 17.0609 3.99 18.9188C3.99096 18.9198 3.99219 18.9206 3.99356 18.921C3.99492 18.9214 3.99638 18.9215 3.99777 18.9211C3.99916 18.9208 4.00043 18.9201 4.00146 18.9191C4.00248 18.9181 4.00322 18.9168 4.00359 18.9155C4.41672 17.3083 5.22859 15.9502 6.43922 14.8411C7.23484 14.1127 8.13953 13.562 9.15328 13.1892C9.15647 13.1881 9.15928 13.1861 9.16141 13.1835C9.16353 13.1809 9.16489 13.1777 9.16533 13.1743C9.16576 13.171 9.16527 13.1676 9.16388 13.1645C9.1625 13.1614 9.16029 13.1588 9.1575 13.1569C8.25313 12.5203 7.61781 11.6986 7.25156 10.6917C6.82453 9.51797 6.86297 8.20406 7.33125 7.07438C8.19375 4.99453 10.2938 3.735 12.547 3.97172ZM15.6412 8.98828C15.6412 8.51011 15.5471 8.03661 15.3641 7.59484C15.1811 7.15306 14.9129 6.75165 14.5748 6.41353C14.2366 6.07541 13.8352 5.80719 13.3934 5.62421C12.9517 5.44122 12.4782 5.34703 12 5.34703C11.0343 5.34703 10.1081 5.73066 9.42525 6.41353C8.74238 7.0964 8.35875 8.02256 8.35875 8.98828C8.35875 9.954 8.74238 10.8802 9.42525 11.563C10.1081 12.2459 11.0343 12.6295 12 12.6295C12.4782 12.6295 12.9517 12.5353 13.3934 12.3524C13.8352 12.1694 14.2366 11.9012 14.5748 11.563C14.9129 11.2249 15.1811 10.8235 15.3641 10.3817C15.5471 9.93995 15.6412 9.46646 15.6412 8.98828ZM6.62156 16.717C5.85375 17.6859 5.36203 18.87 5.21625 20.0986C5.21438 20.1152 5.21969 20.1286 5.23219 20.1389C6.80969 21.4327 8.59328 22.2173 10.583 22.493C10.9058 22.5377 11.2219 22.5658 11.5312 22.5773C13.9234 22.667 16.1083 22.0287 18.0858 20.6625C18.262 20.5409 18.49 20.3655 18.7697 20.1361C18.7825 20.1258 18.7878 20.1123 18.7856 20.0958C18.7328 19.688 18.6597 19.3289 18.5662 19.0186C18.1275 17.5598 17.3141 16.3781 16.1259 15.4734C15.8781 15.2847 15.6291 15.1192 15.3787 14.977C14.1356 14.272 12.7808 13.987 11.3142 14.122C10.8933 14.1608 10.4805 14.2417 10.0758 14.3648C8.67859 14.7898 7.52719 15.5739 6.62156 16.717Z"
                                fill="#656565"
                            />
                        </svg>
                    </Link> */}
                    {/* <button
                        onClick={openPopup}
                        className="flex flex-row items-center justify-center w-[98px] h-[32px] bg-red-600 rounded hover:bg-red-400 text-white-50 text-small-d-400"
                    >
                        Sign in
                    </button> */}
                    <Link
                        to="/profile"
                        className="flex flex-row items-center justify-start gap-1 hover:cursor-pointer group"
                    >
                        <img
                            //srcset="https://small 480w, https://medium 800w, https://large 1100w"
                            src="https://image.tmdb.org/t/p/w235_and_h235_face/3dxEx32JnxUO34Wx0Y8tulUwlyh.jpg"
                            alt="Elva dressed as a fairy"
                            className="w-[34px] h-[34px] rounded-[50%] object-cover object-center"
                        />
                        <p className="hidden sm:block text-small-d-400 group-hover:text-red-600">
                            Ruka Inaba
                        </p>
                    </Link>
                </div>

                <div className="flex-row items-center justify-center gap-3 hidden lg:flex">
                    <div className="relative">
                        <ul className="flex flex-row items-center justify-between gap-4">
                            <li className="group px-2 hover:bg-white-100 rounded-t-md h-6">
                                <div className="h-full flex flex-row items-center justify-center">
                                    <Link
                                        to="/browse/theaters"
                                        className="group-hover:cursor-pointer group-hover:text-red-600 text-body-d-700 "
                                    >
                                        Movies
                                    </Link>
                                </div>
                                <div className="w-fit h-[550px] absolute bg-white-50 hidden group-hover:flex top-6 left-[0px] rounded-b-md shadow-[0_2.8px_2.2px_rgba(0,_0,_0,_0.034),_0_6.7px_5.3px_rgba(0,_0,_0,_0.048),_0_12.5px_10px_rgba(0,_0,_0,_0.06),_0_22.3px_17.9px_rgba(0,_0,_0,_0.072),_0_41.8px_33.4px_rgba(0,_0,_0,_0.086),_0_100px_80px_rgba(0,_0,_0,_0.12)]">
                                    <LinksPanel
                                        data={data1}
                                        tittle1={'Explore Movies'}
                                        tittle2={'New Movies in Theaters'}
                                    ></LinksPanel>
                                </div>
                            </li>
                            <li className="group px-2 hover:bg-white-100 rounded-t-md h-6">
                                <div className="h-full flex flex-row items-center justify-center">
                                    <Link
                                        to="/browse/tv"
                                        className="group-hover:cursor-pointer group-hover:text-red-600 text-body-d-700 "
                                    >
                                        Tv Shows
                                    </Link>
                                </div>
                                <div className="w-fit h-[550px] absolute bg-white-50 hidden group-hover:flex top-6 left-[0px] rounded-b-md shadow-[0_2.8px_2.2px_rgba(0,_0,_0,_0.034),_0_6.7px_5.3px_rgba(0,_0,_0,_0.048),_0_12.5px_10px_rgba(0,_0,_0,_0.06),_0_22.3px_17.9px_rgba(0,_0,_0,_0.072),_0_41.8px_33.4px_rgba(0,_0,_0,_0.086),_0_100px_80px_rgba(0,_0,_0,_0.12)]">
                                    <LinksPanel
                                        data={data2}
                                        tittle1={'Explore TV'}
                                        tittle2={'New TV Shows'}
                                    ></LinksPanel>
                                </div>
                            </li>
                            <li className="group px-2 hover:bg-white-100 rounded-md h-6">
                                <div className="h-full flex flex-row items-center justify-center">
                                    <Link
                                        to="/blog"
                                        className="group-hover:cursor-pointer group-hover:text-red-600 text-body-d-700 "
                                    >
                                        Blog
                                    </Link>
                                </div>
                            </li>
                        </ul>
                    </div>
                    <div className="flex flex-row items-center justify-start gap-2">
                        <div className="flex flex-row items-center justify-start gap-1 w-[265px] h-5 bg-white-100 rounded-3xl px-2">
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
                            <input
                                placeholder="Search Movies, Tv, Actors..."
                                type="text"
                                id="fname"
                                name="fname"
                                className="outline-none bg-transparent text-small-d-400 w-full"
                            />
                        </div>
                        {/* <button
                            onClick={openPopup}
                            className="flex flex-row items-center justify-center w-[98px] h-[32px] bg-red-600 rounded hover:bg-red-400 text-white-50 text-small-d-400"
                        >
                            Sign in
                        </button> */}
                        <Link
                            to="/profile"
                            className="flex flex-row items-center justify-start gap-1 hover:cursor-pointer group"
                        >
                            <img
                                //srcset="https://small 480w, https://medium 800w, https://large 1100w"
                                src="https://image.tmdb.org/t/p/w235_and_h235_face/3dxEx32JnxUO34Wx0Y8tulUwlyh.jpg"
                                alt="Elva dressed as a fairy"
                                className="w-[34px] h-[34px] rounded-[50%] object-cover object-center"
                            />
                            <p className="text-small-d-400 group-hover:text-red-600">
                                Ruka Inaba
                            </p>
                        </Link>
                    </div>
                </div>
                {isPopupOpen && (
                    <LoginCard
                        formData={formData}
                        handleChange={handleChange}
                        handleSubmit={handleSubmit}
                        closePopup={closePopup}
                    ></LoginCard>
                )}
            </div>
        </nav>
    )
}

export default Navbar
