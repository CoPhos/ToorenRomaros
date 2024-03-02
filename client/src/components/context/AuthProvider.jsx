import { createContext, useState} from 'react'

const AuthContext = createContext({})

export const AuthProvider = ({children}) => {
  const [auth, setauth] = useState({})
  const [isAuthenticated, setisAuthenticated] = useState(false)
  
  const login = (
      id,
      user,
      roles,
      accessToken,
      refreshToken,
      email
  ) => {
      setauth({ id, user, roles, accessToken, refreshToken, email })
      setisAuthenticated(true)
  }

  const setImage = (imageurl) => {
    setauth({...auth, imageurl})
  }

  const logout = () => {
      setauth({})
      setisAuthenticated(false)
  }
    return (
        <AuthContext.Provider
            value={{ auth, isAuthenticated, setauth, login, logout, setImage }}
        >
            {children}
        </AuthContext.Provider>
    )
}

export default AuthContext