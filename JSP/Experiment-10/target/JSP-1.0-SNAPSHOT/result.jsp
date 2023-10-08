<%--
  Created by IntelliJ IDEA.
  User: horizon
  Date: 2022/5/13
  Time: 23:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
    <title>计算ab的结果</title>
</head>
<body>
a和b的计算结果为：
<%out.print(request.getAttribute("result"));
%>
</body>
</html>
