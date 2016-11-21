<#include "common/_layout.ftl">
<@layoutHead title="网站"></@layoutHead>

<@layoutBody>
<!-- 这是nested的内容-->

<ul class="breadcrumb">
    <li><span class="primary-font"><i class="icon-home"></i></span><a href="#">首页</a></li>
    <li>管理中心</li>
    <li>活动管理</li>
</ul>

<div class="smart-widget clearfix">
    <div class="smart-widget-header ">
        活动中心
        <button type="button" onclick="mulit_del()" class="button border-red" id="button1"><span class="icon-trash-o"></span> 批量删除
        </button>
        <button class="btn btn-success  smart-widget-option" data-toggle="modal" data-target="#myModal">添加活动
        </button>
    </div>

    <div class="smart-widget-inner">
        <div class="smart-widget-body">

            <table class="table table-hover table table-condensed">
                <thead>
                <tr class="active">
                    <th class="text-center">
                        <div class="custom-checkbox">
                            <input class="inbox-check" id="chkAll" type="checkbox">
                            <label for="chkAll"></label>
                        </div>
                    </th>
                    <#--<th>序号</th>-->
                    <th>活动ID</th>
                    <th>活动名称</th>
                    <th>活动简介</th>
                    <th>当前报名人数</th>
                    <th>活动价格</th>
                    <th>最少人数</th>
                    <th>最多人数</th>
                    <th>活动开始时间</th>
                    <th>活动结束时间</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                    <#list activityList as oneActivity>
                    <tr class="active">
                        <td class="text-center">
                            <div class="custom-checkbox">
                                <input type="checkbox" id="chk${oneActivity.id}" name="choose" class="inbox-check"
                                       value="${oneActivity.id}">
                                <label for="chk${oneActivity.id}"></label>
                            </div>
                        </td>
                        <#--<td>${oneActivity_index+1}</td>-->
                        <td>${oneActivity.id}</td>
                        <td>${oneActivity.title}</td>
                        <td width="200">${oneActivity.detail}</td>
                        <td>${oneActivity.numberOfPeople}</td>
                        <td>${oneActivity.price}</td>
                        <td>${oneActivity.lowerLimit}</td>
                        <td>${oneActivity.upperLimit}</td>
                        <td>${oneActivity.startime?string('yyyy.MM.dd HH:mm:ss')}</td>
                        <td>${oneActivity.endtime?string('yyyy.MM.dd HH:mm:ss')}</td>
                        <td>
                            <a href=""
                               data-toggle="modal"
                               data-target="#myModal2"
                               onclick="getContent(this)"
                            >
                                <i class="fa fa-bars"></i>
                            </a>      <!--修改活动 -->
                            <a href=""
                               onclick="mulit_del(this)"
                            >
                                <i class="fa fa-times" id="button2"></i>
                            </a>
                        </td><!--删除活动 -->
                    </tr>
                    </#list>
                </tbody>
                <tbody>
                    <ul class="pagination">
                        <li><a href="/activity/list?page=${pagePojo.homePage}">首页</a></li>
                        <li><a href="/activity/list?page=${pagePojo.getPreviousPage()}">上一页</a></li>
                        <li><a href="#">当前第${pagePojo.getCurrentPage()}页</a></li>
                        <li><a href="#">共${pagePojo.countPage}页</a></li>
                        <li><a href="#">总${pagePojo.amount}条数据</a></li>
                        <li><a href="/activity/list?page=${pagePojo.getNextPage()}">下一页</a></li>
                        <li><a href="/activity/list?page=${pagePojo.trailerPage}">尾页</a></li>
                    </ul>
                </tbody>

            </table>
        </div>

    </div><!-- ./smart-widget-inner -->

