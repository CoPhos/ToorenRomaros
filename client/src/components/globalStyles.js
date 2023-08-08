import { createGlobalStyle } from 'styled-components';
 
export const GlobalStyle = createGlobalStyle`
  :root { 
        box-sizing: border-box; 
        font-family: 'Source Sans 3', sans-serif;
    } 
    *,
    ::before, ::after {
        box-sizing: inherit;
    }
`;
 
export const Colors = {
  mainColor: "#FF5959",
};