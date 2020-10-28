<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="springform" %>
<html>
<head>
    <link href="<c:url value="/resources/css/style.css"/>" type="text/css" rel="stylesheet">
    <link rel="shortcut icon" href="<c:url value="/resources/js/assets/tiger.png"/>" type="image/png">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title><spring:message code="label.title"/></title>
</head>
<body class="getAnimal">
<div class="shadow"></div>
<header class="header">
    <span class="lang">
        <a href="?lang=en">en</a> | <a href="?lang=ru">ru</a>
    </span>
    <div class="name_Animal_Category">
        <div class="wrapper_name_Animal">
            <p class="animal_description">
                <spring:message code="getAnimal.animal"/> -&nbsp;
            </p>
            <p class="animal_Name"></p>
        </div>

        <div class="wrapper_name_Category">
            <p class="category_description">
                <spring:message code="getAnimal.category"/> -&nbsp;
            </p>
            <p class="category_name"></p>
        </div>
        <div class="wrapper_logo">
            <p class="logo_text">
                <spring:message code="getAll.logo.category"/> -
            </p>
            <div class="logo_img"></div>
        </div>
    </div>
</header>
<main class="main">
    <div class="spinnerAnimal active"></div>
    <div class="modal">
        <div class="message_modal">
            <p>
                <spring:message code="getAnimal.attention"/>
            </p>
            <div class="close"></div>
        </div>
    </div>
    <div class="get_Animal">
        <p><spring:message code="change.Animal"/></p>
        <div class="check_Animal" id="selectId">
            <c:forEach var="ani" items="${getAllList}">
                <div class="animal_List">
                    <input type="hidden" id="<c:out value="${ani.nameAnimal}"/>"
                           value="<c:out value="${ani.idAnimal}"/>">
                    <c:out value="${ani.nameAnimal}"/>
                </div>
            </c:forEach>
        </div>
    </div>
    <div class="container_get_Animal">
        <div class="wrapper_Parse_Animal">
            <div class="wrapper_Img_Animal">
                <div class="img_Animal"></div>
            </div>
            <div class="audio_check">
                <div class="wrapper_Audio"></div>
                <div class="button check"><spring:message code="change.Animal"/></div>
            </div>
        </div>
    </div>
</main>
<form class="go_To_Index getAnimalPage" action="${contextPath}/animals" method="get">
    <input class="button index main" type="submit" value="<spring:message code="main.page"/>"/>
</form>
<script type="module" src="<c:url value="/resources/js/index.js"/>"></script>
</body>
</html>