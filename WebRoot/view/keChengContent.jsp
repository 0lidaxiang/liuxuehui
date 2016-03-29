<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head lang="zh-CN">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>特色课程</title>
    <!-- Bootstrap -->
    <link href="<%=path %>/static/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=path %>/static/css/keChengContent.css" rel="stylesheet">

    <!--[if lt IE 9]>
    <script src="<%=path %>/static/js/html5shiv.min.js"></script>
    <script src="<%=path %>/static/js/respond.min.js"></script>
    <![endif]-->

</head>
<body>
<jsp:include page="head.jsp"></jsp:include>
<div class="container">
    <ol class="breadcrumb">
        <li><a href="index.html">首页</a></li>
        <li><a href="keCheng.html">特色课程</a></li>
        <li class="active">雅思钻石7分课程</li>
    </ol>
    <div class="row">
        <div class="col-md-8 col-md-offset-2 keChengContent">
            <div class="text-center">
                <h2>雅思钻石7分课程</h2>
            </div>
            <div>
                <h3>班级名称：</h3>
                <p>雅思钻石7分课程</p>
            </div>

            <div>
                <h3>使用教材：</h3>
                <p>
                    记得早先少年时，大家诚诚恳恳，说一句，是一句，清早上火车站，长街黑暗无行人，卖豆浆的小店冒着热气，从前的日色变得慢，车，马，邮件都慢
                </p>
            </div>
            <div>
                <h3>适合对象：</h3>
                <p>
                    学生基础大道6.5分，需要考到7分的学生，词汇量7500以上。
                </p>
            </div>
            <div>
                <h3>保分承诺：</h3>
                <p>
                    均分7分以上
                </p>
            </div>
            <div>
                <h3>案例分析：</h3>
                <p>
                    记得早先少年时，大家诚诚恳恳，说一句，是一句，清早上火车站，长街黑暗无行人，卖豆浆的小店冒着热气，从前的日色变得慢，车，马，邮件都慢，一生只够爱一个人，从前的锁也好看，钥匙精美有样子，你锁了，人家就懂了。
                    记得早先少年时，大家诚诚恳恳，说一句，是一句，清早上火车站，长街黑暗无行人，卖豆浆的小店冒着热气，从前的日色变得慢，车，马，邮件都慢，一生只够爱一个人，从前的锁也好看，钥匙精美有样子，你锁了，人家就懂了。
                    记得早先少年时，大家诚诚恳恳，说一句，是一句，清早上火车站，长街黑暗无行人，卖豆浆的小店冒着热气，从前的日色变得慢，车，马，邮件都慢，一生只够爱一个人，从前的锁也好看，钥匙精美有样子，你锁了，人家就懂了。
                    记得早先少年时，大家诚诚恳恳，说一句，是一句，清早上火车站，长街黑暗无行人，卖豆浆的小店冒着热气，从前的日色变得慢，车，马，邮件都慢，一生只够爱一个人，从前的锁也好看，钥匙精美有样子，你锁了，人家就懂了。
                </p>
            </div>
        </div>
    </div>
</div>

<jsp:include page="footer.jsp"></jsp:include>
<script src="<%=path %>/static/js/jquery-1.11.0.js"></script>
<script src="<%=path %>/static/js/bootstrap.min.js"></script>
</body>
</html>