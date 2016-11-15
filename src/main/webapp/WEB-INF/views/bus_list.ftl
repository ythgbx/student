<#include "common/_layout.ftl">
<@layoutHead title="网站">
</@layoutHead>
<@layoutBody>
<!-- 这是nested的内容-->
<ul class="breadcrumb">
    <li><span class="primary-font"><i class="icon-home"></i></span><a href="index.html"> Home</a></li>
    <li>Table</li>
    <li>Static Table</li>
</ul>
<div class="smart-widget">
    <div class="smart-widget-header">
        车辆管理
        <button class="btn btn-success smart-widget-option" data-toggle="modal" data-target="#add">
            添加车辆
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
                    <th>汽车ID</th>
                    <th>车牌号</th>
                    <th>线路</th>
                    <th>司机ID</th>
                    <th>设备编号</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                    <#list busList as bus>
                    <tr class="active">
                        <td class="text-center">
                            <div class="custom-checkbox">
                                <input type="checkbox" name="choose" id="chk${bus.id}" class="inbox-check"
                                       value="${bus.id}">
                                <label for="chk${bus.id}"></label>
                            </div>
                        </td>
                        <td>${bus.id}</td>
                        <td>${bus.name}</td>
                        <td>${bus.lineId}</td>
                        <td>${bus.userId}</td>
                        <td>${bus.device}</td>
                        <td>
                            <a onclick="bus.getBusBuyId(this)" data-toggle="modal" data-target="#update"><i
                                    class="fa fa-bars"></i></a>
                            <a onclick="bus.del(this)" id="delSingle"><i class="fa fa-times"></i></a>
                        </td>
                    </tr>
                    </#list>
                </tbody>
                <tbody>
                <tr>
                    <ul class="pagination">
                        <li><a href="/bus/list?page=${pagePojo.homePage}">首页</a></li>
                        <li><a href="/bus/list?page=${pagePojo.getPreviousPage()}">上一页</a></li>
                        <li><a href="#">当前第${pagePojo.getCurrentPage()+1}页</a></li>
                        <li><a href="#">共${pagePojo.countPage}页</a></li>
                        <li><a href="#">总${pagePojo.amount}条数据</a></li>
                        <li><a href="/bus/list?page=${pagePojo.getNextPage()}">下一页</a></li>
                        <li><a href="/bus/list?page=${pagePojo.trailerPage-1}">尾页</a></li>
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
                        添加车辆
                    </h4>
                </div>
                <div class="modal-body">

                    <label for="exampleInputEmail1">车牌号</label>
                    <input type="text" class="form-control" id="exampleInputEmail1" name="name"
                           placeholder="请输入该车辆车牌号">

                    <label for="exampleInputEmail1">线路</label>
                    <input type="text" class="form-control" id="exampleInputEmail1" name="line_id"
                           placeholder="请输入该车票行驶路线">

                    <label for="exampleInputEmail1">司机ID</label>
                    <input type="text" class="form-control" id="exampleInputEmail1" name="user_id"
                           placeholder="请输入司机对应ID">

                    <label for="exampleInputEmail1">设备编号</label>
                    <input type="text" class="form-control" id="exampleInputEmail1" name="device"
                           placeholder="请输入该车辆对应的设备编号">
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
                    <label for="exampleInputEmail1">车牌号</label>
                    <input type="text" class="form-control" id="exampleInputEmail1" name="name">

                    <label for="exampleInputEmail1">线路</label>
                    <input type="text" class="form-control" id="exampleInputEmail1" name="line_id">

                    <label for="exampleInputEmail1">司机ID</label>
                    <input type="text" class="form-control" id="exampleInputEmail1" name="user_id">

                    <label for="exampleInputEmail1">设备编号</label>
                    <input type="text" class="form-control" id="exampleInputEmail1" name="device">
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
                    }console.log(ids);
                } else {
                    return;
                }

            } else if (object.className == "fa fa-times") {
                var tr1 = node.parentNode.parentNode;
                if (confirm("确定删除所选项目?")) {
                    ids.push(tr1.cells[1].innerText);
                    console.log(ids);
                } else {
                    return;
                }
            }
            $.ajax({
                url: "/bus/del",
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

        Bus.prototype.getBusBuyId = function (node) {//通过ID获取站点详情
            var tr1 = node.parentNode.parentNode;//获取id
            var id = tr1.cells[1].innerText;
            $.ajax({
                url: "/bus/detail?id=" + id,
                type: "GET",
                contentType: "application/json;charset=utf-8",
                success: function (data) {
                    if (data != null || data != "") {
                        console.log(data);
                        $("[name=id]").val(data.id);
                        $("[name=name]").val(data.name);
                        $("[name=user_id]").val(data.user_id);
                        $("[name=line_id]").val(data.line_id);
                        $("[name=device]").val(data.device);
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
                url = "/bus/add";
                var t = $('#formAdd').serializeArray();
                $.each(t, function () {
                    d[this.name] = this.value;
                });
            } else if (event.srcElement.id == "update") {
                url = "/bus/update";
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
                        window.location.reload();//刷新
                    }
                    if (data.result == "failure") {
                        alert(data.content);
                        window.location.reload();
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

