<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/5/30
  Time: 14:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>页面丢失</title>
    <%--<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>styles/error404.jsp">--%>
    <style>
        body {
            background-color: #ff90b3;
            margin: 0;
            padding: 0;
        }

        .text {
            margin: 250px 300px;
            text-align: center;
            display: inline-block;
            transition: 2s;
        }

        .text span {
            background-color: #fff;
            width: 120px;
            height: 120px;
            display: block;
            line-height: 120px;
            font-family: "方正兰亭超细黑简体";
            font-weight: bold;
            color: #a0a0a0;
            font-size: 40px;
            float: left;
            transition: 2s;
        }

        .text span:nth-child(1) {
            border-top-left-radius: 3px;
            border-bottom-left-radius: 3px;
        }

        .text span:nth-child(1) {
            border-top-right-radius: 3px;
            border-bottom-right-radius: 3px;
        }

        .text:hover span:nth-child(odd) {
            transform: skewY(-15deg);
            color: #b5b5b5;
            box-shadow: 0 60px 20px rgba(0, 0, 0, .1);
        }

        .text:hover span:nth-child(even) {
            transform: skewY(15deg);
            box-shadow: 0 60px 20px rgba(0, 0, 0, .1), inset 0px 0 30px rgba(0, 0, 0, .2);
            color: #b5b5b5;
        }

        .text:hover {
            transform: rotateX(35deg);
        }


    </style>
    <script>
        function toLogin() {
            //TODO history返回上级页面
            history.back();
        }
    </script>
</head>
<body>
<div class="text" onclick=" toLogin();">
    <span>找</span>
    <span>不</span>
    <span>到</span>
    <span>指</span>
    <span>定</span>
    <span>界</span>
    <span>面</span>
    <div style="clear: both;"></div>
</div>

</body>
</html>
