<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: tangfuqiang
  Date: 2017/12/3
  Time: 上午12:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>

<head>
    <title>用户分析</title>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>css/style.css">
    <script type="text/javascript" src="<%=basePath%>js/chart.js"></script>
</head>

<body>

<form onsubmit="return">

    <div class="head">
        <img src="<%=basePath%>images/logo.png" class="img_head">
        <span class="title">用户管理系统</span>
        <div class="div_option">
            <a href="#" class="a_option_exit">退出</a>
            <a href="#" class="a_option_help">帮助</a>
        </div>
    </div>
    <div class="left">
        <p><a href="<%=basePath%>index/backoruserlist" class="left_a">用户查询</a></p>
        <hr>
        <p class="left_p2"><a href="<%=basePath%>index/toaddpage" class="left_a">用户新增</a></p>
        <hr>
        <p class="left_p2" style="background-color: #C3C3C3"><a href="<%=basePath%>index/tochartpage" class="left_a">用户分析</a></p>
        <img src="<%=basePath%>images/logo.png" class="left_img">
        <p><a href="#" class="login">当前用户登录</a></p>
    </div>
    <div class="main">
        <br>
        <div class="pie" style="width: 300px">
            <canvas id="myChartpie" width="300px" height="300px"></canvas>
        </div>
        <div class="line">
            <canvas id="myChartline" width="500" height="300"></canvas>
        </div>
    </div>
    <script>
        var sex=new Array();
        var sextotal=new Array();

        var year = new Array();
        var yeartotal = new Array();
        <c:forEach items="${sexlist}" var="sex">
        sex.push('${sex.sex}');
        sextotal.push('${sex.total}');
        </c:forEach>

        <c:forEach items="${yearlist}" var="year">
        year.push('${year.year}')
        yeartotal.push('${year.total}')
        </c:forEach>
        var ctxpie = document.getElementById('myChartpie').getContext('2d');
        // The type of chart we want to create
        var myChartpie = new Chart(ctxpie, {
            type: 'pie',
            data: {
                labels: sex,
                datasets: [{
                    data: sextotal,
                    backgroundColor: [
                        'rgba(255, 99, 132, 0.2)',
                        'rgba(54, 162, 235, 0.2)',
                    ],
                    borderColor: [
                        'rgba(255,99,132,1)',
                        'rgba(54, 162, 235, 1)',
                    ],
                }]
            },
            options: {
                title: {
                    display: true,
                    text: '用户性别分布'
                },
                hover: {
                    mode: 'nearest',
                    intersect: true
                },
            }
        });

        //曲线图
        var ctxline = document.getElementById('myChartline').getContext('2d');
        var myChartline = new Chart(ctxline, {
            type: 'line',
            data: {
                labels: year,
                datasets: [{

                    label: "数量",
                    data: yeartotal,
                    backgroundColor: [
                        'rgba(255, 99, 132, 0.2)',
                    ],
                    borderColor: [
                        'rgba(105,14,12,1)',

                    ],
                }]
            },
            options: {
                responsive: true,
                title: {
                    display: true,
                    text: '用户生日分布'
                },
                tooltips: {
                    mode: 'index',
                    intersect: false,
                },

                hover: {
                    mode: 'nearest',
                    intersect: true
                },
            }
        });
    </script>
</form>
</body>

</html>
