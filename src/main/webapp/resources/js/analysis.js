$(function() {
	obj = {
        putre : function() {
			var x = [];
			var y = [];
			$.getJSON('/poorBuild/statistics?year=2017', function(json, textStatus) {
				/*optional stuff to do after success */
				for ( var n in json) {
					x[n] = json[n].colleges;
					y[n] = json[n].count;
				}
				console.log(x);
				console.log(y)

				$('.container').highcharts({
					chart:{
						type : "column"
					},
					title : {
						text : "建档申请"
					},
					xAxis : {
						categories : x
					},
                    plotOptions:{
                        series: {
                            dataLabels: {
                                enabled: true
                            }
                        }
                    },
					yAxis : {
						title : {
							text : '数量'
						},
						min : 0,
						plotLines : [ {
							value : 0,
							width : 1,
							color : '#808080'
						} ]
					},
					tooltip : {
						valueSuffix : '人'
					},
					legend : {
						enabled : false,
						layout : 'vertical',
						align : 'right',
						verticalAlign : 'middle',
						borderWidth : 0
					},
					series : [ {
						name : '总数',
						data : y
					}]
				});
			});
		},
        grant : function() {
			var x = [];
			var y = [];
			var z = [];
			$.getJSON('/grant/statistics?year=2017', function(json, textStatus) {
				/*optional stuff to do after success */
				for ( var n in json) {
					x[n] = json[n].colleges;
					y[n] = json[n].count;
					z[n] = json[n].poorGrades;
				}
				console.log(x);
				console.log(y)

				$('.container').highcharts({
					chart:{
						type : "column",
					},
					plotOptions:{
						series: {
				            dataLabels: {
				                enabled: true
				            }
				        }
					},
					title : {
						text : "登录地点"
					},
					xAxis : {
						categories : x
					},
					yAxis : {
						title : {
							text : '登录次数'
						},
						min : 0,
						plotLines : [ {
							value : 0,
							width : 1,
							color : '#808080'
						} ]
					},
					tooltip : {
						valueSuffix : '次'
					},
					legend : {
						layout : 'vertical',
						align : 'right',
						verticalAlign : 'middle',
						borderWidth : 0
					},
					series : [ {
						name : z,
						data : y
					} ]
				});
			});
		},
        movacition : function() {
			var x = [];
			var y = [];
			$.getJSON('/motivational/statistics?year=2017', function(json, textStatus) {
				/*optional stuff to do after success */
				for ( var n in json) {
					x[n] = json[n].colleges;
					y[n] = json[n].count;
				}
				console.log(x);
				console.log(y)

				$('.container').highcharts({
                    chart:{
                        type : "column",
                    },
                    plotOptions:{
                        series: {
                            dataLabels: {
                                enabled: true
                            }
                        }
                    },
					title : {
						text : "登录时间"
					},
					xAxis : {
						categories : x,
					},
					yAxis : {
						title : {
							text : '登录次数'
						},
						min : 0,
						plotLines : [ {
							value : 0,
							width : 1,
							color : '#808080'
						} ]
					},
					tooltip : {
						valueSuffix : '次'
					},
					legend : {
						layout : 'vertical',
						align : 'right',
						verticalAlign : 'middle',
						borderWidth : 0
					},
					series : [ {
						name : '登录',
						data : y
					} ]
				});
			});
		}
	}
});