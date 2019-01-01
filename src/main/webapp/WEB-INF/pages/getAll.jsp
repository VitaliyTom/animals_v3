<<<<<<< HEAD
<%--
  Created by IntelliJ IDEA.
  User: tomas
  Date: 08.12.2018
  Time: 2:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
${all}
</body>
</html>
=======
<%--
  Created by IntelliJ IDEA.
  User: tomas
  Date: 08.12.2018
  Time: 2:06
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
<c:forEach var = "ani" items="${getAllList}">
 <c:out value = "${ani}"/><p>
    </c:forEach>

<%--<c:forEach items="${getAllList}" var="ani">
    ${getAllList}
</c:forEach>--%>


</center>
</body>
</html>
>>>>>>> 853371060790a3dadb4907e46437b4b91e71640f
