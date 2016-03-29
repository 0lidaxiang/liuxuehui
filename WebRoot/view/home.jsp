<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
    <title>留学慧首页</title>
    <!-- Bootstrap -->
    <link href="${path}/static/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=path %>/static/css/bootstrap-datetimepicker.min.css" rel="stylesheet">
    <link href="${path}/static/css/index.css" rel="stylesheet">

    <!--[if lt IE 9]>
    <script src="${path}/static/js/html5shiv.min.js"></script>
    <script src="${path}/static/js/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<jsp:include page="head.jsp"></jsp:include>
<div id="liuXueHui-biSheng" class="carousel slide" data-ride="carousel">
    <!--<ol class="carousel-indicators">-->
        <!--<li data-target="#liuXueHui-biSheng" data-slide-to="0" class="active"></li>-->
        <!--<li data-target="#liuXueHui-biSheng" data-slide-to="1" class="active"></li>-->
        <!--<li data-target="#liuXueHui-biSheng" data-slide-to="2" class="active"></li>-->
        <!--<li data-target="#liuXueHui-biSheng" data-slide-to="3" class="active"></li>-->
    <!--</ol>-->
    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">
        <div class="item active">
            <img src="${path}/static/img/banner_1.jpg" alt="留学慧">
            <div class="carousel-caption getFA">
                <h3>我的留学方案</h3>
                <form>
                    <div class="form-group">
                        <label>意向留学国家</label><br>
                        <label class="radio-inline">
                            <input type="radio" name="liuXueGuoJia" id="inlineRadio1" value="yingguo"> 英国
                        </label>
                        <label class="radio-inline">
                            <input type="radio" name="liuXueGuoJia" id="inlineRadio3" value="xinxilan"> 新西兰
                        </label>
                        <label class="radio-inline">
                            <input type="radio" name="liuXueGuoJia" id="inlineRadio2" value="aozhou"> 澳洲
                        </label>
                        <label class="radio-inline">
                            <input type="radio" name="liuXueGuoJia" id="inlineRadio4" value="rihan"> 日韩
                        </label>
                        <label class="radio-inline" style="margin-left: 0px;">
                            <input type="radio" name="liuXueGuoJia" id="inlineRadio5" value="meiguo"> 美国
                        </label>
                        <label class="radio-inline">
                            <input type="radio" name="liuXueGuoJia" id="inlineRadio6" value="jianada"> 加拿大
                        </label>
                    </div>
                    <div class="form-group">
                        <label>目前就读年级</label>
                        <select class="form-control" name="nianJi">
                            <option>1</option>
                            <option>2</option>
                            <option>3</option>
                            <option>4</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label>计划出国时间</label>
                        <input class="form-control form_date" type="text" value="" name="chuGuoShiJian" data-date-format="yyyy-mm-dd" data-link-format="yyyy-mm-dd">
                    </div>
                    <button type="button" class="btn btn-primary btn-lg btn-block">获取留学方案</button>
                </form>
            </div>
        </div>
    </div>

    <!--<a class="left carousel-control" href="#liuXueHui-biSheng" role="button" data-slide="prev">-->
        <!--<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>-->
        <!--<span class="sr-only">Previous</span>-->
    <!--</a>-->
    <!--<a class="right carousel-control" href="#liuXueHui-biSheng" role="button" data-slide="next">-->
        <!--<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>-->
        <!--<span class="sr-only">Next</span>-->
    <!--</a>-->
</div>

