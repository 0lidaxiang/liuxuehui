<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
    <title>咨询顾问</title>
    <!-- Bootstrap -->
    <link href="<%=path %>/static/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=path %>/static/css/liebiao2.css" rel="stylesheet">

    <!--[if lt IE 9]>
    <script src="<%=path %>/static/js/html5shiv.min.js"></script>
    <script src="<%=path %>/static/js/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<jsp:include page="head.jsp"></jsp:include>
<div class="container">
    <div class="row weiZhi">
        <div class="col-md-10 col-md-offset-1">
            <span>所在位置：咨询/留学顾问</span>
        </div>
    </div>
</div>
<div class="container" id="lieBiao">
    <div class="row ziXunGuWen">
        <div class="col-md-10 col-md-offset-1 paiXu">
            <div class="col-sm-6 xu">
                <ul class="nav nav-pills">
                    <li class="lieBiaoMingCheng">留学顾问</li>
                    <!-- 
                    <li role="presentation" class="active"><a href="#">综合排名</a></li>
                    <li role="presentation"><a href="#">雅思</a></li>
                    <li role="presentation"><a href="#">托福</a></li>
                    <li role="presentation"><a href="#">SAT</a></li>
                     -->
                </ul>
            </div>
            <div class="col-sm-6 text-right wanShan">
                <span>帮你推荐老师：<a href="#">完善留学意向</a></span>
            </div>
        </div>
        <div class="col-md-10 col-md-offset-1 head-search">
            <hr>
            <div class="search-tiaoJian">
                <form class="form-inline" method="post">
                    <div class="form-group">
                        <label for="leiXing">留学意向国家：</label>
                        <select class="form-control" name="yiXiangGuoJia" id="leiXing">
                            <option value="buXian">--不限--</option>
                            <option value="meiGuo">美国</option>
                            <option value="yingGuo">英国</option>
                            <option value="jiaNaDa">加拿大</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="diQu">目前就读年级：</label>
                        <select class="form-control" name="jiuDuNianJi" id="diQu">
                            <option value="buXian">--不限--</option>
                            <option value="one">1</option>
                            <option value="two">2</option>
                            <option value="three">3</option>
                            <option value="four">4</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="diQu">咨询形式：</label>
                        <select class="form-control" name="ziXunXingShi" id="diQu">
                            <option value="buXian">--不限--</option>
                            <option value="wang">网上</option>
                            <option value="dian">电话</option>
                            <option value="jian">见面</option>
                        </select>
                    </div>
                    <input type="text" class="form-control" placeholder="" id="search-name" name="search-name">
                    <button class="btn btn-primary" type="button" id="search-name-button">搜索</button>
                </form>

            </div>
        </div>
        <div class="col-md-10 col-md-offset-1">
            <c:forEach items="${guWenList}" var="guWen" varStatus="status">
        		<div class="col-sm-12 guWen-content">
	                <div class="col-sm-5 text-center content-img">
	                    <a href="${path}/guwen/content.shtml?guWenGuid=${guWen.guid}">
	                    	<img src="${path}/static/uploadImg/guwen/liebiao/${guWen.photoName}">
	                    </a>
	                </div>
	                <div class="col-sm-7 content-miaoShu">
	                    <a href="${path}/guwen/content.shtml?guWenGuid=${guWen.guid}"><h4>${guWen.name}</h4></a>
	                    <div class="col-sm-6 xiaoKuai">
	                        <p><span class="miaoshu-title">身份：</span>${guWen.shenFen}</p>
	                    </div>
	                    <div class="col-sm-6 xiaoKuai">
	                        <p><span class="miaoshu-title">入行时间：</span>${guWen.ruHangShiJian}</p>
	                    </div>
	                    <div class="col-sm-6 xiaoKuai">
	                        <p><span class="miaoshu-title">擅长国家：</span>${guWen.shanChangGuoJia}</p>
	                    </div>
	                    <div class="col-sm-6 xiaoKuai">
	                        <p><span class="miaoshu-title">咨询形式：</span>${guWen.ziXunXingShi}</p>
	                    </div>
	                    <p><span class="miaoshu-title">擅长专业：</span>${guWen.shanChangZuanYe}</p>
	                    <p><span class="miaoshu-title">职业信条：</span>${guWen.zhiYeXinTiao}</p>
	                    <p><span class="miaoshu-title">学员评价：</span>${guWen.xueYuanPinJia}</p>
	                </div>
	            </div>
        	</c:forEach>


        </div>

    </div>
    <c:import url="/view/page.jsp"></c:import>
</div>


<jsp:include page="footer.jsp"></jsp:include>
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
        </div>
    </div>
</div>
<script src="<%=path %>/static/js/jquery-1.11.0.js"></script>
<script src="<%=path %>/static/js/bootstrap.min.js"></script>
</body>
</html>