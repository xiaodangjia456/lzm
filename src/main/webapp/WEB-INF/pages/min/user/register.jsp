<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- include _comm.jsp -->
<%@ include file="/comm/_comm.jsp"%>
<!-- title -->
<title>林之牧物联网</title>
</head>
<!-- body -->
<body>
<br>
	<form class="layui-form" action="<%=contextPath%>/min/default/register" id="formId" method="post">
		<input type="hidden" id="contextPath" name="contextPath" value="<%=contextPath%>">
		<div class="layui-form-item">
			<div class="layui-inline">
				<label class="layui-form-label">登录账号</label>
				<div class="layui-input-inline">
					<input type="text" name="name" value="${item.name}" lay-verify="required" autocomplete="off" placeholder="请输入账号"
						class="layui-input">
				</div>
			</div>
			<div class="layui-inline">
				<label class="layui-form-label">登录密码</label>
				<div class="layui-input-inline">
					<input type="text" name="realPassword" value="${item.realPassword}" lay-verify="required" autocomplete="off"
						placeholder="请输入密码" class="layui-input">
				</div>
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
		<hr color="#ccc" width="100%" style="height: 3px;">
		<div class="layui-form-item">
			<div class="layui-inline">
				<label class="layui-form-label">公司名称</label>
				<div class="layui-input-inline">
					<input type="text" name="companyName" value="${item.companyName}" lay-verify="required" autocomplete="off" placeholder="请输入企业名称"
						class="layui-input" style="width: 240px;">
				</div>
			</div>
			<div class="layui-inline">
				<label class="layui-form-label">英文名称</label>
				<div class="layui-input-inline">
					<input type="text" name="companyNameEn" value="${item.companyNameEn}" lay-verify="" autocomplete="off"
						placeholder="请输入英文企业名称" class="layui-input" style="width: 240px;">
				</div>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">信用代码</label>
			<div class="layui-input-block">
				<input type="text" name="creditCode" value="${item.creditCode}" lay-verify="" autocomplete="off"
					placeholder="请输入企业信用代码" class="layui-input">
			</div>
		</div>
		<div class="layui-form-item">
			<div class="layui-inline">
				<label class="layui-form-label">公司法人</label>
				<div class="layui-input-inline">
					<input type="text" name="juridicalPerson" value="${item.juridicalPerson}" lay-verify="" autocomplete="off"
						placeholder="请输入公司法人名称" class="layui-input" style="width: 240px;">
				</div>
			</div>
			<div class="layui-inline">
				<label class="layui-form-label">联系人</label>
				<div class="layui-input-inline">
					<input type="tel" name="connectUserName" value="${item.connectUserName}" lay-verify="" autocomplete="off"
						placeholder="请输入联系人姓名" class="layui-input" style="width: 240px;">
				</div>
			</div>
		</div>

		<div class="layui-form-item">
			<div class="layui-inline">
				<label class="layui-form-label">联系电话</label>
				<div class="layui-input-inline">
					<input type="tel" name="companyPhone" value="${item.companyPhone}" lay-verify="" autocomplete="off"
						placeholder="请输入手机号码" class="layui-input" style="width: 240px;">
				</div>
			</div>
			<div class="layui-inline">
				<label class="layui-form-label">邮箱地址</label>
				<div class="layui-input-inline">
					<input type="text" name="companyEmail" value="${item.companyEmail}" lay-verify="" autocomplete="off" placeholder="请输入邮箱地址"
						class="layui-input" style="width: 240px;">
				</div>
			</div>
			<div class="layui-inline">
				<label class="layui-form-label">网站地址</label>
				<div class="layui-input-inline">
					<input type="text" name="companyUrl" value="${item.companyUrl}" lay-verify="" autocomplete="off" placeholder="请输入企业官网网址"
						class="layui-input" style="width: 240px;">
				</div>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">详细地址</label>
			<div class="layui-input-block">
				<input type="text" name="companyAddress" value="${item.companyAddress}" lay-verify="" autocomplete="off"
					placeholder="请输入企业联系地址" class="layui-input">
					
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