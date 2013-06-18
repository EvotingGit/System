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
        <title>Polling Division Details</title>
    </head>
    <body>
        <h1>Polling Division Details</h1>
         <form name="PollingDiviregform" method="post" action="../PollingDivisionRegister_Servlet">
             <table>
                <tr>
                    <td>
                         <label>Polling Division Code :</label> 
                         </td>
                         <td>
                            <div> 
                            <input name="p_divisioncode" type="text" />
                            </div>
                         </td>
                </tr>
                <tr>
                      <td>
                         <label>Polling Division Name :</label> 
                         </td>
                         <td>
                            <div> 
                            <input name="p_divisionname" type="text" />
                            </div>
                        </td>
                     </tr>
                      <tr>
                   <td>                 
                   <div>
                   <label>District Name :</label>    
                    </div>
                    </td>
                   <td>
                    <div>
                        <select name="distrcid">
                            <option value="c6628449-47a7-4eb5-993d-96b131030c12">Colombo</option>
                            <option value="" >Gampaha</option>                
                        </select> 
                    </div>
                    </td>
                     </tr>  
                       <tr>
                    <td>
                         <label>Registered Political Parties :</label> 
                         </td>
                         <td>
                            <div> 
                            <input name="politicalpartyamount" type="text" />
                            </div>
                         </td>
                </tr>
                 <tr>
                    <td>
                         <label>Registered Voters :</label> 
                         </td>
                         <td>
                            <div> 
                            <input name="regisvoteramount" type="text" />
                            </div>
                         </td>
                </tr>
            </table>
            <br>
            <input type="submit" value="Submit" name="polldivisionregbtn" id="polldivisionregbtn"/>
        </form>
    </body>
</html>
