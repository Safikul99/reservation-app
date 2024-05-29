import { useState } from 'react';
import '..//Styles/AdminLogin.css'
import { Link } from 'react-router-dom';
const  AdminLogin= () => {
    let[username,setusername]=useState("")
    let[password,setpassword]=useState("")

    function verify(){
        if(username=="abcd" && password==1234)
            {
                alert("Login Sucessfully")
            }
            else{
                alert("login failed")
            }
    }
    return ( 
        <div className="AdminLogin">
            <form onSubmit={verify} action="">
                <label htmlFor="">
                    Username
                </label>
                   <input type="text" value={username} onChange={(e)=>{setusername(e.target.value)}} placeholder="Enter the username" required/>
                <label htmlFor="">
                   Pasword
               </label>
                 <input type="text" value={password} onChange={(e)=>{setpassword(e.target.value)}} placeholder="Enter the password" required/>
                 <button className="btn btn-prmary">Login</button>
            </form>
            <p>Are you the new user ? <Link to="/adminsingup">Register here...</Link></p>

        </div>

    );
}
 
export default AdminLogin;