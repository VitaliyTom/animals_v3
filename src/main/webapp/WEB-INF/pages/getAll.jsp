<%--
  Created by IntelliJ IDEA.
  User: tomas
  Date: 08.12.2018
  Time: 2:06
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="springform" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="media" uri="/WEB-INF/taglib/MediaTag.tld" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<html>
<head>
    <link href="<c:url value="/resources/css/style.css"/>" type="text/css" rel="stylesheet">
    <title>Title</title>

</head>
<body>
<span style="float: right">
    <a href="?lang=en">en</a>
    |
    <a href="?lang=ru">ru</a>
</span>
<h1><spring:message code="get.all.animals.and.categories"/></h1>
<div class="wrapper">
    <div align="right">
        <table align="center" class="animal">
            <tr>
                <td><spring:message code="getAll.id.animal"/></td>
                <td><spring:message code="getAll.name"/></td>
                <td><spring:message code="getAll.category"/></td>
                <td><spring:message code="getAll.img"/></td>
                <td><spring:message code="getAll.audio"/></td>
            </tr>
            <c:forEach var="ani" items="${getAllList}">
                <tr>
                    <td><c:out value="${ani.idAnimal}"/></td>
                    <td><c:out value="${ani.nameAnimal}"/></td>
                    <td><c:out value="${ani.nameCategory}"/></td>
                    <td><img src="data:image/png;base64,<media:mediaByte mediaByte="${ani.imageAnimal}"/>" height="50px"
                             width="70px"></td>
                    <td>
                        <audio controls="controls" autobuffer="autobuffer">
                            <source src="data:audio/mp3;base64,<media:mediaByte mediaByte="${ani.audioAnimal}"/>">
                        </audio>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <div class="block">
        <div align="left">
            <table align="center" class="category">
                <tr>
                    <td><spring:message code="getAll.id.category"/></td>
                    <td><spring:message code="getAll.category"/></td>
                    <td><spring:message code="getAll.logo"/></td>
                </tr>
                <c:forEach var="cat" items="${getAllCategory}">
                    <tr>
                        <td>
                            <c:out value="${cat.categoryIdDto}"/>
                        </td>
                        <td>
                            <c:out value="${cat.nameCategoryRus}"/>
                            <c:out value="${cat.nameCategoryEng}"/>
                        </td>
                        <td><img src="data:image/png;base64,<media:mediaByte mediaByte="${cat.logo.bytes}"/>"
                                 height="50px" width="70px"></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <div align="center" class="href__index">
            <a href="${contextPath}">[ index ]</a>
            <p><a href="${contextPath}/loginAdmin">[ loginAdmin ]</a></p>
        </div>
    </div>
</div>
</body>
</html>
