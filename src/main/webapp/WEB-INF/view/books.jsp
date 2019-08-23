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
<div class="container">
    <h1>Add and Remove Books</h1>

    <form:form method="post" modelAttribute="addbook">
        <table>
            <tr>
                <td><form:label path="title">Title</form:label></td>
                <td><form:input path="title"/></td>
            </tr>
            <tr>
                <td><form:label path="isbnCode">ISBN code</form:label></td>
                <td><form:input path="isbnCode"/></td>
            </tr>
            <tr>
                <td><form:label path="genre">Genre</form:label></td>
                <td><form:input path="genre"/></td>
            </tr>
            <tr>
                <td><form:label path="language">Language</form:label></td>
                <td><form:select path="language">
                    <form:options items="${languageList}"/>
                </form:select></td>
            </tr>
            <tr>
                <td><form:label path="year">Year</form:label></td>
                <td><form:input path="year"/></td>
            </tr>
            <tr>
                <td><form:label path="author1">Autor 1</form:label></td>
                <td><form:input path="author1"/></td>
            </tr>
            <tr>
                <td><form:label path="author2">Autor 2</form:label></td>
                <td><form:input path="author2"/></td>
            </tr>

            <tr>
                <td><input type="submit" value="Add"></td>
            </tr>


        </table>


    </form:form>

</div>
</sec:authorize>

<div class="container">
    <div class="row border border-primary">

            <div class="col-md-3">Title</div>
            <div class="col-md-2">ISBNcode</div>
            <div class="col-md-1">Genre</div>
            <div class="col-md-1">Language</div>
            <div class="col-md-1">Year</div>
            <div class="col-md-1">Status</div>
            <div class="col-md-2">Picture</div>
            <div class="col-md-1">About</div>
    </div>


        <c:forEach var="book" items="${books}" >
            <div class="row border border-primary">
                <div class="col-md-3" id="title">${book.title}</div>
                <div class="col-md-2">${book.isbnCode}</div>
                <div class="col-md-1">${book.genre}</div>
                <div class="col-md-1">${book.language}</div>
                <div class="col-md-1">${book.year}</div>
                <div class="col-md-1">${book.status==true ? "<img width='30px' height='30px' src='https://upload.wikimedia.org/wikipedia/en/f/fb/Yes_check.svg'>" :
                        "<img width='30px' height='30px' src='https://upload.wikimedia.org/wikipedia/commons/thumb/f/f5/No_Cross.svg/1024px-No_Cross.svg.png'>"}</div>
                <div class="col-md-2"><img class="cover-photo" src="https://media.istockphoto.com/photos/open-book-picture-id495477978" height="200" width="125"></div>
                <div class="col-md-1"><a class="btn btn-outline-primary" href="/app/book/${book.id}">Details</a></div>
                <sec:authorize access="hasRole('ADMIN')">
                <div class="col-md-1"><a class="btn btn-outline-primary" href="/app/delete/${book.id}">Remove</a></div>
                </sec:authorize>

            </div>
        </c:forEach>

    <a class="btn btn-primary books-btn-page" href="/index.jsp">Home</a>
    <a class="btn btn-primary books-btn-page" href="/app/scanBook">Scan book</a>

</div>
<script>
   function searchfunction() {
        console.log("Ready")
       // Declare variables
       var input, filter, table, tr, td, i, txtValue;
       input = document.getElementById("searchInput");
       filter = input.value.toUpperCase();
       tr = document.getElementsByClassName("row border border-primary")
       console.log(tr)


       // Loop through all table rows, and hide those who don't match the search query
       for (i = 0; i < tr.length; i++) {
           console.log(td)
           if (td) {
               txtValue = td.innerText;
               console.log(txtValue)
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
