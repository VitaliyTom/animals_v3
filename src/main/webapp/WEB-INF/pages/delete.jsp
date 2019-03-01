<%--
  Created by IntelliJ IDEA.
  User: tomas
  Date: 10.12.2018
  Time: 0:46
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="springform" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link href="<c:url value="/resources/css/style.css"/>" type="text/css" rel="stylesheet">

    <title>Delete</title>
</head>
<body class="crud">

<div align="center" class="delete-animal">
    <springform:form method="post" action="/delete" modelAttribute="newAnimal">
        Введите id животного которое хотите удалить <springform:input type="text" path="idAnimal"/>
        <springform:errors path="idAnimal"/>
        <input type="submit" value="delete animal"/>
    </springform:form>

    <p><a href="/">[ index ]</a></p>

</div>
</body>
</html>
