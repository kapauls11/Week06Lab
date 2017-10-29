<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="login" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="sait" uri="/WEB-INF/tlds/sait.tld" %>

<sait:debug>
    Remote Host: ${pageContext.request.remoteHost}<br />
    Session ID: ${pageContext.session.id}
</sait:debug>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>

    <body>
        <h1>Remember Me Login Page</h1>

        <login:loginTag></login:loginTag>

        ${errorMessage}
        ${successMessage}
    </body>
</html>


