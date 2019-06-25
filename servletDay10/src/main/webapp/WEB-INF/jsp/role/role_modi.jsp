<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/6/4
  Time: 16:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>宏晶信息－NetCTOSS</title>
    <link type="text/css" rel="stylesheet" media="all" href="<%=request.getContextPath()%>/WEB-INF/jsp/styles/global.css" />
    <link type="text/css" rel="stylesheet" media="all" href="<%=request.getContextPath()%>/WEB-INF/jsp/styles/global_color.css" />
    <script language="javascript" type="text/javascript">
        //保存成功的提示消息
        function showResult() {
            showResultDiv(true);
            window.setTimeout("showResultDiv(false);", 3000);
        }
        function showResultDiv(flag) {
            var divResult = document.getElementById("save_result_info");
            if (flag)
                divResult.style.display = "block";
            else
                divResult.style.display = "none";
        }
    </script>
</head>
<body>
<!--Logo区域开始-->
<div id="header">
    <img src="<%=request.getContextPath()%>/WEB-INF/jsp/images/logo.png" alt="logo" class="left"/>
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
    <!--保存操作后的提示信息：成功或者失败-->
    <div id="save_result_info" class="save_success">保存成功！</div>
    <form action="" method="" class="main_form">
        <div class="text_info clearfix"><span>角色名称：</span></div>
        <div class="input_info">
            <input type="text" class="width200" value="超级管理员" />
            <span class="required">*</span>
            <div class="validate_msg_medium error_msg">不能为空，且为20长度的字母、数字和汉字的组合</div>
        </div>
        <div class="text_info clearfix"><span>设置权限：</span></div>
        <div class="input_info_high">
            <div class="input_info_scroll">
                <ul>
                    <li><input type="checkbox" checked />管理员管理</li>
                    <li><input type="checkbox" checked />角色管理</li>
                    <li><input type="checkbox" checked />资费管理</li>
                    <li><input type="checkbox" checked />账务账号</li>
                    <li><input type="checkbox" checked />业务账号</li>
                    <li><input type="checkbox" checked />账单</li>
                    <li><input type="checkbox" checked />报表</li>
                </ul>
            </div>
            <span class="required">*</span>
            <div class="validate_msg_tiny">至少选择一个权限</div>
        </div>
        <div class="button_info clearfix">
            <input type="button" value="保存" class="btn_save" onclick="showResult();" />
            <input type="button" value="取消" class="btn_save" />
        </div>
    </form>
</div>
<!--主要区域结束-->
<div id="footer">
    <span>[地址：合肥市高新区云飞路与文曲路交口创新产业园二期F4栋12层]</span>
    <br />
    <span>版权所有&copy;合肥宏晶信息科技有限公司 </span>
</div>
</body>
</html>
