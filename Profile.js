import React from 'react'
import "./Profile.css";
import { useState } from 'react';
function Profile() {
  let[image,setImage]=useState("");
  let[state,setState]=useState({
    "name":"",
    "gender":"",
    "email":"",
    "description":""
  })
  let[theme,setTheme]=useState({
    "bgColor":"white",
    "textColor":"black",
    "title":"LIGHT MODE"
  })
  var image1="data:image/jpeg;base64,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";
  var image2="data:image/jpeg;base64,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";
 const changeTheme=(event)=>{
  if(event.target.checked)
  {
    setTheme({
      "bgColor":"black",
      "textColor":"white",
      "title":"SWITCH TO DARK MODE"
    })
  }
  else{
    setTheme({
      "bgColor":"white",
      "textColor":"black",
      "title":"SWITCH TO LIGHT MODE"
    })
  }

 }
 const changeToRajat=()=>{
  setImage(image1);
  setState({
    "name":"RAJAT SHARMA",
    "gender":"MALE",
    "email":"rj@gmail.com",
    "description":"HE IS JAVA PROFESSIONAL"
  })
 }
 const changeToRiya=()=>{
  setImage(image2);
  setState({
    "name":"RIYA SHARMA",
    "gender":"FEMALE",
    "email":"ry@gmail.com",
    "description":"SHE IS ORACLE PROFESSIONAL"
  })
 }
  return (
    
  
    <div className='profileContainer'>
        <div className='leftContainer'>
        <img src={image}
        height="200px"
        width="200px"
        alt="NO IMAGE"/>
         
        </div>
        <div className='rightContainer' style={{backgroundColor:theme.bgColor,color:theme.textColor}}>
         <h2>PROFILE</h2>
         <h2>NAME:{state.name}</h2>
         <h2>GENDER:{state.gender}</h2>
         <h2>EMAIL:{state.email}</h2>
         <h2>DESCRIPTION:{state.description}</h2>
         <button onClick={changeToRajat}>RAJAT SHARMA</button>&nbsp;&nbsp;
         <button onClick={changeToRiya}>RIYA SHARMA</button>
         <br></br><br></br>
         <input type="checkbox" onChange={changeTheme}></input>
         <h2>{theme.title}</h2>
        </div>
      
    </div>
  )
}

export default Profile