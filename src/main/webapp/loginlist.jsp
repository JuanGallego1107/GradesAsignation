<%--
  Created by IntelliJ IDEA.
  User: galle
  Date: 24/09/2023
  Time: 5:27 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>LoginList</title>
</head>
<body>
<h3><%= "Login para la lista" %>
</h3>
<form action="loginlist" method="post">
    <div>
        <label for="username">Username</label>
        <div>
            <input type="text" name="username" id="username">
        </div>
    </div>
    <div>
        <label for="password">Password</label>
        <div>
            <input type="password" name="password" id="password">
        </div>
    </div>
    <div>
        <input type="submit" value="Login">
    </div>
</form>
</body>
</html>
