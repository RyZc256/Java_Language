<%@ page import="com.dao.Login" %>
<%--
  Created by IntelliJ IDEA.
  User: horizon
  Date: 2022/3/29
  Time: 17:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="css/main.css"/>
    <link rel="stylesheet" href="layui/css/layui.css"/>
    <title>登录页面-环境数据可视化系统</title>
</head>
<body style="background: url(img/background_login.jpg)center top /auto 100% no-repeat;">

<ul class="layui-nav">
    <li class="layui-nav-item"><a href="index.jsp">首页</a></li>
    <li class="layui-nav-item layui-col-md-offset10"><a href="login.jsp">控制台</a></li>
    <li class="layui-nav-item"><a href="login.jsp">登录</a></li>
    <li class="layui-nav-item"><a href="register.jsp">注册</a></li>
</ul>

<div class="login-img">
    <img src="img/1653375817957533374.png"/>
</div>

<div class="login">
    <div class="layui-panel" style="padding: 40px 50px">
        <h1>登录</h1><br><br>
        <form class="layui-form" method="post" action="login">
            <input type="hidden" name="method" value="Userlogin" />

            <div class="layui-form-item input">
                <input class="layui-input" type="text" required="required" placeholder="请输入用户名" name="username"/>
            </div>
            <br>
            <div class="layui-form-item input">
                <input class="layui-input" type="password" required="required" placeholder="请输入密码" autocomplete="off" name="password"/>
            </div>
            <span style="color: red; ">
                <%
                    String error = (String) session.getAttribute("error");
                    if(error!=null){
                        out.print(error);
                    }
                    session.invalidate();
                %>
            </span>
            <br><br>
            <div class="layui-form-item input">
                <button class="layui-btn layui-btn-normal but" type="submit" style="float: left">登录</button>
                <button class="layui-btn layui-btn-primary but" type="button" style="float: right" onclick='location.href=("register.jsp")'>注册</button>
            </div>
            <div>
                <a class="link" href="fpwd.jsp" onclick='location.href=("fpwd.jsp")' >忘记密码</a>
            </div>
        </form>
    </div>

</div>

</body>

<script src="layui/layui.js"></script>
<script>
    layui.use('element', function(){
        var element = layui.element;
        element.render('nav','text1');
    });
</script>
<script>
    layui.use('form',function (){
        var form=layui.form;
    });
</script>
</html>