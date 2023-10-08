<%--
  Created by IntelliJ IDEA.
  User: horizon
  Date: 2022/4/8
  Time: 08:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <c:set var="email" scope="request" value="${param.email}"></c:set>
    <c:set var="name" scope="request" value="${param.name}"></c:set>
    <c:set var="date" scope="request" value="${param.date}"></c:set>
    <c:set var="sex" scope="request" value="${param.sex}"></c:set>
    <%
        String magazine = "";
        String[] magazinesz = request.getParameterValues("Magazine");
        for(int i=0;i<magazinesz.length;i++){
            magazine+=magazinesz[i];
            if(i!=magazinesz.length-1)
                magazine+=",";
        }
    %>
    <c:set var="notice" scope="request" value="${param.Notice}"></c:set>

    <table border="1" align="center" width="1000" >
        <tr>
            <td>邮箱地址</td>
            <td>真实姓名</td>
            <td>出生日期</td>
            <td>性别</td>
            <td>杂志订阅</td>
            <td>备注</td>
        </tr>
        <tr>
            <td> <c:out value="${email}"></c:out> </td>
            <td> <c:out value="${name}"></c:out> </td>
            <td> <c:out value="${date}"></c:out> </td>
            <td> <c:out value="${sex}"></c:out> </td>
            <td> <% out.print(magazine); %> </td>
            <td> <c:out value="${notice}"></c:out> </td>
        </tr>
    </table>

</body>
</html>
