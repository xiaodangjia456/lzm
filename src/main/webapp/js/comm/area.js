layui.use([ 'form', 'layer' ],function() {
	var form = layui.form, layer = layui.layer, $ = layui.jquery;

	// 监听省下拉菜单
	form.on('select(_sheng)',function(data) {
		if (data.value == ""
				|| data.value == "undefined") {
			$("#city_shi").empty();
			$("#city_shi").append('<option value="">请选择市</option>');
			$("#city_shi").append('<option value="">显示全部</option>');
			form.render();
		} else {
			$.ajax({
				url : contextPath + 'min/city/get/city/by/' + data.value,
				type : 'GET',
				success : function(result) {
					$("#city_shi").empty();
					$("#city_shi").append('<option value="">请选择市</option>');
					$("#city_shi").append('<option value="">显示全部</option>');
					if (result != "") {
						var _shis = eval("("+ result + ")");
						$.each(_shis,function(i,item) {
							$("#city_shi").append('<option value="'+ item.name+ '">'+ item.name+ '</option>');
						});
					}
					form.render();
				}
			});
		}
	});

	// 监听省下拉菜单
	form.on('select(_shi)',function(data) {
		if (data.value == "" || data.value == "undefined") {
			$("#city_xian").empty();
			$("#city_xian").append('<option value="">请选择县/区</option>');
			$("#city_xian").append('<option value="">显示全部</option>');
			form.render();
		} else {
			$.ajax({
				url :contextPath + '/min/city/get/city/by/' + data.value,
				type : 'GET',
				success : function(result) {
					$("#city_xian").empty();
					$("#city_xian").append('<option value="">请选择县/区</option>');
					$("#city_xian").append('<option value="">显示全部</option>');
					if (result != "") {
						var _shis = eval("("+ result+ ")");
						$.each(_shis,function(i,item) {
							$("#city_xian").append('<option value="'+ item.name+ '">'+ item.name+ '</option>');
						});
					}
					form.render();
				}
			});
		}
	});
	
});