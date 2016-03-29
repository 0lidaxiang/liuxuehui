<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
    <title>登录或注册</title>
    <!-- Bootstrap -->
    <link href="${path}/static/css/bootstrap.min.css" rel="stylesheet">
    <link href="${path}/static/css/loginAndReg.css" rel="stylesheet">

    <!--[if lt IE 9]>
    <script src="${path}/static/js/html5shiv.min.js"></script>
    <script src="${path}/static/js/respond.min.js"></script>
    <![endif]-->
  	<script src="${path}/static/js/jquery-1.11.0.js"></script>
    <script src="${path}/static/js/bootstrap.min.js"></script>
    <script>
        $(function(){
        	//登陆
            $("#login").click(function(){
                var account = $(".login-mobile").val();
                var pwd = $(".login-pwd").val();
                 $.post("${path}/adminUser/adminLogin.shtml",{"account":account,"pwd":pwd},function(data){
					var msg = data.msg;
					if(msg=="success"){
						location.href="${path}/home/goHome.shtml"
					}else if(msg=="account"){
						$(".login_error_msg").html("帐号不存在");
					}else if(msg=="password"){
						$(".login_error_msg").html("密码错误");
					}
				});
            });
        });
    </script>
</head>
<body>
	<jsp:include page="adminNav.jsp"></jsp:include>
    <div class="container-fluid">
        <div class="row">
            <!--<div class="col-md-12 header">-->

            <!--</div>-->
            <div class="col-xs-12 col-sm-10 col-md-8 col-md-offset-2 col-sm-offset-1 main">
                <div class="col-sm-6 col-md-6 tuPian"></div>
                <div class="col-xs-12 col-sm-6 col-md-6">
                    <ul class="nav nav-tabs text-center">
                        <li role="presentation" class="active"><a>留学慧admin登录</a></li>
                    </ul>
                    <form id="loginForm">
                        <div class="form-group">
                            <input type="text" class="form-control login-mobile"  placeholder="管理员账号">
                        </div>
                        <div class="form-group">
                            <input type="password" class="form-control login-pwd" placeholder="密码">
                        </div>
                        <div class="col-md-12 text-center submit">
                            <button type="button" class="btn btn-primary" id="login">登录</button>
                        </div>
                        <div class="col-md-12 text-center error">
                            <span class="login_error_msg"></span>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>


	<jsp:include page="adminFooter.jsp"></jsp:include>
</body>
</html>