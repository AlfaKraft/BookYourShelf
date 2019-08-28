<%--
  Created by IntelliJ IDEA.
  User: kasutaja
  Date: 15.08.2019
  Time: 9:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>

<jsp:include page="include/header.jsp"/>

<div class="container">
<div class="row">
    <div class="col-md-3">

    </div>
<div class="col-md-6">
        <form action='<spring:url value="/app/loginAction"/>' method="post">
        <h2>Log in</h2>
        <div class="form-group">
            <label>E-mail</label>
                <input class="form-control" type="text" name="username" placeholder="E-mail">
        </div>
        <div class="form-group">
            <label>Password</label>
                <input class="form-control" type="password" name="password" placeholder="Password">
        </div>
            <button class="btn btn-lg btn-primary btn-block" type="submit">Login</button>
        </form>
</div>
    <div class="col-md-3">

    </div>

</div>
</div>

<jsp:include page="include/footer.jsp"/>
</body>
</html>
