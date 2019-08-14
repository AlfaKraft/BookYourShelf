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

<p>Title: ${book.title}</p>
<p>ISBNcode: ${book.isbnCode}</p>
<p>Genre: ${book.genre}</p>
<p>Language: ${book.language}</p>
<p>Year: ${book.year}</p>
<p>Status: </p>
<img src="https://media.istockphoto.com/photos/open-book-picture-id495477978" height="200" width="200">
<p></p><a href="/app/updateBook/${book.id}">Laenuta</a> || <a href="/">Broneeri</a> || <a href="/">Tagasta</a></p>
</body>
</html>