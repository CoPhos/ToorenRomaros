import React from 'react'
import styled from 'styled-components'
import { fontSizes } from './globalStyles'

function Tittle({ text, margin, tittle, sizes }) {
    if (!sizes) {
        sizes = {
            tittleM: fontSizes.mh6,
            tittleD: fontSizes.h6,
            base: fontSizes.base,
        }
    }
    return (
        <Div args={{ marginValue: margin, sizesValue: sizes }}>
            {tittle && <P className="tittle notBlue">{tittle}</P>}
            {text && <P className="text notBlue">{text}</P>}
        </Div>
    )
}

const Div = styled.div`
    display: flex;
    flex-direction: column;
    align-items: flex-start;
    justify-content: center;
    margin: ${(props) => props.args.marginValue};
    .tittle {
        font-size: ${(props) => props.args.sizesValue.tittleM};
        @media only screen and (min-width: 904px) {
            font-size: ${(props) => props.args.sizesValue.tittleD};
        }
    }
    .text {
        font-size: ${(props) => props.args.sizesValue.base};
        font-weight: normal;
    }
`

const P = styled.p`
    font-weight: bold;
    margin: 0;
    margin-left: 4px;
    padding-left: 8px;
    border-left: 4px solid ${(props) => props.theme.colors.main};
`

export default Tittle
