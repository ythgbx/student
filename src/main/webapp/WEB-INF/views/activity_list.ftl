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
        活动中心
        <button class="btn btn-success btn-xs smart-widget-option" data-toggle="modal" data-target="#myModal">添加活动</button>
    </div>

    <div class="smart-widget-inner">
        <div class="smart-widget-body">

            <table class="table table-hover">
                <thead>
                <tr class="active">
                    <th class="text-center">
                        <div class="custom-checkbox">
                           <input class="inbox-check" id="chkAll" type="checkbox">
                            <label for="chkAll"></label>
                        </div>
                    </th>
                    <th>活动ID</th>
                    <th>活动名称</th>
                    <th>活动简介</th>
                    <th>当前报名人数</th>
                    <th>活动价格</th>
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
                                <input type="checkbox" id="chk${oneActivity.id}" class="inbox-check">
                                <label for="chk${oneActivity.id}"></label>
                            </div>
                        </td>
                        <td>${oneActivity.id}</td>
                        <td>${oneActivity.title}</td>
                        <td>${oneActivity.detail}</td>
                        <td>${oneActivity.numberOfPeople}</td>
                        <td>${oneActivity.price}</td>
                        <td>${oneActivity.startime?string('yyyy.MM.dd HH:mm:ss')}</td>
                        <td>${oneActivity.endtime?string('yyyy.MM.dd HH:mm:ss')}</td>
                        <td>
                            <a href="javascript:doPost('/activity/updateactivity', {'id':'${oneActivity.id}'})"
                               data-toggle="modal"
                               data-target="#myModal2">
                                <i class="fa fa-bars"></i>
                            </a>      <!--修改活动 -->
                            <a href="/activity/deleteactivity?id=${oneActivity.id}" >
                                <i class="fa fa-times"></i>
                            </a>
                        </td><!--删除活动 -->
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
        <div class=" inline-block vertical-middle m-right-xs ">Page 1 of 8 </div>
        <ul class="pagination vertical-middle">
            <li ><a href="#"><i class="fa fa-step-backward"></i></a></li>
            <li ><a href="#"><i class="fa fa-caret-left large"></i></a></li>
            <li ><a href="#"><i class="fa fa-caret-right large"></i></a></li>
            <li "><a href="#"><i class="fa fa-step-forward"></i></a></li>
        </ul>
    </div>
</div><!-- ./pagination-row -->
<form role="form" enctype="multipart/form-data" action="/activity/addactivity" method="post">
<div class="modal fade" id="myModal">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" ><span class="sr-only">Close</span></button>
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
                        <input type="text" class="form-control" id="text3" name="price" >
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">活动开始时间</label>
                        <input type="date" class="form-control" id="text4" name="startime">
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">活动结束时间</label>
                        <input type="date" class="form-control" id="text5" name="endtime">
                    </div>
                   <!--<div class="form-group">
                        <label for="exampleInputFile">图片上传</label>
                        <input type="file" id="file1" name="image">
                    </div>-->

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="submit" class="btn btn-primary" id="submit">提交</button>
            </div>

        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
</form>

<form role="form" enctype="multipart/form-data" action="/activity/updateactivity" method="post">
    <div class="modal fade" id="myModal2">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" ><span class="sr-only">Close</span></button>
                    <h4 class="modal-title">修改活动</h4>
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
                        <input type="text" class="form-control" id="text3" name="price" >
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">活动开始时间</label>
                        <input type="date" class="form-control" id="text4" name="startime">
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">活动结束时间</label>
                        <input type="date" class="form-control" id="text5" name="endtime">
                    </div>
                    <!--<div class="form-group">
                         <label for="exampleInputFile">图片上传</label>
                         <input type="file" id="file1" name="image">
                     </div>-->

                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="submit" class="btn btn-primary" id="submit">提交</button>
                </div>

            </div><!-- /.modal-content -->
        </div><!-- /.modal-dialog -->
    </div><!-- /.modal -->
</form>
</@layoutBody>

<@layoutFooter>
<script>
    $(function()	{
        $('.inbox-check').click(function()	{
            var activeRow = $(this).parent().parent().parent();

            activeRow.toggleClass('active');
        });


        $('#inboxCollapse').click(function()	{
            $('.inbox-menu-inner').slideToggle();
        });

        $('#chkAll').click(function()	{
            if($(this).prop('checked'))	{
                $('.inbox-check').prop('checked',true);
                $('.inbox-check').parent().parent().parent().addClass('active');
            }
            else	{
                $('.inbox-check').prop('checked',false);
                $('.inbox-check').parent().parent().parent().removeClass('active');
            }
        });

        $(window).resize(function() {
            if (Modernizr.mq('(min-width: 980px)')) {
                $('.inbox-menu ul').show();
            }
        });
    });
</script>
<!-- Parsley -->
</@layoutFooter>