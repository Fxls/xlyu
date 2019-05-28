<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/28
  Time: 14:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>timeShow</title>
    <script src="../static/js/jquery-1.4.3.js"></script>
    <script>
        $(function () {
            setInterval(function () {
                window.location.reload();
            },1000)
        });
    </script>

</head>
<%--自动刷新时间--%>
<body>
当前时间：<%=(new java.util.Date()).toLocaleString()%>

</body>
</html>
