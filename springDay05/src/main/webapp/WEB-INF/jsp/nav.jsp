<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/6/11
  Time: 19:48
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    request.setAttribute("base", request.getContextPath());
%>
<c:forEach var="menu" items="${menus}">
    <li><a href="${base}${menu.href}" class="${menu.clazz}"></a></li>
</c:forEach>