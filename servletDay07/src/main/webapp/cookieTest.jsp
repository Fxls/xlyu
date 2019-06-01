<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/30
  Time: 18:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>cookieTest</title>
</head>
<body>
<form action="http://localhost:8080/servletDay07/login" method="post">
    <input type="text" placeholder="输入用户名" name="name"/>
    <input type="text" placeholder="输入所在地" name="area"/>
    <input type="submit" value="Go"/>
</form>
</body>
</html>