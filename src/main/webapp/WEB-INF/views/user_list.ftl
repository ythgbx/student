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
        用户列表
    </div>
    <div class="smart-widget-inner">
        <div class="smart-widget-body">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th><input type="checkbox" name="全选""></th>
                    <th>姓名</th>
                    <th>电话</th>
                    <th>积分</th>
                    <th>用户类型</th>
                </tr>
                </thead>
                <tbody>
                    <#list userList as oneUser>
                    <tr>
                        <th><input type="checkbox" name="${oneUser.id} value="1""></th>
                        <td>${oneUser.name}</td>
                        <td>${oneUser.phone}</td>
                        <td>${oneUser.points}</td>
                        <#if oneUser.type==1>
                            <td>管理员</td>
                        <#else>
                            <td>用户</td>
                        </#if>
                    </tr>
                    </#list>
                </tbody>
                <tbody>
                <tr>
                    <ul class="pagination">
                        <li><a href="/user/list?page=${pagePojo.homePage}">首页</a></li>
                        <li><a href="/user/list?page=${pagePojo.getPreviousPage()}">上一页</a></li>
                        <li><a href="#">当前第${pagePojo.getCurrentPage()+1}页</a></li>
                        <li><a href="#">共${pagePojo.countPage}页</a></li>
                        <li><a href="#">总${pagePojo.amount}条数据</a></li>
                        <li><a href="/user/list?page=${pagePojo.getNextPage()}">下一页</a></li>
                        <li><a href="/user/list?page=${pagePojo.trailerPage-1}">尾页</a></li>
                    </ul>
                </tr>
                </tbody>
            </table>
        </div>
    </div><!-- ./smart-widget-inner -->
</div><!-- ./smart-widget -->

</@layoutBody>

<@layoutFooter></@layoutFooter>