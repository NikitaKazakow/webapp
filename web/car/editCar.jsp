<%--
  Created by IntelliJ IDEA.
  User: Никита
  Date: 08.04.2020
  Time: 20:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Редактирование данных машины</title>
    <link rel="stylesheet" type="text/css" href="../resources/css/style.css">
</head>
<body>
<div class="fixed-header">
    <div class="container">
        <nav>
            <img class="logo" src="../resources/img/back.png">
            <a href="${pageContext.request.contextPath}/car?vin=all">Редактирование данных автомобиля</a>
        </nav>
    </div>
</div>
<div class="container add-dialog">
    <div class="dialog-panel">
        <p>Редактирование данных автомобиля:</p>
    </div>

    <jsp:useBean id="updateCar" scope="request" type="entity.CarEntity"/>
    <form id="deleteCar" hidden method="post" action="${pageContext.request.contextPath}/car?action=delete">
        <input name="vin" hidden type="number" minlength="4" maxlength="4" value="${updateCar.vinNumberCar}">
    </form>
    <form id="editCar" class="edit-form" method="post" action="${pageContext.request.contextPath}/car?action=update">
        <label>
            VIN номер
            <input readonly name="vin" type="text" required value="${updateCar.vinNumberCar}">
        </label>
        <label>
            Цвет
            <input name="colour" type="text" required value="${updateCar.colourCar}">
        </label>
        <label>
            Страна производитель
            <input name="country" type="text" required value="${updateCar.manufactureCountry}">
        </label>
        <label>
            Марка
            <input name="mark" type="text" required value="${updateCar.markCar}">
        </label>
        <label>
            Модель
            <input name="model" type="text" required value="${updateCar.modelCar}">
        </label>
        <label>
            Год производства
            <input name="year" type="number" pattern="1?[0-9]{3}$" minlength="4" maxlength="4" step="1" required value="${updateCar.yearOfIssueCar}">
        </label>
        <menu class="button-container">
            <button form="deleteCar" formmethod="post" type="submit" class="delete-button">Удалить</button>
            <button form="editCar" formmethod="post"  type="submit" class="add-button">Сохранить</button>
        </menu>
    </form>
</div>
</body>
</html>
