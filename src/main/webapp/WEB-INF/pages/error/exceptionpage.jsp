<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Something went wrong</title>
    <%--  <link href="<c:url value="/resources/css/styles.css"/>" type="text/css" rel="stylesheet">--%>
</head>

<body class="bodyException">

<div class="error-div">

    <h2>  ${ex}  </h2>

    <br/><br/><br/>

    <button style="margin-left: 30%" type="button" name="back" class="buttonSignup" onclick="history.back()">back</button>

</div>

</body>
</html>
