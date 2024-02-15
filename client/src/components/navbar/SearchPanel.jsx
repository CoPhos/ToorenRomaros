import React, { Fragment } from 'react'
import SearchMovieCard from '../cards/movieCard/SearchMovieCard'
import TittleCard from '../cards/tittle/TittleCard'

function SearchPanel({ filmQuery, postQuery, divRef }) {
    const isLoading = filmQuery.isLoading || postQuery.isLoading

    const hasError = filmQuery.error || postQuery.error

    if (isLoading) {
        return (
            <div className="w-[480px] h-[550px] px-2 pb-4  overflow-x-auto absolute bg-white-50 flex flex-col items-start justify-start top-6 right-[0px] rounded-b-md shadow-[0_2.8px_2.2px_rgba(0,_0,_0,_0.034),_0_6.7px_5.3px_rgba(0,_0,_0,_0.048),_0_12.5px_10px_rgba(0,_0,_0,_0.06),_0_22.3px_17.9px_rgba(0,_0,_0,_0.072),_0_41.8px_33.4px_rgba(0,_0,_0,_0.086),_0_100px_80px_rgba(0,_0,_0,_0.12)]">
                <p>Loading...</p>
            </div>
        )
    }

    if (hasError) {
        return (
            <div className="w-[480px] h-[550px] px-2 pb-4  overflow-x-auto absolute bg-white-50 flex flex-col items-start justify-start top-6 right-[0px] rounded-b-md shadow-[0_2.8px_2.2px_rgba(0,_0,_0,_0.034),_0_6.7px_5.3px_rgba(0,_0,_0,_0.048),_0_12.5px_10px_rgba(0,_0,_0,_0.06),_0_22.3px_17.9px_rgba(0,_0,_0,_0.072),_0_41.8px_33.4px_rgba(0,_0,_0,_0.086),_0_100px_80px_rgba(0,_0,_0,_0.12)]">
                <p>
                    Oops! Something went wrong while fetching the data.
                    <br />
                </p>
            </div>
        )
    }

    const filmaData = filmQuery.data?.data?.response
    const postData = postQuery.data?.data?.response
    
    return (
        <Fragment>
            <div
                ref={divRef}
                className="w-[480px] h-[550px] px-2 pb-4  overflow-x-auto absolute bg-white-50 flex flex-col items-start justify-start top-6 right-[0px] rounded-b-md shadow-[0_2.8px_2.2px_rgba(0,_0,_0,_0.034),_0_6.7px_5.3px_rgba(0,_0,_0,_0.048),_0_12.5px_10px_rgba(0,_0,_0,_0.06),_0_22.3px_17.9px_rgba(0,_0,_0,_0.072),_0_41.8px_33.4px_rgba(0,_0,_0,_0.086),_0_100px_80px_rgba(0,_0,_0,_0.12)]"
            >
                <div className="flex flex-col items-start justify-start ">
                    <TittleCard tittle={'MOVIES / TV'}></TittleCard>
                    <div className="flex flex-col items-start justify-start gap-1 mt-2">
                        {filmaData?.length > 0 ? (
                            filmaData?.map((item) => {
                                return (
                                    <SearchMovieCard
                                        key={item.id}
                                        data={item}
                                    ></SearchMovieCard>
                                )
                            })
                        ) : (
                            <p className="text-tag">No results found</p>
                        )}
                    </div>
                </div>
                <div className="flex flex-col items-start justify-start ">
                    <TittleCard tittle={'BLOG POSTS'}></TittleCard>
                    <div className="flex flex-col items-start justify-start gap-1 mt-2">
                        {postData?.length > 0 ? (
                            postData.map((item) => {
                                return (
                                    <SearchMovieCard
                                        key={item.id}
                                        data={item}
                                        isBlog={true}
                                    ></SearchMovieCard>
                                )
                            })
                        ) : (
                            <p className="text-tag">No results found</p>
                        )}
                    </div>
                </div>
            </div>
        </Fragment>
    )
}

export default SearchPanel
