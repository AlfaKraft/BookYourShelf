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
    <title>BookYourShelf - Tieto</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link href="https://fonts.googleapis.com/css?family=Roboto&display=swap" rel="stylesheet">


    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/header.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/mobile.css">
</head>
<body>

<nav class="navbar navbar-light bg-nav-color nav_mobile_desk">
    <div class="container menu-bar">

        <li>

            <a href="/index.jsp"><img src="${pageContext.request.contextPath}/css/img/bys_logo_white.png" height="auto" width="200"></a>
        </li>
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
                <a href="/app/history">History</a>
            </li>

        <li>
            <a href="/app/account">Account</a>
        </li>
        </sec:authorize>
        <sec:authorize access="hasRole('ADMIN')">
        <li>
             <a href="/app/users">Users</a>
        </li>
        <li>
            <a href="/app/borrows">Borrows list</a>
        </li>
        <li>
            <a href="/app/account">Account</a>
        </li>
        </sec:authorize>
        <sec:authorize access="isAuthenticated()">
            Welcome , <sec:authentication property="name"/>
        </sec:authorize>
        <sec:authorize access="!isAuthenticated()">
            <a href="<c:url value="/app/login"/>">Login</a>
            <a href="<c:url value="/app/user/registration"/>">Sign-Up</a>
        </sec:authorize>

        <sec:authorize access="isAuthenticated()">
            <a href="<c:url value="/logout" />">Logout</a>
        </sec:authorize>

    </div>
</nav>

<div class="pos-f-t">
    <div class="collapse" id="navbarToggleExternalContent">
        <div class="bg-nav-color-extend p-4">
        <ul>
            <li><a href="/index.jsp">Home</a></li>
            <li><a href="/app/books">Books</a></li>
            <sec:authorize access="hasRole('USER')">
            <li><a href="/app/scanBook">Borrow</a></li>
            <li><a href="/app/scanBook">Return</a></li>
            <li><a href="/app/history">History</a></li>
            <li><a href="/app/account">Account</a></li>
            </sec:authorize>
            <sec:authorize access="hasRole('ADMIN')">
                <li><a href="/app/users">Users</a></li>
                <li><a href="/app/borrows">Borrows list</a></li>
                <li><a href="/app/account">Account</a></li>
            </sec:authorize>
            <sec:authorize access="isAuthenticated()">
                <li>
                Welcome, <sec:authentication property="name"/>
                </li>
            </sec:authorize>
            <sec:authorize access="!isAuthenticated()">
                <li><a href="<c:url value="/app/login"/>">Login</a></li>
                <li><a href="<c:url value="/app/user/registration"/>">Sign-Up</a></li>
            </sec:authorize>
            <sec:authorize access="isAuthenticated()">
                <a href="<c:url value="/logout" />">Logout</a>
            </sec:authorize>
        </ul>

        </div>
    </div>
    <nav class="navbar navbar-dark bg-nav-color nav_mobile_mobile">
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarToggleExternalContent" aria-controls="navbarToggleExternalContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
    </nav>
</div>

</body>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</html>
