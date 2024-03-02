import { useState } from 'react'

const useApiErrorHandler = () => {
    const [errorMessage, seterrorMessage] = useState('')

    const handleApiError = (error) => {
        if (!error.response) {
            seterrorMessage('No Server Response')
        } else {
            handleHttpError(error)
        }
    }

    const handleHttpError = (error) => {
        switch (error.response.status) {
            case 401:
                seterrorMessage('Unauthorized')
                break
            default:
                seterrorMessage(error.response.data.message)
        }
    }

    return { errorMessage, seterrorMessage, handleApiError }
}

export default useApiErrorHandler
