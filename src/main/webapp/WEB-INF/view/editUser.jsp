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
    <title>Edit user</title>
</head>
<body>
<jsp:include page="include/header.jsp"/>
<h3>Editing user account</h3>
<c:choose>
<c:when test="${user.firstName != null}">
    <h3>Edit user ${user.firstName}</h3>
</c:when>
</c:choose>

<form:form method="POST" action="/app/user/edit" modelAttribute="user">
   <form:hidden path="id" />
      <form:hidden path="picture" />
    <table>
        <tr>
            <td><form:label path="firstName">First name</form:label></td>
            <td><form:input path="firstName"/></td>
            <td><form:errors path="firstName"></form:errors></td>
        </tr>
        <tr>
            <td><form:label path="lastName">Last name</form:label></td>
            <td><form:input path="lastName"/></td>
            <td><form:errors path="lastName"></form:errors></td>
        </tr>
        <tr>
            <td><form:label path="email">Email</form:label></td>
            <td><form:input path="email" readonly="true"/></td>
            <td><form:errors path="email"></form:errors></td>
        </tr>
        <tr>
            <td><form:label path="role">Role</form:label></td>
            <td><form:input path="role"/></td>
            <td><form:errors path="role"></form:errors></td>
        </tr>
        <tr>
            <td><form:label path="password">Reset password</form:label></td>
            <td><form:input type="password" path="password"/></td>
            <td><form:errors path="password"></form:errors></td>
        </tr>
        <tr>
            <td><form:label path="matchingPassword">Repeat password</form:label></td>
            <td><form:input type="password" path="matchingPassword"/></td>
            <td><form:errors path="matchingPassword"></form:errors></td>
        </tr>
        <tr>
            <td><input type="submit" value="Save"/></td>
            <td><a href="/app/users">Cancel</a></td>
        </tr>
    </table>
</form:form>
</body>
</html>
