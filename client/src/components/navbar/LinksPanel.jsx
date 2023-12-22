import React from 'react'
import {Link} from 'react-router-dom'

function LinksPanel({data, tittle1, tittle2}) {
  return (
      <div className="flex flex-row items-start justify-between py-2 px-1 w-full">
          <div className="flex flex-col items-start justify-start gap-1 grow h-full border-r border-white-600 px-2">
              <p className="text-h3-d-700 whitespace-nowrap mb-2">{tittle1}</p>
              {data.explore.map((value, index) => (
                  <Link
                      to="/adads"
                      key={value}
                      className="text-small-d-400 text-white-500 hover:cursor-pointer hover:text-blue-800 whitespace-nowrap"
                  >
                      {value}
                  </Link>
              ))}
              <Link
                  to="/asdasd"
                  className="text-small-d-700 hover:cursor-pointer hover:text-blue-800 whitespace-nowrap"
              >
                  See all
              </Link>
          </div>
          <div className="flex flex-col items-start justify-start gap-1 grow h-full pr-2 pl-3">
              <p className="text-h3-d-700 whitespace-nowrap mb-2">{tittle2}</p>
              {Object.entries(data.movies).map(([key, value]) => {
                  return (
                      <Link
                          to="/adads"
                          key={value}
                          className="text-small-d-400 text-white-500 hover:cursor-pointer hover:text-blue-800 whitespace-nowrap"
                      >
                          {value}
                      </Link>
                  )
              })}
              <Link
                  to="/asdasd"
                  className="text-small-d-700 hover:cursor-pointer hover:text-blue-800 whitespace-nowrap"
              >
                  See all
              </Link>
          </div>
      </div>
  )
}

export default LinksPanel