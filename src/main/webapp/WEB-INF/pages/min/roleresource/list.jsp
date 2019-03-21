<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- include _comm.jsp -->
<%@ include file="/comm/_comm.jsp"%>
<!-- title -->
<title>林之牧物联网</title>
</head>
<!-- body -->
<body>
<br>
	<form action="/min/roleresource/get/pre" method="get" id="searchForm" name="searchForm">
		<input type="hidden" id="contextPath" name="contextPath" value="">
		<div class="layui-form-item">
			<label class="layui-form-label">账号/用户名</label>
			<div class="layui-input-inline">
				<input type="text" name="_userName" value="" lay-verify="required" placeholder="请输入账号或用户名"
					autocomplete="off" class="layui-input">
			</div>
			<button type="submit" class="layui-btn">搜索</button>
		</div>
	</form>
	<div class="site-demo-button" style="margin-bottom: 0;">
		<button data-method="setTop" class="layui-btn" data-title="添加用户信息" data-url="/min/roleresource/post/pre">添加</button>
	</div>
	
	<div class="layui-form">
		<table class="layui-table">
			<colgroup>
				<col width="50">
					<col width="60">
					<col width="60">
					<col width="60">
				<col>
			</colgroup>
			<thead>
				<tr>
					<th>编号</th>
					<th>角色ID</th>
					<th>资源ID</th>
					<th>用户ID</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
			
			<c:forEach items="${page.result}" var="item" varStatus="status">
		  	  
			  <tr>
				<td>${page.thisPageFirstElementNumber + status.index}</td>
						<td>
							<c:out value='${item.roleId}'/>&nbsp;
						</td>
						<td>
							<c:out value='${item.resourceId}'/>&nbsp;
						</td>
						<td>
							<c:out value='${item.userId}'/>&nbsp;
						</td>
				<td>
					<button data-method="showButton" class="layui-btn  layui-btn-small" data-title="查看用户信息" data-url="/min/roleresource/showDetail/${item.id}">查看</button>
					<button data-method="updateButton" class="layui-btn  layui-btn-small" data-title="修改用户信息" data-url="/min/roleresource/${item.id}/put/pre">修改</button>
					<button data-method="deleteButton" class="layui-btn  layui-btn-small" data-title="确定删除用户信息吗？" data-url="/min/roleresource/${item.id}">删除</button>
				</td>
			  </tr>
			  
		  	  </c:forEach>
			</tbody>
		</table>
	</div>
	<div id="laypage"></div>


	<!-- 通用-970*90 -->
	<div>
		<ins class="adsbygoogle" style="display: inline-block; width: 970px; height: 90px"
			data-ad-client="ca-pub-6111334333458862" data-ad-slot="6835627838"></ins>
	</div>	
	
</body>
</html>
