import React, { useEffect } from 'react'
import axios from '../../utils/constants'
import SpotlightCarouselContainer from './SpotlightCarouselContainer'
import { useQuery } from 'react-query'
import { useQueryClient } from 'react-query'
import ErrorBoundary from '../../utils/ErrorBoundary'

function SpotlightCarouselManager() {
    const queryClient = useQueryClient()
    const POST_URL = '/posts'

    const getLatestPost = useQuery({
        queryKey: ['latestPosts'],
        queryFn: async () => {
            return axios.get(POST_URL + '?page=0&size=6&latest=true')
        },
    })

    const getAllImages = useQuery(
        'allImagesFromLatestPosts',
        async () => {
            if (!getLatestPost.data) {
                return []
            }

            const imageResponses = await Promise.all(
                getLatestPost.data.data.response.map(async (item) => {
                    const response = await axios.get(
                        `${item.id}/media/images?imageType=POST_MAIN`
                    )
                    return { id: item.id, images: response.data }
                })
            )

            const updatedPosts = getLatestPost.data.data.response.map(
                (item) => {
                    const correspondingImage = imageResponses.find(
                        (image) => image.id === item.id
                    )
                    return correspondingImage
                        ? { ...item, images: correspondingImage.images }
                        : item
                }
            )

            queryClient.setQueryData(['latestPosts'], {
                data: { response: updatedPosts },
            })
        },
        { enabled: !!getLatestPost.data }
    )
    if (getLatestPost.isLoading || getAllImages.isLoading) {
        return <div className="h-[390px] "></div>
    }
    return (
        <div className='min-h-[325px]'>
            {getLatestPost.error || getAllImages.error ? (
                <div>
                    <p>
                        Oops! Something went wrong while fetching the data.
                        <br></br>
                        {getLatestPost.error?.message}
                        <br></br>
                        {getAllImages.error?.message}
                    </p>
                </div>
            ) : (
                getLatestPost.data.data.response && (
                    <ErrorBoundary>
                        <SpotlightCarouselContainer
                            data={getLatestPost.data.data.response}
                        />
                    </ErrorBoundary>
                )
            )}
        </div>
    )
}

export default SpotlightCarouselManager
