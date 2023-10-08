<%--
  Created by IntelliJ IDEA.
  User: zsy
  Date: 2022/5/30
  Time: 19:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    if(session.getAttribute("Verify_Result")==null){
        response.sendRedirect("./index.jsp");
    }
%>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="css/main.css"/>
    <link rel="stylesheet" href="layui/css/layui.css"/>
    <title>修改密码</title>
</head>
<body class="fpwd-body">
<div class="layui-container">
    <div class="fpwd-panel">
        <div class="fpwd-item">
            <h1>修改密码</h1>
            <form action="user?method=editPassword" method="post">
                <div class="layui-form-item" style="padding-top: 20px">
                    <input class="layui-input" type="text" required="required" placeholder="请输入新的密码" name="U_Password"/>
                </div>
                <div class="layui-form-item" style="padding-top: 10px">
                    <button class="layui-btn layui-btn-normal but" style="width: 100%" type="submit">完成</button>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
