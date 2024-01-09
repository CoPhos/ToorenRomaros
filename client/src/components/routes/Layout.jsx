import { Fragment } from 'react';
import { Outlet } from 'react-router-dom'

import NavbarManager from '../navbar/NavbarManager';
import Footer from '../footer/Footer';


function Layout() {
  return (
      <Fragment>
          <NavbarManager></NavbarManager>
          <main>
              <Outlet />
          </main>
          <Footer></Footer>
      </Fragment>
  )
}

export default Layout