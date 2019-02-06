<%--
  Created by IntelliJ IDEA.
  User: lin
  Date: 05.02.19
  Time: 23:56
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

    <c:forEach var="cat" items="${getAllCategory}">
        <c:out value="${cat}"/>  <p>
    </c:forEach>

    <p><a href="/">[ index ]</a></p>


</body>
</html>
