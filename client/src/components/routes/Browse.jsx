import React from 'react'
import ErrorBoundary from '../../utils/ErrorBoundary'
import BrowseManager from '../browse/BrowseManager'

function Browse({}) {
    return (
        <ErrorBoundary>
            <BrowseManager/>
        </ErrorBoundary>
    )
}

export default Browse
