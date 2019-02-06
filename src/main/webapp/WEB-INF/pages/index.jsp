<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<html>


<head>
    <meta charset="utf-8"/>
    <title><spring:message code="animals"/></title>
</head>
<body>
<span style="float: right">
    <a href="?lang=en">en</a>
    |
    <a href="?lang=ru">ru</a>
    |
    <a href="?lang=pl">pl</a>
</span>

<div align="center" class="index-1">

    <form action="/read" method="get">
        <input type="submit" value="<spring:message code="label.start"/>">
    </form>

</div>

<div align="center" class="index-2">
    <form action="/loginAdmin" method="get">
        <input type="submit" value="<spring:message code="label.login"/>">
    </form>
</div>

<div align="center" class="cat">
    <form action="/getCategory" method="get">
        <input type="submit" value="категории">
    </form>
</div>


</body>

</html>




