<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- include _comm.jsp -->
<%@ include file="/comm/_comm.jsp"%>
<!-- title -->
<title>林之牧物联网</title>
</head>
<!-- body -->
<body>
<br>
	<form class="layui-form" action="min/device/${item.id}" data-type="ajax" id="formId" method="post">
		<input type="hidden" id="siteId" name="siteId" value="${siteId }"> 
		<div class="layui-form-item">
			<label class="layui-form-label">设备类型</label>
			<div class="layui-input-inline">
				<select name="deviceType" lay-verify="required">
					<option value="">[请选择]</option>
					<c:forEach items="${d_list }" var="d_d">
						<option value="${d_d.id }" <c:if test="${d_d.id==item.deviceType }">selected</c:if>>${d_d.content }</option>
					</c:forEach>
				</select>
			</div>
		</div>
		<div class="layui-form-item">
			<div class="layui-inline">
				<label class="layui-form-label">设备名称</label>
				<div class="layui-input-inline">
					<input type="text" name="deviceName" value="${item.deviceName}" lay-verify="required" autocomplete="off"
						placeholder="请输入设备名称" class="layui-input">
				</div>
			</div>
			<div class="layui-inline">
				<label class="layui-form-label">设备编号</label>
				<div class="layui-input-inline">
					<input type="text" name="deviceCode" value="${item.deviceCode}" lay-verify="required" autocomplete="off"
						placeholder="请输入设备编号" class="layui-input">
				</div>
			</div>
		</div>

		<div class="layui-form-item">
			<div class="layui-inline">
				<label class="layui-form-label">设备IP</label>
				<div class="layui-input-inline">
					<input type="tel" name="deviceIp" value="${item.deviceIp}" lay-verify="" autocomplete="off" placeholder="请输入设备IP"
						class="layui-input">
				</div>
			</div>
			<div class="layui-inline">
				<label class="layui-form-label">设备端口</label>
				<div class="layui-input-inline">
					<input type="text" name="devicePort" value="${item.devicePort}" lay-verify="" autocomplete="off"
						placeholder="请输入设备端口" class="layui-input">
				</div>
			</div>
		</div>
		<div class="layui-form-item">
			<div class="layui-inline">
				<label class="layui-form-label">采集端口</label>
				<div class="layui-input-inline">
					<input type="text" name="deviceSport" value="${item.deviceSport}" lay-verify="" autocomplete="off"
						placeholder="请输入套接字采集端口号" class="layui-input">
				</div>
			</div>
			<div class="layui-inline">
				<label class="layui-form-label">注册字</label>
				<div class="layui-input-inline">
					<input type="text" name="deviceReg" value="${item.deviceReg}" lay-verify="" autocomplete="off" placeholder="请输入注册字"
						class="layui-input">

				</div>
			</div>
		</div>

		<div class="layui-form-item">
			<div class="layui-input-block">
				<button class="layui-btn layui-btn-sm layui-btn-normal" lay-submit="" lay-filter="edit">立即提交</button>
				<button type="reset" class="layui-btn layui-btn-primary layui-btn-sm">重置</button>
			</div>
		</div>
	</form>
</body>
</html>