var chartsComm = {
	/**
	 * 饼状
	 */
	pie_chart : function(data) {
		$('#cont0')
				.highcharts(
						{
							chart : {
								plotBackgroundColor : null,
								plotBorderWidth : null,
								plotShadow : false
							},
							title : {
								text : ''
							},
							tooltip : {
								pointFormat : '{series.name}: <b>{point.percentage:.1f}%</b>'
							},
							credits:{
								enabled:''
								},
							plotOptions : {
								pie : {
									allowPointSelect : true,
									cursor : 'pointer',
									dataLabels : {
										enabled : true,
										color : '#000000',
										connectorColor : '#000000',
										format : '<b>{point.name}</b>: {point.percentage:.1f} %'
									}
								}
							},
							series : [ data ],
							colors : [ 'red',// 第一个颜色
							'orange',// 第二个颜色
							'yellow',// 第三个颜色
							'green', '#00B400', '#ccc' ],
						});
	},
	/**
	 * 柱状
	 */
	columnar_chart : function(data) {
		var result = eval("(" + data + ")");
		$('#cont1').highcharts(result);
	},
	/**
	 * 区域图
	 */
	area_chart : function(data) {
		var result = eval("(" + data + ")");
		$('#container').highcharts({
			chart : {
				type : 'area'
			},
			title : {
				text : ''
			},
			subtitle : {
				text : ''
			},
			
			credits : {
				enabled : ''
			},
			xAxis : {
				labels : {
					formatter : function() {
						return parseInt(this.value) + "月"; // clean,
															// unformatted
															// number for year
					}
				}
			},
			yAxis : {
				title : {
					text : '信息量统计'
				},
				labels : {
					formatter : function() {
						return this.value;
					}
				}
			},exporting: {
	            enabled: false
	        },
			credits:{
				enabled:''
				},
			plotOptions : {
				area : {
					pointStart : 1,
					marker : {
						enabled : false,
						symbol : 'circle',
						radius : 1,
						states : {
							hover : {
								enabled : true
							}
						}
					}
				}
			},
			series : result
		});
	}
};
