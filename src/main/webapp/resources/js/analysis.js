$(function() {
	obj = {
		device : function() {
			var x = [];
			var y = [];
			$.getJSON('/poorBuild/statistics', function(json, textStatus) {
				/*optional stuff to do after success */
				for ( var n in json) {
					x[n] = json[n].device;
					y[n] = json[n].num;
				}
				console.log(x);
				console.log(y)

				$('.container').highcharts({

					title : {
						text : "登录设备"
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
						name : '登录',
						data : y
					} ]
				});
			});
		},
		city : function() {
			var x = [];
			var y = [];
			$.getJSON('logfo/countCity.do', function(json, textStatus) {
				/*optional stuff to do after success */
				for ( var n in json) {
					x[n] = json[n].city;
					y[n] = json[n].num;
				}
				console.log(x);
				console.log(y)

				$('#container').highcharts({
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
						name : '登录',
						data : y
					} ]
				});
			});
		},
		time : function() {
			var x = [];
			var y = [];
			$.getJSON('logfo/countTime.do', function(json, textStatus) {
				/*optional stuff to do after success */
				for ( var n in json) {
					x[n] = json[n].time;
					y[n] = json[n].num;
				}
				console.log(x);
				console.log(y)

				$('#container').highcharts({

					title : {
						text : "登录时间"
					},
					xAxis : {
						//type: 'datetime',                                                   
						//tickPixelInterval: 10,
						categories : x,
						labels : {
							format : '{value} 时'
						}

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