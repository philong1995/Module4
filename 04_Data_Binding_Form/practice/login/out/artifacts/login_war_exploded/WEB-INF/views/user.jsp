<%--
  Created by IntelliJ IDEA.
  User: macbookpro
  Date: 11/24/20
  Time: 10:33 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Info User</title>
</head>
<body>
<h1>Welcome</h1>
<h3>Account: ${user.account}</h3>
<h3>Name: ${user.name}</h3>
<h3>Email: ${user.email}</h3>
<h3>Age: ${user.age}</h3>
<a href="/login">Back</a>
</body>
</html>
