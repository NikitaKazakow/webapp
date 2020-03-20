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
    <link rel="stylesheet" type="text/css" href="resources/css/style.css">
</head>
<body>
    <div class="header">
        <div class="logo">
            <img src="resources/img/logo.png" width="85" height="85">
            <p>Система учета продаж автомобилей</p>
        </div>
    </div>
    <div class="login-form">
        <form method="post" action="${pageContext.request.contextPath}/login.jsp">
            <p>Вход в систему:</p>
            <input type="text" required name="login" id="loginInput" placeholder="Логин">
            <input type="password" required name="password" id="passwordInput" placeholder="Пароль">
            <button type="submit">Войти</button>
        </form>
    </div>
</body>
</html>
