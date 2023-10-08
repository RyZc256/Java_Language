<%@ page import="bean.Email" %><%--
  Created by IntelliJ IDEA.
  User: horizon
  Date: 2022/4/15
  Time: 08:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>输出注册邮箱信息</title>
</head>

<jsp:useBean id="Email" class="bean.Email" scope="session"></jsp:useBean>
<jsp:setProperty name="Email" property="email" param="email"></jsp:setProperty>
<jsp:setProperty name="Email" property="domain" param="domain"></jsp:setProperty>
<jsp:setProperty name="Email" property="password" param="password"></jsp:setProperty>
<jsp:setProperty name="Email" property="name" param="name"></jsp:setProperty>
<jsp:setProperty name="Email" property="date" param="date"></jsp:setProperty>
<jsp:setProperty name="Email" property="sex" param="sex"></jsp:setProperty>
<%
    String magazine = "";
    String[] sz = request.getParameterValues("Magazine");
    for(int i=0;i<sz.length;i++){
        magazine+=sz[i];
        if(i!=sz.length-1)
            magazine+=",";
    }
    Email.setMagazine(magazine);
%>
<jsp:setProperty name="Email" property="notion" param="Notice"></jsp:setProperty>
<body>
    <table border="1">

        <tr>
            <td>用户名</td>
            <td>密码</td>
            <td>真实姓名</td>
            <td>出生日期</td>
            <td>性别</td>
            <td>杂志订阅</td>
            <td>备注</td>
        </tr>
        <tr>
            <td>
                <jsp:getProperty name="Email" property="email"/>@
                <jsp:getProperty name="Email" property="domain"/>
            </td>
            <td>
                <jsp:getProperty name="Email" property="password"/>
            </td>
            <td>
                <jsp:getProperty name="Email" property="name"/>
            </td>
            <td>
                <jsp:getProperty name="Email" property="date"/>
            </td>
            <td>
                <jsp:getProperty name="Email" property="sex"/>
            </td>
            <td>
                <jsp:getProperty name="Email" property="magazine"/>
            </td>
            <td>
                <jsp:getProperty name="Email" property="notion"/>
            </td>
        </tr>
    </table>
</body>
</html>
