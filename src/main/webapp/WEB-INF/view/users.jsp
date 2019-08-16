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
    <title>Kasutajate nimekiri</title>
</head>
<body>
<h3>Kasutajate nimekiri</h3>
<ul>
    <c:forEach var="user" items="${users}">
        <li>${user.firstName} ${user.lastName} <a href="/app/user/edit/${user.id}">MUUDA</a></li>
    </c:forEach>
</ul>

<a href="/app/user/edit/">Lisa kasutja</a>

</body>
</html>
