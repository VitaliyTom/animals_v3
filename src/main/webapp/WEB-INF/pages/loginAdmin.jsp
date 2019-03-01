<%--
  Created by IntelliJ IDEA.
  User: tomas
  Date: 05.12.2018
  Time: 16:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link href="<c:url value="/resources/css/style.css"/>" type="text/css" rel="stylesheet">

    <title>CRUD</title>
</head>
<body class="admin">

<div align="center" class="CRUD-animal">

    <p>
    <form action="/create" method="get">
        <input type="submit" value="[ create ]"/>
    </form>
    </p>
    <p>
    <form action="/update" method="get">
        <input type="submit" value="[ update ]"/>
    </form>
    </p>
    <p>
    <form action="/delete" method="get">
        <input type="submit" value="[ delete ]"/>
    </form>
    </p>
    <p>
    <form action="/getAll" method="get">
        <input type="submit" value="[ get all ]"/>
    </form>
    </p>
    <p><a href="/">[ index ]</a></p>
</div>

</body>
</html>
<%--
    <p><a href="/create">[ create ]</a></p>
    <p><a href="/update">[ update ]</a></p>
    <p><a href="/delete">[ delete ]</a></p>
    <p><a href="/getAll">[ get all ]</a></p>--%>

