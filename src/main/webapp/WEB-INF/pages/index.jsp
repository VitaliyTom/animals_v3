<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<html>



<head>
    <meta charset="utf-8" />
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

<center>

<p><a href="/readAnimalId"><spring:message code="label.start"/></a></p>
<p><a href="/loginAdmin"><spring:message code="label.login"/></a></p>

</center>

</body>

</html>




