<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/6/13
  Time: 18:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>城市下拉选级联菜单</title>
    <script type="text/javascript" src="<%=request.getContextPath()%>/jquery-1.4.3.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath()%>/json.js"></script>
    <script>
        //ajax对象获取（兼容）
        function getXhr() {
            var xhr = null;
            if (window.XMLHttpRequest) {
                xhr = new XMLHttpRequest();
            } else {
                xhr = new ActiveXObject('Microsoft.XMLHttp');
            }
            return xhr;
        }

        //获取省份
        function getProvince() {

            var ajax = getXhr();
            //监听事件
            ajax.onreadystatechange = function () {
                if (ajax.readyState == 4 && ajax.status == 200) {
                    //接收省份列表
                    var get = ajax.responseText;
                    // 使用项目依赖的json.js，其中的parseJSON方法,可以将json字符串转化成js对象
                    var province = get.parseJSON();

                    for (var i = 0; i < province.length; i++) {
                        $("#province").append('<option value="' + province[i].code + '">' + province[i].name + '</option>');
                    }
                }
            };
            //异步
            ajax.open('get', '/ajax/pro.city', true);
            //发送
            ajax.send();
        }

        function getCity() {
            //获取选中省对应的code
            var code = $("#province").find("option:selected").val();
            // console.log(code);
            $("#opheadC").nextAll().remove();
            $("#opheadA").nextAll().remove();
            var ajax = getXhr();
            ajax.onreadystatechange = function () {
                if (ajax.readyState == 4 && ajax.status == 200) {
                    var get = ajax.responseText;
                    var city = get.parseJSON();
                    for (var i = 0; i < city.length; i++) {
                        $("#city").append('<option  value="' + city[i].code + '">' + city[i].name + '</option>');
                    }
                }
            };
            //使用get方式传递参数
            ajax.open('get', '/ajax/city.city?code=' + code);
            //不发送数据，常用于get方式
            ajax.send(null);
        }

        function getArea() {
            //获取选中市对应的code
            var code2 = $("#city").find("option:selected").val();
            console.log(code2);
            $("#opheadA").nextAll().remove();
            var ajax = getXhr();
            ajax.onreadystatechange = function () {
                if (ajax.readyState == 4 && ajax.status == 200) {
                    var get = ajax.responseText;
                    var area = get.parseJSON();
                    for (var i = 0; i < area.length; i++) {
                        $("#area").append('<option  value="' + area[i].code + '">' + area[i].name + '</option>');
                    }
                }
            };
            //使用get方式传递参数
            ajax.open('get', '/ajax/area.city?code2=' + code2);
            //不发送数据，常用于get方式
            ajax.send(null);
        }

        //回调事件处理函数
        // function fn() {
        //     //数据接收成功&&请求成功
        //     if (xhr.readyState == 4 && xhr.status == 200) {
        //         //服务器返回的文本
        //         var txt = xhr.responseText;
        //     }
        // }
        //创建get/post请求
        <%--xhr.open('get','<%=request.getContextPath()%>/city?name=',true);--%>
        <%--xhr.open('post','<%=request.getContextPath()%>/city',true);--%>
        <%--xhr.setRequestHeader('content-type','application/x-www-form-urlencoded');--%>
        // xhr.send(null);
        // xhr.send(name=value);
    </script>
</head>
<body onload="getProvince()">
<label>省份</label>
<select id="province" onchange="getCity()">
    <option value="-1">--请选择--</option>
</select>
<label>城市</label>
<select id="city" onchange="getArea();">
    <option id="opheadC" value="-1">--请选择--</option>
</select>
<label>乡镇</label>
<select id="area">
    <option id="opheadA" value="-1">--请选择--</option>
</select>
</body>
</html>
