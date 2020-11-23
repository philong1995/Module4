<%--
  Created by IntelliJ IDEA.
  User: macbookpro
  Date: 11/24/20
  Time: 2:58 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: ttqld
  Date: 11/23/2020
  Time: 11:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sandwich Condiments</title>
</head>
<body>
    <form action="/save" method="get">
        <label for="condimentsName">Input name</label>
        </label><input id="condimentsName" type="text" name="name">
        <label>Lettuce</label>
        <input type="checkbox" name="condiments" value="Lettuce">
        <label>Tomato</label>
        <input type="checkbox" name="condiments" value="Tomato">
        <label>Mustard</label>
        <input type="checkbox" name="condiments" value="Mustard">
        <label>Sprouts</label>
        <input type="checkbox" name="condiments" value="Sprouts">
        <hr>
        <button type="submit">Save</button>
    </form>
</body>
</html>
