<%-- 
    Document   : loginTag
    Created on : Oct 16, 2017, 8:16:38 AM
    Author     : Administrator
--%>

<%@tag description="put the tag description here" pageEncoding="UTF-8"%>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="username"%>
<%@attribute name="password"%>
<%@attribute name="rememberMe"%>


<%-- any content can be specified here e.g.: --%>


<form action="login" method="post">
    Username: <input type="text" name="username" value="${username}"></br>
    Password: <input type="password" name="password" value="${password}"></br>
    <input type="submit" value="login"><br>
    <input type="checkbox" name="rememberMe" value ="${rememberMe}"> Remember me </br>
</form>

