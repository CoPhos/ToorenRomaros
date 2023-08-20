import { createGlobalStyle } from 'styled-components'

export const GlobalStyle = createGlobalStyle`
  :root { 
        box-sizing: border-box; 
        font-family: 'Source Sans 3', sans-serif;
        font-size: 16px;
    } 
    *,
    ::before, ::after {
        box-sizing: inherit;
    }
    #root{
            max-width: 1624px;
            background-color: #FFFFFF;
            margin: 0 auto;
        }
    body {
        margin: 0px;
        background-color: #F2F2F2;
        @media only screen and (max-width: 904px) {
          background-color: #FFFFFF;
        }
    }
    #root{
      min-height: 100vh;
      display: flex;
      flex-direction: column;
      position: relative;
    }
    h1 {
      font-size: 3.815rem;
    }
    h2 {
      font-size: 3.052rem;
    }
    h3 {
      font-size: 2.441rem;
    }
    h4 {
      font-size: 1.953rem;
    }
    h5 {
      font-size: 1.563rem;
    }
    h6 {
      font-size: 1.25rem;
    }
    p {
        font-size: 1rem; 
      }
    caption {
      font-size: 0.8rem;
    }
    @media only screen and (max-width: 904px) {
      h1 {
        font-size: 2.027rem;
      }
      h2 {
        font-size: 1.802rem;
      } 
      h3 {
        font-size: 1.602rem;
      }
      h4 {
        font-size: 1.424rem;
      }
      h5 {
        font-size: 1.266rem;
      }
      h6 {
        font-size: 1.125rem;
      }
      caption {
        font-size: 0.889rem; 
      }
    }
`

export const colors = {
    main: '#FF5959',
    secondary: '#272B45',
    footer: '#2A2C32',
    hyperlinks: '#51A9EE',
    caption: '#959595',
    background: '#F2F2F2',
    line: '#E9E9EA',
    red: '#F02D2D',
    yellow: '#FFCB34',
    green: '#66CC33',
}

export const fontSizes = {
    mh1: '2.027rem',
    mh2: '1.802rem',
    mh3: '1.602rem',
    mh4: '1.424rem',
    mh5: '1.266rem',
    mh6: '1.125rem',
    mCaption: '0.889rem',
    base: '16px',
    h1: '3.815rem',
    h2: '3.052rem',
    h3: '2.441rem',
    h4: '1.953rem',
    h5: '1.563rem',
    h6: '1.25rem',
    caption: '0.8rem',
}
