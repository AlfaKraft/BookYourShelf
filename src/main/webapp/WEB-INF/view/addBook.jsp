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
    <title>Add Books</title>
</head>
<body>
<jsp:include page="include/header.jsp"/>

<div class="container">
    <form:form method="POST" enctype="multipart/form-data"  action="/app/book/new" modelAttribute="book"  class="form-signin">

    <table>
        <tr>
            <td><form:label path="title">Title</form:label></td>
            <td><form:input path="title"/></td>
            <td><form:errors path="title"></form:errors></td>
        </tr>
        <tr>
            <td><form:label path="isbnCode">ISBN code</form:label></td>
            <td><form:input path="isbnCode"/></td>
            <td><form:errors path="isbnCode"></form:errors></td>
        </tr>
        <tr>
            <td><form:label path="genre">Genre</form:label></td>
            <td><form:input path="genre"/></td>
            <td><form:errors path="genre"></form:errors></td>
        </tr>
        <tr>
            <td><form:label path="language">Language</form:label></td>
            <td><form:select path="language">
                <form:options items="${languageList}"/>
            </form:select></td>
            <td><form:errors path="language"></form:errors></td>
        </tr>
        <tr>
            <td><form:label path="year">Year</form:label></td>
            <td><form:input path="year"/></td>
            <td><form:errors path="year"></form:errors></td>
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
            <td><form:label path="coverImage">Cover</form:label></td>
            <td><form:input type="file" path="coverImage"/></td>
        </tr>

        <tr>
            <td><input type="submit" value="Add"></td>
        </tr>
    </table>


</form:form>
</div>


</body>
</html>
