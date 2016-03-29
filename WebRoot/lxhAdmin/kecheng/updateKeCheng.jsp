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
    <title>修改课程</title>
    <!-- Bootstrap -->
    <link href="${path}/static/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=path %>/static/css/bootstrap-datetimepicker.min.css" rel="stylesheet">
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
                <h4>修改课程</h4>
                <div class="col-md-12 col-md-offset-3 content_jiChu">
                    <form class="form-horizontal" id="form" method="post" enctype="multipart/form-data" action="${path}/kecheng/update.shtml">
                        <input type="hidden" name="keChengGuid" value="${keCheng.guid}">
                        <div class="form-group">
                            <label for="name" class="col-sm-2 control-label">课程名称</label>
                            <div class="col-sm-8 col-md-6">
                                <input type="text" class="form-control" id="name" value="${keCheng.name}" name="name">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="indexMiaoShu" class="col-sm-2 control-label">首页使用的描述语句</label>
                            <div class="col-sm-8 col-md-6">
                                <input type="text" class="form-control" id="indexMiaoShu" value="${keCheng.indexMiaoShu}" name="indexMiaoShu">
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
                                	<c:if test="${keCheng.indexXyBj==1}">
                                		<option value="0">不选用</option>
										<option value="1" selected="selected">选用</option>
                                	</c:if>
                                	<c:if test="${keCheng.indexXyBj==0}">
                                		<option value="0" selected="selected">不选用</option>
										<option value="1">选用</option>
                                	</c:if>
								</select>
                            </div>
	                    </div>
	                    <div class="form-group">
                            <label for="indexWeiZhi" class="col-sm-2 control-label">首页选用时，放置的位置</label>
                            <div class="col-sm-8 col-md-6">
                                <input type="text" class="form-control" id="indexWeiZhi" value="${keCheng.indexWeiZhi}" name="indexWeiZhi" placeholder="整数值">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="photo" class="col-sm-2 control-label">列表图片</label>
                            <div class="col-sm-8 col-md-6">
                                <input type="file" class="form-control" id="photo" name="photo">
                                <span>尺寸建议：287*125</span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="jianjie" class="col-sm-2 control-label">简介</label>
                            <div class="col-sm-8 col-md-6">
                                <textarea class="form-control" rows="3" id="jianjie" name="jianjie">${keCheng.jianjie}</textarea>
                            </div>
                        </div>
                        <div class="form-group">
	                        <label for="beginTime" class="col-sm-2 control-label">开始时间</label>
	                        <div class="col-sm-8 col-md-6">
	                        	<input class="form-control form_date" type="text"  value="${beginTime}" id="beginTime" name="beginTime" data-date-format="yyyy-mm-dd" data-link-format="yyyy-mm-dd">
	                    	</div>
	                    </div>
                        <div class="form-group">
	                        <label for="endTime" class="col-sm-2 control-label">结束时间</label>
	                        <div class="col-sm-8 col-md-6">
	                        	<input class="form-control form_date" type="text"  value="${endTime}" id="endTime" name="endTime" data-date-format="yyyy-mm-dd" data-link-format="yyyy-mm-dd">
	                    	</div>
	                    </div>
	                    <div class="form-group">
                            <label for="tuiJianZhiShu" class="col-sm-2 control-label">推荐指数</label>
                            <div class="col-sm-8 col-md-6">
                                <input type="text" class="form-control" id="tuiJianZhiShu" value="${keCheng.tuiJianZhiShu}" name="tuiJianZhiShu" placeholder="整数值 1-5">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="baoMingRenShu" class="col-sm-2 control-label">已经报名人数</label>
                            <div class="col-sm-8 col-md-6">
                                <input type="text" class="form-control" id="baoMingRenShu" name="baoMingRenShu" placeholder="整数值" value="${keCheng.baoMingRenShu}">
                            </div>
                        </div>
                        
                        <div class="form-group">
                            <label for="dianhua" class="col-sm-2 control-label">联系电话</label>
                            <div class="col-sm-8 col-md-6">
                                <input type="text" class="form-control" id="dianhua" value="${keChengContent.dianHua}" name="dianhua" placeholder="多个以顿号隔开">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="weiXin" class="col-sm-2 control-label">微信</label>
                            <div class="col-sm-8 col-md-6">
                                <input type="text" class="form-control" id="weiXin" value="${keChengContent.weiXin}" name="weiXin">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="jiaoCai" class="col-sm-2 control-label">学习所用到的教材</label>
                            <div class="col-sm-8 col-md-6">
                                <input type="text" class="form-control" id="jiaoCai" value="${keChengContent.jiaoCai}" name="jiaoCai">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="shiHeDuiXiang" class="col-sm-2 control-label">适合对象</label>
                            <div class="col-sm-8 col-md-6">
                                <input type="text" class="form-control" id="shiHeDuiXiang" value="${keChengContent.shiHeDuiXiang}" name="shiHeDuiXiang">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="baoFenChengNuo" class="col-sm-2 control-label">保分承诺</label>
                            <div class="col-sm-8 col-md-6">
                                <input type="text" class="form-control" id="baoFenChengNuo" value="${keChengContent.baoFenChengNuo}" name="baoFenChengNuo">
                            </div>
                        </div>
                         <div class="form-group">
                            <label for="keChengFenXi" class="col-sm-2 control-label">课程分析</label>
                            <div class="col-sm-8 col-md-6">
                                <textarea class="form-control" rows="7" id="keChengFenXi" name="keChengFenXi">${keChengContent.keChengFenXi}</textarea>
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
<script src="<%=path %>/static/js/bootstrap-datetimepicker.min.js"></script>
<script>
    $(function(){
        $("#tiJiao").click(function(){
            var name = $("#name").val();
            var photo = $("#photo").val();
            var jieshao = $("#jieshao").val();
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

		$('.form_date').datetimepicker({
            language:  'fr',
            weekStart: 1,
            todayBtn:  1,
            autoclose: 1,
            todayHighlight: 1,
            startView: 2,
            minView: 2,
            forceParse: 0
        });
    });
</script>
</body>
</html>