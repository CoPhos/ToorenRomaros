import React from 'react'
import { Link } from 'react-router-dom'

function TittleCard({tittle, to, linkText, mt}) {
  return (
      <div
          className={`flex flex-row w-full items-center justify-between border-solid border-l-4
                 border-red-600   ${mt ? mt : 'mt-4'}`}
      >
          <p className="uppercase text-body-m-700 lg:text-body-d-700 ml-1">
              {tittle}
          </p>
          {to ? (
              <Link
                  to={to}
                  className="hover:cursor-pointer text-blue-700 hover:text-blue-900 "
              >
                  {linkText}
              </Link>
          ) : null}
      </div>
  )
}

export default TittleCard