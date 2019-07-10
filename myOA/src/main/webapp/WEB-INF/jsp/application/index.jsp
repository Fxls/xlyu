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
                <c:forEach items="${list}" var="son">
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

            <form class="form-horizontal" role="form" action="${base}/application/leave" method="post">
                <div class="form-group">
                    <label for="inputEmail3" class="col-sm-2 control-label">申请人</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="inputEmail3" name="applyerName"/>
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputPassword3" class="col-sm-2 control-label">请假原因</label>
                    <div class="col-sm-10">
                        <textarea class="form-control" id="inputPassword3" name="reason">

                        </textarea>
                    </div>
                </div>


                <div class="form-group">
                    <label class="col-sm-2 control-label">开始时间</label>
                    <div class="col-sm-10">
                        <div class="row">
                            <div class='col-sm-6'>
                                <div class="form-group">
                                    <label>选择日期+时间：</label>
                                    <!--指定 date标记-->
                                    <div class='input-group date' id='datetimepicker2'>
                                        <input name="startTime" type='text' class="form-control"/>
                                        <span class="input-group-addon">
                                             <span class="glyphicon glyphicon-calendar"></span>
                                        </span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>


                <div class="form-group">
                    <label class="col-sm-2 control-label">结束时间</label>
                    <div class="col-sm-10">
                        <div class="row">
                            <div class='col-sm-6'>
                                <div class="form-group">
                                    <label>选择日期+时间：</label>
                                    <!--指定 date标记-->
                                    <div class='input-group date' id='datetimepicker3'>
                                        <input name="endTime" type='text' class="form-control"/>
                                        <span class="input-group-addon">
                                             <span class="glyphicon glyphicon-calendar"></span>
                                        </span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>


                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-default">提交</button>
                    </div>
                </div>
            </form>
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
