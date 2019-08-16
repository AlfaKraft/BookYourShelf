<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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


<div class="search-container"><input type="text" id="searchInput" onkeyup="searchfunction()" placeholder="Search books..."></div>
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
