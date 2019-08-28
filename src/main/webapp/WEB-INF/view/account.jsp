<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="java.sql.Connection" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Your account</title>
</head>
<body>
<jsp:include page="include/header.jsp"/>
<div class="container">
    <h2>Account Information</h2>
    <div class="row">
            <div class="col-md-8">
                <p>Firstname: ${details.firstName}</p>
                <p>Lastname: ${details.lastName}</p>
                <p>E-mail: ${details.email}</p>
            </div>
    </div>

</body>
</html>
