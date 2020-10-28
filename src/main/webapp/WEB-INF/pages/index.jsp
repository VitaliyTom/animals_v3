<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="<c:url value="/resources/css/run.css"/>" type="text/css" rel="stylesheet">
    <link rel="shortcut icon" href="<c:url value="/resources/js/assets/tiger.png"/>" type="image/png">
    <title><spring:message code="animals"/></title>
</head>
<body class="bodyIndex">
<div class="shadow"></div>
<header class="header index start">
    <h1><spring:message code="animals"/></h1>
    <h2 class="description_app"><spring:message code="label.app"/></h2>
    <span class="lang">
    <a href="?lang=en">en</a>
    |
    <a href="?lang=ru">ru</a>
</span>
</header>
<main>
    <div class="container">
        <div class="page start">
            <form class="form start" action="${contextPath}/getId" method="get">
                <input class="button start" type="submit" value="<spring:message code="label.start"/>">
            </form>
        </div>
        <div class="page login">
            <form class="form login" action="${contextPath}/loginAdmin" method="get">
                <input class="button login" type="submit" value="<spring:message code="admin.page"/>">
            </form>
        </div>
    </div>
    <div class="qr_Code">
        <div class="wrapper_qr_Code">
            <div class="qr"></div>
            <div class="link_Cv">
                <a class="cv" href="https://vitaliytom-my-cv.netlify.app/" target="_blank"><spring:message code="go.to.cv"/></a>
            </div>
        </div>
    </div>
</main>
<script type="module" src="<c:url value="/resources/js/qrCode.js"/>"></script>
</body>
</html>