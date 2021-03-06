<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <h1>About your chosen book</h1>
        <div class="row">
            <div class="col-md-2"></div>
            <div class="col-md-4">
                <p>Title: <b>${book.title}</b></p>
                <p>ISBNcode: ${book.isbnCode}</p>
                <p>Genre: ${book.genre}</p>
                <p>Language: ${book.language}</p>
                <p>Year: ${book.year}</p>

                <c:if test="${book.borrower != null}">
                    <p>Currently in the hands of: <b>${book.borrower}</b></p>
                </c:if>
                <p>Status: ${book.status==true ? "<img width='30px' height='30px' src='/css/img/icons8-book-shelf-64.png' alt='book in shelf' title='This book is in shelf'>" :
                        "<img width='30px' height='30px' src='/css/img/icons8-return-book-64.png' alt='book is taken' title='Book is taken'>"}</p>

                    <c:forEach var="item" items="${book.authors}" varStatus="i">
                        <c:if test="${item.authorName.length()>0}">
                            <p>Author ${i.index +1}: ${item.authorName}</p>
                        </c:if>
                    </c:forEach>
                <br>
                <sec:authorize access="hasRole('USER')">
                    <div class="book-btn-page">

                        <c:if test="${book.status == true}">
                            <li><a class="btn btn-primary" href="/app/lendBook/${book.id}">Borrow</a></li>
                        </c:if>

                        <c:if test="${book.status == false}">
                            <li><a class="btn btn-primary" href="/app/returnBook/${book.id}">Return</a></li>
                        </c:if>
                    </div>
                </sec:authorize>

                <br>

                <a class="btn btn-outline-primary" href="${pageContext.request.contextPath}/app/books">All books</a>

            </div>
            <div class="col-md-4 book-cover-pos">
                <c:if test="${book.cover==null || book.cover.length() == 0}">
                    <img src="https://media.istockphoto.com/photos/open-book-picture-id495477978" height="200" width="125">
                </c:if>
                <c:if test="${book.cover!=null && book.cover.length() != 0}">
                    <img src="/img/${book.cover}" height="200" width="125">
                </c:if>

            </div>
            <div class="col-md-2">

            </div>

        </div>



    </div>
</body>
</html>