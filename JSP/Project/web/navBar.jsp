<%--
  Created by IntelliJ IDEA.
  User: zsy
  Date: 2022/5/9
  Time: 16:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.entity.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<jsp:useBean id="user" class="com.entity.User" scope="session"/>
<%
    user=(User) session.getAttribute("user");
    if(user==null || user.getU_Account()==null){
        %> <jsp:forward page="index.jsp"/><%
    }
%>
<ul class="layui-nav">

    <li class="layui-nav-item"><a href="main.jsp">首页</a></li>
    <li class="layui-nav-item layui-col-md-offset10"><a href="loadProject.jsp">控制台</a></li>
    <li class="layui-nav-item">
        <a href="profile.jsp"><%=user.getU_Account()%></a>
        <dl class="layui-nav-child"> <!-- 二级菜单 -->
            <dd><a href="profile.jsp">个人中心</a></dd>
            <dd><a href="logout.jsp">注销账号</a></dd>
        </dl>
    </li>
</ul>

</body>
<script src="layui/layui.js"></script>
<script>
    layui.use('element', function(){
        var element = layui.element;
        element.render('nav','text1');
    });
</script>

</html>
