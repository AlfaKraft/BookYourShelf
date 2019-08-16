<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title></title>
</head>
<body>
<h1>Spring MVC 5 + Spring Security 5 + Hibernate 5 example</h1>
<h2>${message}</h2>

<form action="/app/logout" method="post">
    <input value="Logout" type="submit">
</form>
</body>
</html>


<!--<html>
<head>
    <title>Raamatukogu</title>
</head>
<body>
<br>
<h2>Raamatukogu</h2>
<div>
    <h4>
        <a href="app/book/load">Raamatud</a>
    </h4>
    <h4>
        <a href="app/books">Raamatud</a>
    </h4>
    <h4>
        <a href="app/lend">Laenuta</a>
    </h4>
    <h4>
        <a href="app/return">Tagasta</a>
    </h4>
</div>
</body>
</html>-->