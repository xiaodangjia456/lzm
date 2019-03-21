<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- include _comm.jsp -->
<%@ include file="/comm/_comm.jsp"%>
<!-- title -->
<title>林之牧物联网</title>
</head>
<!-- body -->
<body>
<br>
	<form class="layui-form" action="<%=contextPath%>/min/dictionary/get/pre" method="get" id="searchForm"
		name="searchForm">
		<input type="hidden" id="contextPath" name="contextPath" value="<%=contextPath%>"><input type="hidden"
			id="totalPage" name="totalPage" value="${page.totalPage }"> <input type="hidden" id="currentPage"
			name="currentPage" value="${page.currentPage }"> <input type="hidden" id="showCount" name="showCount"
			value="${page.showCount }">
		<div class="layui-form-item">
			<label class="layui-form-label">数据类型</label>
			<div class="layui-input-inline">
				<select name="type" lay-verify="required">
					<option value="">请选择[基础数据类型]</option>
					<option value="">显示全部</option>
					<c:forEach items="${d_map }" var="map">
						<option value="${map.key }" <c:if test="${map.key==type }">selected</c:if>>${map.value }</option>
					</c:forEach>
				</select>
			</div>

			<div class="site-demo-button" style="margin-bottom: 0;">
				<button type="submit" class="layui-btn">搜索</button>
				<button type="button" data-method="btnAdd" class="layui-btn" data-title="添加基础数据信息"
					data-url="<%=contextPath%>/min/dictionary/post/pre">添加</button>
			</div>
		</div>
	</form>

	<div class="layui-form">
		<table class="layui-table">
			<colgroup>
				<col width="60">
				<col width="350">
				<col width="200">
				<col>
			</colgroup>
			<thead>
				<tr>
					<th>编号</th>
					<th>描述内容</th>
					<th>数据类型</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach items="${list}" var="item" varStatus="status">

					<tr>
						<td>${status.index+1}</td>
						<td><c:out value='${item.content}' escapeXml="false" />&nbsp;</td>
						<td><c:out value='${item.type}' />&nbsp;</td>
						<td><c:choose>
								<c:when test="${fn:contains(item.type,'SQ_')}">
								</c:when>
								<c:otherwise>
									<div class="site-demo-button" style="margin-bottom: 0;">
										<button type="button" data-method="btnShow" class="layui-btn layui-btn-primary layui-btn-mini"
											data-title="查看基础数据信息" data-url="<%=contextPath%>/min/dictionary/showDetail/${item.id}">查看</button>
										<button type="button" data-method="btnUpdate" class="layui-btn layui-btn-primary layui-btn-mini"
											data-title="修改基础数据信息" data-url="<%=contextPath%>/min/dictionary/${item.id}/put/pre">修改</button>
										<button type="button" data-method="btnDelete" class="layui-btn layui-btn-primary layui-btn-mini"
											data-title="确定删除基础数据信息吗？" data-url="<%=contextPath%>/min/dictionary/delete/${item.id}">删除</button>
									</div>
								</c:otherwise>
							</c:choose>
						</td>
					</tr>

				</c:forEach>
			</tbody>
		</table>
		<div id="laypage"></div>
	</div>

</body>
</html>
