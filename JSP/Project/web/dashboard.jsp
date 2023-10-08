<%--
  Created by IntelliJ IDEA.
  User: zsy
  Date: 2022/5/9
  Time: 20:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.entity.Project" %>
<%@ page import="com.entity.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="utf-8">
    <title>控制面板</title>
    <link rel="stylesheet" href="layui/css/layui.css"/>
    <link rel="stylesheet" href="css/main.css"/>
</head>

<body>

<jsp:include page="navBar.jsp"/>

<%--项目报错提示--%>
<%
    String error = (String) session.getAttribute("error");
    if(error!=null){
    %><script>alert(<%=error%>)</script><%
        session.setAttribute("error",null);
    }
%>

<%--获取当前user--%>
<%
    User user=(User) session.getAttribute("user");
%>
<div class="layui-container">
    <div class="layui-row layui-col-space20" style="padding: 30px 0;">
        <div class="layui-panel" align="right" >
            <button class="layui-btn layui-btn-sm" onclick="createProject()">新建项目</button>
        </div>
        <div class="layui-panel">
            <table lay-filter="ProjectTable">
                <thead>
                    <tr>
                        <th lay-data="{field:'P_ID',sort:true}">项目编号</th>
                        <th lay-data="{field:'P_Tag',sort:true}">标识符</th>
                        <th lay-data="{field:'P_Name',sort:true}">项目名称</th>
                        <th lay-data="{field:'P_Date',sort:true}">创建日期</th>
                        <th lay-data="{fixed: 'right', width:180,toolbar: '#bar'}">编辑</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        ArrayList<Project> list = (ArrayList<Project>) session.getAttribute("ProjectList");
                        for(Project p:list){
                            %><tr>
                                <td><%=p.getP_ID()%></td>
                                <td><%=p.getP_Tag()%></td>
                                <td><%=p.getP_Name()%></td>
                                <td><%=p.getP_Date()%></td>
                                <td></td>
                            </tr><%
                        }
                    %>
                </tbody>
            </table>
        </div>
    </div>
</div>

<%--新建项目表单--%>
<div style="padding: 25px 0;display: none;" id="biaodan">
    <div class="layui-row" >
        <div class="layui-col-xs11">
            <form class="layui-form" method="post" action="project">
                <input type="hidden" name="method" value="createProject">
                <input type="hidden" name="U_ID" value="<%=user.getU_ID()%>">
                <div class="layui-form-item">
                    <label class="layui-form-label">项目名称</label>
                    <div class="layui-input-block">
                        <input name="P_Name" class="layui-input" required="required" placeholder="请输入项目名" type="text">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">标识符</label>
                    <div class="layui-input-block">
                        <input name="P_Tag" class="layui-input" required="required" placeholder="请输入设备上正确的唯一标识符" type="text">
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
<%--引用layui.js--%>
<script src="layui/layui.js" charset="utf-8"></script>

<%--工具条内容--%>
<script type="text/html" id="bar">
    <a class="layui-btn layui-btn-xs layui-btn-normal" lay-event="detail">详情</a>
    <a class="layui-btn layui-btn-xs" lay-event="edit">重命名</a>
    <a class="layui-btn layui-btn-xs layui-btn-danger" lay-event="del">删除</a>
</script>

<%--渲染表格--%>
<script>
    var table = layui.table;
    //转换静态表格
    table.init('ProjectTable', {
        height: 450 //设置高度
        ,limit: 10 //注意：请务必确保 limit 参数（默认：10）是与你服务端限定的数据条数一致
        ,page:true
    });
</script>

<%--工具条事件--%>
<script>
    table.on('tool(ProjectTable)',function (obj){
        //获得当行数据
        var data = obj.data;
        //获得lay-event对应的值
        var event = obj.event;

        //创建表单
        var toolForm = document.createElement("form");
        toolForm.method="post";
        toolForm.action="project";

        //创建input2,保存U_ID
        var input2=document.createElement("input");
        input2.type="hidden";
        input2.name="U_ID";
        input2.value=<%=((User)session.getAttribute("user")).getU_ID()%>;
        toolForm.appendChild(input2);

        //创建input3,保存选中的P_ID
        var input3=document.createElement("input");
        input3.type="hidden";
        input3.name="P_ID";
        input3.value=data.P_ID;
        toolForm.appendChild(input3);

        //创建input5,保存选中的P_Tag。
        var input5=document.createElement("input");
        input5.type="hidden";
        input5.name="P_Tag"
        input5.value=data.P_Tag;
        toolForm.appendChild(input5);

        if(event === 'del'){//删除项目
            layer.confirm('是否确认删除，删除数据无法找回！',function (index){

                //创建input1,保存要执行的方法。
                var input1=document.createElement("input");
                input1.type="hidden";
                input1.name="method"
                input1.value="delProject";
                toolForm.appendChild(input1);

                //上传表单
                document.body.appendChild(toolForm);
                toolForm.submit(); //递交表单
                document.body.removeChild(toolForm);

                layer.close(index);
            });
        }else if(event === 'edit'){//重命名项目
            layer.prompt({
                formType: 0,
                value: '',
                title: '请输入新的项目名',
                maxlength: 100,
            },function x(value , index, elem){

                //创建input1,保存要执行的方法。
                var input1=document.createElement("input");
                input1.type="hidden";
                input1.name="method"
                input1.value="editProject";
                toolForm.appendChild(input1);

                //创建input4,保存要修改的项目名称。
                var input4=document.createElement("input");
                input4.type="hidden";
                input4.name="P_Name"
                input4.value=value;
                toolForm.appendChild(input4);

                //上传表单
                document.body.appendChild(toolForm);
                toolForm.submit(); //递交表单
                document.body.removeChild(toolForm);

                layer.close(index);
            });
        }else if(event==='detail'){//查看详情
            //修改表单指向
            toolForm.action="loadSensor.jsp";

            //上传表单
            document.body.appendChild(toolForm);
            toolForm.submit(); //递交表单
            document.body.removeChild(toolForm);

            layer.close(index);
        }
    });
</script>

<%--新建项目--%>
<script>
    function createProject(){
        var $ =layui.jquery
        layer.open({
            type: 1,
            title: '新建项目',
            shadeClose: true,
            shade: 0.5,
            area: ['500px', '280px'],
            content: $('#biaodan'),
        });
    }
</script>

</html>
