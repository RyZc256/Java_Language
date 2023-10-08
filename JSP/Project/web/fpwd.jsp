<%--
  Created by IntelliJ IDEA.
  User: zsy
  Date: 2022/5/25
  Time: 11:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="css/main.css"/>
    <link rel="stylesheet" href="layui/css/layui.css"/>
    <title>找回密码</title>
</head>
<body class="fpwd-body">
<div class="layui-container">
    <div class="fpwd-panel">
        <div class="fpwd-item">
            <h1>找回密码</h1>
            <form action="user?method=sendEmail" method="post">
                <div class="layui-form-item" style="padding-top: 20px">
                    <input class="layui-input" type="text" required="required" placeholder="请输入用户名" name="U_Name"/>
                </div>
                <div class="layui-form-item" style="padding-top: 10px">
                    <button class="layui-btn layui-btn-normal but" style="width: 100%" type="submit">下一步</button>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
