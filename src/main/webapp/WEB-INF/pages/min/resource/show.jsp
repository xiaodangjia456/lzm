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
						<td>资源编号</td>
						<td>${item.resourceCode}</td>
					</tr>
					<tr>
						<td>资源名称</td>
						<td>${item.resourceName}</td>
					</tr>
					<tr>
						<td>父  id</td>
						<td>${item.inheritCode}</td>
					</tr>
					<tr>
						<td>资源等级</td>
						<td>${item.levels}</td>
					</tr>
					<tr>
						<td>资源图片</td>
						<td>${item.imagePath}</td>
					</tr>
					<tr>
						<td>资源访问路径</td>
						<td>${item.resourceUrl}</td>
					</tr>
					<tr>
						<td>是否可用</td>
						<td>${item.isAbleTable}</td>
					</tr>
		</table>
	</div>
</body>
</html>