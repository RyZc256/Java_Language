<%--
  Created by IntelliJ IDEA.
  User: horizon
  Date: 2022/4/1
  Time: 16:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        String username = request.getParameter("username");
        String pwd = request.getParameter("pwd");
        String role = request.getParameter("role");
        if(username.equals("admin") && pwd.equals("admin")){
            response.sendRedirect("addBook.jsp");
            session.setAttribute("username",username);
        }else{%>
            登录失败，请等待5秒后重新登录
    <%
        response.setHeader("Refresh","5;URL=login.jsp");}
    %>
</body>
</html>
