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
    <title>Title</title>
</head>
<body>
<h3>Raamatute detailvaade</h3>


<table>
    <tr>
        <th>Nimi</th>
        <th>Autor</th>
        <th>Pilt</th>
        <th>-</th>
    </tr>
    <tr>
        <td>${book.name}</td>
        <td>${book.author}</td>
        <td><img src="https://media.istockphoto.com/photos/open-book-picture-id495477978" height="200" width="200"></td>
        <td><a href="/">Broneeri</a></td>
    </tr>
</table>
</body>
</html>