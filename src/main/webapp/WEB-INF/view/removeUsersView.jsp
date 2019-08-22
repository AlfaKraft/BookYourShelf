<%--
  Created by IntelliJ IDEA.
  User: shipo
  Date: 8/21/2019
  Time: 10:12 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Remove users</title>
</head>
<body>
<jsp:include page="include/header.jsp"/>
<div class="container">
    <ul>
        <c:forEach var="user" items="${list}">
            <li>${user.firstName} ${user.lastName} <a href="/app/user/delete/${user.id}">Remove</a></li>
        </c:forEach>
    </ul>
</div>
<tr>
    <td><a href="/app/users">Cancel</a></td>
</tr>
</body>
</html>
