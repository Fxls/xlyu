<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/30
  Time: 15:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>登录页面</title>
    <style>
        #myCanvas {
            background-image: url("背景2.png");
            pointer-events: none;
        }
    </style>
    <link rel="stylesheet" type="text/css" href="login.css">
    <script  src="jquery-1.4.3.js"></script>
</head>
<body>

<span class="webName"><font face="MS Mincho" ><strong>桜の花の落ちるスピード、秒速五センチメートル。<br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;——篠原明里</strong></font></span>
<div style="position: absolute" class="main">
    <form>
        <div class="head">
            <scan class="headName"><font face="MS Mincho"><strong>秒速五センチメートル</strong></font></scan>
        </div>
        <div  class="username"><input class="userText" type="text" placeholder="支持QQ号/手机号/邮箱登录" name="loginInfo"/></div>
        <div class="pwd"><input class="pwdText" type="password" placeholder="QQ密码" name="loginInfo"/></div>
        &nbsp;<input class="remember" type="checkbox" name="loginInfo" title="为了确保你的信息安全，请不要在网吧等公共场所勾选此选项" id="cb"/><label
            for="cb"><span class="tip"
                           title="为了确保你的信息安全，请不要在网吧等公共场所勾选此选项"><strong>&nbsp;&nbsp;下次自动登录</strong></span></label><br/>
        <input class="submit" type="submit" value="登  录"/><br/>
    </form>
    <img src="扫码登录.png" class="QR"/>&nbsp;<span class="tip2"><strong>扫码快捷登录</strong></span><br/>
    <a class="forgetA"
       href="https://aq.qq.com/v2/uv_aq/html/reset_pwd/pc_reset_pwd_input_account.html?v=3.0&old_ver_account="
       target="_blank"><span class="forget"><strong>忘记密码？</strong></span></a>
</div>
<span class="message"><font face="MS Mincho"><strong>「ねえ、知っていますか？桜の花の落ちるスピードは秒速五センチメートルだそうです。秒速5センチメートル、あれは桜の花の落ちるスピードで、どのようなスピードで私とあなたの間の距離を歩くことができますか？</strong></font></span>
<span class="foot"><font face="微软雅黑">&copy;2019 xlyu.All Rights Reserved.</font></span>
<select class="menuName">
    <option selected>花里胡哨版</option>
    <a href="login-clear.html" target="_self"><option>简约版</option></a>
</select>

<canvas id="myCanvas" style="position: absolute;z-index: -1">
</canvas>
<script>
    //获取myCanvas
    var can = document.getElementById("myCanvas");

    //返回canvas 的上下文，如果上下文没有定义则返回null
    //2d",建立一个 CanvasRenderingContext2D 二维渲染上下文
    var ctx = can.getContext("2d");


    //画布宽度,高度
    var wid = window.innerWidth;
    var hei = window.innerHeight;
    can.width = wid;
    can.height = hei;
    //雪花数目

    var snow = 50;

    //雪花坐标、半径
    var arr = []; //保存各圆坐标及半径
    for (var i = 0; i < snow; i++) {

        //push() 方法可向数组的末尾添加一个或多个元素，并返回新的长度。
        arr.push({

            x: Math.random() * wid,//横坐标

            y: Math.random() * hei,//纵坐标

            r: Math.random() * 10 + 1

        })

    }

    //画雪花

    function DrawSnow() {

        //clearRect：在给定矩形内清空一个矩形：
        /**
         * x-要清除的矩形左上角的x坐标
         * y-要清除的矩形左上角的y坐标
         * width：要清除的矩形的宽度，以像素计
         * height：要清除的矩形的高度，以像素计
         */
        ctx.clearRect(0, 0, wid, hei);

        //填充
        ctx.fillStyle = "white";

        //beginPath()方法开始一条路径，或重置当前的路径
        ctx.beginPath();

        for (var i = 0; i < snow; i++) {

            var p = arr[i];

            //moveTo：
            /**
             * x:目标位置x坐标
             * y：目标位置y坐标
             */
            ctx.moveTo(p.x, p.y);

            //画圆：
            /**
             * x        ---     圆心x坐标
             * y        ---     圆心y坐标
             * r        ---     圆的半径
             * sAngle   ---     起始角，以弧度计。（弧的圆心的三点钟位置是0度）。
             * eAngle   --- 	结束角，以弧度计。
             * counterclockwise ---- false:顺时针，逆时针
             */
            ctx.arc(p.x, p.y, p.r, 0, 2 * Math.PI, false);

        }

        //fill() 方法填充当前的图像（路径）。默认颜色是黑色。
        ctx.fill();

        SnowFall();

        ctx.closePath();

    }

    //雪花飘落

    function SnowFall() {

        for (var i = 0; i < snow; i++) {

            var p = arr[i];

            p.y += Math.random() * 2 + 1;

            if (p.y > hei) {

                p.y = 0;

            }

            p.x += Math.random() * 2 + 1;

            if (p.x > wid) {

                p.x = 0;

            }

        }

    }

    setInterval(DrawSnow, 50);
</script>

</body>
</html>