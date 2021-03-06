<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
     <!--The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags-->
<meta name="description" content="">
    <meta name="author" content="">

    <title>Create an account - BookYourShelf - Tieto</title>


</head>

<body>
<jsp:include page="include/header.jsp"/>
<div class="container">

    <div class="row">
        <div class="col-md-3">
        </div>
        <div class="col-md-6">
    <form:form method="POST" action="/app/user/save" modelAttribute="user" enctype="multipart/form-data" class="form-signin">
        <h1 class="form-signin-heading">Create your account</h1>
        <form:hidden path="id" />
        <spring:bind path="firstName">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:label path="firstName">First name</form:label>
                <form:input type="text" path="firstName" class="form-control" placeholder="First name"
                            autofocus="true"></form:input>
                <form:errors path="firstName"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="lastName">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:label path="lastName">Last name</form:label>
                <form:input type="text" path="lastName" class="form-control" placeholder="Last name"
                            autofocus="true"></form:input>
                <form:errors path="lastName"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="email">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:label path="email">E-mail</form:label>
                <form:input type="text" path="email" class="form-control" placeholder="E-mail"
                            autofocus="true"></form:input>
                <form:errors path="email"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="password">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:label path="password">Password</form:label>
                <form:input type="password" path="password" class="form-control" placeholder="Password"></form:input>
                <form:errors path="password">
                </form:errors>
            </div>
        </spring:bind>

        <spring:bind path="matchingPassword">
            <div class="form-group ${status.error ? 'has-error' : ''}">

                <form:label path="matchingPassword">Repeat password</form:label>
                <form:input type="password" path="matchingPassword" class="form-control" placeholder="Repeat password"></form:input>

            </div>
        </spring:bind>


        <spring:bind path="pictureFile">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:label class="custom-file-upload" path="pictureFile">Add profile picture  <img src="/css/img/cloud-computing.png"></form:label>
                <form:input type="file" path="pictureFile" class="form-control picture-user " placeholder="Picture"></form:input>
                <p class="file-return"></p>
            </div>
        </spring:bind>


        <button class="btn btn-lg btn-primary btn-block " type="submit">Submit</button>
    </form:form>
        </div>

    <div class="col-md-3">

    </div>
    </div>
</div>
<jsp:include page="include/footer.jsp"/>


</body>
<script>
    document.querySelector("html").classList.add('js');

    var fileInput  = document.querySelector( ".picture-user" ),
        button     = document.querySelector( ".custom-file-upload" ),
        the_return = document.querySelector(".file-return");

    button.addEventListener( "keydown", function( event ) {
        if ( event.keyCode == 13 || event.keyCode == 32 ) {
            fileInput.focus();
        }
    });
    button.addEventListener( "click", function( event ) {
        fileInput.focus();
        return false;
    });
    fileInput.addEventListener( "change", function( event ) {
        the_return.innerHTML = this.value;
    });
</script>
</html>


