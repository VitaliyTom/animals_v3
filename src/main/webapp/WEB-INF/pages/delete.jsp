<%--
  Created by IntelliJ IDEA.
  User: tomas
  Date: 10.12.2018
  Time: 0:46
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="springform" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete</title>
</head>
<body>

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
