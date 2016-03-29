<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
    <title>在线测评</title>
    <!-- Bootstrap -->
    <link href="<%=path %>/static/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=path %>/static/css/bootstrap-datetimepicker.min.css" rel="stylesheet">
    <link href="<%=path %>/static/css/zaiXianCePing.css" rel="stylesheet">

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
            <span>所在位置：留学慧在线测评</span>
        </div>
    </div>
</div>
<div class="container-fluid main">
    <div class="row">
        <div class="col-xs-12 col-sm-9 col-md-8 col-sm-offset-2 col-md-offset-2 right_content">
            <div class="row tianXieXinXi">
                <h4>在线测评 - 获取留学方案</h4>
                <div class="col-md-12 col-md-offset-3 content_jiChu">
                    <form class="form-horizontal" id="cePing_form" method="post" action="<%=path%>/onlinetest/savetest.shtml">
                        <div class="form-group">
                            <label for="inputGuoJia" class="col-sm-2 control-label">所在国家</label>
                            <div class="col-sm-8 col-md-6">
                                <input type="text" class="form-control" name="guoJia" id="inputGuoJia" value="中国" readonly="readonly">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputxuexiao" class="col-sm-2 control-label">最近就读学校</label>
                            <div class="col-sm-8 col-md-6">
                                <input type="text" name="school" class="form-control" id="inputxuexiao" placeholder="学校">
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">就读年级</label>
                            <div class="col-sm-8 col-md-6">
                                <select class="form-control" name="grade" id="nianJi">
                                    <option>1</option>
                                    <option>2</option>
                                    <option selected>3</option>
                                    <option>4</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputZhuanYe" class="col-sm-2 control-label">在读专业</label>
                            <div class="col-sm-8 col-md-6">
                                <input type="text" name="major" class="form-control" id="inputZhuanYe" placeholder="专业">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputYuYanCJ" class="col-sm-2 control-label">语言成绩</label>
                            <div class="col-sm-8 col-md-6 chengji">
                                <div class="col-xs-6">
                                    <select class="form-control" name="examType" id="yuYanLeiXing">
                                        <option value="雅思" selected>雅思</option>
                                        <option value="托福">托福</option>
                                        <option value="GRE">GRE</option>
                                    </select>
                                </div>
                                <div class="col-xs-6">
                                    <input type="text" name="score" class="form-control" id="inputYuYanCJ" placeholder="分数">
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-sm-2 control-label">意向留学国家</label>
                            <div class="col-sm-8 col-md-6" id="liuXueGuoJia">
                                <label class="checkbox-inline">
                                    <input type="checkbox" name="intentionCountry" id="inputLiuXueDi1" value="英国">英国
                                </label>
                                <label class="checkbox-inline">
                                    <input type="checkbox" name="intentionCountry" id="inputLiuXueDi2" value="澳洲">澳洲
                                </label>
                                <label class="checkbox-inline">
                                    <input type="checkbox" name="intentionCountry" id="inputLiuXueDi3" value="新西兰">新西兰
                                </label>
                                <label class="checkbox-inline">
                                    <input type="checkbox" name="intentionCountry" id="inputLiuXueDi4" value="日韩">日韩
                                </label>
                                <label class="checkbox-inline">
                                    <input type="checkbox" name="intentionCountry" id="inputLiuXueDi5" value="美国">美国
                                </label>
                                <label class="checkbox-inline">
                                    <input type="checkbox" name="intentionCountry" id="inputLiuXueDi6" value="加拿大">加拿大
                                </label>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputLiuXueZY" class="col-sm-2 control-label">希望就读专业</label>
                            <div class="col-sm-8 col-md-6">
                                <input type="text" name="intentionMajor" class="form-control" id="inputLiuXueZY" placeholder="新闻">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputChuGuoShiJian" class="col-sm-2 control-label">计划出国时间</label>
                            <div class="col-sm-8 col-md-6">
                                <div class="input-group date form_date col-md-12" data-date="" data-date-format="yyyy-mm-dd" data-link-field="dtp_input2" data-link-format="yyyy-mm-dd">
                                    <input class="form-control" name="planOutTime" type="text" value="" readonly  id="inputChuGuoShiJian">
                                    <span class="input-group-addon"><span class="glyphicon glyphicon-remove"></span></span>
                                    <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="inputTel" class="col-sm-2 control-label">手机号码</label>
                            <div class="col-sm-8 col-md-6">
                                <input type="tel" name="phoneNumber" class="form-control" id="inputTel" placeholder="tel">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-8 col-md-8 text-center">
                                <button type="button" class="btn btn-warning" id="tijiao">提交测评信息</button>
                                <c:if test="${!empty result}">
                                   <font color="red"><c:out value="${result}"/></font>
                                </c:if>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
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
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
<jsp:include page="footer.jsp"></jsp:include>
<script src="<%=path %>/static/js/jquery-1.11.0.js"></script>
<script src="<%=path %>/static/js/bootstrap.min.js"></script>
<script src="<%=path %>/static/js/bootstrap-datetimepicker.min.js"></script>
<script>
    $(function(){
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
        $("#tijiao").click(function(){
            var xueXiao = $("#inputxuexiao").val();
            var zhuanYe = $("#inputZhuanYe").val();
            var liuXueYiXiang = $("#liuXueGuoJia input:checked").length;
            var yiXiangZhuanYe = $("#inputLiuXueZY").val();
            var chuGuoShiJian = $("#inputChuGuoShiJian").val();
            var tel = $("#inputTel").val();
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
            }else if(tel==''){
                $(".modal-body p").text("手机号码必须填写");
                $('#tiShi').modal({keyboard: false});
            }else if(!checkMobileNumber(tel)){
                $(".modal-body p").text("手机号码格式错了");
                $('#tiShi').modal({keyboard: false});
            }else{
                $("#cePing_form").submit();
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