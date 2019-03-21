<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- include _comm.jsp -->
<%@ include file="/comm/_comm.jsp"%>
<!-- title -->
<title>林之牧物联网</title>
</head>
<!-- body -->
<body>
	<form class="layui-form layui-form-pane" action="min/user/get/pre" method="get" id="searchForm" name="searchForm">
		<input type="hidden" id="totalResult" name="totalResult" value="${page.totalResult }"> 
		<input type="hidden" id="currentPage" name="currentPage" value="${page.currentPage }"> 
		<input type="hidden" id="showCount" name="showCount" value="${page.showCount }"> 
		<input id="handle_status" value="" type="hidden">
		<div class="layui-form-item border_shadow">
			<label class="layui-form-label">账号/用户名</label>
			<div class="layui-input-inline">
				<input type="text" name="_userName" value="${_userName }" lay-verify="required" placeholder="请输入账号" autocomplete="off" class="layui-input">
			</div>
			<label class="layui-form-label">用户角色</label>
			<div class="layui-input-inline">
				<select name="roleId" lay-verify="required">
					<option value="">请选择[用户角色]</option>
					<option value="">显示全部</option>
					<c:forEach items="${r_list }" var="role">
						<option value="${role.id }" <c:if test="${role.id==roleId }">selected</c:if>>${role.roleName }</option>
					</c:forEach>
				</select>
			</div>
			<label class="layui-form-label">是否可用</label>
			<div class="layui-input-inline">
				<select name="enabled" lay-verify="required">
					<option value="">请选择</option>
					<option value="">显示全部</option>
					<option value="true">可用</option>
					<option value="false">不可用</option>
				</select>
			</div>
		</div>
		<div class="layui-btn-group">
			<button type="submit" class="layui-btn layui-btn-sm layui-btn-normal">
				<i class="layui-icon">&#xe615;</i>搜索
			</button>
			<button class="layui-btn layui-btn-sm layui-btn-normal" onclick="toUrlPage('添加用户', 'min/user/post/pre', '80%', '80%', true);">
				<i class="layui-icon">&#xe654;</i>添加
			</button>
			<button class="layui-btn layui-btn-sm layui-btn-warm" onclick="toUrlPage('资源分配', 'min/resource/get/resource/fenpei/page', '80%', '80%', false)">
				<i class="layui-icon">&#xe656;</i>资源分配
			</button>
		</div>
	</form>


	<div class="layui-form">
		<table class="layui-table no_border_shadow">
			<colgroup>
				<col width="60">
				<col width="100">
				<col width="120">
				<col width="100">
				<col width="320">
				<col width="100">
				<col width="80">
				<col>
			</colgroup>
			<thead>
				<tr>
					<th>编号</th>
					<th>登录账号</th>
					<th>联系电话</th>
					<th>真实姓名</th>
					<th>详细地址</th>
					<th>角色</th>
					<th>启用</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach items="${list}" var="item" varStatus="status">

					<tr>
						<td nowrap="nowrap">${status.index+1}</td>
						<td nowrap="nowrap"><c:out value='${item.name}' />&nbsp;</td>
						<td nowrap="nowrap"><c:out value='${item.phone}' />&nbsp;</td>
						<td nowrap="nowrap"><c:out value='${item.realName}' />&nbsp;</td>
						<td nowrap="nowrap"><c:out value='${item.address}' />&nbsp;</td>
						<td nowrap="nowrap"><c:out value='${item.role.roleName}' />&nbsp;</td>
						<td nowrap="nowrap">
							<c:if test="${item.enabled=='true'}">已开启</c:if> 
							<c:if test="${item.enabled=='false'}">
								<font color="red">未开启</font>
							</c:if> &nbsp;</td>
						<td nowrap="nowrap">
							<div class="layui-btn-group">
								<button class="layui-btn layui-btn-xs layui-btn-normal" onclick="toUrlPage('用户信息详情', 'min/user/showDetail/${item.id}', '80%', '80%', true)">查看</button>
								<button class="layui-btn layui-btn-xs layui-btn-warm" onclick="toUrlPage('修改用户信息', 'min/user/${item.id}/put/pre', '80%', '80%', true)">编辑</button>
								<button class="layui-btn layui-btn-xs layui-btn-danger" onclick="del_Url('min/user/${item.id}','');">删除</button>
								<c:if test="${item.enabled=='true'}">
									<button class="layui-btn layui-btn-xs layui-btn-warm" onclick="edit_Url('min/user/${item.id}/enabled/no', '', 'POST')">废弃</button>
								</c:if>
								<c:if test="${item.enabled=='false'}">
									<button class="layui-btn layui-btn-xs layui-btn-warm" onclick="edit_Url('min/user/${item.id}/enabled/ok', '', 'POST')">启用</button>
								</c:if>
								<button class="layui-btn layui-btn-xs layui-btn-warm" onclick="toUrlPage('分配站点', 'min/user/${item.id}/init/site/fenpei/page', '80%', '80%', false)">分配站点</button>
							</div> 
						</td>
					</tr>

				</c:forEach>
			</tbody>
		</table>
		<div id="laypage" class="border_shadow"></div>
	</div>

</body>
</html>
