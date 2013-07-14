<%-- 
    Document   : SignOut
    Created on : Dec 17, 2012, 11:24:57 AM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Logout</title>
    </head>
    <body>
       
        <%
        session.removeAttribute("Admindetals");
        response.sendRedirect("Adminlogin.jsp");
        session.setAttribute("Admindetals",null);
        
        session.removeAttribute("PMuser");
        response.sendRedirect("Adminlogin.jsp");
        
        session.removeAttribute("P;MMflg");
        response.sendRedirect("Adminlogin.jsp");
         %>
    </body>
</html>
