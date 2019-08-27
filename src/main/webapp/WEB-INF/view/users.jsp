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
<h3>Users list</h3>
<div class="container">
    <div class="row border border-primary">
        <div class="col-md-2">First name</div>
        <div class="col-md-2">Last name</div>
        <div class="col-md-1"></div>
        <div class="col-md-1"></div>
    </div>


    <c:forEach var="user" items="${users}">
        <div class="row border border-primary">
            <div class="col-md-2">${user.firstName} </div>
            <div class="col-md-2">${user.lastName}</div>
            <div class="col-md-1"><a href="/app/user/edit/${user.id}">Edit</a></div>
            <div><a class="btn btn-outline-primary" href="/app/user/delete/${user.id}" onclick="return confirm('Are you sure you want to remove ${user.firstName} ${user.lastName}?')">Remove</a></div>
        </div>
    </c:forEach>
</div>

</body>
</html>
