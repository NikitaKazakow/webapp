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
    <title>Вход в систему</title>
    <link rel="stylesheet" type="text/css" href="resources/css/style.css">
</head>
<body>
    <div class="fixed-header">
        <div class="container">
            <nav>
                <img class="logo" src="resources/img/logo.png">
                <a href="/">Продажа автомобилей</a>
            </nav>
        </div>
    </div>
    <form class="login_form" method="post" action="${pageContext.request.contextPath}/">
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
</body>
</html>
