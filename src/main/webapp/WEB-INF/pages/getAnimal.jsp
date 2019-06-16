<%--
  Created by IntelliJ IDEA.
  User: tomas
  Date: 05.12.2018
  Time: 1:00
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="springform" %>


<html>
<head>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7/jquery.js"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/index.js"/>"></script>
    <link href="<c:url value="/resources/css/style.css"/>" type="text/css" rel="stylesheet">
    <title><spring:message code="label.title"/></title>


</head>
<body class="getAnimal">

<span class="lang">
    <a class="href" href="?lang=en">en</a>
    |
    <a class="href" href="?lang=ru">ru</a>

</span>
<%-- style="display: flex"--%>

<div align="center" class="wrapper">

    <div align="center" class="get-Animal-Text-Left">
        <div align="center" id="ga1">
            <h3 style="color: bisque"><spring:message code="getAnimal.animal"/> - <spring:message
                    code="getAnimal.category"/></h3>
            <div align="center" id="ga2">
            </div>
            <div align="left" id="ga">
            </div>
        </div>
    </div>
    <div align="right" class="getAll-animal">       <%--fixme желательно добавить рандомный выбор животного--%>
        <h3 class="h3"><spring:message code="check.Animal"/>:</h3>
        <select id="select">
            <option disabled><spring:message code="check.Animal"/></option>
            <%--FIXME  1 животное автоматичеки выбрано, тем самым первым его выбрать нельзя--%>
            <c:forEach var="ani" items="${getAllList}">
                <option value="<c:out value="${ani.idAnimal}"/> ">
                    <c:out value="${ani.nameAnimal}"/>
                </option>
            </c:forEach>
        </select>
    </div>
</div>
</body>
</html>

<%--autoplay="autoplay"--%>




