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
<jsp:useBean id="bookDAO" class="com.dao.BookDAO"></jsp:useBean>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>修改图书信息</h1>
<h1>${text}</h1>
<form action="handle.jsp?action=edit" method="post">
    <input type="hidden" name="id" value="${book.id}">
    书名:&nbsp;<input type="text" name="bookname"value="${book.bookname}" size="50"><br>
    作者:&nbsp;<input type="text" name="author"value="${book.author}"><br>
    出版社:&nbsp;<input type="text" name="press"value="${book.press}"><br>
    出版时间:&nbsp;<input type="text" name="pubdate"value="${book.pubdate}"><br>
    价格:&nbsp;<input type="text" name="price"value="${book.price}"><br>
    ISBN号:&nbsp;<input type="text" name="isbn"value="${book.isbn}"><br>
    <input type="submit" value="提交">
    <input type="button" onclick="window.location='main.jsp'" value="返回">
</form>
</body>
</html>
