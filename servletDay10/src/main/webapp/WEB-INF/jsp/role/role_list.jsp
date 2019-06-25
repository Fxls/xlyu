<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/6/4
  Time: 16:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>宏晶信息－NetCTOSS</title>
    <link type="text/css" rel="stylesheet" media="all" href="<%=request.getContextPath()%>/static/styles/global.css" />
    <link type="text/css" rel="stylesheet" media="all" href="<%=request.getContextPath()%>/static/styles/global_color.css" />
    <script language="javascript" type="text/javascript">
        function deleteRole() {
            var r = window.confirm("确定要删除此角色吗？");
            document.getElementById("operate_result_info").style.display = "block";
        }
    </script>
</head>
<body>
<!--Logo区域开始-->
<div id="header">
    <img src="<%=request.getContextPath()%>/static/images/logo.png" alt="logo" class="left"/>
    <a href="#">[退出]</a>
</div>
<!--Logo区域结束-->
<!--导航区域开始-->
<div id="navi">
    <ul id="menu">
        <li><a href="<%=request.getContextPath()%>/WEB-INF/jsp/index.html" class="index_off"></a></li>
        <li><a href="<%=request.getContextPath()%>/WEB-INF/jsp/role/role_list.html" class="role_on"></a></li>
        <li><a href="<%=request.getContextPath()%>/WEB-INF/jsp/admin/admin_list.html" class="admin_off"></a></li>
        <li><a href="<%=request.getContextPath()%>/WEB-INF/jsp/fee/fee_list.html" class="fee_off"></a></li>
        <li><a href="<%=request.getContextPath()%>/WEB-INF/jsp/account/account_list.html" class="account_off"></a></li>
        <li><a href="<%=request.getContextPath()%>/WEB-INF/jsp/service/service_list.html" class="service_off"></a></li>
        <li><a href="<%=request.getContextPath()%>/WEB-INF/jsp/bill/bill_list.html" class="bill_off"></a></li>
        <li><a href="<%=request.getContextPath()%>/WEB-INF/jsp/report/report_list.html" class="report_off"></a></li>
        <li><a href="<%=request.getContextPath()%>/WEB-INF/jsp/user/user_info.html" class="information_off"></a></li>
        <li><a href="<%=request.getContextPath()%>/WEB-INF/jsp/user/user_modi_pwd.html" class="password_off"></a></li>
    </ul>
</div>
<!--导航区域结束-->
<!--主要区域开始-->
<div id="main">
    <form action="" method="">
        <!--查询-->
        <div class="search_add">
            <input type="button" value="增加" class="btn_add" onclick="location.href='role_add.html';" />
        </div>
        <!--删除的操作提示-->
        <div id="operate_result_info" class="operate_success">
            <img src="<%=request.getContextPath()%>/WEB-INF/jsp/images/close.png" onclick="this.parentNode.style.display='none';" />
            删除成功！
        </div> <!--删除错误！该角色被使用，不能删除。-->
        <!--数据区域：用表格展示数据-->
        <div id="data">
            <table id="datalist">

                <tr>
                    <th>角色 ID</th>
                    <th>角色名称</th>
                    <th class="width600">拥有的权限</th>
                    <th class="td_modi"></th>
                </tr>
                <c:forEach var="role" items="${list}" varStatus="stat">
                    <tr>
                        <td>${role.id}</td>
                        <td>${role.name}</td>
                        <td>${role.powerNames}</td>
                        <td>
                            <input type="button" value="修改" class="btn_modify" onclick="location.href='role_modi.html';"/>
                            <input type="button" value="删除" class="btn_delete" onclick="deleteRole();" />
                        </td>
                    </tr>
                </c:forEach>

            </table>
        </div>
        <!--分页-->
        <div id="pages">
            <a href="#">上一页</a>
            <a href="#" class="current_page">1</a>
            <a href="#">2</a>
            <a href="#">3</a>
            <a href="#">4</a>
            <a href="#">5</a>
            <a href="#">下一页</a>
        </div>
    </form>
</div>
<!--主要区域结束-->
<div id="footer">
    <p>[地址：合肥市高新区云飞路与文曲路交口创新产业园二期F4栋12层]</p>
    <p>版权所有&copy;合肥宏晶信息科技有限公司 </p>
</div>
</body>
</html>
