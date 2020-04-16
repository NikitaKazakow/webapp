<%--
  Created by IntelliJ IDEA.
  User: Никита
  Date: 11.04.2020
  Time: 16:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean id="error" scope="request" class="java.lang.String" type="java.lang.String"/>
<jsp:useBean id="car" scope="request" class="entity.CarEntity" type="entity.CarEntity"/>

<html>
<head>
    <title>Добавление автомобиля</title>
    <link rel="stylesheet" type="text/css" href="resources/css/style.css">
</head>
<body>
<div class="fixed-header">
    <div class="container">
        <nav>
            <img class="logo" src="resources/img/back.png" alt="Главная страница">
            <a href="${pageContext.request.contextPath}/car?vin=all">Добавление автомобиля</a>
        </nav>
    </div>
</div>
<div class="add-dialog container">
    <form hidden id="cancelForm" action="${pageContext.request.contextPath}/car" method="get">
        <input hidden name="vin" value="all">
    </form>
    <form id="addForm" method="post" action="${pageContext.request.contextPath}/car?action=add">
        <section>
            <p>Заполните данные автомобиля:</p>
            <c:choose>
                <c:when test="${error.equals('1')}">
                    <input name="vin" type="text" required placeholder="VIN номер" value="${car.vinNumberCar}">
                    <a class="input-error">Машина с таким VIN же есть в базе</a>
                    <input name="colour" type="text" required placeholder="Цвет" value="${car.colourCar}">
                    <input name="country" type="text" required placeholder="Страна производитель"
                           value="${car.manufactureCountry}">
                    <input name="mark" type="text" required placeholder="Марка" value="${car.markCar}">
                    <input name="model" type="text" required placeholder="Модель" value="${car.modelCar}">
                    <input name="year" type="number" pattern="1?[0-9]{3}$" minlength="4" maxlength="4"
                           step="1" required placeholder="Год производства" value="${car.yearOfIssueCar}">
                </c:when>
                <c:when test="${error.equals('0')}">
                    <input name="vin" type="text" required placeholder="VIN номер">
                    <input name="colour" type="text" required placeholder="Цвет">
                    <input name="country" type="text" required placeholder="Страна производитель">
                    <input name="mark" type="text" required placeholder="Марка">
                    <input name="model" type="text" required placeholder="Модель">
                    <input name="year" type="number" pattern="1?[0-9]{3}$" minlength="4" maxlength="4"
                           step="1" required placeholder="Год производства">
                </c:when>
            </c:choose>
        </section>
        <div class="modal-button-container">
            <button form="cancelForm" class="delete-button" type="submit">Отмена</button>
            <button class="add-button" type="submit">Добавить</button>
        </div>
    </form>
</div>
</body>
</html>
