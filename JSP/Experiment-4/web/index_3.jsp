<%--
  Created by IntelliJ IDEA.
  User: horizon
  Date: 2022/3/26
  Time: 14:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=utf-8"%>
<html>
<head>
    <title>CSS+DIV页面布局</title>
    <link href="css/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div id="header">
    <div id="logo">
        <img src="./images/logo.gif" border="0"/><br/>
        <span>
				 2021年春学期 &nbsp;&nbsp;&nbsp;&nbsp;当前用户：小李 (管理员)
		  </span>
    </div>
    <div id="banner"> 好好学习，天天向上</div>
    <img id="computer" src="./images/head.gif" align="middle" />
</div><!-- end header -->
<div id="main">
    <div id="left">
        <iframe src="user.html" frameborder="0" name="onlineUser" width="100%" height="500px" scrolling="auto"></iframe>
    </div>
    <div id="right"><p><img src="images/znz.jpg"/></p></div>
</div><!-- end main -->
<div id="footer">
    <p>&copy;班级：姓名：学号：制作 <a href="#">学院网站</a></p>
</div>
</body>
</html>