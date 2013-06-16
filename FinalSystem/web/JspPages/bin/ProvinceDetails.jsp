<%-- 
    Document   : newjsp
    Created on : Jun 1, 2013, 6:36:45 AM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>District Details</title>
    </head>
    <body>
        
        <form name="Provinceregform" method="get" action="../ProvinceRegister_Servlet" enctype="multipart/form-data">
             <table>
                <tr>
                    <td>
                         <label>Province Code :</label> 
                         </td>
                         <td>
                            <div> 
                            <input name="provincode" type="text" />
                            </div>
                         </td>
                </tr>
                <tr>
                      <td>
                         <label>Province Name :</label> 
                         </td>
                         <td>
                            <div> 
                            <input name="provincename" type="text" />
                            </div>
                        </td>
                     </tr>
                <tr>
                        <td>
                         <label>Description :</label> 
                         </td>
                         <td>
                            <div> 
                            <input name="decrp" type="text"/>
                            </div>
                    </td>
                    </tr>
                <tr>
                   <td>                 
                   <div>
                   <label>No of Districts :</label>    
                    </div>
                    </td>
                   <td>
                    <div>
                        <select name="Nodistrcs">
                            <option value="1" >1</option>
                            <option value="2" >2</option>
                            <option value="3" >3</option>
                            <option value="4" >4</option>
                            <option value="5" >5</option>
                            <option value="6" >6</option>
                            <option value="7" >7</option>
                            <option value="8" >8</option>
                            <option value="9" >9</option>                        
                        </select> 
                    </div>
                    </td>
                   
                    </tr>  
            </table>
            <br>
            <input type="submit" value="Submit" name="provinceregbtn" id="provinceregbtn"/>
        </form>
    </body>
</html>
