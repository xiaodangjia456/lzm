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
			<button type="button" class="layui-btn  layui-btn-sm layui-btn-normal" onclick="JavaScript:window.location.href='min/imgspore/${item.id}/put/pre'">
				<i class="layui-icon layui-anim layui-anim-rotate">&#xe642;</i>修改信息
			</button>
		</div>
	</div>
	
<!-- 修改按钮 End-->

<!-- Table Start -->
	<table class="layui-table">
		
		<tr>
			<td width="20%">站点IdSITE_ID</td>
			<td width="80%">${item.siteId}</td>
		</tr>
		
		<tr>
			<td width="20%">站点别名SITE_ALIAS</td>
			<td width="80%">${item.siteAlias}</td>
		</tr>
		
		<tr>
			<td width="20%">设备IdDEVICE_ID</td>
			<td width="80%">${item.deviceId}</td>
		</tr>
		
		<tr>
			<td width="20%">图片日期（年-月-日）IMG_DATE</td>
			<td width="80%">${item.imgDate}</td>
		</tr>
		
		<tr>
			<td width="20%">图片名称IMG_NAME</td>
			<td width="80%">${item.imgName}</td>
		</tr>
		
		<tr>
			<td width="20%">图片全路径IMG_PATH</td>
			<td width="80%">${item.imgPath}</td>
		</tr>
		
		<tr>
			<td width="20%">数据创建时间CREATE_TIME</td>
			<td width="80%">${item.createTime}</td>
		</tr>
		
		<tr>
			<td width="20%">图片类型IMG_TYPE</td>
			<td width="80%">${item.imgType}</td>
		</tr>
	</table>
<!-- Table End -->
</body>
</html>