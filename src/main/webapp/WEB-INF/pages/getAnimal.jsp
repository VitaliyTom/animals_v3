<%--
  Created by IntelliJ IDEA.
  User: tomas
  Date: 05.12.2018
  Time: 1:00
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="springform" %>
<%@ taglib uri="/WEB-INF/taglib/imageTag.tld" prefix="image" %>
<%@ taglib uri="/WEB-INF/taglib/audioTag.tld" prefix="adi" %>

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


<div align="center" class="get-animal-text">

    [ <spring:message code="getAnimal.animal"/> - ${animalDto.nameAnimal} |
    <spring:message code="getAnimal.category"/> - ${animalDto.animalCategory} ]

</div>

<div align="center" class="get-animal">

    <%--fixme .bytes--%>
    <img src="<image:imageTg imageByte="${animalDto.imageAnimal.bytes}"/>" height="500px" width="700px">

    <p>
        <audio controls="controls" autobuffer="autobuffer">
            <source src="<adi:audioTg soundByte="${animalDto.audioAnimal.bytes}"/>">
        </audio>
    </p>


    <p>
    <form action="/read" method="get">
        <input type="submit" value="<spring:message code="getAnimal.next"/>">
    </form>
    </p>
    <p><a href="/">[ index ]</a></p>
</div>
</body>
</html>


<%--
autoplay="autoplay"--%>


