import React, { Fragment } from 'react'

function Info({ data, staff, genre }) {
    const director = staff.filter((staff) => staff.director === 'Director')
    const screenwriter = staff.filter((staff) => staff.director === 'Screenwriter')
    const producer = staff.filter((staff) => staff.director === 'Producer')
    return (
        <Fragment>
            <div className="mt-2">
                <p className="text-small-m-400 lg:text-small-d-400">
                    {data.synopsis}
                </p>
            </div>
            <div className="flex flex-row items-center justify-start">
                <p className="text-small-m-700 lg:text-small-d-700">Rating:</p>
                &nbsp;
                <p className="text-small-m-400 lg:text-small-d-400">
                    {data.suitableFor}
                </p>
            </div>
            <div className="flex flex-row items-center justify-start">
                <p className="text-small-m-700 lg:text-small-d-700">Genre:</p>
                &nbsp;
                {genre.map((element, index) => (
                    <p
                        key={element.id}
                        className="text-small-m-400 lg:text-small-d-400"
                    >
                        {element.genre}
                        {index < genre.length - 1 && ','}&nbsp;
                    </p>
                ))}
            </div>
            <div className="flex flex-row items-center justify-start">
                <p className="text-small-m-700 lg:text-small-d-700">
                    Original Language:
                </p>
                &nbsp;
                <p className="text-small-m-400 lg:text-small-d-400">
                    {data.originalLanguage}
                </p>
            </div>
            {director !== null &&
            director !== undefined &&
            Object.keys(director).length > 0 ? (
                <div className="flex flex-row items-center justify-start">
                    <p className="text-small-m-700 lg:text-small-d-700">
                        Director:
                    </p>
                    &nbsp;
                    {Object.entries(director).forEach(
                        ([key, value], index, array) => {
                            return (
                                <p
                                    key={value}
                                    className="text-small-m-400 lg:text-small-d-400"
                                >
                                    {value}
                                    {index < array.length - 1 && ','}&nbsp;
                                </p>
                            )
                        }
                    )}
                </div>
            ) : (
                ''
            )}
            {producer !== null &&
            producer !== undefined &&
            Object.keys(producer).length > 0 ? (
                <div className="flex flex-row items-center justify-start">
                    <p className="text-small-m-700 lg:text-small-d-700">
                        Producer:
                    </p>
                    &nbsp;
                    {Object.entries(producer).forEach(
                        ([key, value], index, array) => {
                            return (
                                <p
                                    key={value}
                                    className="text-small-m-400 lg:text-small-d-400"
                                >
                                    {value}
                                    {index < array.length - 1 && ','}&nbsp;
                                </p>
                            )
                        }
                    )}
                </div>
            ) : (
                ''
            )}
            {screenwriter !== null &&
            screenwriter !== undefined &&
            Object.keys(screenwriter).length > 0 ? (
                <div className="flex flex-row items-center justify-start">
                    <p className="text-small-m-700 lg:text-small-d-700">
                        Writer:
                    </p>
                    &nbsp;
                    {Object.entries(screenwriter).forEach(
                        ([key, value], index, array) => {
                            return (
                                <p className="text-small-m-400 lg:text-small-d-400">
                                    {value}
                                    {index < array.length - 1 && ','}&nbsp;
                                </p>
                            )
                        }
                    )}
                </div>
            ) : (
                ''
            )}
            {data.theatersReleaseDate ? (
                <div className="flex flex-row items-center justify-start">
                    <p className="text-small-m-700 lg:text-small-d-700">
                        Release Date (Theaters):
                    </p>
                    &nbsp;
                    <p className="text-small-m-400 lg:text-small-d-400">
                        {data.theatersReleaseDate}
                    </p>
                </div>
            ) : (
                ''
            )}
            {data.streamingReleaseDate ? (
                <div className="flex flex-row items-center justify-start">
                    <p className="text-small-m-700 lg:text-small-d-700">
                        Release Date (Streaming):
                    </p>
                    &nbsp;
                    <p className="text-small-m-400 lg:text-small-d-400">
                        {data.streamingReleaseDate}
                    </p>
                </div>
            ) : (
                ''
            )}
            {data.runTime ? (
                <div className="flex flex-row items-center justify-start">
                    <p className="text-small-m-700 lg:text-small-d-700">
                        Runtime:
                    </p>
                    &nbsp;
                    <p className="text-small-m-400 lg:text-small-d-400">
                        {data.runTime}
                    </p>
                </div>
            ) : (
                ''
            )}
            <div className="flex flex-row items-center justify-start">
                <p className="text-small-m-700 lg:text-small-d-700">
                    Distributor:
                </p>
                &nbsp;
                <p className="text-small-m-400 lg:text-small-d-400">
                    {data.distributor}
                </p>
            </div>
            {data.boxOffice ? (
                <div className="flex flex-row items-center justify-start">
                    <p className="text-small-m-700 lg:text-small-d-700">
                        Box Office:
                    </p>
                    &nbsp;
                    <p className="text-small-m-400 lg:text-small-d-400">
                        ${parseInt(data.boxOffice, 10).toLocaleString('en-US')}
                    </p>
                </div>
            ) : (
                ''
            )}
            <div className="flex flex-row items-center justify-start">
                <p className="text-small-m-700 lg:text-small-d-700">
                    SoundMix:
                </p>
                &nbsp;
                <p className="text-small-m-400 lg:text-small-d-400">
                    {data.soundMix}
                </p>
            </div>
            <div className="flex flex-row items-center justify-start">
                <p className="text-small-m-700 lg:text-small-d-700">
                    Aspect Ratio:
                </p>
                &nbsp;
                <p className="text-small-m-400 lg:text-small-d-400">
                    {data.aspectRatio}
                </p>
            </div>
        </Fragment>
    )
}

export default Info
