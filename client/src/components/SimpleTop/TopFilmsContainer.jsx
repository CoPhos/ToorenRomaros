import React, {Fragment} from 'react'
import TittleCard from '../cards/tittle/TittleCard';
import {Link} from 'react-router-dom'

function TopFilmsContainer({tittle, to, linkText, data}) {
  return (
      <div className='ml-1'>
          <TittleCard tittle={tittle} to={to} linkText={linkText}></TittleCard>
          <ul className="p-0 w-full">
              {Object.values(Object.values(data)).map((value, index) => {
                  return (
                      <Fragment key={index.toString()}>
                          <li
                              className=" list-none p-0 m-0 w-full border-b-[1px]
                                border-white-200 h-[54px]"
                          >
                              <Link
                                  to={`/film/${value.id}`}
                                  className="flex flex-row items-center justify-between h-full group"
                              >
                                  <p className="grow-[3] max-w-full overflow-hidden text-ellipsis line-clamp-1 break-words text-small-m-400 lg:text-small-d-400 group-hover:cursor-pointer group-hover:text-red-600">
                                      {value.tittle}
                                  </p>
                                  <div className="flex flex-row items-center justify-end">
                                      <div className="flex flex-row items-center justify-start w-[56px] gap-0.5 group-hover:cursor-pointer group-hover:text-red-600">
                                          <svg
                                              width="17"
                                              height="17"
                                              viewBox="0 0 17 17"
                                              fill="none"
                                              xmlns="http://www.w3.org/2000/svg"
                                          >
                                              <path
                                                  d="M16.9996 8.51056H0.913086V17.0005H16.9996V8.51056Z"
                                                  fill="#F1543F"
                                              />
                                              <path
                                                  d="M8.95908 10.0029C7.4981 10.0029 6.30322 11.1927 6.30322 12.659C6.30322 14.1253 7.49288 15.315 8.95908 15.315C10.4201 15.315 11.6149 14.1253 11.6149 12.659C11.6149 11.1927 10.4201 10.0029 8.95908 10.0029Z"
                                                  fill="white"
                                              />
                                              <path
                                                  d="M8.09326 11.0204V14.3704L10.5665 12.6954L8.09326 11.0204Z"
                                                  fill="#324A5E"
                                              />
                                              <path
                                                  d="M0.626511 2.90674L0.511719 2.98501L0.929143 5.80282L4.3155 5.29144L0.689124 2.94327L0.626511 2.90674Z"
                                                  fill="#324A5E"
                                              />
                                              <path
                                                  d="M2.92773 2.54145L6.54889 4.95224L9.38738 4.52435L5.73491 2.11877L2.92773 2.54145Z"
                                                  fill="#324A5E"
                                              />
                                              <path
                                                  d="M7.98389 1.77442L11.6259 4.18521L14.4644 3.7521L10.7806 1.35175L7.98389 1.77442Z"
                                                  fill="#324A5E"
                                              />
                                              <path
                                                  d="M16.4105 0.50116L13.0972 1.0021L16.6401 3.37637L16.7183 3.40768L16.8279 3.31897L16.4105 0.50116Z"
                                                  fill="#324A5E"
                                              />
                                              <path
                                                  d="M5.43701 2.16043L9.08948 4.56601L11.9227 4.13812L8.28072 1.73254L5.43701 2.16043Z"
                                                  fill="white"
                                              />
                                              <path
                                                  d="M0.500977 2.91196L0.527066 3.07894L4.01256 5.33841L6.84583 4.9053L3.22467 2.49451L0.500977 2.91196Z"
                                                  fill="white"
                                              />
                                              <path
                                                  d="M16.7076 3.17802L13.3943 0.955078L10.4775 1.39862L14.1613 3.79898L16.7285 3.41283L16.8015 3.39718L16.8328 3.25629L16.7076 3.17802Z"
                                                  fill="white"
                                              />
                                              <path
                                                  d="M4.12744 5.68774L4.15875 5.65643L4.12744 5.68774Z"
                                                  stroke="#231F20"
                                                  stroke-miterlimit="10"
                                              />
                                              <path
                                                  d="M16.9948 5.65643L16.8696 5.60425L13.5771 8.51077H17V5.72948L16.9948 5.65643Z"
                                                  fill="#324A5E"
                                              />
                                              <path
                                                  d="M0.913086 5.58344V8.36994C0.913086 8.4169 0.939175 8.45864 0.986135 8.47952L1.0644 8.50561L4.39858 5.58865H0.913086V5.58344Z"
                                                  fill="#324A5E"
                                              />
                                              <path
                                                  d="M11.777 5.58344L8.44287 8.51083H11.3179L14.6155 5.58344H11.777Z"
                                                  fill="#324A5E"
                                              />
                                              <path
                                                  d="M6.66364 5.58344L3.30859 8.51083H6.1836L9.523 5.58344H6.66364Z"
                                                  fill="#324A5E"
                                              />
                                              <path
                                                  d="M4.08551 5.58344L0.954828 8.32819L0.913086 8.36472V8.51083H3.56895L6.97617 5.58344H4.08551Z"
                                                  fill="white"
                                              />
                                              <path
                                                  d="M14.3074 5.58344L11.0098 8.51083H13.8848L16.9998 5.75563V5.58344H14.3074Z"
                                                  fill="white"
                                              />
                                              <path
                                                  d="M9.21537 5.58344L5.87598 8.51083H8.75099L12.0852 5.58344H9.21537Z"
                                                  fill="white"
                                              />
                                          </svg>

                                          <p className="text-small-m-400 lg:text-small-d-400 ">
                                              {value.averageUserRating
                                                  ? value.averageUserRating +
                                                    '%'
                                                  : '--'}
                                          </p>
                                      </div>
                                  </div>
                              </Link>
                          </li>
                      </Fragment>
                  )
              })}
          </ul>
      </div>
  )
}

export default TopFilmsContainer