
<%--
  Created by IntelliJ IDEA.
  User: tomas
  Date: 05.12.2018
  Time: 1:00
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="/WEB-INF/taglib/imageTag.tld" prefix="imag" %>
<%@ taglib uri="/WEB-INF/taglib/audioTag.tld" prefix="adi" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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





    <img src="<imag:imageTg imageByteTag="${images}"/>"  height="500px" width="700px" >
<p>
    <%--<img src="data:image/png;base64, ${image}" width="700px" height="500px"/> --%></p>


<p>
    <audio controls="controls" autobuffer="autobuffer" >

        <source src="<adi:audioTg soundByteTag="${sound}"/>" >
    <%--<source src="data:audio/mp3;base64,${sound}"/>--%>

</audio>
</p>

   <p> <form action="/readAnimalId"  method="post">

        <input type="hidden" />


        <input type="submit" value="<spring:message code="getAnimal.next"/>">

    </form>  </p>

</center>
</body>
</html>


<%--
autoplay="autoplay"--%>

