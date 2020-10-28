<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Something went wrong</title>
      <link href="<c:url value="/resources/css/status.css"/>" type="text/css" rel="stylesheet">
    <link rel="shortcut icon" href="<c:url value="/resources/js/assets/tiger.png"/>" type="image/png">
</head>

<body class="bodyException">

<div class="error-div">

    <h2>  ${ex}  </h2>
    <button type="button" name="back" class="buttonSignup" onclick="history.back()">back</button>

</div>

</body>
</html>
