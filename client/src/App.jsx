import React from 'react'
import { Routes, Route } from 'react-router-dom'
import { QueryClientProvider, QueryClient } from 'react-query';
import './index.css'; 

//components

import Home from './components/routes/Home';
import FilmDetails from './components/routes/FilmDetails';
import Browse from './components/routes/Browse';
import EditorManager from './components/textEditor/EditorManager'
import ProfileManager from './components/profile/ProfileManager';
import AllReviewsManager from './components/allReviews/AllReviewsManager'
import HomeBlogManager from './components/homeBlog/HomeBlogManager';
import Layout from './components/routes/Layout';
import RequiredAuth from './components/routes/RequiredAuth';
import Unauthorized from './components/routes/Unauthorized';
import NotFound from './components/routes/NotFound'
import { LoginPopUpProvider } from '../src/components/context/LoginPopUpProvider'
import CriticProfileManager from './components/profile/CriticProfileManager';

const queryClient = new QueryClient({
    defaultOptions: {
        queries: {
            refetchOnWindowFocus: false, 
            cacheTime: 0,
            
        },
    },
})

export default function App() {
    return (
        <QueryClientProvider client={queryClient}>
            <LoginPopUpProvider>
                <Routes>
                    <Route path="/" element={<Layout></Layout>}>
                        {/* public routes */}
                        <Route exact path="/" element={<Home />} />
                        <Route
                            exact
                            path="/film/:uuid/"
                            element={<FilmDetails />}
                        />
                        <Route path="/browse" element={<Browse />} />
                        <Route
                            exact
                            path="/film/:uuid/reviews/"
                            element={<AllReviewsManager />}
                        />
                        <Route path="/blog" element={<HomeBlogManager />} />
                        <Route
                            path="/unauthorized"
                            element={<Unauthorized />}
                        />

                        {/* private routes */}
                        <Route
                            element={<RequiredAuth allowedRoles={['CRITIC']} />}
                        >
                            <Route
                                exact
                                path="/editor/:uuid"
                                element={<EditorManager />}
                            />
                        </Route>

                        <Route
                            element={
                                <RequiredAuth
                                    allowedRoles={['USER']}
                                />
                            }
                        >
                            <Route
                                exact
                                path="/profile"
                                element={<ProfileManager />}
                            />
                        </Route>
                        <Route
                            element={
                                <RequiredAuth
                                    allowedRoles={['CRITIC']}
                                />
                            }
                        >
                            <Route
                                exact
                                path="/critic"
                                element={<CriticProfileManager />}
                            />
                        </Route>

                        {/* 404 */}
                        <Route path="*" element={<NotFound />} />
                    </Route>

                   
                </Routes>
            </LoginPopUpProvider>
        </QueryClientProvider>
    )
}