<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- include _comm.jsp -->
<%@ include file="/comm/_comm.jsp"%>
<!-- title -->
<title>林之牧物联网</title>
</head>
<!-- body -->
<body>
	<form class="layui-form layui-form-pane" action="min/logs/get/pre" method="get" id="searchForm" name="searchForm">
		<input type="hidden" id="totalResult" name="totalResult" value="${page.totalResult }"> 
		<input type="hidden" id="currentPage" name="currentPage" value="${page.currentPage }"> 
		<input type="hidden" id="showCount" name="showCount" value="${page.showCount }"> 
		<input id="handle_status" value="" type="hidden">
		<div class="layui-form-item border_shadow">
			<label class="layui-form-label">账号/用户名</label>
			<div class="layui-input-inline">
				<input type="text" name="_userName" value="${_userName }" lay-verify="required" placeholder="请输入账号或用户名"
					autocomplete="off" class="layui-input">
			</div>
		</div>
		<div class="layui-btn-group">
			<button type="submit" class="layui-btn layui-btn-sm layui-btn-normal">
				<i class="layui-icon">&#xe615;</i>搜索
			</button>
		</div>
	</form>
	
	<div class="layui-form">
		<table class="layui-table no_border_shadow">
			<colgroup>
				<col width="50">
				<col width="150">
				<col width="320">
				<col width="60">
				<col width="60">
				<col width="60">
				<col width="100">
				<col>
			</colgroup>
			<thead>
				<tr>
					<th>编号</th>
					<th>用户信息</th>
					<th>日志内容</th>
					<th>执行方法</th>
					<th>操作表</th>
					<th>IP地址</th>
					<th>执行时间</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
			
			<c:forEach items="${list}" var="item" varStatus="status">
		  	  
			  <tr>
				<td>${status.index+1}</td>
				<td>
					<c:out value='${item.user}'/>&nbsp;
				</td>
				<td>
					${fn:substring(item.record, 0, 40)}&nbsp;
				</td>
				<td>
					<c:out value='${item.method}'/>&nbsp;
				</td>
				<td>
					<c:out value='${item.tableName}'/>&nbsp;
				</td>
				<td>
					<c:out value='${item.ipAddr}'/>&nbsp;
				</td>
				<td>
					<fmt:formatDate value="${item.creatTime}" pattern="yyyy-MM-dd" />&nbsp;
				</td>
				<td>
					<div class="layui-btn-group">
						<button class="layui-btn layui-btn-xs layui-btn-normal" onclick="toUrlPage('日志信息详情', 'min/logs/showDetail/${item.id}', '80%', '80%', true)">查看</button>
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
