import React, { useState, useEffect } from 'react'
import { Link } from 'react-router-dom'
import { useSearchParams } from 'react-router-dom'
import { BASE_URL } from '../../utils/constants'
import ReviewRating from '../cards/filmData/ReviewRating'
import ReviewCard from '../cards/filmData/ReviewCard'

function AllReviewsContainer({
    commonRatings,
    superRatings,
    handleSelectedOrder,
    handleSelectedRatingChange,
    selectedOrder,
    selectedRating,
    handleSelectedSuperChange,
    filmData,
    data,
    fetchNextPage,
    isFetchingNextPage,
    hasNextPage,
    filmImageData,
}) {
    const [searchParams, setSearchParams] = useSearchParams()
    const superReview = searchParams.get('super')
    const [active, setactive] = useState(superReview == 'true' ? 1 : 2)
    const totalSuper =
        superRatings.positive + superRatings.negative + superRatings.neutral
    const totalCommon =
        commonRatings.positive + commonRatings.negative + commonRatings.neutral
    const baseClassesButton =
        'text-white-300 text-small-m-400 lg:text-small-d-400 border-[none] hover:cursor-pointer py-2 px-1'
    const focus = 'text-white-900 border-t-[1px] border-white-950'
    const notFocus = 'border-[none]'
    const show = 'flex flex-col items-center justify-start gap-2'
    const notShow = 'hidden'
    useEffect(() => {
        const handleScroll = () => {
            const { scrollTop, scrollHeight, clientHeight } =
                document.documentElement
            if (
                scrollHeight - scrollTop === clientHeight &&
                hasNextPage &&
                !isFetchingNextPage
            ) {
                fetchNextPage()
            }
        }

        window.addEventListener('scroll', handleScroll)

        return () => {
            window.removeEventListener('scroll', handleScroll)
        }
    }, [hasNextPage, isFetchingNextPage, fetchNextPage])
    return (
        <div className="mt-4 px-1">
            <div className="flex flex-row items-center justify-start gap-2">
                <img
                    //srcset="https://small 480w, https://medium 800w, https://large 1100w"
                    src={`${BASE_URL}/images/${filmImageData[0].id}`}
                    alt="Elva dressed as a fairy"
                    className="w-[120px] h-[200px] rounded object-cover object-center"
                />
                <div className="flex flex-col items-start justify-start gap-1">
                    <p className="text-body-m-700 lg:text-body-d-700">
                        {filmData.tittle}
                    </p>
                    <p className="text-small-m-700 lg:text-small-d-700">
                        {superReview == 'true'
                            ? 'Critic Reviews'
                            : 'User Reviews'}
                    </p>
                </div>
            </div>
            <div className="mt-2">
                <ReviewRating
                    tittle={'User Reviews'}
                    totalScore={
                        superReview == 'true'
                            ? filmData.averageSuperRating
                            : filmData.averageUserRating
                    }
                    data={superReview == 'true' ? superRatings : commonRatings}
                ></ReviewRating>
            </div>

            <div>
                <div className="w-full">
                    <div className="flex flex-row items-center justify-around w-full">
                        <button
                            onClick={() => {
                                setactive(1)
                                handleSelectedSuperChange('true')
                            }}
                            className={`${baseClassesButton} ${
                                active === 1 ? focus : notFocus
                            }`}
                        >
                            Critic Reviews
                        </button>
                        <button
                            onClick={() => {
                                setactive(2)
                                handleSelectedSuperChange('false')
                            }}
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
                        {totalSuper + totalCommon} Reviews Available
                    </p>
                    <div className="flex flex-row items-center justify-start gap-2 self-end mt-1 min-[550px]:mt-[0px]">
                        <div>
                            <select
                                name="rating"
                                id="rating"
                                value={selectedRating}
                                onChange={(e) => handleSelectedRatingChange(e)}
                                className="text-small-m-700 lg:text-small-d-700 rounded border border-white-200 w-[175px] px-3 py-1"
                            >
                                <option value="all">All Reviews</option>
                                <option value="positive">Postive</option>
                                <option value="neutral">Neutral</option>
                                <option value="negative">Negative</option>
                            </select>
                        </div>
                        <div>
                            <select
                                name="order"
                                id="order"
                                value={selectedOrder}
                                onChange={(e) => handleSelectedOrder(e)}
                                className="text-small-m-700 lg:text-small-d-700 rounded border border-white-200 w-[175px] px-3 py-1"
                            >
                                <option value="rating">Score</option>
                                <option value="publicationDateTime">
                                    Recently Added
                                </option>
                                <option value="likeCount">More liked</option>
                            </select>
                        </div>
                    </div>
                </div>

                <div className="flex flex-col items-center justify-start gap-2 mt-2">
                    {data?.map((page, pageIndex) => (
                        <React.Fragment key={pageIndex}>
                            {page.data.response.content.map((item) => (
                                <ReviewCard
                                    key={item.id}
                                    expand={
                                        superReview == 'true' ? false : true
                                    }
                                    data={item}
                                    critic={
                                        superReview == 'true' ? true : false
                                    }
                                ></ReviewCard>
                            ))}
                        </React.Fragment>
                    ))}
                </div>
            </div>
        </div>
    )
}

export default AllReviewsContainer
