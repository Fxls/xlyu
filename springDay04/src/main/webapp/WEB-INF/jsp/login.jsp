<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/6/28
  Time: 9:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<fieldset>
    <legend>用户登录</legend>
    <form method="post" action="login.do">
        <input type="text" placeholder="请输入登录账号" name="adminCode"><br/>
        <input placeholder="请输入密码" type="password" name="password"><br/>
        <span style="color: red;font-size: 10px">${msg}</span><br>
        <input type="submit" value="登录">
    </form>
</fieldset>
</body>
</html>
