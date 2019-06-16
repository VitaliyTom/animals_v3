<%--
  Created by IntelliJ IDEA.
  User: tomas
  Date: 10.12.2018
  Time: 1:14
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="springform" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <link href="<c:url value="/resources/css/style.css"/>" type="text/css" rel="stylesheet">

    <title>Update</title>
</head>
<body class="crud">
<span style="float: right">
    <a href="?lang=en">en</a>
    |
    <a href="?lang=ru">ru</a>
</span>
<h1><spring:message code="update.animal"/></h1>
<div align="center" class="update-animal">
    <springform:form method="post" action="${contextPath}/update" enctype="multipart/form-data"
                     modelAttribute="newAnimal">
        <table align="center" class="update"><%--rules="none" cellpadding="0" cellspacing="0" border="0"--%>
            <tr class="tr">
                <td class="td"><spring:message code="Enter.animal.id.to.update"/>:</td>
                <td class="td"><springform:input type="text" path="idAnimal"/>
                    <springform:errors path="idAnimal"/></td>
            </tr>
            <tr class="tr">
                <td class="td"><spring:message code="Enter.the.animal.in.Russian"/>:</td>
                <td class="td"><springform:input type="text" path="nameAnimalRus"/>
                    <springform:errors path="nameAnimalRus"/></td>
            </tr>
            <tr class="tr">
                <td class="td"><spring:message code="Enter.the.animal.in.English"/>:</td>
                <td class="td"><springform:input type="text" path="nameAnimalEng"/>
                    <springform:errors path="nameAnimalRus"/></td>
            </tr>
            <tr class="tr">
                <td class="td"><spring:message code="Enter.categories.id"/>:</td>
                <td class="td"><springform:input type="text" path="categoryId"/>
                    <springform:errors path="categoryId"/></td>
            </tr>
            <tr class="tr">
                <td class="td"><spring:message code="Upload.a.photo"/>:</td>
                <td class="td"><springform:input type="file" path="imageAnimal" accept="image/*"/>
                    <springform:errors path="imageAnimal"/></td>
            </tr>
            <tr class="tr">
                <td class="td"><spring:message code="Upload.a.sound"/>:</td>
                <td class="td"><springform:input type="file" path="audioAnimal"/>
                    <springform:errors path="audioAnimal"/></td>
            </tr>
        </table>
        <input type="submit" value="<spring:message code="save.animal"/>"/>
    </springform:form>


    <p><a href="${contextPath}">[ index ]</a></p>
    <p><a href="${contextPath}/loginAdmin">[ loginAdmin ]</a></p>
</div>
</body>
</html>

<%--<springform:form method="post" action="${contextPath}/update" enctype="multipart/form-data"
                     modelAttribute="newAnimal">
        <spring:message code="Enter.animal.id.to.update"/>: <springform:input type="text" path="idAnimal"/>
        <springform:errors path="idAnimal"/>
        <br>
        <spring:message code="Enter.the.animal.in.Russian"/>: <springform:input type="text" path="nameAnimalRus"/>
        <springform:errors path="nameAnimalRus"/>
        <br>
        <spring:message code="Enter.the.animal.in.English"/>: <springform:input type="text" path="nameAnimalEng"/>
        <springform:errors path="nameAnimalRus"/>
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
        <input type="submit" value="save animal"/>
    </springform:form>--%>