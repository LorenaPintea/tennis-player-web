<%@ page import="java.time.LocalDate" %><%--
  Created by IntelliJ IDEA.
  User: lorenapintea
  Date: 07/08/2024
  Time: 12:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Tennis Player DB</title>
</head>
<body>
<%
    LocalDate currentDate = LocalDate.now();
%>

<p><i>Current Date: <%= currentDate %> </i></p>
<p><i>Today is <%= currentDate.getDayOfWeek() %> </i></p>

<h2>Welcome to the tennis player database!</h2>

<form action="${pageContext.request.contextPath}/player.do" method="POST">
    <b>Player name: <input type="text" name="name"/></b>
    <input type="submit" value="Enter"/>
</form>

</body>
</html>
