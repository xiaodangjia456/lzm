<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- include _comm.jsp -->
<%@ include file="/comm/_comm.jsp"%>
<!-- title -->
<title>林之牧物联网</title>
</head>
<!-- body -->
<body>
<form class="layui-form" data-type="ajax" action="min/siteuser/${item.id}" id="formId" method="post">
	<div class="layui-form-item">
		<label class="layui-form-label">用户IDUSER_ID</label>
		<div class="layui-input-block">
			<input type="text" name="userId" id="userId" value="${item.userId}" lay-verify="required" autocomplete="off" placeholder="请输入用户ID"
				class="layui-input">
		</div>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label">站点IDSITE_ID</label>
		<div class="layui-input-block">
			<input type="text" name="siteId" id="siteId" value="${item.siteId}" lay-verify="required" autocomplete="off" placeholder="请输入站点ID"
				class="layui-input">
		</div>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label">是否可预览SEE</label>
		<div class="layui-input-block">
			<input type="text" name="see" id="see" value="${item.see}" lay-verify="required" autocomplete="off" placeholder="请输入是否可预览"
				class="layui-input">
		</div>
	</div>
	<div class="layui-form-item">
		<label class="layui-form-label">是否可控制ACT</label>
		<div class="layui-input-block">
			<input type="text" name="act" id="act" value="${item.act}" lay-verify="required" autocomplete="off" placeholder="请输入是否可控制"
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