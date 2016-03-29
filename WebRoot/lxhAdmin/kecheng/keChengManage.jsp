<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
    <title>特色课程</title>
    <!-- Bootstrap -->
    <link href="${path}/static/css/bootstrap.min.css" rel="stylesheet">
    <link href="${path}/static/css/liebiao2.css" rel="stylesheet">

    <!--[if lt IE 9]>
    <script src="${path}/static/js/html5shiv.min.js"></script>
    <script src="${path}/static/js/respond.min.js"></script>
    <![endif]-->

</head>
<body>
<jsp:include page="../adminNav.jsp"></jsp:include>
<div class="container">
    <div class="row weiZhi">
        <div class="col-md-10 col-md-offset-1">
            <span>所在位置：特色课程</span>
        </div>
    </div>
</div>
<div class="container" id="lieBiao">
    <div class="row teSeKeCheng">
        <div class="col-md-10 col-md-offset-1 head-search">
            <hr>
            <div class="search-tiaoJian">
                <div class="col-md-4 text-center">
                    <form class="form-inline" method="post" id="searchByName">
                        <input type="text" class="form-control" placeholder="输入课程名称搜索" id="search-name" name="search-name">
                        <button class="btn btn-primary" type="button" id="search-name-button">搜索</button>
                    </form>
                </div>
                <div class="col-md-8 text-center">
                    <form class="form-inline" method="post" id="searchByTime">
                        <input type="text" class="form-control" placeholder="开始时间" id="begin-time" name="begin-time">
                        <label>&nbsp;-&nbsp;</label>
                        <input type="text" class="form-control" placeholder="结束时间" id="end-time" name="end-time">
                        <button class="btn btn-primary" type="button" id="search-time-button">查找</button>
                    </form>
                </div>
            </div>
            <div class="search-tiaoJian text-center">
            	<a href="${path}/lxhAdmin/kecheng/addKeCheng.jsp" class="btn btn-default" target="_blank">添加课程</a>
            </div>
        </div>
        <div class="col-md-10 col-md-offset-1 keChneg">
        	<c:forEach items="${keChengList}" var="keCheng" varStatus="status">
        		<div class="col-sm-6 col-md-4 kecheng-content">
	                <div class="thumbnail">
	                    <a href="${path}/kecheng/content.shtml?keChengGuid=${keCheng.guid}">
	                    	<img src="${path}/static/uploadImg/kecheng/liebiao/${keCheng.photoName}" alt="${keCheng.name}">
	                    </a>
	                    <div class="caption">
	                        <p>${keCheng.jianjie}</p>
	                        <p>开课时间：<fmt:formatDate value="${keCheng.beginTime}" pattern="yyyy-MM-dd"/></p>
	                    </div>
	                    <div class="caption text-center">
	                        <a href="${path}/kecheng/content.shtml?keChengGuid=${keCheng.guid}" class="btn btn-default" style="padding:4px 8px 4px 8px">立即报名</a>
	                        <a href="${path}/kecheng/goUpdateKeCheng.shtml?keChengGuid=${keCheng.guid}" class="btn btn-success" style="padding:4px 8px 4px 8px">修改</a>
	                        <a class="btn btn-danger delete" style="padding:4px 8px 4px 8px" id="${keCheng.guid}">删除</a>
	                    </div>
	                </div>
	            </div>
        	</c:forEach>

        </div>

    </div>
    <c:import url="/view/page.jsp"></c:import>
</div>


<jsp:include page="../adminFooter.jsp"></jsp:include>
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
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div>
<script src="${path}/static/js/jquery-1.11.0.js"></script>
<script src="${path}/static/js/bootstrap.min.js"></script>
<script>
    $(function(){
        $("#search-name-button").click(function(){
            var search_name = $.trim($("#search-name").val());
            //如果输入为空，跳出提示
            if(search_name==''){
                $(".modal-body p").text("输入要搜索的课程名称");
                $('#tiShi').modal({
                    keyboard: false
                });
            }else{
                $("#searchByName").submit();
            }
        });
        
        $(".delete").click(function(){
			var keChengGuid = $(this).attr("id");
			if(confirm("确定要删除数据吗")){
				$.post("${path}/kecheng/delete.shtml",{"keChengGuid":keChengGuid},function(data){
					var msg = data.msg;
					if(msg=="success"){
						$("#"+keChengGuid).parent().parent().parent().fadeOut("slow");
					}else if(msg=="fail"){
						alert("系统异常，删除失败");
					}
				});
			}
		});
    });
</script>
</body>
</html>