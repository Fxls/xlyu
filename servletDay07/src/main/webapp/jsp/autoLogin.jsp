<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/31
  Time: 19:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>自动登录页面</title>
</head>
<body>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>cookieTest</title>
    <script>
        function load() {
            var name = document.getElementById("idName");
            var pwd = document.getElementById("idPwd");
            if (name.value == "null" && pwd.value == "null") {
                name.value = "";
                pwd.value = "";
            }
        }

        function check() {
            var name = document.getElementById("idName");
            var pwd = document.getElementById("idPwd");
            if (name.value == "" || pwd.value == "") {
                alert("？？？？？？？？？？？");
            }
        }

    </script>
</head>
<body onload="load();">
<form action="<%=request.getContextPath()%>/check.log" method="post">
    <%
        String name = (String) request.getAttribute("name");
        String pwd = (String) request.getAttribute("pwd");
    %>
    <input id="idName" type="text" placeholder="输入用户名" name="name" value="<%=name%>"/>
    <input id="idPwd" type="password" placeholder="输入密码" name="pwd" value="<%=pwd%>"/>
    <button type="submit" onclick="check();">Go</button>
    >
</form>
</body>
</html>
</body>
</html>
