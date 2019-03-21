<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- include _comm.jsp -->
<%@ include file="/comm/_comm.jsp"%>
<!-- title -->
<title>林之牧物联网</title>
</head>
<!-- body -->
<body>
<form class="layui-form" data-type="ajax" action="min/siteuser" id="formId" method="post">
	<input type="hidden" id="userId" name="userId" value="${userId }">
	<h2 style="color: #ccc; font-weight: 900; margin-left: 12px;">账号：${user.name }</h2>
	<div class="layui-form-item border_shadow" style="margin: 10px;">
		<c:forEach items="${list }" var="site">
	   		<input type="checkbox" name="siteId" id="siteId" title="${site.siteName }" value="${site.id }" <c:if test="${site.check=='true' }">checked=""</c:if>>
		</c:forEach>
	</div>
	<div class="layui-form-item">
		<div class="layui-input-block">
			<button class="layui-btn layui-btn-sm layui-btn-normal" lay-submit="" lay-filter="add">立即提交</button>
			<button type="reset" class="layui-btn layui-btn-sm layui-btn-warm">重置</button>
		</div>
	</div>
</form>
</body>
</html>