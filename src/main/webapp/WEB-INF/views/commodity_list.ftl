<#include "common/_layout.ftl">
<@layoutHead title="网站">
</@layoutHead>


<@layoutBody>
<!-- 这是nested的内容-->


<ul class="breadcrumb">
    <li><span class="primary-font"><i class="icon-home"></i></span><a href="#">首页</a></li>
    <li>管理中心</li>
    <li>商品管理</li>
</ul>
<div class="smart-widget clearfix">
    <div class="smart-widget-header">
        商品管理

        <#--<button class="btn btn-success smart-widget-option" data-toggle="modal" data-target="#add">-->
            <#--添加商品类型-->
        <#--</button>-->
        <button class="btn btn-success smart-widget-option" data-toggle="modal" data-target="#add">
            添加商品
        </button>
        &nbsp;&nbsp;
        <button onclick="bus.del(this)" id="del" class="button border-red"><span class="icon-trash-o"></span> 批量删除
        </button>
    <#--<button class="btn btn-success btn-xs smart-widget-option" data-toggle="modal" data-target="#sakura" >修改</button>-->
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
                    <th>商品ID</th>
                    <th>商品名称</th>
                    <th>商品类型</th>
                    <th>商品价格</th>
                    <th>商品数量</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                    <#list commodityLists as Commodity>
                    <tr class="active">
                        <td class="text-center">
                            <div class="custom-checkbox">
                                <input type="checkbox" name="choose" id="chk${Commodity.id}" class="inbox-check"
                                       value="${Commodity.id}">
                                <label for="chk${Commodity.id}"></label>
                            </div>
                        </td>
                        <#--<td>${Commodity_index+1}</td>-->
                        <td>${Commodity.id}</td>
                        <td>${Commodity.name}</td>
                        <#if Commodity.typeId==1>
                            <td>积分</td>
                        <#else>
                            <td>优惠卡</td>
                        </#if>
                        <td>${Commodity.price}</td>
                        <td>${Commodity.amount}</td>
                        <td>
                            <a onclick="bus.getCommodityBuyId(this)" data-toggle="modal" data-target="#update"><i
                                    class="fa fa-bars"></i></a>
                            <a onclick="bus.del(this)" id="delSingle"><i class="fa fa-times"></i></a>
                        </td>
                    </tr>
                    </#list>
                </tbody>
                <tbody>
                <tr>
                    <ul class="pagination">
                        <li><a href="/commodity/list?page=${pagePojo.homePage}">首页</a></li>
                        <li><a href="/commodity/list?page=${pagePojo.previousPage}">上一页</a></li>
                        <li><a href="#">当前第${pagePojo.currentPage}页</a></li>
                        <li><a href="#">共${pagePojo.countPage}页</a></li>
                        <li><a href="#">总${pagePojo.amount}条数据</a></li>
                        <li><a href="/commodity/list?page=${pagePojo.nextPage}">下一页</a></li>
                        <li><a href="/commodity/list?page=${pagePojo.trailerPage}">尾页</a></li>
                    </ul>
                </tr>
                </tbody>
            </table>
        </div>
    </div><!-- ./smart-widget-inner -->
</div><!-- ./smart-widget -->


