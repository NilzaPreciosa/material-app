<%-- 
    Document   : new
    Created on : 9/Jan/2013, 13:04:25
    Author     : User
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%--
<%@ page import="org.springframework.security.ui.webapp.AuthenticationProcessingFilter" %>
<%@ page import="org.springframework.security.ui.AbstractProcessingFilter" %>
<%@ page import="org.springframework.security.AuthenticationException" %>
--%>

<html>
    <head>
        <link rel="stylesheet" type="text/css" href="../css/struture.css">
         <title>Login Page</title>
    </head>
    <body onload='document.f.j_username.focus();'>
<h3>Login with Username and Password</h3><form name='f' action='/security/j_spring_security_check' method='POST'>
 <table>
    <tr><td>User:</td><td><input type='text' name='j_username' value=''></td></tr>
    <tr><td>Password:</td><td><input type='password' name='j_password'/></td></tr>
    <tr><td colspan='2'><input name="submit" type="submit" value="Login"/></td></tr>
  </table>
</form></body></html>