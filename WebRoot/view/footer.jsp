<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%if(session.getAttribute("userSession")==null) {%>
  <!-- 未登录是显示 -->
 	<div class="container-fluid text-center dengLuZhuCe">
    	<h1>现在开始加入留学慧，开启海外留学之旅</h1>
	    <a class="btn btn-warning" href="${path}/user/loginOrReg.shtml" role="button">马上注册</a>
	    <a class="btn btn-success" href="${path}/user/loginOrReg.shtml" role="button">立即登录</a>
	</div>
 <%}%>
<div class="container" id="footer">
    <div class="container">
        <div class="row">
            <div class="col-md-10 col-md-offset-1 diBuNav">
                <h1>留学慧</h1>
                <div class="col-md-4 lianXi">
                    <span class="tel">联系电话：15380783329</span>
                    <span class="diZhi">南京市中山南路230号308</span>
                </div>
                <div class="col-xs-6 col-sm-3 col-md-2 navContent">
                    <span>了解我们</span><br>
                    <!-- 
                    <a href="#">关于留学慧</a><br>
                    <a href="#">联系我们</a><br>
                    <a href="#">加入我们</a><br>
                     -->
                </div>
                <div class="col-xs-6 col-sm-3 col-md-2 navContent">
                    <span>合作伙伴</span><br>
                    <!-- 
                    <a href="#">新东方</a><br>
                    <a href="#">山木教育</a><br>
                    <a href="#">环亚朗文</a><br>
                    <a href="#">金吉利留学</a><br>
                     -->
                </div>
                <div class="col-xs-6 col-sm-3 col-md-2 navContent">
                    <span>服务支持</span><br>
                    <!-- 
                    <a href="#">常见问题</a><br>
                    <a href="#">意见反馈</a><br>
                     -->
                </div>
                <div class="col-xs-6 col-sm-3 col-md-2 navContent">
                    <span>相关链接</span><br>
                    <!-- 
                    <a href="#">免责声明</a><br>
                    <a href="#">服务条款</a><br>
                     -->
                </div>
            </div>
        </div>
    </div>
</div>