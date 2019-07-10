    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
            <%request.setAttribute("base", request.getContextPath());%>
        <html>
        <head>
        <title>用户添加</title>
        <style>
        .fieldsetClass {
        margin-bottom: 20px;
        }

        .prompt {
        color: red;
        background-color: #5dffdf;
        }
        .parentMenuClass{
            margin-left: 5px;
            margin-top: 10px;
            margin-bottom: 10px;
        width: 100px;
        height: 50px;
        background-color: #04a2ff;
        outline: 0px;
        border: none;
        box-shadow: 3px 2px 2px #0f15ff;
        border-radius: 50px;
        }
        </style>
        <script src="${base}/static/jquery-1.4.3.js"> </script>
        <script>
        function hidden() {
        setTimeout(function () {
        document.getElementById("hidden").hidden=true;
        },3000)
        }
        </script>
        </head>
        <body onload="hidden();">
        <div style="margin-left: 400px">
        <%--放置顶部菜单--%>
        <c:forEach items="${topMenus}" var="list">
            <%--<img  src="${base}/static/${list.menuIcon}1.png" alt="${list.menuName}"/>--%>
            <button class="parentMenuClass" onclick="location.href='${base}/${list.menuLink}?parentId=${list.id}'">${list.menuName}</button>
        </c:forEach>
        </div>

        <div id="hidden" class="prompt">
        ${msg}
        </div>


        <div>
        <fieldset style="margin-left: 400px;margin-right: 500px;">
        <legend>新增用户</legend>
        <form action="${base}/menu/add" method="post">
        <input class="fieldsetClass" type="text" name="menuName" placeholder="菜单名"><br>
        <input class="fieldsetClass" type="text" name="menuIcon" placeholder="菜单图标"><br>
        <input class="fieldsetClass" type="text" name="menuLink" placeholder="跳转地址"><br>
        <input class="fieldsetClass" type="text" name="parentId" placeholder="父级菜单id"><br>
        <select class="fieldsetClass" name="status">
        <option value="1">正常</option>
        <option value="0">禁用</option>
        </select><br>
        <input type="submit" value="提交">
        </form>
        </fieldset>
        </div>
        </body>
        </html>
