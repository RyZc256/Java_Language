<%--
  Created by IntelliJ IDEA.
  User: zsy
  Date: 2022/5/9
  Time: 16:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.entity.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="layui/css/layui.css">
    <link rel="stylesheet" href="css/main.css"/>
    <title>个人中心</title>
</head>
<body>
<jsp:useBean id="user" class="com.entity.User" scope="session"/>
<jsp:include page="navBar.jsp"/>
<%
    user=(User) session.getAttribute("user");
%>
<div class="layui-container">
    <div class="layui-row layui-col-space20" style="padding: 30px 0;">
        <div class="layui-col-xs9 layui-col-md3">
            <div class="layui-panel">
                <ul class="layui-menu" id="Menu1">
                    <li lay-options="{id:101}">
                        <div class="layui-menu-body-title"><a href="profile.jsp"><i class="layui-icon layui-icon-user"></i>&nbsp;&nbsp;个人资料</a></div>
                    </li>
                    <li class="layui-menu-item-divider"></li>
                    <li lay-options="{id:101}">
                        <div class="layui-menu-body-title"><a href="account.jsp"><i class="layui-icon layui-icon-auz"></i>&nbsp;&nbsp;账号安全</a></div>
                    </li>
                </ul>
            </div>
        </div>

        <div class="layui-col-md9">
            <div class="layui-panel" style="padding: 10px 20px;">
                <H2>个人资料</H2>
            </div>

            <div class="layui-panel layui-row" style="padding: 10px 20px;">
                <div class="layui-col-md2" style="margin-top: 15px;text-align: center">
                    <img class="profile-photo" src="img/huaweicloud-iotexperience.png">
                    <button class="layui-btn layui-btn-sm" id="subPhoto" type="button" style="margin-top: 5px"><i class="layui-icon">&#xe67c;</i>修改图片</button>
                </div>
                <div class="layui-col-md10">
                    <table class="layui-table" lay-skin="nob" >
                        <colgroup>
                            <col width="100">
                            <col>
                            <col width="100">
                            <col>
                        </colgroup>
                        <tbody>
                        <tr>
                            <td>用户名</td>
                            <td><%=user.getU_Account()%></td>
                            <td>电子邮箱</td>
                            <td><%=user.getU_Email()%></td>
                        </tr>
                        <tr>
                            <td>用户id</td>
                            <td><%=user.getU_ID()%></td>
                            <td>电话号码</td>
                            <td><%=user.getU_Telphone()%></td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>

<%--<jsp:include page="footer.jsp"/>--%>
</body>

<script src="layui/layui.js"></script>

<script>
    layui.use('upload', function(){
        var upload = layui.upload;

        //执行实例
        var uploadInst = upload.render({
            elem: '#subPhoto' //绑定元素
            ,url: '/upload/' //上传接口
            ,done: function(res){
                //上传完毕回调
            }
            ,error: function(){
                //请求异常回调
            }
        });
    });
</script>
</html>
