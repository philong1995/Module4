<%--
  Created by IntelliJ IDEA.
  User: macbookpro
  Date: 11/24/20
  Time: 4:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Máy tính đơn giản</title>
</head>
<body>
<center>
<h1>Calculator </h1>
<form>
        <input type="text" id="num1" name="num1" placeholder="first number">
        <input type="text" id="num2" name="num2" placeholder="second number"><br><br>
        <button type="submit" formaction="/add">+</button>
        <button type="submit" formaction="/sub">-</button>
        <button type="submit" formaction="/mul">x</button>
        <button type="submit" formaction="/div">/</button>
</form>
<h2>Result : ${resultNumber}</h2>
</center>
</body>
</html>
