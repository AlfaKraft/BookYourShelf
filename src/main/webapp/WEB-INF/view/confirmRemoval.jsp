<%--
  Created by IntelliJ IDEA.
  User: kasutaja
  Date: 14.08.2019
  Time: 15:21
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Confirm</title>
</head>
<h2>Confirm Removal</h2>
<form:form method="post" action="/app/book/remove" modelAttribute="bookRemove">
    <form:hidden path="id"/>
    <form:hidden path="title"/>
    <form:hidden path="isbnCode"/>
    <form:hidden path="language"/>


    <p>${bookRemove.title}</p>
    <input type="submit" value="Confirm Removal">
    <a href="/index.jsp">Cancel</a>
</form:form>


<body>

</body>
</html>
