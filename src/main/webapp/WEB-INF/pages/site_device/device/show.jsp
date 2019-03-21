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
			<button class="layui-btn  layui-btn-sm layui-btn-normal" onclick="JavaScript:window.location.href='min/device/${item.id}/put/pre?siteId=${siteId }'">
				<i class="layui-icon">&#xe642;</i>修改设备信息
			</button>
		</div>
	</div>
	<div class="layui-form"  style="margin: 10px;">
		<table class="layui-table">
			<tr>
				<td width="20%">设备名称</td>
				<td width="80%">${item.deviceName}</td>
			</tr>
			<tr>
				<td>设备类型</td>
				<td>${item.deviceType}</td>
			</tr>
			<tr>
				<td>设备IP</td>
				<td>${item.deviceIp}</td>
			</tr>
			<tr>
				<td>设备端口</td>
				<td>${item.devicePort}</td>
			</tr>
			<tr>
				<td>注册字</td>
				<td>${item.deviceReg}</td>
			</tr>
		</table>
	</div>
</body>
</html>