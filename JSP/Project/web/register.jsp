
<%--
  Created by IntelliJ IDEA.
  User: horizon
  Date: 2022/3/29
  Time: 17:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/main.css"/>
    <link rel="stylesheet" href="layui/css/layui.css">
    <title>注册页面-环境数据可视化系统</title>
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
<div class="register">
    <div class="layui-panel" style="padding: 40px 50px">
        <h1>注册</h1><br><br>

        <form class="layui-form" method="post" action="register">
            <div class="layui-form-item">
                <input class="layui-input" type="text" required="required" placeholder="用户名" name="U_Account">
            </div>
            <div class="layui-form-item">
                <input class="layui-input" type="password" required="required" placeholder="密码" name="U_Password">
            </div>
            <div class="layui-form-item">
                <input class="layui-input" type="email" required="required" placeholder="邮箱" name="U_Email">
            </div>
            <div class="layui-form-item">
                <input class="layui-input" type="tel" required="required" placeholder="联系方式" name="U_Telphone">
            </div>
            <div class="layui-form-item">
                <input class="layui-input" type="text" required="required" placeholder="中华人民共和国居民身份证" pattern="^[1-9]\d{5}(18|19|([23]\d))\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\d{3}[0-9Xx]$" name="U_Idcard">
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
                <button class="layui-btn layui-btn-normal but" type="submit" style="float: left">注册</button>
                <button class="layui-btn layui-btn-primary but" type="reset" style="float: right">重置</button>
            </div>
        </form>
    </div>
</div>


</body>

<%--引用layui.js--%>
<script src="layui/layui.js" charset="utf-8"></script>
<script>
    layui.use('element', function(){
        var element = layui.element;
        element.render('nav','text1');
    });
</script>
</html>
