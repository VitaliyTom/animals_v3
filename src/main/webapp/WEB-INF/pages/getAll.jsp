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


    <p><a href="/">[ index ]</a></p>


    <springform:form method="post" action="/getId"  modelAttribute="newAnimal">


        <p><select>
            <option disabled> Выберите животное </option>

            <c:forEach var="ani" items="${getAllList}">

                <%--<springform:hidden     path="id" value="${ani.animalId}"/>--%>

                <option name="newAnimal" value="<c:out value="${ani.animalId}"/>">
                    <springform:hidden     path="idAnimal" value="${ani.animalId}"/>
                    <c:out value="${ani.animalName}"/>
                    <%--<springform:hidden     path="newAnimal" value="${ani.animalId}"/>--%>
                </option>


            </c:forEach>

        </select></p>

        <input type="submit" value="get animal"/>
    </springform:form>


    <%-- <form action="/getId" method="post">

         <p><select size="3" >
         <option disabled>Выберите животное</option>

         <c:forEach var="ani" items="${getAllList}">

             <option value="<c:out value="${ani.animalId}"/>"><c:out value="${ani.animalName}"/></option>
         </c:forEach>

         </select></p>
         <p><input type="submit" value="Отправить"></p>
     </form>--%>


    <%--     <div align="center" class="getAll-animal">

             <c:forEach var="ani" items="${getAllList}">


             <a href=""

             <c:out value="${ani}"/>  <p>




             </c:forEach>

             <p><a href="/">[ index ]</a></p>--%>
</div>
</body>
</html>

<%--<c:forEach var="ani" items="${getAllList}">
    <c:out value="${ani}"/>  <p>
    </c:forEach>--%>

<%-- Введите животное <springform:input type="text" path="nameAnimal"/>
        <springform:errors path="nameAnimal"/>
        <br>

        <springform:errors path="categoryId"/>
        <br>
        Введите название категорий <springform:input type="text" path="animalCategory"/>
        <springform:errors path="animalCategory"/>
        <br>
        Загрузите фотографию на сервер <springform:input type="file" path="imageAnimal" accept="image/*"/>
        <springform:errors path="imageAnimal"/>
        <br>
        Загрузите звук на сервер <springform:input type="file" path="audioAnimal"/>
        <springform:errors path="audioAnimal"/>--%>