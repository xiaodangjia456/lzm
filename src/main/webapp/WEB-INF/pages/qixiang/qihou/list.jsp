<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- include _comm.jsp -->
<%@ include file="/comm/_comm.jsp"%>
<!-- title -->
<title>林之牧物联网</title>
</head>
<!-- body -->
<body>

<!-- search Start -->
<form class="layui-form layui-form-pane" action="min/qihou/get/pre" method="get" id="searchForm" name="searchForm">
	<input type="hidden" id="totalResult" name="totalResult" value="${page.totalResult}"> 
	<input type="hidden" id="currentPage" name="currentPage" value="${page.currentPage}"> 
	<input type="hidden" id="showCount" name="showCount" value="${page.showCount}">
	<input type="hidden" id="_status" value="">
	<div class="layui-form-item border_shadow">
		<label class="layui-form-label">站点</label>
		<div class="layui-input-inline">
			<select name="siteId" id="siteId" lay-filter="_siteId" lay-verify="required" autocomplete="off">
					<option value="">请选择站点信息</option>
					<c:forEach items="${s_List }" var="site">
						<option value="${site.id }" <c:if test="${site.id==siteId }">selected</c:if>>${site.siteName }</option>
					</c:forEach>
				</select>
		</div>
	</div>

	<div class="layui-btn-group">
		<button type="submit" class="layui-btn layui-btn-sm layui-btn-normal">
			<i class="layui-icon  layui-anim layui-anim-scaleSpring">&#xe615;</i>搜索
		</button>
	</div>
</form>
<!-- search End -->

<!-- Table Start -->
<div class="layui-form">
	<table class="layui-table no_border_shadow">
		<colgroup>
			<col width="60">
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
			<col width="100">
			<col width="100">
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
						<th>日期 </th>
						<th>时间 </th>
						<th>空温 </th>
						<th>空湿 </th>
						<th>压强</th>
						<th>风向</th>
						<th>风速</th>
						<th>降雨量</th>
						<th>蒸发量</th>
						<th>光照度</th>
						<th>光合辐射</th>
						<th>总辐射</th>
						<th>地温1</th>
						<th>地温2 </th>
						<th>地温3 </th>
						<th>地湿1 </th>
						<th>地湿2 </th>
						<th>地湿3 </th>
						<th>浓解度</th>
						<th>PH值</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="item" varStatus="status">
				<tr>
					<td nowrap="nowrap">${status.index+1}</td>
					<td nowrap="nowrap"><fmt:formatDate value="${item.riqi}" pattern="yyyy-MM-dd" />&nbsp;</td>
					<td nowrap="nowrap"><fmt:formatDate value="${item.shijian}" type="time" />&nbsp;</td>
					<td nowrap="nowrap"><c:out value='${item.kongqiwendu}' />&nbsp;</td>
					<td nowrap="nowrap"><c:out value='${item.kongqishidu}' />&nbsp;</td>
					<td nowrap="nowrap"><c:out value='${item.daqiyaqiang}' />&nbsp;</td>
					<td nowrap="nowrap"><c:out value='${item.fengxiang}' />&nbsp;</td>
					<td nowrap="nowrap"><c:out value='${item.fengsu}' />&nbsp;</td>
					<td nowrap="nowrap"><c:out value='${item.yuliang}' />&nbsp;</td>
					<td nowrap="nowrap"><c:out value='${item.zhengfaliang}' />&nbsp;</td>
					<td nowrap="nowrap"><c:out value='${item.guangzhaoqiangdu}' />&nbsp;</td>
					<td nowrap="nowrap"><c:out value='${item.guanghe}' />&nbsp;</td>
					<td nowrap="nowrap"><c:out value='${item.zongfushe}' />&nbsp;</td>
					<td nowrap="nowrap"><c:out value='${item.turangwendu1}' />&nbsp;</td>
					<td nowrap="nowrap"><c:out value='${item.turangwendu2}' />&nbsp;</td>
					<td nowrap="nowrap"><c:out value='${item.turangwendu3}' />&nbsp;</td>
					<td nowrap="nowrap"><c:out value='${item.turangshidu1}' />&nbsp;</td>
					<td nowrap="nowrap"><c:out value='${item.turangshidu2}' />&nbsp;</td>
					<td nowrap="nowrap"><c:out value='${item.turangshidu3}' />&nbsp;</td>
					<td nowrap="nowrap"><c:out value='${item.turangEc}' />&nbsp;</td>
					<td nowrap="nowrap"><c:out value='${item.turangPh}' />&nbsp;</td>
					<td nowrap="nowrap">
						<div class="layui-btn-group">
							<button type="button" class="layui-btn layui-btn-primary layui-btn-xs" onclick="MinFormUtil.showDetail('qihou', ${item.id}, '');">查看</button>
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
