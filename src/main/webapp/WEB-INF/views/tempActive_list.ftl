<#include "common/_layout.ftl">
<@layoutHead title="网站"></@layoutHead>

<@layoutBody>
<!-- 这是nested的内容-->

<ul class="breadcrumb">
    <li><span class="primary-font"><i class="icon-home"></i></span><a href="#">首页</a></li>
    <li>管理中心</li>
    <li>活动管理</li>
</ul>
<div class="smart-widget">
    <div class="smart-widget-header">
        活动管理
        <div class="search-input pull-right">
            <input type="text" class="form-control input-sm inline-block" id="sea">
            <a class="input-icon text-normal" onclick="bus.search()">
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
                    <th>用户ID</th>
                    <th>姓名</th>
                    <th>联系方式</th>
                    <th>学校</th>
                    <th>院系</th>
                    <th>活动名称</th>
                    <#--<th>操作</th>-->
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
                        <td>${oneUser.id}</td>
                        <td>${oneUser.name}</td>
                        <td>${oneUser.phone}</td>
                        <td>${oneUser.school}</td>
                        <td>${oneUser.institute}</td>
                        <td>${oneUser.source}</td>
                        <#--<td><input type="button" data-toggle="modal" data-target="#Recharge" id="" value="充值" onclick="bus.getUserBuyId(this)"/></td>-->
                    </tr>
                    </#list>
                <p>活动报名总人数:${pagePojo.amount}人</p>
                </tbody>
                <tbody>
                <tr>
                    <ul class="pagination">
                        <li><a href="/user/activeAll?page=${pagePojo.homePage}">首页</a></li>
                        <li><a href="/user/activeAll?page=${pagePojo.getPreviousPage()}">上一页</a></li>
                        <li><a href="#">当前第${pagePojo.getCurrentPage()}页</a></li>
                        <li><a href="#">共${pagePojo.countPage}页</a></li>
                        <li><a href="#">总${pagePojo.amount}条数据</a></li>
                        <li><a href="/user/activeAll?page=${pagePojo.getNextPage()}">下一页</a></li>
                        <li><a href="/user/activeAll?page=${pagePojo.trailerPage}">尾页</a></li>
                    </ul>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>

<#--<!-- 模态框（Modal） 充值&ndash;&gt;-->
<#--<div class="modal fade" id="Recharge" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">-->
    <#--<div class="modal-dialog">-->
        <#--<div class="modal-content">-->
            <#--<form id="fromRecharge"  enctype="multipart/form-data" method="post">-->
                <#--<div class="modal-header">-->
                    <#--<button type="button" class="close" data-dismiss="modal" aria-hidden="true">-->
                    <#--&lt;#&ndash;&times;&ndash;&gt;-->
                    <#--</button>-->
                    <#--<h4 class="modal-title" id="myModalLabel">-->
                        <#--积分充值-->
                    <#--</h4>-->
                <#--</div>-->
                <#--<div class="modal-body">-->

                    <#--<label for="exampleInputEmail1">确认充值账号ID</label>-->
                    <#--<input type="text" class="form-control" id="exampleInputEmail1" name="id">-->
                    <#--<label for="exampleInputEmail1">充值额度</label>-->
                    <#--<input type="text" class="form-control" id="exampleInputEmail1" name="addNum"-->
                           <#--placeholder="请输入充值积分">-->

                <#--</div>-->
                <#--<div class="modal-footer">-->
                    <#--<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>-->
                    <#--<button onclick="bus.addPoint()" type="button" class="btn btn-primary">充值</button>-->
                <#--</div>-->
            <#--</form>-->
        <#--</div><!-- /.modal-content &ndash;&gt;-->
    <#--</div><!-- /.modal &ndash;&gt;-->
<#--</div>-->

</@layoutBody>

<@layoutFooter>
<script type="text/javascript">
    var Bus = ((function () {
        function Bus() {
        }
        Bus.prototype.search = function () {
            var d = document.getElementById("sea");
            window.location.href="/user/activeAll?source="+d.value;
            console.log(d.value)
        };
        return Bus;
    })());
    window.bus = new Bus();
</script>

</@layoutFooter>