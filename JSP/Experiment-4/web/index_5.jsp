<%--
  Created by IntelliJ IDEA.
  User: horizon
  Date: 2022/3/26
  Time: 14:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="java.lang.String"%>
<html>
<head>
    <Title>forward动作元素的应用</title>
</head>
<body>
<% String username=request.getParameter("user");%>
<% String pwd=request.getParameter("pass");%>
<% if(username.equals("admin") && pwd.equals("admin")){ %>
<jsp:forward page="./success.html"></jsp:forward>
<% }else{ %>
<jsp:forward page="./login.jsp"></jsp:forward>
<% } %>
</body>
</html>