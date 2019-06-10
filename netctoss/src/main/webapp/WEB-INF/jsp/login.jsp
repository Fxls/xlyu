<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/6/7
  Time: 21:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>登录页面</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/login.css">
    <script>
        function check() {

            var name = document.getElementById("nameId").value;
            var pwd = document.getElementById("pwdId").value;
            var nameReg = /[a-z]{2,7}/;
            var pwdReg = /[a-z]{2,7}/;
            if (!name || !pwd) {
                alert("请输入用户名或密码！");
                return false;
            }
            if (!nameReg.test(name)) {
                alert("请输入2~7为字母用户名！");//数据库已经设置了用户名不重复
                return false;
            }
            if (!pwdReg.test(pwd)) {
                alert("密码格式错误！");
                return false;
            }

            return true;
        }
    </script>
</head>
<body>

<span class="webName"><font face="MS Mincho"><strong>桜の花の落ちるスピード、秒速五センチメートル。<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;——篠原明里</strong></font></span>
<div style="position: absolute" class="main">
    <form action="<%=request.getContextPath()%>/check.log" method="post" onsubmit="return check();">
        <div class="head">
            <scan class="headName"><font face="MS Mincho"><strong>秒速五センチメートル</strong></font></scan>
        </div>
        <div class="username"><input class="userText" id="nameId" type="text" placeholder="支持QQ号/手机号/邮箱登录"
                                     name="username" value="<%=request.getAttribute("loginName")%>"/><span></span></div>
        <div class="pwd"><input class="pwdText" id="pwdId" type="password" placeholder="QQ密码" name="pwd"
                                value="<%=request.getAttribute("loginPwd")%>"/><span></span></div>
        <script>
            if (document.getElementById("nameId").value == "null") {
                document.getElementById("nameId").value = "";
                document.getElementById("pwdId").value = ""
            }
        </script>
        &nbsp;<input class="remember" type="text" name="cap" placeholder="验证码" id="cb"/><img
            style="position: absolute;margin-top: 5px;margin-left: 10px" src="<%=request.getContextPath()%>/cap"
            onclick="this.src='<%=request.getContextPath()%>/cap?d='+Math.random();"><span>${param.msg}</span><br/>
        <input class="submit" type="submit" value="登  录"/><br/>
    </form>
    <img src="<%=request.getContextPath()%>/static/扫码登录.png" class="QR"/>&nbsp;<span
        class="tip2"><strong>扫码快捷登录</strong></span><br/>
    <a class="forgetA"
       href="https://aq.qq.com/v2/uv_aq/html/reset_pwd/pc_reset_pwd_input_account.html?v=3.0&old_ver_account="
       target="_blank"><span class="forget"><strong>忘记密码？</strong></span></a>
</div>
<span style="position: absolute;border:  1px solid black;z-index: auto;margin-top: 500px">1111</span>
<span class="message"><font face="MS Mincho"><strong>「ねえ、知っていますか？桜の花の落ちるスピードは秒速五センチメートルだそうです。秒速5センチメートル、あれは桜の花の落ちるスピードで、どのようなスピードで私とあなたの間の距離を歩くことができますか？</strong></font></span>
<span class="foot"><font face="微软雅黑">&copy;2019 xlyu.All Rights Reserved.</font></span>

<canvas id="myCanvas" style="position: absolute;z-index: -1">
</canvas>
<script src="<%=request.getContextPath()%>/static/move.js"></script>

</body>
</html>