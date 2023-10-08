<%--
  Created by IntelliJ IDEA.
  User: horizon
  Date: 2022/4/1
  Time: 15:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.*" language="java" pageEncoding="gb2312" %>
<%
    request.setCharacterEncoding("gb2312");
    if(session.getAttribute("username")==null || session.getAttribute("username").equals("")){
        out.print("请先登录，等待5秒自动返回登录界面");
        response.setHeader("Refresh","5;URL=login.jsp");
    }
%>
<html>
<head>
    <meta charset="utf-8">
    <title>表单</title>
    <script>
        function verify(){
            if(pwd1.value != pwd2.value){
                alert("两次密码不一致");
                pwd1.value = "";
                pwd2.value = "";
            }
        }
    </script>
</head>
<body>
<form name="data" method="post" action="saveEmail.jsp">
    <table border="1">
        <tr>
            <td>
                请选择您的雅虎邮箱：
            </td>
            <td>
                <input type="text" required="required" name="email" />
                <font color="red">@</font>
                <select required="required" name="domain">
                    <option value ="yahoo.cn">yahoo.cn</option>
                    <option value ="sina.com.cn">sina.com.cn</option>
                    <option value="163.com">163.com</option>
                </select>
            </td>
        </tr>
        <tr>
            <td>
                密码：
            </td>
            <td>
                <input id="pwd1" type="password" required="required" name="password" />
            </td>
        </tr>
        <tr>
            <td>
                再次输入密码：
            </td>
            <td>
                <input id="pwd2" type="password" required="required" name="verify_password" onblur="verify()" />
            </td>
        </tr>
        <tr>
            <td>
                真实姓名：
            </td>
            <td>
                <input type="text" required="required" name="name" />
            </td>
        </tr>
        <tr>
            <td>
                出生日期：
            </td>
            <td>
                <input type="text" required="required" name="date" />
            </td>
        </tr>
        <tr>
            <td>
                性别：
            </td>
            <td>
                <input required="required" type="radio" name="sex" value="男">男
                <input required="required" type="radio" name="sex" value="女">女
            </td>
        </tr>
        <tr>
            <td>
                杂志订阅：
            </td>
            <td>
                <input type="checkbox" name="Magazine" value="旅游" />旅游
                <input type="checkbox" name="Magazine" value="财经" />财经
                <input type="checkbox" name="Magazine" value="汽车" />汽车
                <input type="checkbox" name="Magazine" value="音乐" />音乐
            </td>
        </tr>
        <tr>
            <td>
                雅虎服务条款
            </td>
            <td >
                <textarea name="Notice" rows="5" >雅虎中国对于任何包含于、经由、或联结、下载或从任何与本网站有关服务(以下简称「服务」)所获得之资讯、内容或广告(以下简称「资料」)，您于此接受并承认信赖任何「资料」所生之风险应自行承担。雅虎中国，有权但无此义务，改善或更正在「服务」或「资料」任何部分之错误或疏失。</textarea>
            </td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" name="agree" value="同意服务条款并提交"/>
                <input type="reset" name="clear" value="清空"/>
            </td>
        </tr>
    </table>
</form>



</body>
</html>
