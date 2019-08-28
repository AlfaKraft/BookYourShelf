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
<h4>Login</h4>

<form action='<spring:url value="/app/loginAction"/>' method="post">
    <table>
        <tr>
            <td>Username</td>
            <td><input type="text" name="username"></td>
        </tr>
        <tr>
            <td>Password</td>
            <td><input type="password" name="password"></td>
        </tr>
        <tr>
            <td><button type="submit">Login</button></td>
        </tr>
    </table>
</form>
<a href="/app/user/faceRecognition"><button>Face recognition</button></a>
<br/>
<jsp:include page="include/footer.jsp"/>
</body>
</html>
