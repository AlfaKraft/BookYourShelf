<%--
  Created by IntelliJ IDEA.
  User: kasutaja
  Date: 9.08.2019
  Time: 15:44
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Books</title>
</head>
<body>
<h3>Raamatute nimekiri</h3>
<ul>
    <c:forEach var="book" items="${books}">
        <li>${book.title}</li>
    </c:forEach>
</ul>
<a href="/index.jsp">Back</a>



</body>
</html>
