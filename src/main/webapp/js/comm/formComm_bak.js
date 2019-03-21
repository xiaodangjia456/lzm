layui
		.use(
				[ 'form', 'layedit', 'laydate', 'element', 'laypage', 'layer' ],
				function() {
					var form = layui.form(), layer = layui.layer, layedit = layui.layedit, laydate = layui.laydate, element = layui
							.element(), $ = layui.jquery, laypage = layui.laypage;
					layedit.set({
						uploadImage : {
							url : $("#contextPath").val()
									+ '/min/RandomValidateCode/image/upload', // 接口url
							type : 'post' // 默认post
						}
					});

					// 创建一个编辑器
					var editIndex = layedit.build('LAY_demo_editor');
					//自定义验证规则
					form.verify({
						dbnumber: [/^([0-9]{1,}[.][0-9]*)$/, '对不起，请输入正确数字！']
					});

					form.on('radio(bill)', function(data){
						var bill = data.value; //被点击的radio的value值
						if(bill=="不开"){
							$("#paymentMethod").attr("lay-verify","");
							$("#billCompany").attr("lay-verify","");
							$("#billCode").attr("lay-verify","");
							$("#billAddress").attr("lay-verify","");
							$("#paymentMethod_div").hide();
							$("#bill_item_div").hide();
						}else{
							$("#paymentMethod").attr("lay-verify","required");
							$("#billCompany").attr("lay-verify","required");
							$("#billCode").attr("lay-verify","required");
							$("#billAddress").attr("lay-verify","required");
							$("#paymentMethod_div").show();
							$("#bill_item_div").show();
						}
					}); 
					// 监听省下拉菜单
					form
							.on(
									'select(_sheng)',
									function(data) {
										if (data.value == ""
												|| data.value == "undefined") {
											$("#city_shi").empty();
											$("#city_shi")
													.append(
															'<option value="">请选择市</option>');
											$("#city_shi")
													.append(
															'<option value="">显示全部</option>');
											form.render();
										} else {
											$
													.ajax({
														url : $("#contextPath")
																.val()
																+ '/min/city/get/city/by/'
																+ data.value,
														type : 'GET',
														success : function(
																result) {
															$("#city_shi")
																	.empty();
															$("#city_shi")
																	.append(
																			'<option value="">请选择市</option>');
															$("#city_shi")
																	.append(
																			'<option value="">显示全部</option>');
															if (result != "") {
																var _shis = eval("("
																		+ result
																		+ ")");
																$
																		.each(
																				_shis,
																				function(
																						i,
																						item) {
																					$(
																							"#city_shi")
																							.append(
																									'<option value="'
																											+ item.name
																											+ '">'
																											+ item.name
																											+ '</option>');
																				});
															}
															form.render();
														}
													});
										}
									});

					// 监听省下拉菜单
					form
							.on(
									'select(_shi)',
									function(data) {
										if (data.value == ""
												|| data.value == "undefined") {
											$("#city_xian").empty();
											$("#city_xian")
													.append(
															'<option value="">请选择县/区</option>');
											$("#city_xian")
													.append(
															'<option value="">显示全部</option>');
											form.render();
										} else {
											$
													.ajax({
														url : $("#contextPath")
																.val()
																+ '/min/city/get/city/by/'
																+ data.value,
														type : 'GET',
														success : function(
																result) {
															$("#city_xian")
																	.empty();
															$("#city_xian")
																	.append(
																			'<option value="">请选择县/区</option>');
															$("#city_xian")
																	.append(
																			'<option value="">显示全部</option>');
															if (result != "") {
																var _shis = eval("("
																		+ result
																		+ ")");
																$
																		.each(
																				_shis,
																				function(
																						i,
																						item) {
																					$(
																							"#city_xian")
																							.append(
																									'<option value="'
																											+ item.name
																											+ '">'
																											+ item.name
																											+ '</option>');
																				});
															}
															form.render();
														}
													});
										}
									});

					// 监听省下拉菜单
					form
							.on(
									'select(_deviceId)',
									function(data) {
										if (data.value == ""
												|| data.value == "undefined") {
											$("#s_deviceModelId").empty();
											$("#s_deviceModelId")
													.append(
															'<option value="">请选择[设备型号]</option>');
											$("#s_deviceModelId")
													.append(
															'<option value="">显示全部</option>');
											form.render();
										} else {
											$
													.ajax({
														url : $("#contextPath")
																.val()
																+ '/min/devicemodel/get/by/'
																+ data.value,
														type : 'GET',
														success : function(
																result) {
															$(
																	"#s_deviceModelId")
																	.empty();
															$(
																	"#s_deviceModelId")
																	.append(
																			'<option value="">请选择[设备型号]</option>');
															$(
																	"#s_deviceModelId")
																	.append(
																			'<option value="">显示全部</option>');
															if (result != "") {
																var _deviceModelId = eval("("
																		+ result
																		+ ")");
																$
																		.each(
																				_deviceModelId,
																				function(
																						i,
																						item) {
																					$(
																							"#s_deviceModelId")
																							.append(
																									'<option value="'
																											+ item.id
																											+ '">'
																											+ item.deviceModel
																											+ '</option>');
																				});
															}
															form.render();
														}
													});
										}
									});

					// 监听省下拉菜单
					form
							.on(
									'select(_deviceModelId)',
									function(data) {
										if (data.value == ""
												|| data.value == "undefined") {
											$("#_device_model_fault").empty();
											$("#_device_model_fault")
													.append(
															'<input type="checkbox" name="faults" title="暂无" disabled="">');
											$("#_device_model_parts").empty();
											$("#_device_model_parts")
													.append(
															'<input type="checkbox" name="parts" title="暂无" disabled="">');

											$("#s_deviceModelPartsId").empty();
											$("#s_deviceModelPartsId")
													.append(
															'<option value="">请选择[配件信息]</option>');
											$("#s_deviceModelPartsId")
													.append(
															'<option value="">显示全部</option>');
											form.render();
										} else {
											$
													.ajax({
														url : $("#contextPath")
																.val()
																+ '/min/devicemodelparts/get/by/'
																+ data.value,
														type : 'GET',
														success : function(
																result) {

															$(
																	"#_device_model_fault")
																	.empty();
															$(
																	"#_device_model_parts")
																	.empty();

															$(
																	"#s_deviceModelPartsId")
																	.empty();
															$(
																	"#s_deviceModelPartsId")
																	.append(
																			'<option value="">请选择[配件信息]</option>');
															$(
																	"#s_deviceModelPartsId")
																	.append(
																			'<option value="">显示全部</option>');
															if (result != "") {
																var dateJson = eval("("
																		+ result
																		+ ")");
																$
																		.each(
																				dateJson.deviceModelParts,
																				function(
																						i,
																						item) {
																					$(
																							"#s_deviceModelPartsId")
																							.append(
																									'<option value="'
																											+ item.id
																											+ '">'
																											+ item.deviceParts
																											+ '</option>');
																					$(
																							"#_device_model_parts")
																							.append(
																									'<div class="layui-input-inline"><input type="checkbox" name="parts" value="'
																											+ item.id
																											+ '" title="'
																											+ item.deviceParts
																											+ '"><input type="text" name="partsNumber" placeholder="数量" style="width:50px;float:left;" autocomplete="off" class="layui-input"></div>');
																				});

																$
																		.each(
																				dateJson.deviceModelFault,
																				function(
																						i,
																						item) {
																					$(
																							"#_device_model_fault")
																							.append(
																									'<input type="checkbox" name="faults" value="'
																											+ item.id
																											+ '" title="'
																											+ item.faultTitle
																											+ '">');
																				});
															} else {
																$(
																		"#_device_model_fault")
																		.append(
																				'<input type="checkbox" name="faults" value="" title="暂无" disabled="">');
																$(
																		"#_device_model_parts")
																		.append(
																				'<input type="checkbox" name="parts" value="" title="暂无" disabled="">');
															}
															form.render();
														}
													});
										}
									});

					laypage({
						cont : 'laypage',
						pages : document.getElementById("totalPage").value,
						curr : document.getElementById("currentPage").value,
						groups : document.getElementById("showCount").value, // 连续显示分页数
						skip : true,
						jump : function(obj, first) {
							if (!first) {
								document.getElementById("currentPage").value = obj.curr;
								document.getElementById("searchForm").submit();
							}
						}
					});

					// 触发事件
					var active = {
						btnAdd : function() {
							// 添加按钮
							var title = $(this).data('title');
							var url = $(this).data('url');
							// 多窗口模式，层叠置顶
							layer.open({
								type : 2, // 此处以iframe举例
								title : title,
								area : [ '80%', '80%' ],
								shade : 0.3,
								id : 'LAY_layuipro',// 设定一个id，防止重复弹出
								maxmin : true,
								offset : "50px",
								content : url,
								zIndex : layer.zIndex, // 重点1
								success : function(layero) {
									layer.setTop(layero); // 重点2
								},
								end : function() {
									location.reload();
								}
							});
						},
						btnUpdate : function() {
							// 修改按钮
							var title = $(this).data('title');
							var url = $(this).data('url');
							// 多窗口模式，层叠置顶
							layer.open({
								type : 2, // 此处以iframe举例
								title : title,
								area : [ '80%', '80%' ],
								shade : 0.3,
								id : 'LAY_layuipro',// 设定一个id，防止重复弹出
								maxmin : true,
								offset : "50px",   // auto 自动适应
								content : url,
								zIndex : layer.zIndex, // 重点1
								success : function(layero) {
									layer.setTop(layero); // 重点2
								},
								end : function() {
									location.reload();
								}
							});
						},
						btnDelete : function() {
							// 删除按钮
							var title = $(this).data('title');
							var url = $(this).data('url');
							layer.msg(title, {
								time : 20000, // 20s后自动关闭
								btn : [ '确定', '取消' ],
								btnAlign : 'c', // 按钮居中
								yes : function() {
									layer.closeAll();
									layer.open({
										type : 2, // 此处以iframe举例
										title : title,
										area : [ '80%', '80%' ],
										shade : 0.3,
										id : 'LAY_layuipro',// 设定一个id，防止重复弹出
										maxmin : true,
										offset : "50px",   // auto 自动适应
										content : url,
										zIndex : layer.zIndex, // 重点1
										success : function(layero) {
											layer.setTop(layero); // 重点2
										},
										end : function() {
											location.reload();
										}
									});
								},
								btn2 : function() {
									layer.closeAll();
								}
							});
						},
						btnShow : function() {
							// 查看详情按钮
							var title = $(this).data('title');
							var url = $(this).data('url');
							// 多窗口模式，层叠置顶
							layer.open({
								type : 2, // 此处以iframe举例
								title : title,
								area : [ '80%', '80%' ],
								shade : 0.3,
								id : 'LAY_layuipro',// 设定一个id，防止重复弹出
								maxmin : true,
								offset : "50px",   // auto 自动适应
								content : url,
								zIndex : layer.zIndex, // 重点1
								success : function(layero) {
									layer.setTop(layero); // 重点2
								}
							});
						},
						btnQiTa : function() {
							// 查看详情按钮
							var title = $(this).data('title');
							var url = $(this).data('url');
							// 多窗口模式，层叠置顶
							layer.open({
								type : 2, // 此处以iframe举例
								title : title,
								area : [ '80%', '80%' ],
								shade : 0.3,
								id : 'LAY_layuipro',// 设定一个id，防止重复弹出
								maxmin : true,
								offset : "50px",   // auto 自动适应
								content : url,
								zIndex : layer.zIndex, // 重点1
								success : function(layero) {
									layer.setTop(layero); // 重点2
								}
							});
						},
						btnExport : function() {
							// 数据导出按钮
							var url = $(this).data('url');
							$.ajax({
								url : url,
								timeout : 10000,
								data : $("#searchForm").serialize(),
								type : 'GET',
								scriptCharset : "utf-8",
								success : function(result) {
									if(result!="" && (result.indexOf("/")>=0)){
										window.location.href = result;
									}
								}
							});
						}
					};

					$('.site-demo-button .layui-btn').on('click', function() {
						var othis = $(this), method = othis.data('method');
						active[method] ? active[method].call(this, othis) : '';
					});

					// 监听提交
					form.on('submit(formId)', function(data) {
						return true;
					});
					// 监听折叠
					element.on('collapse(test)', function(data) {
						layer.msg('展开状态：' + data.show);
					});
					
					// 时间控件
					var start = {
						min : '1900-01-01 00:00:00',
						max : '2099-12-31 23:59:59',
						istoday : false,
						choose : function(datas) {
							end.min = datas; // 开始日选好后，重置结束日的最小日期
							end.start = datas // 将结束日的初始值设定为开始日
						}
					};

					var end = {
						min : '1900-01-01 00:00:00',
						max : '2099-12-31 23:59:59',
						istoday : false,
						choose : function(datas) {
							start.max = datas; // 结束日选好后，重置开始日的最大日期
						}
					};
					
					document.getElementById('LAY_demorange_s').onclick = function() {
						start.elem = this;
						laydate(start);
					}
					document.getElementById('LAY_demorange_e').onclick = function() {
						end.elem = this;
						laydate(end);
					}

				});