<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>


<head>

    <meta charset="utf-8"/>
    <link href="<c:url value="/resources/css/style.css"/>" type="text/css" rel="stylesheet">
    <title><spring:message code="animals"/></title>

</head>
<body class="bodyIndex">

<span style="float: right">
    <a href="?lang=en">en</a>
    |
    <a href="?lang=ru">ru</a>

</span>

<div align="center" class="index-1">

    <form action="${contextPath}/getId" method="get">
        <input type="submit" value="<spring:message code="label.start"/>">
    </form>

</div>

<div align="center" class="index-2">
    <form action="${contextPath}/loginAdmin" method="get">
        <input type="submit" value="<spring:message code="label.login"/>">
    </form>
</div>




</body>

</html>




