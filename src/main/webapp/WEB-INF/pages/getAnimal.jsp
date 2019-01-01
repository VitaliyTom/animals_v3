
<%--
  Created by IntelliJ IDEA.
  User: tomas
  Date: 05.12.2018
  Time: 1:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>



<center>

${id}
${name}
${category}







<p><img src="data:image/png;base64, ${image}" width="700px" height="500px"/> </p>


<p><audio controls="controls" autobuffer="autobuffer" >
    <source src="data:audio/mp3; base64,${sound}"/>

</audio>
</p>

   <p> <form action="/animal/readAnimalId"  method="post">

        <input type="hidden" />


        <input type="submit" value="дальше">

    </form>  </p>

</center>
</body>
</html>


<%--
autoplay="autoplay"--%>

