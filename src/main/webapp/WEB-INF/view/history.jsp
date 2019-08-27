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
    <div class="row border border-primary">
        
        <div class="col-md-4">Book title</div>
        <div class="col-md-2">Borrowed date</div>
        <div class="col-md-2">Return date</div>
        <div class="col-md-2">Due date</div>

    </div>

    <c:forEach var="borrows"  items="${borrows}" >
        <div class="row border border-primary">
            <div class="col-md-4">${borrows.title}</div>
            <div class="col-md-2">${borrows.dateTaken}</div>
            <div class="col-md-2">${borrows.dateBrought}</div>
            <div class="col-md-2">${borrows.dateToBring}</div>
        </div>
    </c:forEach>
</div>
<jsp:include page="include/footer.jsp"/>

</body>
</html>
