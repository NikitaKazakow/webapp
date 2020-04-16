<%--
  Created by IntelliJ IDEA.
  User: Никита
  Date: 09.04.2020
  Time: 21:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="vin" scope="request" class="java.lang.String" type="java.lang.String"/>
<jsp:useBean id="complectaionList" scope="request" type="java.util.List<entity.ComplectationEntity>"/>
<html>
<head>
    <title>Комплектации</title>
    <link rel="stylesheet" type="text/css" href="resources/css/style.css">
</head>
<body>
<div class="fixed-header">
    <div class="container">
        <nav>
            <img class="logo" src="resources/img/back.png" alt="Главная страница">
            <a href="${pageContext.request.contextPath}/car?vin=all">Комплектации автомобиля</a>
        </nav>
    </div>
</div>
<div>
    <table class="table-style">
        <tr>
            <th>Название</th>
            <th>Цена</th>
            <th>Описание</th>
        </tr>
        <c:if test="${complectaionList.size() != 0}">
            <c:forEach var="complectaion" items="${complectaionList}">
                <tr onclick="tableRowClick(this)" class="row-choice">
                    <td>${complectaion.nameComplectation}</td>
                    <td>${complectaion.priceComplectation}</td>
                    <td>
                        <ul>
                            <li>
                                Кузов:
                                <p>Тип кузова: ${complectaion.specification.bodyTypeSpecification}</p>
                                <p>Кол-во дверей: ${complectaion.specification.bodyTypeSpecification}</p>
                            </li>
                            <li>
                                Двигатель:
                                <p>Тип двигателя: ${complectaion.specification.bodyTypeSpecification}</p>
                                <p>Кол-во цилиндров: ${complectaion.specification.engineCylinderCountSpecification}</p>
                                <p>Мощность: ${complectaion.specification.enginePowerSpecification}</p>
                            </li>
                            <li>
                                Подвеска:
                                <p>Тип КПП: ${complectaion.specification.gearBoxTypeSpecification}</p>
                                <p>Привод: ${complectaion.specification.driveTypeSpecification}</p>
                            </li>
                        </ul>
                    </td>
                </tr>
            </c:forEach>
        </c:if>
        <c:if test="${complectaionList.size() == 0}">
            <tr>
                <td colspan="3">Комплектации не заполнены..</td>
            </tr>
        </c:if>
    </table>
</div>
<div class="button-container">
    <form action="${pageContext.request.contextPath}/complectation" method="get">
        <input hidden name="action" value="add">
        <input id="vinInput" hidden name="vin" value="${vin}">
        <button class="add-button" type="submit">Добавить</button>
    </form>
</div>
<script>
    function tableRowClick(rowElement) {
        let vin = document.getElementById("vinInput").value;
        window.location.href = "/complectation?action=edit&vin=" + vin + "&name=" + rowElement.cells[0].innerText;
    }
</script>
</body>
</html>
