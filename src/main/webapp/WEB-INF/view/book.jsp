<%@ page import="java.sql.Connection" %><%--
  Created by IntelliJ IDEA.
  User: kasutaja
  Date: 9.08.2019
  Time: 15:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

</head>
<body>
<jsp:include page="include/header.jsp"/>
    <div class="container">
        <h3>About your chosen book</h3>
        <div class="row">
            <div class="col-md-8">
                <p>Title: <b>${book.title}</b></p>
                <p>ISBNcode: ${book.isbnCode}</p>
                <p>Genre: ${book.genre}</p>
                <p>Language: ${book.language}</p>
                <p>Year: ${book.year}</p>
                <p>Status: ${book.status}</p>
            </div>
            <div class="col-md-4">
            <img src="https://media.istockphoto.com/photos/open-book-picture-id495477978" height="200" width="200">
            </div>
        </div>
            <div class="book-btn-page">
                <li><a class="btn btn-outline-primary space-right" href="/app/lendBook/${book.id}">Borrow</a></li>
                <!-- <li><a class="btn btn-outline-primary space-btw" href="/">Book a book</a></li> -->
                <li><a class="btn btn-outline-primary" href="/app/returnBook/${book.id}">Return</a></li>
                <li></li>
            </div>

            <br>

                <a class="btn btn-primary" href="/app/books">All books</a>


    </div>
</body>
</html>