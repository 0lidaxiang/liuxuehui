<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
request.setAttribute("path",path);
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!doctype html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="baidu-site-verification" content="6oM4nu5rFH" />
		<script type="text/javascript">
			window.location.href="${path}/home/goHome.shtml"
		</script>
	</head>
	<body>
		<div>
		</div>
	</body>
</html>
