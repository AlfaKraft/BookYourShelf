<%--
  Created by IntelliJ IDEA.
  User: kasutaja
  Date: 16.08.2019
  Time: 11:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Users list</title>
</head>
<body>
<jsp:include page="include/header.jsp"/>

<div class="container">
    <h2>Users list</h2>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>Name</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <tbody>
<c:forEach var="user" items="${users}">
        <tr>
            <td>${user.firstName} ${user.lastName}</td>
            <td><a class="btn btn-info" href="/app/user/edit/${user.id}">Edit</a></td>
            <td><a class="btn btn-danger" href="/app/user/delete/${user.id}" onclick="return confirm('Are you sure you want to remove ${user.firstName} ${user.lastName}?')">Remove</a></td>
        </tr>
</c:forEach>
        </tbody>
    </table>


</div>

</body>
</html>
