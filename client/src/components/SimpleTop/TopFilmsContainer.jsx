import React, {Fragment} from 'react'
import TittleCard from '../cards/tittle/TittleCard';

function TopFilmsContainer({tittle, to, linkText, data}) {
  return (
      <div>
          <TittleCard tittle={tittle} to={to} linkText={linkText}></TittleCard>
          <ul className="p-0 w-full">
              {Object.values(Object.values(data)).map((value, index) => {
                  return (
                      <Fragment key={index.toString()}>
                          <li>

                          </li>
                      </Fragment>
                  )
              })}
          </ul>
      </div>
      //   padding: 0; flex flex-row items-center justify-between list-none
      // width: 100%;
      // li {
      //     display: flex;
      //     flex-direction: row;
      //     align-items: center;
      //     justify-content: space-between;
      //     list-style-type: none;
      //     padding: 0;
      //     margin: 0;
      //     width: 100%;
      //     border-bottom: 1px solid ${(props) => props.theme.colors.line};
      //     .movieRtng {
      //         max-width: 282px;
      //         overflow: hidden;
      //         text-overflow: ellipsis;
      //         display: -webkit-box;
      //         -webkit-line-clamp: 1;
      //         -webkit-box-orient: vertical;
      //         overflow: hidden;
      //     }
      // }
      // li:hover,
      // li:focus {
      //     cursor: pointer;
      //     p {
      //         color: ${(props) => props.theme.colors.hyperlinks};
      //     }
      // }
  )
}

export default TopFilmsContainer