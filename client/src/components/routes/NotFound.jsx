import { Link } from 'react-router-dom'

function NotFound() {
    return (
        <article className='p-[100px]'>
            <h1>Oops!</h1>
            <p>Page Not Found</p>
            <div className="flex items-center justify-center">
                <Link to="/" className='text-blue-600 hover:text-blue-800'>Visit Our Homepage</Link>
            </div>
        </article>
    )
}

export default NotFound
