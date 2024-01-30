import React from 'react'
import {Link} from 'react-router-dom'

function LinksPanel({ data, filmData, tittle1, tittle2 }) {
    return (
        <div className="flex flex-row items-start justify-between py-2 px-1 w-full">
            <div className="flex flex-col items-start justify-start gap-1 grow h-full border-r border-white-600 px-2">
                <p className="text-h3-d-700 whitespace-nowrap mb-2">
                    {tittle1}
                </p>
                {Object.entries(data).map(([key, value]) => (
                    <Link
                        to={value.to}
                        key={key}
                        className="text-small-d-400 text-white-500 hover:cursor-pointer hover:text-red-600 whitespace-nowrap"
                    >
                        {value.tittle}
                    </Link>
                ))}
                <Link
                    to={
                        tittle1 == 'Explore TV'
                            ? '/browse?at=home'
                            : '/browse?at=theaters'
                    }
                    className="text-small-d-700 hover:cursor-pointer hover:text-red-600 whitespace-nowrap"
                >
                    See all
                </Link>
            </div>
            <div className="flex flex-col items-start justify-start gap-1 grow h-full pr-2 pl-3">
                <p className="text-h3-d-700 whitespace-nowrap mb-2">
                    {tittle2}
                </p>
                {filmData.map(item =>{
                    return (
                        <Link
                            to={`/film/${item.id}`}
                            key={item.id}
                            className="text-small-d-400 text-white-500 hover:cursor-pointer hover:text-red-600 whitespace-nowrap"
                        >
                            {item.tittle}
                        </Link>
                    )
                })}
                <Link
                    to={
                        tittle1 == 'Explore TV'
                            ? '?at=upcoming&filmType=2'
                            : '?at=upcoming&filmType=1'
                    }
                    className="text-small-d-700 hover:cursor-pointer hover:text-red-600 whitespace-nowrap"
                >
                    See all
                </Link>
            </div>
        </div>
    )
}

export default LinksPanel