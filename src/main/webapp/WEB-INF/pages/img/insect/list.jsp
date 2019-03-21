<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- include _comm.jsp -->
<%@ include file="/comm/_comm.jsp"%>
<!-- title -->
<title>林之牧物联网</title>
<link rel="stylesheet" href="js/comm/jQueryViewer/css/viewer.min.css">
<style>
* { margin: 0; padding: 0;}
#jq22 { width: 100%; margin: 0 auto; font-size: 0;}
#jq22 li { display: inline-block; width: 240px; height:240px; margin-left: 1%; padding-top: 1%;}
#jq22 li img { width: 100%; height: 100%;cursor: pointer}
</style>
</head>
<!-- body -->
<body>

<!-- search Start -->
<form class="layui-form  layui-form-pane" action="min/imginsect/get/pre" method="get" id="searchForm" name="searchForm">
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
		
		<div class="layui-btn-group">
			<button type="submit" class="layui-btn layui-btn-sm layui-btn-normal">
				<i class="layui-icon  layui-anim layui-anim-scaleSpring">&#xe615;</i>搜索</button>
		</div>
	</div>
</form>
<!-- search End -->

<!-- Table Start -->
<div class="layui-form">
	<ul id="jq22">
		<c:forEach items="${list }" var="item">
			<li><img data-original="${realmName }${item.imgPath }" src="${realmName }${item.imgPath }" alt="${item.imgName }"></li>
		</c:forEach>
	</ul>
	<div id="laypage"  class="border_shadow"></div>
</div>
<!-- Table End -->
<script src="js/comm/jQueryViewer/js/viewer.min.js"></script>
<script>
	var viewer = new Viewer(document.getElementById('jq22'), {
		url: 'data-original'
	});
</script>
</body>
</html>
