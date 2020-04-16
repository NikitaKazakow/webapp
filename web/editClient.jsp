<%--
  Created by IntelliJ IDEA.
  User: Никита
  Date: 16.04.2020
  Time: 20:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Редактирование данных клиента</title>
    <link rel="stylesheet" type="text/css" href="resources/css/style.css">
</head>
<body>
<div class="fixed-header">
    <div class="container">
        <nav>
            <img class="logo" src="resources/img/back.png" alt="Назад">
            <a href="${pageContext.request.contextPath}/client">Редактирование данных клиента</a>
        </nav>
    </div>
</div>
<div class="container add-dialog">
    <div class="dialog-panel">
        <p>Редактирование данных клиента:</p>
    </div>
    <jsp:useBean id="client" scope="request" type="entity.ClientEntity" class="entity.ClientEntity"/>
    <form id="deleteClient" hidden method="get" action="${pageContext.request.contextPath}/client">
        <input name="action" hidden value="delete">
        <input name="id" hidden value="${client.passportNumber}">
    </form>
    <form id="editClient" method="post" action="${pageContext.request.contextPath}/client?action=edit">
        <label>
            <div class="label-text">ФИО</div>
            <input name="name" type="text" required value="${client.fullNameClient}">
        </label>
        <label>
            <div class="label-text">Номер паспорта</div>
            <input name="id" type="text" readonly required value="${client.passportNumber}">
        </label>
        <label>
            <div class="label-text">Адрес</div>
            <input name="address" type="text" required value="${client.homeAddressClient}">
        </label>
        <label>
            <div class="label-text">Номер телефона</div>
            <input name="phone" type="text" required value="${client.phoneNumberClient}">
        </label>
        <div class="button-container">
            <button form="deleteClient" formmethod="get" type="submit" class="delete-button">Удалить</button>
            <button form="editClient" formmethod="post"  type="submit" class="add-button">Сохранить</button>
        </div>
    </form>
</div>
</body>
</html>
