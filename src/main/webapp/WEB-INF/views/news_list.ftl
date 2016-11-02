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
         新闻中心
        <button class="btn btn-success btn-xs smart-widget-option" data-toggle="modal" data-target="#myModal">添加新闻</button>
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
                    <th>新闻ID</th>
                    <th>新闻标题</th>
                    <th>新闻内容</th>
                    <th>新闻类型</th>
                    <th>作者</th>
                    <th>发布时间</th>
                    <th>操作</th>

                </tr>
                </thead>
                <tbody>
                    <#list newsList as oneNew>
                    <tr class="active">
                        <td class="text-center">
                            <div class="custom-checkbox">
                                <input type="checkbox" id="chk${oneNew.id}" class="inbox-check">
                                <label for="chk${oneNew.id}"></label>
                            </div>
                        </td>
                        <td>${oneNew.id}</td>
                        <td>${oneNew.title}</td>
                        <td>${oneNew.content}</td>
                        <td>${oneNew.type}</td>
                        <td>${oneNew.author}</td>
                        <td>${oneNew.time?string('yyyy.MM.dd HH:mm:ss')}</td>
                        <td>
                            <a href=""
                               data-toggle="modal"
                               data-target="#myModal2">
                                <i class="fa fa-bars"></i>
                            </a>      <!--修改活动 -->
                            <a href="/news/list/?id=${oneNew.id}" >
                                <i class="fa fa-times"></i>
                            </a>
                        </td><!--删除活动 -->
                    </tr>
                    </#list>
                </tbody>

            </table>
            <ul class="pagination">
                <li><a href="/news/list?page=${pagePojo.homePage}">首页</a></li>
                <li><a href="/news/list?page=${pagePojo.getPreviousPage()}">上一页</a></li>
                <li><a href="#">当前第${pagePojo.getCurrentPage()+1}页</a></li>
                <li><a href="#">共${pagePojo.countPage}页</a></li>
                <li><a href="#">总${pagePojo.amount}条数据</a></li>
                <li><a href="/news/list?page=${pagePojo.getNextPage()}">下一页</a></li>
                <li><a href="/news/list?page=${pagePojo.trailerPage-1}">尾页</a></li>
            </ul>
        </div>
    </div><!-- ./smart-widget-inner -->
</div><!-- ./smart-widget -->
<form role="form" enctype="multipart/form-data" action="/news/addnews" method="post">
    <div class="modal fade" id="myModal">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" ><span class="sr-only">Close</span></button>
                    <h4 class="modal-title">添加新闻</h4>
                </div>

                <div class="modal-body">
                    <div class="form-group">
                        <label for="exampleInputEmail1">新闻标题</label>
                        <input type="text" class="form-control" id="text1" name="title">
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">新闻内容</label>
                        <input type="text" class="form-control" id="text2" name="content">
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">新闻类型</label>
                        <input type="text" class="form-control" id="text2" name="type">
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">作者</label>
                        <input type="text" class="form-control" id="text3" name="author" >
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">发布时间</label>
                        <input type="date" class="form-control" id="text4" name="time">
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
</@layoutFooter>