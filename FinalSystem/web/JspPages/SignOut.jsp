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
        session.removeAttribute("adminflg");
        response.sendRedirect("Newfolder/Login.jsp");
        
        session.removeAttribute("PMuser");
        response.sendRedirect("Newfolder/Login.jsp");
        
        session.removeAttribute("PMMflg");
        response.sendRedirect("Newfolder/Login.jsp");
         %>
    </body>
</html>
