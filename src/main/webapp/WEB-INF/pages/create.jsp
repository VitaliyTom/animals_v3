<%--
  Created by IntelliJ IDEA.
  User: tomas
  Date: 28.11.2018
  Time: 17:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="springform" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <link href="<c:url value="/resources/css/style.css"/>" type="text/css" rel="stylesheet">

    <meta charset="utf-8"/>
    <title>Загрузка файла</title>
</head>
<body class="crud">

<div align="center" class="create-animal">
    <springform:form method="post" action="/create" enctype="multipart/form-data" modelAttribute="newAnimal">
        Введите животное <springform:input type="text" path="nameAnimal"/>
        <springform:errors path="nameAnimal"/>
        <br>
        Введите id категорий <springform:input type="text" path="categoryId"/>
        <springform:errors path="categoryId"/>
        <br>
        Введите название категорий <springform:input type="text" path="animalCategory"/>
        <springform:errors path="animalCategory"/>
        <br>
        Загрузите фотографию на сервер <springform:input type="file" path="imageAnimal" accept="image/*"/>
        <springform:errors path="imageAnimal"/>
        <br>
        Загрузите звук на сервер <springform:input type="file" path="audioAnimal"/>
        <springform:errors path="audioAnimal"/>
        <br>
        <input type="submit" value="save animal"/>
    </springform:form>


    <p><a href="/">[ index ]</a></p>
</div>
</body>
</html>
