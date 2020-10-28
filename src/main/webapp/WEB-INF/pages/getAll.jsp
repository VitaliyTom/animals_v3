<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="springform" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="media" uri="/WEB-INF/taglib/MediaTag.tld" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="<c:url value="/resources/css/style.css"/>" type="text/css" rel="stylesheet">
    <link rel="shortcut icon" href="<c:url value="/resources/js/assets/tiger.png"/>" type="image/png">
    <title>All animals and categories</title>
</head>
<body>
<header>
    <div class="wrapper_header">
        <div class="header">
            <h1><spring:message code="get.all.animals.and.categories"/></h1>
            <span class="lang"> <a href="?lang=en">en</a> | <a href="?lang=ru">ru</a>  </span>
        </div>
    </div>
</header>
<div class="spinner active"></div>
<main>
    <div class="modal">
        <div class="message_modal">
            <p>
                <spring:message code="getAnimal.attention"/>
            </p>
            <div class="close"></div>
        </div>
    </div>
    <p class="main_Description_Animal">
        <spring:message code="getAnimal.animal"/>
    </p>
    <div class="container_Get_All">
        <div class="wrapper_arrow_left">
            <div class="arrow_left hidden"></div>
        </div>
        <div class="wrapper_Animal_All">
            <c:forEach var="ani" items="${getAllList}">
                <div class="animal active">
                    <div class="wrapper_description">
                        <div class="description_image">
                            <img src="data:image/png;base64,<media:mediaByte mediaByte="${ani.imageAnimal}"/>"
                                 alt="image"/>
                        </div>
                        <div class="description_text">
                            <div class="id_animal">
                            <span class="id_animal_span">
                                <spring:message code="getAll.id.animal"/>
                            </span>
                                <p>
                                    <c:out value="${ani.idAnimal}"/>
                                </p>
                            </div>
                            <div class="name_animal">
                            <span class="name_animal_span">
                                <spring:message code="getAll.name"/>
                            </span>
                                <p>
                                    <c:out value="${ani.nameAnimal}"/>
                                </p>
                            </div>
                            <div class="category_animal">
                            <span class="category_animal_span">
                                <spring:message code="getAll.category"/>
                            </span>
                                <p>
                                    <c:out value="${ani.nameCategory}"/>
                                </p>
                            </div>
                        </div>
                    </div>
                    <div class="description_audio">
                        <audio controls="controls" autobuffer="autobuffer">
                            <source src="data:audio/mp3;base64,<media:mediaByte mediaByte="${ani.audioAnimal}"/>">
                        </audio>
                    </div>
                </div>
            </c:forEach>
        </div>
        <div class="wrapper_arrow_right">
            <div class="arrow_right hidden"></div>
        </div>
    </div>
    <p class="main_Description_Category">
        <spring:message code="getAnimal.category"/>
    </p>
    <div class="container_Get_All">
        <div class="wrapper_arrow_left">
            <div class="arrow_left_Category hidden"></div>
        </div>
        <div class="wrapper_Category_All">
            <c:forEach var="cat" items="${getAllCategory}">
                <div class="category active">
                    <div class="wrapper_description">
                        <div class="description_image">
                            <div class="category_logo">
                                <span class="category_logo_span">
                                     <spring:message code="getAll.logo"/>
                                </span>
                                <p>
                                    <c:out value="${cat.nameCategoryEng}"/>
                                </p>
                            </div>
                            <img src="data:image/png;base64,<media:mediaByte mediaByte="${cat.logo.bytes}"/>"
                                 alt="image"/>
                        </div>
                        <div class="description_text category_Text">
                            <div class="id_category">
                                <span class="id_category_span">
                                    <spring:message code="getAll.id.category"/>
                                </span>
                                <p>
                                    <c:out value="${cat.categoryIdDto}"/>
                                </p>
                            </div>
                            <div class="category_name">
                                <span class="category_name_span">
                                    <spring:message code="getAll.category"/>
                                </span>
                                <p>
                                    <c:out value="${cat.nameCategoryRus}"/>
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
        <div class="wrapper_arrow_right">
            <div class="arrow_right_Category hidden"></div>
        </div>
    </div>
</main>
<div class="href__index allAnimals">
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
<script type="module" src="<c:url value="/resources/js/getAll.js"/>"></script>
</body>
</html>
