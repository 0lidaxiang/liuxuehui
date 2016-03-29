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
    <title>用户中心-我的订单</title>
    <!-- Bootstrap -->
    <link href="<%=path %>/static/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=path %>/static/css/user.css" rel="stylesheet">

    <!--[if lt IE 9]>
    <script src="<%=path %>/static/js/html5shiv.min.js"></script>
    <script src="<%=path %>/static/js/respond.min.js"></script>
    <![endif]-->

</head>
<body>
<jsp:include page="head.jsp"></jsp:include>
<div class="container main">
    <div class="row">
        <div class="col-xs-12 col-sm-3 col-md-3 left_nav text-center">
            <img src="<%=path %>/static/img/touxiang.jpg" for="exampleInputFile" class="img-circle touxiang">
            <ul class="nav nav-pills nav-stacked text-center left_nav_shu">
                <li role="presentation"><a href="user.jsp">基本信息</a></li>
                <li role="presentation" class="active"><a href="#">我的订单</a></li>
                <li role="presentation"><a href="cePing.jsp">留学测评</a></li>
            </ul>
            <ul class="nav nav-pills text-center left_nav_heng">
                <li role="presentation"><a href="user.jsp">基本信息</a></li>
                <li role="presentation" class="active"><a href="#">我的订单</a></li>
                <li role="presentation"><a href="cePing.jsp">留学测评</a></li>
            </ul>
        </div>
        <div class="col-xs-12 col-sm-9 col-md-9 right_content">
            <div class="row">
                <div class="col-md-12 content_dingDan">
                    <h4>我的代金券</h4>
                    <div class="table-responsive text-center">
                        <table class="table table-bordered">
                            <thead class="">
                                <tr>
                                    <td><strong>名称</strong></td>
                                    <td><strong>券码</strong></td>
                                    <td><strong>价格</strong></td>
                                    <td><strong>抵用金额</strong></td>
                                    <td><strong>下单时间</strong></td>
                                    <td><strong>订单状态</strong></td>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>留学代金券</td>
                                    <td>ehyd-yjsh-yjkk-ikju</td>
                                    <td>0</td>
                                    <td>￥1000</td>
                                    <td>2015-04-23</td>
                                    <td>未使用</td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


<jsp:include page="footer.jsp"></jsp:include>
<script src="<%=path %>/static/js/jquery-1.11.0.js"></script>
<script src="<%=path %>/static/js/bootstrap.min.js"></script>
<script>
    $(function(){

    });
</script>
</body>
</html>