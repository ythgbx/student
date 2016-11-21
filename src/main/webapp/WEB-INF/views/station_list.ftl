<#include "common/_layout.ftl">
<@layoutHead title="网站">
</@layoutHead>
<@layoutBody>
<!-- 这是nested的内容-->
<ul class="breadcrumb">
    <li><span class="primary-font"><i class="icon-home"></i></span><a href="#">首页</a></li>
    <li>管理中心</li>
    <li>站点管理</li>
</ul>
<div class="smart-widget">
    <div class="smart-widget-header">
        站点管理
        <button class="btn btn-success smart-widget-option" data-toggle="modal" data-target="#add">
            添加站点
        </button>
        &nbsp;&nbsp;
        <button onclick="bus.del(this)" id="del" class="button border-red"><span class="icon-trash-o"></span> 批量删除
        </button>
    </div>
    <div class="smart-widget-inner">
        <div class="smart-widget-body">
            <table class="table table-hover">
                <thead>
                <tr class="active">
                    <th class="text-center">
                        <div class="custom-checkbox">
                            <input type="checkbox" id="chkAll" class="inbox-check">
                            <label for="chkAll"></label>
                        </div>
                    </th>
                    <#--<th>序号</th>-->
                    <th>站点ID</th>
                    <th>站点名称</th>
                    <th>站点经度</th>
                    <th>站点纬度</th>
                    <th>站点说明</th>
                    <th>站点价格</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                    <#list stationList.stations as station>
                    <tr class="active">
                        <td class="text-center">
                            <div class="custom-checkbox">
                                <input type="checkbox" name="choose" id="chk${station.id}" class="inbox-check"
                                       value="${station.id}">
                                <label for="chk${station.id}"></label>
                            </div>
                        </td>
                        <#--<td>${station_index+1}</td>-->
                        <td>${station.id}</td>
                        <td>${station.name}</td>
                        <td>${station.pos.lng}</td>
                        <td>${station.pos.lat}</td>
                        <td>${station.annotation}</td>
                        <td>${station.price}</td>
                        <td>
                            <a onclick="bus.getStationBuyId(this)" data-toggle="modal" data-target="#update"><i
                                    class="fa fa-bars"></i></a>
                            <a onclick="bus.del(this)" id="delSingle"><i class="fa fa-times"></i></a>
                        </td>
                    </tr>
                    </#list>
                </tbody>
                <tbody>
                <tr>
                    <ul class="pagination">
                        <li><a href="/station/listAll?page=${pagePojo.homePage}">首页</a></li>
                        <li><a href="/station/listAll?page=${pagePojo.getPreviousPage()}">上一页</a></li>
                        <li><a href="#">当前第${pagePojo.getCurrentPage()}页</a></li>
                        <li><a href="#">共${pagePojo.countPage}页</a></li>
                        <li><a href="#">总${pagePojo.amount}条数据</a></li>
                        <li><a href="/station/listAll?page=${pagePojo.getNextPage()}">下一页</a></li>
                        <li><a href="/station/listAll?page=${pagePojo.trailerPage}">尾页</a></li>
                    </ul>
                </tr>
                </tbody>
            </table>
        </div>
    </div><!-- ./smart-widget-inner -->
</div><!-- ./smart-widget -->

<!-- 模态框（Modal） 添加-->
<div class="modal fade" id="add" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <form id="formAdd" enctype="multipart/form-data" method="post">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    <#--&times;-->
                    </button>
                    <h4 class="modal-title" id="myModalLabel">
                        添加站点
                    </h4>
                </div>
                <div class="modal-body">

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
                    <button onclick="bus.update(this)" id="add" type="button" class="btn btn-primary">提交</button>
                </div>
            </form>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>

<!-- 模态框（Modal） 添加-->
<div class="modal fade" id="update" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <form id="formUpdate" enctype="multipart/form-data" method="post">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    <#--&times;-->
                    </button>
                    <h4 class="modal-title" id="myModalLabel">
                        修改站点
                    </h4>
                </div>
                <div class="modal-body">
                    <input type="hidden" name="id">
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
                    <button onclick="bus.update(this)" id="update" type="button" class="btn btn-primary">提交</button>
                </div>
            </form>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>

</@layoutBody>

<@layoutFooter>
<script type="text/javascript">
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
<script type="text/javascript">
    var Bus = ((function () {
        function Bus() {

        }

        Bus.prototype.del = function (node) {//删除
            var ids = new Array();
            var obj = $(":checked");
            var object = event.srcElement;
            if (object.className == "button border-red") {
                var chk_value = [];
                $('input[name="choose"]:checked').each(function () {  //获取选中状态
                    chk_value.push($(this).val());
                });
                if (chk_value.length == 0) {
                    alert("请至少选择一项!");
                    return;
                } else if (confirm("确定删除所选项目?")) {
                    for (var i in obj) {
                        if (obj[i].checked) {
                            ids.push(obj[i].value)
                        }
                    }
                } else {
                    return;
                }

            } else if (object.className == "fa fa-times") {
                var tr1 = node.parentNode.parentNode;
                if (confirm("确定删除所选项目?")) {
                    ids.push(tr1.cells[1].innerText);
                } else {
                    return;
                }
            }
            $.ajax({
                url: "/station/del",
                data: JSON.stringify({"ids": ids}),
                type: "DELETE",
                dataType: "json",
                contentType: "application/json;charset=utf-8",
                success: function (data) {
                    if (data.result == "success") {
                        alert(data.content);
                        window.location.reload();
                    }
                    if (data.result == "failure") {
                        alert(data.content)
                    }
                }
            })
        };

        Bus.prototype.getStationBuyId = function (node) {//通过ID获取站点详情
            var tr1 = node.parentNode.parentNode;//获取id
            var id = tr1.cells[1].innerText;
            $.ajax({
                url: "/station/detail?id=" + id,
                type: "GET",
                contentType: "application/json;charset=utf-8",
                success: function (data) {
                    if (data != null || data != "") {
                        $("[name=id]").val(data.id);
                        $("[name=name]").val(data.name);
                        $("[name=lng]").val(data.pos.lng);
                        $("[name=lat]").val(data.pos.lat);
                        $("[name=annotation]").val(data.annotation);
                        $("[name=price]").val(data.price);
                    } else {
                        alert("数据获取失败!");
                    }

                }
            })

        };

        Bus.prototype.update = function () {
            var d = {};
            var url = "";
            if (event.srcElement.id == "add") {
                url = "/station/add";
                var t = $('#formAdd').serializeArray();
                $.each(t, function () {
                    d[this.name] = this.value;
                });
            } else if (event.srcElement.id == "update") {
                url = "/station/update";
                var t = $('#formUpdate').serializeArray();
                $.each(t, function () {
                    d[this.name] = this.value;
                });
            }
            $.ajax({
                url: url,
                data: JSON.stringify(d),
                type: "POST",
                dataType: "json",
                contentType: "application/json;charset=UTF-8",
                success: function (data) {
                    if (data.result == "success") {
                        alert(data.content);
                    }
                    if (data.result == "failure") {
                        alert(data.content);
                    }
                },
                error: function (data) {
                }
            });
            window.location.reload();
        };


        return Bus;
    })());
    window.bus = new Bus();
</script>
</@layoutFooter>


