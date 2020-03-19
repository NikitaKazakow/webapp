<%--
  Created by IntelliJ IDEA.
  User: Nikita
  Date: 19.03.2020
  Time: 13:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <header>
        <img src="resources/img/logo.png" alt="webApp" width="96" height="96">
        <h1>Sales management</h1>
    </header>
    <form method="post" action="${pageContext.request.contextPath}/login.jsp">
        <label>
            <input type="text" name="login">
            <input type="password" name="password">
            <input type="submit" title="Войти">
        </label>
    </form>
</body>
</html>
