<%-- 
    Document   : login
    Created on : Oct 2, 2017, 8:14:41 AM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>

    <body>
        <h1>Remember Me Login Page</h1>

        <form action="login" method="post">
            Username: <input type="text" name="username" value="${username}"></br>
            Password: <input type="password" name="password" value="${password}"></br>
            <input type="submit" value="login"><br>
            <input type="checkbox" name="rememberMe" value ="${rememberMe}"> Remember me </br>
        </form>


        ${errorMessage}
        ${successMessage}
    </body>
</html>