<%@ page import="java.net.URLEncoder" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/6/1
  Time: 11:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>请登录</title>
</head>
<body>
<%
    //重写url地址
    String url = response.encodeURL(request.getContextPath() + "/check.log");
%>

<form action="<%=url%>" method="post">
    <input type="text" placeholder="请输入用户名" name="name"/>
    <input type="password" placeholder="请输入密码" name="pwd"/>
    <input type="text" name="captcha" placeholder="captcha">
    <img id="idImg" src="<%=request.getContextPath()%>/captcha.log" onclick="this.src='<%=request.getContextPath()%>/captcha.log?d='+Math.random();"><br>
    <%--<input type="text"/>--%>
    <input type="submit"/>

</form>

</body>
</html>
