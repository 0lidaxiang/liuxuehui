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
        function doforward(){
           var userSession="${sessionScope.userSession}";
       }
       
        $(function(){

            //切换到注册界面
            $(".nav-tabs li:eq(1)").click(function(){
                if(!$(this).hasClass("active")){
                    $(this).siblings("li").removeClass("active");
                    $(this).addClass("active");
                    $("#loginForm").css("display","none");
                    $("#registerForm").css("display","block");
                }
            });

            //切换到登陆界面
            $(".nav-tabs li:eq(0)").click(function(){
                if(!$(this).hasClass("active")){
                    $(this).siblings("li").removeClass("active");
                    $(this).addClass("active");
                    $("#loginForm").css("display","block");
                    $("#registerForm").css("display","none");
                }
            });

            //登陆
            $("#login").click(function(){
                var mobile = $(".login-mobile").val();
                var pwd = $(".login-pwd").val();
                if(mobile==""){
                    $(".login_error_msg").text("请输入手机账号");
                    return;
                }else if(pwd==""){
                    $(".login_error_msg").text("请输入密码");
                }else if(checkMobileNumber(mobile)){
                    $.post("${path}/user/login.shtml",{"mobilephone":mobile,"passwd":pwd},function(data){
                        var msg = data.msg;
                        if(msg=="success"){
                           location.href="${path}/home/goHome.shtml";
                        }else if(msg=="success_to_user"){
                            location.href="${path}/view/user.jsp";
                        }else if(msg=="mobile_error"){
                            $(".login_error_msg").text("手机账号有误");
                        }else if(msg=="pwd_error"){
                            $(".login_error_msg").text("密码错误了哦");
                        }
                    });
                }else{
                    $(".login-mobile").css("borderColor","red");
                    $(".login_error_msg").text("手机号的格式不对，请重新输入");
                }
            });

            //注册
            $("#register").click(function(){
                var mobile = $(".register-mobile").val();
                var pwd = $(".register-pwd").val();
                var pwd_again = $(".register-pwd-again").val();
                var yzm = $(".register-yzm").val();
                if(mobile==""){
                    $(".register_error_msg").text("请输入手机账号");
                    return;
                }else if(pwd==""){
                    $(".register_error_msg").text("请输入密码");
                }else if(pwd_again==""){
                    $(".register_error_msg").text("第二次确认密码没有输入");
                }else if(yzm==""){
                    $(".register_error_msg").text("请输入验证码");
                }else if(checkMobileNumber(mobile)){
                    if(pwd==pwd_again){
                        $.post("${path}/user/register.shtml",{"mobilephone":mobile,"passwd":pwd},function(data){
                            var msg = data.msg;
                            if(msg=="reg_sucess"){
                                location.href="${path}/view/user.jsp";
                            }else if(msg=="yzm_error"){
                                $(".register_error_msg").text("验证码输入不对");
                            }else{
                              alert(msg);
                            }
                        });
                    }else{
                        $(".register_error_msg").text("2次输入密码不一致，请重新输入");
                    }
                }else{
                    $(".register_error_msg").text("手机号的格式不对，请重新输入");
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
        window.onload=doforward;
    </script>
</head>
<body>
	<jsp:include page="head.jsp"></jsp:include>
    <div class="container-fluid">
        <div class="row">
            <!--<div class="col-md-12 header">-->

            <!--</div>-->
            <div class="col-xs-12 col-sm-10 col-md-8 col-md-offset-2 col-sm-offset-1 main">
                <div class="col-sm-6 col-md-6 tuPian"></div>
                <div class="col-xs-12 col-sm-6 col-md-6">
                    <ul class="nav nav-tabs text-center">
                        <li role="presentation" class="active"><a>登录</a></li>
                        <li role="presentation" class="tab_2"><a>注册</a></li>
                    </ul>
                    <form id="loginForm">
                        <div class="form-group">
                            <input type="tel" class="form-control login-mobile"  placeholder="手机账号">
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
                    <form id="registerForm">
                        <div class="form-group">
                            <input type="tel" class="form-control register-mobile"  placeholder="手机账号">
                        </div>
                        <div class="form-group">
                            <input type="password" class="form-control register-pwd" placeholder="密码">
                        </div>
                        <div class="form-group">
                            <input type="password" class="form-control register-pwd-again" placeholder="再输一次密码">
                        </div>
                        <div class="input-group">
                            <input type="text" class="form-control register-yzm" placeholder="输入验证码">
                            <span class="input-group-btn yanZhengMa">
                                <img src="${path}/static/img/yanzhengma.jpg" title="点击换一张">
                            </span>
                        </div>
                        <div class="col-md-12 text-center submit">
                            <button type="button" class="btn btn-primary" id="register">注册</button>
                        </div>
                        <div class="col-md-12 text-center error">
                            <span class="register_error_msg"></span>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>


	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>