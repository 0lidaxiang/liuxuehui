<%@page import="org.springframework.web.context.request.SessionScope"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
request.setAttribute("path",path);
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<nav class="navbar navbar-default navigator">
    <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand logo" href="${path}/home/goHome.shtml"><img src="<%=path %>/static/img/logo_demo.jpg" alt="留学慧"></a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav nav-content">
                <li><a href="${path}/home/goHome.shtml">首页</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">咨询<span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="${path}/jigou/more.shtml?pageNo=1">留学机构</a></li>
                        <li><a href="${path}/guwen/more.shtml?pageNo=1">留学顾问</a></li>
                        <li><a href="${path}/wenan/more.shtml?pageNo=1">金牌文案</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">培训<span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="${path}/xuexiao/more.shtml?pageNo=1">学校</a></li>
                        <li><a href="${path}/mingshi/more.shtml?pageNo=1">名师</a></li>
                    </ul>
                </li>
                <li><a href="${path}/student/more.shtml?pageNo=1">成功案例</a></li>
                <li><a href="${path}/onlinetest/more.shtml?pageNo=1">在线测评</a></li>
                <li><a href="${path}/kecheng/more.shtml?pageNo=1">特色课程</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right text-center nav_touxiang">
                <li><a>后台管理员</a></li>
            </ul>
        </div>
    </div>
</nav>