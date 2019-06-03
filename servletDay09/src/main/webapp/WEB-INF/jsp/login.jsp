<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/6/3
  Time: 15:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/login" method="post">
    <input type="text" name="name" placeholder="输入用户名"><br/>
    <input type="password" name="pwd" placeholder="输入密码"> <br/>
    <input type="submit" value="登录">
</form>
</body>
</html>
