<%--
  Created by IntelliJ IDEA.
  User: tomas
  Date: 10.12.2018
  Time: 1:14
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="springform" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update</title>
</head>
<body>

<div align="center" class="update-animal">

    <springform:form method="post" action="/update" enctype="multipart/form-data" modelAttribute="newAnimal">
        Введите id животного для обновления <springform:input type="text" path="idAnimal"/>
        <springform:errors path="idAnimal"/>
        <br>
        Введите животное <springform:input type="text" path="nameAnimal"/>
        <springform:errors path="nameAnimal"/>
        <br>
        Введите id категорий <springform:input type="text" path="categoryId"/>
        <springform:errors path="categoryId"/>
        <br>
        Введите название категорий <springform:input type="text" path="animalCategory"/>
        <springform:errors path="animalCategory"/>
        <br>
        Загрузите фотографию <springform:input type="file" path="imageAnimal" accept="image/*"/>
        <springform:errors path="imageAnimal"/>
        <br>
        Загрузите звук  <springform:input type="file" path="audioAnimal" />
        <springform:errors path="audioAnimal"/>
        <br>
        <input type="submit" value="save animal"/>
    </springform:form>


       <p><a href="/">[ index ]</a></p>
</div>

</body>
</html>
