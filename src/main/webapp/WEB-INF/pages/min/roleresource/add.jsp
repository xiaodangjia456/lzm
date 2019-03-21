<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- include _comm.jsp -->
<%@ include file="/comm/_comm.jsp"%>
<!-- title -->
<title>林之牧物联网</title>
</head>
<!-- body -->
<body>
	<form class="layui-form layui-form-pane" action="min/roleresource" data-type="ajax" id="formId" method="post">
		<div class="layui-form-item border_shadow">
			<label class="layui-form-label">用户角色</label>
			<div class="layui-input-inline">
				<select name="roleId" id="r_roleId" lay-filter="_roleId" lay-verify="required">
					<c:forEach items="${r_list }" var="role">
						<option value="${role.id }" <c:if test="${role.id==roleId }">selected</c:if>>${role.roleName }</option>
					</c:forEach>
				</select>
			</div>
		</div>
		<div class="layui-form-item border_shadow" style="margin: 10px;">
			<c:forEach items="${list_l0 }" var="l0">
				<fieldset class="layui-elem-field layui-field-title border_shadow">
					<legend>
						<input type="checkbox" name="resourceId" value="${l0.level0.id }" title="${l0.level0.resourceName }"
							<c:if test="${l0.check=='true' }">checked=""</c:if>>
					</legend>

					<c:forEach items="${l0.level1 }" var="l1">
						<fieldset class="layui-elem-field layui-field-title" style="margin-left: 50px;">
							<legend>
								<input type="checkbox" name="resourceId" value="${l1.level1.id }" title="${l1.level1.resourceName }"
									<c:if test="${l1.check=='true' }">checked=""</c:if>>
							</legend>
							<div class="layui-form-item" style="margin-left: 100px;">
								<c:forEach items="${l1.level2 }" var="l2">
									<input type="checkbox" name="resourceId" value="${l2.level2.id }" title="${l2.level2.resourceName }"
										<c:if test="${l2.check=='true' }">checked=""</c:if>>
								</c:forEach>
							</div>

						</fieldset>
					</c:forEach>
				</fieldset>
			</c:forEach>
		</div>

		<div class="layui-form-item">
			<div class="layui-input-block">
				<button class="layui-btn layui-btn-sm layui-btn-normal" lay-submit="" lay-filter="add">立即提交</button>
				<button type="reset" class="layui-btn layui-btn-primary layui-btn-sm">重置</button>
			</div>
		</div>
	</form>

	<script type="text/javascript">
		layui.use([ 'form', 'element', 'layer' ], function() {
			var form = layui.form, layer = layui.layer, $ = layui.jquery;
			form.on('checkbox', function(data){
				if(data.elem.checked){
					$(data.elem).attr('checked',true);
				}else{
					$(data.elem).attr('checked',false);
				}
				form.render('checkbox');  
			}); 
			form.on('select(_roleId)', function(data) {
				var url = contextPath + 'min/resource/get/resource/fenpei/page?roleId='+ data.value;
				window.location.href = url;
				form.render();
			});
		});
	</script>
</body>
</html>