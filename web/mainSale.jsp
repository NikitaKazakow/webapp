<%--
  Created by IntelliJ IDEA.
  User: Никита
  Date: 16.04.2020
  Time: 20:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="saleList" scope="request" type="java.util.List<entity.SaleEntity>"/>
<html>
<head>
    <title>Продажы</title>
    <link rel="stylesheet" type="text/css" href="resources/css/style.css">
</head>
<body>
<div class="fixed-header">
    <div class="container">
        <nav>
            <img class="logo" src="resources/img/back.png" alt="Главная страница">
            <a href="${pageContext.request.contextPath}/">Продажи</a>
        </nav>
    </div>
</div>
<div>
    <table class="table-style">
        <tr>
            <th>Клиент</th>
            <th>Автомобиль</th>
            <th>Дата</th>
            <th>Сумма</th>
        </tr>
        <c:if test="${saleList.size() != 0}">
            <c:forEach var="sale" items="${saleList}">
                <tr onclick="tableRowClick(this)" class="row-choice">
                    <td>
                        <p>ФИО: ${sale.client.fullNameClient}</p>
                        <p>Номер паспорта: ${sale.client.passportNumber}</p>
                        <p>Адрес: ${sale.client.homeAddressClient}</p>
                        <p>Номер телефона: ${sale.client.phoneNumberClient}</p>
                    </td>
                    <td>
                        <p>VIN номер: ${sale.carByVinNumberCarFk.vinNumberCar}</p>
                        <p>Цвет: ${sale.carByVinNumberCarFk.colourCar}</p>
                        <p>Страна: ${sale.carByVinNumberCarFk.manufactureCountry}</p>
                        <p>Марка: ${sale.carByVinNumberCarFk.markCar}</p>
                        <p>Модель: ${sale.carByVinNumberCarFk.modelCar}</p>
                        <p>Год производства: ${sale.carByVinNumberCarFk.vinNumberCar}</p>
                    </td>
                    <td>${sale.data}</td>
                    <td>${sale.paymentAmount}</td>
                </tr>
            </c:forEach>
        </c:if>
        <c:if test="${saleList.size() == 0}">
            <tr>
                <td colspan="4">База продаж пуста..</td>
            </tr>
        </c:if>
    </table>
</div>
<div class="button-container">
    <form action="${pageContext.request.contextPath}/sale" method="get">
        <input hidden name="action" value="add">
        <button class="add-button" type="submit">Добавить</button>
    </form>
</div>
<script>
    function tableRowClick(rowElement) {
        window.location.href = "/sale?action=edit&vin=" + rowElement.cells[1].innerText.split("\n")[0].split(" ", 3)[2]
            + "&id=" + rowElement.cells[0].innerText.split("\n\n")[1].split(" ")[2];
    }
</script>
</body>
</html>
