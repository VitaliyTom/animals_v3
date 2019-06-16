<%--
  Created by IntelliJ IDEA.
  User: tomas
  Date: 03.06.2019
  Time: 11:47
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="springform" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <link href="<c:url value="/resources/css/style.css"/>" type="text/css" rel="stylesheet">

    <title>DeleteCategory</title>
</head>
<body class="crud">
<span style="float: right">
    <a href="?lang=en">en</a>
    |
    <a href="?lang=ru">ru</a>
</span>
<h1><spring:message code="delete.category"/></h1>
<div align="center" class="delete-animal">
    <form action="${contextPath}/deleteCategory" method="post">
        <spring:message code="Enter.id.to.delete.categories"/>: <input type="number" name="id">
        <input type="submit" value="<spring:message code="delete"/>">
    </form>
    <a href="${contextPath}">[ index ]</a>
    <p><a href="${contextPath}/loginAdmin">[ loginAdmin ]</a></p>
</div>

</body>
</html>