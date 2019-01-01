<%--
  Created by IntelliJ IDEA.
  User: tomas
  Date: 10.12.2018
  Time: 1:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update</title>
</head>
<body>

<center>
    <form action="/animal/update" enctype="multipart/form-data" method="post">
        <table>
            <tr>
                <td> Введите id животного которое нужно изменить </td>
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
    </form>

</center>

</body>
</html>
