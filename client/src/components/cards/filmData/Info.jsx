import React, { Fragment } from 'react'

function Info({ movieInfo }) {
    return (
        <Fragment>
            <div className="mt-2">
                <p className="text-small-m-400 lg:text-small-d-400">
                    {movieInfo.summary}
                </p>
            </div>
            <div className="flex flex-row items-center justify-start">
                <p className="text-small-m-700 lg:text-small-d-700">Rating:</p>
                &nbsp;
                <p className="text-small-m-400 lg:text-small-d-400">
                    {movieInfo.Rating}
                </p>
            </div>
            <div className="flex flex-row items-center justify-start">
                <p className="text-small-m-700 lg:text-small-d-700">Genre:</p>
                &nbsp;
                {movieInfo.Genre.map((element, index) => (
                    <p
                        key={element}
                        className="text-small-m-400 lg:text-small-d-400"
                    >
                        {element}
                        {index < movieInfo.Genre.length - 1 && ','}&nbsp;
                    </p>
                ))}
            </div>
            <div className="flex flex-row items-center justify-start">
                <p className="text-small-m-700 lg:text-small-d-700">
                    Original Language:
                </p>
                &nbsp;
                <p className="text-small-m-400 lg:text-small-d-400">
                    {movieInfo.OriginalLanguage}
                </p>
            </div>
            <div className="flex flex-row items-center justify-start">
                <p className="text-small-m-700 lg:text-small-d-700">
                    Director:
                </p>
                &nbsp;
                <p className="text-small-m-400 lg:text-small-d-400">
                    {movieInfo.Director}
                </p>
            </div>
            <div className="flex flex-row items-center justify-start">
                <p className="text-small-m-700 lg:text-small-d-700">
                    Producer:
                </p>
                &nbsp;
                {movieInfo.Producer.map((element, index) => (
                    <p
                        key={element}
                        className="text-small-m-400 lg:text-small-d-400"
                    >
                        {element}
                        {index < movieInfo.Producer.length - 1 && ','}&nbsp;
                    </p>
                ))}
            </div>
            <div className="flex flex-row items-center justify-start">
                <p className="text-small-m-700 lg:text-small-d-700">Writer:</p>
                &nbsp;
                {movieInfo.Writer.map((element, index) => (
                    <p
                        key={element}
                        className="text-small-m-400 lg:text-small-d-400"
                    >
                        {element}
                        {index < movieInfo.Writer.length - 1 && ','}&nbsp;
                    </p>
                ))}
            </div>
            <div className="flex flex-row items-center justify-start">
                <p className="text-small-m-700 lg:text-small-d-700">
                    Release Date (Theaters):
                </p>
                &nbsp;
                <p className="text-small-m-400 lg:text-small-d-400">
                    {movieInfo.ReleaseDateTheaters}
                </p>
            </div>
            <div className="flex flex-row items-center justify-start">
                <p className="text-small-m-700 lg:text-small-d-700">Runtime:</p>
                &nbsp;
                <p className="text-small-m-400 lg:text-small-d-400">
                    {movieInfo.Runtime}
                </p>
            </div>
            <div className="flex flex-row items-center justify-start">
                <p className="text-small-m-700 lg:text-small-d-700">
                    Distributor:
                </p>
                &nbsp;
                <p className="text-small-m-400 lg:text-small-d-400">
                    {movieInfo.Distributor}
                </p>
            </div>
            <div className="flex flex-row items-center justify-start">
                <p className="text-small-m-700 lg:text-small-d-700">
                    Production Co:
                </p>
                &nbsp;
                <p className="text-small-m-400 lg:text-small-d-400">
                    {movieInfo.ProductionCo}
                </p>
            </div>
            <div className="flex flex-row items-center justify-start">
                <p className="text-small-m-700 lg:text-small-d-700">
                    SoundMix:
                </p>
                &nbsp;
                <p className="text-small-m-400 lg:text-small-d-400">
                    {movieInfo.SoundMix}
                </p>
            </div>
            <div className="flex flex-row items-center justify-start">
                <p className="text-small-m-700 lg:text-small-d-700">
                    Aspect Ratio:
                </p>
                &nbsp;
                <p className="text-small-m-400 lg:text-small-d-400">
                    {movieInfo.AspectRatio}
                </p>
            </div>
        </Fragment>
    )
}

export default Info