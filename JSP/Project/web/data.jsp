<%@ page import="java.util.ArrayList" %>
<%@ page import="com.entity.Data" %>
<%@ page import="com.entity.Sensor" %>
<%--
  Created by IntelliJ IDEA.
  User: zsy
  Date: 2022/5/20
  Time: 9:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Title</title>
    <link rel="stylesheet" href="layui/css/layui.css">
</head>
<body>

<%
    ArrayList<Data> dataList=(ArrayList<Data>)session.getAttribute("DataList");
    Sensor sensor=(Sensor) session.getAttribute("sensor");

    if(dataList.size()==0){
        %><jsp:forward page="error.jsp"/><%
    }

    //拆分第一条数据的时间
    String str=dataList.get(0).getDatetime();
    String[] strSpilt=str.split(" ");
    String[] date=strSpilt[0].split("-");
    String[] time=strSpilt[1].split(":");
    //获取所有数据保存到data
    StringBuilder data=new StringBuilder();
    for(int i=1;i<dataList.size();i++){
        data.append(dataList.get(i).getValue()).append(",");
    }
%>

<div class="layui-panel" style="padding: 10px 20px;">
    <H2>传感器信息<a href="sensor?method=delSensor&S_ID=<%=sensor.getS_ID()%>"><i class="layui-icon layui-icon-more-vertical"></i></a></H2>
</div>
<div class="layui-panel" style="padding: 10px 20px;">
    <table class="layui-table" lay-skin="nob" >
        <colgroup>
            <col width="120">
            <col>
        </colgroup>
        <tbody>
        <tr>
            <td>传感器名</td>
            <td><%=sensor.getS_Name()%></td>
        </tr>
        <tr>
            <td>标识符</td>
            <td><%=sensor.getS_Tag()%></td>
        </tr>
        <tr>
            <td>序列号</td>
            <td><%=sensor.getS_Serial()%></td>
        </tr>
        </tbody>
    </table>
</div>

<div class="layui-panel" style="padding: 20px 20px;">
    <!-- 为 ECharts 准备一个定义了宽高的 DOM -->
    <div id="main" style="width: 750px;height:550px;"></div>
</div>


<%--引用echarts--%>
<script src="echarts/echarts.min.js" charset="utf-8"></script>

<%--引用layui.js--%>
<script src="layui/layui.js" charset="utf-8"></script>


<%--渲染图表--%>
<script type="text/javascript">

    let myChart = echarts.init(document.getElementById('main'));
    let base = +new Date(<%=date[0]%>,<%=date[1]%>-1,<%=date[2]%>,<%=time[0]%>,<%=time[1]%>,<%=time[2]%>);
    //30秒
    let frequency =2*1000;
    let d = [<%=data.toString()%>];
    let data = [[base, d[0]]];

    for (let i = 1; i < <%=dataList.size()%>; i++) {
        let now = new Date((base += frequency));
        data.push([+now,  d[i]]);
    }

    option = {
        tooltip: {
            trigger: 'axis',
            position: function (pt) {
                return [pt[0], '10%'];
            }
        },
        title: {
            left: 'center',
            text: '<%=sensor.getS_Name()%>可视化'
        },
        toolbox: {
            feature: {
                dataZoom: {
                    yAxisIndex: 'none'
                },
                magicType: { type: ['line', 'bar'] },
                restore: {},
                saveAsImage: {}
            }
        },
        xAxis: {
            type: 'time',
        },
        yAxis: {
            type: 'value',
            boundaryGap: [0, '100%']
        },
        dataZoom: [
            {
                type: 'inside',
                start: 0,
                end: 20
            },
            {
                start: 0,
                end: 20
            }
        ],
        series: [
            {
                name: '<%=sensor.getM_Name()%>(<%=sensor.getM_Unit()%>)',
                type: 'line',
                symbol: 'none',
                data: data
            }
        ]
    };
    myChart.setOption(option);
</script>
</html>
