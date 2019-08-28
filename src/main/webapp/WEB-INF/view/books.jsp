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

</head>
<body>
<jsp:include page="include/header.jsp"/>
<sec:authorize access="hasRole('ADMIN')">
<a class="btn btn-outline-primary" href="/app/book/add">Add new book</a>
</sec:authorize>

<div class="container">
<input id="search-book" type="text" onkeyup="myFunction()" placeholder="Search books...">


<table id="booktable">
    <tr>
            <th>Title</th>
            <th>Genre</th>
            <th>Language</th>
            <th>Year</th>
            <th>Status</th>
            <th>Picture</th>
            <th>About</th>
    </tr>
        <c:forEach var="book" items="${books}" >

            <tr>
                <td>${book.title}</td>
                <td>${book.genre}</td>
                <td>${book.language}</td>
                <td>${book.year}</td>
                <td>${book.status==true ? "<img width='30px' height='30px' src='https://upload.wikimedia.org/wikipedia/en/f/fb/Yes_check.svg'>" :
                        "<img width='30px' height='30px' src='https://upload.wikimedia.org/wikipedia/commons/thumb/f/f5/No_Cross.svg/1024px-No_Cross.svg.png'>"}</td>
                <td>
                    <c:if test="${book.cover==null}">
                        <img src="https://media.istockphoto.com/photos/open-book-picture-id495477978" height="200" width="200">
                    </c:if>
                    <c:if test="${book.cover!=null}">
                        <img src="/img/${book.cover}" height="200" width="200">
                    </c:if>
                </td>
                <td><a class="btn btn-outline-primary" href="/app/book/${book.id}">Details</a></td>
                <sec:authorize access="hasRole('ADMIN')">
                <td>
                    <a class="btn btn-outline-primary" href="/app/delete/${book.id}" onclick="return confirm('Are you sure you want to delete ${book.title}?')">Delete</a></td>
                 </sec:authorize>
            </tr>
        </c:forEach>
</table>
</div>
<script>
    function myFunction() {
        // Declare variables
        var input, filter, table, tr, td, i, txtValue;
        input = document.getElementById("search-book");
        filter = input.value.toUpperCase();
        table = document.getElementById("booktable");
        tr = table.getElementsByTagName("tr");



        // Loop through all table rows, and hide those who don't match the search query
        for (i = 0; i < tr.length; i++) {
            td = tr[i].getElementsByTagName("td")[0];
            if (td) {
                txtValue = td.textContent || td.innerText;
                if (txtValue.toUpperCase().indexOf(filter) > -1) {
                    tr[i].style.display = "";
                } else {
                    tr[i].style.display = "none";
                }
            }
        }
    }
</script>



</body>
</html>
