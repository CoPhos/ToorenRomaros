import React,{useState} from 'react'
import {Link} from 'react-router-dom'
import { useLocation } from 'react-router-dom'

import ReviewRating from '../cards/filmData/ReviewRating'
import ReviewCard from '../cards/filmData/ReviewCard'

function AllReviewsContainer({ rating }) {
    const [active, setactive] = useState(1)
    const location = useLocation()
    const params = new URLSearchParams(location.search)
    const pathnameArray = location.pathname.split('/')

    const genre = params.get('genre') || 'all'
    const type = pathnameArray[pathnameArray.length - 1]
    const sort = params.get('sort') || 'default'

    const baseClassesButton =
        'text-white-300 text-small-m-400 lg:text-small-d-400 border-[none] hover:cursor-pointer py-2 px-1'
     const focus = 'text-white-900 border-t-[1px] border-white-950'
     const notFocus = 'border-[none]'
     const show = 'flex flex-col items-center justify-start gap-2'
     const notShow = 'hidden'

    return (
        <div className="mt-4 px-1">
            <div className="flex flex-row items-center justify-start gap-2">
                <img
                    //srcset="https://small 480w, https://medium 800w, https://large 1100w"
                    src="https://resizing.flixster.com/-XZAfHZM39UwaGJIFWKAE8fS0ak=/v3/t/assets/p159790_p_v8_ae.jpg"
                    alt="Elva dressed as a fairy"
                    className="w-[60px] h-[100px] rounded object-cover object-center"
                />
                <div className="flex flex-col items-start justify-start gap-1">
                    <p className="text-body-m-700 lg:text-body-d-700">
                        Fast & Furious: Tokyo Drift
                    </p>
                    <p className="text-small-m-700 lg:text-small-d-700">
                        {type == 'critic' ? 'Critic Reviews' : 'User Reviews'}
                    </p>
                </div>
            </div>
            <div className='mt-2'>
                <ReviewRating
                    tittle={'User Reviews'}
                    totalScore={65}
                    numberOfReviews={80}
                    rating={rating}
                ></ReviewRating>
            </div>

            <div>
                <div className="w-full">
                    <div className="flex flex-row items-center justify-around w-full">
                        <button
                            onClick={() => setactive(1)}
                            className={`${baseClassesButton} ${
                                active === 1 ? focus : notFocus
                            }`}
                        >
                            Critic Reviews
                        </button>
                        <button
                            onClick={() => setactive(2)}
                            className={`${baseClassesButton} ${
                                active === 2 ? focus : notFocus
                            }`}
                        >
                            User Reviews
                        </button>
                    </div>
                </div>

                <div className="flex flex-row items-center justify-between flex-wrap">
                    <p className="text-small-m-400 lg:text-small-d-400">
                        Showing 53 Critic Reviews
                    </p>
                    <div className="flex flex-row items-center justify-start gap-2 self-end mt-1 min-[550px]:mt-[0px]">
                        <div>
                            <select
                                name="cars"
                                id="cars"
                                className="text-small-m-700 lg:text-small-d-700 rounded border border-white-200 w-[175px] px-3 py-1"
                            >
                                <option value="volvo">All Reviews</option>
                                <option value="saab">Saab</option>
                                <option value="opel">Opel</option>
                                <option value="audi">Audi</option>
                            </select>
                        </div>
                        <div>
                            <select
                                name="cars"
                                id="cars"
                                className="text-small-m-700 lg:text-small-d-700 rounded border border-white-200 w-[175px] px-3 py-1"
                            >
                                <option value="volvo">All Reviews</option>
                                <option value="saab">Saab</option>
                                <option value="opel">Opel</option>
                                <option value="audi">Audi</option>
                            </select>
                        </div>
                    </div>
                </div>

                <div className="flex flex-col items-center justify-start gap-2 mt-2">
                    <ReviewCard expand={true}></ReviewCard>
                    <ReviewCard expand={true}></ReviewCard>
                    <ReviewCard expand={true}></ReviewCard>
                    <ReviewCard expand={true}></ReviewCard>
                    <ReviewCard expand={true}></ReviewCard>
                </div>
            </div>
        </div>
    )
}

export default AllReviewsContainer