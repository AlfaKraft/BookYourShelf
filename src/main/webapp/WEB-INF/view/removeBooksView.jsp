<%--
  Created by IntelliJ IDEA.
  User: kasutaja
  Date: 14.08.2019
  Time: 13:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Remove Books</title>
</head>
<body>
<jsp:include page="include/header.jsp"/>
<div class="container">
<ul>
    <c:forEach var="book" items="${list}">
            <li>${book.title} <a href="/app/delete/${book.id}">Remove</a></li>
    </c:forEach>
</ul>
</div>
</body>
</html>
