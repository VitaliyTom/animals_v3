<%--
  Created by IntelliJ IDEA.
  User: tomas
  Date: 05.12.2018
  Time: 16:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <link href="<c:url value="/resources/css/style.css"/>" type="text/css" rel="stylesheet">
    <title>CRUD</title>
</head>
<body class="admin">
<span class="lang">
    <a class="href" href="?lang=en">en</a>
    |
    <a class="href" href="?lang=ru">ru</a>
</span>
<div align="center" class="CRUD-animal">
    <p>
    <form action="${contextPath}/create" method="get">
        <input type="submit" value="[ <spring:message code="create.animal"/> ]"/>
    </form>
    </p>
    <p>
    <form action="${contextPath}/update" method="get">
        <input type="submit" value="[ <spring:message code="update.animal"/> ]"/>
    </form>
    </p>
    <p>
    <form action="${contextPath}/delete" method="get">
        <input type="submit" value="[ <spring:message code="delete.animal"/> ]"/>
    </form>
    </p>
    <p>
    <form action="${contextPath}/createCategory" method="get">
        <input type="submit" value="[ <spring:message code="create.category"/> ]"/>
    </form>
    </p>
    <p>
    <form action="${contextPath}/updateCategory" method="get">
        <input type="submit" value="[ <spring:message code="update.category"/> ]"/>
    </form>
    </p>
    <p>
    <form action="${contextPath}/deleteCategory" method="get">
        <input type="submit" value="[ <spring:message code="delete.category"/> ]"/>
    </form>
    </p>
    <p>
    <form action="${contextPath}/getAll" method="get">
        <input type="submit" value="[ <spring:message code="get.all.animals.and.categories"/> ]"/>
    </form>
    </p>
    <p><a href="${contextPath}">[ index ]</a></p>
</div>
</body>
</html>
<%--
    <p><a href="/create">[ create ]</a></p>
    <p><a href="/update">[ update ]</a></p>
    <p><a href="/delete">[ delete ]</a></p>
    <p><a href="/getAll">[ get all ]</a></p>--%>

