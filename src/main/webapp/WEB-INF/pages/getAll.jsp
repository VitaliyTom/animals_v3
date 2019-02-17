<%--
  Created by IntelliJ IDEA.
  User: tomas
  Date: 08.12.2018
  Time: 2:06
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="springform" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div align="center" class="getAll-animal">


    <springform:form method="post" action="/getId" modelAttribute="newAnimal">

        животные :
        <springform:select path="idAnimal">

            <springform:option value="1" label="--- Select ---"/>
            <springform:options items="${getAllList}" itemLabel="animalName" itemValue="animalId"/>

        </springform:select>

        <p>
            <input type="submit"/>
        </p>

    </springform:form>


    <p><a href="/">[ index ]</a></p>

</div>
</body>
</html>

<%--<c:forEach var="ani" items="${getAllList}">
    <c:out value="${ani}"/>  <p>
    </c:forEach>--%>

