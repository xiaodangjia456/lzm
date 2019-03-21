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
					<label class="layui-form-label">user</label>
					<div class="layui-input-block">
						<input type="text" name="user" value="${item.user}" lay-verify="required" autocomplete="off" placeholder="请输入" class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">record</label>
					<div class="layui-input-block">
						<input type="text" name="record" value="${item.record}" lay-verify="required" autocomplete="off" placeholder="请输入" class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">creatTime</label>
					<div class="layui-input-block">
						<input type="text" name="creatTime" value="${item.creatTime}" lay-verify="required" autocomplete="off" placeholder="请输入" class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">method</label>
					<div class="layui-input-block">
						<input type="text" name="method" value="${item.method}" lay-verify="required" autocomplete="off" placeholder="请输入" class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">tableName</label>
					<div class="layui-input-block">
						<input type="text" name="tableName" value="${item.tableName}" lay-verify="required" autocomplete="off" placeholder="请输入" class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">ipAddr</label>
					<div class="layui-input-block">
						<input type="text" name="ipAddr" value="${item.ipAddr}" lay-verify="required" autocomplete="off" placeholder="请输入" class="layui-input">
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