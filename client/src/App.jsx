import React from 'react'
import { BrowserRouter, Switch, Route } from 'react-router-dom'
import './index.css'; 

//components
import NavbarManager from './components/navbar/NavbarManager';
import Footer from './components/footer/Footer'
import MobileNavMenu from './components/navbar/MobileNavMenu'

import Home from './components/routes/Home';
import FilmDetails from './components/routes/FilmDetails';
import Browse from './components/routes/Browse';
import EditorManager from './components/textEditor/EditorManager'

export default function App() {
    return (
        
            <BrowserRouter>
                <NavbarManager></NavbarManager>
                <main>
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
                </main>

                <Footer></Footer>
                <Route
                    render={({ location }) => {
                        const fillColor =
                            location.pathname === '/'
                                ? 'home'
                                : location.pathname === '/browse'
                                ? 'browse'
                                : location.pathname === '/blog'
                                ? 'blog'
                                : location.pathname === '/profile'
                                ? 'profile'
                                : location.pathname === '/notification'
                                ? 'notification'
                                : 'default'
                        return <MobileNavMenu fillColor={fillColor} />
                    }}
                />
            </BrowserRouter>
        
    )
}