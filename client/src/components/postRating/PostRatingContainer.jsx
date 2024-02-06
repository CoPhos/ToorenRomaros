import React, { Fragment, useState, useEffect } from 'react'
import Carousel from 'react-elastic-carousel'
import EditCommentCard from '../cards/editCommentCard/EditCommentCard';

function PostRatingContainer({
    hoveredIndex,
    currentIndex,
    setHoveredIndex,
    handleSubmit,
    handleChange,
    formData,
    handleCheckboxChange,
    openPopup,
    closePopup,
    handleOnClick,
    userCommentData,
    filmdata,
    fomrError,
    isPopupOpen,
}) {
    function handleOnMouseLeave() { 
        if (!(parseInt(userCommentData.rating, 10) >= 0 || hoveredIndex != null)) {
           setHoveredIndex(null)
        } else {
            setHoveredIndex(currentIndex)
        }
    }

    useEffect(() => {
        if (isPopupOpen) {
            document.body.style.overflow = 'hidden'
        } else {
            document.body.style.overflow = 'auto'
        }
    }, [isPopupOpen])

    const breakPoints = [
        { width: 1, itemsToShow: 4 },
        { width: 290, itemsToShow: 6 },
        { width: 410, itemsToShow: 8 },
        { width: 545, itemsToShow: 10 },
    ]

    const baseClassesRating =
        'flex items-center justify-center rounded-xl h-[64px] w-[64px]'

    let dynamicClasses
    let totalScoreText
    if (hoveredIndex + 1 <= 4) {
        dynamicClasses = 'bg-red-600'
        totalScoreText = 'Generally Unfavorable'
    } else if (hoveredIndex + 1 < 7 && hoveredIndex + 1 > 4) {
        dynamicClasses = 'bg-[#ffbd3f]'
        totalScoreText = 'Mixed or Average'
    } else {
        dynamicClasses = 'bg-green-600'
        totalScoreText = 'Generally Favorable'
    }

    const baseClasses =
        'flex items-center justify-center rounded-[50%] w-[44px] h-[44px] hover:cursor-pointer'
    

    const children = new Array(10).fill(null).map((_, index) => {
        let dynamicClasses = 'child '
        if (hoveredIndex !== null && index <= hoveredIndex) {
            dynamicClasses = dynamicClasses + 'opacity-100 '
        } else {
            dynamicClasses = dynamicClasses + 'opacity-50 '
        }
        if (index + 1 <= 4) {
            dynamicClasses = dynamicClasses + 'bg-red-600 '
        } else if (index + 1 < 7 && index + 1 > 4) {
            dynamicClasses = dynamicClasses + 'bg-[#ffbd3f] '
        } else {
            dynamicClasses = dynamicClasses + 'bg-green-600 '
        }

        return (
            <div
                key={index}
                className={`${baseClasses} ${dynamicClasses}`}
                onMouseEnter={() => setHoveredIndex(index)}
                onMouseLeave={() => handleOnMouseLeave()}
                onClick={(e) => handleOnClick(e,index)}
            >
                <p className="w-fit h-fit text-body-b-700 text-white-50">
                    {(index + 1) * 10}
                </p>
            </div>
        )
    })

    return (
        <Fragment>
            <div className="w-full mb-2">
                <div className="flex flex-row items-center justify-between w-full mt-2">
                    <div className="flex flex-col items-start justify-center">
                        <p className="text-body-m-300 lg:text-body-d-300">
                            My Score
                        </p>
                        <p className="text-small-m-700 lg:text-small-d-700">
                            Hover and click to give a rating
                        </p>
                    </div>
                    <div>
                        <div
                            className={`${baseClassesRating} ${dynamicClasses}`}
                        >
                            <p className="text-[36px] font-bold text-white-50">
                                {hoveredIndex + 1 + '0'}
                            </p>
                        </div>
                    </div>
                </div>
                <div className="w-full mt-1 max-w-[1024px]" style={{}}>
                    <Carousel
                        pagination={true}
                        showArrows={false}
                        breakPoints={breakPoints}
                    >
                        {children}
                    </Carousel>
                </div>
                <button
                    onClick={openPopup}
                    className="mt-2 rounded-md border-[1px] border-white-200 w-full text-small-m-400 h-[36px] lg:text-small-d-400 hover:border-white-600 hover:text-white-500"
                >
                    Add My Review
                </button>
            </div>
            {isPopupOpen && (
                <EditCommentCard
                    filmdata={filmdata}
                    baseClassesRating={baseClassesRating}
                    dynamicClasses={dynamicClasses}
                    totalScoreText={totalScoreText}
                    hoveredIndex={hoveredIndex}
                    children={children}
                    breakPoints={breakPoints}
                    handleSubmit={handleSubmit}
                    formData={formData}
                    handleChange={handleChange}
                    fomrError={fomrError}
                    handleCheckboxChange={handleCheckboxChange}
                    closePopup={closePopup}
                ></EditCommentCard>
            )}
        </Fragment>
    )
}

export default PostRatingContainer
