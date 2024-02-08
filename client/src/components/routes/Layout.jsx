import { Fragment } from 'react'
import { Outlet } from 'react-router-dom'
import { useLocation } from 'react-router-dom'

import NavbarManager from '../navbar/NavbarManager'
import MobileNavMenu from '../../components/navbar/MobileNavMenu'
import Footer from '../footer/Footer'

function Layout({ }) {
     const location = useLocation()
    
    let fillColor;

    if (location.pathname === '/'){fillColor='home'}
    else if (location.pathname.includes('/browse')){ fillColor = 'browse'}
    else if (location.pathname.includes('/blog')){ fillColor = 'blog'}
    else if (location.pathname.includes('/profile') ||location.pathname.includes('/critic') || location.pathname.includes('/admin')){ fillColor='profile'}
    else if (location.pathname === '/notification') {fillColor = 'notification'}
        return (
            <Fragment>
                <NavbarManager></NavbarManager>
                <main>
                    <Outlet />
                </main>
                <MobileNavMenu fillColor={fillColor} />
                <Footer></Footer>
            </Fragment>
        )
}

export default Layout
