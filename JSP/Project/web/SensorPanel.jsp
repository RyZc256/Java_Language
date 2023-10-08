<%@ page import="java.util.ArrayList" %>
<%@ page import="com.entity.Sensor" %>
<%@ page import="com.entity.Project" %><%--
  Created by IntelliJ IDEA.
  User: zsy
  Date: 2022/5/12
  Time: 10:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Title</title>
    <link rel="stylesheet" href="layui/css/layui.css"/>
    <link rel="stylesheet" href="css/main.css"/>
</head>

<body>

<jsp:include page="navBar.jsp"/>

<%
    ArrayList<Sensor> sensorList =(ArrayList<Sensor>) session.getAttribute("sensorList");
    Project project = (Project) session.getAttribute("project");
%>
<div class="layui-container">

    <div class="layui-row layui-col-space10" style="padding: 30px 0;">
        <div class="layui-col-md3">
            <div class="layui-panel" style="padding: 10px 20px;">
                <h2><%=project.getP_Name()%><button style="float: right" class="layui-btn layui-btn-sm" onclick=addSensor() ><i class="layui-icon layui-icon-add-1"></i></button></h2>

            </div>

            <div class="layui-panel">

                <table lay-filter="SensorTable">
                    <thead>
                        <tr>
                            <th lay-data="{field:'S_ID',width:60,sort:true}">ID</th>
                            <th lay-data="{field:'S_Name',sort:true}">传感器</th>
                            <th lay-data="{fixed:'right', width:115,toolbar: '#bar'}">编辑</th>
                        </tr>
                    </thead>
                    <tbody>
                    <%
                        for(Sensor s:sensorList){
                            %><tr>
                                <td><%=s.getS_ID()%></td>
                                <td><%=s.getS_Name()%></td>
                                <td></td>
                            </tr><%
                        }
                    %>
                    </tbody>
                </table>
            </div>
        </div>
        <div class="layui-col-md9">
            <div class="layui-panel">
                <div class="layui-tab layui-tab-brief" lay-allowClose="true" lay-filter="demo">
                    <ul class="layui-tab-title">
                        <li class="layui-this" lay-id="1">Test1</li>
                    </ul>
                    <div class="layui-tab-content">
                        <div class="layui-tab-item layui-show">Test1</div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<%--编辑传感器名表单--%>
<div style="padding: 25px 0;display: none;" id="edit">
    <div class="layui-row" >
        <div class="layui-col-xs11">
            <form class="layui-form" method="post" action="sensor">
                <input type="hidden" name="method" value="editSensor">
                <input type="hidden" name="S_ID" id="sid">
                <div class="layui-form-item">
                    <label class="layui-form-label">传感器名</label>
                    <div class="layui-input-block">
                        <input name="S_Name" class="layui-input" id="s_name" required="required" placeholder="请输入新传感器名" type="text">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">标识符</label>
                    <div class="layui-input-block">
                        <input name="S_Tag" class="layui-input" placeholder="请输入新标识符" type="text">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">序列号</label>
                    <div class="layui-input-block">
                        <input name="S_Serial" class="layui-input" placeholder="请输入新序列号" type="text">
                    </div>
                </div>

                <br>
                <div class="layui-form-item">
                    <div class="layui-input-block" style="margin-left: 63%">
                        <button name="submit" class="layui-btn-normal layui-btn" onclick="x()" <%--type="submit"--%> >提交</button>
                        <button name="reset" class="layui-btn layui-btn-primary" type="reset">重置</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>

