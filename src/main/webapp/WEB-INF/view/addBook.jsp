<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: kasutaja
  Date: 26.08.2019
  Time: 16:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Books - BookYourShelf - Tieto</title>
</head>
<body>
<jsp:include page="include/header.jsp"/>

<div class="container">
    <div class="row">
        <div class="col-md-3">
        </div>
        <div class="col-md-6">
            <form:form method="POST" enctype="multipart/form-data"  action="/app/book/new" modelAttribute="book"  class="form-signin">
            <h2>Add a book</h2>

                <div class="form-group">
                    <form:label path="title">Title</form:label>
                    <form:input class="form-control" placeholder="Title" path="title" />
                    <form:errors path="title"></form:errors>
                </div>
                <div class="form-group">
                    <form:label path="isbnCode">ISBN code</form:label>
                    <form:input class="form-control" placeholder="ISBN code" path="isbnCode"/>
                     <form:errors path="isbnCode"></form:errors>
                </div>

                <div class="form-group">
                    <form:label path="genre">Genre</form:label>
                    <form:select class="form-control" path="genre">
                        <form:options class="form-control" items="${genreList}"/>
                    </form:select>
                    <form:errors path="genre"></form:errors></td>
                </div>
                <div class="form-group">

                    <form:label path="language">Language</form:label>
                    <form:select class="form-control" path="language">
                        <form:options class="form-control" items="${languageList}"/>
                    </form:select>
                    <form:errors path="language"></form:errors>
                </div>
                <div class="form-group">
                   <form:label path="year">Year</form:label>
                     <form:input class="form-control" placeholder="Year" path="year" type="year" maxlength="4"/>
                    <form:errors path="year"></form:errors>
                </div>
                <div class="form-group">
                    <form:label path="author1">Author 1</form:label>
                    <form:input class="form-control" placeholder="Author 1" path="author1"/>
                </div>
                <div class="form-group">
                    <form:label path="author2">Author 2</form:label>
                    <form:input class="form-control" placeholder="Author 2" path="author2"/>
                </div>
                <div class="form-group">
                    <form:label for="file-upload" class="custom-file-upload" path="coverImage">Cover upload <img src="/css/img/cloud-computing.png"></form:label>
                    <form:input id="file-upload" class="btn btn-primary cover-img-book" type="file" path="coverImage"/>
                    <p class="file-return"></p>
                </div>
                 <input class="btn btn-primary btn-block" type="submit" value="Add">

        </div>
    </form:form>

    <div class="col-md-3">

    </div>
</div>
</div>


</body>
<script>
    document.querySelector("html").classList.add('js');

    var fileInput  = document.querySelector( ".cover-img-book" ),
        button     = document.querySelector( ".custom-file-upload" ),
        the_return = document.querySelector(".file-return");

    button.addEventListener( "keydown", function( event ) {
        if ( event.keyCode == 13 || event.keyCode == 32 ) {
            fileInput.focus();
        }
    });
    button.addEventListener( "click", function( event ) {
        fileInput.focus();
        return false;
    });
    fileInput.addEventListener( "change", function( event ) {
        the_return.innerHTML = this.value;
    });
</script>
</html>
