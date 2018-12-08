<%--
  Created by IntelliJ IDEA.
  User: tomas
  Date: 28.11.2018
  Time: 17:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>


<head>
    <meta charset="utf-8"/>
    <title>Загрузка файла</title>
</head>
<body>

<center>
<form action="/animal/upload" enctype="multipart/form-data" method="post">
    <table>
        <tr>
            <td> Введите животное</td>
            <td><input type="text" name="name"/></td>
        </tr>

        <tr>
            <td>Введите категорию</td>
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

</center>
</body>


</html>
