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
					<label class="layui-form-label">资源编号</label>
					<div class="layui-input-block">
						<input type="text" name="resourceCode" value="${item.resourceCode}" lay-verify="required" autocomplete="off" placeholder="请输入" class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">资源名称</label>
					<div class="layui-input-block">
						<input type="text" name="resourceName" value="${item.resourceName}" lay-verify="required" autocomplete="off" placeholder="请输入" class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">父  id</label>
					<div class="layui-input-block">
						<input type="text" name="inheritCode" value="${item.inheritCode}" lay-verify="required" autocomplete="off" placeholder="请输入" class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">资源等级</label>
					<div class="layui-input-block">
						<input type="text" name="levels" value="${item.levels}" lay-verify="required" autocomplete="off" placeholder="请输入" class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">资源图片</label>
					<div class="layui-input-block">
						<input type="text" name="imagePath" value="${item.imagePath}" lay-verify="required" autocomplete="off" placeholder="请输入" class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">资源访问路径</label>
					<div class="layui-input-block">
						<input type="text" name="resourceUrl" value="${item.resourceUrl}" lay-verify="required" autocomplete="off" placeholder="请输入" class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">是否可用</label>
					<div class="layui-input-block">
						<input type="text" name="isAbleTable" value="${item.isAbleTable}" lay-verify="required" autocomplete="off" placeholder="请输入" class="layui-input">
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