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
    body {
      margin: 0px;
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
    @media only screen and (max-width: 600px) {
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

export const Colors = {
    main: '#FF5959',
    secondary: '#272B45',
    footer: '#2A2C32',
    hyperlinks: '51A9EE',
    caption: '#959595',
    background: 'F2F2F2',
    pureWhite: '#FFFFFF',
    pureBlack: '000000',
    line: '#E9E9EA',
}
