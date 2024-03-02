import React, { useState, useEffect, Fragment } from 'react'
import { Link } from 'react-router-dom'
import MovieCard from '../cards/movieCard/MovieCard'
import SortPanel from '../cards/browse/SortPanel'
import CheckboxPanel from '../cards/browse/CheckboxPanel'

function BrowseContainer({
    handleCheckboxChange,
    checkedCheckboxes,
    generateUrl,
    at,
    sortBy,
    filmType,
    genre,
    rating,
    streaming,
    resetCheckboxGroup,
    filmData,
    fetchNextPage,
    isFetchingNextPage,
    hasNextPage,
    handleAddWatchList,
}) {
    const [openPanels, setOpenPanels] = useState([])

    const handleButtonClick = (panelKey, event) => {
        event.preventDefault()
        setOpenPanels((prev) => [...prev, panelKey])
    }

    const handlePanelClose = (panelKey) => {
        setOpenPanels((prev) => prev.filter((panel) => panel !== panelKey))
    }

    const isPanelOpen = (panelKey) => openPanels.includes(panelKey)

    const baseClassesLink = 'flex flex-row items-center justify-center h-[48px]'
    const selectedClassesLink = 'border-b-[2px] border-white-500'
    const notSelectedClassesLink = 'text-white-400 border-none'

    const genres = {
        0: { tittle: 'Romance', data: 'Romance' },
        1: { tittle: 'Horror', data: 'Horror' },
        2: { tittle: 'News', data: 'News' },
        3: { tittle: 'Action', data: 'Action' },
        4: { tittle: 'History', data: 'History' },
        5: { tittle: 'Animation', data: 'Animation' },
        6: { tittle: 'Sci-fi', data: 'Sci-fi' },
        7: { tittle: 'War', data: 'War' },
        8: { tittle: 'Drama', data: 'Drama' },
        9: { tittle: 'Fantasy', data: 'Fantasy' },
        10: { tittle: 'Crime', data: 'Crime' },
        11: { tittle: 'Comedy', data: 'Comedy' },
        12: { tittle: 'Sports', data: 'Sports' },
        13: { tittle: 'Stand up', data: 'Stand up' },
        14: { tittle: 'Adventure', data: 'Adventure' },
        15: { tittle: 'Entertainment', data: 'Entertainment' },
    }
    const ratings = {
        0: { tittle: 'PG-13', data: 'PG-13' },
        1: { tittle: 'PG-18', data: 'PG-18' },
        2: { tittle: 'R', data: 'R' },
        3: { tittle: 'G', data: 'G' },
        4: { tittle: 'PG', data: 'PG' },
    }
    const streamPlatform = {
        0: { tittle: 'Netflix', data: 'Netflix' },
        1: { tittle: 'Hulu', data: 'Hulu' },
        2: { tittle: 'Apple TV+', data: 'Apple TV Plus' },
        3: { tittle: 'Disney+', data: 'Disney Plus' },
        4: { tittle: 'Amazon Prime Video', data: 'Amazon Prime Video' },
        5: { tittle: 'HBO Max', data: 'HBO Max' },
    }
    const sortRadioButtonData = {
        0: { text: 'Most Popular', value: 'view_count-Desc' },
        1: { text: 'Newest', value: 'added_date-Desc' },
        2: { text: 'Top Box Office', value: 'box_office-Desc' },
        3: { text: 'Alphabetical', value: 'tittle-Asc' },
        4: {
            text: 'Critic Rating (Highest)',
            value: 'average_super_rating-Desc',
        },
        5: {
            text: 'Critic Rating (Lowest)',
            value: 'average_super_rating-Asc',
        },
        6: {
            text: 'Audience Score (Highest)',
            value: 'average_user_rating-Desc',
        },
        7: {
            text: 'Audience Score (Lowest)',
            value: 'average_user_rating-Asc',
        },
    }
    const filmTypeRadioButtonData = {
        0: { text: 'All', value: 'all' },
        1: { text: 'Movies', value: '1' },
        2: { text: 'TV Shows', value: '2' },
    }
    useEffect(() => {
        const handleScroll = () => {
            const { scrollTop, scrollHeight, clientHeight } =
                document.documentElement
            if (
                scrollHeight - scrollTop === clientHeight &&
                hasNextPage &&
                !isFetchingNextPage
            ) {
                fetchNextPage()
            }
        }

        window.addEventListener('scroll', handleScroll)

        return () => {
            window.removeEventListener('scroll', handleScroll)
        }
    }, [hasNextPage, isFetchingNextPage, fetchNextPage])

    return (
        <Fragment>
            <p className="text-h3-m-700 lg:text-h3-d-700 mt-2">
                TV Shows (December 2023)
            </p>

            <div className="flex flex-row items-center justify-start gap-3 overflow-x-scroll min-[420px]:overflow-x-hidden mt-2 border-b border-white-300">
                <div
                    className={`${baseClassesLink} ${
                        at == 'theaters'
                            ? selectedClassesLink
                            : notSelectedClassesLink
                    }`}
                >
                    <Link
                        onClick={(event) => {
                            resetCheckboxGroup(event, 'genre')
                            resetCheckboxGroup(event, 'rating')
                            resetCheckboxGroup(event, 'streaming')
                        }}
                        to={{
                            search: generateUrl('reset', 'theaters', ''),
                        }}
                        className={
                            'text-small-m-400 lg:text-small-d-400 whitespace-nowrap'
                        }
                    >
                        In Theaters
                    </Link>
                </div>
                <div
                    className={`${baseClassesLink} ${
                        at == 'home'
                            ? selectedClassesLink
                            : notSelectedClassesLink
                    }`}
                >
                    <Link
                        onClick={(event) => {
                            resetCheckboxGroup(event, 'genre')
                            resetCheckboxGroup(event, 'rating')
                            resetCheckboxGroup(event, 'streaming')
                        }}
                        to={{
                            search: generateUrl('reset', 'home', 'all'),
                        }}
                        className="text-small-m-400 lg:text-small-d-400 whitespace-nowrap"
                    >
                        At home
                    </Link>
                </div>
                <div
                    className={`${baseClassesLink} ${
                        at == 'upcoming'
                            ? selectedClassesLink
                            : notSelectedClassesLink
                    }`}
                >
                    <Link
                        onClick={(event) => {
                            resetCheckboxGroup(event, 'genre')
                            resetCheckboxGroup(event, 'rating')
                            resetCheckboxGroup(event, 'streaming')
                        }}
                        to={{
                            search: generateUrl('reset', 'upcoming', 'all'),
                        }}
                        className="text-small-m-400 lg:text-small-d-400 whitespace-nowrap"
                    >
                        Cooming Soon
                    </Link>
                </div>
                <div
                    className={`${baseClassesLink} ${
                        at == 'tv'
                            ? selectedClassesLink
                            : notSelectedClassesLink
                    }`}
                >
                    <Link
                        onClick={(event) => {
                            resetCheckboxGroup(event, 'genre')
                            resetCheckboxGroup(event, 'rating')
                            resetCheckboxGroup(event, 'streaming')
                        }}
                        to={{
                            search: generateUrl('reset', 'tv', ''),
                        }}
                        className="text-small-m-400 lg:text-small-d-400 whitespace-nowrap"
                    >
                        TV Shows
                    </Link>
                </div>
            </div>

            <div className="flex flex-row items-center justify-start gap-2 mt-2 relative min-[665px]:static flex-wrap">
                <div className="static min-[665px]:relative">
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
                        tittle={'Sort'}
                        panelKey="sort"
                        isOpen={isPanelOpen('sort')}
                        isPanelOpen={isPanelOpen}
                        onClose={handlePanelClose}
                        sortRadioButtonData={sortRadioButtonData}
                        selectedValue={sortBy}
                        searchParamsName={'sortBy'}
                        generateUrl={generateUrl}
                    ></SortPanel>
                </div>

                {!(at == 'theaters' || at == 'tv') ? (
                    <div className="static min-[665px]:relative">
                        <div
                            onClick={(event) =>
                                handleButtonClick('filmType', event)
                            }
                            className="flex flex-row items-center justify-start gap-1 px-2 py-[4px] border border-white-300 rounded-[18px] hover:cursor-pointer"
                        >
                            <button className="text-small-m-400 lg:text-small-d-400 text-white-700 uppercase">
                                Film Type
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
                            tittle={'Film Type'}
                            panelKey="filmType"
                            isOpen={isPanelOpen('filmType')}
                            isPanelOpen={isPanelOpen}
                            onClose={handlePanelClose}
                            sortRadioButtonData={filmTypeRadioButtonData}
                            selectedValue={filmType}
                            searchParamsName={'filmType'}
                            generateUrl={generateUrl}
                        ></SortPanel>
                    </div>
                ) : (
                    ''
                )}

                <div className="static min-[665px]:relative">
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
                        elements={genres}
                        handleCheckboxChange={handleCheckboxChange}
                        checkedCheckboxes={checkedCheckboxes}
                        selectedValue={genre}
                        searchParamsName={'genre'}
                        generateUrl={generateUrl}
                        resetCheckboxGroup={resetCheckboxGroup}
                    ></CheckboxPanel>
                </div>

                <div className="static min-[665px]:relative">
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
                        elements={ratings}
                        handleCheckboxChange={handleCheckboxChange}
                        checkedCheckboxes={checkedCheckboxes}
                        selectedValue={rating}
                        searchParamsName={'rating'}
                        generateUrl={generateUrl}
                        resetCheckboxGroup={resetCheckboxGroup}
                    ></CheckboxPanel>
                </div>

                {at == 'home' ||
                at == 'streaming' ||
                at == 'upcoming' ||
                at == 'tv' ? (
                    <div className="static min-[665px]:relative">
                        <div
                            onClick={(event) =>
                                handleButtonClick('streaming', event)
                            }
                            className="flex flex-row items-center justify-start gap-1 px-2 py-[4px] border border-white-300 rounded-[18px] hover:cursor-pointer"
                        >
                            <button className="text-small-m-400 lg:text-small-d-400 text-white-700 uppercase">
                                Streaming
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
                            tittle={'Streaming'}
                            panelKey="streaming"
                            isOpen={isPanelOpen('streaming')}
                            isPanelOpen={isPanelOpen}
                            onClose={handlePanelClose}
                            elements={streamPlatform}
                            handleCheckboxChange={handleCheckboxChange}
                            checkedCheckboxes={checkedCheckboxes}
                            selectedValue={streaming}
                            searchParamsName={'streaming'}
                            generateUrl={generateUrl}
                            resetCheckboxGroup={resetCheckboxGroup}
                        ></CheckboxPanel>
                    </div>
                ) : (
                    ''
                )}
            </div>

            <Link
                onClick={(event) => {
                    resetCheckboxGroup(event, 'genre')
                    resetCheckboxGroup(event, 'rating')
                    resetCheckboxGroup(event, 'streaming')
                }}
                to="/browse?at=theaters"
                className="text-small-m-300 lg:text-small-d-300 text-blue-900 hover:cursor-pointer hover:text-blue-600"
            >
                Reset Filters
            </Link>

            <div className="flex flex-row items-center justify-start gap-2 flex-wrap mt-2">
                {filmData?.map((page, pageIndex) => (
                    <Fragment key={pageIndex}>
                        {page.data.response.map((item) => (
                            <MovieCard
                                key={item.id}
                                data={item}
                                id={item.id}
                                images={item.mainImageId}
                                handleAddWatchList={handleAddWatchList}
                            />
                        ))}
                    </Fragment>
                ))}
                {(!filmData ||
                    filmData.every(
                        (page) => page.data.response.length === 0
                    )) && <p>No data found</p>}
            </div>
        </Fragment>
    )
}

export default BrowseContainer
