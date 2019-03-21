<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- include _comm.jsp -->
<%@ include file="/comm/_comm.jsp"%>
<!-- title -->
<title>林之牧物联网</title>
</head>
<!-- body -->
<body>
	<form class="layui-form" data-type="ajax" action="min/imginsect" id="formId" method="post">
		<div class="layui-form-item">
			<label class="layui-form-label">站点IdSITE_ID</label>
			<div class="layui-input-block">
				<input type="text" name="siteId" id="siteId" value="${item.siteId}" lay-verify="required" autocomplete="off" placeholder="请输入站点Id" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">站点别名SITE_ALIAS</label>
			<div class="layui-input-block">
				<input type="text" name="siteAlias" id="siteAlias" value="${item.siteAlias}" lay-verify="required" autocomplete="off" placeholder="请输入站点别名" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">设备IdDEVICE_ID</label>
			<div class="layui-input-block">
				<input type="text" name="deviceId" id="deviceId" value="${item.deviceId}" lay-verify="required" autocomplete="off" placeholder="请输入设备Id" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">图片日期（年-月-日）IMG_DATE</label>
			<div class="layui-input-block">
				<input type="text" name="imgDate" id="imgDate" value="${item.imgDate}" lay-verify="required" autocomplete="off" placeholder="请输入图片日期（年-月-日）" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">图片名称IMG_NAME</label>
			<div class="layui-input-block">
				<input type="text" name="imgName" id="imgName" value="${item.imgName}" lay-verify="required" autocomplete="off" placeholder="请输入图片名称" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">图片全路径IMG_PATH</label>
			<div class="layui-input-block">
				<input type="text" name="imgPath" id="imgPath" value="${item.imgPath}" lay-verify="required" autocomplete="off" placeholder="请输入图片全路径" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">数据创建时间CREATE_TIME</label>
			<div class="layui-input-block">
				<input type="text" name="createTime" id="createTime" value="${item.createTime}" lay-verify="required" autocomplete="off" placeholder="请输入数据创建时间" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">图片类型IMG_TYPE</label>
			<div class="layui-input-block">
				<input type="text" name="imgType" id="imgType" value="${item.imgType}" lay-verify="required" autocomplete="off" placeholder="请输入图片类型" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<div class="layui-input-block">
				<button class="layui-btn layui-btn-sm layui-btn-normal" lay-submit="" lay-filter="add">立即提交</button>
				<button type="reset" class="layui-btn layui-btn-sm layui-btn-warm">重置</button>
			</div>
		</div>
	</form>
	<jsp:include page="main/webapp/comm/_comm.jsp"></jsp:include>
</body>
</html>