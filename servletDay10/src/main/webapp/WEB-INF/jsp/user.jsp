<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/6/4
  Time: 9:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--引入jstl中的c标签--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Title</title>
    <style>
        .sliver {
            background-color: silver;
        }

        .pink {
            background-color: pink;
        }
    </style>
</head>
<body>
<%--优先级：pageContext>request>session>application--%>


<%--<%--%>
<%--String str = "123";--%>
<%--String str2 = "456";--%>
<%--int[] arr = {1, 2, 3};--%>
<%--pageContext.setAttribute("str", str);--%>
<%--request.setAttribute("str", str2);--%>
<%--pageContext.setAttribute("arr", arr);--%>
<%--%>--%>
<%--${str}--%>


<table border="1" style="border-collapse: collapse">
    <thead>
    <tr>
        <th>ID</th>
        <th>姓名</th>
        <th>性别</th>
        <th>年龄</th>
    </tr>
    </thead>

    <tbody>
    <%--forEach+if--%>


    <%--<c:forEach var="user" items="${list}" varStatus="stat">--%>
    <%--<tr <c:if test="${stat.index%2==0}">class="sliver"</c:if>>--%>
    <%--<td>${stat.index}</td>--%>
    <%--<td>${user.name}</td>--%>
    <%--<td>${user.gender}</td>--%>
    <%--<td>${user.age}</td>--%>
    <%--</tr>--%>
    <%--</c:forEach>--%>


    <%--forEach+choose/when--%>
    <c:forEach var="user" items="${list}" varStatus="stat">
        <c:choose>
            <c:when test="${stat.index%2==0}">
                <tr class="sliver">
                    <td>${stat.index}</td>
                    <td>${user.name}</td>
                    <td>${user.gender}</td>
                    <td>${user.age}</td>
                </tr>
            </c:when>
            <c:otherwise>
                <tr class="pink">
                    <td>${stat.index}</td>
                    <td>${user.name}</td>
                    <td>${user.gender}</td>
                    <td>${user.age}</td>
                </tr>
            </c:otherwise>
        </c:choose>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
