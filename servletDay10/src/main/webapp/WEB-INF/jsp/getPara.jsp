<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/6/4
  Time: 15:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--EL获取请求参数的方法--%>

<html>
<head>
    <title>Title</title>
</head>
<body>
${param.username}
<br/>
${param.userpwd}
<br/>

<c:forEach var="hobby" items="${paramValues.hobbies}">
    ${hobby}
</c:forEach>

</body>
</html>
