<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
    <title>在线测评列表</title>
    <!-- Bootstrap -->
    <link href="${path}/static/css/bootstrap.min.css" rel="stylesheet">
	<link href="${path}/static/css/index.css" rel="stylesheet">
    <!--[if lt IE 9]>
    <script src="${path}/static/js/html5shiv.min.js"></script>
    <script src="${path}/static/js/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<jsp:include page="adminNav.jsp"></jsp:include>

<!--内容区-->
<div class="container" id="cePing_lieBiao">
    <div class="col-sm-12 table-responsive text-center">
       <table class="table table-bordered table-hover table-striped">
           <thead class="">
               <tr class="info">
                   <td><strong>序号</strong></td>
                   <td><strong>手机号</strong></td>
                   <td><strong>国家</strong></td>
                   <td><strong>就读学校</strong></td>
                   <td><strong>年级</strong></td>
                   <td><strong>专业</strong></td>
                   <td><strong>语言成绩</strong></td>
                   <td><strong>意向留学国家</strong></td>
                   <td><strong>意向留学专业</strong></td>
                   <td><strong>计划出国时间</strong></td>
                   <td><strong>状态</strong></td>
                   <td><strong>录入时间</strong></td>
                   <td><strong>操作</strong></td>
               </tr>
           </thead>
           <tbody>
           	<c:if test="${fn:length(onlineTestList)==0}">
           		<tr><td class="bg-success text-info" colspan="10">没人提交留学意向</td></tr>
           	</c:if>
           	<c:if test="${fn:length(onlineTestList)>0}">
           		<c:forEach items="${onlineTestList}" var="onlineTest" varStatus="status">
           			<tr style="height:70px;" valign="middle">
           			 <td class="text-muted">${status.index + 1}</td>
                     <td>${onlineTest.phoneNumber}</td>
                     <td>${onlineTest.guoJia}</td>
                     <td>${onlineTest.school}</td>
                     <td>${onlineTest.grade}</td>
                     <td>${onlineTest.major}</td>
                     <td>${onlineTest.examType}${onlineTest.score}分</td>
                     <td>${onlineTest.intentionCountry}</td>
                     <td>${onlineTest.intentionMajor}</td>
                     <td>${onlineTest.planOutTime}</td>
                     <td>
                     	<c:if test="${onlineTest.zhuangTai!=1}">未处理</c:if>
                     	<c:if test="${onlineTest.zhuangTai==1}">处理了</c:if>
                     </td>
                     <td><fmt:formatDate value="${onlineTest.luRuTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                     <td>
                       	<c:if test="${onlineTest.zhuangTai!=1}">
                       		<a class="chuLi" id="${onlineTest.guid}" style="cursor:pointer;color:red;">标记已处理</a>
                       	</c:if>
                   		<c:if test="${onlineTest.zhuangTai==1}">
                   			<a class="chuLi" id="${onlineTest.guid}" style="cursor:pointer;color:blue;">返回未处理</a>
                   		</c:if>
                     </td>
                 </tr>
           		</c:forEach>
           	</c:if>
           </tbody>
       </table>
       <c:import url="/view/page.jsp"></c:import>
   </div>
</div>


<jsp:include page="adminFooter.jsp"></jsp:include>
<script src="${path}/static/js/jquery-1.11.0.js"></script>
<script src="${path}/static/js/bootstrap.min.js"></script>
<script>
    $(function(){
        $(".chuLi").click(function(){
        	var onlineTestGuid = $(this).attr("id");
        	$.post("${path}/onlinetest/updateZhuangTai.shtml",{"onlineTestGuid":onlineTestGuid},function(data){
        		var msg = data.msg;
        		var zhuangTai = data.zhuangTai;
				if(msg=="success"){
					if(zhuangTai=="no"){
						$("#"+onlineTestGuid).text("标记已处理");
						$("#"+onlineTestGuid).parent().prev().prev().text("未处理");
						$("#"+onlineTestGuid).css("color","red");
					}else{
						$("#"+onlineTestGuid).text("返回未处理");
						$("#"+onlineTestGuid).parent().prev().prev().text("处理了");
						$("#"+onlineTestGuid).css("color","blue");
					}
				}else if(msg=="fail"){
					alert("系统异常，删除失败");
				}
        	});
        	
        });
    });
</script>
</body>
</html>