<!--内容区-->
<div class="container" id="main_content">
    <div class="row">
        <div class="col-md-6 col-md-offset-1">
            <div class="col-md-9">
                <div id="liuXueHui-mingShi" class="carousel slide" data-ride="carousel">
                    <ol class="carousel-indicators">
                        <c:forEach items="${mingShiIndexList}" var="mingShi" varStatus="status">
                        	<c:if test="${status.first}">
                        		<li data-target="#liuXueHui-mingShi" data-slide-to="0" class="active"></li>
                        	</c:if>
                        	<c:if test="${!status.first}">
                        		<li data-target="#liuXueHui-mingShi" data-slide-to="1"></li>
                        	</c:if>
                    	</c:forEach>
                    </ol>
                    <div class="carousel-inner" role="listbox">
                        <c:forEach items="${mingShiIndexList}" var="mingShi" varStatus="status">
                        	<c:if test="${status.first}">
                        		<div class="item active">
                        			<a href="${path}/mingshi/content.shtml?mingShiGuid=${mingShi.guid}">
                        				<img src="${path}/static/uploadImg/mingshi/index/${mingShi.indexPhotoName}" alt="${mingShi.name}">
                        			</a>
		                            <div class="carousel-caption">
		                                <h4>${mingShi.name}</h4>
		                                <p>${mingShi.indexMiaoShu}</p>
		                            </div>
		                        </div>
                        	</c:if>
                        	<c:if test="${!status.first}">
                        		<div class="item">
                        			<a href="${path}/mingshi/content.shtml?mingShiGuid=${mingShi.guid}">
		                            	<img src="${path}/static/uploadImg/mingshi/index/${mingShi.indexPhotoName}" alt="${mingShi.name}">
		                            </a>
		                            <div class="carousel-caption">
		                                <h4>${mingShi.name}</h4>
		                                <p>${mingShi.indexMiaoShu}</p>
		                            </div>
		                        </div>
                        	</c:if>
                    	</c:forEach>
                    </div>
                    <a class="left carousel-control" href="#liuXueHui-mingShi" role="button" data-slide="prev">
                        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                    </a>
                    <a class="right carousel-control" href="#liuXueHui-mingShi" role="button" data-slide="next">
                        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                    </a>
                </div>
            </div>
            <div class="col-md-3 text-center more-mingshi">
                <img src="${path}/static/img/jinPaiMingShi.png" alt="金牌名师">
                <a href="${path}/mingshi/more.shtml?pageNo=1">更多名师</a>
            </div>
        </div>
        <div class="col-md-4 jinPaiWenAn">
            <div class="biaoTi">
                <span>金牌文案</span>
                <a href="${path}/wenan/more.shtml?pageNo=1" class="more">更多金牌文案</a>
            </div>
            <c:forEach items="${wenAnIndexList}" var="wenAn" varStatus="status">
            	<div class="media">
	                <div class="media-left">
	                    <a href="${path}/wenan/content.shtml?wenAnGuid=${wenAn.guid}">
	                        <img class="media-object" src="${path}/static/uploadImg/wenan/index/${wenAn.indexPhotoName}" alt="${wenAn.name}">
	                    </a>
	                </div>
	                <div class="media-body">
	                    <h4>${wenAn.name}</h4>
	                    <span>${wenAn.shenFen}</span>
	                    <p>${wenAn.indexMiaoShu}</p>
	                </div>
	            </div>
            </c:forEach>
        </div>
    </div>
    <div class="row">
        <div class="col-md-10 col-md-offset-1 ziXunGuWen">
            <div class="biaoTi">
                <span>咨询顾问/Gold Consultant</span>
                <a href="${path}/guwen/more.shtml?pageNo=1" class="more">更多>></a>
            </div>
            <c:forEach items="${guWenIndexList}" var="guWen" varStatus="status">
            	<div class="col-xs-6 col-sm-3 renYuan">
	                <div class="thumbnail">
	                    <a href="${path}/guwen/content.shtml?guWenGuid=${guWen.guid}"><img src="${path}/static/uploadImg/guwen/index/${guWen.indexPhotoName}" alt="${guWen.name}"></a>
	                    <div class="caption">
	                        <span>${guWen.name}</span>
	                        <p>${guWen.indexMiaoShu}</p>
	                    </div>
	                </div>
	            </div>
            </c:forEach>
            
        </div>
    </div>
    <div class="row">
        <div class="col-md-4 col-md-offset-1 teJiaKeCheng">
            <div class="biaoTi">
                <span>特价课程</span>
                <a href="${path}/kecheng/more.shtml?pageNo=1" class="more">+ 更多</a>
            </div>
            <div class="col-md-12 keCheng">
                <ul>
                	<c:forEach items="${keChengIndexList}" var="keCheng" varStatus="status">
                		<li>
                			<a href="${path}/kecheng/content.shtml?keChengGuid=${keCheng.guid}">
                				<span>${keCheng.indexMiaoShu}</span><br>
		                        <span class="time">报名截止时间：<fmt:formatDate value="${keCheng.endTime}" pattern="yyyy-MM-dd"/></span>
		                        <span class="baoMing">已报名：<span class="badge">${keCheng.baoMingRenShu}</span></span>
                			</a>
	                    </li>
                	</c:forEach>
                </ul>
            </div>
        </div>
        <div class="col-md-6 get-offer">
            <div class="biaoTi">
                <span>成功案例</span>
                <a href="${path}/student/more.shtml?pageNo=1" class="more">+ 更多</a>
            </div>
            <div class="col-md-12 offer">
            	<c:forEach items="${studentIndexList}" var="student" varStatus="status">
            		<c:if test="${status.index==0}">
            			<a href="${path}/student/content.shtml?studentGuid=${student.guid}">
		                    <div class="offer-1 diyi">
		                        <div class="one"></div>
		                        <div class="two"></div>
		                        <img src="${path}/static/uploadImg/xuesheng/index/${student.indexPhotoName}">
		                        <div class="three"></div>
		                        <div class="four"></div>
		                        <div class="gaoBai">
		                            <span>我叫${student.name}</span><br>
		                            <span>感谢留学慧，助我获得${student.jinRuXueXiao}的offer</span>
		                        </div>
		                    </div>
		                </a>
            		</c:if>
            		<c:if test="${status.index==1}">
            			<a href="${path}/student/content.shtml?studentGuid=${student.guid}">
		                    <div class="offer-1 dier">
		                        <div class="one"></div>
		                        <div class="two"></div>
		                        <img src="${path}/static/uploadImg/xuesheng/index/${student.indexPhotoName}">
		                        <div class="three"></div>
		                        <div class="four"></div>
		                        <div class="gaoBai">
		                            <span>我叫${student.name}</span><br>
		                            <span>感谢留学慧，助我获得${student.jinRuXueXiao}的offer</span>
		                        </div>
		                    </div>
		                </a>
            		</c:if>
            		<c:if test="${status.index==2}">
            			<a href="${path}/student/content.shtml?studentGuid=${student.guid}">
		                    <div class="offer-1 disan">
		                        <div class="one"></div>
		                        <div class="two"></div>
		                        <img src="${path}/static/uploadImg/xuesheng/index/${student.indexPhotoName}">
		                        <div class="three"></div>
		                        <div class="four"></div>
		                        <div class="gaoBai">
		                            <span>我叫${student.name}</span><br>
		                            <span>感谢留学慧，助我获得${student.jinRuXueXiao}的offer</span>
		                        </div>
		                    </div>
		                </a>
            		</c:if>
            		<c:if test="${status.index==3}">
            			<a href="${path}/student/content.shtml?studentGuid=${student.guid}">
		                    <div class="offer-1 disi">
		                        <div class="one"></div>
		                        <div class="two"></div>
		                        <img src="${path}/static/uploadImg/xuesheng/index/${student.indexPhotoName}">
		                        <div class="three"></div>
		                        <div class="four"></div>
		                        <div class="gaoBai">
		                            <span>我叫${student.name}</span><br>
		                            <span>感谢留学慧，助我获得${student.jinRuXueXiao}的offer</span>
		                        </div>
		                    </div>
		                </a>
            		</c:if>
            		<c:if test="${status.index==4}">
            			<a href="${path}/student/content.shtml?studentGuid=${student.guid}">
		                    <div class="offer-1 diwu">
		                        <div class="one"></div>
		                        <div class="two"></div>
		                        <img src="${path}/static/uploadImg/xuesheng/index/${student.indexPhotoName}">
		                        <div class="three"></div>
		                        <div class="four"></div>
		                        <div class="gaoBai">
		                            <span>我叫${student.name}</span><br>
		                            <span>感谢留学慧，助我获得${student.jinRuXueXiao}的offer</span>
		                        </div>
		                    </div>
		                </a>
            		</c:if>
            	</c:forEach>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-10 col-md-offset-1 text-center heZuoJiGou">
            <span class="left-xian">———</span><span class="biao">—  我们的合作机构  —</span><span class="right-xian">———</span><br>
            <c:forEach items="${ziXunJiGouIndexList}" var="jiGou" varStatus="status">
            	<div class="col-xs-6 col-sm-4 col-md-2 text-center">
	                <a href="${path}/jigou/content.shtml?jiGouGuid=${jiGou.guid}">
	                    <img src="${path}/static/uploadImg/jigou/index/${jiGou.indexPhotoName}" class="img-rounded">
	                </a>
	            </div>
            </c:forEach>
        </div>
    </div>
</div>
<jsp:include page="footer.jsp"></jsp:include>
<script src="${path}/static/js/jquery-1.11.0.js"></script>
<script src="${path}/static/js/bootstrap.min.js"></script>
<script src="<%=path %>/static/js/bootstrap-datetimepicker.min.js"></script>
<script>
    $(function(){
        
        $(".offer-1").hover(
            function(){
                $(this).children("div.gaoBai").slideDown(100);
            },
            function(){
                $(this).children("div.gaoBai").slideUp(50);
            }
        );
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