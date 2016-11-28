<#include "common/_layout.ftl">
<@layoutHead title="网站"></@layoutHead>

<@layoutBody>
<!-- 这是nested的内容-->

<ul class="breadcrumb">
    <li><span class="primary-font"><i class="icon-home"></i></span><a href="#">首页</a></li>
    <li>管理中心</li>
    <li>用户管理</li>
</ul>
<div class="smart-widget">
    <div class="smart-widget-header">
        用户列表
        <button type="button" onclick="mulit_del()" class="button border-red" id="button1"><span
                class="icon-trash-o"></span> 批量删除
        </button>
        <div class="search-input pull-right">
            <input type="text" class="form-control input-sm inline-block" id="sea">
            <a class="input-icon text-normal" onclick="bus.searchUser()">
                <i class="ion-ios7-search-strong"></i>
            </a>
        </div>
    </div>

    <div class="smart-widget-inner">
        <div class="smart-widget-body">
            <table class="table table-hover">
                <thead>
                <tr class="active">
                    <#--<th class="text-center">-->
                        <#--<div class="custom-checkbox">-->
                            <#--<input type="checkbox" id="chkAll" class="inbox-check">-->
                            <#--<label for="chkAll"></label>-->
                        <#--</div>-->
                    <#--</th>-->
                    <#--<th>序号</th>-->
                    <th class="text-center">
                        <div class="custom-checkbox">
                            <input class="inbox-check" id="chkAll" type="checkbox">
                            <label for="chkAll"></label>
                        </div>
                    </th>
                    <th>用户ID</th>
                    <#--<th>姓名</th>-->
                    <th>账号</th>
                    <th>积分</th>
                    <th>用户类型</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                    <#list userList as oneUser>
                    <tr class="active">
                        <#--<td class="text-center">-->
                            <#--<div class="custom-checkbox">-->
                                <#--<input type="checkbox" name="choose" id="chk${oneUser.id}" class="inbox-check" value="${oneUser.id}">-->
                                <#--<label for="chk${oneUser.id}"></label>-->
                            <#--</div>-->
                        <#--</td>-->
                        <#--<td>${oneUser_index+1}</td>-->
                        <td class="text-center">
                            <div class="custom-checkbox">
                                <input type="checkbox" id="chk${oneUser.id}" name="choose" class="inbox-check"
                                       value="${oneUser.id}">
                                <label for="chk${oneUser.id}"></label>
                            </div>
                        </td>
                        <td>${oneUser.id}</td>
                        <#--<td>${oneUser.name}</td>-->
                        <td>${oneUser.phone}</td>
                        <td>${oneUser.points}</td>
                        <#if oneUser.type==1>
                            <td>管理员</td>
                        <#else>
                            <td>用户</td>
                        </#if>
                        <td><input type="button" data-toggle="modal" data-target="#Recharge" id="" value="充值" onclick="bus.getUserBuyId(this)"/></td>
                    </tr>
                    </#list>
                </tbody>
                <tbody>
                <tr>
                    <ul class="pagination">
                        <li><a href="/user/list?page=${pagePojo.homePage}">首页</a></li>
                        <li><a href="/user/list?page=${pagePojo.getPreviousPage()}">上一页</a></li>
                        <li><a href="#">当前第${pagePojo.getCurrentPage()}页</a></li>
                        <li><a href="#">共${pagePojo.countPage}页</a></li>
                        <li><a href="#">总${pagePojo.amount}条数据</a></li>
                        <li><a href="/user/list?page=${pagePojo.getNextPage()}">下一页</a></li>
                        <li><a href="/user/list?page=${pagePojo.trailerPage}">尾页</a></li>
                    </ul>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>

<!-- 模态框（Modal） 充值-->
<div class="modal fade" id="Recharge" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <form id="fromRecharge"  enctype="multipart/form-data" method="post">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    <#--&times;-->
                    </button>
                    <h4 class="modal-title" id="myModalLabel">
                        积分充值
                    </h4>
                </div>
                <div class="modal-body">

                    <label for="exampleInputEmail1">确认充值账号</label>
                    <input type="text" class="form-control" id="exampleInputEmail1" name="phone">
                    <label for="exampleInputEmail1">充值额度</label>
                    <input type="text" class="form-control" id="exampleInputEmail1" name="addNum"
                           placeholder="请输入充值积分">

                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button onclick="bus.addPoint()" type="button" class="btn btn-primary">充值</button>
                </div>
            </form>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>

</@layoutBody>

<@layoutFooter>
<script type="text/javascript">
    var Bus = ((function () {
        function Bus() {
        }

        Bus.prototype.searchUser = function () {
            var phone = document.getElementById("sea").value;
            if(!(/^1[34578]\d{9}$/.test(phone))){
                alert("手机号码有误，请重填");
                return false;
            }else {
                window.location.href="/user/find?phone="+phone;
            }
//            console.log(phone);
//            $.ajax({
//                url: "/user/find?phone="+phone,
//                type: "GET",
//                dataType: "json",
//                contentType: "application/json;charset=UTF-8",
//                success: function (data) {
//                    if (data.result == "success") {
////
//                    }
//                    if (data.result == "error") {
//                        console.log("error");
//                        alert(data.content);
//                    }
//                },
//                error: function (data) {
//                }
//            });
        };

        Bus.prototype.getUserBuyId = function (node) {//通过ID获取商品详情
            var tr1 = node.parentNode.parentNode;//获取id
            var phone=tr1.cells[3].innerText;
            $("[name=phone]").val(phone);

        };

        Bus.prototype.addPoint = function () {
            var d = {};
            var t = $('#fromRecharge').serializeArray();
            $.each(t, function () {
                d[this.name] = this.value;
            });
            console.log(d);
            $.ajax({
                url: "/user/recharge/point",
                data: JSON.stringify(d),
                type: "POST",
                dataType: "json",
                contentType: "application/json;charset=UTF-8",
                success: function (data) {
                    if (data.result == "success") {
                        console.log("充值成功!")
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
            url: "/user/del",
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
</@layoutFooter>