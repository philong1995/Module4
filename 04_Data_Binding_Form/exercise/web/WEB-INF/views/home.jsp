<%--
  Created by IntelliJ IDEA.
  User: macbookpro
  Date: 11/24/20
  Time: 6:57 PM
  To change this template use File | Settings | File Templates.
--%>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Save</title>
</head>
<body>
<form:form modelAttribute="setting" action="/setting">
    <label style="font-weight: bold;margin-right: 50px">Language: </label>
    <form:input path="language" disabled="true"></form:input> <br><br>
    <label style="font-weight: bold;margin-right: 50px">Page size: </label>
    <form:input path="pageSize" disabled="true"></form:input> <br><br>
    <label style="font-weight: bold;margin-right: 50px">Spams filter: </label>
    <form:input path="spamFilter" disabled="true"></form:input><br><br>
    <label style="font-weight: bold;margin-right: 50px">Signature</label>
    <form:textarea path="signature" disabled="true"></form:textarea>
</form:form>
</body>
</html>
