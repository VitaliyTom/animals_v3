<%@ taglib prefix="springform" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="<c:url value="/resources/css/style.css"/>" type="text/css" rel="stylesheet">
    <link rel="shortcut icon" href="<c:url value="/resources/js/assets/tiger.png"/>" type="image/png">
    <title>Delete category</title>
</head>
<body class="crud categoryDelete">
<header class="header">
    <h1><spring:message code="delete.category"/></h1>
    <span class="lang">
        <a class="href" href="?lang=en">en</a>
        |
        <a class="href" href="?lang=ru">ru</a>
    </span>
</header>
<main class="main">
    <div class="delete_Animal">
        <form class="form" action="${contextPath}/deleteCategory" method="post">
            <spring:message code="Enter.id.to.delete.categories"/>: <input id="delete_Category" type="number" name="id">
            <input class="button delete" type="submit" value="<spring:message code="delete"/>">
        </form>
    </div>
</main>
<div class="href__index">
    <div>
        <form class="form_index" action="${contextPath}" method="get">
            <input class="button index" type="submit" value="<spring:message code="start.page"/>"/>
        </form>
    </div>
    <div>
        <form class="form_adminPage" action="${contextPath}/loginAdmin" method="get">
            <input class="button index" type="submit" value="<spring:message code="admin.page"/>"/>
        </form>
    </div>
</div>
</body>
</html>