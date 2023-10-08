<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: horizon
  Date: 2022/4/8
  Time: 09:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <%
    int[] num = {1,2,3,4,5,6,7,8,9};
    int flag = 1;
    request.setAttribute("num",num);
  %>
<c:forEach var="i" begin="1" end="9" step="1">
  <c:forEach var="k" begin="1" end="${i}" step="1">
    <c:out value="${i} + ${k} = ${i*k} "></c:out>
  </c:forEach>
  <br>
</c:forEach>
</body>
</html>
