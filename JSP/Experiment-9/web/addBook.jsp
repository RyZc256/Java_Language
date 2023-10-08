<%--
  Created by IntelliJ IDEA.
  User: horizon
  Date: 2022/5/7
  Time: 23:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setCharacterEncoding("gb2312");
    if(session.getAttribute("username")==null || session.getAttribute("username").equals("")){
        out.print("请先登录，等待5秒自动返回登录界面");
        response.setHeader("Refresh","5;URL=login.jsp");
    }
%>
<html>
<head>
    <title>添加图书</title>
</head>
<body>
<form action="handle.jsp?action=add" method="post">
    书名:&nbsp;<input type="text" name="bookname"><br>
    作者:&nbsp;<input type="text" name="author"><br>
    出版社:&nbsp;<input type="text" name="press"><br>
    出版时间:&nbsp;<input type="date" name="pubdate">格式如：2017-10-01<br>
    价格:&nbsp;<input type="text" name="price"><br>
    ISBN号:&nbsp;<input type="text" name="isbn"><br>
    <input type="submit" value="提交">
    <input type="button" onclick="window.location='main.jsp'" value="返回">
</form>
</body>
</html>
