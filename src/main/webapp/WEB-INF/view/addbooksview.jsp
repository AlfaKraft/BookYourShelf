<%--
  Created by IntelliJ IDEA.
  User: kasutaja
  Date: 13.08.2019
  Time: 15:17
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add and Remove Books</title>
</head>
<body>
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
                <td><input type="submit" value="Add"></td>
            </tr>


        </table>
        <h3>Raamatute nimekiri</h3>
        <ul>
            <c:forEach var="book" items="${list}">
                    <li>${book.title}</li>
            </c:forEach>
        </ul>

    </form:form>



</body>
</html>
