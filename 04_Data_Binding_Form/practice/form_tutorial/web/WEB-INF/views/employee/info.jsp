<%--
  Created by IntelliJ IDEA.
  User: macbookpro
  Date: 11/24/20
  Time: 3:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Infor</title>
</head>
<body>
<center>
<h2>Submitted Employee Information</h2>
<table>
    <tr>
        <td>Name :</td>
        <td>${name}</td>
    </tr>
    <tr>
        <td>ID :</td>
        <td>${id}</td>
    </tr>
    <tr>
        <td>Contact Number :</td>
        <td>${contactNumber}</td>
    </tr>
    <tr>
        <td></td>
        <td><a href="/showform">Create new employee</a></td>
    </tr>
</table>
</center>
</body>
</html>