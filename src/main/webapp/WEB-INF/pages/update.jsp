<%@ taglib prefix="springform" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="<c:url value="/resources/css/style.css"/>" type="text/css" rel="stylesheet">
    <link rel="shortcut icon" href="<c:url value="/resources/js/assets/tiger.png"/>" type="image/png">
    <title>Update animal</title>
</head>
<body class="crud animalUpdate">
<header class="header">
    <h1><spring:message code="update.animal"/></h1>
    <span class="lang">
        <a href="?lang=en">en</a>
        |
        <a href="?lang=ru">ru</a>
    </span>
</header>
<main class="main">
    <div class="create_Animal update">
        <springform:form class="form" method="post" action="${contextPath}/update" enctype="multipart/form-data"
                         modelAttribute="newAnimal">
            <spring:message code="Enter.animal.id.to.update"/>:<springform:input type="text" path="idAnimal"/>
            <springform:errors path="idAnimal"/>

            <spring:message code="Enter.the.animal.in.Russian"/>:<springform:input type="text"
                                                                                   path="nameAnimalRus"/>
            <springform:errors path="nameAnimalRus"/>


            <spring:message code="Enter.the.animal.in.English"/>:<springform:input type="text"
                                                                                   path="nameAnimalEng"/>
            <springform:errors path="nameAnimalRus"/>

            <spring:message code="Enter.categories.id"/>:<springform:input type="text" path="categoryId"/>
            <springform:errors path="categoryId"/>

            <div class="input_media">
                <p class="input_Img">
                    <spring:message code="Upload.a.photo"/>:<springform:input type="file" path="imageAnimal"
                                                                              accept="image/*"/>
                    <springform:errors path="imageAnimal"/>
                    <label for="imageAnimal"><spring:message code="select.file"/></label>
                </p>
                <p class="input_Sound">
                    <spring:message code="Upload.a.sound"/>:<springform:input type="file" path="audioAnimal"/>
                    <springform:errors path="audioAnimal"/>
                    <label for="audioAnimal"><spring:message code="select.file"/></label>
                </p>
            </div>
            <input class="button save_animal" type="submit" value="<spring:message code="save.animal"/>"/>
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