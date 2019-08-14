<%--
  Created by IntelliJ IDEA.
  User: shipo
  Date: 8/14/2019
  Time: 1:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%-- <%@ page contentType="text/html;charset=UTF-8" language="java" %> --%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head></head>
<body>
<c:choose>
    <c:when test="user.id != null">
        <h3>Muudame ${user.firstName}</h3>
    </c:when>
    <c:otherwise>
        <h3>Muuda isik</h3>
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
            <td><input type="submit" value="Salvesta"/></td>
            <td><a href="/app/users/load">Katkesta</a></td>
        </tr>
    </table>
</form:form>
</body>
</html>
