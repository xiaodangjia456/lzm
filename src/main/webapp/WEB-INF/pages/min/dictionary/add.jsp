<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- include _comm.jsp -->
<%@ include file="/comm/_comm.jsp"%>
<!-- title -->
<title>林之牧物联网</title>
</head>
<!-- body -->
<body>
<br>
	<form class="layui-form" action="<%=contextPath%>/min/dictionary/add" id="formId" method="post">
		<input type="hidden" id="contextPath" name="contextPath" value="<%=contextPath%>">
		<div class="layui-form-item">
			<label class="layui-form-label">数据类型</label>
			<div class="layui-input-block">
				<select name="type" lay-filter="type" lay-verify="required">
					<option value="">请选择</option>
					<c:forEach items="${d_map }" var="map">
						<c:choose>
							<c:when test="${fn:contains(map.key,'SQ_')}">
							</c:when>
							<c:otherwise>
								<option value="${map.key }" <c:if test="${map.key==item.type }">selected</c:if>>${map.value }</option>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</select>
			</div>
		</div>

		<div class="layui-form-item">
			<label class="layui-form-label">类型描述</label>
			<div class="layui-input-block">
				<input type="text" name="content" value="${item.content}" lay-verify="required" autocomplete="off"
					placeholder="请输入类型描述" class="layui-input">
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