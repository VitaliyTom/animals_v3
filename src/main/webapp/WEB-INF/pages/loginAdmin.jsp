<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="<c:url value="/resources/css/style.css"/>" type="text/css" rel="stylesheet">
    <link rel="shortcut icon" href="<c:url value="/resources/js/assets/tiger.png"/>" type="image/png">
    <title>Admin page</title>
</head>
<body class="admin">
<header class="header">
    <h1><spring:message code="admin.page"/></h1>
    <span class="lang">
    <a class="href" href="?lang=en">en</a>
    |
    <a class="href" href="?lang=ru">ru</a>
</span>
</header>
<main>
    <div class="CRUD_Animal">
        <div class="wrapper_Animal_category">
            <div class="wrapper_Animal">
                <form action="${contextPath}/create" method="get">
                    <input class="button create_Animal_button" type="submit"
                           value="<spring:message code="create.animal"/>"/>
                </form>
                <form action="${contextPath}/update" method="get">
                    <input class="button update_Animal_button" type="submit"
                           value="<spring:message code="update.animal"/>"/>
                </form>
                <form action="${contextPath}/delete" method="get">
                    <input class="button delete_Animal_button" type="submit"
                           value="<spring:message code="delete.animal"/>"/>
                </form>
            </div>
            <div class="wrapper_Category">
                <form action="${contextPath}/createCategory" method="get">
                    <input class="button create_Category_button" type="submit"
                           value="<spring:message code="create.category"/>"/>
                </form>
                <form action="${contextPath}/updateCategory" method="get">
                    <input class="button update_Category_button" type="submit"
                           value="<spring:message code="update.category"/>"/>
                </form>
                <form action="${contextPath}/deleteCategory" method="get">
                    <input class="button delete_Category_button" type="submit"
                           value="<spring:message code="delete.category"/>"/>
                </form>
            </div>
        </div>
        <div class="wrapper_All">
            <form action="${contextPath}/getAll" method="get">
                <input class="button get_All_animals_Categories_button" type="submit"
                       value="<spring:message code="get.all.animals.and.categories"/>"/>
            </form>
        </div>
    </div>
</main>
<form class="go_To_Index" action="${contextPath}" method="get">
    <input class="button index loginAdmin" type="submit" value="<spring:message code="start.page"/>"/>
</form>
</body>
</html>