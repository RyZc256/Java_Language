<%--
  Created by IntelliJ IDEA.
  User: horizon
  Date: 2022/4/1
  Time: 16:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form method="POST" action="/web/request/checkLogin.jsp">
        <table border="1">
            <tr>
                <td>登录名：</td>
                <td>
                    <input type="text" name="username">
                </td>
            </tr>
            <tr>
                <td>密&nbsp;&nbsp;码：</td>
                <td>
                    <input type="password" name="pwd">
                </td>
            </tr>
            <tr>
                <td>角&nbsp;&nbsp;色：</td>
                <td>
                    <input type="radio" name="role" value="admin">管理员
                    <input type="radio" name="role" value="user">普通用户
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="登录">
                    <input type="reset" value="清空">
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
