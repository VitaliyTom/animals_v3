
<%--
  Created by IntelliJ IDEA.
  User: tomas
  Date: 05.12.2018
  Time: 1:00
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><spring:message code="label.title"/></title>
</head>
<body>
<span style="float: right">
    <a href="?lang=en">en</a>
    |
    <a href="?lang=ru">ru</a>
    |
    <a href="?lang=pl">pl</a>
</span>


<center>

        [ <spring:message code="getAnimal.animal"/> = ${name} | <spring:message code="getAnimal.category"/> = ${category} ]







<p><img src="data:image/png;base64, ${image}" width="700px" height="500px"/> </p>


<p><audio controls="controls" autobuffer="autobuffer" >
    <source src="data:audio/mp3; base64,${sound}"/>

</audio>
</p>

   <p> <form action="/animal/readAnimalId"  method="post">

        <input type="hidden" />


        <input type="submit" value="<spring:message code="getAnimal.next"/>">

    </form>  </p>

</center>
</body>
</html>


<%--
autoplay="autoplay"--%>

