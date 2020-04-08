<%--
  Created by IntelliJ IDEA.
  User: Никита
  Date: 07.04.2020
  Time: 17:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Работа с автомобилями</title>
    <link rel="stylesheet" type="text/css" href="../resources/css/style.css">
    <script src="../resources/js/jquery-3.4.1.min.js"></script>
</head>
<body>
    <div class="fixed-header">
        <div class="container">
            <nav>
                <img class="logo" src="../resources/img/logo.png" alt="Главная страница">
                <a href="${pageContext.request.contextPath}/">Продажа автомобилей</a>
            </nav>
        </div>
    </div>
    <div>
        <jsp:useBean id="carList" scope="request" type="java.util.List<entity.CarEntity>"/>
        <table class="table-style">
            <tr>
                <th>VIN номер</th>
                <th>Цвет</th>
                <th>Страна производитель</th>
                <th>Марка</th>
                <th>Модель</th>
                <th>Год производства</th>
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
                            <form method="get" action="${pageContext.request.contextPath}/complectation?VIN=${car.vinNumberCar}">
                                <button type="submit">Открыть</button>
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
        <button id="addCarButton" class="add-button" onclick="addCarModal.showModal()">Добавить</button>
    </div>
    <div class="add-dialog">
        <dialog id="addCarDialog">
            <div class="dialog-panel">
                <p>Добавление автомобиля:</p>
                <button form="addForm" type="reset" onclick="addCarModal.close()">X</button>
            </div>
            <form id="addForm" method="post" action="${pageContext.request.contextPath}/car?action=add">
                <section>
                    <input name="vin" type="text" required placeholder="VIN номер">
                    <input name="colour" type="text" required placeholder="Цвет">
                    <input name="country" type="text" required placeholder="Страна производитель">
                    <input name="mark" type="text" required placeholder="Марка">
                    <input name="model" type="text" required placeholder="Модель">
                    <input name="year" type="number" pattern="1?[0-9]{3}$" minlength="4" maxlength="4" step="1" required placeholder="Год производства">
                </section>
                <div class="modal-button-container">
                    <button class="delete-button" type="reset" onclick="addCarModal.close()">Отмена</button>
                    <button class="add-button" type="submit">Добавить</button>
                </div>
            </form>
        </dialog>
    </div>
    <script>
        let addCarModal = document.getElementById('addCarDialog');
        
        function tableRowClick(rowElement) {
            window.location.href = "/car?vin=" + rowElement.cells[0].innerText;
        }
    </script>
</body>
</html>
