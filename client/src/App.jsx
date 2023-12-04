import React from 'react'
import { BrowserRouter, Switch, Route } from 'react-router-dom'
import './index.css'; 

import { ThemeProvider } from 'styled-components'

//utils
import { colors } from './utils/globalStyles'
import { fontSizes } from './utils/globalStyles'
import { GlobalStyle } from './utils/globalStyles'

//components
import NavbarContainer from './components/navbar/NavbarContainer'
import Footer from './components/footer/Footer'
import MobileNavMenu from './components/navbar/MobileNavMenu'

import Home from './components/routes/Home';
import FilmDetails from './components/routes/FilmDetails';
import Browse from './components/routes/Browse';
import EditorManager from './components/textEditor/EditorManager'

 //themes
    const theme = {
        colors: colors,
        fontSizes: fontSizes,
    }

export default function App() {
    return (
        <ThemeProvider theme={theme}>
            <GlobalStyle />
            <BrowserRouter>
                <NavbarContainer></NavbarContainer>
                
                    <Switch>
                        <Route exact path="/">
                            <Home></Home>
                        </Route>
                        <Route path="/film">
                            <FilmDetails></FilmDetails>
                        </Route>
                        <Route path="/browse">
                            <Browse></Browse>
                        </Route>
                        <Route path="/editor">
                            <EditorManager></EditorManager>
                        </Route>
                        <Route>
                            <p>Page Not Found</p>
                        </Route>
                    </Switch>
                
                {/* <MobileNavMenu></MobileNavMenu>
                <Footer></Footer> */}
            </BrowserRouter>
        </ThemeProvider>
    )
}