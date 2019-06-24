<%@page language="java" contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    request.setAttribute("base", request.getContextPath());
%>
<!DOCTYPE html >
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>宏晶信息－NetCTOSS</title>
    <link type="text/css" rel="stylesheet" media="all" href="${base}/styles/global.css"/>
    <link type="text/css" rel="stylesheet" media="all" href="${base}/styles/global_color.css"/>
    <script type="text/javascript" src="${base}/static/jquery-1.4.3.js"></script>
    <script language="javascript" type="text/javascript">
        var nameCheck = false;
        var idcardCheck = false;
        var loginNameCheck = false;
        var pwdCheck = false;
        var pwdagainCheck = false;
        var telCheck = false;

        //保存成功的提示信息
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

        //显示选填的信息项
        function showOptionalInfo(imgObj) {
            var div = document.getElementById("optionalInfo");
            if (div.className == "hide") {
                div.className = "show";
                imgObj.src = "${base}/images/hide.png";
            } else {
                div.className = "hide";
                imgObj.src = "${base}/images/show.png";
            }
        }

        function nameAjax(obj) {
            $.ajax({
                url: "/netctoss/name.adda",
                type: "post",
                data: "name=" + obj.value,
                dataType: "text",
                success: function (data) {
                    if (data == "*此选项不能为空！" || data == "*姓名格式错误!" || data == "*姓名已经存在，请更换") {
                        $("#nameTip").css("color", "red");
                        $("#nameTip").text(data);
                        nameCheck = false;
                    }
                    if (data == "✔") {
                        $("#nameTip").css("color", "green");
                        $("#nameTip").text(data);
                        nameCheck = true;
                    }
                }
            });
        }

        function idcardAjax(obj) {
            $.ajax({
                url: "/netctoss/idcard.adda",
                data: "idcard=" + obj.value,
                type: "post",
                dataType: "text",
                success: function (data) {
                    if (data == "*该身份证号已经被注册！" || data == "*身份证号格式错误！" || data == "*此选项不能为空！") {
                        $("#idcardTip").css("color", "red");
                        $("#idcardTip").text(data);
                        idcardCheck = false;
                    }
                    if (data == "✔") {
                        $("#idcardTip").css("color", "green");
                        $("#idcardTip").text(data);
                        idcardCheck = true;
                    }
                }
            });
        }

        function loginnameAjax(obj) {
            $.ajax({
                url: "/netctoss/loinname.adda",
                data: "loginname=" + obj.value,
                type: "post",
                dataType: "text",
                success: function (data) {
                    if (data == "*登录名格式错误！" || data == "*此选项不能为空！" || data == "*该登录名已经注册！") {
                        $("#loginnameTip").css("color", "red");
                        $("#loginnameTip").text(data);
                        loginNameCheck = false;
                    }
                    if (data == "✔") {
                        $("#loginnameTip").css("color", "green");
                        $("#loginnameTip").text(data);
                        loginNameCheck = true;
                    }
                }
            });
        }

        function pwdAjax(obj) {
            $.ajax({
                url: "/netctoss/pwd.adda",
                data: "pwd=" + obj.value,
                type: "post",
                dataType: "text",
                success: function (data) {
                    if (data == "*密码格式错误！" || data == "*此选项不能为空！") {
                        $("#pwdTip").css("color", "red");
                        $("#pwdTip").text(data);
                        pwdCheck = false;
                    }
                    if (data == "✔") {
                        $("#pwdTip").css("color", "green");
                        $("#pwdTip").text(data);
                        pwdCheck = true;
                    }
                }
            });
        }

        function pwdagainAjax(obj) {
            $.ajax({
                url: "/netctoss/pwdaggain.adda",
                data: "pwdTwice=" + obj.value + "&pwd=" + $("#pwd").val(),
                type: "post",
                dataType: "text",
                success: function (data) {
                    if (data == "*两次密码不一致!" || data == "*此选项不能为空！") {
                        $("#pwdagainTip").css("color", "red");
                        $("#pwdagainTip").text(data);
                        pwdagainCheck = false;
                    }
                    if (data == "✔") {
                        $("#pwdagainTip").css("color", "green");
                        $("#pwdagainTip").text(data);
                        pwdagainCheck = true;
                    }
                }
            });
        }

        function telAjax(obj) {
            $.ajax({
                url: "/netctoss/tel.adda",
                data: "tel=" + obj.value,
                type: "post",
                dataType: "text",
                success: function (data) {
                    if (data == "*此选项不能为空！" || data == "*手机号格式错误!") {
                        $("#tel").css("color", "red");
                        $("#tel").text(data);
                        telCheck = false;
                    }
                    if (data == "✔") {
                        $("#tel").css("color", "green");
                        $("#tel").text(data);
                        telCheck = true;
                    }
                }
            });
        }

        function checkSubmit() {
            if (nameCheck == false) {
                alert("请检查姓名！");
                return false;
            }
            if (idcardCheck == false) {
                alert("请检查身份证号填写!");
                return false;
            }
            if (loginNameCheck == false) {
                alert("请检查登录名!");
                return false;
            }
            if (pwdCheck == false) {
                alert("请检查密码模块！");
                return false;
            }
            if (pwdagainCheck == false) {
                alert("请检查密码模块！");
                return false;
            }
            if (telCheck == false) {
                alert("请检查电话号码！");
                return false;
            }
            confirm("你确定要添加账务信息？");
            return true;
        }

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
        <%--使用include指令引入导航栏--%>
        <%@include file="../nav.jsp" %>
    </ul>
