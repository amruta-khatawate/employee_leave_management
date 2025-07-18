import React from 'react'
import '../styles/Login.css';

function Login() {
  return (
    <div className='login-container'>
      <div className='title'>
        <h2 className='headline'>Login</h2>
      </div>
      <form className='loginform' >
        <div>
           <label className='label'>Employee ID:</label>
           <input className='inpfield' type='text' placeholder='Enter your Emp id' required/>
        </div>

        <div>
           <label className='label'>Name:</label>
           <input className='inpfield' type='text' placeholder='Enter your name' required/>
        </div>

           <button className='btn' type='submit'>Submit</button>
      </form>
    </div>
  )
}

export default Login