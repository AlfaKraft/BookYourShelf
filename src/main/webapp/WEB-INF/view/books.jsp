<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: kasutaja
  Date: 12.08.2019
  Time: 11:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <thead>
        <tr>
            <th>Title</th>
            <th>ISBNcode</th>
            <th>Genre</th>
            <th>Language</th>
            <th>Year</th>
            <th>Status</th>
            <th>Picture</th>
        </tr>
    </thead>
    <tr>
    <tbody>
        <c:forEach var="book" items="${books}" >
            <tr>
                <td>${book.title}</td>
                <td>${book.barCode}</td>
                <td>${book.genre}</td>
                <td>${book.language}</td>
                <td>${book.year}</td>
                <td>${book.status}</td>
                <td><img src="https://media.istockphoto.com/photos/open-book-picture-id495477978" height="200" width="200"></td>
                <td><a href="/app/book/${book.id}">Details</a></td>
            </tr>
        </c:forEach>
        <tr><a href="/app/lend">Skäneeri raamat</a></tr>
    </tbody>
</table>

</body>
</html>
