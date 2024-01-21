import React from 'react'
import TittleCard from '../cards/tittle/TittleCard'
import Info from '../cards/filmData/Info'
import CastContainer from '../cards/filmData/CastContainer';
import WhereToWatch from '../cards/filmData/WhereToWatch';

function FilmDetailsContainer({
    data,
    staff,
    genre,
    streamSites,
}) {    console.log(streamSites)
 
    return (
        <div className="flex flex-col items-start justify-center ml-1">
            <TittleCard
                tittle={'Movie Info'}
                to={null}
                linkText={''}
            ></TittleCard>
            <Info data={data} staff={staff} genre={genre}></Info>

            <TittleCard
                tittle={'CAST & CREW'}
                to={null}
                linkText={''}
            ></TittleCard>
            <CastContainer staff={staff}></CastContainer>
            <TittleCard
                tittle={'WHERE TO WATCH'}
                to={null}
                linkText={''}
            ></TittleCard>
            <div className="flex flex-row items-center justify-start flex-wrap gap-2 mt-2">
                {streamSites.map((item) => {
                    return (
                        <WhereToWatch key={item.id} data={item}></WhereToWatch>
                    )
                })}
            </div>
        </div>
    )
}

export default FilmDetailsContainer