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
						<td>行政代码</td>
						<td>${item.code}</td>
					</tr>
					<tr>
						<td>名称</td>
						<td>${item.name}</td>
					</tr>
					<tr>
						<td>父id</td>
						<td>${item.parentId}</td>
					</tr>
					<tr>
						<td>首字母</td>
						<td>${item.firstLetter}</td>
					</tr>
					<tr>
						<td>城市等级</td>
						<td>${item.level}</td>
					</tr>
		</table>
	</div>
</body>
</html>