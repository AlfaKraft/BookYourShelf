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
    <title>Edit user - BookYourShelf - Tieto</title>

</head>
<body>
<jsp:include page="include/header.jsp"/>

<div class="container">
    <h1>Editing user account</h1>
    <div class="row">
        <div class="col-md-3">

        </div>
        <div class="col-md-6">

<c:choose>
<c:when test="${user.firstName != null}">
    <h3>Edit user ${user.firstName} ${user.lastName}</h3>
</c:when>
</c:choose>

<form:form method="POST" action="/app/user/edit" modelAttribute="user">
   <form:hidden path="id" />
      <form:hidden path="picture" />
    <div class="form-group">
        <form:label path="firstName">First name</form:label>
        <form:input class="form-control" path="firstName"/>
        <form:errors path="firstName"></form:errors>
    </div>
    <div class="form-group">
        <form:label path="lastName">Last name</form:label>
        <form:input class="form-control" path="lastName"/>
        <form:errors path="lastName"></form:errors>
    </div>
    <div class="form-group">
        <form:label path="email">Email</form:label>
        <form:input class="form-control" path="email" readonly="true"/>
        <form:errors path="email"></form:errors>
    </div>
    <div class="form-group">
        <form:label path="role">Role</form:label>
        <form:input class="form-control" path="role"/>
        <form:errors path="role"></form:errors>
    </div>
    <div class="form-group">
        <form:label path="password">Reset password</form:label>
        <form:input class="form-control" type="password" path="password"/>
        <form:errors path="password"></form:errors>
    </div>
    <div class="form-group">
        <form:label path="matchingPassword">Repeat password</form:label>
        <form:input class="form-control" type="password" path="matchingPassword"/>
        <form:errors path="matchingPassword"></form:errors>
    </div>
            <input class="btn btn-block btn-primary space-down" type="submit" value="Save"/>
            <a class="btn btn-secondary" href="/app/users">Cancel</a>
</form:form>
        </div>
    </div>
    <div class="col-md-3">

    </div>
    <jsp:include page="include/footer.jsp"/>
</div>
</body>
</html>
