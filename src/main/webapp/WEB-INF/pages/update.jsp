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
        <table align="center" class="update">
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
