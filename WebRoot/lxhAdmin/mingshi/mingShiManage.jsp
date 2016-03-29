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
    <title>培训名师</title>
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
            <span>所在位置：培训/名师</span>
        </div>
    </div>
</div>
<div class="container" id="lieBiao">
    <div class="row peiXunMingShi">
        <div class="col-md-10 col-md-offset-1 paiXu">
            <div class="col-sm-6">
                <ul class="nav nav-pills">
                    <li class="lieBiaoMingCheng">培训名师</li>
                    <li role="presentation" class="active"><a href="#">综合排名</a></li>
                    <li role="presentation"><a href="#">雅思</a></li>
                    <li role="presentation"><a href="#">托福</a></li>
                    <li role="presentation"><a href="#">SAT</a></li>
                </ul>
            </div>
            <div class="col-sm-6 text-right">
                <form class="form-inline" id="searchByName"  method="post">
                    <input type="text" class="form-control" placeholder="" id="search-name" name="search-name">
                    <button class="btn btn-primary" type="button" id="search-name-button">搜索名师</button>
                </form>
            </div>
        </div>
        <div class="col-md-10 col-md-offset-1 head-search">
            <hr>
            <div class="search-tiaoJian text-center">
            	<a href="${path}/lxhAdmin/mingshi/addMingShi.jsp" class="btn btn-default" target="_blank">添加培训名师</a>
            </div>
        </div>
        <div class="col-md-10 col-md-offset-1">
        
        	<c:forEach items="${mingShiList}" var="mingShi" varStatus="status">
        		<div class="col-sm-12 mingshi-content">
	                <div class="col-sm-5 text-center content-img">
	                    <a href="${path}/mingshi/content.shtml?mingShiGuid=${mingShi.guid}">
	                    	<img src="${path}/static/uploadImg/mingshi/liebiao/${mingShi.photoName}">
	                    </a>
	                </div>
	                <div class="col-sm-7 content-miaoShu">
	                    <h4>${mingShi.name}</h4>
	                    <p><span class="miaoshu-title">名师介绍：</span>${mingShi.jianJie}</p>
	                    <p><span class="miaoshu-title">人气：</span>${mingShi.renQi}</p>
	                    <p>
	                        <span class="miaoshu-title">评价：</span>
	                        <c:forEach  begin="1" end="${mingShi.xinJiPingJia}" >
	                        	<span class="glyphicon glyphicon-star" aria-hidden="true"></span>
							</c:forEach>
	                    </p>
	                    <div class="col-sm-12 text-center">
	                        <a class="btn btn-warning" href="${path}/mingshi/content.shtml?mingShiGuid=${mingShi.guid}" style="padding-left:20px;padding-right:20px;">风采详情</a>
	                        <a class="btn btn-success" href="${path}/mingshi/goUpdateMingShi.shtml?mingShiGuid=${mingShi.guid}" style="padding-left:20px;padding-right:20px;">修改</a>
	                        <a class="btn btn-danger delete" id="${mingShi.guid}" style="padding-left:20px;padding-right:20px;">删除</a>
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
        </div>
    </div>
</div>
<script src="${path}/static/js/jquery-1.11.0.js"></script>
<script src="${path}/static/js/bootstrap.min.js"></script>
<script>
    $(function(){
        $("#search-name-button").click(function(){
            var search_name = $.trim($("#search-name").val());
            //如果输入为空，跳出提示
            if(search_name==''){
                $(".modal-body p").text("输入要搜索名师的名字");
                $('#tiShi').modal({
                    keyboard: false
                });
            }else{
                $("#searchByName").submit();
            }
        });
        
        $(".delete").click(function(){
			var mingShiGuid = $(this).attr("id");
			if(confirm("确定要删除数据吗")){
				$.post("${path}/mingshi/delete.shtml",{"mingShiGuid":mingShiGuid},function(data){
					var msg = data.msg;
					if(msg=="success"){
						$("#"+mingShiGuid).parent().parent().parent().fadeOut("slow");
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
