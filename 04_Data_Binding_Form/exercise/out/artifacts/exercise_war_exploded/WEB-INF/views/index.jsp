<%--
  Created by IntelliJ IDEA.
  User: macbookpro
  Date: 11/24/20
  Time: 3:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Setting Email</title>
</head>
<body>

<form:form action="/setting" method="post" modelAttribute="setting">
  <label style="font-weight: bold;margin-right: 50px">Language: </label>
  <form:select path="language" items="${languageList}"></form:select> <br><br>
  <label style="font-weight: bold;margin-right: 50px">Page size: </label>
  Show <form:select path="pageSize" items="${pageList}"></form:select> email per page <br><br>
  <label style="font-weight: bold;margin-right: 50px">Spams filter: </label>
  <form:checkbox path="spamFilter"></form:checkbox>Enable Spams Filter<br><br>
  <label style="font-weight: bold;margin-right: 50px">Signature</label>
  <form:textarea path="signature"></form:textarea><br><br>
  <hr>
  <form:button>Update</form:button>
</form:form>
</body>
</html>