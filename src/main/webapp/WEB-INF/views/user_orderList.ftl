<#include "common/_layout.ftl">
<@layoutHead title="网站"></@layoutHead>

<@layoutBody>
<!-- 这是nested的内容-->

<ul class="breadcrumb">
    <li><span class="primary-font"><i class="icon-home"></i></span><a href="index.html"> Home</a></li>
    <li>Table</li>
    <li>Static Table</li>
</ul>
<div class="smart-widget">
    <div class="smart-widget-header">
        订单详情
    </div>
    <div class="smart-widget-inner">
        <div class="smart-widget-body">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th><input type="checkbox" name="checkAll">全选/取消反选</th>
                    <th>用户ID</th>
                    <th>商品ID</th>
                    <th>订单号</th>
                    <th>购买数量</th>
                    <th>购买时间</th>
                </tr>
                </thead>
                <tbody>
                    <#--<tr><button type="button"  class="button border-green" id="checkall"><span class="icon-check"></span> 全选</button>-->
                        <#--<button type="submit" class="button border-red"><span class="icon-trash-o"></span> 批量删除</button></tr>-->
                    <#list commodityOrders as commodityOrder>
                    <tr>
                        <th><input type="checkbox" name="${commodityOrder.userId} value="1""></th>
                        <td>${commodityOrder.userId}</td>
                        <td>${commodityOrder.commodityId}</td>
                        <td>${commodityOrder.tradeNo}</td>
                    <#--<#if Commodity.typeId==1>-->
                    <#--<td>积分</td>-->
                    <#--<#else>-->
                    <#--<td>优惠卡</td>-->
                    <#--</#if>-->
                        <td>${commodityOrder.amount}</td>

                        <td>${commodityOrder.payTime?string('yyyy.MM.dd HH:mm:ss')}</td>
                    <#--<td><a href="#"><button type="button" value="管理">管理</button> </a></td>-->
                    </tr>
                    </#list>
                </tbody>
                <tbody>
                <tr>
                    <ul class="pagination">
                        <li><a href="/commodity/orderList?page=${pagePojo.homePage}">首页</a></li>
                        <li><a href="/commodity/orderList?page=${pagePojo.getPreviousPage()}">上一页</a></li>
                        <li><a href="#">当前第${pagePojo.getCurrentPage()+1}页</a></li>
                        <li><a href="#">共${pagePojo.countPage}页</a></li>
                        <li><a href="#">总${pagePojo.amount}条数据</a></li>
                        <li><a href="/commodity/orderList?page=${pagePojo.getNextPage()}">下一页</a></li>
                        <li><a href="/commodity/orderList?page=${pagePojo.trailerPage-1}">尾页</a></li>
                    </ul>
                </tr>
                </tbody>
            </table>
        </div>
    </div><!-- ./smart-widget-inner -->
</div><!-- ./smart-widget -->

</@layoutBody>

<@layoutFooter></@layoutFooter>


