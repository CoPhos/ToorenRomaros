import React, { Fragment } from "react"

class ErrorBoundary extends React.Component {
    constructor(props) {
        super(props)
        this.state = { error: null, errorInfo: null }
    }

    componentDidCatch(error, errorInfo) {
       this.setState({
           error: error,
           errorInfo: errorInfo,
       })
    }

    render() {
        if (this.state.errorInfo) {
            return (
                <Fragment>
                    <h1>Something went wrong.</h1>
                    <h2>please try again later...</h2>
                </Fragment>
            )
        }

        return this.props.children
    }
}

export default ErrorBoundary