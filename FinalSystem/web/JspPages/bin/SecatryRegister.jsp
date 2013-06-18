<%-- 
    Document   : SecatryRegister
    Created on : Jun 5, 2013, 5:06:05 AM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Online Election Voting</title>
    </head>
    <body>
        <h1>Sectary Details Registration </h1>
         <form name="adminregform" method="post" action="../AdminRegister_Servlet" >
             <table>
                <tr>
                    <td>
                         <label>User Code :</label> 
                         </td>
                         <td>
                            <div> 
                            <input name="usercode" type="text" />
                            </div>
                         </td>
                </tr>
                <tr>
                      <td>
            <label>User Type:</label> 
                         </td>
                         <td>
               <div>
                 <select name="usrtyp">
                    <option value="Administrator" >Administrator</option>
                    <option value="Candidates"  >Candidates</option>
                     <option value="Sectry" >Sectary</option>
                    <option value="Voter" >Voter</option>
                 </select> 
              </div>
                    </td>
                    </tr>
                <tr>
                      <td>
                         <label>First Name :</label> 
                         </td>
                         <td>
                            <div> 
                            <input name="fname" type="text" />
                            </div>
                    </td>
                     </tr>
                     <tr>
                        <td>
                         <label>Last Name :</label> 
                         </td>
                         <td>
                            <div> 
                            <input name="lname" type="text" />
                            </div>
                    </td>
                    </tr>
                <tr>
                      <td>                 
                   <div>
                   <label>Gender :</label>    
                    </div>
                    </td>
                    <td> 
                    <div>
                    <input type="radio" name="gndr" id="radio-1" value="Male"  checked="checked"/>    
                    <label for="radio-1">Male</label>
                    </div>
                   </td>
                   
                   <td>
                   <div>
                   <input type="radio" name="gndr" id="radio-2" value="Female"  />
                   <label for="radio-2" >Female</label>
                   </div>
                    </td>
                    </tr>  
                <tr>
                      <td>
                        <div>
                         <label> NIC No :</label>   
                        </div>
                    </td>
                    <td> <div> <input type="text"  name="nic" />
                              	</div></td>
                    </tr>
                <tr>
                      <td>
                         <label> Contact No:</label>   
                       </td>
                       <td>
                    <div> 
                       <input name="mbno" type="text"  class="large" placeholder="Mobile No"/>
                   </div>
                       </td>
                       <td>
                           <div> 
                       <input name="lndno" type="text"  class="large" placeholder="Resident No"/>
                   </div>
                       </td>
                    </tr>
                <tr>
                      <td>
                       <label>Birthday picker :</label>   
                      </td>
                      <td>
                        <input type="text" name="birthday"/>
                      </td>
                </tr>
                <tr>
                    <td>
                      <label>Email :</label>
                    </td>
                    <td>
                      <div> 
                   <input type="text" name="e_mail" />
                     </div>
                    </td>
                </tr>
                <tr>
                    <td>
                         <label>Profile Picture :</label>
                    </td>
                    <td>
                         <div> 
                             <input type="file" name="uProperty" /> 
                      </div>
                    </td>
                </tr>
                  <tr>
                    <td>
                         <label>User Name :</label>
                    </td>
                    <td>
                         <div> 
                             <input type="text" name="usernam" />
                     </div>
                    </td>
                </tr>
                 <tr>
                    <td>
                         <label>Password :</label>
                    </td>
                    <td>
                         <div> 
                             <input type="password" name="passwrd" />
                     </div>
                    </td>
                </tr>
                 <tr>
                    <td>
                         <label>Confirm Password :</label>
                    </td>
                    <td>
                         <div> 
                             <input type="password" name="conpasswrd" />
                     </div>
                    </td>
                </tr>
                 <tr>
                    <td>
                         <label>Political Party :</label>
                    </td>
                    <td>
                         <div> 
                             <input type="text" name="loc" />
                     </div>
                    </td>
                </tr>
            </table>
            <br>
            <input type="submit" value="Submit" name="sectaryregbtn" id="sectaryregbtn"/>
        </form>
    </body>
</html>
