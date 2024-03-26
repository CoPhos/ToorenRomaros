import { Fragment } from 'react'
import { Outlet } from 'react-router-dom'
import { useLocation } from 'react-router-dom'
import useAuth from '../hooks/useAuth'
import ErrorBoundary from '../../utils/ErrorBoundary'

import NavbarManager from '../navbar/NavbarManager'
import MobileNavMenu from '../../components/navbar/MobileNavMenu'
import Footer from '../footer/Footer'

function Layout({ }) {
     const location = useLocation()
     const { auth } = useAuth()

    let fillColor;
    if (location.pathname === '/'){fillColor='home'}
    else if (
        location.pathname.includes('/browse') ||
        location.pathname.includes('/post')
    ) {
        fillColor = 'browse'
    } else if (location.pathname.includes('/blog')) {
        fillColor = 'blog'
    } else if (
        location.pathname.includes('/profile') ||
        location.pathname.includes('/critic') ||
        location.pathname.includes('/admin')
    ) {
        fillColor = 'profile'
    } else if (location.pathname === '/notification') {
        fillColor = 'notification'
    }
 
    const onlyLogo =
        location.pathname.includes('/forgot-password') ||
        location.pathname.includes('/confirm-reset')

    let toProfile
    if (auth?.roles?.includes('USER')) {
        toProfile = '/profile'
    } else if (auth?.roles?.includes('CRITIC')) {
        toProfile = '/critic'
    }

        return (
            <ErrorBoundary>
                <NavbarManager onlyLogo={onlyLogo}></NavbarManager>
                <main>
                    <Outlet />
                </main>
                {!onlyLogo && (
                    <MobileNavMenu fillColor={fillColor} to={toProfile} />
                )}
                <Footer></Footer>
            </ErrorBoundary>
        )
}

export default Layout
