<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: kasutaja
  Date: 22.08.2019
  Time: 18:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>History</title>
</head>
<body>
<body>
<jsp:include page="include/header.jsp"/>
<div class="container">
    <h2>History</h2>
    <table class="table table-striped">
        <thead>
            <th>Book title</th>
            <th>Borrowed date</th>
            <th>Return date</th>
            <th>Due date</th>
        </thead>
        <tbody>
        <c:forEach var="borrows"  items="${borrows}" >
            <tr>
                <td>${borrows.title}</td>
                <td>${borrows.dateTaken}</td>
                <td>${borrows.dateBrought}</td>
                <td>${borrows.dateToBring}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>
<jsp:include page="include/footer.jsp"/>

</body>
</html>
