import React, { Fragment } from 'react'
import { useParams } from 'react-router-dom';
import axios from '../../utils/constants'

import FilmDetailsContainer from './FilmDetailsContainer'
import FilmMainInfoContainer from './FilmMainInfoContainer';
import { useQuery } from 'react-query';

function FilmManager() {
    const params = useParams()
    console.log(params.uuid)
    const FILM_URL = '/films'
    //movie critic consensus
    //total super and user ratings
    //ratings score

    const getFilm = useQuery({
        queryKey: ["getFilmById"],
        queryFn: async () => {
            try{
                return axios.get( FILM_URL + `/${params.uuid}`)
            }catch (error){
                return error
            }
        },
        onSuccess: (data) => {
            console.log(data?.data)
        },
        onError: (error) => {
            console.log(error)
        }

    })

    const getRatingFromFilm = useQuery({
        queryKey: ['getRatingByFilmIdAndRatingType'],
        queryFn: async () => {
            try {
                return axios.get(FILM_URL + `/${params.uuid}` + "/ratings")
            } catch (error) {
                return error
            }
        },
        onSuccess: (data) => {
            console.log(data?.data)
        },
        onError: (error) => {
            console.log(error)
        },
    })

    const movieInfo = {
        summary:
            "Based on the extraordinary character at the center of Charlie and the Chocolate Factory, Roald Dahl’s most iconic children's book and one of the best-selling children's books of all time, Wonka tells the wondrous story of how the world's greatest inventor, magician and chocolate-maker became the beloved Willy Wonka we know today.",
        Rating: 'PG (Some Violence | Mild Language | Thematic Elements)',
        Genre: ['Kids & family', 'Musical', 'Comedy', 'Fantasy'],
        OriginalLanguage: 'English',
        Director: 'Paul King',
        Producer: ['David Heyman', 'Alexandra Derbyshire', 'Luke Kelly'],
        Writer: ['Simon Farnaby', 'Paul King'],
        ReleaseDateTheaters: 'Dec 15, 2023  Wide',
        Runtime: '1h 56m',
        Distributor: 'Warner Bros. Pictures',
        ProductionCo: 'Heyday Films',
        SoundMix: 'Dolby Atmos, Dolby Digital',
        AspectRatio: 'Digital 2.39:1',
    }
    const cast = {
        1: {
            name: 'Amber Midthunder',
            role: 'Actor',
            as: 'Naru',
        },
        2: {
            name: 'Amber Midthunder',
            role: 'Actor',
            as: 'Naru',
        },
        3: {
            name: 'Amber Midthunder',
            role: 'Actor',
            as: 'Naru',
        },
        4: {
            name: 'Amber Midthunder',
            role: 'Actor',
            as: 'Naru',
        },
        5: {
            name: 'Amber Midthunder',
            role: 'Actor',
            as: 'Naru',
        },
        6: {
            name: 'Amber Midthunder',
            role: 'Actor',
            as: 'Naru',
        },
        7: {
            name: 'Amber Midthunder',
            role: 'Actor',
            as: 'Naru',
        },
        8: {
            name: 'Amber Midthunder',
            role: 'Actor',
            as: 'Naru',
        },
        9: {
            name: 'Amber Midthunder',
            role: 'Actor',
            as: 'Naru',
        },
        10: {
            name: 'Amber Midthunder',
            role: 'Actor',
            as: 'Naru',
        },
    }
    

      if (getFilm.isLoading || getRatingFromFilm.isLoading) {
          return <p></p>
      }

       return getFilm.error || getRatingFromFilm.error ? (
           <div>
               <p>
                   Oops! Something went wrong while fetching the data.
                   <br></br>
                   {getFilm.error?.message}
                   <br></br>
                   {getRatingFromFilm.error?.message}
               </p>
           </div>
       ) : (
           <Fragment>
               <FilmMainInfoContainer
                   data={getFilm.data.data.response}
                   ratings={getRatingFromFilm.data.data.response}
               ></FilmMainInfoContainer>
               {/* <FilmDetailsContainer
                   data={getFilm.data?.data?.response}
                   cast={cast}
               ></FilmDetailsContainer> */}
           </Fragment>
       )
}

export default FilmManager