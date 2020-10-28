<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="springform" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="<c:url value="/resources/css/style.css"/>" type="text/css" rel="stylesheet">
    <link rel="shortcut icon" href="<c:url value="/resources/js/assets/tiger.png"/>" type="image/png">
    <title>Update category</title>
</head>
<body class="crud categoryUpdate">
<header class="header">
    <h1><spring:message code="update.category"/></h1>
    <span class="lang">
        <a class="href" href="?lang=en">en</a>
        |
        <a class="href" href="?lang=ru">ru</a>
    </span>
</header>
<main class="main">
    <div class="update_Category">
        <springform:form class="form" method="post" action="${contextPath}/updateCategory" enctype="multipart/form-data"
                         modelAttribute="newCategory">

            <spring:message code="Enter.categories.id"/>: <springform:input type="text" path="categoryIdDto"/>
            <springform:errors path="categoryIdDto"/>

            <spring:message code="Enter.a.category.in.Russian"/>: <springform:input type="text" path="nameCategoryRus"/>
            <springform:errors path="nameCategoryRus"/>

            <spring:message code="Enter.a.category.in.English"/>: <springform:input type="text" path="nameCategoryEng"/>
            <springform:errors path="nameCategoryEng"/>

            <div class="input_media_category">
                <p class="input_Img">
                    <spring:message code="Upload.logo"/>: <springform:input type="file" path="logo" accept="image/*"/>
                    <springform:errors path="logo"/>
                    <label for="logo"><spring:message code="select.file"/></label>
                </p>
            </div>
            <input class="button save_Category" type="submit" value="<spring:message code="save.category"/>"/>
        </springform:form>
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