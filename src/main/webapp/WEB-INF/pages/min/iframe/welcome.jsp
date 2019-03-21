<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%@ include file="/comm/_comm.jsp"%>
<title>林之牧物联网</title>

<link rel="stylesheet" href="css/sccl.css">
<link rel="stylesheet" type="text/css" href="css/skin/qingxin/skin.css" id="layout-skin" />
<script type="text/javascript" src="js/comm/lib/jquery-1.9.0.min.js"></script>
<script type="text/javascript" src="js/comm/lib/html5.js"></script>

</head>

<body>
	<input type="hidden" id="contextPath" name="contextPath" value="<%=contextPath%>">
	<div class="layout-admin">
		<header class="layout-header">
			<span class="header-logo">林之牧物联网</span> <a class="header-menu-btn" href="javascript:;"><i class="icon-font">&#xe600;</i></a>
			<ul class="header-bar">
				<li class="header-bar-role"><a href="">${user.role.roleName }</a></li>
				<li class="header-bar-nav"><a href="">${user.name }<i class="icon-font" style="margin-left: 5px;">&#xe60c;</i></a>
					<ul class="header-dropdown-menu">
						<li><a href="min/user/showDetail/${user.id}">个人信息</a></li>
						<li><a href="min/default/to/logout" target="_parent">切换账户</a></li>
						<li><a href="min/default/to/logout" target="_parent">退出</a></li>
					</ul></li>
				<li class="header-bar-nav"><a href="javascript:;" title="换肤"><i class="icon-font">&#xe608;</i></a>
					<ul class="header-dropdown-menu right dropdown-skin">
						<li><a href="" data-val="qingxin" title="清新">清新</a></li>
						<li><a href="" data-val="blue" title="蓝色">蓝色</a></li>
						<li><a href="" data-val="molv" title="墨绿">墨绿</a></li>

					</ul></li>
			</ul>
		</header>
		<aside class="layout-side">
			<ul class="side-menu">

			</ul>
		</aside>

		<div class="layout-side-arrow">
			<div class="layout-side-arrow-icon">
				<i class="icon-font">&#xe60d;</i>
			</div>
		</div>

		<section class="layout-main">
			<div class="layout-main-tab">
				<button class="tab-btn btn-left">
					<i class="icon-font">&#xe60e;</i>
				</button>
				<nav class="tab-nav">
					<div class="tab-nav-content">
						<a href="" class="content-tab active" data-id="min/default/right">首页</a>
					</div>
				</nav>
				<button class="tab-btn btn-right">
					<i class="icon-font">&#xe60f;</i>
				</button>
			</div>
			<div class="layout-main-body">
				<iframe class="body-iframe" name="iframe0" width="100%" height="99%" src="min/default/right"
					frameborder="0" data-id="min/default/right" seamless></iframe>
			</div>
		</section>
		<div class="layout-footer">@2017 12.1 林之牧物联网</div>
	</div>
	
<script type="text/javascript" src="js/comm/sccl.js"></script>
<script type="text/javascript" src="js/comm/sccl-util.js"></script>
	<script type="text/javascript">
		/*
		初始化加载
		 */
		$(function() {
			/*获取皮肤*/
			//getSkinByCookie();
			/*菜单json*/
			var menu;
			var url = $("#contextPath").val() + "/min/default/get/left/menu";
			$.ajax({
				url : url,
				type : 'get',
				success : function(result) {
					menu = eval("(" + result + ")");
					initMenu(menu, $(".side-menu"));
					$(".side-menu > li").addClass("menu-item");
				}
			});

			/*获取菜单icon随机色*/
			//getMathColor();
		});
	</script>
</body>
</html>
