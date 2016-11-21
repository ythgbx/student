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
        订单详情
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
                    <th>用户ID</th>
                    <th>商品ID</th>
                    <th>订单号</th>
                    <th>购买数量</th>
                    <th>购买时间</th>
                </tr>
                </thead>
                <tbody>
                    <#list orders as order>
                        <tr class="active">
                            <td class="text-center">
                                <div class="custom-checkbox">
                                    <input type="checkbox" name="choose" id="chk${order.userId}" class="inbox-check" value="${order.userId}">
                                    <label for="chk${order.userId}"></label>
                                </div>
                            </td>
                            <#--<td>${order_index+1}</td>-->
                            <td>${order.userId}</td>
                            <td>${order.id}</td>
                            <td>${order.tradeNo}</td>
                            <td>${order.amount}</td>
                            <td>${order.payTime?string('yyyy-MM-dd HH:mm:ss')}</td>
                        </tr>
                    </#list>
                </tbody>
                <tbody>
                <tr>
                    <ul class="pagination">
                        <li><a href="/commodity/orderList?page=${pagePojo.homePage}">首页</a></li>
                        <li><a href="/commodity/orderList?page=${pagePojo.getPreviousPage()}">上一页</a></li>
                        <li><a href="#">当前第${pagePojo.getCurrentPage()}页</a></li>
                        <li><a href="#">共${pagePojo.countPage}页</a></li>
                        <li><a href="#">总${pagePojo.amount}条数据</a></li>
                        <li><a href="/commodity/orderList?page=${pagePojo.getNextPage()}">下一页</a></li>
                        <li><a href="/commodity/orderList?page=${pagePojo.trailerPage}">尾页</a></li>
                    </ul>
                </tr>
                </tbody>
            </table>
        </div>
    </div><!-- ./smart-widget-inner -->
</div><!-- ./smart-widget -->

</@layoutBody>

<@layoutFooter>
<script type="text/javascript">

    $(function(){//全选
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


