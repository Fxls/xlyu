<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/6/8
  Time: 13:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    request.setAttribute("base", request.getContextPath());
%>
<!DOCTYPE >
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>宏晶信息－NetCTOSS</title>
    <link type="text/css" rel="stylesheet" media="all" href="<%=request.getContextPath()%>/styles/global.css"/>
    <link type="text/css" rel="stylesheet" media="all" href="<%=request.getContextPath()%>/styles/global_color.css"/>
    <style>
        #Time {
            color: white;
            font-weight: bolder;
            position: absolute;
            font-size: 35px;
            margin: 400px 650px;
        }
    </style>
    <script>
        function time() {
            setInterval(function () {
                var now = new Date();
                var obj = document.getElementById("Time");
                obj.innerText = now.toLocaleTimeString();

            }, 1000)
        }
    </script>
</head>
<body class="index" onload="time();">
<div id="Time"></div>
<!--导航区域开始-->
<div id="index_navi">
    <ul id="menu">
        <c:forEach var="menu" items="${menus}">
            <li><a href="${base}${menu.href}" class="${menu.clazz}"></a></li>
        </c:forEach>

        <%--<li><a href="index.html" class="index_on"></a></li>--%>
        <%--<li><a href="http://localhost:8080/netctoss/toRole.role" class="role_off"></a></li>--%>
        <%--<li><a href="admin/admin_list.html" class="admin_off"></a></li>--%>
        <%--<li><a href="fee/fee_list.html" class="fee_off"></a></li>--%>
        <%--<li><a href="account/account_list.html" class="account_off"></a></li>--%>
        <%--<li><a href="service/service_list.html" class="service_off"></a></li>--%>
        <%--<li><a href="bill/bill_list.html" class="bill_off"></a></li>--%>
        <%--<li><a href="report/report_list.html" class="report_off"></a></li>--%>
        <%--<li><a href="user/user_info.html" class="information_off"></a></li>--%>
        <%--<li><a href="user/user_modi_pwd.html" class="password_off"></a></li>--%>
    </ul>
</div>
</body>
</html>

