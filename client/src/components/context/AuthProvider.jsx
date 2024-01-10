import { createContext, useState} from 'react'

const AuthContext = createContext({})

export const AuthProvider = ({children}) => {
  const [auth, setauth] = useState({})
  
  const login = ( user, password, roles, accessToken, refreshToken ) => {
      setauth({ user, password, roles, accessToken, refreshToken })
  }

  const logout = () => {
      setauth({})
  }
    return (
        <AuthContext.Provider value={{ auth, setauth, login, logout }}>
            {children}
        </AuthContext.Provider>
    )
}

export default AuthContext