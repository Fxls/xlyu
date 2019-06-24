<%@page language="java" contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    request.setAttribute("base", request.getContextPath());
%>
<!DOCTYPE>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>宏晶信息－NetCTOSS</title>
    <link type="text/css" rel="stylesheet" media="all" href="${base}/styles/global.css"/>
    <link type="text/css" rel="stylesheet" media="all" href="${base}/styles/global_color.css"/>
    <script type="text/javascript" src="${base}/static/jquery-1.4.3.js"></script>
    <script>
        $(function () {
            if ($("#recomm").val() == 0) {
                $("#recomm").val("");
            }
            var idcardNo = "${detailInfo.idcardNo}";
            var year=idcardNo.substring(6,10);
            var month = idcardNo.substring(10,12);
            var day = idcardNo.substring(12,14);
            var birthday = year+"/"+month+"/"+day;
            $("#birthday").val(birthday);
        });
    </script>
</head>
<body>
<!--Logo区域开始-->
<div id="header">
    <img src="${base}/images/logo.png" alt="logo" class="left"/>
    <a href="http://localhost:8080/netctoss/logout.log" >[退出]</a>
</div>
<!--Logo区域结束-->
<!--导航区域开始-->
<div id="navi">
    <ul id="menu">
        <%@include file="../nav.jsp" %>
        <%--<li><a href="../index.html" class="index_off"></a></li>--%>
        <%--<li><a href="../role/role_list.html" class="role_off"></a></li>--%>
        <%--<li><a href="../admin/admin_list.html" class="admin_off"></a></li>--%>
        <%--<li><a href="../fee/fee_list.html" class="fee_off"></a></li>--%>
        <%--<li><a href="../account/account_list.html" class="account_on"></a></li>--%>
        <%--<li><a href="../service/service_list.html" class="service_off"></a></li>--%>
        <%--<li><a href="../bill/bill_list.html" class="bill_off"></a></li>--%>
        <%--<li><a href="../report/report_list.html" class="report_off"></a></li>--%>
        <%--<li><a href="../user/user_info.html" class="information_off"></a></li>--%>
        <%--<li><a href="../user/user_modi_pwd.html" class="password_off"></a></li>--%>
    </ul>
</div>
<!--导航区域结束-->
<!--主要区域开始-->
<div id="main">
    <form action="" method="" class="main_form">
        <!--必填项-->
        <div class="text_info clearfix"><span>账务账号ID：</span></div>
        <div class="input_info"><input type="text" value="${detailInfo.id}" readonly class="readonly"/></div>
        <div class="text_info clearfix"><span>姓名：</span></div>
        <div class="input_info"><input type="text" value="${detailInfo.realName}" readonly class="readonly"/></div>
        <div class="text_info clearfix"><span>身份证：</span></div>
        <div class="input_info">
            <input type="text" value="${detailInfo.idcardNo}" readonly class="readonly"/>
        </div>
        <div class="text_info clearfix"><span>登录账号：</span></div>
        <div class="input_info">
            <input type="text" value="${detailInfo.loginName}" readonly class="readonly"/>
        </div>
        <div class="text_info clearfix"><span>电话：</span></div>
        <div class="input_info">
            <input type="text" class="width200 readonly" readonly value="${detailInfo.telephone}"/>
        </div>
        <div class="text_info clearfix"><span>推荐人账务账号ID：</span></div>
        <div class="input_info"><input id="recomm" type="text" readonly class="readonly" value="${detailInfo.recommenderId}"/></div>
        <%--TODO 需要进行二次查询，待做--%>
        <div class="text_info clearfix"><span>推荐人身份证号码：</span></div>
        <div class="input_info"><input type="text" readonly class="readonly" value=""/></div>
        <div class="text_info clearfix"><span>状态：</span></div>
        <div class="input_info">
            <select disabled>
                <c:if test="${detailInfo.status=='0'}">
                    <option>开通</option>
                </c:if>
                <c:if test="${detailInfo.status=='1'}">
                    <option>暂停</option>
                </c:if>
                <c:if test="${detailInfo.status=='2'}">
                    <option>删除</option>
                </c:if>
            </select>
        </div>
        <div class="text_info clearfix"><span>开通/暂停/删除时间：</span></div>
        <div class="input_info"><input type="text" readonly class="readonly" value="${detailInfo.createDate}"/></div>

        <div class="text_info clearfix"><span>上次登录时间：</span></div>
        <div class="input_info"><input type="text" readonly class="readonly" value="${detailInfo.lastLoginTime}"/></div>
        <div class="text_info clearfix"><span>上次登录IP：</span></div>
        <div class="input_info"><input type="text" readonly class="readonly" value="${detailInfo.lastLoginIp}"/></div>
        <!--可选项数据-->
        <div class="text_info clearfix"><span>生日：</span></div>
        <div class="input_info">
            <input id="birthday" type="text" readonly class="readonly" value=""/>
        </div>
        <div class="text_info clearfix"><span>Email：</span></div>
        <div class="input_info">
            <input type="text" class="width350 readonly" readonly value="${detailInfo.email}"/>
        </div>
        <div class="text_info clearfix"><span>职业：</span></div>
        <div class="input_info">
            <select disabled>
                <c:if test="${detailInfo.occupation=='干部'}">
                    <option>干部</option>
                </c:if>
                <c:if test="${detailInfo.occupation=='学生'}">
                    <option>学生</option>
                </c:if>
                <c:if test="${detailInfo.occupation=='技术人员'}">
                    <option>技术人员</option>
                </c:if>
                <c:if test="${detailInfo.occupation=='其他'}">
                    <option>其他</option>
                </c:if>
            </select>
        </div>
        <div class="text_info clearfix"><span>性别：</span></div>
        <div class="input_info fee_type">
            <c:if test="${detailInfo.gender=='f'}">
                <input type="radio" name="radSex" checked="checked" id="female" disabled/>
                <label for="female">女</label>
                <input type="radio" name="radSex" id="male" disabled/>
                <label for="male">男</label>
            </c:if>
            <c:if test="${detailInfo.gender=='m'}">
                <input type="radio" name="radSex"  id="female" disabled/>
                <label for="female">女</label>
                <input type="radio" name="radSex" checked="checked" id="male" disabled/>
                <label for="male">男</label>
            </c:if>

        </div>
        <div class="text_info clearfix"><span>通信地址：</span></div>
        <div class="input_info"><input type="text" class="width350 readonly" readonly value="${detailInfo.mailaddress}"/>
        </div>
        <div class="text_info clearfix"><span>邮编：</span></div>
        <div class="input_info"><input type="text" class="readonly" readonly value="${detailInfo.zipcode}"/></div>
        <div class="text_info clearfix"><span>QQ：</span></div>
        <div class="input_info"><input type="text" class="readonly" readonly value="${detailInfo.qq}"/></div>
        <!--操作按钮-->
        <div class="button_info clearfix">
            <input type="button" value="返回" class="btn_save"
                   onclick="location.href='http://localhost:8080/netctoss/list.acc';"/>
        </div>
    </form>
</div>
<!--主要区域结束-->
<div id="footer">
    <span>[地址：合肥市高新区云飞路与文曲路交口创新产业园二期F4栋12层]</span>
    <br/>
    <span>版权所有&copy;合肥宏晶信息科技有限公司 </span>
</div>
</body>
</html>
