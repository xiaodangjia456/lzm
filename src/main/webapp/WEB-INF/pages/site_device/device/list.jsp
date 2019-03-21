<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- include _comm.jsp -->
<%@ include file="/comm/_comm.jsp"%>
<!-- title -->
<title>林之牧物联网</title>
</head>
<!-- body -->
<body>
	<form class="layui-form layui-form-pane" action="min/device/get/pre?siteId=${siteId}" method="get" id="searchForm" name="searchForm">
		<input type="hidden" id="siteId" name="siteId" value="${siteId }"> 
		<input type="hidden" id="totalResult" name="totalResult" value="${page.totalResult }"> 
		<input type="hidden" id="currentPage" name="currentPage" value="${page.currentPage }"> 
		<input type="hidden" id="showCount" name="showCount" value="${page.showCount }"> 
		<input id="handle_status" value="" type="hidden">
		<div class="layui-form-item border_shadow">
			<label class="layui-form-label">设备名称</label>
			<div class="layui-input-inline">
				<input type="text" name="deviceName" value="${deviceName }" lay-verify="required" placeholder="请输入设备名称"
					autocomplete="off" class="layui-input">
			</div>
			<label class="layui-form-label">设备编号</label>
			<div class="layui-input-inline">
				<input type="text" name="deviceCode" value="${deviceCode }" lay-verify="required" placeholder="请输入设备编号"
					autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-btn-group">
			<button type="submit" class="layui-btn layui-btn-sm layui-btn-normal">
				<i class="layui-icon">&#xe615;</i>搜索
			</button>
			<button type="button" class="layui-btn layui-btn-sm layui-btn-normal" onclick="_toUrlPage('添加设备', 'min/device/post/pre?siteId=${siteId}', '80%', '80%', true);">
				<i class="layui-icon">&#xe654;</i>添加
			</button>
		</div>
	</form>


	<div class="layui-form">
		<table class="layui-table no_border_shadow">
			<colgroup>
				<col width="60">
				<col width="120">
				<col width="120">
				<col width="120">
				<col width="120">
				<col width="120">
				<col>
			</colgroup>
			<thead>
				<tr>
					<th>编号</th>
					<th>设备名称</th>
					<th>设备编号</th>
					<th>设备类型</th>
					<th>设备IP</th>
					<th>操作人</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach items="${list}" var="item" varStatus="status">
					<tr>
						<td nowrap="nowrap">${status.index+1}</td>
						<td nowrap="nowrap"><c:out value='${item.deviceName}' />&nbsp;</td>
						<td nowrap="nowrap"><c:out value='${item.deviceCode}' />&nbsp;</td>
						<td nowrap="nowrap"><c:out value='${item.deviceType}' />&nbsp;</td>
						<td nowrap="nowrap"><c:out value='${item.deviceIp}' />&nbsp;</td>
						<td nowrap="nowrap"><c:out value='${item.user.name}' />&nbsp;</td>
						<td nowrap="nowrap">
							<div class="layui-btn-group">
								<button class="layui-btn layui-btn-xs layui-btn-normal" onclick="_toUrlPage('设备信息详情', 'min/device/showDetail/${item.id}', '80%', '80%', true)">查看</button>
								<button class="layui-btn layui-btn-xs layui-btn-warm" onclick="_toUrlPage('修改设备信息', 'min/device/${item.id}/put/pre?siteId=${siteId }', '80%', '80%', true)">编辑</button>
								<button class="layui-btn layui-btn-xs layui-btn-danger" onclick="del_Url('min/device/${item.id}','');">删除</button>
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
