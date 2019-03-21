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
			<button class="layui-btn  layui-btn-sm layui-btn-normal" onclick="JavaScript:window.location.href='min/user/${item.id}/put/pre'">
				<i class="layui-icon">&#xe642;</i>修改个人信息
			</button>
		</div>
	</div>
	<div class="layui-form"  style="margin: 10px;">
		<table class="layui-table no_border_shadow">
			<tr>
				<td width="20%" align="right">登录账号</td>
				<td width="80%">${item.name}</td>
			</tr>
			<tr>
				<td align="right">联系电话</td>
				<td>${item.phone}</td>
			</tr>
			<tr>
				<td align="right">真实姓名</td>
				<td>${item.realName}</td>
			</tr>
			<tr>
				<td align="right">详细地址</td>
				<td>${item.address}</td>
			</tr>
			<tr>
				<td align="right">角色</td>
				<td>${item.role.roleName}</td>
			</tr>
		</table>
	</div>
</body>
</html>