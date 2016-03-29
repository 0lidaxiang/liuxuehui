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
    <title>修改学生（成功案例）</title>
    <!-- Bootstrap -->
    <link href="${path}/static/css/bootstrap.min.css" rel="stylesheet">
    <link href="${path}/static/css/zaiXianCePing.css" rel="stylesheet">

    <!--[if lt IE 9]>
    <script src="${path}/static/js/html5shiv.min.js"></script>
    <script src="${path}/static/js/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<jsp:include page="../adminNav.jsp"></jsp:include>
<div class="container-fluid main">
    <div class="row">
        <div class="col-xs-12 col-sm-9 col-md-8 col-sm-offset-2 col-md-offset-2 right_content">
            <div class="row tianXieXinXi">
                <h4>修改学生（成功案例）</h4>
                <div class="col-md-12 col-md-offset-3 content_jiChu">
                    <form class="form-horizontal" id="form" method="post" enctype="multipart/form-data" action="${path}/student/update.shtml">
                        <input type="hidden" name="studentGuid" value="${student.guid}">
                        <div class="form-group">
                            <label for="name" class="col-sm-2 control-label">姓名</label>
                            <div class="col-sm-8 col-md-6">
                                <input type="text" class="form-control" value="${student.name}" id="name" name="name">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="indexMiaoShu" class="col-sm-2 control-label">首页使用的描述语句</label>
                            <div class="col-sm-8 col-md-6">
                                <input type="text" class="form-control" value="${student.indexMiaoShu}" id="indexMiaoShu" name="indexMiaoShu">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="indexPhoto" class="col-sm-2 control-label">首页图片-放首页时用到</label>
                            <div class="col-sm-8 col-md-6">
                                <input type="file" class="form-control" id="indexPhoto" name="indexPhoto">
                                <span>尺寸自己控制，适合首页即可，图片要小，要清晰</span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="indexXyBj" class="col-sm-2 control-label">首页选用</label>
                            <div class="col-sm-8 col-md-6">
                                <select class="form-control" name="indexXyBj" id="indexXyBj">
                                	<c:if test="${student.indexXyBj==1}">
                                		<option value="0">不选用</option>
										<option value="1" selected="selected">选用</option>
                                	</c:if>
                                	<c:if test="${student.indexXyBj==0}">
                                		<option value="0" selected="selected">不选用</option>
										<option value="1">选用</option>
                                	</c:if>
								</select>
                            </div>
	                    </div>
	                    <div class="form-group">
                            <label for="indexWeiZhi" class="col-sm-2 control-label">首页选用时，放置的位置</label>
                            <div class="col-sm-8 col-md-6">
                                <input type="text" class="form-control" value="${student.indexWeiZhi}" id="indexWeiZhi" name="indexWeiZhi" placeholder="整数值">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="photo" class="col-sm-2 control-label">列表图片</label>
                            <div class="col-sm-8 col-md-6">
                                <input type="file" class="form-control" value="${student.guid}" id="photo" name="photo">
                                <span>尺寸建议：250*250</span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="chengJi" class="col-sm-2 control-label">成绩</label>
                            <div class="col-sm-8 col-md-6">
                            	<input type="text" class="form-control" id="chengJi" value="${student.chengJi}" name="chengJi" placeholder="eg：雅思8分">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="offer" class="col-sm-2 control-label">收到的offer</label>
                            <div class="col-sm-8 col-md-6">
                                <input type="text" class="form-control" id="offer" value="${student.offer}" name="offer" placeholder="多个以顿号隔开 ">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="jinRuXueXiao" class="col-sm-2 control-label">入读的学校</label>
                            <div class="col-sm-8 col-md-6">
                                <input type="text" class="form-control" id="jinRuXueXiao" value="${student.jinRuXueXiao}" name="jinRuXueXiao">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="jinRuXueXiaoPingJi" class="col-sm-2 control-label">进入的留学学校评级分数</label>
                            <div class="col-sm-8 col-md-6">
                                <input type="text" class="form-control" id="jinRuXueXiaoPingJi" value="${student.jinRuXueXiaoPingJi}" name="jinRuXueXiaoPingJi" placeholder="整数 1-10 " value="0">
                            </div>
                        </div>
                        
                        
                        <div class="form-group">
                            <label for="xueXiao" class="col-sm-2 control-label">现在就读的学校</label>
                            <div class="col-sm-8 col-md-6">
                                <input type="text" class="form-control" id="xueXiao" value="${studentContent.xueXiao}" name="xueXiao" placeholder="多个以顿号隔开">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="zhuanYe" class="col-sm-2 control-label">在读专业</label>
                            <div class="col-sm-8 col-md-6">
                                <input type="text" class="form-control" id="zhuanYe" value="${studentContent.zhuanYe}" name="zhuanYe">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="pingJunChengJi" class="col-sm-2 control-label">在学校各科的平均成绩</label>
                            <div class="col-sm-8 col-md-6">
                                <input type="text" class="form-control" id="pingJunChengJi" value="${studentContent.pingJunChengJi}" name="pingJunChengJi">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="anLiJianJie" class="col-sm-2 control-label">案例简介</label>
                            <div class="col-sm-8 col-md-6">
                                <input type="text" class="form-control" id="anLiJianJie" value="${studentContent.anLiJianJie}" name="anLiJianJie">
                            </div>
                        </div>
                         <div class="form-group">
                            <label for="anLiFenXi" class="col-sm-2 control-label">案例分析</label>
                            <div class="col-sm-8 col-md-6">
                                <textarea class="form-control" rows="7" id="anLiFenXi" name="anLiFenXi">${studentContent.anLiFenXi}</textarea>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="picture" class="col-sm-2 control-label">内容页面的大图片</label>
                            <div class="col-sm-8 col-md-6">
                                <input type="file" class="form-control" id="picture" name="picture">
                                <span>尺寸建议：700*350</span>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-8 col-md-8 text-center">
                                <button type="submit" class="btn btn-warning" id="tiJiao">提交修改</button>
                                <br>
                                <span>${msg}</span>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
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
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
<jsp:include page="../adminFooter.jsp"></jsp:include>
<script src="${path}/static/js/jquery-1.11.0.js"></script>
<script src="${path}/static/js/bootstrap.min.js"></script>
<script>
    $(function(){
        $("#tiJiao").click(function(){
            var name = $("#name").val();
            var photo = $("#photo").val();
            if(name==""){
                $(".modal-body p").text("名称没填");
                $('#tiShi').modal({
                    keyboard: false
                });
            }else{
            	return ture;
            }
			return false;
        });

		
    });
</script>
</body>
</html>