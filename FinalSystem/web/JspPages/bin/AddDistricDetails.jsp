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
        <title>Province Details</title>
    </head>
    <body>
        <h1> World!</h1>
         <form name="Districregform" method="post" action="../DistrictRegister_Servlet">
             <table>
                <tr>
                    <td>
                         <label>District Code :</label> 
                         </td>
                         <td>
                            <div> 
                            <input name="districtcode" type="text" />
                            </div>
                         </td>
                </tr>
                <tr>
                      <td>
                         <label>District Name :</label> 
                         </td>
                         <td>
                            <div> 
                            <input name="districtname" type="text" />
                            </div>
                        </td>
                     </tr>
                <tr>
                   <td>                 
                   <div>
                   <label>No of Polling Divisions :</label>    
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
                    
                      <tr>
                   <td>                 
                   <div>
                   <label>Province Name :</label>    
                    </div>
                    </td>
                   <td>
                    <div>
                        <select name="provinceid">
                            <option value="1151264d-3174-4e67-9afc-4b7c69cb49eb" >Western Province</option>
                            <option value="Central" >Central Province</option>                
                        </select> 
                    </div>
                    </td>
                   
                    </tr>  
            </table>
            <br>
            <input type="submit" value="Submit" name="districtregbtn" id="districtregbtn"/>
        </form>
    </body>
</html>
