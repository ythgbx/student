<#include "common/_layout.ftl">
<@layoutHead title="网站"></@layoutHead>

<@layoutBody>
<!-- 这是nested的内容-->

<table class="ui table">
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

</@layoutBody>

<@layoutFooter></@layoutFooter>