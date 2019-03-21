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
	<form class="layui-form" action="" id="formId"  method="post">
				<div class="layui-form-item">
					<label class="layui-form-label">角色ID</label>
					<div class="layui-input-block">
						<input type="text" name="roleId" value="${item.roleId}" lay-verify="required" autocomplete="off" placeholder="请输入" class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">资源ID</label>
					<div class="layui-input-block">
						<input type="text" name="resourceId" value="${item.resourceId}" lay-verify="required" autocomplete="off" placeholder="请输入" class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">用户ID</label>
					<div class="layui-input-block">
						<input type="text" name="userId" value="${item.userId}" lay-verify="required" autocomplete="off" placeholder="请输入" class="layui-input">
					</div>
				</div>
			
		<div class="layui-form-item">
			<div class="layui-input-block">
				<button class="layui-btn" lay-submit="" lay-filter="demo1">立即提交</button>
				<button type="reset" class="layui-btn layui-btn-primary">重置</button>
			</div>
		</div>
	</form>
</body>
</html>