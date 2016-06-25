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
        Hover rows
    </div>
    <div class="smart-widget-inner">
        <div class="smart-widget-body">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>姓名</th>
                    <th>电话</th>
                    <th>积分</th>
                    <th>用户类型</th>
                </tr>
                </thead>
                <tbody>
                    <#list userList as oneUser>
                    <tr>
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
            </table>
        </div>
    </div><!-- ./smart-widget-inner -->
</div><!-- ./smart-widget -->

</@layoutBody>

<@layoutFooter></@layoutFooter>