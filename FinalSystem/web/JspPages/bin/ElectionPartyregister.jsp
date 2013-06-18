<%-- 
    Document   : ElectionPartyregister
    Created on : Jun 5, 2013, 4:20:05 AM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Election Party</h1>
         <form name="electpartyregform" method="get" action="../ElectPartyRegister_Servlet" enctype="multipart/form-data">
             <table>
                <tr>
                    <td>
                         <label>Election Party Code :</label> 
                         </td>
                         <td>
                            <div> 
                            <input name="electpcode" type="text" />
                            </div>
                         </td>
                </tr>
                <tr>
                      <td>
                         <label>Party Name :</label> 
                         </td>
                         <td>
                            <div> 
                            <input name="fname" type="text" />
                            </div>
                    </td>
                     </tr>
                <tr>
                      <td>
                       <label>Registed Date :</label>   
                      </td>
                      <td>
                        <input type="text" name="regdate"/>
                      </td>
                </tr>
                <tr>
                    <td>
                         <label>Logo :</label>
                    </td>
                    <td>
                         <div> 
                             <input type="file" name="partylogo" /> 
                      </div>
                    </td>
                </tr>
                <tr>
                      <td>
                        <div>
                         <label> Sectry Name :</label>   
                        </div>
                    </td>
                    <td>     <div>
                 <select name="secname">
                    <option value="" >A</option>
                    <option value=""  >B</option>
                    <option value="" >V</option>
                 </select> 
                              	</div>
                    </td>
                    </tr>
                <tr>
                      <td>
                         <label>  No:</label>   
                       </td>
                       <td>
                    <div> 
                       <input name="no" type="text"  class="large" placeholder="Mobile No"/>
                   </div>
                       </td>
                      
                    </tr>
           </table>
            <br>
            <input type="submit" value="Submit" name="adminregbtn" id="adminregbtn"/>
        </form>
    </body>
</html>
