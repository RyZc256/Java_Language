<%--
  Created by IntelliJ IDEA.
  User: horizon
  Date: 2022/3/26
  Time: 13:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>1-100的和</title>
</head>
<body>
    <%
        int sum = 0;
        for(int i=1;i<101;i++){
            sum += i;
        }
        out.print(sum);
    %>
</body>
</html>
