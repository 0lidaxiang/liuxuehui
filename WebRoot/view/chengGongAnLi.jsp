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
    <title>成功案例</title>
    <!-- Bootstrap -->
    <link href="${path}/static/css/bootstrap.min.css" rel="stylesheet">
    <link href="${path}/static/css/liebiao2.css" rel="stylesheet">

    <!--[if lt IE 9]>
    <script src="${path}/static/js/html5shiv.min.js"></script>
    <script src="${path}/static/js/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<jsp:include page="head.jsp"></jsp:include>
<div class="container">
    <div class="row weiZhi">
        <div class="col-md-10 col-md-offset-1">
            <span>所在位置：成功案例</span>
        </div>
    </div>
</div>
<div class="container" id="lieBiao">
    <div class="row chengGongAnli">
        <div class="col-md-10 col-md-offset-1">
            <div id="big-image" class="carousel slide" data-ride="carousel">
                <!--<ol class="carousel-indicators">-->
                <!--<li data-target="#big-image" data-slide-to="0" class="active"></li>-->
                <!--</ol>-->
                <div class="carousel-inner big-img" role="listbox">
                    <div class="item active">
                        <img src="${path}/static/img/anli-big.jpg" alt="...">
                        <div class="carousel-caption">

                        </div>
                    </div>
                </div>
                <!--<a class="left carousel-control" href="#big-image" role="button" data-slide="prev">-->
                    <!--<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>-->
                    <!--<span class="sr-only">Previous</span>-->
                <!--</a>-->
                <!--<a class="right carousel-control" href="#big-image" role="button" data-slide="next">-->
                    <!--<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>-->
                    <!--<span class="sr-only">Next</span>-->
                <!--</a>-->
            </div>
        </div>
        <div class="col-md-10 col-md-offset-1 anLi">
            <c:forEach items="${studentList}" var="student" varStatus="status">
        		<div class="col-sm-6 anLi-content">
	            	<div class="thumbnail">
	            		<div class="col-sm-5 anLi-img">
		                    <a href="${path}/student/content.shtml?studentGuid=${student.guid}">
		                        <img src="${path}/static/uploadImg/xuesheng/liebiao/${student.photoName}" class="img-rounded"/>
		                    </a>
		                </div>
		                <div class="col-sm-7 miaoShu">
		                    <a href="${path}/student/content.shtml?studentGuid=${student.guid}" target="_blank"><h4>${student.name}</h4></a>
		                    <div class="xueShengXinXi">
		                        <p>成绩：${student.chengJi}</p>
		                        <p>offer：${student.offer}</p>
		                        <p>进入：${student.jinRuXueXiao}</p>
		                    </div>
		                </div>
	            	</div>
	            </div>
        	</c:forEach>
        </div>

    </div>
    <c:import url="/view/page.jsp"></c:import>
</div>

<jsp:include page="footer.jsp"></jsp:include>
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