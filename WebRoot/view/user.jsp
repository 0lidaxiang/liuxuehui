<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="com.liuxue.entity.*"%>
<%
response.setHeader("Pragma","No-cache"); response.setHeader("Cache-Control","No-cache"); response.setDateHeader("Expires", -1); response.setHeader("Cache-Control", "No-store");
String path = request.getContextPath();
request.setAttribute("path",path);
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
User user=(User)session.getAttribute("userSession");
%>

<!DOCTYPE html>
<html>
<head lang="zh-CN">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>用户中心</title>
    <!-- Bootstrap -->
    <link href="${path}/static/css/bootstrap.min.css" rel="stylesheet">
    <link href="${path}/static/css/user.css" rel="stylesheet">

    <!--[if lt IE 9]>
    <script src="${path}/static/js/html5shiv.min.js"></script>
    <script src="${path}/static/js/respond.min.js"></script>
    <![endif]-->

</head>
<body>
<c:import url="/view/head.jsp"></c:import>
<div class="container main">
    <div class="row">

        <div class="col-xs-12 col-sm-3 col-md-3 left_nav text-center">
        	<c:if test="${userSession.touxiang==null}">
        		<img src="${path}/static/img/touxiang.jpg" for="exampleInputFile" class="img-circle touxiang">
        	</c:if>
        	<c:if test="${userSession.touxiang!=null}">
        		<img src="${path}/static/uploadImg/user/${userSession.touxiang}" for="exampleInputFile" class="img-circle touxiang">
        	</c:if>
            <ul class="nav nav-pills nav-stacked left_nav_shu text-center">
                <li role="presentation" class="active"><a href="#">基本信息</a></li>
                <!-- 
                <li role="presentation"><a href="dingDan.jsp">我的订单</a></li>
                <li role="presentation"><a href="cePing.jsp">留学测评</a></li>
                 -->
            </ul>
            <ul class="nav nav-pills text-center left_nav_heng">
                <li role="presentation" class="active"><a href="#">基本信息</a></li>
                <!-- 
                <li role="presentation"><a href="dingDan.jsp">我的订单</a></li>
                <li role="presentation"><a href="cePing.jsp">留学测评</a></li>
                 -->
            </ul>
        </div>
        <div class="col-xs-12 col-sm-9 col-md-9 right_content">
            <div class="row">
                <form class="form-horizontal" enctype="multipart/form-data"  id="user_form" action="${path}/member/updateUserInfo.shtml" method="post">
                    <div class="col-md-12 content_touxiang">
                        <h4>修改头像</h4>
                        <div class="uploadImg">
                            <div class="form-group">
                                <input type="file" id="touXiangFile" class="" name="touxiang">
                                <p class="help-block">图片格式：GIF、JPG、JPEG、PNG，最适合尺寸120*120像素</p>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-12 content_lianXi">
                        <h4>修改联系方式</h4>
                            <div class="form-group">
                                <label for="inputTel" class="col-sm-2 control-label">手机</label>
                                <div class="col-sm-8 col-md-5">
                                    <input type="tel" class="form-control" name="mobilephone" id="inputTel" placeholder="tel" value="${userSession.mobilephone}" readonly="readonly">
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="inputEmail" class="col-sm-2 control-label">常用邮箱</label>
                                <div class="col-sm-8 col-md-5">
                                    <input type="email" name="email" class="form-control" id="inputEmail" placeholder="Email"
                                       value="${userSession.email}"
                                     >
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="inputQQ" class="col-sm-2 control-label">QQ</label>
                                <div class="col-sm-8 col-md-5">
                                    <input type="text" class="form-control" name="qq" id="inputQQ" placeholder="qq"
                                      value="${userSession.qq}"
                                    >
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="inputWeiXin" class="col-sm-2 control-label">微信</label>
                                <div class="col-sm-8 col-md-5">
                                    <input type="text" class="form-control" name="weixin" id="inputWeiXin" placeholder="微信"
                                      value="${userSession.weixin}"
                                    >
                                </div>
                            </div>
                    </div>
                    <div class="col-md-12 content_jiChu">
                        <h4>修改基础信息</h4>
                            <div class="form-group">
                                <label for="inputUserName" class="col-sm-2 control-label">真实姓名</label>
                                <div class="col-sm-8 col-md-5">
                                    <input type="text" class="form-control" name="name" id="inputUserName" placeholder="姓名"
                                        value="${userSession.name}"
                                    >
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-2 control-label">性别</label>
                                <div class="col-sm-8 col-md-5">
                                    <label class="radio-inline">
                                        <input type="radio" name="sex" id="woman" value="woman"
                                           <%if(user.getSex()==1){ %>
                                              checked
                                           <%}%>
                                        >女
                                    </label>
                                    <label class="radio-inline">
                                        <input type="radio" name="sex" id="man" value="man"
                                            <%if(user.getSex()==0){ %>
                                              checked
                                            <%}%>
                                        >男
                                    </label>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="inputNianLing" class="col-sm-2 control-label">年龄</label>
                                <div class="col-sm-8 col-md-5">
                                    <input type="number" class="form-control" name="age" id="inputNianLing" placeholder="年龄"
                                       value="${userSession.age}"
                                    >
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="inputXueXiao" class="col-sm-2 control-label">就读学校</label>
                                <div class="col-sm-8 col-md-5">
                                    <input type="text" class="form-control" name="school" id="inputXueXiao" placeholder="学校"
                                      value="${userSession.school}"
                                    >
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="inputZhuanYe" class="col-sm-2 control-label">在读专业</label>
                                <div class="col-sm-8 col-md-5">
                                    <input type="text" class="form-control" name="major" id="inputZhuanYe" placeholder="专业"
                                       value="${userSession.major}"
                                    >
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-8 col-md-7 text-center">
                                    <!-- <button type="submit" class="btn btn-info" id="saveinfo">保存基本信息修改</button> -->
                                    <button type="button" class="btn btn-info" id="tijiao">保存基本信息修改</button>
                                    <span>${msg}</span>
                                </div>
                            </div>
                    </div>
                </form>
            </div>
        </div>

    </div>
