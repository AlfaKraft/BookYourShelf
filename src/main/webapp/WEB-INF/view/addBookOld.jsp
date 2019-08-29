<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: kasutaja
  Date: 26.08.2019
  Time: 16:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Books - BookYourShelf - Tieto</title>
</head>
<body>
<jsp:include page="include/header.jsp"/>

<div class="container">
    <!--<form method="POST" enctype="multipart/form-data" id="fileUploadForm" action="/app/book/new_v3">
        <input type="text" name="title"/><br/>
        <input type="file" name="coverImage"/><br/><br/>
        <input type="submit" value="Submit" id="btnSubmit"/>
    </form>-->

    <form method="POST" enctype="multipart/form-data" action="/app/book/new_v3">
        <table>
            <tr><td>File to upload:</td><td><input type="file" name="file" /></td></tr>
            <tr><td></td><td><input type="submit" value="Upload" /></td></tr>
        </table>
    </form>
</div>


</body>
</html>
