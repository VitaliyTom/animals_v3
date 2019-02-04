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

<center>


   <%-- <springform:form method="post" action="/update" enctype="multipart/form-data" modelAttribute="newAnimal">
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
    </springform:form>--%>



    <%--<form action="/update" enctype="multipart/form-data" method="post">
        <table>
            <tr>
                <td> Введите id животного  </td>
                <td><input type="text" name="id"/></td>
            </tr>

            <tr>
                <td> Введите новое имя </td>
                <td><input type="text" name="name"/></td>
            </tr>

            <tr>
                <td>Введите новую категорию</td>
                <td><input type="text" name="category"/></td>
            </tr>

            <tr>
                <td>Загрузите новую фотографию на сервер</td>
                <td><input type="file" name="photo" multiple accept="image/*,image/jpeg,image/png"></td>
            </tr>

            <tr>
                <td>Загрузите новый звук на сервер</td>
                <td><input type="file" name="audio" multiple accept="audio/*"><td>
            </tr>

            <tr>
                <td><input type="submit" value="Отправить"></td>
            </tr>
        </table>
    </form>--%>
       <p><a href="/">[ index ]</a></p>
</center>

</body>
</html>