</div><!-- ./smart-widget -->
<form role="form" enctype="multipart/form-data" id="form1">
    <div class="modal fade" id="myModal">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"><span class="sr-only">Close</span></button>
                    <h4 class="modal-title">添加活动</h4>
                </div>

                <div class="modal-body">
                    <div class="form-group">
                        <label for="exampleInputEmail1">活动名称</label>
                        <input type="text" class="form-control" id="text1" name="title">
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">活动简介</label>
                        <input type="text" class="form-control" id="text2" name="detail">
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">当前报名人数</label>
                        <input type="text" class="form-control" id="text2" name="numberOfPeople">
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">活动价格</label>
                        <input type="text" class="form-control" id="text3" name="price">
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">最少人数</label>
                        <input type="text" class="form-control" id="text6" name="lowerLimit">
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">最多人数</label>
                        <input type="text" class="form-control" id="text7" name="upperLimit">
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">活动开始时间</label>
                        <input type="date" class="form-control" id="text4" name="startime">
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">活动结束时间</label>
                        <input type="date" class="form-control" id="text5" name="endtime">
                    </div>
                    <label for="exampleInputEmail1">活动图片</label>
                    <div class="bus-upload text-center form-auto">
                        <img width="360" src="http://temp.im/360x120/FF9500/000" alt="">
                        <input name="image" type="hidden" value="">
                    </div>


                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="button" class="btn btn-primary" id="add" onclick="operate()">提交</button>
                </div>

            </div><!-- /.modal-content -->
        </div><!-- /.modal-dialog -->
    </div><!-- /.modal -->
</form>


<div class="modal fade" id="myModal2">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span class="sr-only">Close</span></button>
                <h4 class="modal-title">修改活动</h4>
            </div>

            <form role="form" enctype="multipart/form-data" id="form2">
                <div class="modal-body">
                    <input type="hidden" name="id" id="updateid">
                    <div class="form-group">
                        <label for="exampleInputEmail1">活动名称</label>
                        <input type="text" class="form-control" id="text1" name="title">
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">活动简介</label>
                        <input type="text" class="form-control" id="text2" name="detail">
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">当前报名人数</label>
                        <input type="text" class="form-control" id="text2" name="numberOfPeople">
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">活动价格</label>
                        <input type="text" class="form-control" id="text3" name="price">
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">最少人数</label>
                        <input type="text" class="form-control" id="text6" name="lowerLimit">
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">最多人数</label>
                        <input type="text" class="form-control" id="text7" name="upperLimit">
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">活动开始时间</label>
                        <input type="date" class="form-control" id="text4" name="startime">
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">活动结束时间</label>
                        <input type="date" class="form-control" id="text5" name="endtime">
                    </div>
                    <label for="exampleInputEmail1">活动图片</label>
                    <div class="bus-upload text-center form-auto">
                        <img width="360" src="http://temp.im/360x120/FF9500/000" alt="" id="img">
                        <input name="image" type="hidden" value="">
                    </div>

                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="button" class="btn btn-primary" id="update" onclick="operate()">提交</button>
                </div>
            </form>

        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

</@layoutBody>

<@layoutFooter>
<script>
    $(function () {//全选
        $('.inbox-check').click(function () {
            var activeRow = $(this).parent().parent().parent();

            activeRow.toggleClass('active');
        });


        $('#inboxCollapse').click(function () {
            $('.inbox-menu-inner').slideToggle();
        });

        $('#chkAll').click(function () {
            if ($(this).prop('checked')) {
                $('.inbox-check').prop('checked', true);
                $('.inbox-check').parent().parent().parent().addClass('active');
            }
            else {
                $('.inbox-check').prop('checked', false);
                $('.inbox-check').parent().parent().parent().removeClass('active');
            }
        });

        $(window).resize(function () {
            if (Modernizr.mq('(min-width: 980px)')) {
                $('.inbox-menu ul').show();
            }
        });
    });
</script>
<!-- Parsley -->
<script type="text/javascript">
    function mulit_del(node) {// 全选
        //判断至少写了一项
        var ids = new Array();
        var object = event.srcElement;
        if (object.id == "button1") {
            var chk_value = [];
            $('input[name="choose"]:checked').each(function () {  //获取选中状态
                chk_value.push($(this).val());
            });
            var obj = document.getElementsByName("choose");

            if (chk_value.length == 0) {
                alert("请至少选择一项!");
                return ;
            } else if (confirm("确定删除所选项目?")) {
                for (var i in obj) {
                    if (obj[i].checked) {
                        ids.push(obj[i].value)
                    }
                }
                console.log(ids)
            }else{
                return ;
            }
        } else if (object.id == "button2") {
            var tr1 = node.parentNode.parentNode;
            if (confirm("确定删除所选项目?")) {
                ids.push(tr1.cells[1].innerText);
            }
            return ;
        }
        $.ajax({
            url: "/activity/del",
            data: JSON.stringify({"ids": ids}),
            type: "DELETE",
            dataType: "json",
            contentType: "application/json;charset=utf-8",
            success: function (data) {
                if (data.result == "success") {
                    alert("删除成功!");
                    window.location.reload();
                }
                if (data.result == "failure") {
                    alert(data.content)
                }
            }
        })
    }


