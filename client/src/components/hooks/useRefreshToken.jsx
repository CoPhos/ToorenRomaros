import axios from '../../utils/constants'
import useAuth from './useAuth'

function useRefreshToken() {
    const { setauth, auth } = useAuth()

    async function refresh() {
        const response = await axios.post(
            '/auth/token/refresh',
            JSON.stringify({
                refreshToken: encodeURIComponent(auth.refreshToken),
            }),
            {
                headers: {
                    'Content-Type': 'application/json',
                },
                withCredentials: true,
            }
        )
        setauth((prev) => {
            return {
                ...prev,
                accessToken: response.data.accessToken,
                refreshToken: response.data.refreshToken,
            }
        })
        console.log(response)
        return response.data.accessToken
    }

  return refresh
}

export default useRefreshToken