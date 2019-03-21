layui.use([ 'form', 'laypage', 'layer' ], function() {
	var form = layui.form, layer = layui.layer, $ = layui.jquery, laypage = layui.laypage;
	// 完整功能
	laypage.render({
		elem : 'laypage',
		count : $("#totalResult").val(),
		curr : $("#currentPage").val(),
		groups : 5,
		limit : $("#showCount").val(),
		limits : [ 10, 20, 30, 40, 50, 60 ],
		layout : [ 'count', 'prev', 'page', 'next', 'limit', 'refresh', 'skip' ],
		theme : '#1E9FFF',
		jump : function(obj, first) {
			if (!first) {
				// layer.msg('第 '+ obj.curr +' 页');
				$("#currentPage").val(obj.curr);
				$("#showCount").val(obj.limit);
				$("#searchForm").submit();
			}
			form.render();
		}
	});

	// 监听登录
	form.on('submit(login)', function(data) {
		var datas = data.field;
		var action = data.form.action;
		// layer.msg(JSON.stringify(data.field));
		var flag = submit_Url(action, datas, 'POST');
		if (action.indexOf("/min/default/login") > -1 && flag == 200) {
			window.location.href = contextPath + "min/default/welcome";
		}
		return false;
	});
	// 监听添加功能
	form.on('submit(add)', function(data) {
		var datas = $("#" + data.form.id).serialize();
		var action = data.form.action;
		// layer.msg(JSON.stringify(data.field));
		var flag = submit_Url(action, datas, 'POST');
		if (flag == 200) {
			// parent.$("#handle_status").val(200);
			var index = parent.layer.getFrameIndex(window.name);
			parent.layer.close(index);
		}
		// else {
		// //parent.$("#handle_status").val(flag);
		// }
		return false;
	});
	// 监听修改功能
	form.on('submit(edit)', function(data) {
		var datas = data.field;
		var action = data.form.action;
		var flag = submit_Url(action, datas, 'PUT');
		if (flag == 200) {
			// parent.$("#handle_status").val(200);
			var index = parent.layer.getFrameIndex(window.name);
			parent.layer.close(index);
		}
		return false;
	});
});

var MinFormUtil = {
	_toUrlPage : function(title, url, width, height, isReload) {
		layer.open({
			type : 2, // 此处以iframe举例
			title : title,
			area : [ width, height ],
			shade : 0.3,
			id : 'LAY_layuipro',// 设定一个id，防止重复弹出
			maxmin : true,
			offset : "auto",
			content : contextPath + url,
			zIndex : layer.zIndex, // 重点1
			success : function(layero, index) {
				layer.setTop(layero); // 重点2
			},
			end : function(layero, index) {
				if (isReload) {
					window.document.getElementById("searchForm").submit();
				}
			}
		});
	},
	toUrlPage : function(title, url, width, height, isReload) {
		parent.layer.open({
			type : 2, // 此处以iframe举例
			title : title,
			area : [ width, height ],
			shade : 0.3,
			id : 'LAY_layuipro',// 设定一个id，防止重复弹出
			maxmin : true,
			offset : "auto",
			content : contextPath + url,
			zIndex : layer.zIndex, // 重点1
			success : function(layero, index) {
				// layer.setTop(layero); // 重点2
				// 向iframe页的id=house的元素传值 // 参考
				// https://yq.aliyun.com/ziliao/133150
				// var body = layer.getChildFrame('body', index);
				// body.contents().find("#house").val(111);
			},
			end : function(layero, index) {
				if (isReload) {
					window.document.getElementById("searchForm").submit();
				}

				// iframe页提交后得到的ajax返回值,然后给父页A中
				// id=handle_status的元素赋值,这边end回调后判断该值
				// var result = $("#handle_status").val();
				// alert(result);
				// if(result.length>0 ){ //防止关闭窗口报错
				// if ( result.code == 200 ) {
				// layer.msg(result.msg,{icon: 1, time: 1500
				// /**1.5秒关闭（如果不配置，默认是3秒）*/});
				// $("#handle_status").val('');
				// alert("-----");
				// $("#searchForm").submit();
				// } else {
				// layer.msg(result.msg,{icon: 2, time: 1500
				// /**1.5秒关闭（如果不配置，默认是3秒）*/ });
				// $("#handle_status").val('');
				// }
				// }else{
				// layer.msg('数据返回异常',{icon: 2, time: 1500
				// /**1.5秒关闭（如果不配置，默认是3秒）*/ });
				// $("#handle_status").val('');
				// }
			}
		});
	},
	/**
	 * 指定路径——固定参数
	 */
	submit_Url : function(url, param, method) {
		var flag = "";
		$.ajax({
			url : url,
			timeout : 10000,
			data : param,
			type : method,
			async : false,
			dataType : 'json',
			scriptCharset : "utf-8",
			success : function(result) {
				flag = result.code;
				if (result.code == 200) {
					parent.layer.msg(result.msg, {
						icon : 1,
						time : 1500
					/** 1.5秒关闭（如果不配置，默认是3秒） */
					});
				} else {
					parent.layer.msg(result.msg, {
						icon : 2,
						time : 1500
					/** 1.5秒关闭（如果不配置，默认是3秒） */
					});
				}
			}
		});
		return flag;
	},
	/**
	 * 删除
	 */
	del_Url : function(url, param) {
		parent.layer.msg("确定要删除数据吗？", {
			icon : 7,
			offset : "auto",
			time : 4000, // 3秒后自动关闭
			btn : [ '确定', '取消' ],
			btnAlign : 'c', // 按钮居中
			yes : function() {
				layer.close();
				var flag = submit_Url(url, param, 'DELETE');
				if (flag == 200) {
					window.document.getElementById("searchForm").submit();
				}
			},
			btn2 : function() {
				layer.close();
			}
		});
	},
	/**
	 * 指定链接异步修改数据
	 */
	edit_Url : function(url, param, method) {
		parent.layer.msg("确定执行本次操作吗？", {
			icon : 7,
			offset : "auto",
			time : 4000, // 3秒后自动关闭
			btn : [ '确定', '取消' ],
			btnAlign : 'c', // 按钮居中
			yes : function() {
				layer.close();
				var flag = submit_Url(url, param, method);
				if (flag == 200) {
					window.document.getElementById("searchForm").submit();
				}
			},
			btn2 : function() {
				layer.close();
			}
		});
	}

};

