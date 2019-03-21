layui.use([ 'layer', 'form', 'element' ],function() {
	var layer = layui.layer, $ = layui.jquery, form = layui.form;

	form.verify({
		userName : function(value) {
			if (value === '')
				return '请输入用户名';
		},
		password : function(value) {
			if (value === '')
				return '请输入密码';
		},
		code : function(value) {
			if (value === '')
				return '请输入验证码';
		}
	});
	// 监听提交
	form.on('submit(login)', function(data) {
		var datas = data.field;
		var action = data.form.action;
		alert(action);
		$.ajax({
			url : action,
			timeout : 10000,
			data : datas,
			type : 'POST',
			dataType:'json',
			scriptCharset : "utf-8",
			success : function(result) {
				layer.msg(result.message, {
					icon : 2
				});
				if (result.status == "300") {
					layer.msg("验证码不正确！", {
						icon : 2
					});
					return false;
				} else if (result.status == "301") {
					layer.msg("验证码不能为空！", {
						icon : 2
					});
					return false;
				} else if (result.status == "400"
						|| result.status == "401") {
					layer.msg("登录失败,账号或密码错误！", {
						icon : 2
					});
					return false;
				} else if (result.status == "200") {
					window.location.href = contextPath + '/min/default/welcome';
					layer.msg("登录成功！", {
						icon : 1
					});
					return true;
				} else {
					layer.msg("登录失败,账号或密码错误！", {
						icon : 2
					});
					return false;
				}
			}
		});
		return false;
	});
});
