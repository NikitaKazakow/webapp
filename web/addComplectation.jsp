<%--
  Created by IntelliJ IDEA.
  User: Никита
  Date: 14.04.2020
  Time: 22:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean id="vin" scope="request" class="java.lang.String" type="java.lang.String"/>
<jsp:useBean id="error" scope="request" class="java.lang.String" type="java.lang.String"/>

<c:if test="${error.equals('1')}">
    <jsp:useBean id="complectation" scope="request" class="entity.ComplectationEntity" type="entity.ComplectationEntity"/>
</c:if>
<html>
<head>
    <title>добавление комплектации</title>
    <link rel="stylesheet" type="text/css" href="resources/css/style.css">
</head>
<body>
<div class="fixed-header">
    <div class="container">
        <nav>
            <img class="logo" src="resources/img/back.png" alt="Главная страница">
            <a href="${pageContext.request.contextPath}/complectation?vin=${vin}">Добавление комплектации</a>
        </nav>
    </div>
</div>
<div class="add-dialog container">
    <form hidden id="cancelForm" action="${pageContext.request.contextPath}/complectation" method="get">
        <input hidden name="vin" value="${vin}">
    </form>
    <form id="addForm" method="post" action="${pageContext.request.contextPath}/complectation?action=add&vin=${vin}">
        <section>
            <p>Заполните данные комплектации:</p>
            <c:choose>
                <c:when test="${error.equals('1')}">
                    <input name="name" type="text" required placeholder="Название"
                           value="${complectation.nameComplectation}">
                    <a class="input-error">Комплектация с таким названием уже есть в базе</a>
                    <input name="price" type="number" required placeholder="Цена"
                           value="${complectation.priceComplectation}">
                    <p>Кузов:</p>
                    <input name="body" type="text" required placeholder="Тип кузова"
                           value="${complectation.specification.bodyTypeSpecification}">
                    <input name="doors" type="number" required placeholder="Кол-во дверей"
                           value="${complectation.specification.doorsCountSpecification}">
                    <p>Двигатель:</p>
                    <input name="engine" type="text" required placeholder="Тип двигателя"
                           value="${complectation.specification.engineTypeSpecification}">
                    <input name="cylinder" type="number" required placeholder="Кол-во цилиндров"
                           value="${complectation.specification.engineCylinderCountSpecification}">
                    <input name="power" type="number" required placeholder="Мощность"
                           value="${complectation.specification.enginePowerSpecification}">
                    <p>КПП и привод:</p>
                    <input name="drive" type="text" required placeholder="Привод"
                           value="${complectation.specification.driveTypeSpecification}">
                    <input name="gearbox" type="text" required placeholder="Тип КПП"
                           value="${complectation.specification.gearBoxTypeSpecification}">
                </c:when>
                <c:when test="${error.equals('0')}">
                    <input name="name" type="text" required placeholder="Название">
                    <input name="price" type="number" required placeholder="Цена">
                    <p>Кузов:</p>
                    <input name="body" type="text" required placeholder="Тип кузова">
                    <input name="doors" type="number" required placeholder="Кол-во дверей">
                    <p>Двигатель:</p>
                    <input name="engine" type="text" required placeholder="Тип двигателя">
                    <input name="cylinder" type="number" required placeholder="Кол-во цилиндров">
                    <input name="power" type="number" required placeholder="Мощность">
                    <p>КПП и привод:</p>
                    <input name="drive" type="text" required placeholder="Привод">
                    <input name="gearbox" type="text" required placeholder="Тип КПП">
                </c:when>
            </c:choose>
        </section>
    </form>
    <div class="modal-button-container">
        <button form="cancelForm" class="delete-button" type="submit">Отмена</button>
        <button form="addForm" class="add-button" type="submit">Добавить</button>
    </div>
</div>
</body>
</html>
