<%--
  Created by IntelliJ IDEA.
  User: tomas
  Date: 03.06.2019
  Time: 12:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="springform" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <meta charset="utf-8"/>

    <title>update category</title>
</head>
<body>
<span style="float: right">
    <a href="?lang=en">en</a>
    |
    <a href="?lang=ru">ru</a>
</span>
<div align="center" class="update-category">
    <springform:form method="post" action="${contextPath}/updateCategory" enctype="multipart/form-data"
                     modelAttribute="newCategory">
        <br>
        Введите id категорий <springform:input type="text" path="categoryIdDto"/>
        <springform:errors path="categoryIdDto"/>
        <br>
        Введите категорию на русском<springform:input type="text" path="nameCategoryRus"/>
        <springform:errors path="nameCategoryRus"/>
        <br>
        Введите категорию на английском<springform:input type="text" path="nameCategoryEng"/>
        <springform:errors path="nameCategoryEng"/>
        <br>
        Загрузите лого <springform:input type="file" path="logo" accept="image/*"/>
        <springform:errors path="logo"/>
        <br>
        <input type="submit" value="save category"/>
    </springform:form>


    <p><a href="${contextPath}">[ index ]</a></p>
    <p><a href="${contextPath}/loginAdmin">[ loginAdmin ]</a></p>
</div>
</body>
</html>

