<%@page language="java" contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    request.setAttribute("base", request.getContextPath());
%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>宏晶信息－NetCTOSS</title>
    <link type="text/css" rel="stylesheet" media="all" href="${base}/styles/global.css"/>
    <link type="text/css" rel="stylesheet" media="all" href="${base}/styles/global_color.css"/>
    <script type="text/javascript" src="${base}/static/jquery-1.4.3.js"></script>
    <script language="javascript" type="text/javascript">
        var namecheck = true;
        var oldpwdcheck = true;
        var newpwdcheck = true;
        var newpwdagaincheck = true;
        var telcheck = true;
        var message = "请检查您的表单后再提交！";
        $(function () {
            // var isSubmitState = true;
            var idcardNo = "${modi.idcardNo}";
            var year = idcardNo.substring(6, 10);
            var month = idcardNo.substring(10, 12);
            var day = idcardNo.substring(12, 14);
            var bir = year + "/" + month + "/" + day;
            $("#birthdayId").val(bir);
        });

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

        //显示修改密码的信息项
        function showPwd(chkObj) {
            if (chkObj.checked)
                document.getElementById("divPwds").style.display = "block";
            else
                document.getElementById("divPwds").style.display = "none";
        }

        function realNameAjax(obj) {
            $.ajax({
                url: "/netctoss/modiname.ajax",
                type: "post",
                data: "realName=" + obj.value,
                dataType: "text",
                success: function (data) {
                    if (data == "*请输入内容" || data == "*请保证输入长度在18以内") {
                        $("#realnameTip").css("color", "red");
                        $("#realnameTip").text(data);
                        namecheck = false;
                    }
                    if (data == "✔") {
                        $("#realnameTip").css("color", "green");
                        $("#realnameTip").text(data);
                        namecheck = true;
                    }
                }
            });
        }

        function oldpwdAjax(obj) {
            $.ajax({
                url: "/netctoss/modiOldpwd.ajax",
                type: "post",
                data: "oldpwd=" + obj.value + "&id=" + "${modi.id}",
                dataType: "text",
                success: function (data) {
                    if (data == "*请输入您的旧密码" || data == "*你输入的旧密码错误，请重新输入") {
                        $("#oldPwd").css("color", "red");
                        $("#oldPwd").text(data);
                        oldpwdcheck = false;
                    }
                    if (data == "✔") {
                        $("#oldPwd").css("color", "green");
                        $("#oldPwd").text(data);
                        oldpwdcheck = true;
                    }
                }
            });
        }

        function newpwdAjax(obj) {
            $.ajax({
                url: "/netctoss/modiNewPwd.ajax",
                type: "post",
                data: "newpwd=" + obj.value,
                dataType: "text",
                success: function (data) {
                    if (data == "*请输入您要设置的新密码" || data == "*请输入六个字符以内的新密码") {
                        $("#newPwd").css("color", "red");
                        $("#newPwd").text(data);
                        newpwdcheck = false;
                    }
                    if (data == "✔新密码可用") {
                        $("#newPwd").css("color", "green");
                        $("#newPwd").text(data);
                        newpwdcheck = true;
                    }
                }
            });
        }

        function newpwdAgain(obj) {
            $.ajax({
                url: "/netctoss/modipwdAgain.ajax",
                type: "post",
                data: "pwdagain=" + obj.value + "&firstpwd=" + $("#firstNew").val(),
                dataType: "text",
                success: function (data) {
                    if (data == "*请输入" || data == "*两次输入必须一样") {
                        $("#pwdAgain").css("color", "red");
                        $("#pwdAgain").text(data);
                        newpwdagaincheck = false;
                    }
                    if (data == "✔") {
                        $("#pwdAgain").css("color", "green");
                        $("#pwdAgain").text(data);
                        newpwdagaincheck = true;
                    }
                }
            });
        }

        function telephoneAjax(obj) {
            $.ajax({
                url: "/netctoss/modiTelephoneAjax.ajax",
                type: "post",
                data: "telephone=" + obj.value,
                dataType: "text",
                success: function (data) {
                    if (data == "*请输入正确的手机号格式") {
                        $("#tele").css("color", "red");
                        $("#tele").text(data);
                        telcheck = false;
                    }
                    if (data == "✔") {
                        $("#tele").css("color", "green");
                        $("#tele").text(data);
                        telcheck = true;
                    }
                }
            });
        }

        function idcardOfRe() {
            $.ajax({
                url: "/netctoss/idcardOfOther.ajax",
                type: "post",
                data: "id=" + "${modi.id}",
                dataType: "text",
                success: function (data) {

                    $("#idRe").val(data);
                }
            });
        }

        function emailAjax(obj) {
            $.ajax({
                url: "/netctoss/emailAjax.ajax",
                type: "post",
                data: "email=" + obj.value,
                dataType: "text",
                success: function (data) {
                    $("#email").css("color", "green");
                    if (data == "*请输入正确格式的邮箱地址") {
                        $("#email").css("color", "red");
                        $("#email").text(data);
                    }
                    if (data == "✔" || data == "") {
                        $("#email").css("color", "green");
                        $("#email").text(data);
                    }
                }
            });
        }

        function zipcodeAjax(obj) {
            $.ajax({
                url: "/netctoss/zipAjax.ajax",
                type: "post",
                data: "zip=" + obj.value,
                dataType: "text",
                success: function (data) {
                    $("#qq").css("color", "green");
                    if (data == "*请输入正确格式的邮编") {
                        $("#zip").css("color", "red");
                        $("#zip").text(data);
                    }
                    if (data == "✔" || data == "") {
                        $("#zip").css("color", "green");
                        $("#zip").text(data);
                    }
                }
            });

        }

        function qqAjax(obj) {
            $.ajax({
                url: "/netctoss/qqAjax.ajax",
                type: "post",
                data: "qq=" + obj.value,
                dataType: "text",
                success: function (data) {
                    $("#qq").css("color", "green");
                    if (data == "*请输入正确格式的qq号") {
                        $("#qq").css("color", "red");
                        $("#qq").text(data);
                    }
                    if (data == "✔" || data == "") {
                        $("#qq").css("color", "green");
                        $("#qq").text(data);
                    }
                }
            });
        }

        $(function () {
            checkData();
        });

        function checkData() {
            if (namecheck == false) {
                alert(message);
                return false;
            }
            if (oldpwdcheck == false) {
                alert(message);
                return false;
            }
            if (newpwdcheck == false) {
                alert(message);
                return false;
            }
            if (newpwdagaincheck == false) {
                alert(message);
                return false;
            }
            if (telcheck == false) {
                alert(message);
                return false;
            }

            return true;
        }
    </script>