</script>
<script type="text/javascript">//上传图片
var Bus = ((function () {
    function Bus() {
        this.upload()
    }

    Bus.prototype.upload = function () {
        var self = this
        $(".bus-upload").each(function (i, v) {
            $(v).children("img").click(function (e) {
                var img = this
                var file = $("<input type='file' accept='image/gif,image/png,image/jpeg'/>");
                file.click().change(function (e) {
                    self.sendFile(
                            file[0].files[0],
                            function (data) {
                                //回调
                                var json = JSON.parse(data);
                                img.src = "/upload/" + json.content;
                                $(v).children("input:hidden").val(json.content)
                                console.log(img.src)
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
            })
        })
    }
    /**
     * 上传文件
     * @param file 文件
     * @param process 进度回调
     * @param callback 回调函数
     * @param error 错误回调
     */
    Bus.prototype.sendFile = function (file, callback, error, process) {
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
    return Bus;
})());
window.bus = new Bus();
</script>
<script>
    function operate() {
        var d = {};
        var url = "";
        if(event.srcElement.id=="add"){
            url="/activity/addactivity";
            var t = $('#form1').serializeArray();
            $.each(t, function () {
                console.log("aaa");
                d[this.name] = this.value;
            });
        }else if(event.srcElement.id=="update"){
            url="/activity/updateactivity";
            var t = $('#form2').serializeArray();
            console.log("bbb");
            $.each(t, function () {
                d[this.name] = this.value;
            });
        };
        $.ajax({
            url: url,
            data: JSON.stringify(d),
            type: "POST",
            dataType: "json",
            contentType: "application/json;charset=UTF-8",
            success: function (data) {
                    alert(data.content);
            },
            failure:function (data) {
                alert(data.content)
            }
        });

    }
</script>
<script>
    function getContent(node) {
        var tr1 = node.parentNode.parentNode;
        var id = tr1.cells[1].innerText;
        console.log(id)
        $.ajax({
            url: "/activity/detail?id="+id,
            type: "GET",
            contentType: "application/json;charset=UTF-8",
             success:function (data) {
               console.log(data)
                if (data != null) {
                    var img = document.getElementById("img");
                    $("[name=id]").val(data.id);
                   $("[name=title]").val(data.title);
                    $("[name=detail]").val(data.detail);
                    $("[name=lowerLimit]").val(data.lower_limit);
                    $("[name=upperLimit]").val(data.upper_limit);
                    $("[name=price]").val(data.price);
                    var date=new Date(data.start_time);
                    var year=date.getFullYear();
                    var mouth=date.getMonth()+1;
                    var day=date.getDate();
                    if(mouth<10){
                        mouth="0"+mouth;
                    }
                    if(day<10){
                        day="0"+day;
                    }
                    var startime = year+"-"+mouth+"-"+day;
                    var date2=new Date(data.end_time);
                    var year2=date2.getFullYear();
                    var mouth2=date2.getMonth()+1;
                    var day2=date2.getDate();
                    if(mouth2<10){
                        mouth2="0"+mouth2;
                    }
                    if(day2<10){
                        day2="0"+day2;
                    }
                    var endtime=year2+"-"+mouth2+"-"+day2;
                    $("[name=startime]").val(startime);
                    $("[name=endtime]").val(endtime);
                    $("[name=numberOfPeople]").val(data.number_of_people);
                    $("[name=image]").val(data.img);
                    img.src="/upload/"+data.img;

                }
           },
            error:function (data) {
                console.log(data)
            }
        })
    }
</script>
</@layoutFooter>