<!-- 模态框（Modal） 修改-->
<div class="modal fade" id="update" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <form id="formUpdate" enctype="multipart/form-data" method="post">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    <#--&times;-->
                    </button>
                    <h4 class="modal-title" id="myModalLabel">
                        修改商品
                    </h4>
                </div>
                <div class="modal-body">
                    <input type="hidden" id="exampleInputEmail1" name="id">
                    <label for="exampleInputEmail1">商品名称</label>
                    <input type="text" class="form-control" id="exampleInputEmail1" name="name" placeholder="请输入商品名称">
                    <label for="exampleInputEmail1">商品描述</label>
                    <input type="text" class="form-control" id="exampleInputEmail1" name="depict"
                           placeholder="请对该商品进行描述">
                    <label for="exampleInputEmail1">商品价格</label>
                    <input type="text" class="form-control" id="exampleInputEmail1" name="price"
                           placeholder="请输入该商品的价格">
                    <label for="exampleInputEmail1">商品数量</label>
                    <input type="text" class="form-control" id="exampleInputEmail1" name="amount"
                           placeholder="请输入该商品的数量">
                    <label for="exampleInputEmail1">商品备注图片</label>
                    <div class="bus-upload text-center form-auto">
                        <img id="itemImg" width="360" src="http://temp.im/360x120/FF9500/000" alt="">
                        <input name="itemImg" type="hidden" value="">
                    </div>
                    <label for="exampleInputEmail1">商品详情图片</label>
                    <div class="bus-upload text-center form-auto">
                        <img id="img" width="360" src="http://temp.im/360x120/FF9500/000" alt="">
                        <input name="img" type="hidden" value="">
                    </div>
                    <label for="exampleInputEmail1">商品积分</label>
                    <input type="text" class="form-control" id="exampleInputEmail1" name="point"
                           placeholder="请输入该商品对应积分">
                    <label for="exampleInputEmail1">商品类型(年卡或月卡)</label>
                    <input type="text" class="form-control" id="exampleInputEmail1" name="couponType"
                           placeholder="请输入该商品类型">
                    <label for="exampleInputEmail1">商品类型(1:积分 2:优惠卡)</label>
                    <input type="text" class="form-control" id="exampleInputEmail1" name="typeId"
                           placeholder="请输入该商品类型">
                <#--<label for="exampleInputEmail1">商品标记(默认为0)</label>-->
                    <input type="hidden" class="form-control" id="exampleInputEmail1" name="flag" value="0"
                           placeholder="0">
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                    </button>
                    <input onclick="bus.updateCommodity(this)" id="update" type="button" class="btn btn-primary"
                           value="修改"/>
                </div>
            </form>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>


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
                        添加商品
                    </h4>
                </div>
                <div class="modal-body">

                    <label for="exampleInputEmail1">商品名称</label>
                    <input type="text" class="form-control" id="exampleInputEmail1" name="name"
                           placeholder="请输入商品名称">

                    <label for="exampleInputEmail1">商品描述</label>
                    <input type="text" class="form-control" id="exampleInputEmail1" name="depict"
                           placeholder="请对该商品进行描述">

                    <label for="exampleInputEmail1">商品价格</label>
                    <input type="text" class="form-control" id="exampleInputEmail1" name="price"
                           placeholder="请输入该商品的价格">

                    <label for="exampleInputEmail1">商品数量</label>
                    <input type="text" class="form-control" id="exampleInputEmail1" name="amount"
                           placeholder="请输入该商品的数量">

                    <label for="exampleInputEmail1">商品备注图片</label>
                    <div class="bus-upload text-center form-auto">
                        <img width="360" src="http://temp.im/360x120/FF9500/000" alt="">
                        <input name="itemImg" type="hidden" value="">
                    </div>

                    <label for="exampleInputEmail1">商品详情图片</label>
                    <div class="bus-upload text-center form-auto">
                        <img width="360" src="http://temp.im/360x120/FF9500/000" alt="">
                        <input name="img" type="hidden" value="">
                    </div>

                    <label for="exampleInputEmail1">商品积分</label>
                    <input type="text" class="form-control" id="exampleInputEmail1" name="point"
                           placeholder="请输入该商品对应积分">

                    <label for="exampleInputEmail1">商品类型(年卡或月卡)</label>
                    <input type="text" class="form-control" id="exampleInputEmail1" name="couponType"
                           placeholder="请输入该商品类型">

                    <label for="exampleInputEmail1">商品类型(1:积分 2:优惠卡)</label>
                    <input type="text" class="form-control" id="exampleInputEmail1" name="typeId"
                           placeholder="请输入该商品类型">

                <#--<label for="exampleInputEmail1">商品标记(默认为0)</label>-->
                    <input type="hidden" class="form-control" id="exampleInputEmail1" name="flag" value="0"
                           placeholder="0">

                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button onclick="bus.updateCommodity(this)" id="add" type="button" class="btn btn-primary">提交
                    </button>
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
            this.upload()
        }

        Bus.prototype.upload = function () {//上传图片
            var self = this;
            $(".bus-upload").each(function (i, v) {
                $(v).children("img").click(function (e) {
                    var img = this;
                    var file = $("<input type='file' accept='image/gif,image/png,image/jpeg'/>");
                    file.click().change(function (e) {
                        self.sendFile(
                                file[0].files[0],
                                function (data) {
                                    //回调
                                    var json = JSON.parse(data);
                                    img.src = "/upload/" + json.content;
                                    $(v).children("input:hidden").val(json.content)
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

        Bus.prototype.mulit_del = function (node) {//删除
            var ids = new Array();
            var object=event.srcElement;
            if(object.className=="button border-red"){
                var obj = document.getElementsByName("choose");
                if (obj == 0) {
                    alert("请至少选择一项!");
                } else if (confirm("确定删除所选项目?")) {
                    for (var i in obj) {
                        if (obj[i].checked) {
                            ids.push(obj[i].value)
                        }
                    }
                }
            }else if(object.className=="fa fa-times"){
                var tr1 = node.parentNode.parentNode;
                if(confirm("确定删除所选项目?")){
                    ids.push(tr1.cells[1].innerText);
                }
            }
            $.ajax({
                url: "/commodity/del",
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
                        window.location.reload();
                    }
                }
            })
            window.location.reload();
        }

        Bus.prototype.getCommodityBuyId = function (node) {//通过ID获取商品详情
            var img = node;
            var tr1 = node.parentNode.parentNode;//获取id
            var id=tr1.cells[1].innerText;
            $.ajax({
                url: "/commodity/detail?id="+id,
                type: "GET",
                contentType: "application/json;charset=utf-8",
                success: function (data) {
                    if (data!=null||data!="") {
                        var itemImg=document.getElementById("itemImg");
                        var img = document.getElementById("img");
                        console.log(data);
                        $("[name=id]").val(data.id);
                        $("[name=name]").val(data.name);
                        $("[name=depict]").val(data.depict);
                        $("[name=price]").val(data.price);
                        $("[name=amount]").val(data.amount);
                        $("[name=itemImg]").val(data.itemImg);
                        console.log(data.itemImg);
                        itemImg.src ="/upload/"+data.itemImg;
                        $("[name=img]").val(data.img);
                        img.src = "/upload/"+data.img;
                        $("[name=point]").val(data.point);
                        $("[name=couponType]").val(data.couponType);
                        $("[name=typeId]").val(data.typeId);
                        $("[name=flag]").val(data.flag);
                    }else {
                        alert("数据获取失败!");
                    }

                }
            })

        };

        Bus.prototype.updateCommodity = function () {
            var d = {};
            var url = "";
            if(event.srcElement.id=="add"){
                url="/commodity/add";
                var t = $('#formAdd').serializeArray();
                $.each(t, function () {
                    d[this.name] = this.value;
                });
            }else if(event.srcElement.id=="update"){
                url="/commodity/update";
                var t = $('#formUpdate').serializeArray();
                $.each(t, function () {
                    console.log("bbb");
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
        };
        return Bus;
    })());
    window.bus = new Bus();
</script>
</@layoutFooter>
