<%--
  Created by IntelliJ IDEA.
  User: kasutaja
  Date: 16.08.2019
  Time: 11:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Edit uset</title>
</head>
<body>
<h3>Kasutaja muutmine/lisamine</h3>
<c:choose>
<c:when test="${user.firstName != null}">
    <h3>Muuda kasutajat ${user.firstName}</h3>
</c:when>
<c:otherwise>
    <h3>Uus isik</h3>
</c:otherwise>
</c:choose>

<form:form method="POST" action="/app/user/save" modelAttribute="user">
   <form:hidden path="id" />
    <table>
        <tr>
            <td><form:label path="firstName">Eesnimi</form:label></td>
            <td><form:input path="firstName"/></td>
        </tr>
        <tr>
            <td><form:label path="lastName">Perenimi</form:label></td>
            <td><form:input path="lastName"/></td>
        </tr>
        <tr>
        <td><form:label path="email">Email</form:label></td>
        <td><form:input path="email"/></td>
        </tr>
        <tr>
        <td><form:label path="role">Roll</form:label></td>
        <td><form:input path="role"/></td>
        </tr>
        <tr>
            <td><form:label path="picture">Pilt</form:label></td>
            <td><form:input path="picture"/></td>
        </tr>
        <tr>
        <td><form:label path="password">Salasõna</form:label></td>
        <td><form:input path="password"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="Salvesta"/></td>
            <td><a href="/app/users">Katkesta</a></td>
        </tr>
    </table>
</form:form>

</body>
</html>