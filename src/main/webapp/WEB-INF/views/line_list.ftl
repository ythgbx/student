<#include "common/_layout.ftl">
<@layoutHead title="网站"></@layoutHead>

<@layoutBody>
<!-- 这是nested的内容-->

<ul class="breadcrumb">
    <li><span class="primary-font"><i class="icon-home"></i></span><a href="#">首页</a></li>
    <li>管理中心</li>
    <li>线路管理</li>
</ul>

<div class="smart-widget clearfix">
    <div class="smart-widget-header ">
        线路列表
        <button type="button" onclick="mulit_del()" class="button border-red" id="button1"><span
                class="icon-trash-o"></span> 批量删除
        </button>
        <button class="btn btn-success  smart-widget-option" data-toggle="modal" data-target="#myModal">添加线路
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
                    <th>线路ID</th>
                    <th>线路名称</th>
                    <th>起始站点</th>
                    <th>结束站点</th>
                    <th>票价</th>
                    <th>站点注释</th>
                    <th>所在城市</th>
                    <th>专线属性</th>
                    <th>起始时间</th>
                    <th>结束时间</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                    <#list lineList as oneLine>
                    <tr class="active">
                        <td class="text-center">
                            <div class="custom-checkbox">
                                <input type="checkbox" id="chk${oneLine.id}" name="choose" class="inbox-check"
                                       value="${oneLine.id}">
                                <label for="chk${oneLine.id}"></label>
                            </div>
                        </td>
                        <#--<td>${oneLine_index+1}</td>-->
                        <td>${oneLine.id}</td>
                        <td>${oneLine.name}</td>
                        <td>${oneLine.start}</td>
                        <td>${oneLine.end}</td>
                        <td>${oneLine.price}</td>
                        <td>${oneLine.annotation}</td>
                        <td>${oneLine.cityName}</td>
                        <td>${oneLine.propName}</td>
                        <td>${oneLine.startTime?string('yyyy.MM.dd HH:mm:ss')}</td>
                        <td>${oneLine.endTime?string('yyyy.MM.dd HH:mm:ss')}</td>
                        <td>
                            <a href=""
                               data-toggle="modal"
                               data-target="#myModal2"
                               onclick="getContent(this)"
                            >
                                <i class="fa fa-bars"></i>
                            </a>      <!--修改线路 -->
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
                <tbody>
                <ul class="pagination">
                    <li><a href="/line/list?page=${pagePojo.homePage}">首页</a></li>
                    <li><a href="/line/list?page=${pagePojo.getPreviousPage()}">上一页</a></li>
                    <li><a href="#">当前第${pagePojo.getCurrentPage()}页</a></li>
                    <li><a href="#">共${pagePojo.countPage}页</a></li>
                    <li><a href="#">总${pagePojo.amount}条数据</a></li>
                    <li><a href="/line/list?page=${pagePojo.getNextPage()}">下一页</a></li>
                    <li><a href="/line/list?page=${pagePojo.trailerPage}">尾页</a></li>
                </ul>

                <ul class="nav-notification  inline-block pull-right">
                    <li class="search-list">
                        <div class="search-input-wrapper">
                            <div class="search-input">
                                <input type="text" class="form-control input-sm inline-block" id="search_input" >
                                <a href="/line/list?lineName" id="search_submit" class="input-icon text-normal"><i class="ion-ios7-search-strong"></i></a>
                            </div>
                        </div>
                    </li>
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
                    <h4 class="modal-title">添加线路</h4>
                </div>

                <div class="modal-body">
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
                        <input type="text" class="form-control" id="text4" name="propName">
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
                return;
            } else if (confirm("确定删除所选项目?")) {
                for (var i in obj) {
                    if (obj[i].checked) {
                        ids.push(obj[i].value)
                    }
                }
                console.log(ids)
            } else {
                return;
            }
        } else if (object.id == "button2") {
            var tr1 = node.parentNode.parentNode;
            if (confirm("确定删除所选项目?")) {
                ids.push(tr1.cells[1].innerText);
            }
            return;
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
        if (event.srcElement.id == "add") {
            url = "/line/addline";
            var t = $('#form1').serializeArray();
            $.each(t, function () {
                console.log("aaa");
                d[this.name] = this.value;
            });
        } else if (event.srcElement.id == "update") {
            url = "/line/updateline";
            var t = $('#form2').serializeArray();
            console.log("bbb");
            $.each(t, function () {
                d[this.name] = this.value;
            });
        }
        ;
        $.ajax({
            url: url,
            data: JSON.stringify(d),
            type: "POST",
            dataType: "json",
            contentType: "application/json;charset=UTF-8",
            success: function (data) {
                alert(data.content);
            },
            failure: function (data) {
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
            url: "/line/linedetail?id=" + id,
            type: "GET",
            contentType: "application/json;charset=UTF-8",
            success: function (data) {
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
                    var date = new Date(data.start_time);
                    var year = date.getFullYear();
                    var mouth = date.getMonth() + 1;
                    var day = date.getDate();
                    if (mouth < 10) {
                        mouth = "0" + mouth;
                    }
                    if (day < 10) {
                        day = "0" + day;
                    }
                    var startime = year + "-" + mouth + "-" + day;
                    var date2 = new Date(data.end_time);
                    var year2 = date2.getFullYear();
                    var mouth2 = date2.getMonth() + 1;
                    var day2 = date2.getDate();
                    if (mouth2 < 10) {
                        mouth2 = "0" + mouth2;
                    }
                    if (day2 < 10) {
                        day2 = "0" + day2;
                    }
                    var endtime = year2 + "-" + mouth2 + "-" + day2;
                    $("[name=startTime]").val(startime);
                    $("[name=endTime]").val(endtime);


                }
            },
            error: function (data) {
                console.log(data)
            }
        })
    }
</script>
<script type="text/javascript">
    $("#search_submit").click(function () {
        var d=$("#search_input").val();
        console.log(d)
        $.ajax({
            url: "/line/list?lineName="+d,
            type: "GET",
            contentType: "application/json;charset=UTF-8",
            success: function (data) {
               window.location.href="/line/list?lineName="+d
            },
            failure: function (data) {
                alert(data.content)
            }
        });
    })
</script>

</@layoutFooter>