</div>


<jsp:include page="footer.jsp"></jsp:include>
<script src="${path}/static/js/jquery-1.11.0.js"></script>
<script src="${path}/static/js/bootstrap.min.js"></script>
<script>
    $(function(){
    	$("#tijiao").click(function(){
        	var touXiangFile = $("#touXiangFile").val();
            var tel = $("#inputTel").val();
            if(tel==''){
                $(".modal-body p").text("手机号码必须填写");
                $('#tiShi').modal({keyboard: false});
            }else if(!checkMobileNumber(tel)){
                $(".modal-body p").text("修改的手机号码格式错了");
                $('#tiShi').modal({keyboard: false});
            }else if(!/\.(gif|jpg|jpeg|png|GIF|JPG|PNG)$/.test(touXiangFile) && touXiangFile!=''){
                $(".modal-body p").text("图片类型必须是.gif,jpeg,jpg,png中的一种");
                $('#tiShi').modal({keyboard: false});
            }else{
                $("#user_form").submit();
            }
        });
    
    
        $("#saveinfo").click(function(){
            var touXiangFile = $("#touXiangFile").val();
            var tel = $("#inputTel").val();
            if(tel==''){
                $(".modal-body p").text("手机号码必须填写");
                $('#tiShi').modal({keyboard: false});
            }else if(!checkMobileNumber(tel)){
                $(".modal-body p").text("修改的手机号码格式错了");
                $('#tiShi').modal({keyboard: false});
            }else if(!/\.(gif|jpg|jpeg|png|GIF|JPG|PNG)$/.test(touXiangFile) && touXiangFile!=''){
                $(".modal-body p").text("图片类型必须是.gif,jpeg,jpg,png中的一种");
                $('#tiShi').modal({keyboard: false});
            }else{
                $("#user_form").submit(function(){
                  $.ajax({ type: 'POST', data: $(this).serialize(), url: '${path}/member/userinfo.shtml',
		            success: function (data) { 
		              if(data.msg=="success"){
		                 alert("个人信息录入成功！");
		                 location.href='<%=path%>/index.jsp';
		              }else{
		                 alert("个人信息录入错误");
		              }
		            },
		            error: function (msg) {
		                
		            } 
		        });
		        return false;
              });
            }
        });
        
        
        //验证手机格式
        function checkMobileNumber(number){
            if(!(/^[1][3-8][0-9]{9}$/.test(number))){
                return false;
            }else{
                return true;
            }
        }
    });
</script>
</body>
</html>