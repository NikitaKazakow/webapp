<%--
  Created by IntelliJ IDEA.
  User: Никита
  Date: 16.04.2020
  Time: 21:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="error" scope="request" type="java.lang.String"/>
<html>
<head>
    <title>Добавление продажи</title>
    <link rel="stylesheet" type="text/css" href="resources/css/style.css">
</head>
<body>
<div class="fixed-header">
    <div class="container">
        <nav>
            <img class="logo" src="resources/img/back.png" alt="Главная страница">
            <a href="${pageContext.request.contextPath}/sale">Добавление продажи</a>
        </nav>
    </div>
</div>
<div class="add-dialog container">
    <form hidden id="cancelForm" action="${pageContext.request.contextPath}/sale" method="get"></form>
    <form id="addForm" method="post" action="${pageContext.request.contextPath}/sale?action=add">
        <c:choose>
            <c:when test="${error.equals('0')}">
                <jsp:useBean id="carList" scope="request" type="java.util.List<entity.CarEntity>"/>
                <jsp:useBean id="clientList" scope="request" type="java.util.List<entity.ClientEntity>"/>
                <p>Заполните данные продажи:</p>
                <select name="vin">
                    <c:forEach var="car" items="${carList}">
                        <option value="${car.vinNumberCar}">VIN номер: ${car.vinNumberCar}</option>
                    </c:forEach>
                </select>
                <select name="id">
                    <c:forEach var="client" items="${clientList}">
                        <option value="${client.passportNumber}">ФИО: ${client.fullNameClient}</option>
                    </c:forEach>
                </select>
                <input name="pay" type="number" step="1" required placeholder="Сумма"><div class="modal-button-container">
                <button form="cancelForm" class="delete-button" type="submit">Отмена</button>
                <button class="add-button" type="submit">Добавить</button>
            </div>
            </c:when>
            <c:when test="${error.equals('1')}">
                <p>База не проданных автомобилей пуста!</p>
                <a target="_blank" href="${pageContext.request.contextPath}/car?action=add">
                    Для оформления продажи необходимо добавить автомобиль...</a>
            </c:when>
        </c:choose>
    </form>
</div>
</body>
</html>
