<%-- 
    Document   : index
    Created on : Apr 15, 2015, 6:30:04 PM
    Author     : NamIT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <center>
            <h1>Login</h1>
            <form action="LoginController" method="POST">
                <input name="user" type="text" placeholder="User" value="" /> 
                <br />
                <input name="pass"  type="password" placeholder="Password" value="" /><br />
                <input type="submit" value="Login" />
            </form>
        </center>
    </body>
</html>
