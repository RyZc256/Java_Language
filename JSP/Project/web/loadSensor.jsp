
<%--
  Created by IntelliJ IDEA.
  User: zsy
  Date: 2022/5/12
  Time: 10:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.entity.User" %>
<%@ page import="com.entity.Project" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String P_ID=request.getParameter("P_ID");
    Project project= (Project) session.getAttribute("project");
    if(project!=null && P_ID==null){
        P_ID= String.valueOf(project.getP_ID());
    }

%>
<%--获取登录用户的所有项目资料--%>
<form action="sensor" id="abc" method="post">

    <input type="hidden" name="method" value="getAllSensorInfo">
    <input type="hidden" name="P_ID" value=<%=P_ID%>>
</form>

<script>

    document.getElementById("abc").submit();
</script>

</body>
</html>
