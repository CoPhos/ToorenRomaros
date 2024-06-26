import axios from 'axios'
export const BASE_URL = process.env.CINNABAR_API_URL
export default axios.create({
    baseURL: BASE_URL,
})

export const axiosPrivate = axios.create({
    baseURL: BASE_URL,
    headers: { 'Content-Type': 'application/json' },
    withCredentials: true
})
