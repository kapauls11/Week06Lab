<%@tag description="loginTag" pageEncoding="UTF-8"%>

<%@attribute name="username"%>
<%@attribute name="password"%>
<%@attribute name="rememberMe"%>


<form action="login" method="post">
    Username: <input type="text" name="username" value="${username}"></br>
    Password: <input type="password" name="password" value="${password}"></br>
    <input type="submit" value="login"><br>
    <input type="checkbox" name="rememberMe" value ="${rememberMe}"> Remember me </br>
</form>

