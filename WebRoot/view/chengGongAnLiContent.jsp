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
    <title>成功案例-${student.name}</title>
    <!-- Bootstrap -->
    <link href="${path}/static/css/bootstrap.min.css" rel="stylesheet">
    <link href="${path}/static/css/chengGongAnLi.css" rel="stylesheet">

    <!--[if lt IE 9]>
    <script src="${path}/staticjs/html5shiv.min.js"></script>
    <script src="${path}/staticjs/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<jsp:include page="head.jsp"></jsp:include>
<div id="student-ziLiao" class="carousel slide" data-ride="carousel">
    <div class="carousel-inner" role="listbox">
        <div class="item active">
            <div class="container anLi">
                <div class="row">
                    <div class="col-sm-6 col-md-6 text-center">
                        <img src="${path}/static/uploadImg/xuesheng/liebiao/${student.photoName}" class="img-rounded">
                    </div>
                    <div class="col-sm-6 col-md-6 ziLiao">
                        <h3>${student.name}</h3>
                        <div>
                            <span class="ming">学校专业：</span><span class="result">${studentContent.xueXiao} ${studentContent.zhuanYe}</span>
                        </div>
                        <div>
                            <span class="ming">平均成绩：</span><span class="result">${studentContent.pingJunChengJi}</span>
                        </div>
                        <div>
                            <span class="ming">语言成绩：</span><span class="result">${student.chengJi}</span>
                        </div>
                        <div>
                            <span>offer：</span><span>${student.offer}</span>
                        </div>
                        <div>
                            <span>进入院校：</span><span>${student.jinRuXueXiao}</span>
                        </div>
                        <div>
                            <span>留学顾问：</span><span><a href="#"></a></span>
                        </div>
                        <div>
                            <span>留学文案：</span><span><a href="#"></a></span>
                        </div>
                        <div>
                            <span>培训名师：</span><span><a href="#"></a></span>
                        </div>
                    </div>
                    <div class="col-md-10 col-md-offset-1 anLiMingXi">
                        <div>
                            <span>案例简介</span>
                            <p>${studentContent.anLiJianJie}</p>
                        </div>
                        <div>
                            <span>案例分析</span>
                            <p>
                                ${studentContent.anLiFenXi}
                            </p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- 左右箭头-->
    <a class="left carousel-control" href="#student-ziLiao" role="button" data-slide="prev">
        <span class="sr-only"></span>
    </a>
    <a class="right carousel-control" href="#student-ziLiao" role="button" data-slide="next">
        <span class="sr-only"></span>
    </a>
</div>
<jsp:include page="footer.jsp"></jsp:include>
<script src="${path}/static/js/jquery-1.11.0.js"></script>
<script src="${path}/static/js/bootstrap.min.js"></script>
</body>
</html>