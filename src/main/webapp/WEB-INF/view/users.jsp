<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: shipo
  Date: 8/13/2019
  Time: 2:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>Kasutajate nimekiri</h3>
<ul>
    <c:forEach var="user" items="${user}">
        <li>${user.firstName} ${user.lastName}</li> <a href="/app/user/edit/${user.id}">Muuda</a>
    </c:forEach>
</ul>


</body>
</html>
