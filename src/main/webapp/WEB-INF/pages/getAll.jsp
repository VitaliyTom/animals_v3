<%--
  Created by IntelliJ IDEA.
  User: tomas
  Date: 08.12.2018
  Time: 2:06
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div align="center" class="delete-animal">

    <c:forEach var="ani" items="${getAllList}">
    <c:out value="${ani}"/>  <p>
    </c:forEach>

    <p><a href="/">[ index ]</a></p>
</div>
</body>
</html>

