<%--
  Created by IntelliJ IDEA.
  User: Pritam
  Date: 08-04-2020
  Time: 07:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" , content="text/html; charset=US-ASCII">
    <title>Login Success Page</title>
</head>
<body>
<h1>Hi <%= request.getAttribute("user") %>, Register Successful</h1>
<a href="Login.html">Login Page</a>
</body>
</html>
