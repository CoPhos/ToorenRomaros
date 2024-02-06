import { useEffect } from 'react'

const useInfiniteScrollX = (
    containerRef,
    hasNextPage,
    isFetchingNextPage,
    fetchNextPage
) => {
    useEffect(() => {
        const handleScrollX = () => {
            const { scrollLeft, scrollWidth, clientWidth } =
                containerRef.current

            if (
                scrollWidth - scrollLeft === clientWidth &&
                hasNextPage &&
                !isFetchingNextPage
            ) {
                fetchNextPage()
            }
        }

        containerRef.current.addEventListener('scroll', handleScrollX)

        return () => {
            containerRef.current.removeEventListener('scroll', handleScrollX)
        }
    }, [containerRef, hasNextPage, isFetchingNextPage, fetchNextPage])
}

export default useInfiniteScrollX
