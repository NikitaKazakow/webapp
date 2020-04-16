<%--
  Created by IntelliJ IDEA.
  User: Никита
  Date: 16.04.2020
  Time: 20:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="error" scope="request" class="java.lang.String" type="java.lang.String"/>
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
            <a href="${pageContext.request.contextPath}/client">Добавление клиента</a>
        </nav>
    </div>
</div>
<div class="add-dialog container">
    <form hidden id="cancelForm" action="${pageContext.request.contextPath}/client" method="get"></form>
    <form id="addForm" method="post" action="${pageContext.request.contextPath}/client?action=add">
        <section>
            <p>Заполните данные клиента:</p>
            <c:choose>
                <c:when test="${error.equals('1')}">
                    <jsp:useBean id="client" scope="request" class="entity.ClientEntity" type="entity.ClientEntity"/>
                    <input name="name" type="text" required placeholder="ФИО"
                           value="${client.fullNameClient}">
                    <input name="id" type="text" required placeholder="Номер паспорта с серией"
                           value="${client.passportNumber}">
                    <a class="input-error">В базе уже есть клиент с таким номером паспорта</a>
                    <input name="address" type="text" required placeholder="Адрес"
                           value="${client.homeAddressClient}">
                    <input name="phone" type="text" required placeholder="Номер телефона"
                           value="${client.phoneNumberClient}">
                </c:when>
                <c:when test="${error.equals('0')}">
                    <input name="name" type="text" required placeholder="ФИО">
                    <input name="id" type="text" required placeholder="Номер паспорта с серией">
                    <input name="address" type="text" required placeholder="Адрес">
                    <input name="phone" type="text" required placeholder="Номер телефона">
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
