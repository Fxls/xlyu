<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/6/4
  Time: 15:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/login" method="post">
    <input type="text" name="username" placeholder="用户名">
    <br/>
    <input type="password" name="userpwd" placeholder="密码">
    <br/>
    <input type="checkbox" name="hobbies" value="抽烟">抽烟
    <input type="checkbox" name="hobbies" value="喝酒">喝酒
    <input type="checkbox" name="hobbies" value="烫头">烫头
    <br/>
    <input type="submit">
</form>
</body>
</html>
