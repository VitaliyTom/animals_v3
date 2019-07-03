<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="springform" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <link href="<c:url value="/resources/css/style.css"/>" type="text/css" rel="stylesheet">
    <meta charset="utf-8"/>
    <title>create animal</title>
</head>
<body class="crud">
<span class="lang">
    <a class="href" href="?lang=en">en</a>
    |
    <a class="href" href="?lang=ru">ru</a>
</span>
<h1><spring:message code="create.animal"/></h1>
<div align="center" class="create-animal">
    <springform:form method="post" action="${contextPath}/create" enctype="multipart/form-data"
                     modelAttribute="newAnimal">
        <spring:message code="Enter.the.animal.in.Russian"/>: <springform:input type="text" path="nameAnimalRus"/>
        <springform:errors path="nameAnimalRus"/>
        <br>
        <spring:message code="Enter.the.animal.in.English"/>: <springform:input type="text" path="nameAnimalEng"/>
        <springform:errors path="nameAnimalEng"/>
        <br>
        <spring:message code="Enter.categories.id"/>: <springform:input type="text" path="categoryId"/>
        <springform:errors path="categoryId"/>
        <br>
        <spring:message code="Upload.a.photo"/>: <springform:input type="file" path="imageAnimal" accept="image/*"/>
        <springform:errors path="imageAnimal"/>
        <br>
        <spring:message code="Upload.a.sound"/>: <springform:input type="file" path="audioAnimal"/>
        <springform:errors path="audioAnimal"/>
        <br>
        <input type="submit" value="<spring:message code="save.animal"/>"/>
    </springform:form>
    <p><a href="${contextPath}">[ index ]</a></p>
    <p><a href="${contextPath}/loginAdmin">[ loginAdmin ]</a></p>
</div>
</body>
</html>

