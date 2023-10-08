<%--
  Created by IntelliJ IDEA.
  User: zsy
  Date: 2022/5/11
  Time: 14:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.entity.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>控制面板</title>
</head>

<body>

<%--获取登录用户的所有项目资料--%>
<form action="project" id="abc" method="post">
    <input type="hidden" name="method" value="getProjectInfo">
    <input type="hidden" name="U_ID" value=<%=((User) session.getAttribute("user")).getU_ID()%>>
</form>

<script>
    document.getElementById("abc").submit();
</script>
</body>
</html>
