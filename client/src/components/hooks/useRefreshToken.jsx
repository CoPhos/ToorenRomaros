import axios from '../../utils/constants'
import useAuth from './useAuth'

function useRefreshToken() {
    const { setAuth } = useAuth()

    async function refresh(refreshToken) {
        const response = await axios.get(
            '/auth/token/refresh',
            JSON.stringify({
                refreshToken: refreshToken,
            }),
            {
                headers: {
                    'Content-Type': 'application/json',
                    withCredentials: true,
                },
            }
        )
        setAuth((prev) => {
            return { ...prev, accessToken: response.data.accessToken }
        })
        return response.data.accessToken
    }

  return refresh
}

export default useRefreshToken