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
    <title>培训学校</title>
    <!-- Bootstrap -->
    <link href="<%=path %>/static/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=path %>/static/css/liebiao2.css" rel="stylesheet">

    <!--[if lt IE 9]>
    <script src="<%=path %>/static/js/html5shiv.min.js"></script>
    <script src="<%=path %>/static/js/respond.min.js"></script>
    <![endif]-->
    
</head>
<body>
<jsp:include page="../adminNav.jsp"></jsp:include>
<div class="container">
    <div class="row weiZhi">
        <div class="col-md-10 col-md-offset-1">
            <span>所在位置：培训/学校</span>
        </div>
    </div>
</div>
<div class="container" id="lieBiao">
    <div class="row peiXunXueJiao">
        <div class="col-md-10 col-md-offset-1 paiXu">
            <div class="col-sm-6">
                <ul class="nav nav-pills">
                    <li class="lieBiaoMingCheng">培训学校</li>
                    <li role="presentation" class="active"><a href="#">综合排名</a></li>
                    <li role="presentation"><a href="#">雅思</a></li>
                    <li role="presentation"><a href="#">托福</a></li>
                    <li role="presentation"><a href="#">SAT</a></li>
                </ul>
            </div>
            <div class="col-sm-6 text-right">
                <form class="form-inline" id="searchXueXiaoByName" method="post">
                    <input type="text" class="form-control" placeholder="" id="search-name" name="search-name">
                    <button class="btn btn-primary" type="button" id="search-name-button">搜索学校</button>
                </form>
            </div>
        </div>
        <div class="col-md-10 col-md-offset-1 head-search">
            <hr>
            <div class="search-tiaoJian text-center">
            	<a href="${path}/lxhAdmin/xuexiao/addXueXiao.jsp" class="btn btn-default" target="_blank">添加培训学校</a>
            </div>
        </div>
        <div class="col-md-10 col-md-offset-1">
            <div id="big-image" class="carousel slide" data-ride="carousel">
                <!--<ol class="carousel-indicators">-->
                    <!--<li data-target="#big-image" data-slide-to="0" class="active"></li>-->
                <!--</ol>-->
                <div class="carousel-inner thumbnail" role="listbox">
                    <div class="item active">
                        <img src="<%=path %>/static/img/xuexiao_big.jpg" alt="...">
                        <div class="carousel-caption">

                        </div>
                    </div>
                </div>
                <a class="left carousel-control" href="#big-image" role="button" data-slide="prev">
                    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                    <span class="sr-only">Previous</span>
                </a>
                <a class="right carousel-control" href="#big-image" role="button" data-slide="next">
                    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                    <span class="sr-only">Next</span>
                </a>
            </div>
        </div>
        <div class="col-md-10 col-md-offset-1">
            <div class="col-sm-9 lieBiao">
            
            	<c:forEach items="${xueXiaoList}" var="xueXiao" varStatus="status">
            		<div class="lieBiao-content">
	                    <div class="name">
	                        <a href="${path}/xuexiao/content.shtml?xueXiaoGuid=${xueXiao.guid}">
	                            <span class="cn-name">${xueXiao.name}</span>
	                            <span class="english-name">${xueXiao.engLishName}</span>
	                        </a>
	                        <a class="btn btn-success" href="${path}/xuexiao/goUpdateXueXiao.shtml?xueXiaoGuid=${xueXiao.guid}" style="padding: 2px 8px 2px 8px;">修改</a>
	                        <a class="btn btn-danger delete" id="${xueXiao.guid}" style="padding: 2px 8px 2px 8px;">删除</a>
	                    </div>
	                    <div class="content">
	                        <div class="col-sm-4 text-center content-img">
	                            <a href="${path}/xuexiao/content.shtml?xueXiaoGuid=${xueXiao.guid}">
	                                <img src="${path}/static/uploadImg/xuexiao/liebiao/${xueXiao.photoName}" class="img-rounded"/>
	                            </a>
	                        </div>
	                        <div class="content-miaoShu">
	                            <p>
	                                ${xueXiao.jianjie}
	                            </p>
	                        </div>
	                    </div>
	                </div>
            	</c:forEach>
                
                
            </div>
            <!-- 院校搜索 -->
            <div class="col-sm-3 search-div">
                <span>院校搜索</span>
                <div class="col-md-12 search">
                    <form  method="post">
                        <div class="form-group">
                            <label for="leiXing">院校类型</label>
                            <select class="form-control" name="yuanXiaoLeiXing" id="leiXing">
                                <option value="gongLi">公立</option>
                                <option value="siLi">私立</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="diQu">院校类型</label>
                            <select class="form-control" name="yuanXiaoDiQu" id="diQu">
                                <option value="nanJing">南京</option>
                                <option value="suZhou">苏州</option>
                                <option value="yangZhou">扬州</option>
                            </select>
                        </div>
                        <button type="button" class="btn" disabled="disabled"><img src="${path}/static/img/search.gif"/>搜索</button>
                    </form>
                </div>
            </div>
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
<script src="<%=path %>/static/js/jquery-1.11.0.js"></script>
<script src="<%=path %>/static/js/bootstrap.min.js"></script>
<script>
    $(function(){
    	$(".delete").click(function(){
			var xueXiaoGuid = $(this).attr("id");
			if(confirm("确定要删除数据吗")){
				$.post("${path}/xuexiao/delete.shtml",{"xueXiaoGuid":xueXiaoGuid},function(data){
					var msg = data.msg;
					if(msg=="success"){
						$("#"+xueXiaoGuid).parent().parent().fadeOut("slow");
					}else if(msg=="fail"){
						alert("系统异常，删除失败");
					}
				});
			}
			
		});
    
        $("#search-name-button").click(function(){
            var search_name = $.trim($("#search-name").val());
            //如果输入为空，跳出提示
            if(search_name==''){
                $(".modal-body p").text("输入要搜索的学校名称");
                $('#tiShi').modal({
                    keyboard: false
                });
            }else{
                $("#searchXueXiaoByName").submit();
            }
        });
    });
</script>
</body>
</html>