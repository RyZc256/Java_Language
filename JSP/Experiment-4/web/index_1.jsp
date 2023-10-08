<%--
  Created by IntelliJ IDEA.
  User: horizon
  Date: 2022/3/25
  Time: 09:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>九九乘法表</title>
</head>
<body>
<%
    for(int i=1;i<10;i++){
        for(int j=1;j<i+1;j++){
            out.print(String.format("%s*%s=%s\t",i,j,i*j));
        }
%>
<br/>
<%
    }
%>
</body>
</html>
