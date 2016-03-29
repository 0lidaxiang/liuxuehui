<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
            <a class="navbar-brand logo" href="${path}/home/goHome.shtml"><img src="${path}/static/img/logo_demo.jpg" alt="留学慧"></a>
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
                <li><a href="${path}/view/zaiXianCePing.jsp">在线测评</a></li>
                <li><a href="${path}/kecheng/more.shtml?pageNo=1">特色课程</a></li>
            </ul>
            <c:if test="${userSession==null}">
            	<!-- 未登录是显示 -->
	            <ul class="nav navbar-nav navbar-right">
	                <a href="${path}/user/loginOrReg.shtml"><button type="button" class="btn btn-success navbar-btn">&nbsp;&nbsp;登录&nbsp;&nbsp;</button></a>&nbsp;&nbsp;
	                <a href="${path}/user/loginOrReg.shtml"><button type="button" class="btn btn-info navbar-btn">&nbsp;&nbsp;注册&nbsp;&nbsp;</button></a>
	            </ul>
            </c:if>
            <c:if test="${userSession!=null}">
            	<!-- 登录时显示 -->
	            <ul class="nav navbar-nav navbar-right text-center nav_touxiang">
	                <li><a href="${path}/member/user.shtml">
	                		<c:if test="${userSession.touxiang!=null}">
	                			<img src="${path}/static/uploadImg/user/${userSession.touxiang}">
	                		</c:if>
	                		<c:if test="${userSession.touxiang==null}">
	                			<img src="${context}/static/img/touxiang.jpg">
	                		</c:if>
		                	
		                	${userSession.mobilephone}
	                	</a>
	                </li>
	            </ul>
            </c:if>
            
        </div>
    </div>
</nav>