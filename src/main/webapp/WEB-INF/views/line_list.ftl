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
        <button type="button" onclick="mulit_del()" class="button border-red"><span class="icon-trash-o"></span> 批量删除
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
                        <td>${oneLine.id}</td>
                        <td>${oneLine.name}</td>
                        <td >${oneLine.start}</td>
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
                                <i class="fa fa-times"></i>
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
<div class="pagination-row clearfix">
    <div class="pull-left vertical-middle hidden-xs">112 messages</div>
    <div class="pull-right pull-left-sm">
        <div class=" inline-block vertical-middle m-right-xs ">Page 1 of 8</div>
        <ul class="pagination vertical-middle">
            <li><a href="#"><i class="fa fa-step-backward"></i></a></li>
            <li><a href="#"><i class="fa fa-caret-left large"></i></a></li>
            <li><a href="#"><i class="fa fa-caret-right large"></i></a></li>
            <li
            "><a href="#"><i class="fa fa-step-forward"></i></a></li>
        </ul>
    </div>
</div><!-- ./pagination-row -->
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
        if (object.className == "button border-red") {
            var obj = document.getElementsByName("choose");
            var ids = new Array();
            if (obj == 0) {
                alert("请至少选择一项!");
            } else if (confirm("确定删除所选项目?")) {
                for (var i in obj) {
                    if (obj[i].checked) {
                        ids.push(obj[i].value)
                    }
                }
            }
        } else if (object.className == "fa fa-times") {
            var tr1 = node.parentNode.parentNode;
            if (confirm("确定删除所选项目?")) {
                ids.push(tr1.cells[1].innerText);
            }
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
<script>
    function operate() {
        var d = {};
        var url = "";
        if(event.srcElement.id=="add"){
            url="/line/addline";
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