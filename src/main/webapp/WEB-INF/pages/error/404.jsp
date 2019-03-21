<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String contextPath = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<!-- Viewport metatags -->
<meta name="HandheldFriendly" content="true" />
<meta name="MobileOptimized" content="320" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />

<link rel="stylesheet" type="text/css"
	href="<%=contextPath%>/css/min/dandelion.css" media="screen" />

<title>林之牧物联网--404</title>

<script type="text/javascript"
	src="<%=contextPath%>/js/comm/jquery-1.4.4.min.js"></script>
<script type="text/javascript">
	var i = 5;
	function myrefresh() {
		i = parseInt(parseInt(i) - 1);
		$("#min_num").text(i);
		if (parseInt(i) == 0) {
			/**
			var contextPath = $("#contextPath").val();
			var url = contextPath + '/min/default/tologin';
			//if (window.parent.length > 0)
			window.parent.location = url;
			//window.location.href = url;
			*/
			javascript:history.go(-1); 
		} else {
			refreshTime();
		}
	}
	function refreshTime() {
		setTimeout('myrefresh()', 1000);
		//javascript:history.go(-1); 
	}
</script>
</head>

<body onload="refreshTime();">
	<input type="hidden" id="contextPath" name="contextPath"
		value="<%=contextPath%>" />

	<!-- Main Wrapper. Set this to 'fixed' for fixed layout and 'fluid' for fluid layout' -->
	<div id="da-wrapper" class="fluid">

		<!-- Content -->
		<div id="da-content">

			<!-- Container -->
			<div class="da-container clearfix">

				<div id="da-error-wrapper">

					<div id="da-error-pin"></div>
					<div id="da-error-code">
						error <span>404</span>
					</div>

					<h1 class="da-error-heading">提示：网速不稳、服务器已关闭或者您所用的登陆用户没有权限等多种原因！</h1>
					<h2>
						<span id="min_num">5</span>秒后自动跳转至登录页面！
					</h2>
					<p>如有问题请与管理员联系，QQ号码：188816675</p>
				</div>
			</div>
		</div>

		<!-- Footer -->
		<div id="da-footer">
			<div class="da-container clearfix">
				<p>COPYRIGHT ©2014-2016POWEREDBY林之牧物联网ALLRIGHTSRESERVED</p>
			</div>
		</div>
	</div>

</body>
</html>
