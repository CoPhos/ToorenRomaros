import React, { useState, useEffect, Fragment, useRef } from 'react'
import {Link} from 'react-router-dom'
import { useLocation } from 'react-router-dom'

import WhereToWatch from '../cards/filmData/WhereToWatch';
import MovieCard from '../cards/movieCard/MovieCard';
import SortPanel from '../cards/browse/SortPanel';
import CheckboxPanel from '../cards/browse/CheckboxPanel';

function BrowseContainer({
    handleSubmit,
    handleCheckboxChange,
    handleRadioChange,
    selectedRadio,
    checkedCheckboxes,
    handleResetClick,
}) {
    const [showSort, setshowSort] = useState(false)
    const [showGenre, setshowGenre] = useState(false)
    const [showRating, setshowRating] = useState(false)

    const [openPanels, setOpenPanels] = useState([])

    const handleButtonClick = (panelKey, event) => {
        event.preventDefault() 
        setOpenPanels((prev) => [...prev, panelKey])
    }

    const handlePanelClose = (panelKey) => {
        setOpenPanels((prev) => prev.filter((panel) => panel !== panelKey))
    }

    const isPanelOpen = (panelKey) => openPanels.includes(panelKey)

    const location = useLocation()
    const params = new URLSearchParams(location.search)
    const pathnameArray = location.pathname.split('/')
    const genre = params.get('genre') || 'all'
    const type = pathnameArray[pathnameArray.length - 1]
    const sort = params.get('sort') || 'default'

    const baseClassesLink = 'flex flex-row items-center justify-center h-[48px]'
    const selectedClassesLink = 'border-b-[2px] border-white-500'
    const notSelectedClassesLink = 'text-white-400 border-none'

    const genres = [
        'action',
        'adventure',
        'comedy',
        'thriller',
        
    ]
    const ratings = ['G', 'PG', 'PG-13', 'NC-17']

    return (
        <Fragment>
            <p className="text-h3-m-700 lg:text-h3-d-700 mt-2">
                TV Shows (December 2023)
            </p>
            <p>Genre: {genre}</p>
            <p>Type: {type}</p>
            <p>Sort: {sort}</p>

            <div className="flex flex-row items-center justify-start gap-3 overflow-x-scroll lg:overflow-x-hidden mt-2 border-b border-white-300">
                <div
                    className={`${baseClassesLink} ${
                        type == 'theaters'
                            ? selectedClassesLink
                            : notSelectedClassesLink
                    }`}
                >
                    <Link
                        to="/browse/theaters"
                        className={
                            'text-small-m-400 lg:text-small-d-400 whitespace-nowrap'
                        }
                    >
                        In Theaters
                    </Link>
                </div>
                <div
                    className={`${baseClassesLink} ${
                        type == 'atHome'
                            ? selectedClassesLink
                            : notSelectedClassesLink
                    }`}
                >
                    <Link
                        to="/browse/atHome"
                        className="text-small-m-400 lg:text-small-d-400 whitespace-nowrap"
                    >
                        At home
                    </Link>
                </div>
                <div
                    className={`${baseClassesLink} ${
                        type == 'cooming'
                            ? selectedClassesLink
                            : notSelectedClassesLink
                    }`}
                >
                    <Link
                        to="/browse/cooming"
                        className="text-small-m-400 lg:text-small-d-400 whitespace-nowrap"
                    >
                        Cooming Soon
                    </Link>
                </div>
                <div
                    className={`${baseClassesLink} ${
                        type == 'tv'
                            ? selectedClassesLink
                            : notSelectedClassesLink
                    }`}
                >
                    <Link
                        to="/browse/tv"
                        className="text-small-m-400 lg:text-small-d-400 whitespace-nowrap"
                    >
                        TV Shows
                    </Link>
                </div>
            </div>

            <div className="flex flex-row items-center justify-start gap-2 mt-2 md:relative flex-wrap">
                <div className="">
                    <div
                        onClick={(event) => handleButtonClick('sort', event)}
                        className="flex flex-row items-center justify-start gap-1 px-2 py-[4px] border border-white-300 rounded-[18px] hover:cursor-pointer"
                    >
                        <button className="text-small-m-400 lg:text-small-d-400 text-white-700 uppercase">
                            Sort
                        </button>
                        <svg
                            width="10"
                            height="10"
                            viewBox="0 0 10 10"
                            fill="none"
                            className=""
                            xmlns="http://www.w3.org/2000/svg"
                        >
                            <path
                                d="M10 2.8248V2.87734C9.98659 3.06601 9.91836 3.22187 9.79531 3.34491C8.39258 4.74817 6.99818 6.14257 5.61211 7.52812C5.49883 7.6414 5.41575 7.71425 5.36289 7.74667C5.14492 7.88026 4.86797 7.88124 4.64609 7.75234C4.59232 7.72109 4.50462 7.64472 4.38301 7.52323C2.98848 6.12922 1.59421 4.73495 0.200195 3.34042C0.0796224 3.21972 0.0128906 3.06457 0 2.87499V2.82226C0.00976562 2.68411 0.0473958 2.56711 0.112891 2.47128C0.252344 2.26698 0.444857 2.16067 0.69043 2.15234C0.811263 2.1483 0.929688 2.17844 1.0457 2.24276C1.10299 2.27454 1.1776 2.33638 1.26953 2.42831C2.49154 3.65175 3.73359 4.894 4.9957 6.15507C4.99857 6.15793 5.0015 6.15793 5.00449 6.15507C6.2748 4.88476 7.53776 3.6218 8.79336 2.3662C9.06953 2.09023 9.50273 2.08026 9.7832 2.34589C9.91484 2.4705 9.98711 2.63013 10 2.8248Z"
                                fill="black"
                            />
                        </svg>
                    </div>
                    <SortPanel
                        handleRadioChange={handleRadioChange}
                        selectedRadio={selectedRadio}
                        panelKey="sort"
                        isOpen={isPanelOpen('sort')}
                        isPanelOpen={isPanelOpen}
                        onClose={handlePanelClose}
                    ></SortPanel>
                </div>

                <div className="">
                    <div
                        onClick={(event) => handleButtonClick('genre', event)}
                        className="flex flex-row items-center justify-start gap-1 px-2 py-[4px] border border-white-300 rounded-[18px] hover:cursor-pointer"
                    >
                        <button className="text-small-m-400 lg:text-small-d-400 text-white-700 uppercase">
                            Genre
                        </button>
                        <svg
                            width="10"
                            height="10"
                            viewBox="0 0 10 10"
                            fill="none"
                            xmlns="http://www.w3.org/2000/svg"
                        >
                            <path
                                d="M10 2.8248V2.87734C9.98659 3.06601 9.91836 3.22187 9.79531 3.34491C8.39258 4.74817 6.99818 6.14257 5.61211 7.52812C5.49883 7.6414 5.41575 7.71425 5.36289 7.74667C5.14492 7.88026 4.86797 7.88124 4.64609 7.75234C4.59232 7.72109 4.50462 7.64472 4.38301 7.52323C2.98848 6.12922 1.59421 4.73495 0.200195 3.34042C0.0796224 3.21972 0.0128906 3.06457 0 2.87499V2.82226C0.00976562 2.68411 0.0473958 2.56711 0.112891 2.47128C0.252344 2.26698 0.444857 2.16067 0.69043 2.15234C0.811263 2.1483 0.929688 2.17844 1.0457 2.24276C1.10299 2.27454 1.1776 2.33638 1.26953 2.42831C2.49154 3.65175 3.73359 4.894 4.9957 6.15507C4.99857 6.15793 5.0015 6.15793 5.00449 6.15507C6.2748 4.88476 7.53776 3.6218 8.79336 2.3662C9.06953 2.09023 9.50273 2.08026 9.7832 2.34589C9.91484 2.4705 9.98711 2.63013 10 2.8248Z"
                                fill="black"
                            />
                        </svg>
                    </div>
                    <CheckboxPanel
                        tittle={'Genre'}
                        panelKey="genre"
                        isOpen={isPanelOpen('genre')}
                        isPanelOpen={isPanelOpen}
                        onClose={handlePanelClose}
                        handleCheckboxChange={handleCheckboxChange}
                        checkedCheckboxes={checkedCheckboxes}
                        elements={genres}
                        handleResetClick={handleResetClick}
                    ></CheckboxPanel>
                </div>

                <div className="">
                    <div
                        onClick={(event) => handleButtonClick('rating', event)}
                        className="flex flex-row items-center justify-start gap-1 px-2 py-[4px] border border-white-300 rounded-[18px] hover:cursor-pointer"
                    >
                        <button className="text-small-m-400 lg:text-small-d-400 text-white-700 uppercase">
                            Rating
                        </button>
                        <svg
                            width="10"
                            height="10"
                            viewBox="0 0 10 10"
                            fill="none"
                            xmlns="http://www.w3.org/2000/svg"
                        >
                            <path
                                d="M10 2.8248V2.87734C9.98659 3.06601 9.91836 3.22187 9.79531 3.34491C8.39258 4.74817 6.99818 6.14257 5.61211 7.52812C5.49883 7.6414 5.41575 7.71425 5.36289 7.74667C5.14492 7.88026 4.86797 7.88124 4.64609 7.75234C4.59232 7.72109 4.50462 7.64472 4.38301 7.52323C2.98848 6.12922 1.59421 4.73495 0.200195 3.34042C0.0796224 3.21972 0.0128906 3.06457 0 2.87499V2.82226C0.00976562 2.68411 0.0473958 2.56711 0.112891 2.47128C0.252344 2.26698 0.444857 2.16067 0.69043 2.15234C0.811263 2.1483 0.929688 2.17844 1.0457 2.24276C1.10299 2.27454 1.1776 2.33638 1.26953 2.42831C2.49154 3.65175 3.73359 4.894 4.9957 6.15507C4.99857 6.15793 5.0015 6.15793 5.00449 6.15507C6.2748 4.88476 7.53776 3.6218 8.79336 2.3662C9.06953 2.09023 9.50273 2.08026 9.7832 2.34589C9.91484 2.4705 9.98711 2.63013 10 2.8248Z"
                                fill="black"
                            />
                        </svg>
                    </div>
                    <CheckboxPanel
                        tittle={'Rating'}
                        panelKey="rating"
                        isOpen={isPanelOpen('rating')}
                        isPanelOpen={isPanelOpen}
                        onClose={handlePanelClose}
                        handleCheckboxChange={handleCheckboxChange}
                        checkedCheckboxes={checkedCheckboxes}
                        elements={ratings}
                        handleResetClick={handleResetClick}
                    ></CheckboxPanel>
                </div>
            </div>

            <div className="flex flex-row items-center justify-start gap-3 overflow-x-scroll lg:overflow-x-hidden mt-2">
                <WhereToWatch blank={false}></WhereToWatch>
                <WhereToWatch blank={false}></WhereToWatch>
                <WhereToWatch blank={false}></WhereToWatch>
                <WhereToWatch blank={false}></WhereToWatch>
                <WhereToWatch blank={false}></WhereToWatch>
                <WhereToWatch blank={false}></WhereToWatch>
                <WhereToWatch blank={false}></WhereToWatch>
                <WhereToWatch blank={false}></WhereToWatch>
                <WhereToWatch blank={false}></WhereToWatch>
            </div>

            <Link
                to="browse"
                className="text-small-m-300 lg:text-small-d-300 text-blue-800 hover:cursor-pointer hover:text-blue-600"
            >
                Reset Filters
            </Link>

            <div className="flex flex-row items-center justify-around gap-2 flex-wrap mt-2">
                <MovieCard></MovieCard>
                <MovieCard></MovieCard>
                <MovieCard></MovieCard>
                <MovieCard></MovieCard>
                <MovieCard></MovieCard>
                <MovieCard></MovieCard>
                <MovieCard></MovieCard>
                <MovieCard></MovieCard>
                <MovieCard></MovieCard>
                <MovieCard></MovieCard>
                <MovieCard></MovieCard>
                <MovieCard></MovieCard>
                <MovieCard></MovieCard>
                <MovieCard></MovieCard>
                <MovieCard></MovieCard>
                <MovieCard></MovieCard>
                <MovieCard></MovieCard>
                <MovieCard></MovieCard>
                <MovieCard></MovieCard>
                <MovieCard></MovieCard>
                <MovieCard></MovieCard>
                <MovieCard></MovieCard>
                <MovieCard></MovieCard>
            </div>
            <div className="flex flex-row items-center justify-center w-full">
                <button className="px-2 mt-2 rounded bg-red-600 py-1 h-full hover:cursor-pointer hover:opacity-50 text-white-50 text-small-m-400 lg:text-small-d-400">
                    Load More
                </button>
            </div>
        </Fragment>
    )
}

export default BrowseContainer