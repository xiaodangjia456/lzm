<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/comm/_comm.jsp"%>
<title>林之牧物联网</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
	
<script type="text/javascript" src="js/comm/lib/jquery-1.9.0.min.js"></script>
<script type="text/javascript" src="js/comm/lib/html5.js"></script>
<script src="js/comm/cloud.js" type="text/javascript"></script>
<script language="javascript" type="text/javascript">
	$(function() {
		$("#but_closePage").hide();
		$("#userLogin").css("border-bottom", "2px solid #f00");
		$('h1').click(function() {
			var h_id = $(this).attr("id");
			if (h_id == "adminLogin") {
				$("#adminLogin").css("border-bottom", "2px solid #f00");
				$("#userLogin").css("border-bottom", "1px solid aliceblue");
				$("#but_register").hide();
				$("#but_closePage").show();
			} else {
				$("#userLogin").css("border-bottom", "2px solid #f00");
				$("#adminLogin").css("border-bottom", "1px solid aliceblue");
				$("#but_register").show();
				$("#but_closePage").hide();
			}
		});
		$('.loginbox').css({
			'position' : 'absolute',
			'left' : ($(window).width() - 450) / 2
		});
		$(window).resize(function() {
			$('.loginbox').css({
				'position' : 'absolute',
				'left' : ($(window).width() - 450) / 2
			});
		});
	});

	// 回车登录
	document.onkeyup = function(e) {
		if (event.keyCode == "13") {//keyCode=13是回车键
			submit_Url(contextPath + "min/default/login", $("#loginForm")
					.serialize(), "POST");
		}
	};
	function custom_close() {
		if (confirm("您确定要关闭本页吗？")) {
			window.opener = null;
			window.open('', '_self');
			window.close();
		}
	}
</script>

</head>

<body
	style="background-color: #1c77ac; background-image: url(images/light.png); background-repeat: no-repeat; background-position: center top; overflow: hidden;">
	<div id="mainBody">
		<div id="cloud1" class="cloud"></div>
		<div id="cloud2" class="cloud"></div>
	</div>
	<div class="logintop">
		<span>欢迎登录林之牧物联网</span>
		<ul>
			<li><a href="#">回首页</a></li>
			<li><a href="#">帮助</a></li>
			<li><a href="#">关于</a></li>
		</ul>
	</div>
	<div class="loginbody">
		<span class="systemlogo"></span>
		<div class="login-box">
			<header>
				<h1 id="userLogin">用户登录</h1>
				<h1 id="adminLogin">管理员登录</h1>
			</header>
			<div id="userLogin_div" class="login-main">
				<form action="min/default/login" id="loginForm" data-type="ajax"
					class="layui-form" method="post">
					<div class="layui-form-item">
						<label class="login-icon"> <i class="layui-icon">&#xe66f;</i>
						</label> <input type="text" name="username" lay-verify="userName"
							autocomplete="off" placeholder="这里输入登录名" class="layui-input" style="height: 40px;" />
					</div>
					<div class="layui-form-item">
						<label class="login-icon"> <i class="layui-icon">&#xe673;</i>
						</label> <input type="password" name="password" lay-verify="password"
							autocomplete="off" placeholder="这里输入密码" class="layui-input" style="height: 40px;" />
					</div>
					<div class="layui-form-item">
						<div class="layui-inline">
							<div class="layui-input-inline" style="width: 140px;">
								<label class="login-icon"> <i class="layui-icon">&#xe679;</i>
								</label> <input type="text" class="layui-input" id="validateCode"
									name="validateCode" lay-verify="code" autocomplete="off"
									placeholder="这里输入验证码" style="height: 40px;" />
							</div>
							<div class="layui-input-inline" style="width: 100px;">
								<img id="valiCode" src="min/RandomValidateCode/creat/image"
									alt="验证码" onclick="this.src=this.src+''" />
							</div>
						</div>
					</div>

					<div class="layui-form-item">
						<div class="pull-left">
							<button id="but_login" class="layui-btn layui-btn-primary"
								lay-submit="" lay-filter="login">&nbsp;&nbsp;登&nbsp;&nbsp;&nbsp;&nbsp;录&nbsp;&nbsp;</button>
						</div>
						<div class="pull-right">
							<!-- <button id="but_register" type="button"
								class="layui-btn layui-btn-primary"
								onclick="toUrlPage('注册信息','/min/default/register/page','60%','80%');">&nbsp;&nbsp;注&nbsp;&nbsp;&nbsp;&nbsp;册&nbsp;&nbsp;</button>
								 -->
							<button id="but_closePage" type="button" style="display: none;"
								class="layui-btn layui-btn-primary" onclick="custom_close();">&nbsp;&nbsp;关&nbsp;&nbsp;&nbsp;&nbsp;闭&nbsp;&nbsp;</button>
						</div>

						<div class="clear"></div>
					</div>
				</form>
			</div>
			<footer>
				<p>林之牧物联网</p>
			</footer>
		</div>
	</div>

	<div class="loginbm">版权所有 2017 xxxx.com 林之牧物联网</div>
</body>
</html>
