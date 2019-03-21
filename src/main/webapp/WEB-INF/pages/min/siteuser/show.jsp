<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- include _comm.jsp -->
<%@ include file="/WEB-INF/pages/comm/_comm.jsp"%>
<!-- title -->
<title>Insert title here</title>
</head>
<!-- body -->
<body>
<br>
<!-- 修改按钮 Start-->
	<div class="layui-form-item">
		<div class="site-demo-button" style="margin: 10px 0 0 10px;">
			<button type="button" class="layui-btn  layui-btn-sm layui-btn-normal" onclick="JavaScript:window.location.href='min/siteuser/${item.id}/put/pre'">
				<i class="layui-icon layui-anim layui-anim-rotate">&#xe642;</i>修改信息
			</button>
		</div>
	</div>
	
<!-- 修改按钮 End-->

<!-- Table Start -->
	<table class="layui-table">
		
		<tr>
			<td width="20%">用户IDUSER_ID</td>
			<td width="80%">${item.userId}</td>
		</tr>
		
		<tr>
			<td width="20%">站点IDSITE_ID</td>
			<td width="80%">${item.siteId}</td>
		</tr>
		
		<tr>
			<td width="20%">是否可预览SEE</td>
			<td width="80%">${item.see}</td>
		</tr>
		
		<tr>
			<td width="20%">是否可控制ACT</td>
			<td width="80%">${item.act}</td>
		</tr>
	</table>
<!-- Table End -->
</body>
</html>