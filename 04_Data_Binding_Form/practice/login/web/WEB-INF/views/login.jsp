<%--
  Created by IntelliJ IDEA.
  User: macbookpro
  Date: 11/24/20
  Time: 10:18 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h3>Home</h3>
<%--@elvariable id="login" type=""--%>
<form:form action="login" method="post" modelAttribute="login">
    <fieldset>
        <legend>Login</legend>
        <table>
            <tr>
                <td><form:label path="account">Account:</form:label></td>
                <td><form:input path="account"  /></td>
            </tr>
            <tr>
                <td><form:label path="password">Password:</form:label></td>
                <td><form:input type="password" path="password"/></td>
            </tr>
            <tr>
                <td><form:button>Login</form:button></td>
                <td><a href="/create">Create New User</a></td>
            </tr>
        </table>
    </fieldset>
</form:form>
</body>
</html>
