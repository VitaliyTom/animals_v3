<%--
  Created by IntelliJ IDEA.
  User: tomas
  Date: 28.11.2018
  Time: 17:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="springform" uri="http://www.springframework.org/tags/form" %>

<html>


<head>
    <meta charset="utf-8"/>
    <title>Загрузка файла</title>
</head>
<body>




<center>

    <springform:form method="post" action="/create" enctype="multipart/form-data" modelAttribute="newAnimal">
        Введите животное <springform:input type="text" path="animalName"/>
        <springform:errors path="animalName"/>
        <br>
        Введите id категорий <springform:input type="text" path="idCategory"/>
        <springform:errors path="idCategory"/>
        <br>
        Введите название категорий <springform:input type="text" path="categoryAnimal"/>
        <springform:errors path="categoryAnimal"/>
        <br>
        Загрузите фотографию на сервер <springform:input type="file" path="animalPicture"/>
        <springform:errors path="animalPicture"/>
        <br>
        Загрузите звук на сервер <springform:input type="file" path="animalSound" />
        <springform:errors path="animalSound"/>
        <br>
        <input type="submit" value="save animal"/>
    </springform:form>



<%--
<form action="/animal/create" enctype="multipart/form-data" method="post">
    <table>
        <tr>
            <td> Введите животное</td>
            <td><input type="text" name="name"/></td>
        </tr>

        <tr>
            <td>Введите id категорий</td>
            <td><input type="text" name="idCategory"/></td>
        </tr>

        <tr>
            <td>Введите название категорий</td>
            <td><input type="text" name="category"/></td>
        </tr>

        <tr>
            <td>Загрузите фотографию на сервер</td>
            <td><input type="file" name="photo" multiple accept="image/*,image/jpeg,image/png"></td>
        </tr>

        <tr>
            <td>Загрузите звук на сервер</td>
            <td><input type="file" name="audio" multiple accept="audio/*"><td>
        </tr>

        <tr>
            <td><input type="submit" value="Отправить"></td>
        </tr>
    </table>
</form>

  --%>

</center>




</body>


</html>
