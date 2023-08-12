import React from 'react'
import Navbar from './components/navbar/Navbar'
import { ThemeProvider } from 'styled-components'
import { colors } from './components/globalStyles'
import { fontSizes } from './components/globalStyles'
import { GlobalStyle } from './components/globalStyles'

const theme = {
    colors: colors,
    fontSizes: fontSizes,
}

export default function App() {
    return (
        <ThemeProvider theme={theme}>
            <GlobalStyle />
            <Navbar></Navbar>
            <h1>This is heading 1</h1>
            <h2>This is heading 2</h2>
            <h3>This is heading 3</h3>
            <h4>This is heading 4</h4>
            <h5>This is heading 5</h5>
            <h6>This is heading 6</h6>

            <p>
                <b>Tip:</b> Use h1 to h6 elements only for headings. Do not use
                them just to make text bold or big. Use other tags for that.
            </p>
            <h1>This is heading 1</h1>
            <h2>This is heading 2</h2>
            <h3>This is heading 3</h3>
            <h4>This is heading 4</h4>
            <h5>This is heading 5</h5>
            <h6>This is heading 6</h6>

            <p>
                <b>Tip:</b> Use h1 to h6 elements only for headings. Do not use
                them just to make text bold or big. Use other tags for that.
            </p>
        </ThemeProvider>
    )
}
