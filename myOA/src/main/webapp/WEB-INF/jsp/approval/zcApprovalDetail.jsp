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
    <title>请假审批</title>
    <link href="${base}/static/bootstrap/css/bootstrap.css" rel="stylesheet">
    <link href="${base}/static/bootstrap/bootstrap-datetimepicker.min.css" rel="stylesheet">
    <style>
        .prompt {
            color: red;
            background-color: #5dffdf;
        }

        .diyTable {
            border: 5px black solid;
            padding: 20px;
            margin-top: 10px;
            margin-bottom: 10px;
            border-radius: 20px;
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
                <c:forEach items="${leaveApprovalList}" var="son">
                    <c:if test="${son.menuName=='资产采购审批'}">
                        <div class="panel-heading">
                                ${son.menuName}
                        </div>
                    </c:if>
                    <c:if test="${son.menuName!='资产采购审批'}">
                        <div class="panel-body">
                                ${son.menuName}
                        </div>
                    </c:if>
                </c:forEach>
            </div>
        </div>
        <div class="col-md-8 column">

            <h3 class="text-center text-info">
                待审批
            </h3>
            <div class="diyTable">
                <table class="table table-striped table-hover">
                    <thead>
                    <tr>
                        <th>
                            申请人
                        </th>
                        <th>
                            <%--申请人--%>
                            <input readonly class="input-sm" type="text" value="${thisDetail.applyerName}"/>
                        </th>
                        <th>
                            申请id
                        </th>
                        <th>
                            <%--申请人id--%>
                            <input readonly class="input-sm" type="text" value="${thisDetail.applyerId}"/>
                        </th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td colspan="4">
                            <center><strong>采购事由</strong></center>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="4" rowspan="2">
                        <textarea class="form-control" rows="4" readonly>
                            <%--采购说明--%>
                            ${thisDetail.resonShopping}
                        </textarea>
                        </td>
                    </tr>
                    <tr>
                    </tr>
                    <tr>
                        <td><strong>采购产品名称</strong></td>
                        <td colspan="3">
                            <input readonly value="${thisDetail.proName}" class="form-control" type="text">
                        </td>
                    </tr>
                    <tr>
                        <td><strong>采购产品数量</strong></td>
                        <td><input readonly value="${thisDetail.proNumber}" class="input-sm" type="text"></td>
                        <td><strong>产品单价</strong></td>
                        <td><input readonly value="${thisDetail.proPrice}" class="input-sm" type="text"></td>
                    </tr>
                    <tr>
                        <td><strong>申请时间</strong></td>
                        <td colspan="3">
                            <fmt:formatDate value="${thisDetail.applyTime}" pattern="yyyy-MM-dd HH:mm"/>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="4">
                            <center><strong style="color:#1329ff">备注</strong></center>
                        </td>
                    </tr>
                    <tr>
                        <td rowspan="2" colspan="4">
                        <textarea class="form-control" readonly rows="2">
                            ${thisDetail.tip}
                        </textarea>
                        </td>
                    </tr>
                    <tr>
                    </tr>
                    <form action="${base}/approval/handleZCApproval" method="post">
                        <input hidden name="applicationId" value="${thisDetail.id}" type="text"/>
                        <input hidden name="approvalType" value="资产采购审批" type="text"/>
                        <input hidden name="handleName" value="${nameNav}" type="text"/>
                        <tr>
                            <td colspan="2">
                                <center>
                                    <label for="QWER">通过</label>
                                    <input id="QWER" type="radio" name="result" value="通过"/>
                                </center>
                            </td>
                            <td colspan="2">
                                <center>
                                    <label for="REWQ">不通过</label>
                                    <input id="REWQ" type="radio" name="result" value="不通过"/>
                                </center>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="4">
                                <center><strong style="color:#ff24ba">审批意见</strong></center>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="4" rowspan="2">
                            <textarea class="form-control" rows="2" name="tip">

                            </textarea>
                            </td>
                        </tr>
                        <tr>
                        </tr>
                        <tr>
                            <td colspan="2">
                                <button type="button" class="btn btn-block btn-info btn-sm" onclick="history.back()">
                                    return
                                </button>
                            </td>
                            <td colspan="2">
                                <button type="submit" class="btn btn-block btn-warning btn-sm">submit</button>
                            </td>
                    </form>
                    </tr>
                    </tbody>
                </table>
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


