<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
				<td>数据类型</td>
				<td>${item.type}</td>
			</tr>
			<tr>
				<td>描述内容</td>
				<td>${item.content}</td>
			</tr>
		</table>
	</div>
</body>
</html>