<%--新建传感器名表单--%>
<div style="padding: 25px 0;display: none;" id="add">
    <div class="layui-row" >
        <div class="layui-col-xs11">
            <form class="layui-form" method="post" action="sensor">
                <input type="hidden" name="method" value="addSensor">
                <input type="hidden" name="P_ID" value=<%=project.getP_ID()%>>
                <div class="layui-form-item">
                    <label class="layui-form-label">传感器名称</label>
                    <div class="layui-input-block">
                        <input name="S_Name" class="layui-input" required="required" placeholder="请输入传感器名" type="text">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">标识符</label>
                    <div class="layui-input-block">
                        <input name="S_Tag" class="layui-input" required="required" placeholder="请输入标识符" type="text">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">序列号</label>
                    <div class="layui-input-block">
                        <input name="S_Serial"  class="layui-input" required="required" placeholder="请输入序列号" type="text">
                    </div>
                </div>

                <div class="layui-form-item">
                    <label class="layui-form-label">传感器类型</label>
                    <div class="layui-input-block">
                        <select required="required" name="M_ID">
                            <option value="100">温度</option>
                            <option value="101">湿度</option>
                            <option value="104">人体</option>
                            <option value="105">光照</option>
                            <option value="106">空气质量</option>
                            <option value="107">可燃气体</option>
                            <option value="108">火焰</option>
                        </select>
                    </div>
                </div>
                <br><br><br><br><br><br><br><br><br><br><br><br><br><br>
                    <div class="layui-input-block" style="margin-left: 63%">
                        <button name="submit" class="layui-btn-normal layui-btn" onclick="x()" <%--type="submit"--%> >提交</button>
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

<%--新建传感器--%>
<script>
    function addSensor(){
        var $ =layui.jquery
        layer.open({
            type: 1,
            title: '新建传感器',
            shadeClose: true,
            shade: 0.5,
            area: ['500px', '600px'],
            content: $('#add'),
        });
    }
</script>

<%--工具条内容--%>
<script type="text/html" id="bar">
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-xs layui-btn-danger" lay-event="del">删除</a>
</script>

<%--渲染表格--%>
<script>
    let table = layui.table;
    //转换静态表格
    table.init('SensorTable', {
        height: 450 //设置高度
        ,limit: 10 //注意：请务必确保 limit 参数（默认：10）是与你服务端限定的数据条数一致
        ,page:true
    });
</script>

<%--新建tab--%>
<script>
    layui.use('element', function(){
        let element = layui.element;
        table.on('rowDouble(SensorTable)', function(obj){//表格双击事件
            //删除id为1的窗口
            element.tabDelete('demo','1');
            console.log(obj.tr) //得到当前行元素对象
            console.log(obj.data) //得到当前行数据
            let data=obj.data;
            element.tabAdd('demo', {
                title: data.S_Name,
                content:'<iframe width="100%" height="800px" id="ifr"></iframe>',
                id: '1',
            });
            document.getElementById("ifr").src="loadData.jsp?S_ID="+data.S_ID;
            //切换到id为1的窗口
            element.tabChange('demo', '1');
        });
    });
</script>

<%--工具条事件--%>
<script>
    var data;
    table.on('tool(SensorTable)',function (obj){
        //获得当行数据
        data = obj.data;
        //获得lay-event对应的值
        var event = obj.event;

        //创建表单
        var toolForm = document.createElement("form");
        toolForm.method="post";
        toolForm.action="sensor";

        //创建input2,保存S_ID
        var input2=document.createElement("input");
        input2.type="hidden";
        input2.name="S_ID";
        input2.value=data.S_ID;
        toolForm.appendChild(input2);

        if(event === 'del'){//删除项目
            layer.confirm('是否确认删除，删除数据无法找回！',function (index){
                //创建input1,保存要执行的方法。
                var input1=document.createElement("input");
                input1.type="hidden";
                input1.name="method"
                input1.value="delSensor";
                toolForm.appendChild(input1);

                //上传表单
                document.body.appendChild(toolForm);
                toolForm.submit(); //递交表单
                document.body.removeChild(toolForm);

                layer.close(index);
            });
        }else if(event === 'edit'){//重命名项目
            document.getElementById("sid").value=data.S_ID;
            document.getElementById("s_name").value=data.S_Name;
            var $ =layui.jquery
            layer.open({
                type: 1,
                title: '新建项目',
                shadeClose: true,
                shade: 0.5,
                area: ['500px', '330px'],
                content: $('#edit'),
            });
        }
    });
</script>
</html>
