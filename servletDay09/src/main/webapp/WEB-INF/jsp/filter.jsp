<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/6/3
  Time: 14:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<fieldset>
    <legend>发表评论</legend>
    <form action="<%=request.getContextPath()%>/comm">
        <textarea rows="5" cols="50" name="comment"></textarea>
        <input type="submit" value="发表评论">
    </form>
</fieldset>
</body>
</html>