</head>
<body onload="idcardOfRe()">
<!--Logo区域开始-->
<div id="header">
    <img src="${base}/images/logo.png" alt="logo" class="left"/>
    <a href="http://192.168.0.84:8003/netctoss/logout.log" >[退出]</a>
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
    <div id="save_result_info" class="save_fail">保存失败，旧密码错误！</div>
    <form action="http://192.168.0.84:8003/netctoss/sure/update.acc?id=${modi.id}" method="post" class="main_form" onsubmit="return checkData()">
        <!--必填项-->
        <div class="text_info clearfix"><span>账务账号ID：</span></div>
        <div class="input_info">
            <input type="text" value="${modi.id}" readonly class="readonly"/>
        </div>
        <div class="text_info clearfix"><span>姓名：</span></div>
        <div class="input_info">
            <input name="rname" id="idText" type="text" value="${modi.realName}" onblur="realNameAjax(this)"/>
            <span id="realnameTip" class="required">*</span>
            <%--<div class="validate_msg_long error_msg">20长度以内的汉字、字母和数字的组合</div>--%>
        </div>
        <div class="text_info clearfix"><span>身份证：</span></div>
        <div class="input_info">
            <input type="text" value="${modi.idcardNo}" readonly class="readonly"/>
        </div>
        <div class="text_info clearfix"><span>登录账号：</span></div>
        <div class="input_info">
            <input type="text" value="${modi.loginName}" readonly class="readonly"/>
            <!--
            <div class="change_pwd">
                <input id="chkModiPwd" type="checkbox" onclick="showPwd(this);" />
                <label for="chkModiPwd">修改密码</label>
            </div>
            -->
        </div>

        <div id="">
            <div class="text_info clearfix"><span>旧密码：</span></div>
            <div class="input_info">
                <input type="password" value="" onblur="oldpwdAjax(this);" id="oldPWD"/>
                <span class="required" id="oldPwd">*</span>
                <%--<div class="validate_msg_long">30长度以内的字母、数字和下划线的组合</div>--%>
            </div>
            <div class="text_info clearfix"><span>新密码：</span></div>
            <div class="input_info">
                <input id="firstNew" type="password" onblur="newpwdAjax(this)" value=""/>
                <span class="required" id="newPwd">*</span>
                <%--<div class="validate_msg_long"></div>--%>
            </div>
            <div class="text_info clearfix"><span>重复新密码：</span></div>
            <div class="input_info">
                <input type="password" name="newPasswd" value="" onblur="newpwdAgain(this)" id="again"/>
                <span class="required" id="pwdAgain">*</span>
                <%--<div class="validate_msg_long">两次密码必须相同</div>--%>
            </div>
        </div>

        <div class="text_info clearfix"><span>电话：</span></div>
        <div class="input_info">
            <input name="telno" type="text" onblur="telephoneAjax(this)" class="width200" value="${modi.telephone}" id="tel"/>
            <span class="required" id="tele">*</span>
            <%--<div class="validate_msg_medium error_msg">正确的电话号码格式：手机或固话</div>--%>
        </div>
        <%--TODO 推荐人身份证号码获取--%>
        <div class="text_info clearfix"><span>推荐人身份证号码：</span></div>
        <div class="input_info">
            <input type="text" id="idRe" class="readonly" value="" readonly/>
            <%--<div class="validate_msg_long error_msgs">正确的身份证号码格式</div>--%>
        </div>
        <div class="text_info clearfix"><span>生日：</span></div>
        <div class="input_info">
            <input id="birthdayId" type="text" value="" readonly class="readonly"/>
        </div>
        <div class="text_info clearfix"><span>Email：</span></div>
        <div class="input_info">
            <input type="text" name="em" class="width200" value="${modi.email}" onblur="emailAjax(this)"/>
            <span class="required" id="email"></span>
            <%--<div class="validate_msg_medium">50长度以内，合法的 Email 格式</div>--%>
        </div>
        <div class="text_info clearfix"><span>职业：</span></div>
        <div class="input_info">
            <select name="occupation">
                <c:if test="${modi.occupation=='干部'}">
                    <option selected value="干部">干部</option>
                    <option value="学生">学生</option>
                    <option value="技术人员">技术人员</option>
                    <option value="其他">其他</option>
                </c:if>
                <c:if test="${modi.occupation=='学生'}">
                    <option value="干部">干部</option>
                    <option selected value="学生">学生</option>
                    <option value="技术人员">技术人员</option>
                    <option value="其他">其他</option>
                </c:if>
                <c:if test="${modi.occupation=='技术人员'}">
                    <option value="干部">干部</option>
                    <option value="学生">学生</option>
                    <option selected value="技术人员">技术人员</option>
                    <option value="其他">其他</option>
                </c:if>
                <c:if test="${modi.occupation=='其他'}">
                    <option value="干部">干部</option>
                    <option value="学生">学生</option>
                    <option value="技术人员">技术人员</option>
                    <option  value="其他" selected>其他</option>
                </c:if>
            </select>
        </div>
        <div class="text_info clearfix"><span>性别：</span></div>
        <div class="input_info fee_type">
            <c:if test="${modi.gender=='f'}">
                <input type="radio" name="radSex" value="f" checked="checked" id="female" onclick="feeTypeChange(1);"/>
                <label for="female">女</label>
                <input type="radio" name="radSex" value="m" id="male" onclick="feeTypeChange(2);"/>
                <label for="male">男</label>
            </c:if>
            <c:if test="${modi.gender=='m'}">
                <input type="radio" name="radSex" value="f" id="female" onclick="feeTypeChange(1);"/>
                <label for="female">女</label>
                <input type="radio" name="radSex" value="m" checked="checked" id="male" onclick="feeTypeChange(2);"/>
                <label for="male">男</label>
            </c:if>

        </div>
        <div class="text_info clearfix"><span>通信地址：</span></div>
        <div class="input_info">
            <input type="text" class="width350" name="adr" value="${modi.mailaddress}"/>

            <%--<div class="validate_msg_tiny" ></div>--%>
        </div>
        <div class="text_info clearfix"><span>邮编：</span></div>
        <div class="input_info">
            <input type="text" name="zi" value="${modi.zipcode}" onblur="zipcodeAjax(this)"/>
            <span class="required" id="zip"></span>
        </div>
        <div class="text_info clearfix"><span>QQ：</span></div>
        <div class="input_info">
            <input type="text" name="tencqq" value="${modi.qq}" onblur="qqAjax(this)"/>
            <span class="required" id="qq"></span>
        </div>
        <!--操作按钮-->
        <div class="button_info clearfix">
            <input type="submit" value="保存" class="btn_save"/>
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
