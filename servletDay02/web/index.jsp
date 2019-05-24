<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" import="java.util.*" language="java" %>
<%@page import="com.itek.servlet.day02.Account" %>
<%@ page import="com.itek.servlet.day02.AccountDAO" %>
<%
    String path = request.getContextPath();
    String basepath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE html>
<html>
<head>
    <title>account</title>
    <style>
        table {
            border-collapse: collapse;
            position: center;
        }
    </style>
</head>
<body>
<table border="1">
    <tr>
        <td>account_id</td>
        <td>real_name</td>
        <td>login_name</td>
        <td>idcard_no</td>
        <td>telephone</td>
    </tr>
    <%
        AccountDAO dao = new AccountDAO();
        List<Account> list = dao.readFirstAccount();
        for (Account a1 : list) {
    %>
    <tr>
        <td><%=a1.getAccount_id()%>
        </td>
        <td><%=a1.getReal_name()%>
        </td>
        <td><%=a1.getLogin_name()%>
        </td>
        <td><%=a1.getIdcard_no()%>
        </td>
        <td><%=a1.getTelephone()%>
        </td>
    </tr>
    <%
        }

    %>
</table>
</body>
</html>