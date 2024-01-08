import React from 'react'
import { Link } from 'react-router-dom'

function LoginContainer({active}) {
    const show = 'flex flex-col items-center justify-start gap-2 w-full'
    const notShow = 'hidden'

  return (
      <div className={`${active === 2 ? show : notShow}`}>
          <p className="text-white-700 text-small-m-400 lg:text-small-d-400 text-center w-full">
              Welcome back!
          </p>
          <form
              //onSubmit={handleSubmit}
              className="flex flex-col items-start justify-center gap-1 w-[344px] mt-8"
          >
              <div className="w-full">
                  <label
                      htmlFor="usernameSignin"
                      className="block text-gray-700 text-sm text-small-m-700 lg:text-small-d-700"
                  >
                      Username
                  </label>
                  <input
                      type="text"
                      id="usernameSignin"
                      name="username"
                    //   value={formData.username}
                    //   onChange={handleChange}
                      className="h-[36px] p-1 border border-gray-300 w-full text-small-m-400 lg:text-small-d-400"
                      required
                  />
                  <p className="text-tiny-m-400 lg:text-tiny-d-400">
                      placeholder
                  </p>
              </div>

              <div className="w-full">
                  <label
                      htmlFor="passwordSignin"
                      className="block text-gray-700 text-sm text-small-m-700 lg:text-small-d-700"
                  >
                      Password
                  </label>
                  <input
                      type="password"
                      id="passwordSignin"
                      name="password"
                    //   value={formData.password}
                    //   onChange={handleChange}
                      className="h-[36px] p-1 border border-gray-300 w-full text-small-m-400 lg:text-small-d-400"
                      required
                  />
              </div>

              <button
                  type="submit"
                  className="flex flex-row items-center justify-center mt-2 w-full text-white-50 text-small-m-400 lg:text-small-d-400 rounded bg-[#404040] py-1 h-full hover:cursor-pointer hover:opacity-50"
              >
                  Sign Up
              </button>
              <Link
                  to="/forgotpassword"
                //   Close panel onClick
                  className="text-tiny-m-700 lg:text-tiny-d-700 underline hover:cursor-pointer w-full text-center"
              >
                  Forgot Password?
              </Link>
          </form>
      </div>
  )
}

export default LoginContainer