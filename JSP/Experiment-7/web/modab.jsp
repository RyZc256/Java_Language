<%--
  Created by IntelliJ IDEA.
  User: horizon
  Date: 2022/4/15
  Time: 09:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>计算a和b的余</title>
</head>
<body>
<jsp:useBean id="compute" class="bean.Compute" scope="session"></jsp:useBean>
<%
    int value1=Integer.parseInt(request.getParameter("a"));
    int value2=Integer.parseInt(request.getParameter("b"));
    int sum=compute.modab(value1, value2);
    out.println(value1+"%"+value2+"="+sum);
%>
</body>
</html>
