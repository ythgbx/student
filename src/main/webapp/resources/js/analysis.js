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
				console.log(y);

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
							text : '人数'
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
						name : '建档',
						data : y
					}]
				});
			});
		},
        grant : function() {
			var x = [];
			var commonly = [];
			var general = [];
			var special = [];
			$.getJSON('/grant/statistics?year=2017', function(json, textStatus) {
				/*optional stuff to do after success */
                for ( var n in json) {
                	x.push(json[n].colleges);
                    commonly.push(json[n].commonly);
                    general.push(json[n].general);
                    special.push(json[n].special);

                }



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
						text : "助学金"
					},
					xAxis : {
						categories : x
					},
					yAxis : {
						title : {
							text : '人数'
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
						layout : 'vertical',
						align : 'right',
						verticalAlign : 'middle',
						borderWidth : 0
					},
					series : [ {
						name : "困难",
						data : commonly
					},{
					    name : "一般困难",
                        data : general
                    },{
					    name : "特别困难",
                        data : special
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
						text : "励志奖学金"
					},
					xAxis : {
						categories : x
					},
					yAxis : {
						title : {
							text : '人数'
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
						name : '励志奖学金',
						data : y
					} ]
				});
			});
		}
	}
});