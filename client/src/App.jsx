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
import ProfileManager from './components/profile/ProfileManager';
import AllReviewsManager from './components/allReviews/AllReviewsManager'
import HomeBlogManager from './components/homeBlog/HomeBlogManager';

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
                    <Route path="/profile">
                        <ProfileManager></ProfileManager>
                    </Route>
                    <Route path="/reviews">
                        <AllReviewsManager></AllReviewsManager>
                    </Route>
                    <Route path="/blog">
                       <HomeBlogManager></HomeBlogManager>
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
                            : location.pathname.includes('/browse')
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