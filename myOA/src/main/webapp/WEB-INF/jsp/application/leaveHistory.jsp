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
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    request.setAttribute("base", request.getContextPath());


%>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>申请记录</title>
    <link href="${base}/static/bootstrap/css/bootstrap.css" rel="stylesheet">
    <link href="${base}/static/bootstrap/bootstrap-datetimepicker.min.css" rel="stylesheet">
    <style>
        .prompt {
            color: red;
            background-color: #5dffdf;
        }
    </style>
    <script>
        function hidden() {
            setTimeout(function () {
                document.getElementById("hidden").hidden = true;
            }, 3000)
        }
    </script>
</head>
<body onload="hidden();">
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
                <li>
                    <a href="${base}/login/index">首页</a>
                </li>
                <c:forEach items="${topMenus}" var="top">

                    <c:if test="${top.id==2}">
                        <li class="active">
                            <a href="${base}/${top.menuLink}?parentId=${top.id}">${top.menuName}</a>
                        </li>
                    </c:if>
                    <c:if test="${top.id!=2}">
                        <li>
                            <a href="${base}/${top.menuLink}?parentId=${top.id}">${top.menuName}</a>
                        </li>
                    </c:if>
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
                <c:forEach items="${leavelist}" var="son">
                    <c:if test="${son.menuName=='请假申请'}">
                        <div class="panel-heading">
                                ${son.menuName}
                        </div>
                    </c:if>
                    <c:if test="${son.menuName!='请假申请'}">
                        <div class="panel-body">
                                ${son.menuName}
                        </div>
                    </c:if>
                </c:forEach>
            </div>
        </div>
        <div class="col-md-8 column">
            <table class="table table-hover table-bordered ">
                <thead>
                <tr>
                    <th>
                        请假申请记录id
                    </th>
                    <th>
                        申请人
                    </th>
                    <th>
                        请假事由
                    </th>
                    <th>
                        请假时间
                    </th>
                    <th>
                        申请状态
                    </th>
                    <th>
                        处理人
                    </th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${applicationOfLeave}" var="application">
                    <tr>
                        <th>
                                ${application.id}
                        </th>
                        <th>
                                ${application.applyerName}
                        </th>
                        <th>
                                ${application.reson}
                        </th>
                        <th>
                            <fmt:formatDate value="${application.startTime}"
                                            pattern="yyyy-MM-dd HH:mm"/>~<fmt:formatDate value="${application.endTime}"
                                                                                         pattern="yyyy-MM-dd HH:mm"/>
                        </th>

                        <c:choose>
                            <c:when test="${application.status=='0'}">
                                <th style="background-color: yellow">
                                    正在审批
                                </th>
                            </c:when>
                            <c:when test="${application.status=='1'}">
                                <th style="background-color: green">
                                    审批通过
                                </th>
                            </c:when>
                            <c:when test="${application.status=='2'}">
                                <th style="background-color: red">
                                    审批未通过
                                </th>
                            </c:when>
                            <c:otherwise>
                                <th style="background-color: red">
                                    未知状态，联系管理员
                                </th>
                            </c:otherwise>
                        </c:choose>

                        <th>
                                <%--
                                    先判断status是否为0，为0时处理人无,不为0时选择处理人
                                --%>
                            <c:if test="${application.status=='0'}">
                                <strong>暂无</strong>
                            </c:if>
                            <c:if test="${application.status!='0'}">
                                <%--此时遍历关联表集合，如果两表中的关联条件相等输出处理人姓名--%>
                                <c:forEach items="${approvalToLeave}" var="connection">
                                    <c:if test="${application.id==connection.applicationId}">
                                        <strong>${connection.handleName}</strong>
                                    </c:if>
                                </c:forEach>
                            </c:if>
                        </th>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div id="hidden" class="prompt">
                ${appMsg}
            </div>
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
<script src="${base}/static/bootstrap/moment-with-locales.js"></script>
<script src="${base}/static/bootstrap/bootstrap-datetimepicker.min.js"></script>
<script>
    $(function () {
        $('#datetimepicker3').datetimepicker({
            format: 'YYYY-MM-DD hh:mm',
            locale: moment.locale('zh-cn')
        });
        $('#datetimepicker2').datetimepicker({
            format: 'YYYY-MM-DD hh:mm',
            locale: moment.locale('zh-cn')
        });
    });
</script>

</body>
</html>
