<%@page language="java" contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    request.setAttribute("base", request.getContextPath());
%>
<!DOCTYPE html >
<html>
<head>
    <title>宏晶信息－NetCTOSS</title>
    <link type="text/css" rel="stylesheet" media="all" href="${base}/styles/global.css"/>
    <link type="text/css" rel="stylesheet" media="all" href="${base}/styles/global_color.css"/>
    <script src="${base}/static/jquery-1.4.3.js"></script>
    <script language="javascript" type="text/javascript">

        $(function () {
            var status = '${param.status}';
            $.ajax({
                url: "/netctoss/get/state.acc",
                dataType: "json",
                type: "get",
                success: function (data) {
                    for (var i = 0; i < data.length; i++) {
                        if (status == data[i].status) {
                            var optionObj = $('<option selected value="' + data[i].status + '">' + data[i].msg + '</option>');
                        } else {
                            var optionObj = $('<option value="' + data[i].status + '">' + data[i].msg + '</option>');

                        }
                        $("#status").append(optionObj);
                    }
                }
            });
        });

        //删除
        function deleteAccount(id) {

            var r = window.alert("确定要删除此账务账号吗？\r\n删除后将不能恢复，且会删除其下属的所有业务账号。");

            $.ajax({
                url: "/netctoss/dele.ajax",
                data: "id=" + id + "&status=2",
                type: "get",
                dataType: "text",
                success: function (data) {
                    $("#status" + id).text("删除");
                    $("#btn" + id).empty();
                    var newHtml = $('');
                    $("#btn" + id).append(newHtml);
                    alert(data);
                },
                error: function () {
                    alert("删除失败！");
                }
            });
        }

        //开通或暂停
        function setOpenState(id) {
            var r = window.confirm("确定要开通此账务账号吗？");
            if (r) {

                $.ajax({
                    url: "/netctoss/state.acc",
                    type: "get",
                    data: "id=" + id + "&status=0",
                    dataType: "text",
                    success: function (data) {
                        $("#status" + id).text("开通");
                        //先清空再添加
                        $("#btn" + id).empty();
                        //重写html
                        var newHtml = $('<input type="button" value="暂停" class="btn_pause" onclick="setStopState(' + id + ');"/>\n' +
                            '                                <input type="button" value="修改" class="btn_modify"\n' +
                            '                                       onclick="location.href=\'http://localhost:8080/netctoss/update.acc?id=' + id + '\';"/>\n' +
                            '                                <input type="button" value="删除" class="btn_delete" onclick="deleteAccount(' + id + ');"/>');
                        $("#btn" + id).append(newHtml);
                        alert("开通功能修改" + data);
                    },
                    error: function () {
                        alert("开通功能修改失败！");
                    }
                });
            }
        }

        function setStopState(id) {
            var r = window.confirm("确定要暂停此账务账号吗？");
            if (r) {
                $.ajax({
                    url: "/netctoss/state.acc",
                    type: "get",
                    data: "id=" + id + "&status=1",
                    dataType: "text",
                    success: function (data) {
                        $('#status' + id).text("暂停");
                        $("#btn" + id).empty();
                        var newHtml = $('  <input type="button" value="开通" class="btn_start"\n' +
                            '              onclick="setOpenState(' + id + ');"/>\n' +
                            '              <input type="button" value="修改" class="btn_modify"\n' +
                            '              onclick="location.href=\'http://localhost:8080/netctoss/update.acc?id=' + id + '\';"/>\n' +
                            '              <input type="button" value="删除" class="btn_delete" onclick="deleteAccount(' + id + ');"/>');
                        $("#btn" + id).append(newHtml);
                        alert("暂停功能修改" + data);
                    },
                    error: function () {
                        alert("暂停功能修改失败！");
                    }

                });
            }
        }


        function loadPage() {
            var getPage = "${current}";//"1"
            document.getElementById(getPage).className = "current_page";
        }


        function pageAjax(no) {
            var idcardno = $("#idName").val();
            var realeName = $("#realName").val();
            var loginName = $("#loginName").val();
            var status = $("#status").val();
            <%--alert(${param.idcardNo});--%>
            $.ajax({
                url: "/netctoss/ajax/list.acc",
                data: "apageNo=" + no + "&aidcardNo=" + idcardno + "&arealName=" + realeName + "&aloginName=" + loginName + "&astatus=" + status,
                type: "post",
                dataType: "json",
                success: function (data) {
                    //清空表格数据
                    $("#datalist").empty();
                    $("#parentPage").empty();
                    //页码清除
                    //设置起始页末页a
                    var first = data[data.length - 1].thisPage;
                    var last = data[data.length - 1].lastPage;
                    // alert(first);


                    $("#datalist").append("<tr>\n" +
                        "                        <th>账号ID</th>\n" +
                        "                        <th>姓名</th>\n" +
                        "                        <th class=\"width150\">身份证</th>\n" +
                        "                        <th>登录名</th>\n" +
                        "                        <th>状态</th>\n" +
                        "                        <th class=\"width100\">创建日期</th>\n" +
                        "                        <th class=\"width150\">上次登录时间</th>\n" +
                        "                        <th class=\"width200\"></th>\n" +
                        "                    </tr>\n");
                    for (var i = 0; i < data.length - 1; i++) {
                        var newHtml = "  <tr>\n" +
                            "                        <td>" + data[i].id + "</td>\n" +
                            "                        <td>\n" +
                            "                            <a href='${base}/todetail.acc?detail=" + data[i].realName + "&id=" + data[i].id + "'>" + data[i].realName + "</a>\n" +
                            "                        </td>\n" +
                            "                        <td>" + data[i].idcardNo + "</td>\n" +
                            "                        <td>" + data[i].loginName + "</td>";
                        if (data[i].status == "0") {
                            newHtml = newHtml + "<td id='status" + data[i].id + "'>\n" +
                                "                                    开通" +
                                "                        </td>"
                        }
                        if (data[i].status == "1") {
                            newHtml = newHtml + "<td id='status" + data[i].id + "'>\n" +
                                "                                    暂停" +
                                "                        </td>"
                        }
                        if (data[i].status == "2") {
                            newHtml = newHtml + "<td id='status" + data[i].id + "'>\n" +
                                "                                    删除" +
                                "                        </td>"
                        }

                        newHtml = newHtml + " <td>" + data[i].createTime + "</td><td></td>";
                        if (data[i].status == "0") {
                            newHtml = newHtml + "  <td id='btn" + data[i].id + "' class='td_modi'>\n" +

                                "                                <input type='button' value='暂停' class='btn_pause'\n" +
                                "                                       onclick='setStopState(" + data[i].id + ");'/>\n" +
                                "                                <input type='button' value='修改' class='btn_modify'\n" +
                                "                                       onclick=\"location.href='http://localhost:8080/netctoss/update.acc?id=" + data[i].id + "';\"/>\n" +
                                "                                <input type='button' value='删除' class='btn_delete'\n" +
                                "                                       onclick='deleteAccount(" + data[i].id + ");'/>\n" +

                                "                        </td>\n";

                        }
                        if (data[i].status == "1") {
                            newHtml = newHtml + "  <td id='btn" + data[i].id + "' class='td_modi'>\n" +

                                "                                <input type='button' value='开通' class='btn_start'\n" +
                                "                                       onclick='setStopState(" + data[i].id + ");'/>\n" +
                                "                                <input type='button' value='修改' class='btn_modify'\n" +
                                "                                       onclick=\"location.href='http://localhost:8080/netctoss/update.acc?id=" + data[i].id + "';\"/>\n" +
                                "                                <input type='button' value='删除' class='btn_delete'\n" +
                                "                                       onclick='deleteAccount(" + data[i].id + ");'/>\n" +

                                "                        </td>\n";
                        }
                        if (data[i].status == "2") {
                            newHtml = newHtml + "  <td id='btn" + data[i].id + "' class='td_modi'>\n" +
                                "                        </td>\n";
                        }
                        $("#datalist").append(newHtml);
                    }

                    // 首页和上一页
                    var pageHtml = "<div id='pages'> <a href='#' onclick='pageAjax(" + 1 + ")'>首页</a>";
                    if (data[data.length - 1].thisPage == 1) {
                        pageHtml = pageHtml + " <a href='#' onclick='pageAjax(" + 1 + ")'>上一页</a>";
                    } else {
                        pageHtml = pageHtml + "  <a href='#' onclick='pageAjax(" + (data[data.length - 1].thisPage - 1) + ")'>上一页</a>";
                    }
                    //如果总页数小于等于5页
                    if (data[data.length - 1].lastPage <= 5) {
                        //展示所有的页码
                        for (var i = 1; i <= last; i++) {
                            // 判断当前页码
                            if (data[data.length - 1].thisPage == i) {
                                pageHtml = pageHtml + "<a href='#' class='current_page'" +
                                    " onclick='pageAjax(" + i + ")'>" + i + "</a>";
                            } else {
                                pageHtml = pageHtml + "<a href='#'" +
                                    " onclick='pageAjax(" + i + ")'>" + i + "</a>";
                            }
                        }
                        //如果总页数大于5页
                    } else if (data[data.length - 1].lastPage > 5) {
                        // 前页不动，后页不动，中间页动
                        switch (first) {
                            case 1 :
                                pageHtml = pageHtml + " <a href='#' class='current_page' onclick='pageAjax(" + 1 + ")'>1</a> " +
                                    " <a href='#' onclick='pageAjax(" + 2 + ")'>2</a> " +
                                    " <a href='#' onclick='pageAjax(" + 3 + ")'>3</a> " +
                                    "<a href='#' onclick='pageAjax(" + 4 + ")'>4</a>\n" +
                                    " <a href='#' onclick='pageAjax(" + 5 + ")'>5</a>\n";
                                break;
                            case 2:
                                pageHtml = pageHtml + " <a href='#'  onclick='pageAjax(" + 1 + ")'>1</a> " +
                                    " <a href='#' class='current_page' onclick='pageAjax(" + 2 + ")'>2</a> " +
                                    " <a href='#' onclick='pageAjax(" + 3 + ")'>3</a> " +
                                    "<a href='#' onclick='pageAjax(" + 4 + ")'>4</a>\n" +
                                    " <a href='#' onclick='pageAjax(" + 5 + ")'>5</a>\n";
                                break;
                            case last - 1:
                                pageHtml = pageHtml + " <a href='#'  onclick='pageAjax(" + (last - 4) + ")'>" + (last - 4) + "</a> " +
                                    " <a href='#'  onclick='pageAjax(" + (last - 3) + ")'>" + (last - 3) + "</a> " +
                                    " <a href='#' onclick='pageAjax(" + (last - 2) + ")'>" + (last - 2) + "</a> " +
                                    "<a href='#' class='current_page' onclick='pageAjax(" + (last - 1) + ")'> " + (last - 1) + "</a>\n" +
                                    " <a href='#' onclick='pageAjax(" + (last) + ")'>" + last + "</a>\n";
                                break;
                            case last:
                                pageHtml = pageHtml + " <a href='#'  onclick='pageAjax(" + (last - 4) + ")'>" + (last - 4) + "</a> " +
                                    " <a href='#'  onclick='pageAjax(" + (last - 3) + ")'>" + (last - 3) + "</a> " +
                                    " <a href='#' onclick='pageAjax(" + (last - 2) + ")'>" + (last - 2) + "</a> " +
                                    "<a href='#'  onclick='pageAjax(" + (last - 1) + ")'>" + (last - 1) + "</a>\n" +
                                    " <a href='#' class='current_page' onclick='pageAjax(" + (last) + ")'>" + last + "</a>\n";
                                break;
                            default:
                                pageHtml = pageHtml + " <a href='#'  onclick='pageAjax(" + (first - 2) + ")'>" + (first - 2) + "</a> " +
                                    " <a href='#'  onclick='pageAjax(" + (first - 1) + ")'>" + (first - 1) + "</a> " +
                                    " <a href='#' class='current_page' onclick='pageAjax(" + (first) + ")'>" + (first) + "</a> " +
                                    "<a href='#'  onclick='pageAjax(" + (first + 1) + ")'>" + (first + 1) + "</a>\n" +
                                    " <a href='#' onclick='pageAjax(" + (first + 2) + ")'>" + (first + 2) + "</a>\n";
                                break;
                        }
                    }
                    if (first < last) {
                        //这里需要parse一下，否则视为字符串拼接
                        pageHtml = pageHtml + "<a href='#'  onclick='pageAjax(" + (parseInt(first) + 1) + ")'>下一页</a>";
                    } else {
                        pageHtml = pageHtml + "<a href='#'  onclick='pageAjax(" + (first) + ")'>下一页</a>";
                    }
                    // 末页
                    pageHtml = pageHtml + " <a href='#' onclick='pageAjax(" + last + ")'>末页</a> </div>";
                    $("#parentPage").append(pageHtml);
                }

            });
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
    <form action="${base}/list.acc" method="post">
        <!--查询-->
        <div class="search_add">
            <div>身份证：<input id="idName" name="idcardNo" value="${param.idcardNo}" type="text" placeholder="不验证"
                            class="text_search"/></div>
            <div>姓名：<input id="realName" name="realName" value="${param.realName}" type="text"
                           class="width70 text_search"
                           placeholder="不验证"/></div>
            <div>登录名：<input id="loginName" name="loginName" value="${param.loginName}" type="text" placeholder="不验证"
                            class="text_search"/></div>
            <div>
                状态：
                <select id="status" class="select_search" name="status">
                    <option value="-1">全部</option>
                </select>
            </div>
            <div><input type="submit" value="搜索" class="btn_search"/></div>
            <input type="button" value="增加" class="btn_add"
                   onclick="location.href='http://localhost:8080/netctoss/add.acc';"/>
        </div>
        <!--删除等的操作提示-->
        <div id="operate_result_info" class="operate_success">
            <img src="${base}/images/close.png" onclick="this.parentNode.style.display='none';"/>
            删除成功，且已删除其下属的业务账号！
        </div>
        <!--数据区域：用表格展示数据-->
        <div id="data">
            <table id="datalist">
                <tr>
                    <th>账号ID</th>
                    <th>姓名</th>
                    <th class="width150">身份证</th>
                    <th>登录名</th>
                    <th>状态</th>
                    <th class="width100">创建日期</th>
                    <th class="width150">上次登录时间</th>
                    <th class="width200"></th>
                </tr>
                <c:forEach var="account" items="${accounts}">
                    <tr>
                        <td>${account.id}</td>
                        <td>
                            <a href="${base}/todetail.acc?detail=${account.realName}&id=${account.id}">${account.realName}</a>
                        </td>
                        <td>${account.idcardNo}</td>
                        <td>${account.loginName}</td>

                            <%--TODO 状态修正--%>

                        <td id="status${account.id}">
                            <c:choose>
                                <c:when test="${account.status == '0'}">
                                    开通
                                </c:when>
                                <c:when test="${account.status == '1'}">
                                    暂停
                                </c:when>
                                <c:when test="${account.status == '2'}">
                                    删除
                                </c:when>
                                <c:otherwise>
                                    状态类型异常
                                </c:otherwise>
                            </c:choose>
                        </td>

                        <td>${account.createDate}</td>
                        <td>${account.lastLoginTime}</td>
                        <td id="btn${account.id}" class="td_modi">
                            <c:if test="${account.status=='0'}">
                                <input type="button" value="暂停" class="btn_pause"
                                       onclick="setStopState(${account.id});"/>
                                <input type="button" value="修改" class="btn_modify"
                                       onclick="location.href='http://localhost:8080/netctoss/update.acc?id=${account.id}';"/>
                                <input type="button" value="删除" class="btn_delete"
                                       onclick="deleteAccount(${account.id});"/>
                            </c:if>
                            <c:if test="${account.status=='1'}">
                                <input type="button" value="开通" class="btn_start"
                                       onclick="setOpenState(${account.id});"/>
                                <input type="button" value="修改" class="btn_modify"
                                       onclick="location.href='http://localhost:8080/netctoss/update.acc?id=${account.id}';"/>
                                <input type="button" value="删除" class="btn_delete"
                                       onclick="deleteAccount(${account.id});"/>
                            </c:if>
                            <c:if test="${account.status=='2'}">

                            </c:if>

                        </td>
                    </tr>
                </c:forEach>


            </table>
            <p>业务说明：<br/>
                1、创建则开通，记载创建时间；<br/>
                2、暂停后，记载暂停时间；<br/>
                3、重新开通后，删除暂停时间；<br/>
                4、删除后，记载删除时间，标示为删除，不能再开通、修改、删除；<br/>
                5、暂停账务账号，同时暂停下属的所有业务账号；<br/>
                6、暂停后重新开通账务账号，并不同时开启下属的所有业务账号，需要在业务账号管理中单独开启；<br/>
                7、删除账务账号，同时删除下属的所有业务账号。</p>
        </div>
        <!--分页-->
        <div id="parentPage">
            <div id="pages">
                <a href="#" onclick="pageAjax(1);">首页</a>
                <c:if test="${current<=1}">
                    <a href="#" onclick="pageAjax(1)">上一页</a>
                </c:if>
                <c:if test="${current > 1}">
                    <a href="#" onclick="pageAjax(${current-1})">上一页</a>
                </c:if>
                <%--TODO 模糊查询分页细节完善未做--%>
                <c:if test="${endPage<=5}">
                    <c:forEach var="i" begin="1" end="${endPage}" step="1">
                        <a id="${i}" href="#" onclick="pageAjax(${i})" class="">${i}</a>
                    </c:forEach>
                </c:if>
                <%--p;2总页数大于5--%>
                <c:if test="${endPage>5}">
                    <%--1,2,3,4,5--%>
                    <c:if test="${current<=3}">
                        <a id="1" href="#" onclick="pageAjax(1)" class="">1</a>
                        <a id="2" href="#" onclick="pageAjax(2)" class="">2</a>
                        <a id="3" href="#" onclick="pageAjax(3)" class="">3</a>
                        <a id="4" href="#" onclick="pageAjax(4)" class="">4</a>
                        <a id="5" href="#" onclick="pageAjax(5)" class="">5</a>
                    </c:if>
                    <%--e-4,e-3,e-2,e-1,e--%>
                    <c:if test="${current>=(endPage-2)}">
                        <a id="${endPage-4}" href="#" onclick="pageAjax(${endPage-4})" class="">${endPage-4}</a>
                        <a id="${endPage-3}" href="#" onclick="pageAjax(${endPage-3})" class="">${endPage-3}</a>
                        <a id="${endPage-2}" href="#" onclick="pageAjax(${endPage-2})" class="">${endPage-2}</a>
                        <a id="${endPage-1}" href="#" onclick="pageAjax(${endPage-1})" class="">${endPage-1}</a>
                        <a id="${endPage}" href="#" onclick="pageAjax(${endPage})" class="">${endPage}</a>
                    </c:if>
                    <%--c-2,c-1,c,c+1,c+2--%>
                    <c:if test="${current>3&&current<(endPage-2)}">
                        <a id="${current-2}" href="#" onclick="pageAjax(${current-2})" class="">${current-2}</a>
                        <a id="${current-1}" href="#" onclick="pageAjax(${current-1})" class="">${current-1}</a>
                        <a id="${current}" href="#" onclick="pageAjax(${current})" class="">${current}</a>
                        <a id="${current+1}" href="#" onclick="pageAjax(${current+1})" class="">${current+1}</a>
                        <a id="${current+2}" href="#" onclick="pageAjax(${current+2})" class="">${current+2}</a>
                    </c:if>
                </c:if>

                <c:if test="${current == endPage}">
                    <a href="#" onclick="pageAjax(${endPage})">下一页</a>
                </c:if>
                <c:if test="${current != endPage}">
                    <a href="#" onclick="pageAjax(${current+1})">下一页</a>
                </c:if>
                <a href="#" onclick="pageAjax(${endPage})">末页</a>
            </div>
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
