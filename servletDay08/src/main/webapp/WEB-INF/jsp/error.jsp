<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/6/1
  Time: 15:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>验证码都错？</title>
    <script>
        function auto() {
            setInterval(function () {
                location.href="http://localhost:8080/servletDay08/login.log";
            },3000)
        }
    </script>
</head>
<body onload="auto();">
验证码都能输歪来
</br>
3s自动回去嗷
</body>
</html>
