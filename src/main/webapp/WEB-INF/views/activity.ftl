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
                <tr>
                    <th>活动ID</th>
                    <th>活动名称</th>
                    <th>活动简介</th>
                    <th>报名人数限额</th>
                    <th>活动价格</th>
                    <th>活动开始时间</th>
                    <th>活动结束时间</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                    <#list activityList as oneActivity>
                    <tr>
                        <td>${oneActivity.id}</td>
                        <td>${oneActivity.title}</td>
                        <td>${oneActivity.detail}</td>
                        <td>${oneActivity.amount}</td>
                        <td>${oneActivity.price}</td>
                        <td>${oneActivity.startime?string('yyyy.MM.dd HH:mm:ss')}</td>
                        <td>${oneActivity.endtime?string('yyyy.MM.dd HH:mm:ss')}</td>
                        <td><a href="http://www.baidu.com"><i class="fa fa-bars"></i></a>
                            <a href="http://www.baidu.com"><i class="fa fa-times"></i></a></td>
                    </tr>
                    </#list>
                </tbody>
            </table>
        </div>
    </div><!-- ./smart-widget-inner -->
</div><!-- ./smart-widget -->
<form role="form" enctype="multipart/form-data" action="/activity/addactivity" method="post">
<div class="modal fade" id="myModal">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" ><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
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
                    <label for="exampleInputPassword1">报名人数限额</label>
                    <input type="text" class="form-control" id="text2" name="amount">
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
<!-- Parsley -->
</@layoutFooter>