<%--
  Created by IntelliJ IDEA.
  User: zsy
  Date: 2022/5/30
  Time: 19:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    if(request.getParameter("Vcode")!=null){
        if(request.getParameter("code").equals(session.getAttribute("Vcode"))){
            response.sendRedirect(String.format("editpwd.jsp?username=%s",request.getParameter("RTP_user")));
            session.setAttribute("Vcode",null);
        }
        else{
            out.print("验证码错误");
            response.setHeader("Refresh","5;URL=#");
        }

    }
%>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="css/main.css"/>
    <link rel="stylesheet" href="layui/css/layui.css"/>
    <title>输入验证码</title>
</head>
<body class="fpwd-body">
<div class="layui-container">
    <div class="fpwd-panel">
        <div class="fpwd-item">
            <h1>输入验证码</h1><br>
            <span class="link" style="padding-top: 20px">验证码已发送到绑定邮箱，请输入接收的验证码</span>
            <form action="user?method=Verify" method="post">
                <div class="layui-form-item" style="padding-top: 20px">
                    <input class="layui-input" type="text" required="required" placeholder="请输入验证码" name="code"/>
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
