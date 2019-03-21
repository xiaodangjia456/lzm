<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- include _comm.jsp -->
<%@ include file="/comm/_comm.jsp"%>
<!-- title -->
<title>林之牧物联网</title>
</head>
<!-- body -->
<body>
	
	<div class="layui-form"  style="margin: 10px;">
		<table class="layui-table">
			<tr>
				<td>用户信息</td>
				<td>${item.user}</td>
			</tr>
			<tr>
				<td>日志内容</td>
				<td>${item.record}</td>
			</tr>
			<tr>
				<td>执行方法</td>
				<td>${item.method}</td>
			</tr>
			<tr>
				<td>操作表</td>
				<td>${item.tableName}</td>
			</tr>
			<tr>
				<td>IP地址</td>
				<td>${item.ipAddr}</td>
			</tr>
			<tr>
				<td>执行时间</td>
				<td>${item.creatTime}</td>
			</tr>
		</table>
	</div>
</body>
</html>