<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- include _comm.jsp -->
<%@ include file="/comm/_comm.jsp"%>
<!-- title -->
<title>林之牧物联网</title>
<script type="text/javascript" src="js/comm/area.js"></script>
</head>
<!-- body -->
<body>
	<form class="layui-form layui-form-pane" action="min/site/get/pre" method="get" id="searchForm" name="searchForm">
		<input type="hidden" id="totalResult" name="totalResult" value="${page.totalResult }"> 
		<input type="hidden" id="currentPage" name="currentPage" value="${page.currentPage }"> 
		<input type="hidden" id="showCount" name="showCount" value="${page.showCount }"> 
		<input id="handle_status" value="" type="hidden">
		<div class="layui-form-item border_shadow">
			<label class="layui-form-label">站点名称</label>
			<div class="layui-input-inline">
				<input type="text" name="_siteName" value="${_siteName }" lay-verify="required" placeholder="请输入站点名称"
					autocomplete="off" class="layui-input">
			</div>
			<label class="layui-form-label">行政区域</label>
			<div class="layui-input-inline">
				<select name="sheng" id="city_sheng" lay-filter="_sheng" lay-verify="required" autocomplete="off">
					<option value="">请选择省</option>
					<c:forEach items="${c_list }" var="city">
						<option value="${city.name }" <c:if test="${city.name==sheng }">selected</c:if>>${city.name }</option>
					</c:forEach>
				</select>
			</div>
			<div class="layui-input-inline">
				<select name="shi" id="city_shi" lay-filter="_shi" lay-verify="required" autocomplete="off">
					<option value="">请选择市</option>
					<option value="${shi }" selected>${shi }</option>
				</select>
			</div>
			<div class="layui-input-inline">
				<select name="xian" id="city_xian" lay-filter="_xian" lay-verify="required" autocomplete="off">
					<option value="">请选择县/区</option>
					<option value="${xian }" selected>${xian }</option>
				</select>
			</div>
		</div>
		
		<div class="layui-btn-group">
			<button type="submit" class="layui-btn layui-btn-sm layui-btn-normal">
				<i class="layui-icon">&#xe615;</i>搜索
			</button>
			<button class="layui-btn layui-btn-sm layui-btn-normal" onclick="toUrlPage('添加站点', 'min/site/post/pre', '80%', '80%', true);">
				<i class="layui-icon">&#xe654;</i>添加
			</button>
		</div>
	</form>


	<div class="layui-form">
		<table class="layui-table no_border_shadow">
			<colgroup>
				<col width="60">
				<col width="200">
				<col width="150">
				<col width="80">
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
					<th>站点名称</th>
					<th>站点IP</th>
					<th>端口号</th>
					<th>站点密码</th>
					<th>省</th>
					<th>市</th>
					<th>县</th>
					<th>操作人</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach items="${list}" var="item" varStatus="status">

					<tr>
						<td nowrap="nowrap">${status.index+1}</td>
						<td nowrap="nowrap"><c:out value='${item.siteName}' />&nbsp;</td>
						<td nowrap="nowrap"><c:out value='${item.siteIp}' />&nbsp;</td>
						<td nowrap="nowrap"><c:out value='${item.sitePort}' />&nbsp;</td>
						<td nowrap="nowrap"><c:out value='${item.sitePwd}' />&nbsp;</td>
						<td nowrap="nowrap"><c:out value='${item.sheng}' />&nbsp;</td>
						<td nowrap="nowrap"><c:out value='${item.shi}' />&nbsp;</td>
						<td nowrap="nowrap"><c:out value='${item.xian}' />&nbsp;</td>
						<td nowrap="nowrap"><c:out value='${item.user.name}' />&nbsp;</td>
						<td nowrap="nowrap">
							<div class="layui-btn-group">
								<button class="layui-btn layui-btn-xs layui-btn-normal" onclick="toUrlPage('站点信息详情', 'min/site/showDetail/${item.id}', '80%', '80%', true)">查看</button>
								<button class="layui-btn layui-btn-xs layui-btn-warm" onclick="toUrlPage('修改站点信息', 'min/site/${item.id}/put/pre', '80%', '80%', true)">编辑</button>
								<button class="layui-btn layui-btn-xs layui-btn-danger" onclick="del_Url('min/site/${item.id}','');">删除</button>
								<button class="layui-btn layui-btn-xs layui-btn-normal" onclick="toUrlPage('设备管理', 'min/device/get/pre?siteId=${item.id}', '80%', '80%', false)">设备管理</button>
								
							</div> 
						</td>
					</tr>

				</c:forEach>
			</tbody>
		</table>
		<div id="laypage"  class="border_shadow"></div>
	</div>

</body>
</html>
