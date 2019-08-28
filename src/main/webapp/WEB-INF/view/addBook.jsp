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
            <form:form method="POST" action="/app/book/new" modelAttribute="book" class="form-signin">
            <h2>Add a book</h2>
                <table class="table">
            <tr>
                <td><form:label path="title">Title</form:label></td>
                <td><form:input class="form-control" placeholder="Title" path="title" /></td>
                <td><form:errors path="title"></form:errors></td>
            </tr>
            <tr>
                <td><form:label path="isbnCode">ISBN code</form:label></td>
                <td> <form:input class="form-control" placeholder="ISBN code" path="isbnCode"/></td>
                <td> <form:errors path="isbnCode"></form:errors></td>
            </tr>
            <tr class="form-group">
                <td> <form:label path="genre">Genre</form:label></td>
                <td> <form:input class="form-control" placeholder="Genre" path="genre"/></td>
                <td> <form:errors path="genre"></form:errors></td>
            </tr>
            <tr>
                <td> <form:label path="language">Language</form:label></td>
                <td> <form:select class="form-control" path="language">
                    <form:options class="form-control" items="${languageList}"/>>
                </form:select></td>
                <td>  <form:errors path="language"></form:errors></td>
            </tr>
            <tr>
                <td>  <form:label path="year">Year</form:label></td>
                <td>  <form:input class="form-control" placeholder="Year" path="year"/></td>
                <td>  <form:errors path="year"></form:errors></td>
            </tr>
            <tr>
                <td>  <form:label path="author1">Author 1</form:label></td>
                <td>  <form:input class="form-control" placeholder="Author 1" path="author1"/></td>
            </tr>
            <tr>
                <td>  <form:label path="author2">Author 2</form:label></td>
                <td> <form:input class="form-control" placeholder="Author 2" path="author2"/></td>
            </tr>
            <tr>
                <td>  <input class="btn btn-primary btn-block" type="submit" value="Add"></td>
            </tr>
                </table>
        </div>

</form:form>

    <div class="col-md-3">

    </div>
</div>
</div>


</body>
</html>
