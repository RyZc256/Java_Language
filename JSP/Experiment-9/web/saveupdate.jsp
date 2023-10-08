<%--
  Created by IntelliJ IDEA.
  User: horizon
  Date: 2022/5/6
  Time: 09:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<% request.setCharacterEncoding("utf-8");%>
<jsp:useBean id="bookDAO" class="com.dao.BookDAO"></jsp:useBean>
<jsp:useBean id="book" class="com.bean.Book"></jsp:useBean>
<jsp:setProperty name="book" property="*"/>
<%
    boolean result = bookDAO.updateBook(book);
    String msg = "";
    if(result)
        msg = "修改图书成功";
    else
        msg = "修改图书失败";
    session.setAttribute("msg",msg);
    response.sendRedirect("result.jsp");
%>
</body>
</html>
