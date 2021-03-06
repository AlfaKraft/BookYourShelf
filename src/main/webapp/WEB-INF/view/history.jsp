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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/history.css" >
</head>
<body>
<jsp:include page="include/header.jsp"/>
<div class="limiter">
    <div class="container-table100">
        <div class="wrap-table100">
            <div class="table100">
    <h1>History</h1>
                <div class="inputGroup">
                    <input id="filterBorrowed" name="filterBorrowed" type="checkbox" onclick="filtered()"/>
                    <label for="filterBorrowed">Currently in your possession</label>
                </div>
    <table id="historytable">
        <tr class="table-head ">
            <th>Book title</th>
            <th>Borrowed date</th>
            <th>Return date</th>
            <th>Due date</th>
        </tr>
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
        </div>
    </div>
</div>

<jsp:include page="include/footer.jsp"/>

<script src="${pageContext.request.contextPath}/js/filterBorrowed.js">

</script>
</body>
</html>
