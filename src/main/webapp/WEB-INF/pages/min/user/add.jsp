<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- include _comm.jsp -->
<%@ include file="/comm/_comm.jsp"%>
<!-- title -->
<title>林之牧物联网</title>
</head>
<!-- body -->
<body>
<br>
	<form class="layui-form" action="min/user" data-type="ajax" id="formId" method="post">
		<div class="layui-form-item">
			<label class="layui-form-label">登录账号</label>
			<div class="layui-input-block">
				<input type="text" name="name" value="${item.name}" lay-verify="required" autocomplete="off" placeholder="请输入账号"
					class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">登录密码</label>
			<div class="layui-input-block">
				<input type="text" name="realPassword" value="${item.realPassword}" lay-verify="required" autocomplete="off"
					placeholder="请输入密码" class="layui-input">
			</div>
		</div>

		<div class="layui-form-item">
			<div class="layui-inline">
				<label class="layui-form-label">联系电话</label>
				<div class="layui-input-inline">
					<input type="tel" name="phone" value="${item.phone}" lay-verify="" autocomplete="off"
						placeholder="请输入手机号码" class="layui-input">
				</div>
			</div>
			<div class="layui-inline">
				<label class="layui-form-label">邮箱地址</label>
				<div class="layui-input-inline">
					<input type="text" name="email" value="${item.email}" lay-verify="" autocomplete="off" placeholder="请输入邮箱地址"
						class="layui-input">
				</div>
			</div>
		</div>

		<div class="layui-form-item">
			<label class="layui-form-label">真实姓名</label>
			<div class="layui-input-block">
				<input type="text" name="realName" value="${item.realName}" lay-verify="" autocomplete="off"
					placeholder="请输入真实姓名" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">详细地址</label>
			<div class="layui-input-block">
				<input type="text" name="address" value="${item.address}" lay-verify="" autocomplete="off"
					placeholder="请输入详细地址" class="layui-input">
					
			</div>
		</div>

		<div class="layui-form-item">
			<label class="layui-form-label">角色</label>
			<div class="layui-input-block">
				<select name="roleId" lay-filter="roleId" lay-verify="required">
					<option value="">[请选择]</option>
					<c:forEach items="${r_list }" var="role">
						<option value="${role.id }" <c:if test="${role.id==item.roleId }">selected</c:if>>${role.roleName }</option>
					</c:forEach>
				</select>
			</div>
		</div>

		<div class="layui-form-item">
			<div class="layui-input-block">
				<button class="layui-btn layui-btn-sm layui-btn-normal" lay-submit="" lay-filter="add">立即提交</button>
				<button type="reset" class="layui-btn layui-btn-primary layui-btn-sm">重置</button>
			</div>
		</div>
	</form>
</body>
</html>