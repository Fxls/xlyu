<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/8
  Time: 21:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    request.setAttribute("base", request.getContextPath());
%>
<html>
<head>
    <title>Title</title>
    <style>
        .parentMenuClass{
            margin-left: 5px;
            margin-top: 10px;
            margin-bottom: 10px;
            width: 100px;
            height: 50px;
            background-color: #04a2ff;
            outline: 0px;
            border: none;
            box-shadow: 3px 2px 2px #0f15ff;
            border-radius: 50px;
        }
    </style>
</head>
<body>
<div>
    <%--放置顶部菜单--%>
    <c:forEach items="${parentMenu}" var="list">
        <%--<img  src="${base}/static/${list.menuIcon}1.png" alt="${list.menuName}"/>--%>
        <button class="parentMenuClass" onclick="location.href='${base}/${list.menuLink}?parentId=${list.id}'">${list.menuName}</button>
    </c:forEach>
</div>
<c:forEach items="${list}" var="list">
    <h1>${list.menuName}</h1>
</c:forEach>
</body>
</html>
