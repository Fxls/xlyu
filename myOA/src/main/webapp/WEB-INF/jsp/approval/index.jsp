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
    <title>login</title>
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
                    <a href="#">首页</a>
                </li>
                <c:forEach items="${topMenus}" var="top">

                    <c:if test="${top.id==3}">
                        <li class="active">
                            <a href="${base}/${top.menuLink}?parentId=${top.id}">${top.menuName}</a>
                        </li>
                    </c:if>
                    <c:if test="${top.id!=3}">
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
                <c:forEach items="${list}" var="son">
                    <c:if test="${son.menuName=='请假审批'}">
                        <div class="panel-heading">
                                ${son.menuName}
                        </div>
                    </c:if>
                    <c:if test="${son.menuName!='请假审批'}">
                        <div class="panel-body">
                                ${son.menuName}
                        </div>
                    </c:if>
                </c:forEach>
            </div>
        </div>
        <div class="col-md-8 column">
            <div class="page-header">
                <c:forEach items="${applicationLeaves}" var="leave">
                    <form action="${base}/approval/leave" method="post">
                        <input hidden type="text" name="handleName" value="${nameNav}">
                        <input hidden type="text" name="applicationId" value="${leave.id}">
                        <input hidden type="text" name="approvalType" value="请假审批">
                        <h1>
                            请假审批 from ${leave.applyerName}<br/>
                            <small>请假事由：${leave.reson}</small>
                            <br/>
                            <small>请假时间：<fmt:formatDate value="${leave.startTime}" pattern="yyyy/MM/dd HH:mm"/>
                                ~
                                <fmt:formatDate value="${leave.endTime}" pattern="yyyy/MM/dd HH:mm"/>
                            </small>
                                <%--<fmt:formatDate value="${record.startTime}" pattern="yyyy/MM/dd HH:mm" /> --%>
                            <br/>
                        </h1>
                            <%--审批意见--%>
                        <div class="form-group">
                            <div class="col-sm-10">
                                <label for="inputPassword3" class="col-sm-2 control-label">
                                    审批意见
                                </label><br/>
                                <textarea class="form-control" id="inputPassword3" name="tip"></textarea><br/>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="radio">
                                <label><input type="radio" name="result" value="通过"/>通过</label>
                                <label><input type="radio" name="result" value="不通过"/>不通过</label>
                            </div>
                        </div>
                        <button type="submit" class="btn btn-default">确定</button>
                    </form>
                </c:forEach>
            </div>
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
