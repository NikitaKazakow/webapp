<%--
  Created by IntelliJ IDEA.
  User: Никита
  Date: 15.04.2020
  Time: 21:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<jsp:useBean id="complectation" scope="request" type="entity.ComplectationEntity"/>
<html>
<head>
    <title>Редактирование комплектации</title>
    <link rel="stylesheet" type="text/css" href="resources/css/style.css">
</head>
<body>
<div class="fixed-header">
    <div class="container">
        <nav>
            <img class="logo" src="resources/img/back.png" alt="Назад">
            <a href="${pageContext.request.contextPath}/complectation?vin=${complectation.vinNumberCarFk}">Редактирование комплектации</a>
        </nav>
    </div>
</div>
<div class="container add-dialog">
    <div class="dialog-panel">
        <p>Редактирование данных автомобиля:</p>
    </div>
    <form id="deleteComplectation" hidden method="get" action="${pageContext.request.contextPath}/complectation">
        <label>
            <input name="action" hidden value="delete">
            <input name="vin" hidden value="${complectation.vinNumberCarFk}">
            <input name="name" hidden value="${complectation.nameComplectation}">
        </label>
    </form>
    <form id="editComplectation" method="post" action="${pageContext.request.contextPath}/complectation?action=update">
            <input style="display: none" name="vin" hidden value="${complectation.vinNumberCarFk}">
            <input style="display: none" name="name" hidden value="${complectation.nameComplectation}">
        <label>
            <div class="label-text">Цена</div>
            <input name="price" type="number" required value="${complectation.priceComplectation}">
        </label>
        <p>Кузов:</p>
        <label>
            <div class="label-text">Тип кузова</div>
            <input name="body" type="text" required value="${complectation.specification.bodyTypeSpecification}">
        </label>
        <label>
            <div class="label-text">Количество дверей</div>
            <input name="doors" type="number" required value="${complectation.specification.doorsCountSpecification}">
        </label>
        <p>Двигатель:</p>
        <label>
            <div class="label-text">Тип двигателя</div>
            <input name="engine" type="text" required value="${complectation.specification.engineTypeSpecification}">
        </label>
        <label>
            <div class="label-text">Количество цилиндров</div>
            <input name="cylinder" type="number" required value="${complectation.specification.engineCylinderCountSpecification}">
        </label>
        <label>
            <div class="label-text">Мощность</div>
            <input name="power" type="number" required value="${complectation.specification.enginePowerSpecification}">
        </label>
        <p>КПП и привод:</p>
        <label>
            <div class="label-text">Привод</div>
            <input name="drive" type="text" required value="${complectation.specification.driveTypeSpecification}">
        </label>
        <label>
            <div class="label-text">Тип КПП</div>
            <input name="gearbox" type="text" required value="${complectation.specification.gearBoxTypeSpecification}">
        </label>
        <div class="button-container">
            <button form="deleteComplectation" formmethod="get" type="submit" class="delete-button">Удалить</button>
            <button form="editComplectation" formmethod="post"  type="submit" class="add-button">Сохранить</button>
        </div>
    </form>
</div>
</body>
</html>
