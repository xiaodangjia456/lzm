<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- include _comm.jsp -->
<%@ include file="/comm/_comm.jsp"%>
<!-- title -->
<title>林之牧物联网</title>
</head>
<!-- body -->
<body>
<br>
	<div class="layui-form">
		<table class="layui-table">
					<tr>
						<td>角色ID</td>
						<td>${item.roleId}</td>
					</tr>
					<tr>
						<td>资源ID</td>
						<td>${item.resourceId}</td>
					</tr>
					<tr>
						<td>用户ID</td>
						<td>${item.userId}</td>
					</tr>
		</table>
	</div>
</body>
</html>