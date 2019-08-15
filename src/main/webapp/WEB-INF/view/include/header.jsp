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
    <title>Raamatukogu</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link href="https://fonts.googleapis.com/css?family=Roboto&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/header.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
</head>
<body>
<nav>
    <div class="container menu-bar">
        <!--
          <li>
              <a href="/app/person/load">Isikud</a>
          </li>
         -->
        <li>
            <a href="/app/books">Raamatud</a>
        </li>
        <li>
            <a href="/app/scanBook">Laenuta</a>
        </li>
        <li>
            <a href="/app/scanBook">Tagasta</a>
        </li>
    </div>
</nav>
</body>
</html>
