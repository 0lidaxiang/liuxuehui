<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
    <title>留学机构</title>
    <!-- Bootstrap -->
    <link href="<%=path %>/static/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=path %>/static/css/content2.css" rel="stylesheet">

    <!--[if lt IE 9]>
    <script src="<%=path %>/static/js/html5shiv.min.js"></script>
    <script src="<%=path %>/static/js/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<jsp:include page="head.jsp"></jsp:include>
<div class="container">
    <div class="row weiZhi">
        <div class="col-md-10 col-md-offset-1">
            <span>所在位置：<a href="#">留学机构</a>/新东方</span>
        </div>
    </div>
</div>
<div class="container" id="content">
    <div class="col-md-10 col-md-offset-1 image-content">
        <div class="col-sm-8">
            <div class="thumbnail"><div class="big-img"></div></div>
            <div class="tab">
                机构介绍
            </div>
            <div class="text-content">
                <div class="jieShao">
                    <p>新东方前途出国是新东方旗下从事出国留学服务的专职机构，创办于1996年。业务涵盖美国留学、英国留学、加拿大留学、澳新留学、欧亚留学等国家"一站式"留学服务。前途出国目前在全国开设30多家分公司，秉承"权威、专业、诚信"的理念，帮助数十万学员实现留学梦！农家菜都能接受才能你就从地上你才能到数据库你就从地上南京考你就从开始你看才能到数据库你就穿三角裤年进出口撒即可内存接口三年产假卡萨好踩死你角川书店你就从地上</p>
                </div>
                <hr>
                <div class="jieShao">
                    <p>电话：67674747</p>
                    <p>地址：南京市好看路779号</p>
                </div>
            </div>
        </div>
        <div class="col-sm-4">
            <div class="right-img"></div>
        </div>
    </div>
</div>


<div class="container-fluid text-center dengLuZhuCe">
    <h1>现在开始加入留学慧，开启海外留学之旅</h1>
    <a class="btn btn-warning" href="#" role="button">马上注册</a>
    <a class="btn btn-success" href="#" role="button">立即登录</a>
</div>
<!--提示窗口-->
<div class="modal fade" id="tiShi">
    <div class="modal-dialog modal-sm">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">提示</h4>
            </div>
            <div class="modal-body">
                <p></p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
            </div>
        </div>
    </div>
</div>

<jsp:include page="footer.jsp"></jsp:include>
<script src="<%=path %>/static/js/jquery-1.11.0.js"></script>
<script src="<%=path %>/static/js/bootstrap.min.js"></script>
</body>
</html>