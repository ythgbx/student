<#include "common/_layout.ftl">
<@layoutHead title="网站"></@layoutHead>
<@layoutBody>
<!-- 这是nested的内容-->

<ul class="breadcrumb">
    <li><span class="primary-font"><i class="icon-home"></i></span><a href="#">首页</a></li>
    <li>管理中心</li>
    <li>用户乘车记录管理</li>
</ul>
<div class="smart-widget">
    <div class="smart-widget-header">
        用户列表
        <div class="search-input pull-right">
            <input type="text" class="form-control input-sm inline-block" id="sea">
            <a class="input-icon text-normal" onclick="bus.searchTicket()">
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
                    <th>线路ID</th>
                    <th>起点站</th>
                    <th>终点站</th>
                    <th>乘车时间</th>
                    <th>消费</th>
                    <#--<th>操作</th>-->
                </tr>
                </thead>
                <tbody>
                    <#list resultTicketList.tickets as ticket>
                    <tr class="active">
                    <#--<td class="text-center">-->
                    <#--<div class="custom-checkbox">-->
                    <#--<input type="checkbox" name="choose" id="chk${oneUser.id}" class="inbox-check" value="${oneUser.id}">-->
                    <#--<label for="chk${oneUser.id}"></label>-->
                    <#--</div>-->
                    <#--</td>-->
                        <#--<td>${ticket_index+1}</td>-->
                        <td>${ticket.id}</td>
                        <td>${ticket.start_station}</td>
                        <td>${ticket.end_station}</td>
                        <td id="time">${ticket.time?number_to_date?string("YYYY-MM-dd HH:mm:ss")}</td>
                        <td>-${ticket.price}</td>
                        <#--<#if oneUser.type==1>-->
                            <#--<td>管理员</td>-->
                        <#--<#else>-->
                            <#--<td>用户</td>-->
                        <#--</#if>-->
                        <#--<td><input type="button" data-toggle="modal" data-target="#Recharge" id="" value="充值" onclick="bus.getUserBuyId(this)"/></td>-->
                    </tr>
                    </#list>
                </tbody>
                <tbody>
                <tr>
                    <ul class="pagination">
                        <li><a href="/ticket/userList?page=${pagePojo.homePage}">首页</a></li>
                        <li><a href="/ticket/userList?page=${pagePojo.getPreviousPage()}">上一页</a></li>
                        <li><a href="#">当前第${pagePojo.getCurrentPage()}页</a></li>
                        <li><a href="#">共${pagePojo.countPage}页</a></li>
                        <li><a href="#">总${pagePojo.amount}条数据</a></li>
                        <li><a href="/ticket/userList?page=${pagePojo.getNextPage()}">下一页</a></li>
                        <li><a href="/ticket/userList?page=${pagePojo.trailerPage}">尾页</a></li>
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
                        用户乘车记录
                    </h4>
                </div>
                <div class="modal-body">

                    <label for="exampleInputEmail1">用户ID</label>
                    <input type="text" class="form-control" id="exampleInputEmail1" name="id">
                    <label for="exampleInputEmail1">起点站</label>
                    <input type="text" class="form-control" id="exampleInputEmail1" name="start_station">
                    <label for="exampleInputEmail1">终点站</label>
                    <input type="text" class="form-control" id="exampleInputEmail1" name="end_station">
                    <label for="exampleInputEmail1">乘车时间</label>
                    <input type="text" class="form-control" id="exampleInputEmail1" name="time">
                    <label for="exampleInputEmail1">消费</label>
                    <input type="text" class="form-control" id="exampleInputEmail1" name="price">

                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                    </button>
                    <button type="button" class="btn btn-primary btn-lg " onclick="bus.addPoint()">充值</button>
                </div>
            </form>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
</@layoutBody>

<@layoutFooter>
<script type="text/javascript">
    var Bus = ((function () {// 根据用户id搜索乘车记录
        function Bus() {
        }
        Bus.prototype.searchTicket = function () {
            var d = document.getElementById("sea");
            window.location.href="/ticket/userList?id="+d.value;
        };


        return Bus;
    })());
    window.bus = new Bus();
</script>
</@layoutFooter>