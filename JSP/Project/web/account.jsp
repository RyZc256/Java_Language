<%--
  Created by IntelliJ IDEA.
  User: zsy
  Date: 2022/5/9
  Time: 17:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.entity.User" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="layui/css/layui.css">
    <link rel="stylesheet" href="css/main.css">
    <title>个人中心</title>
</head>
<body >
<jsp:useBean id="user" class="com.entity.User" scope="session"/>
<jsp:include page="navBar.jsp"/>
<%
    user=(User) session.getAttribute("user");
    if(user==null){
        %><jsp:forward page="index.jsp"/><%
        session.invalidate();
    }
    assert user != null;%>
<div class="layui-container">
    <div class="layui-row layui-col-space20" style="padding: 30px 0;">
        <div class="layui-col-md3">
            <div class="layui-panel">
                <ul class="layui-menu" id="Menu1">
                    <li  lay-options="{id:101}">
                        <div class="layui-menu-body-title"><a href="profile.jsp"><i class="layui-icon layui-icon-user"></i>&nbsp;&nbsp;个人资料</a></div>
                    </li>
                    <li class="layui-menu-item-divider"></li>
                    <li  lay-options="{id:101}">
                        <div class="layui-menu-body-title"><a href="account.jsp"><i class="layui-icon layui-icon-auz"></i>&nbsp;&nbsp;账号安全</a></div>
                    </li>
                </ul>
            </div>
        </div>

        <div class="layui-col-md9">
            <div class="layui-panel" style="padding: 10px 20px;">
                <div>
                    <H2>账号信息</H2>
                </div>
            </div>
            <div class="layui-panel" style="padding: 10px 20px;">
                <table class="layui-table" lay-skin="nob" >
                    <colgroup>
                        <col width="120">
                        <col>
                        <col width="80">
                    </colgroup>
                    <tbody>
                        <tr>
                            <td>密码</td>
                            <td>********</td>
                            <td ><a class="link2" onclick=editPwd()>修改</a></td>
                        </tr>
                        <tr>
                            <td>电子邮箱</td>
                            <td><%=user.getU_Email()%></td>
                            <td><a class="link2" style="cursor: pointer" onclick=editEmail()>修改</a></td>
                        </tr>
                        <tr>
                            <td>电话号码</td>
                            <td><%=user.getU_Telphone()%></td>
                            <td><a class="link2" style="cursor: pointer" onclick=editPhone()>修改</a></td>
                        </tr>
                        <tr>
                            <td>身份证</td>
                            <td><%=user.getU_Idcard()%></td>
                            <td><a class="link2" style="cursor: pointer" onclick=editIdCard()>修改</a></td>
                        </tr>
                        <tr>
                            <td>最后登录时间</td>
                            <td><%=user.getU_LastOnline()%></td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>

<%--编辑用户邮箱--%>
<div style="padding: 25px 0;display: none;" id="editEmail">
    <div class="layui-row" >
        <div class="layui-col-xs11">
            <form class="layui-form" method="post" action="user">
                <input type="hidden" name="method" value="editUserInfo">
                <input type="hidden" name="U_Name" value="<%=user.getU_Account()%>">
                <div class="layui-form-item">
                    <label class="layui-form-label">邮箱</label>
                    <div class="layui-input-block">
                        <input name="U_Email" class="layui-input" required="required" value=<%=user.getU_Email()%> type="text">
                    </div>
                </div>

                <br>
                <div class="layui-form-item">
                    <div class="layui-input-block" style="margin-left: 63%">
                        <button name="submit" class="layui-btn-normal layui-btn" type="submit" >提交</button>
                        <button name="reset" class="layui-btn layui-btn-primary" type="reset">重置</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>

<%--编辑用户电话--%>
<div style="padding: 25px 0;display: none;" id="editPhone">
    <div class="layui-row" >
        <div class="layui-col-xs11">
            <form class="layui-form" method="post" action="user">
                <input type="hidden" name="method" value="editUserInfo">
                <input type="hidden" name="U_Name" value="<%=user.getU_Account()%>">
                <div class="layui-form-item">
                    <label class="layui-form-label">电话</label>
                    <div class="layui-input-block">
                        <input name="U_Telphone" class="layui-input" required="required" value=<%=user.getU_Telphone()%> type="text">
                    </div>
                </div>

                <br>
                <div class="layui-form-item">
                    <div class="layui-input-block" style="margin-left: 63%">
                        <button name="submit" class="layui-btn-normal layui-btn" type="submit" >提交</button>
                        <button name="reset" class="layui-btn layui-btn-primary" type="reset">重置</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>

<%--编辑用户身份证--%>
<div style="padding: 25px 0;display: none;" id="editIdCard">
    <div class="layui-row" >
        <div class="layui-col-xs11">
            <form class="layui-form" method="post" action="user">
                <input type="hidden" name="method" value="editUserInfo">
                <input type="hidden" name="U_Name" value="<%=user.getU_Account()%>">
                <div class="layui-form-item">
                    <label class="layui-form-label">身份证</label>
                    <div class="layui-input-block">
                        <input name="U_IdCard" class="layui-input" required="required" value=<%=user.getU_Idcard()%> type="text">
                    </div>
                </div>

                <br>
                <div class="layui-form-item">
                    <div class="layui-input-block" style="margin-left: 63%">
                        <button name="submit" class="layui-btn-normal layui-btn" type="submit" >提交</button>
                        <button name="reset" class="layui-btn layui-btn-primary" type="reset">重置</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<%--<jsp:include page="footer.jsp"/>--%>
</body>

<%--修改密码--%>
<script>
    function editPwd(){

    }
</script>

<%--修改邮箱--%>
<script>
    function editEmail(){
        var $ =layui.jquery
        layer.open({
            type: 1,
            title: '修改邮箱',
            shadeClose: true,
            shade: 0.5,
            area: ['500px', '240px'],
            content: $('#editEmail'),
        });
    }
</script>

<%--修改电话--%>
<script>
    function editPhone(){
        var $ =layui.jquery
        layer.open({
            type: 1,
            title: '修改电话',
            shadeClose: true,
            shade: 0.5,
            area: ['500px', '240px'],
            content: $('#editPhone'),
        });
    }
</script>

<%--修改身份证--%>
<script>
    function editIdCard(){
        var $ =layui.jquery
        layer.open({
            type: 1,
            title: '修改身份证',
            shadeClose: true,
            shade: 0.5,
            area: ['500px', '240px'],
            content: $('#editIdCard'),
        });
    }
</script>
</html>