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
			<button type="button" class="layui-btn  layui-btn-sm layui-btn-normal" onclick="JavaScript:window.location.href='min/qihou/${item.id}/put/pre'">
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
			<td width="20%">设备IdDEVICE_ID</td>
			<td width="80%">${item.deviceId}</td>
		</tr>
		
		<tr>
			<td width="20%">注册字ZHUCE</td>
			<td width="80%">${item.zhuce}</td>
		</tr>
		
		<tr>
			<td width="20%">日期RIQI</td>
			<td width="80%">${item.riqi}</td>
		</tr>
		
		<tr>
			<td width="20%">时间SHIJIAN</td>
			<td width="80%">${item.shijian}</td>
		</tr>
		
		<tr>
			<td width="20%">空气温度KONGQIWENDU</td>
			<td width="80%">${item.kongqiwendu}</td>
		</tr>
		
		<tr>
			<td width="20%">空气湿度KONGQISHIDU</td>
			<td width="80%">${item.kongqishidu}</td>
		</tr>
		
		<tr>
			<td width="20%">大气压强DAQIYAQIANG</td>
			<td width="80%">${item.daqiyaqiang}</td>
		</tr>
		
		<tr>
			<td width="20%">风向FENGXIANG</td>
			<td width="80%">${item.fengxiang}</td>
		</tr>
		
		<tr>
			<td width="20%">风速FENGSU</td>
			<td width="80%">${item.fengsu}</td>
		</tr>
		
		<tr>
			<td width="20%">降雨量YULIANG</td>
			<td width="80%">${item.yuliang}</td>
		</tr>
		
		<tr>
			<td width="20%">蒸发量ZHENGFALIANG</td>
			<td width="80%">${item.zhengfaliang}</td>
		</tr>
		
		<tr>
			<td width="20%">光照强度GUANGZHAOQIANGDU</td>
			<td width="80%">${item.guangzhaoqiangdu}</td>
		</tr>
		
		<tr>
			<td width="20%">光合有效辐射GUANGHE</td>
			<td width="80%">${item.guanghe}</td>
		</tr>
		
		<tr>
			<td width="20%">总辐射ZONGFUSHE</td>
			<td width="80%">${item.zongfushe}</td>
		</tr>
		
		<tr>
			<td width="20%">土壤温度10cmTURANGWENDU1</td>
			<td width="80%">${item.turangwendu1}</td>
		</tr>
		
		<tr>
			<td width="20%">土壤温度20cmTURANGWENDU2</td>
			<td width="80%">${item.turangwendu2}</td>
		</tr>
		
		<tr>
			<td width="20%">土壤温度30cmTURANGWENDU3</td>
			<td width="80%">${item.turangwendu3}</td>
		</tr>
		
		<tr>
			<td width="20%">土壤湿度10cmTURANGSHIDU1</td>
			<td width="80%">${item.turangshidu1}</td>
		</tr>
		
		<tr>
			<td width="20%">土壤湿度20cmTURANGSHIDU2</td>
			<td width="80%">${item.turangshidu2}</td>
		</tr>
		
		<tr>
			<td width="20%">土壤湿度30cmTURANGSHIDU3</td>
			<td width="80%">${item.turangshidu3}</td>
		</tr>
		
		<tr>
			<td width="20%">土壤可溶浓度TURANG_EC</td>
			<td width="80%">${item.turangEc}</td>
		</tr>
		
		<tr>
			<td width="20%">土壤PH值TURANG_PH</td>
			<td width="80%">${item.turangPh}</td>
		</tr>
	</table>
<!-- Table End -->
</body>
</html>