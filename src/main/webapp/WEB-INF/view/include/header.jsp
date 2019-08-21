<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: kasutaja
  Date: 15.08.2019
  Time: 10:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Library - Tieto</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link href="https://fonts.googleapis.com/css?family=Roboto&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/header.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
    <sec:authorize access="!isAuthenticated()">
        <a href="<c:url value="/app/login"/>">Login</a>
    </sec:authorize>

    <sec:authorize access="isAuthenticated()">
        <a href="<c:url value="/logout" />">Logout</a>
    </sec:authorize>
</head>
<body>
<nav>
    <div class="container menu-bar">

        <li>
            <a href="/app/books">Books</a>
        </li>
        <sec:authorize access="hasRole('USER')">
        <li>
            <a href="/app/scanBook">Borrow</a>
        </li>
        <li>
            <a href="/app/scanBook">Return</a>
        </li>
        <li>
            <a href="/app/account">Account</a>
        </li>
        </sec:authorize>
        <sec:authorize access="hasRole('ADMIN')">
        <li>
            <a href="/app/book/add">Add Books</a>
        </li>
        <li>

            <a href="/app/books/remove">Remove Books</a>
        </li>
        <li>
             <a href="/app/users">Users</a>
        </li>
        <li>
            <a href="/app/user/edit">Add Users</a>
        </li>
        <li>
            <a href="/app/users">//Eitööta//Remove Users</a>
        </li>
        <li>
            <a href="/app/account">Account</a>
        </li>
        </sec:authorize>
        <sec:authorize access="isAuthenticated()">
            Welcome back, <sec:authentication property="name"/>
        </sec:authorize>

    </div>
</nav>
</body>
</html>
