<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
    <title>${guWen.name}</title>
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
            <span>所在位置：<a href="${path}/guwen/more.shtml?pageNo=1">咨询顾问</a>/${guWen.name}</span>
        </div>
    </div>
</div>
<div class="container" id="content">
    <div class="col-md-10 col-md-offset-1 image-content">
        <div class="col-sm-8">
            <div class="thumbnail"><div class="big-img"></div></div>
            <div class="tab">
                顾问介绍
            </div>
            <div class="text-content">
                <div class="jieShao">
                    <p>${guWenContent.jieShao}</p>
                </div>
                <hr>
                <div class="jieShao">
                    <p>电话：${guWenContent.dianHua}</p>
                    <p>QQ：${guWenContent.QQ}</p>
                    <p>微信：${guWenContent.weiXin}</p>
                    <p>博客：<a href="${guWenContent.boKeUrl}">${guWenContent.boKeUrl}</a></p>
                </div>
            </div>
        </div>
        <div class="col-sm-4">
            <div class="right-img"></div>
        </div>
    </div>
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
<script type="text/javascript">
	$(function(){
		$(".big-img").css("background-image","url(${path}/static/uploadImg/guwen/content/${guWenContent.pictureName})");
	});
</script>
</body>
</html>