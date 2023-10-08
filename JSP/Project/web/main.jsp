<%--
  Created by IntelliJ IDEA.
  User: zsy
  Date: 2022/5/9
  Time: 16:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>首页-环境数据可视化系统</title>
    <link rel="stylesheet" href="layui/css/layui.css"/>
    <link rel="stylesheet" href="css/main.css"/>
<head/>
<body>
<jsp:include page="navBar.jsp"/>

<div class="layui-carousel " id="carousel1">
    <div carousel-item>
        <div style="background: url(img/carousel1.png)center top / auto 100% no-repeat;">

        </div>
        <div style="background: url(img/carousel2.png)center top / auto 100% no-repeat;">

        </div>
        <div style="background: url(img/carousel3.png)center top / auto 100% no-repeat;">

        </div>
        <div style="background: url(img/carousel4.png)center top / auto 100% no-repeat;">

        </div>
        <div style="background: url(img/carousel5.png)center top / auto 100% no-repeat;">

        </div>
    </div>
</div>

<div class="layui-container">
    <div class="layui-row">
        <div style="text-align: center;margin: 20px">
            <span class="product-title">为什么选择我们?</span>
        </div>
        <div>
            <span class="product-subtitle">技术优势</span>
        </div>
        <div class="layui-row layui-col-space16" style="margin-top: 10px">
            <div class="layui-col-md3" >
                <div class="layui-panel card">
                    <div class="card-item">
                        <img class="card-img" src="img/huaweicloud-iotecology.png">
                        <br><p style="margin-top: 58px">开放的物联网生态</p>
                    </div>
                </div>
            </div>
            <div class="layui-col-md3">
                <div class="layui-panel card">
                    <div class="card-item">
                        <img class="card-img"src="img/huaweicloud-iotintelligence.png">
                        <br><p style="margin-top: 58px">高效的物联网智能</p>
                    </div>
                </div>
            </div>
            <div class="layui-col-md3">
                <div class="layui-panel card">
                    <div class="card-item">
                        <img class="card-img"src="img/huaweicloud-iotsafe.png">
                        <br><p style="margin-top: 58px">安全可信的万物互联</p>
                    </div>
                </div>
            </div>
            <div class="layui-col-md3">
                <div class="layui-panel card">
                    <div class="card-item">
                        <img class="card-img" src="img/huaweicloud-iotexperience.png">
                        <br><p style="margin-top: 58px">全栈全场景的体验</p>
                    </div>
                </div>
            </div>
        </div>
        <div style="text-align: center;margin: 20px">
            <span class="product-title">提供多种关键的行业数字引擎</span>
        </div>
        <div>
            <span class="product-subtitle">IoT行业数字引擎</span>
        </div>
        <div class="layui-row layui-col-space16" style="margin-top: 10px">
            <div class="layui-col-md4" >
                <div class="layui-panel">
                    <img class=" list-img" src="img/O1CN01b9FaG01vooGadQZEO_!!6000000006220-2-tps-760-520.png">
                    <div class="list-title-bg">
                        <div class="list-title">数字商业引擎</div>
                    </div>
                </div>
            </div>
            <div class="layui-col-md4" >
                <div class="layui-panel">
                    <img class=" list-img" src="img/O1CN01GnB3CN21mPtDPprnG_!!6000000007027-2-tps-760-520.png">
                    <div class="list-title-bg">
                        <div class="list-title">数字农业引擎</div>
                    </div>
                </div>
            </div>
            <div class="layui-col-md4" >
                <div class="layui-panel">
                    <img class=" list-img" src="img/O1CN01MhioXz22YxsEKZBcR_!!6000000007133-2-tps-760-520.png">
                    <div class="list-title-bg">
                        <div class="list-title">数字城市引擎</div>
                    </div>
                </div>
            </div>
            <div class="layui-col-md4" >
                <div class="layui-panel">
                    <img class=" list-img" src="img/O1CN01XsUvVi1MHpBjjcuAk_!!6000000001410-2-tps-760-520.png">
                    <div class="list-title-bg">
                        <div class="list-title">数字工业引擎</div>
                    </div>
                </div>
            </div>
            <div class="layui-col-md4" >
                <div class="layui-panel">
                    <img class=" list-img" src="img/O1CN01Znxj591voLrvrWfXJ_!!6000000006219-2-tps-760-520.png">
                    <div class="list-title-bg">
                        <div class="list-title">数字园区引擎</div>
                    </div>
                </div>
            </div>
            <div class="layui-col-md4" >
                <div class="layui-panel">
                    <img class=" list-img" src="img/O1CN016KXdeu1Z8HwqQJLin_!!6000000003149-2-tps-760-520.png">
                    <div class="list-title-bg">
                        <div class="list-title">数字商业引擎</div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<jsp:include page="footer.jsp"/>
<body/>
<script src="layui/layui.js"></script>
<script>
    layui.use('carousel', function(){
        var carousel = layui.carousel;
        //建造实例
        carousel.render({
            elem: '#carousel1'
            ,width: '100%' //设置容器宽度
            ,height: '382px'
            ,arrow: 'hover' //始终显示箭头
            ,indicator: 'inside'
        });
    });
</script>
