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
						<td>角色名称</td>
						<td>${item.roleName}</td>
					</tr>
					<tr>
						<td>是否可用</td>
						<td>${item.isAble}</td>
					</tr>
					<tr>
						<td>角色级别</td>
						<td>${item.levels}</td>
					</tr>
		</table>
	</div>
</body>
</html>