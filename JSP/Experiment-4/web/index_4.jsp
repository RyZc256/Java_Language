<%--
  Created by IntelliJ IDEA.
  User: horizon
  Date: 2022/3/26
  Time: 14:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
  <title>CSS+DIV页面布局</title>
  <link href="css/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
<%@ include file="header.jsp"%>
<div id="main">
  <div id="left">
    <iframe src="user.html" frameborder="0" name="onlineUser" width="100%" height="500px" scrolling="auto"></iframe>
  </div>
  <div id="right"><p><img src="images/znz.jpg"/></p></div>
</div><!-- end main -->
<%@ include file="footer.jsp"%>
</body>
</html>