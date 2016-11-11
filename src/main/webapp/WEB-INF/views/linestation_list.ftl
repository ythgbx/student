<#include "common/_layout.ftl">
<@layoutHead title="网站"></@layoutHead>

<@layoutBody>
<!-- 这是nested的内容-->

<ul class="breadcrumb">
    <li><span class="primary-font"><i class="icon-home"></i></span><a href="index.html"> Home</a></li>
    <li>Table</li>
    <li>Static Table</li>
</ul>

<div class="smart-widget clearfix">
    <div class="smart-widget-header ">
        线路列表
        <button type="button" onclick="mulit_del()" class="button border-red" id="button1"><span class="icon-trash-o"></span> 批量删除
        </button>
        <button class="btn btn-success  smart-widget-option" data-toggle="modal" data-target="#myModal1">添加站点
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
                    <th>站点ID</th>
                    <th>线路名称</th>
                    <th>起始纬度</th>
                    <th>结束经度</th>
                    <th>站点注释</th>
                    <th>价格</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                    <#list linestation as oneLine>
                    <tr class="active">
                        <td class="text-center">
                            <div class="custom-checkbox">
                                <input type="checkbox" id="chk${oneLine.id}" name="choose" class="inbox-check"
                                       value="${oneLine.id}">
                                <label for="chk${oneLine.id}"></label>
                            </div>
                        </td>
                        <td>${oneLine.id}</td>
                        <td>${oneLine.name}</td>
                        <td >${oneLine.lat}</td>
                        <td>${oneLine.lng}</td>
                        <td>${oneLine.annotation}</td>
                        <td>${oneLine.price}</td>
                        <td>
                            <a href=""
                               data-toggle="modal"
                               data-target="#myModal2"
                               onclick="getContent(this)"
                            >
                                <i class="fa fa-bars"></i>
                            </a>      <!--修改站点 -->
                            <a href=""
                               onclick="mulit_del(this)"
                            >
                                <i class="fa fa-times" id="button2"></i>
                            </a>
                            <a href="/line/detail_list?id=${oneLine.id}">
                                <i class="fa fa-bookmark"></i>
                            </a>
                        </td><!--删除线路 -->
                    </tr>
                    </#list>

                </tbody>

            </table>
            <ul class="pagination">
                <li><a href="/activity/list?page=${pagePojo.homePage}">首页</a></li>
                <li><a href="/activity/list?page=${pagePojo.getPreviousPage()}">上一页</a></li>
                <li><a href="#">当前第${pagePojo.getCurrentPage()+1}页</a></li>
                <li><a href="#">共${pagePojo.countPage}页</a></li>
                <li><a href="#">总${pagePojo.amount}条数据</a></li>
                <li><a href="/activity/list?page=${pagePojo.getNextPage()}">下一页</a></li>
                <li><a href="/activity/list?page=${pagePojo.trailerPage-1}">尾页</a></li>
            </ul>
        </div>

    </div><!-- ./smart-widget-inner -->

</div><!-- ./smart-widget -->

<!-- 模态框（Modal） 添加-->
<div class="modal fade" id="myModal1" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <form id="form1" enctype="multipart/form-data" >
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    <#--&times;-->
                    </button>
                    <h4 class="modal-title" id="myModalLabel">
                        添加站点
                    </h4>
                </div>
                <div class="modal-body">
                     <input type="hidden" name="lineid" value="${id}">
                    <label for="exampleInputEmail1">站点名称</label>
                    <input type="text" class="form-control" id="exampleInputEmail1" name="name"
                           placeholder="请输入站点名称">

                    <label for="exampleInputEmail1">站点经度</label>
                    <input type="text" class="form-control" id="exampleInputEmail1" name="lng"
                           placeholder="请输入该站点所在经度">

                    <label for="exampleInputEmail1">站点维度</label>
                    <input type="text" class="form-control" id="exampleInputEmail1" name="lat"
                           placeholder="请输入该站点所在纬度">

                    <label for="exampleInputEmail1">站点说明</label>
                    <input type="text" class="form-control" id="exampleInputEmail1" name="annotation"
                           placeholder="请对该站点备注说明">
                    <label for="exampleInputEmail1">站点价格</label>
                    <input type="text" class="form-control" id="exampleInputEmail1" name="price"
                           placeholder="请对该站点设置价格">
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button onclick="operate()" id="add" type="button" class="btn btn-primary">提交</button>
                </div>
            </form>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>


<div class="modal fade" id="myModal2">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span class="sr-only">Close</span></button>
                <h4 class="modal-title">修改线路</h4>
            </div>

            <form role="form" enctype="multipart/form-data" id="form2">
                <div class="modal-body">
                    <input type="hidden" name="id" id="updateid">
                    <div class="form-group">
                        <label for="exampleInputEmail1">线路名称</label>
                        <input type="text" class="form-control" id="text1" name="name">
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">起始站点</label>
                        <input type="text" class="form-control" id="text2" name="start">
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">结束站点</label>
                        <input type="text" class="form-control" id="text2" name="end">
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">站点经纬度</label>
                        <input type="text" class="form-control" id="text2" name="latlng" value="">
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">票价</label>
                        <input type="text" class="form-control" id="text3" name="price">
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">站点注释</label>
                        <input type="text" class="form-control" id="text6" name="annotation">
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">所在城市</label>
                        <input type="text" class="form-control" id="text7" name="cityName">
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">专线属性</label>
                        <input type="text" class="form-control" id="text4" name="propName" value="">
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">起始时间</label>
                        <input type="date" class="form-control" id="text5" name="startTime">
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">结束时间</label>
                        <input type="date" class="form-control" id="text5" name="endTime">
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
            console.log(obj)
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
            url: "/line/del",
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
<script>
    function operate() {
        var d = {};
        var url = "";
        if(event.srcElement.id=="add"){
            url="/station/add";
            var t = $('#form1').serializeArray();
            $.each(t, function () {
                console.log("aaa");
                d[this.name] = this.value;
            });
        }else if(event.srcElement.id=="update"){
            url="/line/updateline";
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
        window.location.reload();
    }
</script>
<script>
    function getContent(node) {
        var tr1 = node.parentNode.parentNode;
        var id = tr1.cells[1].innerText;
        console.log(id)
        $.ajax({
            url: "/line/linedetail?id="+id,
            type: "GET",
            contentType: "application/json;charset=UTF-8",
            success:function (data) {
                console.log(data)
                if (data != null) {
                    $("[name=id]").val(data.id);
                    $("[name=name]").val(data.name);
                    $("[name=start]").val(data.start_station);
                    $("[name=end]").val(data.end_station);
                    $("[name=price]").val(data.price);
                    $("[name=annotation]").val(data.annotation);
                    $("[name=cityName]").val(data.cityName);
                    $("[name=propName]").val(data.propName);
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
                    $("[name=startTime]").val(startime);
                    $("[name=endTime]").val(endtime);


                }
            },
            error:function (data) {
                console.log(data)
            }
        })
    }
</script>

</@layoutFooter>