/**
 * 指定连接跳转页面
 * 
 * @param title
 * @param url
 * @param width
 * @param height
 */
function _toUrlPage(title, url, width, height, isReload) {
	// var frameId = window.frameElement.id;
	MinFormUtil._toUrlPage(title, url, width, height, isReload);
}
/**
 * 指定连接跳转页面
 * 
 * @param title
 * @param url
 * @param width
 * @param height
 */
function toUrlPage(title, url, width, height, isReload) {
	// var frameId = window.frameElement.id;
	MinFormUtil.toUrlPage(title, url, width, height, isReload);
}

/**
 * 指定链接提交数据
 * 
 * @param url
 * @param param
 * @param method
 */
function submit_Url(url, param, method) {
	return MinFormUtil.submit_Url(url, param, method);
}

/**
 * 指定链接删除数据
 * 
 * @param url
 * @param param
 */
function del_Url(url, param) {
	MinFormUtil.del_Url(url, param);
}
/**
 * 指定链接异步修改数据
 * 
 * @param url
 * @param param
 */
function edit_Url(url, param, method) {
	MinFormUtil.edit_Url(url, param, method);
}


/**
 * 切换分页显示条数
 */
function pageCount() {
	var changeCount = $("#changeCount").val();
	$("#showCount").val(changeCount);
	$("#searchForm").submit();
}

/**
 * 切换分页
 * @param _currentPage
 */
function chooesPage(_currentPage) {
	var changeCount = $("#changeCount").val();
	$("#showCount").val(changeCount);
	$("#currentPage").val(parseInt(_currentPage));
	$("#searchForm").submit();
}

/**
 * 切换每页显示多少条数据
 */
function _chooseCount() {
	var changeCount = $("#changeCount").val();
	$("#showCount").val(changeCount);
	var _currentPage = $("#chooseCount").val();
	$("#currentPage").val(parseInt(_currentPage));
	$("#searchForm").submit();
}

/**
 * 更换页
 * 
 * @param status
 */
function _pageChange(status) {
	var currentPage = $("#currentPage").val();
	if (status == 'first') {
		$("#currentPage").val(1);
	}
	if (status == 'up') {
		$("#currentPage").val(parseInt(parseInt(currentPage) - 1));
	}
	if (status == 'down') {
		var totalPage = $("#totalPage").val();
		if (parseInt(currentPage) > parseInt(totalPage)) {
			$("#currentPage").val(parseInt(parseInt(totalPage)));
		} else {
			$("#currentPage").val(parseInt(parseInt(currentPage) + 1));
		}
	}
	if (status == 'last') {
		var totalPage = $("#totalPage").val();
		$("#currentPage").val(parseInt(parseInt(totalPage)));
	}
	var changeCount = $("#changeCount").val();
	$("#showCount").val(changeCount);
	$("#searchForm").submit();
}
