<%--
  Created by IntelliJ IDEA.
  User: tomas
  Date: 10.12.2018
  Time: 0:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete</title>
</head>
<body>

<center>
    <form action="/animal/delete" enctype="multipart/form-data" method="post">
        <table>
            <tr>
                <td> Введите id животного</td>
                <td><input type="text" name="id"/></td>
            </tr>


                <td><input type="submit" value="Удалить"></td>
            </tr>
        </table>
    </form>

</center>


</body>
</html>
