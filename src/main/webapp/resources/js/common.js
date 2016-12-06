$(function(){
	//表格行，鼠标放上去变色
	$(".tr:odd").css("background", "#FFFCEA");
	$(".tr:odd").each(function(){
		$(this).hover(function(){
			$(this).css("background-color", "#FFE1FF");
		}, function(){
			$(this).css("background-color", "#FFFCEA");
		});
	});
	$(".tr:even").each(function(){
		$(this).hover(function(){
			$(this).css("background-color", "#FFE1FF");
		}, function(){
			$(this).css("background-color", "#fff");
		});
	}); 

	/*ie6,7下拉框美化*/
    if ( $.browser.msie ){
    	if($.browser.version == '7.0' || $.browser.version == '6.0'){
    		$('.select').each(function(i){
			   $(this).parents('.select_border,.select_containers').width($(this).width()+5); 
			 });
    		
    	}
    }

});

function updateImg() {
	var img = document.getElementById("Img1");
	var imgName = document.getElementById("Img2");
	var file = $("<input type='file' accept='image/gif,image/png,image/jpeg'/>");
	file.click().change(function (e) {
		sendFile(
			file[0].files[0],
			function (data) {
				//回调
				var json = JSON.parse(data);
				img.src= "/upload/" + json.content;
				$("[name=img]").val(json.content);
			},
			function (err) {
				//错误
				console.log(err)
			},
			function (e) {
				if (e.lengthComputable) {
					var percentage = Math.round((e.loaded * 100) / e.total);
					console.log(percentage)
				}
			}
		)
	})
}

/**
 * 上传文件
 * @param file 文件
 * @param process 进度回调
 * @param callback 回调函数
 * @param error 错误回调
 */
function sendFile(file, callback, error, process) {
	console.log("aa");
	var uri = "/file/upload";
	var xhr = new XMLHttpRequest();
	var fd = new FormData();
	xhr.open("POST", uri, true);
	xhr.onreadystatechange = function () {
		if (xhr.readyState == 4 && xhr.status == 200) {
			// Handle response.
			try {
				if (callback != null && typeof(callback) === "function") {
					callback(xhr.responseText)
				} else {
					console.log(xhr.responseText)
				}
			} catch (e) {
				if (error != null && typeof(callback) === "function") {
					error(e)
				} else {
					console.log(e)
				}
			}
		}
	}
	if (process != null && typeof(process) === "function") {
		xhr.upload.addEventListener("progress", process, false)
	}
	fd.append('file', file);
	// Initiate a multipart/form-data upload
	xhr.send(fd);

}