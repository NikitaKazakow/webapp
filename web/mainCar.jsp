<%--
  Created by IntelliJ IDEA.
  User: Никита
  Date: 07.04.2020
  Time: 17:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean id="orderName" class="java.lang.String" type="java.lang.String"/>
<jsp:useBean id="orderValue" class="java.lang.String" type="java.lang.String"/>

<jsp:useBean id="carList" scope="request" type="java.util.List<entity.CarEntity>"/>
<jsp:useBean id="findValue" scope="request" class="java.lang.String" type="java.lang.String"/>

<c:if test="${findValue != null || findValue != ''}">
    <c:set var="orderName" scope="page" value="find" />
    <c:set var="orderValue" scope="page" value="${findValue}"/>
</c:if>
<c:if test="${findValue == null || findValue.equals('')}">
    <c:set var="orderName" scope="page" value="vin" />
    <c:set var="orderValue" scope="page" value="all"/>
</c:if>

<html>
<head>
    <title>Работа с автомобилями</title>
    <link rel="stylesheet" type="text/css" href="resources/css/style.css">
</head>
<body>
    <div class="fixed-header">
        <div class="container">
            <nav>
                <img class="logo" src="resources/img/back.png" alt="Главная страница">
                <a href="${pageContext.request.contextPath}/">Работа с автомобилями</a>
            </nav>
        </div>
    </div>
    <div>
        <table class="table-style">
            <tr>
                <th colspan="7" class="search-container">
                    <form class="search-input" method="get" action="${pageContext.request.contextPath}/car">
                        <label>
                            Поиск:
                            <c:if test="${findValue != null}">
                                <input name="find" type="text" value="${findValue}">
                            </c:if>
                            <c:if test="${findValue == null}">
                                <input name="find" type="text">
                            </c:if>
                            <button class="add-button" type="submit">Поиск</button>
                        </label>
                    </form>
                    <form class="search-reset" action="${pageContext.request.contextPath}/car">
                        <input name="vin" hidden value="all">
                        <button class="delete-button" type="submit">Сбросить</button>
                    </form>
                </th>
            </tr>
            <tr>
                <th class="order-container">
                    <p>VIN номер</p>
                    <form action="${pageContext.request.contextPath}/car" method="get">
                        <input hidden name="${orderName}" value="${orderValue}">
                        <input hidden name="orderBy" value="vinNumberCar">
                        <input hidden name="direction" value="asc">
                        <button type="submit">^</button>
                    </form>
                    <form action="${pageContext.request.contextPath}/car" method="get">
                        <input hidden name="${orderName}" value="${orderValue}">
                        <input hidden name="orderBy" value="vinNumberCar">
                        <input hidden name="direction" value="desc">
                        <button type="submit">v</button>
                    </form>
                </th>
                <th>
                    <p>Цвет</p>
                    <form action="${pageContext.request.contextPath}/car" method="get">
                        <input hidden name="${orderName}" value="${orderValue}">
                        <input hidden name="orderBy" value="colourCar">
                        <input hidden name="direction" value="asc">
                        <button type="submit">^</button>
                    </form>
                    <form action="${pageContext.request.contextPath}/car" method="get">
                        <input hidden name="${orderName}" value="${orderValue}">
                        <input hidden name="orderBy" value="colourCar">
                        <input hidden name="direction" value="desc">
                        <button type="submit">v</button>
                    </form>
                </th>
                <th>
                    <p>Страна производитель</p>
                    <form action="${pageContext.request.contextPath}/car" method="get">
                        <input hidden name="${orderName}" value="${orderValue}">
                        <input hidden name="orderBy" value="manufactureCountry">
                        <input hidden name="direction" value="asc">
                        <button type="submit">^</button>
                    </form>
                    <form action="${pageContext.request.contextPath}/car" method="get">
                        <input hidden name="${orderName}" value="${orderValue}">
                        <input hidden name="orderBy" value="manufactureCountry">
                        <input hidden name="direction" value="desc">
                        <button type="submit">v</button>
                    </form>
                </th>
                <th>
                    <p>Марка</p>
                    <form action="${pageContext.request.contextPath}/car" method="get">
                        <input hidden name="${orderName}" value="${orderValue}">
                        <input hidden name="orderBy" value="markCar">
                        <input hidden name="direction" value="asc">
                        <button type="submit">^</button>
                    </form>
                    <form action="${pageContext.request.contextPath}/car" method="get">
                        <input hidden name="${orderName}" value="${orderValue}">
                        <input hidden name="orderBy" value="markCar">
                        <input hidden name="direction" value="desc">
                        <button type="submit">v</button>
                    </form>
                </th>
                <th>
                    <p>Модель</p>
                    <form action="${pageContext.request.contextPath}/car" method="get">
                        <input hidden name="${orderName}" value="${orderValue}">
                        <input hidden name="orderBy" value="modelCar">
                        <input hidden name="direction" value="asc">
                        <button type="submit">^</button>
                    </form>
                    <form action="${pageContext.request.contextPath}/car" method="get">
                        <input hidden name="${orderName}" value="${orderValue}">
                        <input hidden name="orderBy" value="modelCar">
                        <input hidden name="direction" value="desc">
                        <button type="submit">v</button>
                    </form>
                </th>
                <th>
                    <p>Год производства</p>
                    <form action="${pageContext.request.contextPath}/car" method="get">
                        <input hidden name="${orderName}" value="${orderValue}">
                        <input hidden name="orderBy" value="yearOfIssueCar">
                        <input hidden name="direction" value="asc">
                        <button type="submit">^</button>
                    </form>
                    <form action="${pageContext.request.contextPath}/car" method="get">
                        <input hidden name="${orderName}" value="${orderValue}">
                        <input hidden name="orderBy" value="yearOfIssueCar">
                        <input hidden name="direction" value="desc">
                        <button type="submit">v</button>
                    </form>
                </th>
                <th>Комплектации</th>
            </tr>
            <c:if test="${carList.size() != 0}">
                <c:forEach var="car" items="${carList}">
                    <tr onclick="tableRowClick(this)" class="row-choice">
                        <td>${car.vinNumberCar}</td>
                        <td>${car.colourCar}</td>
                        <td>${car.manufactureCountry}</td>
                        <td>${car.markCar}</td>
                        <td>${car.modelCar}</td>
                        <td>${car.yearOfIssueCar}</td>
                        <td>
                            <form method="get" action="${pageContext.request.contextPath}/complectation">
                                <button type="submit">Открыть</button>
                                <input hidden name="vin" value="${car.vinNumberCar}">
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </c:if>
            <c:if test="${carList.size() == 0}">
                <tr>
                    <td colspan="7">База автомобилей пуста...</td>
                </tr>
            </c:if>
        </table>
    </div>
    <div class="button-container">
        <form action="${pageContext.request.contextPath}/car" method="get">
            <input hidden name="action" value="add">
            <button class="add-button" type="submit">Добавить</button>
        </form>
    </div>
    <script>
        function tableRowClick(rowElement) {
            window.location.href = "/car?vin=" + rowElement.cells[0].innerText;
        }
    </script>
</body>
</html>
