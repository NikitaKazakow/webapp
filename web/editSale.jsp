<%--
  Created by IntelliJ IDEA.
  User: Никита
  Date: 16.04.2020
  Time: 23:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="sale" scope="request" type="entity.SaleEntity" class="entity.SaleEntity"/>
<jsp:useBean id="carList" scope="request" type="java.util.List<entity.CarEntity>"/>
<jsp:useBean id="clientList" scope="request" type="java.util.List<entity.ClientEntity>"/>
<html>
<head>
    <title>Редактирование данных продажи</title>
    <link rel="stylesheet" type="text/css" href="resources/css/style.css">
</head>
<body>
<div class="fixed-header">
    <div class="container">
        <nav>
            <img class="logo" src="resources/img/back.png" alt="Назад">
            <a href="${pageContext.request.contextPath}/sale">Редактирование данных продажи</a>
        </nav>
    </div>
</div>
<div class="container add-dialog">
    <div class="dialog-panel">
        <p>Редактирование данных продажи:</p>
    </div>
    <form id="deleteSale" hidden method="get" action="${pageContext.request.contextPath}/sale">
        <input name="action" hidden value="delete">
        <input name="id" hidden value="${sale.passportNumberClientFk}">
        <input name="vin" hidden value="${sale.vinNumberCarFk}">
    </form>
    <form id="editSale" method="post" action="${pageContext.request.contextPath}/sale?action=edit">
        <label>
            Автомобиль
            <select name="vin">
                <c:forEach var="car" items="${carList}">
                    <option value="${car.vinNumberCar}">VIN номер: ${car.vinNumberCar}</option>
                </c:forEach>
            </select>
        </label>
        <label>
            Клиент
            <select name="id">
                <c:forEach var="client" items="${clientList}">
                    <option value="${client.passportNumber}">ФИО: ${client.fullNameClient}</option>
                </c:forEach>
            </select>
        </label>
        <label>
            Дата
            <input name="date" type="date" required value="${sale.data}">
        </label>
        <label>
            Сумма
            <input name="pay" type="number" step="1" required value="${sale.paymentAmount}">
        </label>
        <div class="button-container">
            <button form="deleteSale" formmethod="get" type="submit" class="delete-button">Удалить</button>
            <button form="editSale" formmethod="post"  type="submit" class="add-button">Сохранить</button>
        </div>
    </form>
</div>
</body>
</html>
