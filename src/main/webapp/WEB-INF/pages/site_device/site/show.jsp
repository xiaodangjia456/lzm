<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- include _comm.jsp -->
<%@ include file="/comm/_comm.jsp"%>
<!-- title -->
<title>林之牧物联网</title>
</head>
<!-- body -->
<body>
	<div class="layui-form-item">
		<div class="site-demo-button" style="margin: 10px 0 0 10px;">
			<button class="layui-btn  layui-btn-sm layui-btn-normal" onclick="JavaScript:window.location.href='min/site/${item.id}/put/pre'">
				<i class="layui-icon">&#xe642;</i>修改站点信息
			</button>
		</div>
	</div>
	
	<div class="layui-form"  style="margin: 10px;">
		<table class="layui-table">
			<tr>
				<td width="20%">站点名称</td>
				<td width="80%">${item.siteName}</td>
			</tr>
			<tr>
				<td>站点IP</td>
				<td>${item.siteIp}</td>
			</tr>
			<tr>
				<td>站点端口号</td>
				<td>${item.sitePort}</td>
			</tr>
			<tr>
				<td>站点密码</td>
				<td>${item.sitePwd}</td>
			</tr>
			<tr>
				<td>操作人</td>
				<td>${item.user.name}</td>
			</tr>
		</table>
	</div>
</body>
</html>