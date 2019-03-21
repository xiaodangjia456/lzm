<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- include _comm.jsp -->
<%@ include file="/comm/_comm.jsp"%>
<!-- title -->
<title>林之牧物联网</title>
</head>
<!-- body -->
<body>

<!-- search Start -->
<form class="layui-form  layui-form-pane" action="min/imgpicture/get/pre" method="get" id="searchForm" name="searchForm">
	<input type="hidden" id="totalResult" name="totalResult" value="${page.totalResult}"> 
	<input type="hidden" id="currentPage" name="currentPage" value="${page.currentPage}"> 
	<input type="hidden" id="showCount" name="showCount" value="${page.showCount}">
	<input type="hidden" id="_status" value="">
	<div class="layui-form-item border_shadow">
		<label class="layui-form-label">账号</label>
		<div class="layui-input-inline">
			<input type="text" name="_userName" value="" lay-verify="required" placeholder="请输入账号" autocomplete="off"
				class="layui-input">
		</div>
	</div>

	<div class="layui-btn-group">
		<button type="submit" class="layui-btn layui-btn-sm layui-btn-normal">
			<i class="layui-icon  layui-anim layui-anim-scaleSpring">&#xe615;</i>搜索</button>
		<button type="button" class="layui-btn layui-btn-sm layui-btn-normal" onclick="JavaScript:MinFormUtil.toAddPage('imgpicture','');">
			<i class="layui-icon layui-anim layui-anim-rotate">&#xe654;</i>添加</button>
	</div>
</form>
<!-- search End -->

<!-- Table Start -->
<div class="layui-form">
	<table class="layui-table no_border_shadow">
		<colgroup>
			<col width="60">
					<col width="100">
					<col width="100">
					<col width="100">
					<col width="100">
					<col width="100">
					<col width="100">
					<col width="100">
					<col width="100">
					<col width="100">
			<col>
		</colgroup>
		<thead>
			<tr>
				<th>编号</th>
						<th>站点IdSITE_ID </th>
						<th>站点别名SITE_ALIAS </th>
						<th>设备IdDEVICE_ID </th>
						<th>图片日期（年-月-日）IMG_DATE </th>
						<th>图片名称IMG_NAME </th>
						<th>图片全路径IMG_PATH </th>
						<th>数据创建时间CREATE_TIME </th>
						<th>图片类型IMG_TYPE </th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="item" varStatus="status">
				<tr>
					<td nowrap="nowrap">${status.index+1}</td>
							<td nowrap="nowrap"><c:out value='${item.siteId}' />&nbsp;</td>
							<td nowrap="nowrap"><c:out value='${item.siteAlias}' />&nbsp;</td>
							<td nowrap="nowrap"><c:out value='${item.deviceId}' />&nbsp;</td>
							<td nowrap="nowrap"><c:out value='${item.imgDate}' />&nbsp;</td>
							<td nowrap="nowrap"><c:out value='${item.imgName}' />&nbsp;</td>
							<td nowrap="nowrap"><c:out value='${item.imgPath}' />&nbsp;</td>
							<td nowrap="nowrap"><c:out value='${item.createTime}' />&nbsp;</td>
							<td nowrap="nowrap"><c:out value='${item.imgType}' />&nbsp;</td>
					<td nowrap="nowrap">
						<div class="layui-btn-group">
							<button type="button" class="layui-btn layui-btn-primary layui-btn-xs" onclick="MinFormUtil.showDetail('imgpicture', ${item.id}, '');">查看</button>
							<button type="button" class="layui-btn layui-btn-normal layui-btn-xs" onclick="MinFormUtil.toUpdatePage('imgpicture', ${item.id}, '');">修改</button>
							<button type="button" class="layui-btn layui-btn-danger layui-btn-xs" onclick="MinFormUtil.delForm('imgpicture',${item.id};">删除</button>
						</div>
					</td>
				</tr>

			</c:forEach>
		</tbody>
	</table>
	<div id="laypage"  class="border_shadow"></div>
</div>
<!-- Table End -->
</body>
</html>
