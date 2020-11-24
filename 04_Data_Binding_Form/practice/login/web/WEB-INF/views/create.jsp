<%--
  Created by IntelliJ IDEA.
  User: macbookpro
  Date: 11/24/20
  Time: 9:54 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
  <head>
    <title>Create User</title>
  </head>
  <body>
  <form:form action="/create-user" method="post" modelAttribute="user">
    <p>Account name : </p>
    <form:input path="account" />
    <p>Password : </p>
    <form:input type="password" path="password" />
    <p>User name : </p>
    <form:input type="text" path="name" />
    <p>Email : </p>
    <form:input type="text" path="email" />
    <p>Age : </p>
    <form:input type="text" path="age" />
    <p>
    <form:button>Create</form:button>
    </p>
  </form:form>
  </body>
</html>
