import React, { lazy, Suspense } from 'react'
import { Routes, Route } from 'react-router-dom'
import { QueryClientProvider, QueryClient } from 'react-query'
import './index.css'

//components
const Home = lazy(() => import('./components/routes/Home'))
const FilmDetails = lazy(() => import('./components/routes/FilmDetails'))
const Browse = lazy(() => import('./components/routes/Browse'))
const EditorManager = lazy(() =>
    import('./components/textEditor/EditorManager')
)
const ProfileManager = lazy(() => import('./components/profile/ProfileManager'))
const AllReviewsManager = lazy(() =>
    import('./components/allReviews/AllReviewsManager')
)
const HomeBlogManager = lazy(() =>
    import('./components/homeBlog/HomeBlogManager')
)
const Layout = lazy(() => import('./components/routes/Layout'))
const RequiredAuth = lazy(() => import('./components/routes/RequiredAuth'))
const Unauthorized = lazy(() => import('./components/routes/Unauthorized'))
const NotFound = lazy(() => import('./components/routes/NotFound'))
const CriticProfileManager = lazy(() =>
    import('./components/profile/CriticProfileManager')
)

import { LoginPopUpProvider } from '../src/components/context/LoginPopUpProvider'
import { ActionNotificationProvider } from '../src/components/context/ActionNotificationProvider'

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
                <ActionNotificationProvider>
                    <Suspense fallback={<h1></h1>}>
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
                                <Route
                                    path="/post/:uuid"
                                    element={<HomeBlogManager />}
                                />
                                <Route
                                    path="/unauthorized"
                                    element={<Unauthorized />}
                                />

                                {/* private routes */}
                                <Route
                                    element={
                                        <RequiredAuth
                                            allowedRoles={['CRITIC']}
                                        />
                                    }
                                >
                                    <Route
                                        exact
                                        path="/editor/:uuid"
                                        element={<EditorManager />}
                                    />
                                </Route>

                                <Route
                                    element={
                                        <RequiredAuth allowedRoles={['USER']} />
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
                    </Suspense>
                </ActionNotificationProvider>
            </LoginPopUpProvider>
        </QueryClientProvider>
    )
}
