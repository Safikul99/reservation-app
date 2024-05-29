import React,{useState} from "react";
import '../Styles/AdminSignup.css'
const  AdminSingUp= () => {

    let [name,setname]=useState("")
    let[email,setemail]=useState("")
    let[password,setpassword]=useState("")
    let[phone,setphone]=useState("")
    let[gst_number,setgstno]=useState("")
    let[travels_name,settravel]=useState("")
    return ( 
        <div className="AdminSignUp">
          <form action="">
            <label htmlFor="">Name</label>
            <input type="text" required placeholder="Enter the name" value={name} onChange={(e)=>setname(e.target.value)} />
            <label htmlFor="">Email</label>
            <input type="text" required placeholder="Enter the Email" value={email} onChange={(e)=>setemail(e.target.value)} />
            <label htmlFor="">Phone</label>
            <input type="text" required placeholder="Enter the phone" value={phone} onChange={(e)=>setphone(e.target.value)} />
            <label htmlFor="">Gstno</label>
            <input type="text" required placeholder="Enter the gst number" value={gst_number} onChange={(e)=>setgstno(e.target.value)} />
            <label htmlFor="">Travels</label>
            <input type="text" required placeholder="Enter the Travels name" value={travels_name} onChange={(e)=>settravel(e.target.value)} />
            <label htmlFor="">password</label>
            <input type="text" required placeholder="Enter the Password" value={password} onChange={(e)=>setpassword(e.target.value)} />
       <button className="btn btn-primary">submit</button>
            




          </form>
        </div>
     );
}
 
export default AdminSingUp ;