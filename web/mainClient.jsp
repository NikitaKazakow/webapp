<%--
  Created by IntelliJ IDEA.
  User: Никита
  Date: 16.04.2020
  Time: 18:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="clientList" scope="request" type="java.util.List<entity.ClientEntity>"/>
<html>
<head>
    <title>Работа с клиентами</title>
    <link rel="stylesheet" type="text/css" href="resources/css/style.css">
</head>
<body>
<div class="fixed-header">
    <div class="container">
        <nav>
            <img class="logo" src="resources/img/back.png" alt="Главная страница">
            <a href="${pageContext.request.contextPath}/">Клиенты</a>
        </nav>
    </div>
</div>
<div>
    <table class="table-style">
        <tr>
            <th>ФИО</th>
            <th>Номер паспорта</th>
            <th>Адрес</th>
            <th>Номер телефона</th>
        </tr>
        <c:if test="${clientList.size() != 0}">
            <c:forEach var="client" items="${clientList}">
                <tr onclick="tableRowClick(this)" class="row-choice">
                    <td>${client.fullNameClient}</td>
                    <td>${client.passportNumber}</td>
                    <td>${client.homeAddressClient}</td>
                    <td>${client.phoneNumberClient}</td>
                </tr>
            </c:forEach>
        </c:if>
        <c:if test="${clientList.size() == 0}">
            <tr>
                <td colspan="4">База клиентов пуста..</td>
            </tr>
        </c:if>
    </table>
</div>
<div class="button-container">
    <form action="${pageContext.request.contextPath}/client" method="get">
        <input hidden name="action" value="add">
        <button class="add-button" type="submit">Добавить</button>
    </form>
</div>
<script>
    function tableRowClick(rowElement) {
        window.location.href = "/client?action=edit&id=" + rowElement.cells[1].innerText;
    }
</script>
</body>
</html>
