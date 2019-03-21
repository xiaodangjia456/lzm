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
					<label class="layui-form-label">行政代码</label>
					<div class="layui-input-block">
						<input type="text" name="code" value="${item.code}" lay-verify="required" autocomplete="off" placeholder="请输入" class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">名称</label>
					<div class="layui-input-block">
						<input type="text" name="name" value="${item.name}" lay-verify="required" autocomplete="off" placeholder="请输入" class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">父id</label>
					<div class="layui-input-block">
						<input type="text" name="parentId" value="${item.parentId}" lay-verify="required" autocomplete="off" placeholder="请输入" class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">首字母</label>
					<div class="layui-input-block">
						<input type="text" name="firstLetter" value="${item.firstLetter}" lay-verify="required" autocomplete="off" placeholder="请输入" class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">城市等级</label>
					<div class="layui-input-block">
						<input type="text" name="level" value="${item.level}" lay-verify="required" autocomplete="off" placeholder="请输入" class="layui-input">
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