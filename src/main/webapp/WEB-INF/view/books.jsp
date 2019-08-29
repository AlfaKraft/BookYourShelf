<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%--
  Created by IntelliJ IDEA.
  User: kasutaja
  Date: 12.08.2019
  Time: 11:16
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!--===============================================================================================-->
    <link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/perfect-scrollbar/perfect-scrollbar.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/books.css">

<body>
<jsp:include page="include/header.jsp"/>

        <div class="limiter">
            <div class="container-table100">
                <div class="wrap-table100">
                    <div class="table100">
                        <sec:authorize access="hasRole('USER')">
                        <h1>Library</h1>
                        </sec:authorize>
                        <sec:authorize access="hasRole('ADMIN')">
                            <div class="col text-center">
                                <h1>Library</h1>
                                <a class="btn btn-primary space-down btn-size-books" href="/app/book/add">Add new book</a>
                            </div>
                        </sec:authorize>
                        <input class="form-control search-round" id="search-book" type="text" onkeyup="myFunction()" placeholder="Search books...">
<table id="booktable">
    <tr class="table-head">
            <th class="mobile_hide_btitle">Title</th>
            <th class="mobile_hide">Genre</th>
            <th class="mobile_hide">Language</th>
            <th class="mobile_hide_tblt">Year</th>
            <th>Status</th>
            <th>Picture</th>
            <th>About</th>
    </tr>

        <c:forEach var="book" items="${books}" >

            <tr>
                <td class="mobile_btitle book-title-font">${book.title}</td>
                <td class="mobile_hide">${book.genre}</td>
                <td class="mobile_hide">${book.language}</td>
                <td class="mobile_hide_tblt">${book.year}</td>
                <td>${book.status==true ? "<img width='40px' height='40px' src='/css/img/icons8-book-shelf-64.png' alt='book in shelf' title='This book is in shelf'>  " :
                        "<img width='40px' height='40px' src='/css/img/icons8-return-book-64.png' alt='book is taken' title='Book is taken'>"}</td>
                <td>
                    <c:if test="${book.cover==null || book.cover.length() == 0}">
                    <img class="cover-photo" src="https://media.istockphoto.com/photos/open-book-picture-id495477978"  width="125" height="200">
                </c:if>
                    <c:if test="${book.cover!=null && book.cover.length() != 0}">
                        <img class="cover-photo" src="/img/${book.cover}" height="200" width="125">
                    </c:if>
                </td>
                <td><a class="btn btn-primary btn-space-down" href="/app/book/${book.id}">Details</a>
                <sec:authorize access="hasRole('ADMIN')">
                    <a class="btn btn-danger" href="/app/delete/${book.id}" onclick="return confirm('Are you sure you want to delete ${book.title}?')">Delete</a></td>
                 </sec:authorize>
            </tr>
        </c:forEach>
</table>


                    </div>
                </div>
            </div>
        </div>

<script src="${pageContext.request.contextPath}/js/books.js">

</script>


<jsp:include page="include/footer.jsp"/>
</body>
</html>
