<%--
  Created by IntelliJ IDEA.
  User: kasutaja
  Date: 9.08.2019
  Time: 15:28
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head></head>
<body>
<h3>Uus isik</h3>
<form:form method="POST" action="/app/book/save" modelAttribute="book" >
    <table>
        <tr>
            <td><form:label path="barCode">Barcode</form:label></td>
            <td><form:input path="barCode"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="Salvesta"/></td>
        </tr>
    </table>
</form:form>
</body>
</html>
