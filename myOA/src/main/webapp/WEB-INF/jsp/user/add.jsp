<%--
  Created by InteloptionJ IDEA.
  User: Administrator
  Date: 2019/7/8
  Time: 14:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    request.setAttribute("base", request.getContextPath());
%>
<html>
<head>
    <title>用户添加</title>
    <style>
        .fieldsetClass {
            margin-bottom: 20px;
        }

        .prompt {
            color: red;
            background-color: #5dffdf;
        }

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
    <script>
        function hidden() {
            setTimeout(function () {
                document.getElementById("hidden").hidden=true;
            },3000)
        }
    </script>
</head>
<body onload="hidden();">
<div>
    <%--放置顶部菜单--%>
        <c:forEach items="${parentMenu}" var="list">
            <%--<img  src="${base}/static/${list.menuIcon}1.png" alt="${list.menuName}"/>--%>
            <button class="parentMenuClass" onclick="location.href='${base}/${list.menuLink}?parentId=${list.id}'">${list.menuName}</button>
        </c:forEach>
</div>

<div id="hidden" class="prompt">
    ${msg}
</div>

<div>
    <fieldset style="margin-left: 400px;margin-right: 500px;">
        <legend>新增用户</legend>
        <form action="${base}/user/add" method="post">
            <input class="fieldsetClass" type="text" name="name" placeholder="姓名"><br>
            <input class="fieldsetClass" type="text" name="loginName" placeholder="登录名"><br>
            <input class="fieldsetClass" type="password" name="loginPwd" placeholder="密码"><br>
            <select class="fieldsetClass" name="status">
                <option value="1">正常</option>
                <option value="0">禁用</option>
            </select><br>
            <input type="submit" value="提交">
        </form>
    </fieldset>
</div>
</body>
</html>
