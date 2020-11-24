<%--
  Created by IntelliJ IDEA.
  User: macbookpro
  Date: 11/24/20
  Time: 2:27 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>List</title>
</head>
<body>
<center>
<table border="1">
  <tr>
    <th>Name Sandwich</th>
    <th>More Condiments</th>
  </tr>
  <c:forEach var="condiment" items="${condimentsList}">
    <tr>
      <td>${condiment.name}</td>
      <td>${condiment.getCondiments()}</td>
    </tr>
  </c:forEach>
</table>
<a type="button" href="/add" style="text-decoration: none;color: blue">Add New Sandwich and More Condiments</a>
</center>
</body>
</html>
