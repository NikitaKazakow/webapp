<%--
  Created by IntelliJ IDEA.
  User: Nikita
  Date: 18.03.2020
  Time: 15:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>Добро пожаловать!</title>
    <link rel="stylesheet" type="text/css" href="resources/css/style.css">
  </head>
  <body>
  <div class="fixed-header">
    <div class="container">
      <nav>
        <img class="logo" src="resources/img/logo.png" alt="Главная страница">
        <a href="${pageContext.request.contextPath}/">Продажа автомобилей</a>
        <div class="logout_container">
          <a>Пользователь: ${sessionScope.get("login")}</a>
          <form action="${pageContext.request.contextPath}/logout" method="get">
            <button type="submit">Выйти</button>
          </form>
        </div>
      </nav>
    </div>
  </div>
  <div class="container">
    <nav class="main-menu">
      <form action="${pageContext.request.contextPath}/client" method="get">
        <button type="submit">Работа с клиентами</button>
      </form>
      <form action="${pageContext.request.contextPath}/car" method="get">
        <input hidden name="vin" value="all">
        <button type="submit">Работа с автомобилями</button>
      </form>
      <form action="${pageContext.request.contextPath}/sale" method="get">
        <button type="submit">Работа с продажами</button>
      </form>
    </nav>
  </div>
  </body>
</html>
