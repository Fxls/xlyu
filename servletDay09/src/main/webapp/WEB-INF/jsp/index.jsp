<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/6/3
  Time: 15:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    ServletContext sc = application;
    String name = (String) sc.getAttribute("name");
%>
<h1>
    你好，<%=name%>，欢迎登录
</h1>
<br/>
<form action="<%=request.getContextPath()%>/logout" method="post">
    <input type="submit">
</form>
</body>
</html>
