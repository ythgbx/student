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
    <div class="smart-widget-header">
        Hover rows

        <button class="btn btn-success btn-xs smart-widget-option" data-toggle="modal" data-target="#addCommodity" >添加商品</button>
        &nbsp;&nbsp;
        <button class="btn btn-success btn-xs smart-widget-option" data-toggle="modal" data-target="#sakura" >修改</button>
    </div>
    <div class="smart-widget-inner">
        <div class="smart-widget-body">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th><input type="checkbox" name="全选"></th>
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
                    <tr>
                        <th><input type="checkbox" name="${Commodity.id} value="1""></th>
                        <td>${Commodity.id}</td>
                        <td>${Commodity.name}</td>
                        <#if Commodity.typeId==1>
                            <td>积分</td>
                        <#else>
                            <td>优惠卡</td>
                        </#if>
                        <td>${Commodity.price}</td>
                        <td>${Commodity.amount}</td>
                        <td><a href="#"><button type="button" value="管理">管理</button> </a></td>
                    </tr>
                    </#list>
                </tbody>
                <tbody>
                    <tr>
                        <ul class="pagination">
                            <li><a href="/commodity/list?page=${pagePojo.homePage}">首页</a></li>
                            <li><a href="/commodity/list?page=${pagePojo.getPreviousPage()}">上一页</a></li>
                            <li><a href="#">当前第${pagePojo.getCurrentPage()+1}页</a></li>
                            <li><a href="#">共${pagePojo.countPage}页</a></li>
                            <li><a href="#">总${pagePojo.amount}条数据</a></li>
                            <li><a href="/commodity/list?page=${pagePojo.getNextPage()}">下一页</a></li>
                            <li><a href="/commodity/list?page=${pagePojo.trailerPage-1}">尾页</a></li>
                        </ul>
                    </tr>
                </tbody>
            </table>
        </div>
    </div><!-- ./smart-widget-inner -->
</div><!-- ./smart-widget -->




<!-- 模态框（Modal） -->
<div class="modal fade" id="addCommodity" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <h4 class="modal-title" id="myModalLabel">
                    添加商品
                </h4>
            </div>
            <div class="modal-body">
                <form role="form">
                    <label for="exampleInputEmail1">商品名称</label>
                    <input type="text" class="form-control"  id="exampleInputEmail1" name="name" placeholder="请输入商品名称">

                    <label for="exampleInputEmail1">商品描述</label>
                    <input type="text" class="form-control" id="exampleInputEmail1" name="depict" placeholder="请对该商品进行描述">

                    <label for="exampleInputEmail1">商品价格</label>
                    <input type="text" class="form-control" id="exampleInputEmail1" name="price" placeholder="请输入该商品的价格">

                    <label for="exampleInputEmail1">商品数量</label>
                    <input type="text" class="form-control" id="exampleInputEmail1" placeholder="请输入该商品的数量">

                    <label for="exampleInputEmail1">商品备注图片</label>
                    <input type="file" class="form-control" id="exampleInputEmail1" placeholder="添加图片">

                    <label for="exampleInputEmail1">商品详情图片</label>
                    <input type="file" class="form-control" id="exampleInputEmail1" placeholder="添加图片">

                    <label for="exampleInputEmail1">商品积分</label>
                    <input type="text" class="form-control" id="exampleInputEmail1" placeholder="请输入该商品对应积分">

                    <label for="exampleInputEmail1">商品积分</label>
                    <input type="text" class="form-control" id="exampleInputEmail1" placeholder="请输入该商品类型">

                    <label for="exampleInputEmail1">商品积分</label>
                    <input type="text" class="form-control" id="exampleInputEmail1" placeholder="该商品是积分还是会员">

                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                </button>
                <button type="button" class="btn btn-primary">
                    提交更改
                </button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>



<#--<div class="modal fade" id="sakura" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">-->
    <#--<div class="modal-dialog">-->
        <#--<div class="modal-content">-->
            <#--<div class="modal-header">-->
                <#--<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>-->
                <#--<h4 class="modal-title" id="myModalLabel">添加商品</h4>-->
            <#--</div>-->
            <#--<div class="modal-body">-->
                <#--<form role="form">-->
                    <#--<label for="exampleInputEmail1">商品名称</label>-->
                    <#--<input type="email" class="form-control" id="exampleInputEmail1" name="" placeholder="请输入商品名称">-->
                    <#--<label for="exampleInputEmail1">商品金额</label>-->
                    <#--<input type="email" class="form-control" id="exampleInputEmail1" placeholder="Enter email">-->
                    <#--<label for="exampleInputEmail1">商品描述</label>-->
                    <#--<input type="email" class="form-control" id="exampleInputEmail1" placeholder="Enter email">-->
                    <#--<button type="submit" class="btn btn-default">Submit</button>-->
                <#--</form>-->
            <#--</div>-->
            <#--<div class="modal-footer">-->
                <#--<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>-->
                <#--<button type="button" class="btn btn-primary">添加</button>-->
            <#--</div>-->
        <#--</div>-->
    <#--</div>-->
<#--</div>-->
</@layoutBody>

<@layoutFooter></@layoutFooter>