<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%
String path = request.getContextPath();
request.setAttribute("path",path);
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head lang="zh-CN">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>${keCheng.name}</title>
    <!-- Bootstrap -->
    <link href="${path}/static/css/bootstrap.min.css" rel="stylesheet">
    <link href="${path}/static/css/keChengContent.css" rel="stylesheet">

    <!--[if lt IE 9]>
    <script src="${path}/static/js/html5shiv.min.js"></script>
    <script src="${path}/static/js/respond.min.js"></script>
    <![endif]-->

</head>
<body>
<jsp:include page="../adminNav.jsp"></jsp:include>
<div class="container">
    <ol class="breadcrumb">
        <li><a href="${path}/lxhAdmin/adminIndex.jsp">首页</a></li>
        <li><a href="${path}/kecheng/more.shtml?pageNo=1">特色课程</a></li>
        <li class="active">雅思钻石7分课程</li>
    </ol>
    <div class="row">
        <div class="col-md-8 col-md-offset-2 keChengContent">
            <div class="text-center">
                <h2>${keCheng.name}</h2>
            </div>
            <div>
                <h3>班级名称：</h3>
                <p>${keCheng.name}</p>
            </div>

            <div>
                <h3>使用教材：</h3>
                <p>
                    ${keChengContent.jiaoCai }
                </p>
            </div>
            <div>
                <h3>适合对象：</h3>
                <p>
                    ${keChengContent.shiHeDuiXiang}
                </p>
            </div>
            <div>
                <h3>保分承诺：</h3>
                <p>
                    ${keChengContent.baoFenChengNuo }
                </p>
            </div>
            <div>
                <h3>案例分析：</h3>
                <p>
                	${keChengContent.keChengFenXi }
                </p>
            </div>
        </div>
    </div>
</div>

<jsp:include page="../adminFooter.jsp"></jsp:include>
<script src="${path}/static/js/jquery-1.11.0.js"></script>
<script src="${path}/static/js/bootstrap.min.js"></script>
</body>
</html>