</div>
<!--导航区域结束-->
<!--主要区域开始-->
<div id="main">
    <!--保存成功或者失败的提示消息-->
    <%--<div id="save_result_info" class="save_fail">保存失败，该身份证已经开通过账务账号！</div>--%>
    <form action="http://localhost:8080/netctoss/sure/add.acc?status=0" method="post" class="main_form" onsubmit="return checkSubmit();">
        <!--必填项-->
        <div class="text_info clearfix"><span>姓名：</span></div>
        <div class="input_info">
            <input id="nameF" type="text" placeholder="20长度以内" value="" onblur="nameAjax(this)" name="real_name"/>
            <span id="nameTip" class="required">*</span>
            <%--<div class="validate_msg_long">20长度以内的汉字、字母和数字的组合</div>--%>
        </div>
        <div class="text_info clearfix"><span>身份证：</span></div>
        <div class="input_info">
            <input id="idcardF" type="text" value="" placeholder="正确的身份证号码格式" onblur="idcardAjax(this)" name="idcard_no"/>
            <span class="required" id="idcardTip">*</span>
            <%--<div class="validate_msg_long">正确的身份证号码格式</div>--%>
        </div>
        <div class="text_info clearfix"><span>登录账号：</span></div>
        <div class="input_info">
            <input id="loginnameF" type="text" placeholder="15长度以内" value="" onblur="loginnameAjax(this)" name="login_name"/>
            <span class="required" id="loginnameTip">*</span>
            <%--<div class="validate_msg_long">30长度以内的字母、数字和下划线的组合</div>--%>
        </div>
        <div class="text_info clearfix"><span>密码：</span></div>
        <div class="input_info">
            <input type="password" id="pwd" placeholder="请输入六位数字密码" value="" onblur="pwdAjax(this)"/>
            <span class="required" id="pwdTip">*</span>
            <%--<div class="validate_msg_long">30长度以内的字母、数字和下划线的组合</div>--%>
        </div>
        <div class="text_info clearfix"><span>重复密码：</span></div>
        <div class="input_info">
            <input type="password" id="pwdagain" placeholder="两次密码必须相同" value="" onblur="pwdagainAjax(this);" name="login_passwd"/>
            <span class="required" id="pwdagainTip">*</span>
            <%--<div class="validate_msg_long">两次密码必须相同</div>--%>
        </div>
        <div class="text_info clearfix"><span>电话：</span></div>
        <div class="input_info">
            <input type="text" class="width200" placeholder="正确的手机号格式" onblur="telAjax(this)" name="telephone"/>
            <span class="required" id="tel">*</span>
            <%--<div class="validate_msg_medium">正确的电话号码格式：手机或固话</div>--%>
        </div>
        <!--可选项-->
        <div class="text_info clearfix"><span>可选项：</span></div>
        <div class="input_info">
            <img src="${base}/images/show.png" alt="展开" onclick="showOptionalInfo(this);"/>
        </div>
        <div id="optionalInfo" class="hide">
            <%--<div class="text_info clearfix"><span>推荐人身份证号码：</span></div>--%>
            <%--<div class="input_info">--%>
            <%--<input type="text" onblur=""/>--%>
            <%--&lt;%&ndash;<div class="validate_msg_long">正确的身份证号码格式</div>&ndash;%&gt;--%>
            <%--</div>--%>
            <div class="text_info clearfix"><span>生日：</span></div>
            <div class="input_info">
                <input type="text" value="" id="bir" name="birthdate"/>
                <span class="required" style="color: #3168ff">eg：1997-12-11</span>
            </div>
            <div class="text_info clearfix"><span>Email：</span></div>
            <div class="input_info">
                <input type="text" class="width350" name="email" value=""/>
                <span class="required" style="color: #3168ff">eg：xlyuperson@163.com</span>
                <%--<div class="validate_msg_tiny">50长度以内，合法的 Email 格式</div>--%>
            </div>
            <div class="text_info clearfix"><span>职业：</span></div>
            <div class="input_info">
                <select name="occupation">
                    <option value="">-请选择-</option>
                    <option value="干部">干部</option>
                    <option value="学生">学生</option>
                    <option value="技术人员">技术人员</option>
                    <option value="其他">其他</option>
                </select>
            </div>
            <div class="text_info clearfix"><span>性别：</span></div>
            <div class="input_info fee_type">
                <input type="radio" name="radSex" checked="checked" id="female" value="f"/>
                <label for="female">女</label>
                <input type="radio" name="radSex" id="male" value="m"/>
                <label for="male">男</label>
            </div>
            <div class="text_info clearfix"><span>通信地址：</span></div>
            <div class="input_info">
                <input type="text" class="width350" name="mailaddress" value=""/>
                <%--<div class="validate_msg_tiny">50长度以内</div>--%>
            </div>
            <div class="text_info clearfix"><span>邮编：</span></div>
            <div class="input_info">
                <input type="text" value="" name="zipcode"/>
                <%--<div class="validate_msg_long">6位数字</div>--%>
            </div>
            <div class="text_info clearfix"><span>QQ：</span></div>
            <div class="input_info">
                <input type="text" name="qq" value=""/>
                <%--<div class="validate_msg_long">5到13位数字</div>--%>
            </div>
        </div>
        <!--操作按钮-->
        <div class="button_info clearfix">
            <input type="submit" value="保存" class="btn_save" />
            <input type="reset" value="取消" class="btn_save"/>
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
