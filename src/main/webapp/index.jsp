<html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>


<head>
    <meta charset="utf-8" />
    <title>Animals</title>
</head>
<body>
<span style="float: right">
    <a href="?lang=en">en</a>
    |
    <a href="?lang=ru">ru</a>
    |
    <a href="?lang=pl">pl</a>
</span>

<center>



<p><a href="/animal/readAnimalId"><spring:message code="label.start"/></a></p>
<p><a href="/animal/loginAdmin"><spring:message code="label.login"/></a></p>

</center>

</body>

</html>



<%--<html>



<head>
    <meta charset="utf-8" />
    <title>Загрузка файла</title>
</head>
<body>

<form action="/animal/up" enctype="multipart/form-data" method="post">

    <p>Загрузите  фотографию на сервер</p>
    <p> <input type="file" name="photo" multiple accept="image/*,image/jpeg,image/png">
        <input type="file" name="audio" multiple accept="audio/*">
        <input type="submit" value="Отправить">  </p>
</form>

</body>

</html>--%>
