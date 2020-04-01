<%--
  Created by IntelliJ IDEA.
  User: Никита
  Date: 31.03.2020
  Time: 17:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Регистрация</title>
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
        <form method="post" action="${pageContext.request.contextPath}/registration">
            <p>Регистрация:</p>
            <input type="text" required name="login" id="loginInput" placeholder="Логин">
            <c:if test="${state == 2}">
                <p class="error">Пользователь с таким иминем уже есть в системе</p>
            </c:if>
            <input type="password" required name="password" id="passwordInput" placeholder="Пароль">
            <input type="password" required name="password2" id="passwordInput2" placeholder="Пароль еще раз">
            <c:if test="${state == 3}">
                <p class="error">Пароли не совпадают</p>
            </c:if>
            <button type="submit">Зарегистрироваться</button>
        </form>
    </div>
</body>
</html>
