/** @type {import('tailwindcss').Config} */
const defaultTheme = require('tailwindcss/defaultTheme')
module.exports = {
    content: ['./src/**/*.{js,jsx,ts,tsx,html}'],
    theme: {
        fontFamily: {
            sans: ['"Source Sans 3"', ...defaultTheme.fontFamily.sans],
            SonsieOne: ['Sonsie One'],
        },
        fontSize: {
            //Desktop
            'h1-d-700': [
                '76.29px',
                {
                    lineHeight: '85.5px',
                    letterSpacing: '-1.43px',
                    fontWeight: '700',
                },
            ],
            'h2-d-700': [
                '48.83px',
                {
                    lineHeight: '58.6px',
                    letterSpacing: '-0.98px',
                    fontWeight: '700',
                },
            ],
            'h2-d-400': [
                '48.83px',
                {
                    lineHeight: '58.6px',
                    letterSpacing: '-0.98px',
                    fontWeight: '400',
                },
            ],
            'h3-d-700': [
                '25px',
                {
                    lineHeight: '30px',
                    letterSpacing: '-0.15px',
                    fontWeight: '700',
                },
            ],
            'h3-d-400': [
                '25px',
                {
                    lineHeight: '30px',
                    letterSpacing: '-0.15px',
                    fontWeight: '400',
                },
            ],
            'body-d-400': [
                '20px',
                {
                    lineHeight: '30px',
                    letterSpacing: '-0.2px',
                    fontWeight: '400',
                },
            ],
            'body-d-700': [
                '20px',
                {
                    lineHeight: '30px',
                    letterSpacing: '-0.2px',
                    fontWeight: '700',
                },
            ],
            'small-d-400': [
                '16px',
                {
                    lineHeight: '24px',
                    letterSpacing: '-0.2px',
                    fontWeight: '400',
                },
            ],
            'small-d-300': [
                '16px',
                {
                    lineHeight: '24px',
                    letterSpacing: '-0.2px',
                    fontWeight: '300',
                },
            ],
            //Mobile
            'h1-m-700': [
                '36.49px',
                {
                    lineHeight: '43.8px',
                    letterSpacing: '-0.73px',
                    fontWeight: '700',
                },
            ],
            'h2-m-700': [
                '28.83px',
                {
                    lineHeight: '34.6px',
                    letterSpacing: '-0.58px',
                    fontWeight: '700',
                },
            ],
            'h2-m-400': [
                '28.83px',
                {
                    lineHeight: '34.6px',
                    letterSpacing: '-0.58px',
                    fontWeight: '400',
                },
            ],
            'h3-m-700': [
                '20.25px',
                {
                    lineHeight: '24.3px',
                    letterSpacing: '-0.15px',
                    fontWeight: '700',
                },
            ],
            'h3-m-400': [
                '20.25px',
                {
                    lineHeight: '24.3px',
                    letterSpacing: '-0.15px',
                    fontWeight: '400',
                },
            ],
            'body-m-400': [
                '18px',
                {
                    lineHeight: '27px',
                    letterSpacing: '-0.2px',
                    fontWeight: '400',
                },
            ],
            'body-m-700': [
                '18px',
                {
                    lineHeight: '27px',
                    letterSpacing: '-0.2px',
                    fontWeight: '700',
                },
            ],
            'Small-m-400': [
                '16px',
                {
                    lineHeight: '24px',
                    letterSpacing: '-0.2px',
                    fontWeight: '400',
                },
            ],
            'Small-m-300': [
                '16px',
                {
                    lineHeight: '24px',
                    letterSpacing: '-0.2px',
                    fontWeight: '300',
                },
            ],
        },
        spacing: {
            1: '8px',
            2: '16px',
            3: '24px',
            4: '32px',
            5: '40px',
            6: '48px',
        },
        extend: {
            colors: {
                white: {
                    50: '#ffffff',
                    100: '#efefef',
                    200: '#dcdcdc',
                    300: '#bdbdbd',
                    400: '#989898',
                    500: '#7c7c7c',
                    600: '#656565',
                    700: '#525252',
                    800: '#464646',
                    900: '#3d3d3d',
                    950: '#292929',
                },
                red: {
                    50: '#fff3ed',
                    100: '#ffe3d5',
                    200: '#fec3aa',
                    300: '#fe9873',
                    400: '#fc633b',
                    500: '#fa320a',
                    600: '#eb220b',
                    700: '#c3140b',
                    800: '#9b1211',
                    900: '#7d1311',
                    950: '#430709',
                },
                blue: {
                    50: '#edfaff',
                    100: '#d6f3ff',
                    200: '#b5ecff',
                    300: '#83e3ff',
                    400: '#48d0ff',
                    500: '#1eb3ff',
                    600: '#0696ff',
                    700: '#0082ff',
                    800: '#0863c5',
                    900: '#0d559b',
                    950: '#0e345d',
                },
                green: {
                    50: '#edfff6',
                    100: '#d6ffeb',
                    200: '#afffd8',
                    300: '#71ffbb',
                    400: '#2dfb97',
                    500: '#02e578',
                    600: '#00bf5f',
                    700: '#009f53',
                    800: '#067540',
                    900: '#085f37',
                    950: '#00361d',
                },
            },
            lineHeight: {
                text: '1.5',
            },
            letterSpacing: {
                text: '-0.2px',
            },
        },
    },
    plugins: [],
}
