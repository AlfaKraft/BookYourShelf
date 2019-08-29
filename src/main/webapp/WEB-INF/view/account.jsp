<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="java.sql.Connection" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Your account - BookYourShelf - Tieto</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/account.css">
</head>
<body>
<jsp:include page="include/header.jsp"/>
<div class="container">
    <h2>Account Information</h2>
    <div class="row">
        <div class="col-md-3">

        </div>

        <div class="col-md-6">
            <div class="account-view">
            <div>First name:</div>
            <div>${details.firstName}</div>
            </div>
            <div class="account-view">
                <div>Last name:</div>
                <div>${details.lastName}</div>
            </div>
            <div class="account-view">
                <div>E-mail:</div>
                <div>${details.email}</div>
            </div>
        </div>

        <div class="col-md-3">

        </div>
    </div>


    </div>

</body>
</html>
