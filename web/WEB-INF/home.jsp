<%-- 
    Document   : home
    Created on : Oct 2, 2017, 8:14:24 AM
    Author     : Administrator
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="sait" uri="/WEB-INF/tlds/sait.tld" %>

<sait:debug>
    Remote Host: ${pageContext.request.remoteHost}<br />
    Session ID: ${pageContext.session.id}
</sait:debug>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
    </head>
    <body>
        <h1>Home Page</h1>
        <p>
            Hello ${loggedInUsername}. <br>
            <a href ="login?action=logout">Logout</a>
        </p>
    </body>
</html>
