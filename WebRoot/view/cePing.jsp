<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head lang="zh-CN">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>用户中心-留学测评</title>
    <!-- Bootstrap -->
    <link href="<%=path %>/static/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=path %>/static/css/bootstrap-datetimepicker.min.css" rel="stylesheet">
    <link href="<%=path %>/static/css/user.css" rel="stylesheet">

    <!--[if lt IE 9]>
    <script src="<%=path %>/static/js/html5shiv.min.js"></script>
    <script src="<%=path %>/static/js/respond.min.js"></script>
    <![endif]-->

</head>
<body>
<jsp:include page="head.jsp"></jsp:include>
<div class="container main">
    <div class="row">
        <div class="col-xs-12 col-sm-3 col-md-3 left_nav text-center">
            <img src="<%=path %>/static/img/touxiang.jpg" for="exampleInputFile" class="img-circle touxiang">
            <ul class="nav nav-pills nav-stacked text-center left_nav_shu">
                <li role="presentation"><a href="user.jsp">基本信息</a></li>
                <li role="presentation"><a href="dingDan.jsp">我的订单</a></li>
                <li role="presentation" class="active"><a href="#">留学测评</a></li>
            </ul>
            <ul class="nav nav-pills text-center left_nav_heng">
                <li role="presentation"><a href="user.jsp">基本信息</a></li>
                <li role="presentation"><a href="dingDan.jsp">我的订单</a></li>
                <li role="presentation" class="active"><a href="#">留学测评</a></li>
            </ul>
        </div>
        <div class="col-xs-12 col-sm-9 col-md-9 right_content">
            <div class="row">
                <div class="col-md-12 content_jiChu">
                    <h4>留学测评-获取留学方案</h4>
                    <form class="form-horizontal" id="cePing_form" method="post" action="">
                        <div class="form-group">
                            <label for="inputGuoJia" class="col-sm-2 control-label">所在国家</label>
                            <div class="col-sm-8 col-md-6">
                                <input type="text" class="form-control" id="inputGuoJia" value="中国" disabled>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputxuexiao" class="col-sm-2 control-label">最近就读学校</label>
                            <div class="col-sm-8 col-md-6">
                                <input type="text" class="form-control" id="inputxuexiao" placeholder="学校">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">就读年级</label>
                            <div class="col-sm-8 col-md-6">
                                <select class="form-control" id="nianJi">
                                    <option>1</option>
                                    <option>2</option>
                                    <option>3</option>
                                    <option>4</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputZhuanYe" class="col-sm-2 control-label">在读专业</label>
                            <div class="col-sm-8 col-md-6">
                                <input type="text" class="form-control" id="inputZhuanYe" placeholder="专业">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputYuYanCJ" class="col-sm-2 control-label">语言成绩</label>
                            <div class="col-sm-8 col-md-6">
                                <input type="text" class="form-control" id="inputYuYanCJ" placeholder="eg:雅思9分">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">意向留学国家</label>
                            <div class="col-sm-8 col-md-6" id="liuXueGuoJia">
                                <label class="checkbox-inline">
                                    <input type="checkbox" id="inputLiuXueDi1" value="yingguo">英国
                                </label>
                                <label class="checkbox-inline">
                                    <input type="checkbox" id="inputLiuXueDi2" value="aozhou">澳洲
                                </label>
                                <label class="checkbox-inline">
                                    <input type="checkbox" id="inputLiuXueDi3" value="xinxilan">新西兰
                                </label>
                                <label class="checkbox-inline">
                                    <input type="checkbox" id="inputLiuXueDi4" value="rihan">日韩
                                </label>
                                <label class="checkbox-inline">
                                    <input type="checkbox" id="inputLiuXueDi5" value="meiguo">美国
                                </label>
                                <label class="checkbox-inline">
                                    <input type="checkbox" id="inputLiuXueDi6" value="jianada">加拿大
                                </label>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputLiuXueZY" class="col-sm-2 control-label">希望就读专业</label>
                            <div class="col-sm-8 col-md-6">
                                <input type="text" class="form-control" id="inputLiuXueZY" placeholder="新闻">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputChuGuoShiJian" class="col-sm-2 control-label">计划出国时间</label>
                            <div class="col-sm-8 col-md-6">
                                <div class="input-group date form_date col-md-12" data-date="" data-date-format="yyyy-mm-dd" data-link-field="dtp_input2" data-link-format="yyyy-mm-dd">
                                    <input class="form-control" type="text" value="" readonly  id="inputChuGuoShiJian">
                                    <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                                    <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-8 col-md-8 text-center">
                                <button type="button" class="btn btn-info" id="submit">提交测评信息</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>


<jsp:include page="footer.jsp"></jsp:include>
<script src="<%=path %>/static/js/jquery-1.11.0.js"></script>
<script src="<%=path %>/static/js/bootstrap.min.js"></script>
<script src="<%=path %>/static/js/bootstrap-datetimepicker.min.js"></script>
<script>
    $(function(){
        $(".form_date").datetimepicker({
            language:  'fr',
            weekStart: 1,
            todayBtn:  1,
            autoclose: 1,
            todayHighlight: 1,
            startView: 2,
            minView: 2,
            forceParse: 0
        });
       $("#submit").click(function(){
            var xueXiao = $("#inputxuexiao").val();
            var zhuanYe = $("#inputZhuanYe").val();
            var liuXueYiXiang = $("#liuXueGuoJia input:checked").length;
            var yiXiangZhuanYe = $("#inputLiuXueZY").val();
            var chuGuoShiJian = $("#inputChuGuoShiJian").val();
            if(xueXiao==""){
                $(".modal-body p").text("学校没填");
                $('#tiShi').modal({
                    keyboard: false
                });
            }else if(zhuanYe==""){
                $(".modal-body p").text("专业没填");
                $('#tiShi').modal({
                    keyboard: false
                });
            }else if(liuXueYiXiang==0){
                $(".modal-body p").text("留学意向没有选择");
                $('#tiShi').modal({
                    keyboard: false
                });
            }else if(yiXiangZhuanYe==""){
                $(".modal-body p").text("意向专业没有填写");
                $('#tiShi').modal({
                    keyboard: false
                });
            }else if(chuGuoShiJian==""){
                $(".modal-body p").text("计划出国时间没有选择");
                $('#tiShi').modal({
                    keyboard: false
                });
            }else{
                $("#cePing_form").submit();
            }

        });
    });
</script>
</body>
</html>