<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- include _comm.jsp -->
<%@ include file="/comm/_comm.jsp"%>
<!-- title -->
<title>林之牧物联网</title>
</head>
<!-- body -->
<body>
<br>
	<form class="layui-form" action="min/site/${item.id}"  data-type="ajax" id="formId" method="post">
		<div class="layui-form-item">
			<div class="layui-inline">
				<label class="layui-form-label">站点名称</label>
				<div class="layui-input-inline">
					<input type="text" name="siteName" value="${item.siteName}" lay-verify="required" autocomplete="off"
						placeholder="请输入站点名称" class="layui-input">
				</div>
			</div>
			<div class="layui-inline">
				<label class="layui-form-label">站点密码</label>
				<div class="layui-input-inline">
					<input type="text" name="sitePwd" value="${item.sitePwd}" lay-verify="required" autocomplete="off"
						placeholder="请输入站点密码" class="layui-input">
				</div>
			</div>
		</div>

		<div class="layui-form-item">
			<div class="layui-inline">
				<label class="layui-form-label">站点IP</label>
				<div class="layui-input-inline">
					<input type="tel" name=siteIp value="${item.siteIp}" lay-verify="" autocomplete="off" placeholder="请输入站点IP地址"
						class="layui-input">
				</div>
			</div>
			<div class="layui-inline">
				<label class="layui-form-label">站点端口</label>
				<div class="layui-input-inline">
					<input type="text" name="sitePort" value="${item.sitePort}" lay-verify="" autocomplete="off" placeholder="请输入站点端口号"
						class="layui-input">
				</div>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">行政区域</label>
			<div class="layui-input-inline">
				<select name="sheng" id="city_sheng" lay-filter="_sheng" lay-verify="required" autocomplete="off">
					<option value="">请选择省</option>
					<c:forEach items="${c_list }" var="city">
						<option value="${city.name }" <c:if test="${city.name==item.sheng }">selected</c:if>>${city.name }</option>
					</c:forEach>
				</select>
			</div>
			<div class="layui-input-inline">
				<select name="shi" id="city_shi" lay-filter="_shi" lay-verify="required" autocomplete="off">
					<option value="">请选择市</option>
					<option value="${item.shi}" selected>${item.shi}</option>
				</select>
			</div>
			<div class="layui-input-inline">
				<select name="xian" id="city_xian" lay-filter="_xian" lay-verify="required" autocomplete="off">
					<option value="">请选择县/区</option>
					<option value="${item.xian}" selected>${item.xian}</option>
				</select>
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