<%--
  Created by IntelliJ IDEA.
  User: horizon
  Date: 2022/4/1
  Time: 15:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    String email = request.getParameter("email") + "@" + request.getParameter("domain");
    String pwd = request.getParameter("password");
    String name = request.getParameter("name");
    String date = request.getParameter("date");
    String sex = request.getParameter("sex");
    String magazine = "";
    String[] magazinesz = request.getParameterValues("Magazine");
    for(int i=0;i<magazinesz.length;i++){
        magazine+=magazinesz[i];
        if(i!=magazinesz.length-1){
            magazine+=",";
        }
    }
    String notice = request.getParameter("Notice");
%>




<p align="center">注册信息列表</p>
<table border="1" align="center" >
    <tr align="center">
        <td>邮箱地址</td>
        <td>真实姓名</td>
        <td>出生日期</td>
        <td>性别</td>
        <td>杂志订阅</td>
        <td>备注</td>
    </tr>
    <tr align="center">
        <td><%=email%></td>
        <td><%=name%></td>
        <td><%=date%></td>
        <td><%=sex%></td>
        <td><%=magazine%></td>
        <td><%out.print(String.format("%s",notice.substring(0,20)));%></td>
    </tr>

</table>





</body>
</html>
