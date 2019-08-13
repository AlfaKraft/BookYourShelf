<%--
  Created by IntelliJ IDEA.
  User: kasutaja
  Date: 9.08.2019
  Time: 15:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Books</title>
</head>
<body>
<h3>Raamatute nimekiri</h3>
<table>
    <tr>
        <th>Nimi</th>
        <th>Autor</th>
        <th>Pilt</th>
        <th>Staatus</th>
        <th>-</th>
    </tr>
    <tr>
        <td>Example 1</td>
        <td>Author 1</td>
        <td><img src="https://media.istockphoto.com/photos/open-book-picture-id495477978" height="200" width="200"></td>
        <td>true</td>
        <td><a href="/app/book">Detailvaade</a></td>
    </tr>
    <tr>
        <td>${books.name}</td>
        <td>${books.author}</td>
        <td><img src="https://media.istockphoto.com/photos/open-book-picture-id495477978" height="200" width="200"></td>
        <td>${books.status}</td>
        <td><a href="/app/book">Detailvaade</a></td>
    </tr>
</table>
</body>
</html>
