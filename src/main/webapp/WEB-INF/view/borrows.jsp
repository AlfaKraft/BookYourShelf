<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: kasutaja
  Date: 16.08.2019
  Time: 12:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

</head>
<body>
<jsp:include page="include/header.jsp"/>
<div class="container">
    <input id="search-user" type="text" onkeyup="myFunction()" placeholder="Search for a user...">

     <table id="borrowtable" class="table table-striped">
         <thead>
    <tr>
        <th>Book reader</th>
        <th>Books title</th>
        <th>Borrowed date</th>
        <th>Return date</th>
        <th>Due date</th>
    </tr>
         </thead>
         <tbody>
<c:forEach var="borrows"  items="${borrows}" >

    <tr>
        <td>${borrows.name}</td>
        <td>${borrows.title}</td>
        <td>${borrows.dateTaken}</td>
        <td>${borrows.dateBrought}</td>
        <td>${borrows.dateToBring}</td>
    </tr>

</c:forEach>
         </tbody>
     </table>

</div>

<script src="${pageContext.request.contextPath}/js/borrows.js"></script>

<jsp:include page="include/footer.jsp"/>
</body>


</html>
