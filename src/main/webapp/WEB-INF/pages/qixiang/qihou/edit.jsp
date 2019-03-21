<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- include _comm.jsp -->
<%@ include file="/comm/_comm.jsp"%>
<!-- title -->
<title>林之牧物联网</title>
</head>
<!-- body -->
<body>
<form class="layui-form" data-type="ajax" action="min/qihou/${item.id}" id="formId" method="post">
	<div class="layui-form-item">
		<label class="layui-form-label">站点IdSITE_ID</label>
		<div class="layui-input-block">
			<input type="text" name="siteId" id="siteId" value="${item.siteId}" lay-verify="required" autocomplete="off" placeholder="请输入站点Id"
				class="layui-input">
		</div>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label">设备IdDEVICE_ID</label>
		<div class="layui-input-block">
			<input type="text" name="deviceId" id="deviceId" value="${item.deviceId}" lay-verify="required" autocomplete="off" placeholder="请输入设备Id"
				class="layui-input">
		</div>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label">注册字ZHUCE</label>
		<div class="layui-input-block">
			<input type="text" name="zhuce" id="zhuce" value="${item.zhuce}" lay-verify="required" autocomplete="off" placeholder="请输入注册字"
				class="layui-input">
		</div>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label">日期RIQI</label>
		<div class="layui-input-block">
			<input type="text" name="riqi" id="riqi" value="${item.riqi}" lay-verify="required" autocomplete="off" placeholder="请输入日期"
				class="layui-input">
		</div>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label">时间SHIJIAN</label>
		<div class="layui-input-block">
			<input type="text" name="shijian" id="shijian" value="${item.shijian}" lay-verify="required" autocomplete="off" placeholder="请输入时间"
				class="layui-input">
		</div>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label">空气温度KONGQIWENDU</label>
		<div class="layui-input-block">
			<input type="text" name="kongqiwendu" id="kongqiwendu" value="${item.kongqiwendu}" lay-verify="required" autocomplete="off" placeholder="请输入空气温度"
				class="layui-input">
		</div>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label">空气湿度KONGQISHIDU</label>
		<div class="layui-input-block">
			<input type="text" name="kongqishidu" id="kongqishidu" value="${item.kongqishidu}" lay-verify="required" autocomplete="off" placeholder="请输入空气湿度"
				class="layui-input">
		</div>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label">大气压强DAQIYAQIANG</label>
		<div class="layui-input-block">
			<input type="text" name="daqiyaqiang" id="daqiyaqiang" value="${item.daqiyaqiang}" lay-verify="required" autocomplete="off" placeholder="请输入大气压强"
				class="layui-input">
		</div>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label">风向FENGXIANG</label>
		<div class="layui-input-block">
			<input type="text" name="fengxiang" id="fengxiang" value="${item.fengxiang}" lay-verify="required" autocomplete="off" placeholder="请输入风向"
				class="layui-input">
		</div>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label">风速FENGSU</label>
		<div class="layui-input-block">
			<input type="text" name="fengsu" id="fengsu" value="${item.fengsu}" lay-verify="required" autocomplete="off" placeholder="请输入风速"
				class="layui-input">
		</div>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label">降雨量YULIANG</label>
		<div class="layui-input-block">
			<input type="text" name="yuliang" id="yuliang" value="${item.yuliang}" lay-verify="required" autocomplete="off" placeholder="请输入降雨量"
				class="layui-input">
		</div>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label">蒸发量ZHENGFALIANG</label>
		<div class="layui-input-block">
			<input type="text" name="zhengfaliang" id="zhengfaliang" value="${item.zhengfaliang}" lay-verify="required" autocomplete="off" placeholder="请输入蒸发量"
				class="layui-input">
		</div>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label">光照强度GUANGZHAOQIANGDU</label>
		<div class="layui-input-block">
			<input type="text" name="guangzhaoqiangdu" id="guangzhaoqiangdu" value="${item.guangzhaoqiangdu}" lay-verify="required" autocomplete="off" placeholder="请输入光照强度"
				class="layui-input">
		</div>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label">光合有效辐射GUANGHE</label>
		<div class="layui-input-block">
			<input type="text" name="guanghe" id="guanghe" value="${item.guanghe}" lay-verify="required" autocomplete="off" placeholder="请输入光合有效辐射"
				class="layui-input">
		</div>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label">总辐射ZONGFUSHE</label>
		<div class="layui-input-block">
			<input type="text" name="zongfushe" id="zongfushe" value="${item.zongfushe}" lay-verify="required" autocomplete="off" placeholder="请输入总辐射"
				class="layui-input">
		</div>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label">土壤温度10cmTURANGWENDU1</label>
		<div class="layui-input-block">
			<input type="text" name="turangwendu1" id="turangwendu1" value="${item.turangwendu1}" lay-verify="required" autocomplete="off" placeholder="请输入土壤温度10cm"
				class="layui-input">
		</div>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label">土壤温度20cmTURANGWENDU2</label>
		<div class="layui-input-block">
			<input type="text" name="turangwendu2" id="turangwendu2" value="${item.turangwendu2}" lay-verify="required" autocomplete="off" placeholder="请输入土壤温度20cm"
				class="layui-input">
		</div>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label">土壤温度30cmTURANGWENDU3</label>
		<div class="layui-input-block">
			<input type="text" name="turangwendu3" id="turangwendu3" value="${item.turangwendu3}" lay-verify="required" autocomplete="off" placeholder="请输入土壤温度30cm"
				class="layui-input">
		</div>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label">土壤湿度10cmTURANGSHIDU1</label>
		<div class="layui-input-block">
			<input type="text" name="turangshidu1" id="turangshidu1" value="${item.turangshidu1}" lay-verify="required" autocomplete="off" placeholder="请输入土壤湿度10cm"
				class="layui-input">
		</div>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label">土壤湿度20cmTURANGSHIDU2</label>
		<div class="layui-input-block">
			<input type="text" name="turangshidu2" id="turangshidu2" value="${item.turangshidu2}" lay-verify="required" autocomplete="off" placeholder="请输入土壤湿度20cm"
				class="layui-input">
		</div>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label">土壤湿度30cmTURANGSHIDU3</label>
		<div class="layui-input-block">
			<input type="text" name="turangshidu3" id="turangshidu3" value="${item.turangshidu3}" lay-verify="required" autocomplete="off" placeholder="请输入土壤湿度30cm"
				class="layui-input">
		</div>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label">土壤可溶浓度TURANG_EC</label>
		<div class="layui-input-block">
			<input type="text" name="turangEc" id="turangEc" value="${item.turangEc}" lay-verify="required" autocomplete="off" placeholder="请输入土壤可溶浓度"
				class="layui-input">
		</div>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label">土壤PH值TURANG_PH</label>
		<div class="layui-input-block">
			<input type="text" name="turangPh" id="turangPh" value="${item.turangPh}" lay-verify="required" autocomplete="off" placeholder="请输入土壤PH值"
				class="layui-input">
		</div>
	</div>
	<div class="layui-form-item">
		<div class="layui-input-block">
			<button class="layui-btn layui-btn-sm layui-btn-normal" lay-submit="" lay-filter="edit">立即提交</button>
			<button type="reset" class="layui-btn layui-btn-sm layui-btn-warm">重置</button>
		</div>
	</div>
</form>
</body>
</html>