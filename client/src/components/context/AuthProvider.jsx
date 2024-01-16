import { createContext, useState} from 'react'

const AuthContext = createContext({})

export const AuthProvider = ({children}) => {
  const [auth, setauth] = useState({})
  const [isAuthenticated, setisAuthenticated] = useState(false)
  
  const login = ( id, user, password, roles, accessToken, refreshToken ) => {
      setauth({ id, user, password, roles, accessToken, refreshToken })
      setisAuthenticated(true)
  }

  const logout = () => {
      setauth({})
      setisAuthenticated(false)
  }
    return (
        <AuthContext.Provider
            value={{ auth, isAuthenticated, setauth, login, logout }}
        >
            {children}
        </AuthContext.Provider>
    )
}

export default AuthContext