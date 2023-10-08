<%@ page import="com.util.DB" %><%--
  Created by IntelliJ IDEA.
  User: horizon
  Date: 2022/5/7
  Time: 23:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="DB" class="com.util.DB"></jsp:useBean>
<jsp:useBean id="userDAO" class="com.dao.UsersDAO"></jsp:useBean>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    DB db = new DB();
    if(userDAO.login(username,password)){
        session.setAttribute("username",username);
        response.sendRedirect("main.jsp");
    }
%>
</body>
</html>
