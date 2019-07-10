<%@ page import="java.util.List" %>
<%@ page import="com.itek.myoa.domain.Menu" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/9
  Time: 15:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    request.setAttribute("base", request.getContextPath());
    List<Menu> topMenus = (List<Menu>) session.getAttribute("topMenus");
%>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>login</title>
    <link href="${base}/static/bootstrap/css/bootstrap.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <h3 class="text-left">
                ${nameNav},欢迎您使用OA系统
            </h3>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-12 column">
            <ul class="nav nav-tabs">
                <li class="active">
                    <a href="#">首页</a>
                </li>
                <c:forEach items="${topMenus}" var="top">
                    <li>
                        <a href="${base}/${top.menuLink}?parentId=${top.id}">${top.menuName}</a>
                    </li>
                </c:forEach>

                <li class="dropdown pull-right">
                    <a href="#" data-toggle="dropdown" class="dropdown-toggle">下拉<strong class="caret"></strong></a>
                    <ul class="dropdown-menu">
                        <li>
                            <a href="#">操作</a>
                        </li>
                        <li>
                            <a href="#">设置栏目</a>
                        </li>
                        <li>
                            <a href="#">更多设置</a>
                        </li>
                        <li class="divider">
                        </li>
                        <li>
                            <a href="#">分割线</a>
                        </li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-4 column">
            <div class="panel panel-default">
                <div class="panel-heading">
                        Panel title
                </div>
                <div class="panel-body">
                    Panel content
                </div>
                <div class="panel-body">
                    Panel footer
                </div>
            </div>
        </div>
        <div class="col-md-8 column">
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-12 column">
            <center><span><font face="微软雅黑">&copy;2019 xlyu.All Rights Reserved.</font></span>
            </center>
        </div>
    </div>
</div>
<script src="${base}/static/jquery/jquery.min.js"></script>
<script src="${base}/static/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
