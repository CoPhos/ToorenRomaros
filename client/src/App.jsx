import React from 'react'
import Navbar from './components/navbar/Navbar'
import { ThemeProvider } from 'styled-components'
import { Colors } from './components/globalStyles'
import { GlobalStyle } from './components/globalStyles'

const theme = {
  colors: Colors
}

export default function App() {
  return (
    <ThemeProvider theme={theme}>
        <GlobalStyle />
        <Navbar></Navbar>
    </ThemeProvider >
    
  )
}

