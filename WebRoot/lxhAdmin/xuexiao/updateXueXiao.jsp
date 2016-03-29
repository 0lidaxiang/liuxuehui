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
    <title>修改培训学校</title>
    <!-- Bootstrap -->
    <link href="<%=path %>/static/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=path %>/static/css/zaiXianCePing.css" rel="stylesheet">

    <!--[if lt IE 9]>
    <script src="<%=path %>/static/js/html5shiv.min.js"></script>
    <script src="<%=path %>/static/js/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<jsp:include page="../adminNav.jsp"></jsp:include>
<div class="container-fluid main">
    <div class="row">
        <div class="col-xs-12 col-sm-9 col-md-8 col-sm-offset-2 col-md-offset-2 right_content">
            <div class="row tianXieXinXi">
                <h4>修改培训学校</h4>
                <div class="col-md-12 col-md-offset-3 content_jiChu">
                    <form class="form-horizontal" id="form" method="post" enctype="multipart/form-data" action="${path}/xuexiao/update.shtml">
                    	<input type="hidden" name="xueXiaoGuid" value="${xueXiao.guid}">
                        <div class="form-group">
                            <label for="name" class="col-sm-2 control-label">学校名称</label>
                            <div class="col-sm-8 col-md-6">
                                <input type="text" class="form-control" id="name" value="${xueXiao.name}" name="name">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="engLishName" class="col-sm-2 control-label">英文名称</label>
                            <div class="col-sm-8 col-md-6">
                                <input type="text" class="form-control" id="engLishName" value="${xueXiao.engLishName}" name="engLishName">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="indexMiaoShu" class="col-sm-2 control-label">首页使用的描述语句</label>
                            <div class="col-sm-8 col-md-6">
                                <input type="text" class="form-control" id="indexMiaoShu" value="${xueXiao.indexMiaoShu}" name="indexMiaoShu">
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
                                	<c:if test="${xueXiao.indexXyBj==1}">
                                		<option value="0">不选用</option>
										<option value="1" selected="selected">选用</option>
                                	</c:if>
                                	<c:if test="${xueXiao.indexXyBj==0}">
                                		<option value="0" selected="selected">不选用</option>
										<option value="1">选用</option>
                                	</c:if>
								</select>
                            </div>
	                    </div>
	                    <div class="form-group">
                            <label for="indexWeiZhi" class="col-sm-2 control-label">首页选用时，放置的位置</label>
                            <div class="col-sm-8 col-md-6">
                                <input type="text" class="form-control" id="indexWeiZhi" value="${xueXiao.indexWeiZhi}" name="indexWeiZhi" placeholder="整数值">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="photo" class="col-sm-2 control-label">列表图片</label>
                            <div class="col-sm-8 col-md-6">
                                <input type="file" class="form-control" id="photo" name="photo">
                                <span>尺寸建议：150*150</span>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="jianjie" class="col-sm-2 control-label">简介</label>
                            <div class="col-sm-8 col-md-6">
                                <textarea class="form-control" rows="5" id="jianjie" name="jianjie">${xueXiao.jianjie}</textarea>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="renqi" class="col-sm-2 control-label">人气</label>
                            <div class="col-sm-8 col-md-6">
                                <input type="text" class="form-control" id="renqi" value="${xueXiao.renQi}" name="renqi" placeholder="整数值" value="0">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="pinjia" class="col-sm-2 control-label">评价-几颗星</label>
                            <div class="col-sm-8 col-md-6">
                                <input type="text" class="form-control" id="pinjia" value="${xueXiao.pinJia}" name="pinjia" placeholder="填写1-5的整数">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="shanchangguojia" class="col-sm-2 control-label">擅长国家</label>
                            <div class="col-sm-8 col-md-6">
                                <input type="text" class="form-control" id="shanchangguojia" value="${xueXiao.shanChangGuoJia}" name="shanchangguojia" placeholder="多个国家以顿号隔开">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="suoZaiChengShi" class="col-sm-2 control-label">所在城市</label>
                            <div class="col-sm-8 col-md-6">
                                <input type="text" class="form-control" id="suoZaiChengShi" value="${xueXiao.suoZaiChengShi}" name="suoZaiChengShi" placeholder="多个形式以顿号隔开">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="leiXing" class="col-sm-2 control-label">院校类型</label>
                            <div class="col-sm-8 col-md-6">
                                <input type="text" class="form-control" id="leiXing" value="${xueXiao.leiXing}" name="leiXing" placeholder="私立/公立">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="weekZhaoShengShu" class="col-sm-2 control-label">周招生数</label>
                            <div class="col-sm-8 col-md-6">
                                <input type="text" class="form-control" id="weekZhaoShengShu" value="${xueXiao.weekZhaoShengShu}" name="weekZhaoShengShu" placeholder="整数">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="monthZhaoShengShu" class="col-sm-2 control-label">月招生数</label>
                            <div class="col-sm-8 col-md-6">
                                <input type="text" class="form-control" id="monthZhaoShengShu" value="${xueXiao.monthZhaoShengShu}" name="monthZhaoShengShu" placeholder="整数">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="yearZhaoShengShu" class="col-sm-2 control-label">年招生数</label>
                            <div class="col-sm-8 col-md-6">
                                <input type="text" class="form-control" id="yearZhaoShengShu" value="${xueXiao.yearZhaoShengShu}" name="yearZhaoShengShu" placeholder="整数">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="dianhua" class="col-sm-2 control-label">联系电话</label>
                            <div class="col-sm-8 col-md-6">
                                <input type="text" class="form-control" id="dianhua" value="${xueXiaoContent.dianHua}" name="dianhua" placeholder="多个以顿号隔开">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="address" class="col-sm-2 control-label">联系地址</label>
                            <div class="col-sm-8 col-md-6">
                                <input type="text" class="form-control" id="address" value="${xueXiaoContent.address}" name="address">
                            </div>
                        </div>
                         <div class="form-group">
                            <label for="jieshao" class="col-sm-2 control-label">机构详细介绍</label>
                            <div class="col-sm-8 col-md-6">
                                <textarea class="form-control" rows="5" id="jieshao" name="jieshao">${xueXiaoContent.jieShao}</textarea>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="picture" class="col-sm-2 control-label">学校内容页面图片</label>
                            <div class="col-sm-8 col-md-6">
                                <input type="file" class="form-control" id="pictureurl" name="picture">
                                <span>尺寸建议：700*350</span>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-8 col-md-8 text-center">
                                <button type="submit" class="btn btn-warning" id="submit">提交修改</button>
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
<script src="<%=path %>/static/js/jquery-1.11.0.js"></script>
<script src="<%=path %>/static/js/bootstrap.min.js"></script>
<script>
    $(function(){
        $("#submit").click(function(){
            var name = $("#name").val();
            var jianjie = $("#jianjie").val();
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


    });
</script>
</body>
</html>