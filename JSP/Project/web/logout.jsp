<%--
  Created by IntelliJ IDEA.
  User: zsy
  Date: 2022/5/9
  Time: 16:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        session.invalidate();
    %>
    <jsp:forward page="index.jsp"/>
</body>
</html>
