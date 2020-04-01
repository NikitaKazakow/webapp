<%--
  Created by IntelliJ IDEA.
  User: Nikita
  Date: 19.03.2020
  Time: 13:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="resources/css/style.css">
</head>
<body>
    <div>
        <div class=>
            <img src="resources/img/logo.png" width="85" height="85" alt="Main">
            <p>Система учета продаж автомобилей</p>
        </div>
    </div>
    <div>
        <form method="post" action="${pageContext.request.contextPath}/login">
            <p>Вход в систему:</p>
            <input type="text" required name="login" id="loginInput" placeholder="Логин">
            <input type="password" required name="password" id="passwordInput" placeholder="Пароль">
            <c:if test="${state == 1}">
                <div>
                    <p class="error">Неверный логин или пароль</p>
                </div>
            </c:if>
            <button type="submit">Войти</button>
            <a href="${pageContext.request.contextPath}/registration">Регистрация</a>
        </form>
    </div>
</body>
</html>
